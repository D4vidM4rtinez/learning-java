package objetos;

public class Equip {
	private Jugador[] jugadors = new Jugador[3];
	private String nom;

	public Equip() {
		Jugador[] jugador = new Jugador[1];
		setJugadors(jugador);
		setNom("noHiHaNom");
	}

	/**
	 * 
	 * @param jugadors array de jugadores
	 * @param nom      nombre del equipo
	 */
	public Equip(Jugador[] jugadors, String nom) {
		this();
		setJugadors(jugadors);
		setNom(nom);
	}

	public Jugador[] getJugadors() {
		return jugadors;
	}

	public void setJugadors(Jugador[] jugadors) {
		this.jugadors = jugadors;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
