import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playerA;
        String playerB;
        String playAgain;

        do {
            playerA = getPlayerMove(scanner, "Player A");
            playerB = getPlayerMove(scanner, "Player B");

            // Determine the winner and display the result
            String result = determineWinner(playerA, playerB);
            System.out.println(result);

            // Prompt to play again
            System.out.print("Do you want to play again? [Y/N]: ");
            playAgain = scanner.nextLine().trim().toUpperCase();
        } while (playAgain.equals("Y"));

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    public static String getPlayerMove(Scanner scanner, String player) {
        String move;
        do {
            System.out.print(player + ", enter your move (R/P/S): ");
            move = scanner.nextLine().trim().toUpperCase();
            if (!isValidMove(move)) {
                System.out.println("Invalid move. Please enter R, P, or S.");
            }
        } while (!isValidMove(move));
        return move;
    }

    public static boolean isValidMove(String move) {
        return move.equals("R") || move.equals("P") || move.equals("S");
    }

    public static String determineWinner(String moveA, String moveB) {
        if (moveA.equals(moveB)) {
            return "It's a Tie! Both players chose " + moveA;
        }

        switch (moveA) {
            case "R":
                return (moveB.equals("S")) ? "Rock breaks Scissors. Player A wins!" : "Paper covers Rock. Player B wins!";
            case "P":
                return (moveB.equals("R")) ? "Paper covers Rock. Player A wins!" : "Scissors cuts Paper. Player B wins!";
            case "S":
                return (moveB.equals("P")) ? "Scissors cuts Paper. Player A wins!" : "Rock breaks Scissors. Player B wins!";
            default:
                return "Invalid move.";
        }
    }
}