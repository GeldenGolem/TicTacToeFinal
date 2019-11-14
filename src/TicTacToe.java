import java.util.Scanner;

public class TicTacToe{
    public static int row, col;
    public static Scanner scan = new Scanner(System.in); //inputs scanner
    public static char[][] board = new char [3][3]; //sets maximum for array
    public static char turn ='X'; //sets initial turn to X

    public static void main(String[] args) { //creates the bottom of the grids
        //main algorithm
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                board[i][j] = '_';
            }
        }
        PLAY();
    }

    public static void PLAY(){
        boolean playing = true; //print board when playing
        PRINTBOARD();
        while (playing){
            System.out.println("Please enter a row and column (Between 1 and 3): ");
            row = scan.nextInt() -1;
            col = scan.nextInt() -1;
            if (row >= 3) {
                System.out.println("Please Enter a Number between 1 and 3");
            }
            else if (row >3) {
                System.out.println("You cannot play a column higher than the number 3, PLEASE Enter a Number between 1 and 3");
                row = scan.nextInt() -1;
            }

            if (col >= 3) {
                System.out.println("Please Enter a Number between 1 and 3");
            }
            else if (col>3) {
                System.out.println("You cannot play a row higher than the number 3, PLEASE Enter a Number between 1 and 3");
                col = scan.nextInt() -1;
            }
            board [row][col] = turn;
            if(GAMEOVER(row,col)){
                playing = false;
                System.out.print("Game over! Player " + turn+ " wins!");
            }

            PRINTBOARD(); //creates the turns
            if(turn == 'X'){
                turn = '0';
            }
            else{
                turn = 'X';
            }
        }
    }

    public static void PRINTBOARD() {   //this method creates the walls of the grids
        //main algorithm
        for (int i = 0; i < 3; i++) {
            System.out.println();
            for (int j = 0; j < 3; j++) {
                if (j==0)
                    System.out.print("| ");
                System.out.print(board[i][j] + " | ");

            }

        }
        System.out.println();
    }

    public static boolean GAMEOVER(int rMove, int cMove){ //creates instances for winning and losing
        //main algorithm
        if (board[0][cMove] == board [1][cMove]
                && board [0][cMove] == board[2][cMove]) {
            return true;
        }
        if (board[rMove][0] == board [rMove][1]
                && board [rMove][0] == board[rMove][2]) {
            return true;
        }
        if (board[0][0] == board [1][1]
                && board [0][0] == board[2][2]
                && board[1][1] != '_'){
            return true;
        }
        if (board[0][2] == board [1][1]
                && board [0][2] == board[2][0]
                && board[1][1] != '_'){
            return true;
        }
        return false;
    }
}