
public class Chess {
	private String name;
	private String color;

	public Chess(String name, String color) {
		this.name = name;
		this.color = color;
	}

	public Chess(String name) {
		this(name, "WHITE");
	}

	public Chess() {
		this("chess");
	}

	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
