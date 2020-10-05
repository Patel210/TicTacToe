package com.training.tictactoegame;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeGame {
	private static char[] board;
	private static final Scanner SC = new Scanner(System.in);
	private static char USER, COMPUTER;

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
		if (USER == 'X' || USER == 'O')
			COMPUTER = (USER == 'X') ? 'O' : 'X';
		else {
			System.out.println("Strictly enter (X or O)");
			chooseCharacterForUser();
		}
	}
	
	/**
	 *  To view the board 
	 */
	private static void showBoard() {
		for (int i = 1; i < board.length; i++) {
			System.out.print("[" + board[i] + "]");
			if (i % 3 == 0) {
				System.out.println("\n---------");

			}
		}
	}

	public static void main(String[] args) {
		createBoard();
		chooseCharacterForUser();
		showBoard();
	}
}
