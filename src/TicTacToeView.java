import javax.swing.*;
import java.awt.*;

public class TicTacToeView extends JFrame {
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 500;
    private TicTacToe game;
    private Image x;
    private Image o;
// Initializes the window
    public TicTacToeView(TicTacToe t) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tic Tac Toe");
        this.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        this.setVisible(true);
        this.game = t;
        this.o = new ImageIcon("Resources/o.png").getImage();
        this.x = new ImageIcon("Resources/x.png").getImage();
    }

    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0,0,WINDOW_WIDTH,WINDOW_HEIGHT);
        for (Square[] squares: game.getBoard()) {
            for (Square square: squares) {
                square.draw(g);
                if (square.getMarker().equals(TicTacToe.X_MARKER)) {
                    if (square.isWinningSquare()) {
                        g.drawImage(x,(square.getCol() + 1) * 100, (square.getRow() + 1) * 100, 100,100, Color.GREEN, this);
                    }
                    else {
                        g.drawImage(x,(square.getCol() + 1) * 100, (square.getRow() + 1) * 100, 100,100, this);
                    }
                }
                else if (square.getMarker().equals(TicTacToe.O_MARKER)) {
                    if (square.isWinningSquare()) {
                        g.drawImage(o,(square.getCol() + 1) * 100, (square.getRow() + 1) * 100, 100,100, Color.GREEN, this);
                    }
                    g.drawImage(o,(square.getCol() + 1) * 100, (square.getRow() + 1) * 100, 100, 100, this);
                }
            }
        }
        if (game.getWinner().equals(TicTacToe.X_MARKER)) {
            g.setColor(Color.black);
            g.setFont(new Font("Sans", Font.BOLD, 50));
            g.drawString("X Wins", 150, 450);
        }
        else if (game.getWinner().equals(TicTacToe.O_MARKER)) {
            g.setColor(Color.black);
            g.setFont(new Font("Sans", Font.BOLD, 50));
            g.drawString("O Wins", 150, 450);
        }
        else if (game.checkTie()) {
            g.setColor(Color.black);
            g.setFont(new Font("Sans", Font.BOLD, 50));
            g.drawString("Its a Tie!", 150, 450);

        }
    }
}
