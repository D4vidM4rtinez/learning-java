package practica5_DavidMartinez;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	/**
	 * @param p one object of type Persona
	 */
	public static void mostrarPersona(Persona p) {
		p.mostrarPersona();
	}

	/**
	 * @param p an array of objects of type Persona
	 */
	public static void iterarPersona(Persona[] p) {
		System.out.println("");
		for (int i = 0; i < p.length; i++) {
			mostrarPersona(p[i]);
		}
		System.out.println("");

	}

	public static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// generate the first array of players
		Jugador[] jugadores1 = new Jugador[3];
		jugadores1[0] = new Jugador(20, "Adria", 10);
		jugadores1[1] = new Jugador(29, "Elias", 5);
		jugadores1[2] = new Jugador(32, "Martin", 2);
		
		//generate the second array of players
		Jugador[] jugadores2 = new Jugador[3];
		jugadores2[0] = new Jugador(21, "Oscar", 7);
		jugadores2[1] = new Jugador(22, "Alex", 1);
		jugadores2[2] = new Jugador(25, "Esteban", 4);
		
		//create each team with each different array of players
		Equip equipA = new Equip(jugadores1, "EquipA");
		Equip equipB = new Equip(jugadores2, "EquipB");
		
		// generate the referee array
		Arbitre[] arbitros = new Arbitre[2];
		arbitros[0] = new Arbitre(25, "Artur", 2);
		arbitros[1] = new Arbitre(27, "Francisca", 1);
		
		// generate the match with the teams and referees
		Partit partit = new Partit(0, equipA, equipB, 0, 0, arbitros);
		
		//generate a object of type Selector
		Selector selec = new Selector("1- Sumar temps;2- Incrementar marcador equip A;"
				+ "3- Incrementar marcador equip B;4- Mostrar equip A;5- Mostrar equip B;"
				+ "6- Mostrar resum partit;7- Mostrar arbirtres", 7);

		do {
			switch (selec.choseOption(sc)) {
			case 1:
				System.out.print("Introdueix el numero de minuts que vols sumar al temps: ");
				try {
					int addTime = sc.nextInt();
					if (addTime >= 0) {
						partit.setTime(partit.getTime() + addTime);
					} else {
						System.out.println("la maquina del temps encara no ha estat inventada\n");
					}
					
				} catch (InputMismatchException e) {
					System.out.println("ERROR: introduce un numero");
				}
				break;
			case 2:
				System.out.println("+1 al marcador del equip A \n");
				partit.setMarcadorA(partit.getMarcadorA() + 1);
				break;
			case 3:
				System.out.println("+1 al marcador del equip B \n");
				partit.setMarcadorB(partit.getMarcadorB() + 1);
				break;
			case 4:
				iterarPersona(equipA.getJugadors());
				break;
			case 5:
				iterarPersona(equipB.getJugadors());
				break;
			case 6:
				partit.resumPartit();
				break;
			case 7:
				iterarPersona(arbitros);
				break;
			}
		} while (partit.getTime() <= 60);
		sc.close();
	}

}