import java.awt.*;

public class Die {
    private int side;
    private DiceGameView window;
    public Die (DiceGameView window) {
        this.window = window;
    }

    public int roll() {
        return (int) (Math.random() * 6) + 1;
    }

    public void draw(Graphics g) {

    }
}
