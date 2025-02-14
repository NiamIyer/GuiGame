import java.awt.*;
import javax.swing.*;


public class DiceGameView extends JFrame{
    private final int WINDOW_HEIGHT = 500;
    private final int WINDOW_WIDTH = 1000;
    private Image[] die;
    private Image[] bg;
    private DiceGame game;
    public DiceGameView(DiceGame game) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Dice Game");
        this.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        this.setVisible(true);
        die = new Image[6];
        die[0] = new ImageIcon("Resources/1.png").getImage();
        die[1] = new ImageIcon("Resources/2.png").getImage();
        die[2] = new ImageIcon("Resources/3.png").getImage();
        die[3] = new ImageIcon("Resources/4.png").getImage();
        die[4] = new ImageIcon("Resources/5.png").getImage();
        die[5] = new ImageIcon("Resources/6.png").getImage();
        bg = new Image[6] {
                bg[0] = new ImageIcon("Resources/Welcome.png").getImage();
                bg[1] = new ImageIcon("Resources/Instructions.png").getImage();
                bg[4] = new ImageIcon("Resources/End.png").getImage();
        }
    }

    public void paint(Graphics g) {
        switch (game.getState()) {
            case 0:
                drawStart(g);
            case 1:
                drawInstructions(g);
            case 2:
                drawWager(g);
            case 3:
                drawRoll(g);
            case 4:
                drawLoss(g);
            case 5: drawEnd(g);
        }
    }

    public void drawStart(Graphics g) {

    }

}
