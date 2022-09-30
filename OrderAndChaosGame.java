import java.util.Scanner;
import java.util.Scanner;

public class OrderAndChaosGame extends BoardGame {
	private OrderAndChaosBoard board;
	private int round;
	private Scanner in;
	private Chess O;
	private Chess X;
	private OrderAndChaosPlayer A;
	private OrderAndChaosPlayer B;

	public OrderAndChaosGame(boolean additionalRule) {
		board = new OrderAndChaosBoard(additionalRule);
		round = 0;
		in = new Scanner(System.in);
		O = new Chess("O");
		X = new Chess("X");
		A = new OrderAndChaosPlayer("Order", O);
		B = new OrderAndChaosPlayer("Chaos", X);
	}

	@Override
	public void start() {
		
		
		boolean ifContinue;
		do {
			round++;
			System.out.printf("Round %d\n", round);
			ifContinue = gameLoop(board, A, B);
		} while (ifContinue);
	}

	@Override
	public void end() {
		System.out.printf("Game Over!\nPlayer %s has score of %d, Player %s has score of %d.\n", A.getName(),
				A.getScore(), B.getName(), B.getScore());
		if (A.getScore() == B.getScore()) {
			System.out.println("It's a draw!");
		} else
			System.out.printf("Player %s wins!\n", A.getScore() > B.getScore() ? A.getName() : B.getName());
	}

	private boolean gameLoop(OrderAndChaosBoard board, OrderAndChaosPlayer A, OrderAndChaosPlayer B) {
		String input = "";
		OrderAndChaosPlayer currPlayer = A;
		boolean turn = true;
		boolean validPlace = false;
		board.clear();
		while (board.getStatus().equals("pending")) {
			System.out.println(board);
			if (turn)
				currPlayer = A;
			else
				currPlayer = B;
			System.out.printf("Player %s Enter your move and chess(O/X) separated by comma: ", currPlayer.getName());
			// input = ErrorControl.cellInput(board.getNumOfSquares());
			input = ErrorControl.OCPlace();
			String[] inputArr = input.split(",");
			currPlayer.setChess(new Chess(inputArr[1]));
			validPlace = board.place(Integer.parseInt(inputArr[0]), currPlayer);
			while (!validPlace) {
				System.out.println("Cannot be placed on this square. Please retry");
				input = ErrorControl.OCPlace();
				inputArr = input.split(",");
				currPlayer.setChess(new Chess(inputArr[1]));
				validPlace = board.place(Integer.parseInt(inputArr[0]), currPlayer);
			}
			turn = !turn;
		}
		System.out.print(board);
		if (board.getStatus().equals("draw")) {
			System.out.println("It's a draw! Chaos wins!!");
			B.addScore(1);
		} else {
			System.out.printf("Order wins!\n");
			A.addScore(1);
		}
		System.out.printf("Current status: round %d \nScore: \nPlayer %s: %d \nPlayer %s: %d\n\n", round, A.getName(),
				A.getScore(), B.getName(), B.getScore());
		System.out.print("Would you like to continue? (y/N) ");
		input = in.nextLine().toLowerCase();
		while ((!input.equals("y")) && (!input.equals("n"))) {
			System.out.print("Invalid input\nWould you like to continue? (y/N) ");
			input = in.nextLine().toLowerCase();
		}
		return input.equals("y");
	}
}
