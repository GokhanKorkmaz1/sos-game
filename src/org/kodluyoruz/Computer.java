package org.kodluyoruz;

import java.util.Random;

public class Computer extends Player{

	Random random = new Random();
	public Computer(String name, int score) {
		super(name, score);
	}
	

	@Override
	public void play(int size) {
		setX(random.nextInt(1, size+1)); 
		setY(random.nextInt(1, size+1));
		setCh(random.nextBoolean() == true ? 'S' : 'O');
	}

}
