
/**
 * Implements a view of a game of "find my things" by allowing users to click to take turns
 * and displaying the output.
 *
 * @author Ms Caitlin Woods
 * @version April 2022
 * <p>
 */

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GameViewer implements MouseListener {

    // instance variables
    private int bkSize; // block size (i.e. size of a piece) - all other measurements to be derived from bkSize
    private int brdSize; // the size of the board
    private int scoreboardSize; // the size of the scoreboard
    private SimpleCanvas sc; // an object of SimpleCanvas to drae on
    private Board bd; // a board that maintains the current state of the game.
    private AIPlayer ai; // an AI player to place items at the start of every game.

    private Item[] selectedItems; // the items that have been selected by the AIPlayer for the current game.
    private int turnsRemaining; // the number of turns that remains for the player in the current game.
    private int[] closestLostItem; // the distace away of the closest lost item (given a click).
    private int numberOfFoundItems; // the number of items that have been found (i.e. completely uncovered) by the player.
    private int numberOfHiddenItems; // the number of items that the AI player needs to hide.
    private int numberOfTurnsAtStartOfGame; //the number of turns that they player has when a new game starts.


    /**
     * Constructor for objects of class GameViewer.
     * Initialises the field variables and begins a game of "find my things".
     * THIS HAS BEEN PROVIDED FOR YOU.
     * PLEASE DO NOT MODIFY OR CHANGE ANY CODE IN THIS CONSTRUCTOR.
     */
    public GameViewer(int bkSize, int numberOfTurns, int numberOfItemsToHide) {
        numberOfHiddenItems = numberOfItemsToHide;
        numberOfTurnsAtStartOfGame = numberOfTurns;
        this.bkSize = bkSize;
        scoreboardSize = 4 * bkSize;
        brdSize = bkSize * 12;
        sc = new SimpleCanvas("Find my Things", brdSize, brdSize + scoreboardSize, Color.WHITE);
        sc.addMouseListener(this);

        bd = new Board();
        ai = new AIPlayer(bd, numberOfHiddenItems);
        turnsRemaining = numberOfTurnsAtStartOfGame;
        selectedItems = ai.startGame();
        closestLostItem = new int[2];
        sc.drawBoard(brdSize, bkSize, scoreboardSize, turnsRemaining, closestLostItem, numberOfFoundItems,
                selectedItems, bd);
    }

    /**
     * An default constructor for objects of class GameViewer.
     * Sets to block size (bkSize) as a default of 40.
     * Sets the numberOfTurns to 20.
     * Sets the numberOfItemsToHide to 3.
     */
    public GameViewer() {
        // TODO 34
        bkSize = 40;
        turnsRemaining = 20;
        numberOfHiddenItems = 3;
    }

    /**
     * Restarts a game of "Find My Things". There are a few steps to do here. They
     * are:
     * 1) Re-initialise the board field variable
     * 2) Re-initialise the aiPlayer field variable (set the numberOfItems parameter to 3)
     * 3) Re-initialise the turnsRemaining field variable (set the default to 20)
     * 4) Re-nitialise the selectedItems field variable (hint: use ai.startGame)
     * 5) Re-nitialise the closestLostItem field variable to an array of size 2
     * (default values 0)
     * 6) Re-draw the board (use the SimpleCanvas class);
     */
    private void restartGame() {
        // TODO 35
        bd = new Board();
        ai = new AIPlayer(bd, numberOfHiddenItems);
        turnsRemaining = numberOfTurnsAtStartOfGame;
        selectedItems = ai.startGame();
        closestLostItem = new int[2];
        sc.drawBoard(brdSize, bkSize, scoreboardSize, turnsRemaining, closestLostItem, numberOfFoundItems,
                selectedItems, bd);
    }

    /**
     * Get the piece to click (number from 0 to size of board) from a mouse event
     * (this is used in the mousePressed method)
     * hint: you will need to know the size of a piece to calculate the coordinates.
     *
     * @param xClicked the x value of a mouse event.
     * @param yClicked the y value of a mouse event.
     * @return the x and y coordinates of the piece that has been clicked.
     */
    public int[] getNearestPiece(int xClicked, int yClicked) {
        // TODO 36
        int x = xClicked / bkSize;
        int y = yClicked / bkSize;

        return new int[]{x,y};
    }

    /**
     * Returns the number of turns that the player has remaining
     *
     * @return the number of turns remaining
     */
    public int getTurnsRemaining() {
        // TODO 37
        return turnsRemaining;
    }

    /**
     * If a click is not successful, reduce the number of turns that the player has remaining by 1
     *
     * @param a boolean representing if the click was successful (i.e. a player found an item)
     */
    public void reduceTurns(boolean clickSuccessful) {
        // TODO 38
        if (!clickSuccessful) {
            turnsRemaining--;
        }
    }

    /**
     * Draws the game outcome on the canvas (hint: the simple canvas class provides two helper
     * methods to do this)
     * The location of the game outcome text should be set to to [0, 0];
     */
    public void drawGameOutcome() {
        // TODO 39
        if (turnsRemaining >= 0 && numberOfFoundItems == selectedItems.length) {
            sc.drawGameWon(0,0);
        } else {
            sc.drawGameLost(0, 0);
        }
    }

    /**
     * Refreshes the values shown on the board and scoreboard. There are some steps to do here.
     * Actions are as follows:
     * 1) Update state of selected items if they have been found.
     * 2) Update the closest lost item values.
     * 3) Redraw the board.
     * 4) If there are no turns remaining, draw the game outcome.
     *
     * @param xLastClicked
     * @param yLastClicked
     */
    public void refreshBoard(int xLastClicked, int yLastClicked) {
        // TODO 40
    }

    /**
     * Called when the player takes a turn (happens within the mousePressed method).
     * The rules are as follows
     * 1) If the player has no turns remaining, do nothing.
     * 2) If the space that is clicked is already found or searched, do nothing.
     * 3) If the space that is clicked is vacant, search it.
     * 4) If the search was unsuccessful (i.e. the player found nothing), reduce the number of turns remaining by 1.
     * 5) refresh the board (to re-display the board);
     *
     * @return the number of turns remaining.
     */
    public int takeTurn(int x, int y) {
        // TODO 41
        return 0;
    }

    /**
     * Processes a mouse click event. The following actions should be taken.
     * 1) If the "restart game" button has been clicked, restart the game.
     * 2) Otherwise, take a turn.
     * (hint: you must figure out the position (in pixels) of the "restart game" button to do this).
     */
    public void mousePressed(MouseEvent e) {
        // TODO 42
        int x1 = 0;
        int y1 = brdSize + scoreboardSize - 50;
        int x2 = 150;
        int y2 = y1 + 50;
        if (e.getX() >= x1 && e.getX() <= x2 && e.getY() >= y1 && e.getY() <= y2) {
            restartGame();
        }
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    /**
     * This is a helper method for testing purposes only.
     * DO NOT USE THIS METHOD IN YOUR CODE
     * DO NOT MODIFY THIS METHOD.
     */
    public void setBoardStateTestingOnly(Board board) {
        bd = board;
    }

    /**
     * This is a helper method for testing purposes only.
     * DO NOT USE THIS METHOD IN YOUR CODE
     * DO NOT MODIFY THIS METHOD.
     */
    public Item[] getSelectedItems() {
        return selectedItems;
    }


}
