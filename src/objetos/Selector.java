package objetos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Selector {
	Scanner sc = new Scanner(System.in);
	private String options;
	private int numOptions;

	/**
	 * Constructor for a selector
	 * 
	 * @param options    a string with all the options separated by ";"
	 * @param numOptions the number of options being introduced
	 */
	public Selector(String options, int numOptions) {
		super();
		this.setNumOptions(numOptions);
		this.setOptions(options);
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public int getNumOptions() {
		return numOptions;
	}

	public void setNumOptions(int numOptions) {
		this.numOptions = numOptions;
	}

	private String[] formatThePrint() {
		return this.getOptions().split(";");
	}

	private void printSelector() {
		String[] strArr = formatThePrint();
		for (int i = 0; i < strArr.length; i++) {
			System.out.println(strArr[i]);
		}
	}

	public int choseOption(Scanner sc) {
		printSelector();

		int option = 0;
		boolean error = true;
		do {
			try {
				System.out.print("Introduce el numero de tu eleccion: ");
				option = sc.nextInt();
				if (option > 0 && option <= this.getNumOptions()) {
					error = false;
				} else {
					System.out.println("ERROR: introduce un numero entre 1 y " + this.getNumOptions());
				}
			} catch (InputMismatchException e) {
				System.out.println("ERROR: introduce un numero");
			}
		} while (error);
		return option;
	}
}
