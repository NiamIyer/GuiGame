import java.awt.*;

/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    private String marker;
    private int row;
    private int col;
    private boolean isWinningSquare;
    private TicTacToeView window;
    private final int SQUARE_LENGTH = 100;

    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col, TicTacToeView window) {
        this.row = row;
        this.col = col;

        this.window =  window;

        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    public boolean isWinningSquare() {
        return isWinningSquare;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }

    // Draw method to print the square
    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.drawRect(SQUARE_LENGTH * (col + 1), SQUARE_LENGTH * (row + 1), SQUARE_LENGTH, SQUARE_LENGTH);
        g.setColor(Color.red);
        Font axisFont = new Font("Serif", Font.ITALIC + Font.BOLD, 30);
        g.setFont(axisFont);
        if (col == 0) {
            g.drawString(String.valueOf(row),50,50 + SQUARE_LENGTH * (row + 1));
        }
        if (row == 0) {
            g.drawString(String.valueOf(col),50 + SQUARE_LENGTH * (col + 1),75);
        }
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
