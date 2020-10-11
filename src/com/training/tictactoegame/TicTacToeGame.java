package com.training.tictactoegame;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeGame {
	private static char[] board;
	private static final Scanner SC = new Scanner(System.in);
	private static char USER, COMPUTER;
	private static final int HEAD = 0, TAIL = 1;

	/**
	 * Initializing board with empty spaces
	 */
	private static void createBoard() {
		board = new char[10];
		Arrays.fill(board, ' ');
	}

	/**
	 * To decide the character of the user
	 */
	private static void chooseCharacterForUser() {
		System.out.println("Enter the Character you want to play for this game (X or O): ");
		USER = SC.next().charAt(0);
		if (USER == 'X' || USER == 'O') {
			COMPUTER = (USER == 'X') ? 'O' : 'X';
		} else {
			System.out.println("Strictly enter (X or O)");
			chooseCharacterForUser();
		}
	}

	/**
	 * To view the board
	 */
	private static void showBoard() {
		for (int i = 1; i < board.length; i++) {
			System.out.print("[" + board[i] + "]");
			if (i % 3 == 0) {
				System.out.println("\n---------");

			}
		}
	}

	/**
	 * To get the index by user for the move
	 */
	private static int getUserMove() {
		System.out.println("Enter the move (1 -9): ");
		int index = SC.nextInt();
		while (true) {
			if (index >= 1 && index <= 9 && isMovePossible(index)) {
				return index;
			}
		}
	}

	/**
	 * To check whether the move is possible
	 * 
	 */
	private static boolean isMovePossible(int index) {

		return board[index] == ' ';
	}

	/**
	 * To make the move
	 * 
	 */
	private static void makeMove(int index, char playChar) {
		board[index] = playChar;
	}

	/**
	 * Toss for deciding who plays first
	 */
	private static char whoPlaysFirst() {
		int toss = (int) (Math.random() * 10) % 2;
		return (toss == TAIL) ? COMPUTER : USER;

	}

	/**
	 * 
	 * To check for winning conditions
	 */
	private static boolean isWinner(char ch) {
		return ((board[1] == ch && board[2] == ch && board[3] == ch)
				|| (board[4] == ch && board[5] == ch && board[6] == ch)
				|| (board[7] == ch && board[8] == ch && board[9] == ch)
				|| (board[1] == ch && board[4] == ch && board[7] == ch)
				|| (board[2] == ch && board[5] == ch && board[8] == ch)
				|| (board[3] == ch && board[6] == ch && board[9] == ch)
				|| (board[1] == ch && board[5] == ch && board[9] == ch)
				|| (board[7] == ch && board[5] == ch && board[3] == ch));

	}

	/**
	 * returns corner position if any one of it is empty otherwise 0
	 */
	private static int getCornerPosition() {
		int[] cornerPosition = { 1, 3, 7, 9 };
		for (int corner : cornerPosition) {
			if (board[corner] == ' ') {
				return corner;
			}
		}
		return 0;
	}

	/**
	 * To get computer move
	 */
	private static int getComputerMove() {
		int move = getWinningMove(COMPUTER);
		if (move == 0) {
			move = getWinningMove(USER);
		}
		if (move == 0) {
			move = getCornerPosition();
		}
		if (move == 0) {
			move = (board[5] == ' ') ? 5 : 0;
		}
		if (move != 0) {
			return move;
		} else {
			while (true) {
				int index = (int) (Math.random() * 10) % 9 + 1;
				if (isMovePossible(index)) {
					return index;
				}
			}
		}
	}

	/**
	 * To get the winning move
	 * 
	 */
	private static int getWinningMove(char ch) {
		for (int i = 1; i < board.length; i++) {
			if (isMovePossible(i)) {
				makeMove(i, ch);
				if (isWinner(ch)) {
					board[i] = ' ';
					return i;

				}
				board[i] = ' ';
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		createBoard();
		chooseCharacterForUser();
		showBoard();
		whoPlaysFirst();
		makeMove(getUserMove(), USER);
		showBoard();
		makeMove(getComputerMove(), COMPUTER);
		showBoard();
	}
}
