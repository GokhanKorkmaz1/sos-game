package org.kodluyoruz;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game {
	private Player human;
	private Player computer;
	private Board board;
	private boolean turn;
	Random random = new Random();
	Scanner scanner = new Scanner(System.in);

	// Setter and Getters

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public boolean isTurn() {
		return turn;
	}
	
	public void setTurn(boolean turn) {
		this.turn = turn;
	}

	public Game() {
		init();
	}
	

	// Commands to start the game
	public void init() {
		
		// The player reference represents the player and the computer reference represents the computer.
		// The superclass of these two references is the Player class.
		human = new Human("Human", 0);
		computer = new Computer("Computer", 0);
		
		System.out.println("Welcome to the SOS Game!");
		System.out.println("Please enter a number to identify the game field.");
		
		try {
			board = new Board(scanner.nextInt(), 0);
		}catch (InputMismatchException e) {
			board = new Board(5, 0);
			System.out.println("Wrong input type\nSize assigned (5) minimum value.");
		}
		turn = random.nextBoolean();
		
		gameLoop();
	}
	
	public void gameLoop() {
		int x, y, turnScore;
		char ch;
		
		while(true) {
			
			Player p = playbyTurn(turn);
			
			x = p.getX();
			y = p.getY();
			ch= p.getCh();

			if(board.drawLetter(x, y, ch)) {
				
				turnScore = board.calculateScore();
				updateScore(turnScore);
				board.drawScore(human);
				board.drawScore(computer);
				
				// If the player does not score, the turn passes to the opposing player.
				turn=checkTurnByScore(turnScore, turn);
			}
			gameOverCheck();
		}
	}
	
	// Assigns the next player's reference to p. It also fills the required values ​​by running the play method of the player class.
	public Player playbyTurn(boolean turn) {
		if(turn) {
			human.play(board.getSize());
			return human;
		}
		computer.play(board.getSize());	
		return computer;
	}
	
	
	public void updateScore(int score) {
		if(turn) {
			human.setScore(human.getScore() + score);
		}
		else {
			computer.setScore(computer.getScore() + score);
		}
	}
	
	public boolean checkTurnByScore(int turnScore, boolean turn) {
		if(turnScore >= 1)
			return turn;
		return !turn;
	}
	
	public void drawResult() {
		String result="\n";
		if(human.getScore()>computer.getScore())
			result += human.getName() + " won!";
		else if(computer.getScore()>human.getScore())
			result += computer.getName() + " won!";
		else
			result += "Draw";
		
		System.out.println(result);
	}
	
	public void gameOverCheck() {
		if(board.action == Math.pow(board.getSize(),2) ) {
			drawResult();
			return;
		}
	}
}
