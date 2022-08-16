package org.kodluyoruz;

public abstract class Player {
	private String name;
	private int score;
	private int x;
	private int y;
	private char ch;
	
	public Player(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public char getCh() {
		return ch;
	}
	public void setCh(char ch) {
		this.ch = ch;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	abstract void play(int size);  
	
}
