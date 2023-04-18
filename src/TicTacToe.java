import java.util.Scanner;

    public class TicTacToe {

        private static final int ROW = 3;
        private static final int col = 3;

        private static void main(String[] args){
        clearBoard();
        display();

            while (isGameOver()) {
            int rowMove = -1;
            int colMove = -1;

            do{
                rowMove = SafeInput.getRangedInt(new Scanner(System.in)), "Enter the row (1-3): ",
                        colMove = SafeInput.getRangedInt(new Scanner(System.in)), "Enter the column (1-3):
                rowMove = rowMove -;
                colMove = colMove -;

                if (isVolidMove(rowMove , colMove)){
                    System.out.println("Invalid move. Please try again.");


                }
            }while(isVolidMove(colMove , colMove));

            board[rowMove][colMove] = player;
            moveCnt++;
            display();

            if(isWinplayer) {
                System.out.println(player + "wins!");
                if (playAgain()) {
                    break;
                }
                clearBoard();

            }

            if(moveCnt >= 7) {
            }
            if (isTie()){
            }
            System.out.println(Tie game!);
            if(playeAgain()) {
                break;
            }
            clearBoard();
        }
    }
}


}