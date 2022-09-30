
public class OrderAndChaosPlayer extends Player {
	private Chess chess;

	public OrderAndChaosPlayer(String name, Chess chess) {
		super(name);
		this.chess = chess;
	}

	public OrderAndChaosPlayer(String name) {
		super(name);
	}

	public OrderAndChaosPlayer() {
		super();
	}

	public String getChess() {
		return chess.getName();
	}

	public void setChess(Chess chess) {
		this.chess = chess;
	}
}
