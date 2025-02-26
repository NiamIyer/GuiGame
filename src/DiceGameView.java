import java.awt.*;
import javax.swing.*;


public class DiceGameView extends JFrame{
    // Finals for window size and state
    private final int WINDOW_HEIGHT = 500;
    private final int WINDOW_WIDTH = 1000;
    private final int START = 0;
    private final int INSTRUCTIONS = 1;
    private final int GAME = 2;
    private final int LOSS = 3;
    private final int END = 4;
    private Image[] die;
    private Image[] background;
    private DiceGame game;
    private Die[] mydie;
    private Font sansNiam;

    public DiceGameView(DiceGame game) {
        // Makes sure to set all the screen settings
        this.game = game;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Dice Game");
        this.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        mydie = new Die[3];
        // Puts all the images in the arrays
        die = new Image[6];
        die[0] = new ImageIcon("Resources/1.png").getImage();
        die[1] = new ImageIcon("Resources/2.png").getImage();
        die[2] = new ImageIcon("Resources/3.png").getImage();
        die[3] = new ImageIcon("Resources/4.png").getImage();
        die[4] = new ImageIcon("Resources/5.png").getImage();
        die[5] = new ImageIcon("Resources/6.png").getImage();
        background = new Image[5];
        background[0] = new ImageIcon("Resources/Welcome.png").getImage();
        background[1] = new ImageIcon("Resources/Instructions.png").getImage();
        background[2] = new ImageIcon("Resources/Game.png").getImage();
        background[3] = new ImageIcon("Resources/Loss.png").getImage();
        background[4] = new ImageIcon("Resources/End.png").getImage();
        // Sets visible at end (calls paint)
        this.setVisible(true);
        sansNiam = new Font("Sans Niam", Font.ITALIC + Font.BOLD,30);

    }

    public void setDie() {
        // Sets die because it is originally null
        for (int i = 0; i < 3; i++) {
            mydie[i] = game.getDie(i);
        }
    }

    public Image getDie(int side){
        return die[side-1];
    }

    public void paint(Graphics g) {
        // Uses switch case to show the right screen
        switch (game.getState()) {
            case START:
                drawStart(g);
                break;
            case INSTRUCTIONS:
                drawInstructions(g);
                break;
            case GAME:
                drawGame(g);
                break;
            case LOSS:
                drawLoss(g);
                break;
            case END:
                drawEnd(g);
                break;
        }
    }
    // Draws the screen based off the background images
    private void drawStart(Graphics g) {
        g.drawImage(background[START],0,0,this);
    }
    private void drawInstructions(Graphics g) {
        g.drawImage(background[INSTRUCTIONS],0,0,this);
    }
    private void drawGame(Graphics g) {
        g.drawImage(background[GAME],0,0,this);
        for (Die die : mydie) {
            die.draw(g);
        }
        g.setFont(sansNiam);
        g.setColor(new Color(25, 82, 112));
        g.drawString("Balance: " + game.getBalance(),350,75);
        g.drawString("Guess: " + game.getGuess(),110,430);
        g.drawString("Wager: " + game.getBetAmount(),700,430);
    }
    private void drawLoss(Graphics g) {
        g.drawImage(background[LOSS],0,0,this);
        g.setFont(sansNiam);
        g.setColor(Color.white);
        g.drawString("Rolls: " + game.getNumRolls(),400,300);
    }
    private void drawEnd(Graphics g) {
        g.drawImage(background[END],0,0,this);
        g.setFont(sansNiam);
        g.setColor(Color.white);
        g.drawString("Rolls: " + game.getNumRolls(),400,300);
        g.drawString("Balance: " + game.getBalance(),400,400);
    }



}
