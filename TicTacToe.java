import java.util.*;

public class TicTacToe {

    static ArrayList <Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList <Integer> cpuPositions = new ArrayList<Integer>();

    public static void main(String[] args) {

        char [] [] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        printGameBoard(gameBoard);
        /*
        while loop makes it so that the computer keeps
        asking the player to continue placing the pieces.
         */

        while (true){
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your placement (1-9):");
            int PlayerPos = scan.nextInt();
        /*
        this while loop is so that the computer does not play over
        the player's position.
         */
            while (playerPositions.contains(PlayerPos) ||
                    cpuPositions.contains(playerPositions)) {
                System.out.println("Position is taken, enter in another position.");
                PlayerPos = scan.nextInt();
            }

            placePiece(gameBoard, PlayerPos, "player");
        /*
        This is so that the computer generates its symbol randomly
        throughout the game board.
        */
            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;
            while (playerPositions.contains(cpuPos) ||
                    cpuPositions.contains(cpuPos)) {
                cpuPos = rand.nextInt(9) + 1;
            }
            placePiece(gameBoard, cpuPos, "cpu");

            printGameBoard(gameBoard);

            String winner = checkWinner();
            System.out.println(winner);
        }

    }
    public static void printGameBoard (char [][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }

    }
    /*
    This method is to identify the symbols the player
    and the cpu will be using
     */
    public static void placePiece (char [][] gameBoard, int pos, String user) {

        char symbol = ' ';
        if (user.equals("player")) {
            symbol = 'X';
            playerPositions.add(pos);
        } else if (user.equals("cpu")) {
            symbol = 'O';
            cpuPositions.add(pos);
        }

        switch (pos) {
            case 1:
                gameBoard [0][0] = symbol;
                break;
            case 2:
                gameBoard [0][2] = symbol;
                break;
            case 3:
                gameBoard [0][4] = symbol;
                break;
            case 4:
                gameBoard [2][0] = symbol;
                break;
            case 5:
                gameBoard [2][2] = symbol;
                break;
            case 6:
                gameBoard [2][4] = symbol;
                break;
            case 7:
                gameBoard [4][0] = symbol;
                break;
            case 8:
                gameBoard [4][2] = symbol;
                break;
            case 9:
                gameBoard [4][4] = symbol;
                break;
            default:
                break;
        }
    }
/*
This method is to represent all the win conditions.
 */
    public static String checkWinner() {

        List topRow = Arrays.asList(1, 2, 3);
        List middleRow = Arrays.asList(4, 5, 6);
        List bottomRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List middleCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(7, 5, 3);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(middleRow);
        winning.add(bottomRow);
        winning.add(leftCol);
        winning.add(middleCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);

        for (List l : winning) {
            if (playerPositions.containsAll(l)) {
                return " Yay, you won!!";
            } else if (cpuPositions.containsAll(l)) {
                return "Damn, you lost";
            } else if (playerPositions.size() + cpuPositions.size() == 9) {
                return "CAT";
            }
        }

        return "";
    }
}
