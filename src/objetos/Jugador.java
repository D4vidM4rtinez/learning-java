package objetos;

public class Jugador extends Persona {
	private int dorsal;

	public Jugador() {
		super();
		this.dorsal = 0;
	}

	/**
	 * 
	 * @param age    edad del jugador
	 * @param name   nombre del jugador
	 * @param dorsal numero del jugador
	 */
	public Jugador(int age, String name, int dorsal) {
		super(age, name);
		this.setDorsal(dorsal);
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	@Override
	public void mostrarPersona() {
		System.out.println(super.getName() + ", " + super.getAge() + " anys, numero" + this.getDorsal());
	}
}
