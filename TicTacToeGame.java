import java.util.Scanner;

public class TicTacToeGame extends BoardGame {
	private Scanner in;
	private Chess O;
	private Chess X;
	private TicTacToePlayer A;
	private TicTacToePlayer B;
	private TicTacToeTeam t1;
	private TicTacToeTeam t2;
	private TicTacToeBoard board;
	private int round;

	public TicTacToeGame(int size) {
		in = new Scanner(System.in);
		O = new Chess("O");
		X = new Chess("X");
		A = new TicTacToePlayer("O", O);
		B = new TicTacToePlayer("X", X);
		t1 = new TicTacToeTeam();
		t2 = new TicTacToeTeam();
		board = new TicTacToeBoard(size);
		round = 0;
	}

	public TicTacToeGame() {
		this(3);
	}

	@Override
	public void start() {
		boolean ifContinue;
		System.out.println("Welcome to Tic-Tac-Toe!");
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
			A.setChess(O);
			B = t2.getRandomPlayer();
			B.setChess(X);
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

	private boolean gameLoop(TicTacToeBoard board, TicTacToePlayer A, TicTacToePlayer B, TicTacToeTeam t1,
			TicTacToeTeam t2) {
		String input = "";
		TicTacToePlayer currPlayer = A;
		TicTacToeTeam currTeam = t1;
		boolean turn = true;
		boolean validPlace = false;
		board.clear();
		while (board.getStatus().equals("pending")) {
			System.out.println(board);
			if (turn) {
				currTeam = t1;
				currPlayer = A;
			} else {
				currTeam = t2;
				currPlayer = B;
			}
			System.out.printf("Team %s, Player %s Enter your move: ", currTeam.getName(), currPlayer.getName());
			input = ErrorControl.cellInput(board.getNumOfSquares());
			validPlace = board.place(Integer.parseInt(input), currPlayer);
			while (!validPlace) {
				System.out.println("Cannot be placed on the square. Please retry");
				input = ErrorControl.cellInput(board.getNumOfSquares());
				validPlace = board.place(Integer.parseInt(input), currPlayer);
			}
			turn = !turn;
		}
		System.out.print(board);
		if (board.getStatus().equals("draw")) {
			System.out.println("It's a draw!");
		} else {
			System.out.printf("Player %s from team %s wins!\n", currPlayer.getName(), currTeam.getName());
			currPlayer.addScore(1);
			currTeam.addScore(1);
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
