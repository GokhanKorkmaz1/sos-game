package org.kodluyoruz;

import java.util.InputMismatchException;

public class Board {
	private int size;
	char [][]board;
	int score, action;
	
	// Setter and Getters
	public int getSize() {
		return size;
	}

	public void setSize(int size) throws InputMismatchException {
		if(size <5 || size >10) {
			try {
				throw new InvalidSizeException("Invalid set size");
			}catch (InvalidSizeException e) {
				e.printStackTrace();
				this.size = 5;
				System.out.println("Size assigned (" + getSize() + ") minimum value.");
			}
		}
		else {
			this.size = size;
		}
	}

	public char[][] getBoard() {
		return board;
	}

	public void setBoard(char[][] board) {
		this.board = board;
	}

	public Board(int size, int score) {
		setSize(size);
		this.score = score;
		action=0;
		board = new char[getSize()][getSize()];
		drawBoard();
	}
	
	public void drawBoard() {
		drawNumbersVertical();
		
		for (int j = 0; j < board.length; j++) {
			System.out.print(" " + (j+1) + " ");
			for (int i = 0; i < board[j].length; i++) {
				if(board[i][j] == 83)
					System.out.print(" S ");
				else if(board[i][j] == 79)
					System.out.print(" O ");
				else
					System.out.print("   ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void drawNumbersVertical() {
		System.out.println();
		for (int i = 0; i < size+1; i++) {
			System.out.print(" " + i + " ");
		}
		System.out.println();
	}
	
	public void drawScore(Player p) {
		System.out.print( p.getName() + " : " + p.getScore() + " ");
	}
	
	public boolean drawLetter(int x, int y, char ch) {
		if(x<1 || x>size) {
			System.out.println("Incorrect x entry");
			return false;
		}
		if(y<1 || y>size) {
			System.out.println("Incorrect y entry");
			return false;
		}
		
		if( ch != 83 && ch != 115 && ch != 79 && ch != 111) {
			System.out.println("Incorrect character input, only 'S' and 'O' are accepted.");
			return false;
		}
		
		if(board[x-1][y-1] == 83  || board[x-1][y-1] == 79) {
			System.out.println("It's already full");
			return false;
		}
		
		board[x-1][y-1] = (char) (ch >=111 ? ch-32: ch);
		action++;
		drawBoard();
		return true;
	}
	
	public int calculateScore() {
		int turnScore=0;
		for (int i = 0; i < board.length-2; i++) {
			for (int j = 0; j < board[i].length-2; j++) {
				if(board[i][j]==83 && i<board.length-2) {
					if(board[i+1][j] == 79 && board[i+2][j] == 83) {
						turnScore++;
					}
				}
				if(board[i][j]==83 && j<board.length-2) {
					if(board[i][j+1] == 79 && board[i][j+2] == 83) {
						turnScore++;
					}
				}
				if(board[i][j]==83 && i<board.length-2 && j<board.length-2) {
					if(board[i+1][j+1] == 79 && board[i+2][j+2] == 83) {
						turnScore++;
					}
				}
				if(board[i][j]==83 && i>1 && j>1 && i<board.length-2 && j<board.length-2) {
					if(board[i-1][j+1] == 79 && board[i-2][j+2] == 83) {
						turnScore++;
					}
				}
				if(board[i][j]==83 && i>=board.length-2) {
					if(board[i][j+1] == 79 && board[i][j+2] == 83) {
						turnScore++;
					}
				}
				if(board[i][j]==83 && j>=board.length-2) {
					if(board[i+1][j] == 79 && board[i+2][j] == 83) {
						turnScore++;
					}
				}
			}
		}
				
		int temp = turnScore - score;
		score = turnScore;
		return temp;
	}
		
}
