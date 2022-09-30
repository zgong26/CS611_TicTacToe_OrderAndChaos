
public class TicTacToeTeam implements Team<TicTacToePlayer> {
	private TicTacToePlayer p1;
	private TicTacToePlayer p2;
	private String name;
	private int score;

	public TicTacToeTeam(String name) {
		p1 = new TicTacToePlayer("P1");
		p2 = new TicTacToePlayer("P2");
		score = 0;
		this.name = name;
	}

	public TicTacToeTeam() {
		p1 = new TicTacToePlayer("P1");
		p2 = new TicTacToePlayer("P2");
		score = 0;
	}

	@Override
	public TicTacToePlayer getRandomPlayer() {
		double rand = Math.random();
		return rand < 0.5 ? p1 : p2;
	}

	@Override
	public int getScore() {
		return score;
	}

	@Override
	public void addScore(int i) {
		score += i;
	}

	public void addScore() {
		score++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
