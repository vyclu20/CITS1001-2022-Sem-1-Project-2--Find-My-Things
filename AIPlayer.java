
/**
 * Implments an AI player to place pieces randomly on the board at the start of every game
 *
 * @author Ms Caitlin Woods
 * @version April 2022
 * <p>
 */

import java.util.*;
import java.awt.Color;

public class AIPlayer {

    public Item[] itemBank; // an array representing the items that the AIPlayer has to choose from when placing items on the board.
    public int numberOfItems; // the number of items that the AIPlayer should select to hide on the board
    public Board board; // a board for the AIPlayer to hide items on.

    /**
     * Constructor for objects of class AIplayer.
     * Initialises the itemBank array with five default items that can be placed on
     * THIS HAS BEEN PROVIDED FOR YOU.
     * PLEASE DO NOT MODIFY OR CHANGE ANY CODE IN THIS CONSTRUCTOR.
     */
    public AIPlayer(Board board, int numberOfItems) {
        this.board = board;
        this.numberOfItems = numberOfItems;
        itemBank = new Item[]{
                new Item("phone", new int[][]{{1, 0}, {1, 0}}),
                new Item("keys", new int[][]{{0, 1, 0}, {1, 1, 1}, {0, 0, 0}}),
                new Item("shoe", new int[][]{{1, 0, 0}, {1, 0, 0}, {1, 1, 0}}),
                new Item("walking stick", new int[][]{{1, 0, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 0}}),
                new Item("book", new int[][]{{1, 1, 0}, {1, 1, 0}, {1, 1, 0}}),
        };
    }

    /**
     * Returns a UNIQUE numberOfItems from the itemBank array. For example, if
     * numberOfItems is 2, then two items should be true.
     * These items should be selected at random and should be unique (no items can
     * be the same).
     *
     * @param numberOfItems the number of items to be selected
     * @return an array of items (randomly selected from the itemBank and unique)
     */
    public Item[] selectItems(int numberOfItems) {
        // TODO 28
        ArrayList<Item> collect = new ArrayList<>();

        while (collect.size() < numberOfItems) {
            // Use random to get the random number.
            // the argument for nextInt is the upper bound.
            int randomNumber = new Random().nextInt(itemBank.length);

            // add item to array list if it does not exit.
            if (!collect.contains(itemBank[randomNumber])) {
                collect.add(itemBank[randomNumber]);
            }
        }
        return collect.toArray(new Item[0]);

    }

    /**
     * Randomly select a location for the item to be placed. No validation
     * needs to be performed on the selected location at this point but the location should be
     * within the size of the board.
     *
     * @return an int[] representing a location where (loc[0] = x location and
     * loc[1] = y location)
     */
    public int[] selectLocation() {
        // TODO 29
        Random random = new Random();
        int[] location = new int[2];
        location[0] = random.nextInt(this.board.getBoardSize());
        location[1] = random.nextInt(this.board.getBoardSize());
        return location;
    }

    /**
     * Randomly select an item orientation value in degrees (i.e. 0, 90, 180 or 270). Return an
     * integer representing an item's orientation.
     *
     * @return an integer (either 0, 90, 180 or 270).
     */
    public int selectOrientation() {

        // TODO 30
        return new Random().nextInt(4) * 90;
    }

    /**
     * Test if a chosen location (int[]) and orientation (int) is valid for a given item (i.e. the item
     * fits at that location on the board)
     *
     * @param location: the location to be tested (hint: location is represented in the same way
     *                  as in the selectLocation method)
     *                  (hint: you have to rotate the array according to "orr" before testing the location)
     * @param item:     the item to find a place for.
     * @return true if the item fits at the location, false otherwise
     */
    public Boolean tryItemLocation(Item item, int[] location, int orr) {
        // TODO 31
        int boardSize = this.board.getBoardSize();
        int itemSize = item.getShape().length;

        // rotate the item
        for (int i = 0; i < orr / 90; i++) {
            item.rotate90Degrees();
        }

        // check if the item is inside the board
        if (boardSize - location[0] - itemSize < 0 || boardSize - location[1] - itemSize < 0) {
            return false;
        }

        // check is the location is vacant.
        int[][] shape = item.getShape();

        boolean valid = false;
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[0].length; j++) {
                if (shape[i][j] == 1) {
                    if (this.board.isVacant(location[0] + i, location[1] + j)) {
                        valid = true;
                    } else {
                        //return false if there is any location is not vacant.
                        return false;
                    }

                }
            }
        }
        return valid;


    }

    /**
     * Place an item at the location (represented by an int[]) on the board.
     * (hint: the first element of the location array is the x coordinate, and the second element is the y coodinate).
     * The item is placed by setting each piece where the item's value is 1 to a LOSTITEM state.
     * (e.g. for a phone where the shape is [[1, 0], [1, 0]], the output shoud be [[LOSTITEM, VACANT][LOSTITEM, VACAMNT]]
     *
     * @param item:     the item to be placed
     * @param location: the location on the board where first piece of the item
     *                  (i.e. the 0,0 coordinate of the item's shape) should be placed.
     */
    public void setLostPieces(Item item, int[] location) {
        // TODO 32
        int[][] shape = item.getShape();
        for (int x = 0; x < shape.length; x++) {
            for (int y = 0; y < shape[0].length; y++) {
                if (shape[x][y] == 1) {
                    this.board.setLostItem(location[0] + y, location[1] + x);
                }
            }
        }
    }

    /**
     * Begin a game of 'Find My Things'. There are some steps to do here. They are:
     * 1) Select a numberOfItems from the itemBank
     * 2) Select a starting location for each item
     * 3) Keep trying to select a valid location for your items until you find a
     * valid space.
     * 4) Set the location of each of the selected items (hint: use a method from the Item class)
     * 5) Set the lost pieces on the board for each of the selected items
     * (hint: you have already written helper methods to do most of these things)
     *
     * @return an array of selectedItems
     */
    public Item[] startGame() {
        // TODO 33
        //1
        Item[] items = selectItems(numberOfItems);

        //2, 3
        int itemIndex = items.length-1;
        do{
            Item item = items[itemIndex];
            int[] location = selectLocation();
            if(tryItemLocation(item, location, 0)){
                //4
                setLostPieces(item,location);
                //5
                item.setLocation(location[0],location[1]);
                itemIndex--;
            }

        }while (itemIndex >= 0);
        return items;
    }

}