import java.util.Scanner;

public class DiceGame {
    private Player playerOne;
    private Die d1;
    private Scanner input;
    private double betAmount;
    private int guess;
    private int counter;
    private int[] diceRolls;



    public DiceGame()
    {
        this.d1 = new Die(6);
        this.input = new Scanner(System.in);
        this.diceRolls = new int[3];
    }
    public void makePlayer()
    {
        double startingBalance;
        System.out.print("What is your name? ");
        String name = input.nextLine();
        System.out.print("What is your starting balance? ");
        startingBalance = input.nextDouble();
        input.nextLine();
        while (startingBalance < 0)
        {
            System.out.println("You can't start with a negative balance. ");
            startingBalance = input.nextDouble();
            input.nextLine();
        }
        this.playerOne = new Player(name, startingBalance);
    }

    public void wagerAmount()
    {
        System.out.print("How much do you want to wager? ");
        this.betAmount = input.nextDouble();
        input.nextLine();
        while (this.betAmount <= 0 || this.betAmount > playerOne.getBalance())
        {
            if (this.betAmount <= 0)
            {
                System.out.println("Wager can't be zero or negative ");
                this.betAmount = input.nextDouble();
                input.nextLine();
            }
            if (this.betAmount > playerOne.getBalance())
            {
                System.out.println("Wager can't be more than balance ");
                this.betAmount = input.nextDouble();
                input.nextLine();
            }
        }
    }

    public void getGuess()
    {
        System.out.println( d1.toString() + "\nWhat do you think the dice will each land on? Give one number " );
        this.guess = input.nextInt();
        input.nextLine();
        while (guess > 6 || guess < 1)
        {
            System.out.println("You have to enter a number between 1 and 6");
            this.guess = input.nextInt();
            input.nextLine();
        }
    }

    public boolean outOfMoney()
    {
        return playerOne.getBalance() <= 0;
    }

    public void playGame()
    {
        counter = 0;
        // Gets the wager and guess and makes sure they is valid

        // Creates an array and fills it with the rolls
        System.out.println("The rolls are: ");
        for (int i = 0; i < 3; i++)
        {
            diceRolls[i] = d1.roll();
            System.out.print(diceRolls[i] + " ");
            // Sees how many rolls are the same as the guess
            if (diceRolls [i] == guess)
            {
                counter += 1;
            }
        }
        // Adds to balance if they win, subtracts if they lose
        if (counter > 0)
        {
            playerOne.addMoney(betAmount * (counter + 1));
        }
        else
        {
            playerOne.addMoney(betAmount * -1);
        }
        System.out.println("\n" + playerOne.getName() + ", your balance is " + playerOne.getBalance() );
    }

    public static void main(String[] args)
    {
        DiceGame game = new DiceGame();

        game.makePlayer();

        while (game.outOfMoney() == false)
        {
            game.wagerAmount();
            game.getGuess();
            game.playGame();
        }
        System.out.println("You ran out of money!");
    }
}


