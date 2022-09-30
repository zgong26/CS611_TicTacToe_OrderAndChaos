import java.util.Arrays;

public class TicTacToeBoard extends Board {
	private int sideLength;
	private int[] rowCount;
	private int[] colCount;
	private int[] diagonalCount;
	private int chessCount;

	public TicTacToeBoard(int sideLength) {
		super(sideLength);
		this.sideLength = this.getLength();
		rowCount = new int[sideLength];
		colCount = new int[sideLength];
		diagonalCount = new int[2];
		chessCount = 0;
	}

	public int getSideLength() {
		return sideLength;
	}

	public boolean place(int num, TicTacToePlayer player) {
		num--;
		int x = num / sideLength;
		int y = num % sideLength;
		if (board[x][y] != "") {
			return false;
		}
		board[x][y] = player.getChess();
		chessCount++;
		status = checkStatus(x, y, player.getChess());
		return true;
	}

	@Override
	public void clear() {
		for (int i = 0; i < sideLength; i++) {
			for (int j = 0; j < sideLength; j++) {
				board[i][j] = "";
			}
		}
		status = "pending";
		Arrays.fill(rowCount, 0);
		Arrays.fill(colCount, 0);
		Arrays.fill(diagonalCount, 0);
		chessCount = 0;

	}

	private String checkStatus(int x, int y, String chess) {
		int adder = chess.equals("O") ? 1 : -1;
		rowCount[x] += adder;
		colCount[y] += adder;
		diagonalCount[0] += x == y ? adder : 0;
		diagonalCount[1] += sideLength - 1 - x == y ? adder : 0;
		if (Math.abs(rowCount[x]) == sideLength || Math.abs(colCount[y]) == sideLength
				|| Math.abs(diagonalCount[0]) == sideLength || Math.abs(diagonalCount[1]) == sideLength)
			return chess;
		if (chessCount < sideLength * sideLength)
			return "pending";
		return "draw";
	}
}
