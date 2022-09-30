import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		gameBody();
	}

	private static void gameBody() {
		Scanner in = new Scanner(System.in);
		String ifContinue = "y";
		while (ifContinue.equals("y")) {
			System.out.println("Which game would you like to play? \n1. Tic-Tac-Toe\n2. Order and Chaos");
			String ans = in.nextLine();
			while ((!ans.equals("1")) && (!ans.equals("2"))) {
				System.out.println("Invalid input. Please enter 1 or 2.");
				ans = in.nextLine();
			}
			if (ans.equals("1")) {
				System.out.println("Please enter the board size(side length): ");
				int size = ErrorControl.integerInput(1, 9);
				BoardGame tictactoe = new TicTacToeGame(size);
				tictactoe.start();
				tictactoe.end();
			} else {
				System.out.println("Would you like to play it with the additional rule?(y/N) ");
				System.out.println(
						"Additional rule implies that the only winning condition for Order is to have exact 5 consecutive pieces, 6 doesn't count");
				String input = in.nextLine().toLowerCase();
				while ((!input.equals("y")) && (!input.equals("n"))) {
					System.out.print("Invalid input\nDo you want the additional rule?(y/N) ");
					input = in.nextLine().toLowerCase();
				}
				boolean rule = input.equals("y");
				BoardGame OrderAndChaos = new OrderAndChaosGame(rule);
				OrderAndChaos.start();
				OrderAndChaos.end();
			}
			System.out.println("\nWould you like to play another game?(y/N)");
			ifContinue = in.nextLine();
		}
		System.out.println("Game Over");
	}
}
