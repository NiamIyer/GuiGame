public class Player
{
    // Instance variables for name and money
    private double balance;
    private String name;

    public Player(String name, double startMoney)
    {
        this.balance = startMoney;
        this.name = name;
    }

    public double getBalance()
    {
        return this.balance;
    }

    public void addMoney(double money)
    {
        // Adds money instead of setting it
        this.balance += money;
    }

    public String getName()
    {
        return this.name;
    }

}
