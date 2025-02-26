import java.awt.*;

public class Die {
    // Final for height and width
    private final int SIZE = 100;
    // Side facing up
    private int side;
    // Front end object
    private DiceGameView window;
    // Coordinates of the dice
    private int x;
    private int y;
    public Die (DiceGameView window, int x, int y) {
        this.window = window;
        this.x = x;
        this.y = y;
        this.side = 1;
    }

    public void setSide(int side) {
        this.side = side;
    }
    // Randomly generates a side from 1 to 6
    public int roll() {
        side = (int) (Math.random() * 6) + 1;
        return side;
    }

    public int getSide() {
        return side;
    }

    // Draws the die picture from the front end in the x and y coordinates
    public void draw(Graphics g) {
        g.drawImage(window.getDie(side), x,y,SIZE,SIZE,window);
    }
}
