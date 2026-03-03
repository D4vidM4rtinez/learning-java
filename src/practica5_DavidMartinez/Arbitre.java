package practica5_DavidMartinez;

public class Arbitre extends Persona {
	private int license;

	/**
	 * 
	 * @param age     edad del arbitro
	 * @param name    nombre del arbitro
	 * @param license numero de licencia del arbitro
	 */
	public Arbitre() {
		super();
		license = 0;
	}

	/**
	 * 
	 * @param age     edad del arbitro
	 * @param name    nombre del arbitro
	 * @param license numero de licencia del arbitro
	 */
	public Arbitre(int age, String name, int license) {
		super(age, name);
		setLicense(license);
	}

	public int getLicense() {
		return license;
	}

	public void setLicense(int license) {
		this.license = license;
	}

	@Override
	public void mostrarPersona() {
		System.out.println(super.getName() + ", " + super.getAge() + " anys, numero " + this.getLicense());
	}
}
