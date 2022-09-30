
public class OrderAndChaosTeam implements Team<OrderAndChaosPlayer> {
	private OrderAndChaosPlayer p1;
	private OrderAndChaosPlayer p2;
	private String name;
	private int score;

	public OrderAndChaosTeam(String name) {
		p1 = new OrderAndChaosPlayer("P1");
		p2 = new OrderAndChaosPlayer("P2");
		score = 0;
		this.name = name;
	}

	public OrderAndChaosTeam() {
		p1 = new OrderAndChaosPlayer("P1");
		p2 = new OrderAndChaosPlayer("P2");
		score = 0;
	}

	@Override
	public OrderAndChaosPlayer getRandomPlayer() {
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
