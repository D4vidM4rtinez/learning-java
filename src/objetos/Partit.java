package objetos;

public class Partit {
	private int time;
	private Equip equipA;
	private Equip equipB;
	private int marcadorA;
	private int marcadorB;
	private Arbitre[] arbitros = new Arbitre[2];

	/**
	 * 
	 * @param time      tiempo que lleva empezado el partido
	 * @param equipA    el equipo A
	 * @param equipB    el equipo B
	 * @param marcadorA el marcador del equipo A
	 * @param marcadorB el marcador del equipo B
	 * @param arbitros  un array de arbitros
	 */
	public Partit(int time, Equip equipA, Equip equipB, int marcadorA, int marcadorB, Arbitre[] arbitros) {
		setTime(time);
		setEquipA(equipA);
		setEquipB(equipB);
		setMarcadorA(marcadorA);
		setMarcadorB(marcadorB);
		setArbitros(arbitros);
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public Equip getEquipA() {
		return equipA;
	}

	public void setEquipA(Equip equipA) {
		this.equipA = equipA;
	}

	public Equip getEquipB() {
		return equipB;
	}

	public void setEquipB(Equip equipB) {
		this.equipB = equipB;
	}

	public int getMarcadorA() {
		return marcadorA;
	}

	public void setMarcadorA(int marcadorA) {
		this.marcadorA = marcadorA;
	}

	public int getMarcadorB() {
		return marcadorB;
	}

	public void setMarcadorB(int marcadorB) {
		this.marcadorB = marcadorB;
	}

	public Arbitre[] getArbitros() {
		return arbitros;
	}

	public void setArbitros(Arbitre[] arbitros) {
		this.arbitros = arbitros;
	}
	
	public void resumPartit() {
		System.out.println("Minut "+this.getTime()+": "+ equipA.getNom()+""+this.getMarcadorA()+" - "+ equipB.getNom()+""+this.getMarcadorB());
	}
}
