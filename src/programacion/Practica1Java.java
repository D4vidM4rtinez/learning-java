package programacion;

import java.util.Scanner;

public class Practica1Java {

	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		System.out.print("introdueix el primer numero: ");
		int num1 = obj.nextInt();
		System.out.print("introdueix el numero a mirar si es permutacio: ");
		int num2 = obj.nextInt();
		obj.close();

		int[] permutArr = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		addNum(num1, permutArr, "+");
		addNum(num2, permutArr, "-");

		boolean value = evaluateArr(permutArr);
		if (value) {
			System.out.println("el numero es una permutacio");
		} else {
			System.out.println("el numero no es una permutacio");
		}
	}

	public static void addNum(int num, int[] arr, String mode) {
		while (num != 0) {
			int lastInt = num % 10;
			num = num / 10;
			if (mode == "+") {
				arr[lastInt]++;
			} else if (mode == "-") {
				arr[lastInt]--;
			}
		}
	}

	public static boolean evaluateArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				return false;
			}
		}
		return true;
	}
}
