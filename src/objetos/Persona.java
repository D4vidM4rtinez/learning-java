package objetos;

public class Persona {
	private int age;
	private String name;

	public Persona() {
		this.age = 0;
		this.name = "noName";
	}

	/**
	 * 
	 * @param age  edad de la persona
	 * @param name nombre de la persona
	 */
	public Persona(int age, String name) {
		this();
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

	public void mostrarPersona() {
		System.out.println(this.name + ", " + this.age + " anys");
	}
}
