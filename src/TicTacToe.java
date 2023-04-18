import java.util.Scanner;

public class TicTacToe {

    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board[][] = new String[ROW][COL];

    public static void main (String[] args) {
        clearBoard();
        display();
        int moveCnt = 0;
        String player = "X";
        do {
            int rowMove = -1;
            int colMove = -1;

            do {
                rowMove = SafeInput.getRangedInt(new Scanner(System.in), "Player " + player+ ", Enter the row (1-3): ", 1, 3);
                colMove = SafeInput.getRangedInt(new Scanner(System.in), "Player " + player+ ", Enter the column (1-3):", 1, 3);
                rowMove = rowMove - 1;
                colMove = colMove - 1;

                if (!isValidMove(rowMove, colMove)) {
                    System.out.println("Invalid move. Please try again.");
                }
            } while (!isValidMove(rowMove, colMove));

            board[rowMove][colMove] = player;
            moveCnt++;
            display();

            if (isWin(player)) {
                System.out.println(player + " wins!");
                if (!playAgain()) {
                    break;
                }
                clearBoard();
            }

            if (moveCnt >= 7) {
                if (isTie()) {
                    System.out.println("Tie game!");
                    if (!playAgain()) {
                        break;
                    }
                }
            }

            if(player.equalsIgnoreCase("X")){
                player = "O";
            }else {
                player = "X";
            }

        } while (true);
    }


    private static void clearBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = "";
            }
        }
    } // sets all the board elements to a space

    private static void display() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("");
        }

    } // shows the Tic Tac Toe game used as part of the promt for the users move choice…

    private static boolean isValidMove(int row, int col) {
        if (row >= 0 && row <= 2 & col >= 0 && col <= 2  && board[row][col].equalsIgnoreCase("")) {
            return true;
        }
        return false;
    } // returns true if there is a space at the given proposed move coordinates which means it is a legal move.

    private static boolean isWin(String player) {
        if (isColWin(player) || isRowWin(player) || isDiagnalWin(player)) {
            return true;
        }
        return false;

    }// checks to see if there is a win state on the current board for the specified player (X or O) This method in turn calls three additional methods that break down the 3 kinds of wins that are possible.

    private static boolean isColWin(String player) {
        if (board[0][0].equalsIgnoreCase(player) &&
                board[1][0].equalsIgnoreCase(player) &&
                board[2][0].equalsIgnoreCase(player)) {
            return true;
        } else if (board[0][1].equalsIgnoreCase(player) &&
                board[1][1].equalsIgnoreCase(player) &&
                board[2][1].equalsIgnoreCase(player)) {
            return true;
        } else if (board[0][2].equalsIgnoreCase(player) &&
                board[1][2].equalsIgnoreCase(player) &&
                board[2][2].equalsIgnoreCase(player)) {
            return true;
        }

        return false;
    }// checks for a col win for specified player

    private static boolean isRowWin(String player) {
        if (board[0][0].equalsIgnoreCase(player) &&
                board[0][1].equalsIgnoreCase(player) &&
                board[0][2].equalsIgnoreCase(player)) {
            return true;
        } else if (board[1][0].equalsIgnoreCase(player) &&
                board[1][1].equalsIgnoreCase(player) &&
                board[1][2].equalsIgnoreCase(player)) {
            return true;
        } else if (board[2][0].equalsIgnoreCase(player) &&
                board[2][1].equalsIgnoreCase(player) &&
                board[2][2].equalsIgnoreCase(player)) {
            return true;
        }

        return false;
    }// checks for a row win for the specified player

    private static boolean isDiagnalWin(String player) {
        if (board[0][0].equalsIgnoreCase(player) &&
                board[1][1].equalsIgnoreCase(player) &&
                board[2][2].equalsIgnoreCase(player)) {
            return true;
        } else if (board[0][2].equalsIgnoreCase(player) &&
                board[1][1].equalsIgnoreCase(player) &&
                board[2][0].equalsIgnoreCase(player)) {
            return true;
        }
        return false;
    } // checks for a diagonal win for the specified player

    private static boolean isTie() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].equalsIgnoreCase("")) {
                    return false;
                }
            }
        }
        return true;
    }// checks for a tie condition: all spaces on the board are filled OR there is an X and an O in every win vector (i.e. all possible 8 wins are blocked by having both and X and an O in them.)

    private static boolean playAgain() {
        return SafeInput.getYNConfirm(new Scanner(System.in), "Do you  want to play again");

    }

}


