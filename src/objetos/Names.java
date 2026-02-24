package objetos;

public class Names {
	private String name;
	public Names() {
		this.name= "DefaultName";
	}
	public Names(String name) {
		this.setName(name);
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
