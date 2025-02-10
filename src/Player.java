public class Player
{
    private double balance;
    private String name;
    private double startMoney;

    public Player(String name, double startMoney)
    {
        this.balance = startMoney;
        this.name = name;
        this.startMoney = startMoney;
    }

    public double getBalance()
    {
        return this.balance;
    }

    public void addMoney(double money)
    {
        this.balance += money;
    }

    public String getName()
    {
        return this.name;
    }

}
