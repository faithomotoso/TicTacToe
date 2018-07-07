import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static String[][] board = new String[3][3];
    private static String blueprint;
    private static String player;
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("============ Welcome to the Tic Tac Toe Game ============");

        blueprint = " __ ";
        setBoard();
        printBoard();

        setPlayer();

        if (player.equals("x")) {
            playerX();
        } else if (player.equals("o")) {
            playerO();
        }
    }

    private static void playerX() {
        int moves = 9;
        int x, y, computerX, computerY;
        String cord;

//        Player
        while (moves > 0) {
            System.out.print("\nEnter x and y co-ordinates separated with a space: ");
            cord = input.nextLine();
            x = Integer.parseInt(cord.split(" ")[0]);
            y = Integer.parseInt(cord.split(" ")[1]);

            while (true) {
                if (board[x][y] != " __ ") {
                    System.out.println("That spot has been played, try again.");
                    cord = input.nextLine();
                    x = Integer.parseInt(cord.split(" ")[0]);
                    y = Integer.parseInt(cord.split(" ")[1]);
                }

                if (board[x][y] == " __ ") {
                    board[x][y] = "  x ";
                    break;
                }
            }
            printBoard();
            moves--;
            if (checkBoard()) {
                break;
            }

            if (moves == 0 && !checkBoard()) {
                System.out.println("Draw!");
                break;
            }

//            Computer
            computerX = (int) (Math.random() * 3);
            computerY = (int) (Math.random() * 3);
            while (true) {
                if (board[computerX][computerY] != " __ ") {
                    computerX = (int) (Math.random() * 3);
                    computerY = (int) (Math.random() * 3);
                }

                if (board[computerX][computerY] == " __ ") {
                    board[computerX][computerY] = "  o ";
                    break;
                }
            }
            System.out.print("");
            printBoard();
            moves--;
            if (checkBoard()) {
                break;
            }
        }
    }

    private static void playerO() {
        int moves = 9;
        int x, y, computerX, computerY;
        String cord;

//        Player
        while (moves > 0) {
            System.out.print("\nEnter x and y co-ordinates separated with a space: ");
            cord = input.nextLine();
            x = Integer.parseInt(cord.split(" ")[0]);
            y = Integer.parseInt(cord.split(" ")[1]);

            while (true) {
                if (board[x][y] != " __ ") {
                    System.out.println("That spot has been played, try again.");
                    cord = input.nextLine();
                    x = Integer.parseInt(cord.split(" ")[0]);
                    y = Integer.parseInt(cord.split(" ")[1]);
                }

                if (board[x][y] == " __ ") {
                    board[x][y] = "  o ";
                    break;
                }
            }
            printBoard();
            moves--;
            if (checkBoard()) {
                break;
            }

            if (moves == 0 && !checkBoard()) {
                System.out.println("Draw!");
                break;
            }

//            Computer
            computerX = (int) (Math.random() * 3);
            computerY = (int) (Math.random() * 3);
            while (true) {
                if (board[computerX][computerY] != " __ ") {
                    computerX = (int) (Math.random() * 3);
                    computerY = (int) (Math.random() * 3);
                }

                if (board[computerX][computerY] == " __ ") {
                    board[computerX][computerY] = "  x ";
                    break;
                }
            }
            System.out.print("");
            printBoard();
            moves--;
            if (checkBoard()) {
                break;
            }
        }
    }

    private static void setPlayer() {
        System.out.print("Choose a player (x or o): ");
        player = input.nextLine();

        boolean check = false;
        while (!check) {
            if (!player.equals("x") && !player.equals("o")) {
                System.out.println("Invalid, try again.");
                System.out.print("Choose a player (x or o): ");
                player = input.nextLine();
            } else {
                check = true;
                System.out.println("You chose: " + player);
            }
        }
    }

    private static void setBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = blueprint;
            }
        }
    }

    private static void printBoard() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }

    private static boolean checkBoard() {

        if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && board[2][2] == "  x ") {
            System.out.println("x wins!");
            return true;
        } else if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && board[2][2] == "  o ") {
            System.out.println("o wins!");
            return true;
        }

        if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && board[2][0] == "  x ") {
            System.out.println("x wins!");
            return true;
        } else if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && board[2][0] == "  o ") {
            System.out.println("o wins!");
            return true;
        }

        if (board[0][0].equals(board[0][1]) && board[0][1].equals(board[0][2]) && board[0][2] == "  x ") {
            System.out.println("x wins!");
            return true;
        } else if (board[0][0].equals(board[0][1]) && board[0][1].equals(board[0][2]) && board[0][2] == "  o ") {
            System.out.println("o wins!");
            return true;
        }

        if (board[1][0].equals(board[1][1]) && board[1][1].equals(board[1][2]) && board[1][2] == "  x ") {
            System.out.println("x wins!");
            return true;
        } else if (board[1][0].equals(board[1][1]) && board[1][1].equals(board[1][2]) && board[1][2] == "  o ") {
            System.out.println("o wins!");
            return true;
        }

        if (board[2][0].equals(board[2][1]) && board[2][1].equals(board[2][2]) && board[2][2] == "  x ") {
            System.out.println("x wins!");
            return true;
        } else if (board[2][0].equals(board[2][1]) && board[2][1].equals(board[2][2]) && board[2][2] == "  o ") {
            System.out.println("o wins!");
            return true;
        }

        if (board[0][0].equals(board[1][0]) && board[1][0].equals(board[2][0]) && board[2][0] == "  x ") {
            System.out.println("x wins!");
            return true;
        } else if (board[0][0].equals(board[1][0]) && board[1][0].equals(board[2][0]) && board[2][0] == "  o ") {
            System.out.println("o wins!");
            return true;
        }

        if (board[0][1].equals(board[1][1]) && board[1][1].equals(board[2][1]) && board[2][1] == "  x ") {
            System.out.println("x wins!");
            return true;
        } else if (board[0][1].equals(board[1][1]) && board[1][1].equals(board[2][1]) && board[2][1] == "  o ") {
            System.out.println("o wins!");
            return true;
        }

        if (board[0][2].equals(board[1][2]) && board[1][2].equals(board[2][2]) && board[2][2] == "  x ") {
            System.out.println("x wins!");
            return true;
        } else if (board[0][2].equals(board[1][2]) && board[1][2].equals(board[2][2]) && board[2][2] == "  o ") {
            System.out.println("o wins!");
            return true;
        }
        return false;
    }
}
