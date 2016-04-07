package com.thebabies.rockpaperscissors;

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
        if (playerOneWeapon == 'R' && playerTwoWeapon == 'S')
            return 1;
        else if (playerOneWeapon == 'P' && playerTwoWeapon == 'R')
            return 1;
        else if 
    }

    private static void clearScreen()
    {
        for (int i = 0; i < 50; i++)
        {
            System.out.println();
        }
    }

    private static void playGame(boolean twoPlayer)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the name of player one: ");
        String playerOneName = scanner.nextLine();
        String playerTwoName;
        if (twoPlayer)
        {
            System.out.println("Please enter the name of player two: ");
            playerTwoName = scanner.nextLine();
        }
        else
        {
            playerTwoName = "Computer";
        }

        System.out.println("How many rounds would you like to play?");
        System.out.print("You must enter an odd number: ");
        int numberOfRounds;

        // Keep taking user input until an odd number is entered. This is so that there is always an overall winner.
        do
        {
            numberOfRounds = scanner.nextInt();
        }
        while (numberOfRounds % 2 == 0);

        for(int i = 1; i <=numberOfRounds; i++)
        {
            clearScreen();
            showOptions();
        }
    }

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
        Character input;
        do
        {
            showMenu();
            input = scanner.nextLine().charAt(0);

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
