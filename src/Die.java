public class Die {
    private int numSides;
    public Die (int numSides) {
        this.numSides = numSides;
    }

    public int getNumSides() {
        return numSides;
    }

    public void setNumSides(int numSides) {
        this.numSides = numSides;
    }

    public int roll() {
        return (int) (Math.random() * numSides) + 1;
    }
}
