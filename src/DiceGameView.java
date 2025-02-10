import java.awt.*;
import javax.swing.*;


public class DiceGameView extends JFrame{
    private final int WINDOW_HEIGHT = 500;
    private final int WINDOW_WIDTH = 1000;
    private Image[] die;
    private DiceGame game;
    public DiceGameView(DiceGame game, int numSides) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Dice Game");
        this.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        this.setVisible(true);
    }

}
