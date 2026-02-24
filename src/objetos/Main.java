package objetos;

public class Main {
	public static void mostrarPersona(Persona p) {
		p.mostrarPersona();
	}

	public static void main(String[] args) {
		Jugador jugador = new Jugador(21, "david", 3);

		mostrarPersona(jugador);
	}

}
