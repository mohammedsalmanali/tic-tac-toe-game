package com.mohammedsalmanali.games.TicTacToe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public String[] board = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    public String player1;
    public String player2;
    public int player1Score = 0;
    public int player2Score = 0;
    public int draws = 0;
    public int mode;

    private boolean shouldBreak;
    private int winner;
    private Scanner s1;
    private int inp1;
    private int min = 0;
    private int max = 9;
    private int randInt;

    /**
     * Constructs a new TicTacToe Game
     *
     * @param  p1 The player 1 name
     * @param p2 The player 2 name
     * @param md The playing mode, 1 for 2 Players, 2 to play against computer
     *
     */
    public TicTacToe(String p1, String p2, int md) {

        player1 = p1;
        player2 = p2;
        mode = md;

    }

    /**
     * Function that prints the actual playing board
     *
     */
    public void printBoard(){
        System.out.println("  " + board[0] + "  |  " + board[1] + "  |  " + board[2] + "  ");
        System.out.println("----- ----- -----");
        System.out.println("  " + board[3] + "  |  " + board[4] + "  |  " + board[5] + "  ");
        System.out.println("----- ----- -----");
        System.out.println("  " + board[6] + "  |  " + board[7] + "  |  " + board[8] + "  ");
    }

    /**
     * Function that cleans the playing board for a new game
     *
     */
    public void cleanBoard(){

        board[0] = "1";
        board[1] = "2";
        board[2] = "3";
        board[3] = "4";
        board[4] = "5";
        board[5] = "6";
        board[6] = "7";
        board[7] = "8";
        board[8] = "9";

    }

    /**
     * Function that implements a 2 player game
     *
     * @param  p1 The player 1 name
     * @param p2 The player 2 name
     * @return winner Return the winner of the game, 1 for player 1, 2 for player 2 and 3 for Draw
     *
     */
    public int play2p(String pl1, String pl2) {

        winner = 0;

        cleanBoard();

        System.out.println("New Game:");

        printBoard();

        while (winner == 0) {

            System.out.println(pl1 + " turn (X):");
            s1 = new Scanner(System.in);

            while (!s1.hasNextInt()) {

                System.out.println("Please Enter a valid number between 1 and 9");
                s1 = new Scanner(System.in);

            }

            inp1 = s1.nextInt();
            inp1 = inp1 - 1;

            while ((inp1 != 0) && (inp1 != 1) && (inp1 != 2) &&
                    (inp1 != 3) && (inp1 != 4) &&
                    (inp1 != 5) && (inp1 != 6) &&
                    (inp1 != 7) && (inp1 != 8)) {
                System.out.println("Please Enter a valid number between 1 and 9");
                s1 = new Scanner(System.in);
                while (!s1.hasNextInt()) {

                    System.out.println("Please Enter a valid number between 1 and 9");
                    s1 = new Scanner(System.in);

                }
                inp1 = s1.nextInt();
                inp1 = inp1 - 1;
            }

            while (board[inp1].equals("X") || board[inp1].equals("O")) {

                System.out.println("Position Occupied, please enter a valid position");
                s1 = new Scanner(System.in);
                while (!s1.hasNextInt()) {

                    System.out.println("Please Enter a valid number between 1 and 9");
                    s1 = new Scanner(System.in);

                }
                inp1 = s1.nextInt();
                inp1 = inp1 - 1;

            }

            board[inp1] = "X";

            printBoard();

            winner = checkWinner(pl1, pl2);

            shouldBreak = false;
            switch(winner){
                case 1:
                    shouldBreak = true;
                    break;
                case 2:
                    shouldBreak = true;
                    break;
                case 3:
                    shouldBreak = true;
                    break;
            }
            if (shouldBreak) {
                break;
            }

            System.out.println(pl2 + " turn (O):");
            s1 = new Scanner(System.in);

            while (!s1.hasNextInt()) {

                System.out.println("Please Enter a valid number between 1 and 9");
                s1 = new Scanner(System.in);

            }

            inp1 = s1.nextInt();
            inp1 = inp1 - 1;

            while ((inp1 != 0) && (inp1 != 1) && (inp1 != 2) &&
                    (inp1 != 3) && (inp1 != 4) &&
                    (inp1 != 5) && (inp1 != 6) &&
                    (inp1 != 7) && (inp1 != 8)) {
                System.out.println("Please Enter a valid number between 1 and 9");
                s1 = new Scanner(System.in);
                while (!s1.hasNextInt()) {

                    System.out.println("Please Enter a valid number between 1 and 9");
                    s1 = new Scanner(System.in);

                }
                inp1 = s1.nextInt();
                inp1 = inp1 - 1;
            }

            while (board[inp1].equals("X") || board[inp1].equals("O")) {

                System.out.println("Position Occupied, please enter a valid position");
                s1 = new Scanner(System.in);
                while (!s1.hasNextInt()) {

                    System.out.println("Please Enter a valid number between 1 and 9");
                    s1 = new Scanner(System.in);

                }
                inp1 = s1.nextInt();
                inp1 = inp1 - 1;

            }

            board[inp1] = "O";

            printBoard();

            winner = 0;

            winner = checkWinner(pl1, pl2);

            shouldBreak = false;
            switch(winner){
                case 1:
                    shouldBreak = true;
                    break;
                case 2:
                    shouldBreak = true;
                    break;
                case 3:
                    shouldBreak = true;
                    break;
            }
            if (shouldBreak) {
                break;
            }

        }
            return winner;

    }

    /**
     * Function that implements a game against the computer
     *
     * @param  pl1 The player 1 name
     * @param pl2 The player 2 name, by default is "Computer"
     * @return winner Return the winner of the game, 1 for player 1, 2 for player 2 and 3 for Draw
     *
     */
    public int playComputer(String pl1, String pl2) {

        winner = 0;
        inp1 = 0;

        cleanBoard();

        System.out.println("New Game:");

        printBoard();

        while (winner == 0) {
            //Player 1 turn
            if(!pl1.equals("Computer")) {


                System.out.println(pl1 + " turn (X):");
                s1 = new Scanner(System.in);

                while (!s1.hasNextInt()) {

                    System.out.println("Please Enter a valid number between 1 and 9");
                    s1 = new Scanner(System.in);

                }

                inp1 = s1.nextInt();
                inp1 = inp1 - 1;

                while ((inp1 != 0) && (inp1 != 1) && (inp1 != 2) &&
                        (inp1 != 3) && (inp1 != 4) &&
                        (inp1 != 5) && (inp1 != 6) &&
                        (inp1 != 7) && (inp1 != 8)) {
                    System.out.println("Please Enter a valid number between 1 and 9");
                    s1 = new Scanner(System.in);
                    while (!s1.hasNextInt()) {

                        System.out.println("Please Enter a valid number between 1 and 9");
                        s1 = new Scanner(System.in);

                    }
                    inp1 = s1.nextInt();
                    inp1 = inp1 - 1;
                }

                while (board[inp1].equals("X") || board[inp1].equals("O")) {

                    System.out.println("Position Occupied, please enter a valid position");
                    s1 = new Scanner(System.in);
                    while (!s1.hasNextInt()) {

                        System.out.println("Please Enter a valid number between 1 and 9");
                        s1 = new Scanner(System.in);

                    }
                    inp1 = s1.nextInt();
                    inp1 = inp1 - 1;

                }

            }else{

                //Computer turn

                System.out.println("Computer Played:");

                Random random = new Random();
                randInt = random.nextInt(max-min) + min;

                while(board[randInt].equals("X") || board[randInt].equals("O")){
                    randInt = random.nextInt(max-min) + min;
                }

                inp1 = randInt;
            }

            board[inp1] = "X";

            printBoard();

            winner = checkWinner(pl1, pl2);

            shouldBreak = false;
            switch(winner){
                case 1:
                    shouldBreak = true;
                    break;
                case 2:
                    shouldBreak = true;
                    break;
                case 3:
                    shouldBreak = true;
                    break;
            }
            if (shouldBreak) {
                break;
            }

            //Player 2 Turn
            if(!pl2.equals("Computer")) {

                System.out.println(pl2 + " turn (O):");
                s1 = new Scanner(System.in);

                while (!s1.hasNextInt()) {

                    System.out.println("Please Enter a valid number between 1 and 9");
                    s1 = new Scanner(System.in);

                }

                inp1 = s1.nextInt();
                inp1 = inp1 - 1;

                while ((inp1 != 0) && (inp1 != 1) && (inp1 != 2) &&
                        (inp1 != 3) && (inp1 != 4) &&
                        (inp1 != 5) && (inp1 != 6) &&
                        (inp1 != 7) && (inp1 != 8)) {
                    System.out.println("Please Enter a valid number between 1 and 9");
                    s1 = new Scanner(System.in);
                    while (!s1.hasNextInt()) {

                        System.out.println("Please Enter a valid number between 1 and 9");
                        s1 = new Scanner(System.in);

                    }
                    inp1 = s1.nextInt();
                    inp1 = inp1 - 1;
                }

                while (board[inp1].equals("X") || board[inp1].equals("O")) {

                    System.out.println("Position Occupied, please enter a valid position");
                    s1 = new Scanner(System.in);
                    while (!s1.hasNextInt()) {

                        System.out.println("Please Enter a valid number between 1 and 9");
                        s1 = new Scanner(System.in);

                    }
                    inp1 = s1.nextInt();
                    inp1 = inp1 - 1;

                }

            }else{

                //Computer turn

                System.out.println("Computer Played:");

                Random random = new Random();
                randInt = random.nextInt(max-min) + min;

                while(board[randInt].equals("X") || board[randInt].equals("O")){
                    randInt = random.nextInt(max-min) + min;
                }

                inp1 = randInt;

            }

            board[inp1] = "O";

            printBoard();

            winner = 0;

            winner = checkWinner(pl1, pl2);

            shouldBreak = false;
            switch(winner){
                case 1:
                    shouldBreak = true;
                    break;
                case 2:
                    shouldBreak = true;
                    break;
                case 3:
                    shouldBreak = true;
                    break;
            }
            if (shouldBreak) {
                break;
            }

        }
        return winner;

    }

    /**
     * Function that checks if a board of a game has a winner, or draw
     *
     * @param  pl1 The player 1 name
     * @param pl2 The player 2 name, by default is "Computer"
     * @return winner Return the winner of the game or draw, 1 for player 1, 2 for player 2 and 3 for Draw
     * Returns 0 if the game didn't end
     *
     */
    public int checkWinner(String play1, String play2) {

        // Auxiliary matrix of game positions:
        // 0 1 2
        // 3 4 5
        // 6 7 8

        // Player 1 wins
        if ((board[0].equals("X") && board[1].equals("X") && board[2].equals("X")) ||
                (board[0].equals("X") && board[4].equals("X") && board[8].equals("X")) ||
                (board[0].equals("X") && board[3].equals("X") && board[6].equals("X")) ||
                (board[1].equals("X") && board[4].equals("X") && board[7].equals("X")) ||
                (board[2].equals("X") && board[5].equals("X") && board[8].equals("X")) ||
                (board[2].equals("X") && board[4].equals("X") && board[6].equals("X")) ||
                (board[3].equals("X") && board[4].equals("X") && board[5].equals("X")) ||
                (board[6].equals("X") && board[7].equals("X") && board[8].equals("X"))){
            System.out.println("\n"+play1+" Wins (X)!\n");
            return 1;

        }

        // Player 2 wins
        if ((board[0].equals("O") && board[1].equals("O") && board[2].equals("O")) ||
                (board[0].equals("O") && board[4].equals("O") && board[8].equals("O")) ||
                (board[0].equals("O") && board[3].equals("O") && board[6].equals("O")) ||
                (board[1].equals("O") && board[4].equals("O") && board[7].equals("O")) ||
                (board[2].equals("O") && board[5].equals("O") && board[8].equals("O")) ||
                (board[2].equals("O") && board[4].equals("O") && board[6].equals("O")) ||
                (board[3].equals("O") && board[4].equals("O") && board[5].equals("O")) ||
                (board[6].equals("O") && board[7].equals("O") && board[8].equals("O"))){
            System.out.println("\n"+play2+" Wins (O)!\n");
            return 2;

        }

        // Draw condition
        if (!board[0].equals("1") && !board[1].equals("2") && !board[2].equals("3") &&
            !board[3].equals("4") && !board[4].equals("5") && !board[5].equals("6") &&
            !board[6].equals("7") && !board[7].equals("8") && !board[8].equals("9")){
            System.out.println("\n"+"Draw\n");
            return 3;

        }

        return 0;
    }

    /**
     * Function that prints the leaderboard of the game
     */
    public void classification(){
        System.out.println("Classification:");
        System.out.println(this.player1+" "+this.player1Score+" wins");
        System.out.println(this.player2+" "+this.player2Score+" wins");
        System.out.println("Draws: "+this.draws+"\n");
    }

}