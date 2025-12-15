import java.util.Scanner;

public class TicTacToe {
    static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char player = 'X';
        boolean gameOver = false;

        while (!gameOver) {
            printBoard();
            System.out.println("Player " + player + ", enter row (0-2) and column (0-2): ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if (board[row][col] == ' ') {
                board[row][col] = player;

                if (checkWin(player)) {
                    printBoard();
                    System.out.println("Player " + player + " wins!");
                    gameOver = true;
                } else if (isBoardFull()) {
                    printBoard();
                    System.out.println("It's a draw!");
                    gameOver = true;
                } else {
                    player = (player == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Cell already filled. Try again.");
            }
        }
        sc.close();
    }

    static void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.println("| " + board[i][0] + " " + board[i][1] + " " + board[i][2] + " |");
        }
        System.out.println("---------");
    }

    static boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
                return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player)
                return true;
        }
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
               (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    static boolean isBoardFull() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == ' ')
                    return false;
        return true;
    }
}
