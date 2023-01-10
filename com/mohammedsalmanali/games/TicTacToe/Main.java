package com.mohammedsalmanali.games.TicTacToe;

import com.mohammedsalmanali.games.TicTacToe.TicTacToe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int totalNumberOfGames = 10;
        int numberOfGames = 0;
        int winner = 0;
        String play2 = null;

        // Game Mode Selection
        System.out.println("Please select the game mode:");
        System.out.println("1 - 2 Players");
        System.out.println("2 - VS Computer");

        Scanner md = new Scanner(System.in);

        while(!md.hasNextInt()){

            System.out.println("Please Enter a valid mode");
            md = new Scanner(System.in);

        }

        int md1 = md.nextInt();

        while(md1 != 1 && md1 != 2) {
            System.out.println("Please Enter a valid mode");
            md = new Scanner(System.in);
            while (!md.hasNextInt()) {

                System.out.println("Please Enter a valid mode");
                md = new Scanner(System.in);
            }
            md1 = md.nextInt();
        }

        // Player 1 Name
        System.out.println("Enter Player 1 name: ");
        Scanner pl1 = new Scanner(System.in);
        String play1 = pl1.next();

        // Player 2 Name
        if(md1 == 1) {
            System.out.println("Enter Player 2 name: ");
            Scanner pl2 = new Scanner(System.in);
            play2 = pl2.next();
        }else{
            play2 = "Computer";
        }

        // TicTacToe game creation with the two players and mode
        TicTacToe game = new TicTacToe(play1, play2, md1);

        // Play 10 TicTacToe Games
        while (numberOfGames < 10) {

            // Play until player 1 loses
            while ((winner == 0 || winner == 1 || winner == 3) && numberOfGames < totalNumberOfGames) {
                // 2 Players
                if(md1 == 1){
                    winner = game.play2p(game.player1, game.player2);
                }

                // VS Computer
                if(md1 ==2){
                    winner = game.playComputer(game.player1, game.player2);
                }

                // Player 1 wins
                if (winner == 1) {
                    game.player1Score++;
                    game.classification();
                    numberOfGames++;
                }

                // Draw
                if (winner == 3) {
                    game.draws++;
                    game.classification();
                    numberOfGames++;
                }

                // Player 2 wins
                if (winner == 2) {
                    game.player2Score++;
                    game.classification();
                    numberOfGames++;
                }

            }

            winner = 1;

            // Play until player 2 loses
            while ((winner == 1 || winner == 3) && numberOfGames < 10) {

                // 2 Players
                if(md1 == 1){
                    winner = game.play2p(game.player2, game.player1);
                }

                // VS Computer
                if(md1 == 2){
                    winner = game.playComputer(game.player2, game.player1);
                }

                // Player 2 wins
                if (winner == 1) {
                    game.player2Score++;
                    game.classification();
                    numberOfGames++;
                }

                // Draw
                if (winner == 3) {
                    game.draws++;
                    game.classification();
                    numberOfGames++;
                }

                // Player 1 wins
                if (winner == 2) {
                    game.player1Score++;
                    game.classification();
                    numberOfGames++;
                }

            }

            winner = 0;

        }
    }

}