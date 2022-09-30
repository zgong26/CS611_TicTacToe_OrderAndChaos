
public class OrderAndChaosBoard extends Board {
	private final int sideLength;
	private int chessCount;
	private boolean additionalRule;

	public OrderAndChaosBoard(boolean additionalRule) {
		super(6);
		sideLength = 6;
		chessCount = 0;
		this.additionalRule = additionalRule;
	}

	public int getSideLength() {
		return sideLength;
	}

	public boolean place(int num, OrderAndChaosPlayer player) {
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

	private String checkStatus(int x, int y, String chess) {
		// check horizontal
		for (int i = 0; i < sideLength; i++) {
			String pre = "";
			int count = 0;
			int maxCount = 0;
			for (int j = 0; j < sideLength; j++) {
				String curr = board[i][j];
				if (curr.equals("")) {
					pre = "";
					count = 0;
				} else if (curr.equals(pre)) {
					count++;
				} else {
					pre = curr;
					count = 1;
				}
				maxCount = Math.max(maxCount, count);
			}
			if (maxCount == 5 && additionalRule) {
				return chess;
			}
			if (maxCount >= 5 && !additionalRule) {
				return chess;
			}
		}
		// check vertical
		for (int i = 0; i < sideLength; i++) {
			String pre = "";
			int count = 0;
			int maxCount = 0;
			for (int j = 0; j < sideLength; j++) {
				String curr = board[j][i];
				if (curr.equals("")) {
					pre = "";
					count = 0;
				} else if (curr.equals(pre)) {
					count++;
				} else {
					pre = curr;
					count = 1;
				}
				maxCount = Math.max(maxCount, count);
			}
			if (maxCount == 5 && additionalRule) {
				return chess;
			}
			if (maxCount >= 5 && !additionalRule) {
				return chess;
			}
		}
		// check diagonal((0,0) -> (sideLength - 1,sideLength - 1))
		String pre = "";
		int count = 0;
		int maxCount = 0;
		for (int i = 0, j = 0; i < sideLength; i++, j++) {
			String curr = board[i][j];
			if (curr.equals("")) {
				pre = "";
				count = 0;
			} else if (curr.equals(pre)) {
				count++;
			} else {
				pre = curr;
				count = 1;
			}
			maxCount = Math.max(maxCount, count);
		}
		if (maxCount == 5 && additionalRule) {
			return chess;
		}
		if (maxCount >= 5 && !additionalRule) {
			return chess;
		}
		// check diagonal(starts from (0,1))
		pre = board[0][1];
		count = 0;
		maxCount = 0;
		for (int i = 0; i <= 4; i++) {
			String curr = board[i][i + 1];
			if (!curr.equals(pre))
				break;
			count++;
		}
		if (count == 5 && !pre.equals("")) {
			return chess;
		}
		// check diagonal(starts from (1,0))
		pre = board[1][0];
		count = 0;
		for (int i = 1; i <= 5; i++) {
			String curr = board[i][i - 1];
			if (!curr.equals(pre))
				break;
			count++;
		}
		if (count == 5 && !pre.equals("")) {
			return chess;
		}

		// check the other diagonal
		pre = "";
		count = 0;
		for (int i = 0, j = sideLength - 1; i < sideLength; i++, j--) {
			String curr = board[i][j];
			if (curr.equals("")) {
				pre = "";
				count = 0;
			} else if (curr.equals(pre)) {
				count++;
			} else {
				pre = curr;
				count = 1;
			}
			maxCount = Math.max(maxCount, count);
		}
		if (maxCount == 5 && additionalRule) {
			return chess;
		}
		if (maxCount >= 5 && !additionalRule) {
			return chess;
		}

		// same two short diagonals
		pre = board[0][4];
		count = 0;
		for (int i = 0, j = 4; i <= 4; i++, j--) {
			String curr = board[i][j];
			if (!curr.equals(pre))
				break;
			count++;
		}
		if (count == 5 && !pre.equals("")) {
			return chess;
		}

		pre = board[1][5];
		count = 0;
		for (int i = 1, j = 5; i <= 5; i++, j--) {
			String curr = board[i][j];
			if (!curr.equals(pre))
				break;
			count++;
		}
		if (count == 5 && !pre.equals(""))
		{
			return chess;
		}

		if (chessCount < sideLength * sideLength)
			return "pending";
		return "draw";
	}
}
