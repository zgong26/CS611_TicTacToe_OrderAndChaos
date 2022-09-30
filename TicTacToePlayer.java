
public class TicTacToePlayer extends Player {
	private Chess chess;

	public TicTacToePlayer(String name, Chess chess) {
		super(name);
		this.chess = chess;
	}

	public TicTacToePlayer(String name) {
		super(name);
	}

	public TicTacToePlayer() {
		super();
	}

	public String getChess() {
		return chess.getName();
	}

	public void setChess(Chess chess) {
		this.chess = chess;
	}
}
