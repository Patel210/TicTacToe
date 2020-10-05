package com.training.tictactoegame;

import java.util.Arrays;

public class TicTacToeGame {
	private static char[] board;
	
	private static void createBoard() {
		board = new char[10];
		Arrays.fill(board, ' ');
	}
	
	public static void main(String[] args) {
		createBoard();
	}
}
