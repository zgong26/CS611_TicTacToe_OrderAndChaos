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
	private OrderAndChaosTeam t1;
	private OrderAndChaosTeam t2;

	public OrderAndChaosGame(boolean additionalRule) {
		board = new OrderAndChaosBoard(additionalRule);
		round = 0;
		in = new Scanner(System.in);
		O = new Chess("O");
		X = new Chess("X");
		A = new OrderAndChaosPlayer("Order", O);
		B = new OrderAndChaosPlayer("Chaos", X);
		t1 = new OrderAndChaosTeam();
		t2 = new OrderAndChaosTeam();
	}

	@Override
	public void start() {

		boolean ifContinue;
		System.out.println("Welcome to Order and Chaos!");
		System.out.print("Team 1, enter your name: ");
		String name = in.nextLine();
		t1.setName(name);
		System.out.print("Team 2, enter your name: ");
		name = in.nextLine();
		t2.setName(name);
		do {
			round++;
			System.out.printf("Round %d\n", round);
			A = t1.getRandomPlayer();
			B = t2.getRandomPlayer();
			System.out.printf("\n\nTeam 1, player %s is selected.\nTeam 2, player %s is selected\n", A.getName(),
					B.getName());
			ifContinue = gameLoop(board, A, B, t1, t2);
		} while (ifContinue);
	}

	@Override
	public void end() {
		System.out.printf("Game Over!\nTeam %s has score of %d, Team %s has score of %d.\n", t1.getName(),
				t1.getScore(), t2.getName(), t2.getScore());
		if (t1.getScore() == t2.getScore()) {
			System.out.println("It's a draw!");
		} else
			System.out.printf("Team %s wins!\n", t1.getScore() > t2.getScore() ? t1.getName() : t2.getName());
	}

	private boolean gameLoop(OrderAndChaosBoard board, OrderAndChaosPlayer A, OrderAndChaosPlayer B,
			OrderAndChaosTeam t1, OrderAndChaosTeam t2) {
		String input = "";
		OrderAndChaosPlayer currPlayer = A;
		OrderAndChaosTeam currTeam = t1;
		boolean turn = true;
		boolean validPlace = false;
		board.clear();
		while (board.getStatus().equals("pending")) {
			System.out.println(board);
			String order_chaos = "Order";
			if (turn) {
				currTeam = t1;
				currPlayer = A;
				order_chaos = "Order";
			} else {
				currTeam = t2;
				currPlayer = B;
				order_chaos = "Chaos";
			}
			System.out.printf("Team %s, Player %s(%s) Enter your move and chess(O/X) separated by comma: ",
					currTeam.getName(), currPlayer.getName(), order_chaos);
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
			System.out.printf("It's a draw! Team %s(Chaos) wins!!\n", t2.getName());
			t2.addScore(1);
			B.addScore(1);
		} else {
			System.out.printf("Team %s(Order) wins!\n", t1.getName());
			t1.addScore(1);
			A.addScore(1);
		}
		System.out.printf("Current status: round %d \nScore: \nTeam %s: %d \nTeam %s: %d\n\n", round, t1.getName(),
				t1.getScore(), t2.getName(), t2.getScore());
		System.out.print("Would you like to continue? (y/N) ");
		input = in.nextLine().toLowerCase();
		while ((!input.equals("y")) && (!input.equals("n"))) {
			System.out.print("Invalid input\nWould you like to continue? (y/N) ");
			input = in.nextLine().toLowerCase();
		}
		return input.equals("y");
	}
}
