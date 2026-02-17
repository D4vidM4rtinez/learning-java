package programacion;

import java.util.Scanner;

public class TresEnRallav3 {
	// Initialises the scanner, tried to initialise it and close it inside the
	// program and it wouldn't work
	static final Scanner sc = new Scanner(System.in);

	// variable is here to be sure every time i want to use '-' gets the same
	// character
	public static final char voidToken = '-';

	public static void main(String[] args) {
		// using 3d array to save both players into a same "variable"
		// { { { 0, 0 }, { 0, 0 }, { 0, 0 } }, { { 0, 0 }, { 0, 0 }, { 0, 0 } } };
		int[][][] moves = new int[2][3][2];

		// new int[1][2][3];
		// { { { 0 }, { 0 }, { 0 } }, { { 0 }, { 0 }, { 0 } } }

		// @ Deprecated
		// the arrays that save the moves of each player, they are initialised to 0 so
		// you can reference positions
		// final int[][] movesp1 = new int[3][2];
		// final int[][] movesp2 = new int[3][2];
		// { { 0, 0 }, { 0, 0 }, { 0, 0 } };

		final int[][] magicSquare = { { 2, 7, 6 }, { 9, 5, 1 }, { 4, 3, 8 } };

		final char[] tokens = { 'X', 'O' };
		byte player = 0;
		int roundCount = 1;
		final char[][] board = { { voidToken, voidToken, voidToken }, { voidToken, voidToken, voidToken },
				{ voidToken, voidToken, voidToken } };
		showBoard(board);
		boolean end = false;
		boolean win = false;

		do {
			// player change logic, also adds one to the round counter each time both turns
			// have passed
			if (player > 1) {
				player = 0;
				roundCount++;
			}

			// gets the position the player wants to operate on
			System.out.println("Es el turno del jugador " + (player + 1));
			int[] position = getCoordinates(board);
			changeBoard(board, tokens[player], position);

			// logic to call the correct array of saved moves and erase the oldest move if
			// necessary
			if (roundCount > 3) {
				erraseOldestMove(board, moves[player]);
			}
			saveMoves(position, moves[player], roundCount);

			showBoard(board);

			// starts to check if anyone won
			win = didSomeoneWin(moves[player], magicSquare);

			if (!win) {
				// no one won but the board is completely filled
				if (isGameFinished(board)) {
					System.out.println("ningun jugador ha ganado");
					end = true;
				}
			} else {
				// someone got 3 of their tokens in a line
				System.out.println("el jugador " + (player + 1) + " ha ganado");
				end = true;
			}

			// makes it so the turns change
			player++;
		} while (!end);
		sc.close();
	}

	/**
	 * function checks for the round and if its round3 or earlier it saves the move
	 * in the corresponding position, if its a later round it moves all the current
	 * moves one position "lower" and in the last position saves the newest move
	 * 
	 * @param move       : the last move made by the player
	 * @param totalMoves : all saved moves of the player
	 * @param round      : the round number
	 */
	public static void saveMoves(int[] move, int[][] totalMoves, int round) {
		if (round <= 3) {
			totalMoves[round - 1][0] = move[0];
			totalMoves[round - 1][1] = move[1];
		} else {
			totalMoves[0][0] = totalMoves[1][0];
			totalMoves[0][1] = totalMoves[1][1];
			totalMoves[1][0] = totalMoves[2][0];
			totalMoves[1][1] = totalMoves[2][1];
			totalMoves[2][0] = move[0];
			totalMoves[2][1] = move[1];
		}
	}

	/**
	 * changes the board so the oldest token of the player is errased
	 * 
	 * @param board : the game board
	 * @param moves : the saved moves of the player
	 */
	public static void erraseOldestMove(char[][] board, int[][] moves) {
		board[moves[0][0]][moves[0][1]] = voidToken;
	}

	/**
	 * checks if the board is filled with tokens or if there is still some spaces
	 * 
	 * @param board: the game board
	 * @return true if there is still spaces and false if there are not
	 */
	public static boolean isGameFinished(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (char c : board[i]) {
				if (c == voidToken) {
					return (false);
				}
			}
		}
		return (true);
	}

	/**
	 * uses for loops to check if any line and column of the board has been
	 * completed with matching sets of tokens
	 * 
	 * @param bo:  is the game board
	 * @param tok: the token it needs to check, (normally the one associated with
	 *             the last player that moved)
	 * @return
	 */
	public static boolean didSomeoneWin(int[][] moves, int[][] magicSquare) {
		int eval = magicSquare[moves[0][0]][moves[0][1]] + magicSquare[moves[1][0]][moves[1][1]]
				+ magicSquare[moves[2][0]][moves[2][1]];
		if (eval == 15) {
			return(true);
		}
		return (false);
	}

	/**
	 * shows the board in the correct formatting way
	 * 
	 * @param board: the game board
	 */
	public static void showBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (j != board[i].length - 1) {
					System.out.print(board[i][j]);
				} else {
					System.out.println(board[i][j]);
				}
			}
		}
	}

	/**
	 * calls the other functions needed to modify a board and changes it
	 * 
	 * @param board: the game board
	 * @param token: the token to insert into the board
	 */
	public static void changeBoard(char[][] board, char token, int[] position) {
		board[position[0]][position[1]] = token;

	}

	/**
	 * checks if the position introduced by the user can be modified
	 * 
	 * @param position: the array containing the positions
	 * @param arr:      the game board
	 * @return
	 */
	public static boolean checkIfCanModify(int[] position, char[][] arr) {
		try {
			if (arr[position[0]][position[1]] != voidToken) {
				System.out.println("Las coordenadas introducidas ya tienen una ficha");
				return (false);
			} else {
				return (true);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ERROR: uno de los numeros introducidos es mas grande que 3 o menor que 1");
			return (false);
		}
	}

	/**
	 * asks the user for the coordinates to modify
	 * 
	 * @param board: the game board
	 * @return the array with the coordinates properly turned integers
	 */
	public static int[] getCoordinates(char[][] board) {
		int[] cordinate = new int[2];
		boolean error;
		do {
			error = false;
			System.out.print(
					"introduce las coordenadas [1 a 3] que quieras modificar en la tabla separadas por una coma: ");
			String t = sc.nextLine();
			String[] temp = t.split(",");
			try {
				cordinate[0] = Integer.parseInt(temp[0]) - 1;
				cordinate[1] = Integer.parseInt(temp[1]) - 1;
				// catches for any thing that the user introduced that is not a number and if
				// the numbers are not separated by ','
			} catch (NumberFormatException e) {
				System.out.println("ERROR: introduce numeros separados por ' , ' porfavor");
				error = true;
				// catches if the user did not introduce 2 numbers
			} catch (IndexOutOfBoundsException e) {
				System.out.println("ERROR: introduce dos numeros porfavor");
				error = true;
			}
		} while (!checkIfCanModify(cordinate, board) || error);

		return cordinate;
	}

}
