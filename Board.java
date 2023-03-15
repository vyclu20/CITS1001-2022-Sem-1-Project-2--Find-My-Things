
/**
 * A class to maintain update the current state of the board.
 *
 * @author Ms Caitlin Woods
 * @version April 2022
 * <p>
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Board {

    Piece[][] board; // A 2D array of pieces, representing the state of a board.

    /**
     * Constructor for the Board class
     * Initializes the board with 12 rows and columns
     * and sets all locations to VACANT
     */
    public Board() {
        // TODO 11
        this.board = new Piece[12][12];
        for (Piece[] item : this.board) {
            Arrays.fill(item, Piece.VACANT);
        }
    }

    /**
     * Constructor for the Board class
     * Initializes the board with the given number of rows and columns
     * and sets all locations to defaultValue
     */
    public Board(int rows, int cols, Piece defaultValue) {
        // TODO 12
        this.board = new Piece[rows][cols];
        for (Piece[] item : this.board) {
            Arrays.fill(item, defaultValue);
        }
    }

    /**
     * Returns the size of the board as an integer (i.e. 12x12 board should return
     * 12)
     * hint: You can assume the grid is square (i.e. rows == cols)
     *
     * @return the size of the board
     */
    public int getBoardSize() {
        // TODO 13
        return this.board.length;
    }

    /**
     * Returns true if x and y are coordinates in the board, false otherwise
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @return true if x and y are coordinates in the board, false otherwise
     */
    public boolean isPiece(int x, int y) {
        // TODO 14
        int rowSize = this.board.length;
        int colSize = this.board[0].length;

        return x >= 0 && y >= 0 && x <= rowSize - 1 && y <= colSize - 1;
    }

    /**
     * Returns the value of the piece at the given coordinates
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @return the value of the piece at the given coordinates
     * @throws IllegalArgumentException if x and y are not valid coordinates
     */
    public Piece getPiece(int x, int y) {
        // TODO 15
        if (!isPiece(x, y)) {
            throw new IllegalArgumentException();
        }
        return this.board[x][y];
    }

    /**
     * Check if a given piece is part of a lost item
     * Throw an exeption if the piece is not in the board
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @return true if a given piece is part of a lost item, false otherwise
     * @throws IllegalArgumentException if the piece is not in the board
     */
    public boolean isLostItem(int x, int y) {
        // TODO 16
        if (!isPiece(x, y)) {
            try {
                throw new IllegalArgumentException();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return getPiece(x, y) == Piece.LOSTITEM;
    }

    /**
     * Sets the given piece to be part of a lost item (i.e. an item is hidden at
     * this location)
     * Throw an exception if the piece is not on the board
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @throws IllegalArgumentException if the piece is not in the board
     */
    public void setLostItem(int x, int y) {
        // TODO 17
        if (!isPiece(x, y)) {
            try {
                throw new IllegalArgumentException();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.board[x][y] = Piece.LOSTITEM;

    }

    /**
     * Check if a given piece is vacant
     * Throw an exeption if the piece is not in the board
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @return true if a given piece is vacant, false otherwise
     * @throws IllegalArgumentException if the piece is not in the board
     */
    public boolean isVacant(int x, int y) {
        // TODO 18
        if (!isPiece(x, y)) {
            try {
                throw new IllegalArgumentException();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return getPiece(x, y) == Piece.VACANT;
    }

    /**
     * Sets the given piece to be vacant (i.e. no item is on this location)
     * Throw an exception if the piece is not on the board
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @throws IllegalArgumentException if the piece is not in the board
     */
    public void setVacant(int x, int y) {
        // TODO 19
        if (!isPiece(x, y)) {
            try {
                throw new IllegalArgumentException();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.board[x][y] = Piece.VACANT;
    }

    /**
     * Check if a given piece is part of an item that has been found by the player
     * Throw an exeption if the piece is not in the board
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @return true if a given piece is part of a found item, false otherwise
     * @throws IllegalArgumentException if the piece is not in the board
     */
    public boolean isFoundItem(int x, int y) {
        // TODO 20
        if (!isPiece(x, y)) {
            try {
                throw new IllegalArgumentException();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return getPiece(x, y) == Piece.FOUNDITEM;
    }


    /**
     * Sets the given piece to be part of a found item (i.e. an item is hidden at
     * this location and this piece has been found by the player)
     * Throw an exception if the piece is not on the board
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @throws IllegalArgumentException if the piece is not in the board
     */
    public void setFoundItem(int x, int y) {
        // TODO 21
        if (!isPiece(x, y)) {
            try {
                throw new IllegalArgumentException();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.board[x][y] = Piece.FOUNDITEM;

    }

    /**
     * Check if a given piece has been searched by the player (but does not contain
     * any part of a hidden item)
     * Throw an exeption if the piece is not in the board
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @return true if a given piece is part of a found item, false otherwise
     * @throws IllegalArgumentException if the piece is not in the board
     */
    public boolean isSearched(int x, int y) {
        // TODO 22
        if (!isPiece(x, y)) {
            try {
                throw new IllegalArgumentException();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.board[x][y] == Piece.SEARCHED;
    }

    /**
     * Sets the given piece to "searched" (i.e. no item has been hidden at this
     * location and the player has searched this space)
     * Throw an exception if the piece is not on the board
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @throws IllegalArgumentException if the piece is not in the board
     */
    public void setSearched(int x, int y) {
        // TODO 23
        if (!isPiece(x, y)) {
            try {
                throw new IllegalArgumentException();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.board[x][y] = Piece.SEARCHED;
    }


    /**
     * Sets the given piece to a new state, after it has been searched according to
     * the following rules:
     * 1) If the space is currently VACANT, set it to SEARCHED
     * 2) If the space is currently LOST, set it to FOUND
     * 3) Return true if the search was successful (or unnecessary), false otherwide
     *
     * @param x
     * @param y
     * @return true if the search was successful (or unnecessary), false otherwise
     */
    public boolean searchSpace(int x, int y) {
        // TODO 24
        if (getPiece(x, y) == Piece.VACANT) {
            this.board[x][y] = Piece.SEARCHED;
            return true;
        } else if (getPiece(x, y) == Piece.LOSTITEM) {
            this.board[x][y] = Piece.FOUNDITEM;
            return true;
        }
        return false;

    }

    /**
     * Find the closest lost item piece to the piece that has just been touched (at [touchedX, touchedY]).
     * Return the "number of spaces away" that the closest lost item is.
     * An item is considered "the closest" if the "number of spaces away in the x direction"
     * plus the "number of spaces away in the y direction" is minimal.
     *
     * @param touchedX the x coordinate of the touched point
     * @param touchedY the y coordinate of the touched point
     * @return an array of size 2 containing the number of spaces away
     * in the X direction and the number of spaces away in the Y direction
     * where the array is in the form [x, y]
     */
    public int[] getClosestItem(int touchedX, int touchedY) {
        // TODO 25
        int[] closestItem = new int[2];
        int closest = -1;
        int count;
        // use for loop to read the board
        for (int x = 0; x < this.board.length; x++) {
            for (int y = 0; y < this.board[0].length; y++) {

                if (this.board[x][y] == Piece.LOSTITEM) {
                    // the number of counts tell us how far we are to the closest item.
                    count = Math.abs(touchedX - x)+Math.abs(touchedY - y);
                    // closest = -1 means it is the first time finding the closest item.
                    // if the number of counts are smaller than closest, it means that the closest item has been found.
                    if(closest == -1 || closest > count) {
                        // record the smallest number and assign it to array closestItem.
                        closest = count;

                        closestItem[0] = Math.abs(touchedX - x);
                        closestItem[1] = Math.abs(touchedY - y);
                    }
                }
            }
        }
        return closestItem;
    }

    /**
     * Checks if a whole item has been found on the board
     * An item is considered "found" if there are a cluster of spaces on the board that
     * have a value of FOUNDITEM, and that cluster is in the shape of the item.
     *
     * @param item the item to check.
     * @return true if the item has been found, false otherwise.
     */
    public boolean checkForFoundItem(Item item) {
        // TODO 26
        int x = item.getLocationX();
        int y = item.getLocationY();

        int[][] shape = item.getShape();
        boolean found = false;


        for(int i = 0 ; i < shape.length; i++){
            for (int j = 0; j < shape[0].length ;j++){
                // the value '1' represent parts of the object's shape

                if(shape[j][i] == 1){
                    // use x+i and y+j to find the location on the board
                    if(this.board[x+i][y+j] == Piece.FOUNDITEM){
                        found = true;
                    }else{
                        // return false if the location is not "FOUNDITEM". it means the item has not been found.
                        return false;
                    }
                }
            }
        }

        return found;
    }

    /**
     * Goes through a list of items and checks which of the items have been found.
     * (hint: use a helper method that you have already written).
     *
     * @return an array list of items that have been found.
     */
    public ArrayList<Item> getFoundItemsList(Item[] items) {
        // TODO 27
        ArrayList<Item> itemsFound = new ArrayList<>();

        for (Item i : items) {
        if (checkForFoundItem(i) == true) {
        itemsFound.add(i);
        }
    }
    return itemsFound;
    }
}
