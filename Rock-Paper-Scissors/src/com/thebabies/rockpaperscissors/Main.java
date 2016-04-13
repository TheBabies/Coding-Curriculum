package com.thebabies.rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

public class Main {

    //
    // Code to display the text of the main menu
    //
    private static void showMenu()
    {
        System.out.println("Rock Paper Scissors");
        System.out.println("Please select an option from the list:");
        System.out.println("1) Play alone against the computer");
        System.out.println("2) Play against a friend");
        System.out.println("x) Exit the game");
    }

    //
    // Code to display the options of weapons
    //
    private static void showOptions()
    {
        System.out.println("Please select a weapon");
        System.out.println("R) Rock");
        System.out.println("P) Paper");
        System.out.println("S) Scissors");
    }

    //
    // Function to say which player wins.
    // Return 1: Player one won
    // Return 2: Player two won
    // Return 3: Tie
    //
    private static int whichPlayerWins(char playerOneWeapon, char playerTwoWeapon)
    {
        // If the players used the same weapon then return a draw
        if (playerOneWeapon == playerTwoWeapon)
            return 3;
        // All the scenarios in which player 1 can win.
        else if (playerOneWeapon == 'R' && playerTwoWeapon == 'S')
            return 1;
        else if (playerOneWeapon == 'P' && playerTwoWeapon == 'R')
            return 1;
        else if (playerOneWeapon == 'S' && playerTwoWeapon == 'P')
            return 1;

        // If there was not a draw/tie, and player 1 did not win then player 2 won.
        return 2;
    }

    //
    // Essentially clears the screen by printing 50 empty lines
    //
    private static void clearScreen()
    {
        for (int i = 0; i < 50; i++)
        {
            System.out.println();
        }
    }

    //
    // Get a random weapon (for computer players)
    //
    private static Character getRandomWeapon()
    {
        Random random = new Random();
        // Get a random number between 0 and 2 (so three possible numbers)
        int r = random.nextInt(3);
        if (r == 0)
            return 'R';
        else if (r == 1)
            return 'P';
        else
            return 'S';
    }

    //
    // Converts a weapon letter (R, P or S) into the full weapon name
    //
    private static String getWeaponName(Character weaponCode)
    {
        if (weaponCode == 'R')
            return "Rock";
        else if (weaponCode == 'P')
            return "Paper";
        else
            return "Scissors";
    }

    //
    // Main code to play the game.
    //
    private static void playGame(boolean twoPlayer)
    {
        // Get some user input.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the name of player one: ");
        String playerOneName = scanner.nextLine();
        String playerTwoName;
        // Only get the name of player two if twoPlayer is true. Otherwise call the second player "Computer"
        if (twoPlayer)
        {
            System.out.print("Please enter the name of player two: ");
            playerTwoName = scanner.nextLine();
        }
        else
        {
            playerTwoName = "Computer";
        }

        // Find out how many rounds should be played.
        System.out.println("How many rounds would you like to play?");
        int numberOfRounds = scanner.nextInt();

        Character playerOneSelection;
        Character playerTwoSelection;
        int playerOneScore = 0;
        int playerTwoScore = 0;

        // Loop over every possible round. So if 50 rounds were requested, this loop will run 50 times.
        for(int i = 1; i <=numberOfRounds; i++)
        {
            // Only bother clearing the screen if there is a second human player to protect info from.
            if (twoPlayer)
                clearScreen();

            // Say which round is playing.
            System.out.println("Round " + i);
            System.out.println();

            // Only worth being discrete for human players.
            if (twoPlayer)
                System.out.println(playerTwoName + ", please look away from the screen!");

            System.out.println(playerOneName + ", please make your selection.");

            // Show weapons.
            showOptions();
            do
            {
                scanner.reset();
                String playerOneSelectionString = scanner.next();
                // Get a line of text entered by the user then only process the first character.
                playerOneSelection = playerOneSelectionString.charAt(0);
                // Keep going until the user enters R, P or S.
            } while (playerOneSelection != 'R' && playerOneSelection != 'P' && playerOneSelection != 'S');


            // If a two player game is being played then take that data from the user. Otherwise get a random move.
            if (twoPlayer)
            {
                clearScreen();
                System.out.println(playerOneName + ", please look away from the screen!");
                System.out.println(playerTwoName + ", please make your selection.");
                do
                {
                    String playerTwoSelectionString = scanner.next();
                    playerTwoSelection = playerTwoSelectionString.charAt(0);
                } while (playerTwoSelection != 'R' && playerTwoSelection != 'P' && playerTwoSelection != 'S');
            }
            else
            {
                playerTwoSelection = getRandomWeapon();
            }


            if (twoPlayer)
                clearScreen();

            // Work out who won and store as an int.
            int result = whichPlayerWins(playerOneSelection, playerTwoSelection);

            // Show who played what.
            System.out.println(playerOneName + " played " + getWeaponName(playerOneSelection));
            System.out.println(playerTwoName + " played " + getWeaponName(playerTwoSelection));
            System.out.println();

            // If the result is 1 then player 1 won.
            if (result == 1)
            {
                playerOneScore++;
                System.out.println(playerOneName + " wins! Congratulations!");
            }
            // Otherwise, if the result is 2 then player two won.
            else if (result == 2)
            {
                playerTwoScore++;
                System.out.println(playerTwoName + " wins! Congratuations!");
            }
            // Otherwise there was a draw.
            else
            {
                System.out.println("Tiebreak! Nobody wins this round");
            }

            // Show the running tallies.
            System.out.println("Current Scores");
            System.out.println(playerOneName + ":\t" + playerOneScore);
            System.out.println(playerTwoName + ":\t" + playerTwoScore);
            if (i != numberOfRounds)
            {
                System.out.println("Press enter to play the next round");
                scanner.nextLine();
            }
        }

        if (twoPlayer)
            clearScreen();

        // Show final results after all the rounds have been played.
        System.out.println("Final results!");

        // If player 1 has a higher score then they must be the winner. Otherwise player 2 won if they have a higher
        // score. Otherwise overall tie.
        if (playerOneScore > playerTwoScore)
        {
            System.out.println(playerOneName + " wins with " + playerOneScore + " points!");
            System.out.println(playerTwoName + " had " + playerTwoScore + " points.");
        }
        else if (playerOneScore < playerTwoScore)
        {
            System.out.println(playerTwoName + " wins with " + playerTwoScore + " points!");
            System.out.println(playerOneName + " had " + playerOneScore + " points.");
        }
        else
        {
            System.out.println("You tied with " + playerOneScore + " points!");
        }

        // Show scores until user requests main menu.
        System.out.println();
        System.out.println("Press enter to go back to the main menu...");
        scanner.nextLine();
    }

    //
    // Main function: execution starts here!
    //
    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
        Character input;
        do
        {
            // Show game options from function defined above.
            showMenu();

            // Get the first character of anything entered into the next line.
            String inputString = scanner.next();
            input = inputString.charAt(0);

            // If the user enters 1 then play game in one player mode.
            // If the user enters 2 then play game in two player mode.
            // If the user enters x then exit the game.
            // Otherwise loop back round.
            switch(input)
            {
                case '1':
                    playGame(false);
                    break;
                case '2':
                    playGame(true);
                    break;
                case 'x':
                    // Do nothing, because the end of the while loop will exit the program anyway.
                    break;
                default:
                    System.out.println("You entered an invalid option. Please try again.");
            }
        }
        while(input != 'x');
    }
}
