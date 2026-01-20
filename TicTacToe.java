import java.util.Scanner;

public class TicTacToe {

    static char[][] board = new char[3][3];
    static char player = 'X';

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("TIC TAC TOE GAME");
        System.out.println("Enter row and column (0 to 2)");
        System.out.println("Example: 1 1\n");

        initBoard();

        int moves = 0;
        while (moves < 9) {
            printBoard();
            System.out.println("Player " + player + " turn:");
            int r = sc.nextInt();
            int c = sc.nextInt();

            if (r < 0 || r > 2 || c < 0 || c > 2 || board[r][c] != ' ') {
                System.out.println("Invalid move, try again.");
                continue;
            }

            board[r][c] = player;
            moves++;

            if (checkWin()) {
                printBoard();
                System.out.println("Player " + player + " wins!");
                return;
            }

            player = (player == 'X') ? 'O' : 'X';
        }

        printBoard();
        System.out.println("Game Draw!");
        sc.close();
    }

    static void initBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';
    }

    static void printBoard() {
        System.out.println("\nCurrent Board:");
        System.out.println("   0   1   2");
        for (int i = 0; i < 3; i++) {
            System.out.println("  +---+---+---+");
            System.out.print(i + " |");
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + board[i][j] + " |");
            }
            System.out.println();
        }
        System.out.println("  +---+---+---+");
    }

    static boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
                return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player)
                return true;
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
            return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
            return true;

        return false;
    }
}
