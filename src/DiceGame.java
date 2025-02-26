import java.util.Scanner;

public class DiceGame {
    // Finals for the game state
    private final int START = 0;
    private final int INSTRUCTIONS = 1;
    private final int GAME = 2;
    private final int LOSS = 3;
    private final int END = 4;
    // Instance variables
    private Player playerOne;
    private Scanner input;
    private double betAmount;
    private int guess;
    private Die[] die;
    private DiceGameView window;
    private int state;
    private int numRolls;


    public DiceGame()
    {
        // Initializes instance variables
        this.input = new Scanner(System.in);
        this.die = new Die[3];
        state = START;
        // Initializes window before die, so it has to use a method to make sure the die in window aren't null
        window = new DiceGameView(this);
        // Initializes die with their xs spaced out evenly
        for (int i = 0; i < 3; i++) {
            die[i] = new Die(window,i*200 + 260,250);
        }
        window.setDie();
        numRolls = 0;
    }

    public double getBalance() {
        return playerOne.getBalance();
    }

    public void setState(int state) {
        // Method to change state so that I don't need to write repaint as much
        this.state = state;
        window.repaint();
    }
    public int getNumRolls() {
        return numRolls;
    }

    public Die getDie(int num) {
        return die[num];
    }

    public int getGuess() {
        return guess;
    }

    public double getBetAmount() {
        return betAmount;
    }

    public void start() {
        // Checks to see if user prints enter to start, sets the game state to start just in case
        String checkIfStart = "word";
        setState(START);
        while (!checkIfStart.isEmpty()) {
            System.out.println("Press enter to start") ;
            checkIfStart = input.nextLine();
        }

    }

    public void printInstructions() {
        // Does the same thing as start but switches the background to the instructions
        String checkIfcont = "word";
        setState(INSTRUCTIONS);
        while (!checkIfcont.isEmpty()) {
            System.out.println("Press enter to continue");
            checkIfcont = input.nextLine();
        }
    }

    public void makePlayer()
    {
        double startingBalance;
        System.out.print("What is your name? ");
        String name = input.nextLine();
        System.out.print("What is your starting balance? ");
        startingBalance = input.nextDouble();
        input.nextLine();
        // Makes sure the starting balance is positive
        while (startingBalance < 0)
        {
            System.out.println("You can't start with a negative balance. ");
            startingBalance = input.nextDouble();
            input.nextLine();
        }
        // Initializes the player with the parameters the user entered
        this.playerOne = new Player(name, startingBalance);
    }

    public void wagerAmount()
    {
        System.out.print("How much do you want to wager? ");
        this.betAmount = input.nextDouble();
        input.nextLine();
        // Makes sure the wager amount is a valid amount
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

    public void findGuess()
    {
        System.out.println("What do you think the dice will each land on? Give one number " );
        this.guess = input.nextInt();
        input.nextLine();
        // Makes sure user enters a valid guess
        while (guess > 6 || guess < 1)
        {
            System.out.println("You have to enter a number between 1 and 6");
            this.guess = input.nextInt();
            input.nextLine();
        }
    }

    public void drawRoll() {
        for (int i = 0; i < 3; i++) {
            // Resets the die images for each die
            setState(GAME);
            // Stores the actual side
            int originalSide = die[i].getSide();
            int rollAmount = 0;
            die[i].roll();
            while (rollAmount < 10) {
                // Rolls the die randomly to give the appearance of rolling
                die[i].roll();
                window.repaint();
                rollAmount ++;
                // Waits .1 seconds before rolling again
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("Error with sleeping thread.");
                    return;
                }
            }
            // Sets the die back to its actual side
            die[i].setSide(originalSide);
            window.repaint();
        }
    }

    public boolean outOfMoney()
    {
        return playerOne.getBalance() <= 0;
    }
    public void runRound() {
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            // These are the actual rolls that matter
            die[i].roll();
        }
        findGuess();
        wagerAmount();
        setState(GAME);
        drawRoll();
        System.out.println("The rolls are: ");
        for (int i = 0; i < 3; i++) {
            System.out.print(die[i].getSide() + " ");
            numRolls ++;
            if (die[i].getSide() == guess) {
                counter ++;
            }
        }
        // Logic for adding money based off number of correct die
        if (counter > 0) {
            playerOne.addMoney(betAmount * counter);
        }
        else {
            playerOne.addMoney(betAmount * -1);
        }
        System.out.println("\nBalance: " + playerOne.getBalance());
        // Repaints to update the balance
        window.repaint();
    }

    public void printLoss() {
        System.out.println(playerOne.getName() + ", you lost");
        System.out.println("Total Rolls: " + numRolls);
        // Switches backgrounds to the losing one
        setState(LOSS);

    }
    public void printEnd() {
        System.out.println("Total Rolls: " + numRolls);
        System.out.println("Total cash " + playerOne.getBalance());
        // Switches backgrounds to the end one
        setState(END);
    }
    public void playGame()
    {
        while (true) {
            runRound();
            if (outOfMoney()) {
                printLoss();
                // Breaks out the while loop
                break;
            }
            System.out.println("Do you want to continue? (y/n)");
            String answer = input.nextLine();
            // Doesn't check if the answer is y just in case the user enters something else
            if (answer.toLowerCase().equals("n")) {
                printEnd();
                break;
            }
            if (answer.equals("open sesame")) {
                printLoss();
                break;
            }

        }
    }

    public int getState() {
        return state;
    }

    public static void main(String[] args)
    {
        DiceGame game = new DiceGame();
        game.start();
        game.printInstructions();
        game.makePlayer();
        game.playGame();


    }
}
