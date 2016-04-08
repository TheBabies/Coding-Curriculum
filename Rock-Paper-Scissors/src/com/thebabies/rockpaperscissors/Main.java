package com.thebabies.rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static void showMenu()
    {
        System.out.println("Rock Paper Scissors");
        System.out.println("Please select an option from the list:");
        System.out.println("1) Play alone against the computer");
        System.out.println("2) Play against a friend");
        System.out.println("x) Exit the game");
    }

    private static void showOptions()
    {
        System.out.println("Please select a weapon");
        System.out.println("R) Rock");
        System.out.println("P) Paper");
        System.out.println("S) Scissors");
    }

    private static int whichPlayerWins(char playerOneWeapon, char playerTwoWeapon)
    {
        if (playerOneWeapon == playerTwoWeapon)
            return 3;
        else if (playerOneWeapon == 'R' && playerTwoWeapon == 'S')
            return 1;
        else if (playerOneWeapon == 'P' && playerTwoWeapon == 'R')
            return 1;
        else if (playerOneWeapon == 'S' && playerTwoWeapon == 'P')
            return 1;

        return 2;
    }

    private static void clearScreen()
    {
        for (int i = 0; i < 50; i++)
        {
            System.out.println();
        }
    }

    private static Character getRandomWeapon()
    {
        Random random = new Random();
        int r = random.nextInt(3);
        if (r == 0)
            return 'R';
        else if (r == 1)
            return 'P';
        else
            return 'S';
    }

    private static String getWeaponName(Character weaponCode)
    {
        if (weaponCode == 'R')
            return "Rock";
        else if (weaponCode == 'P')
            return "Paper";
        else
            return "Scissors";
    }

    private static void playGame(boolean twoPlayer)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the name of player one: ");
        String playerOneName = scanner.nextLine();
        String playerTwoName;
        if (twoPlayer)
        {
            System.out.print("Please enter the name of player two: ");
            playerTwoName = scanner.nextLine();
        }
        else
        {
            playerTwoName = "Computer";
        }

        System.out.println("How many rounds would you like to play?");
        int numberOfRounds = scanner.nextInt();

        Character playerOneSelection;
        Character playerTwoSelection;
        int playerOneScore = 0;
        int playerTwoScore = 0;

        for(int i = 1; i <=numberOfRounds; i++)
        {
            if (twoPlayer)
                clearScreen();
            System.out.println("Round " + i);
            System.out.println();

            if (twoPlayer)
                System.out.println(playerTwoName + ", please look away from the screen!");

            System.out.println(playerOneName + ", please make your selection.");
            showOptions();
            do
            {
                scanner.reset();
                String playerOneSelectionString = scanner.next();
                playerOneSelection = playerOneSelectionString.charAt(0);
            } while (playerOneSelection != 'R' && playerOneSelection != 'P' && playerOneSelection != 'S');


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
            int result = whichPlayerWins(playerOneSelection, playerTwoSelection);
            System.out.println(playerOneName + " played " + getWeaponName(playerOneSelection));
            System.out.println(playerTwoName + " played " + getWeaponName(playerTwoSelection));
            System.out.println();
            if (result == 1)
            {
                playerOneScore++;
                System.out.println(playerOneName + " wins! Congratulations!");
            }
            else if (result == 2)
            {
                playerTwoScore++;
                System.out.println(playerTwoName + " wins! Congratuations!");
            }
            else
            {
                System.out.println("Tiebreak! Nobody wins this round");
            }

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
        System.out.println("Final results!");
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
        System.out.println();
        System.out.println("Press enter to go back to the main menu...");
        scanner.nextLine();
    }

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
        Character input;
        do
        {
            showMenu();
            String inputString = scanner.next();
            input = inputString.charAt(0);
            //System.out.println(input);


            switch(input)
            {
                case '1':
                    //System.out.println(input);
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
