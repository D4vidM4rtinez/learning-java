package objetos;

public class Persona {
	private int age;
	private String name;

	public Persona() {
		this(15, "Pruna");
	}

	public Persona(int age, String name) {
		this.setAge(age);
		this.setName(name);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age > 0 && age < 99) {
			this.age = age;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
