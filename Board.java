public class Board {
	private int length;
	private int width;
	private String[][] displayBoard;// use for numbering each empty square
	protected String[][] board;// use for internal board tracking
	protected String status;// win, pending, draw, or N/A

	// Initialize a rectangle board
	public Board(int length, int width) {
		this.length = length;
		this.width = width;
		status = "pending";
		board = new String[width][length];
		displayBoard = new String[width][length];
		int number = 1;
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < length; j++) {
				board[i][j] = "";
				displayBoard[i][j] = String.valueOf(number++);
			}
		}
	}

	// Initialize a square board
	public Board(int side) {
		this(side, side);
	}

	// default a 3X3 square
	public Board() {
		this(3);
	}

	public int getLength() {
		return length;
	}

	public int getWidth() {
		return width;
	}

	public boolean place(int num, Player player) {
		num--;
		int x = num / length;
		int y = num % length;
		if (board[x][y] != "") {
			return false;
		}
		board[x][y] = player.getName();
		status = checkStatus();
		return true;
	}

	protected String checkStatus() {
		return "N/A";
	}

	public String getStatus() {
		return status;
	}

	public void clear() {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < length; j++) {
				board[i][j] = "";
			}
		}
		status = "pending";
	}

	// for drawing "+--+--" pattern
	private String drawLine1() {
		String str = "";
		for (int i = 0; i < length; i++) {
			str += "+--";
		}
		str += "+\n";
		return str;
	}

	// for drawing "| | " pattern
	private String drawLine2(int row) {
		String str = "";
		for (int i = 0; i < length; i++) {
			str += "|";
			if (board[row][i].equals(""))
				str += displayBoard[row][i].length() == 1 ? displayBoard[row][i] + " " : displayBoard[row][i];// avoid
																												// indent
																												// error
			else
				str += board[row][i].length() == 1 ? board[row][i] + " " : board[row][i];
		}
		str += "|\n";
		return str;
	}

	public int getNumOfSquares() {
		return length * width;
	}

	public String toString() {
		String boardStr = "";
		for (int i = 0; i < width; i++) {
			boardStr += drawLine1();
			boardStr += drawLine2(i);
		}
		boardStr += drawLine1();
		return boardStr;
	}
}
