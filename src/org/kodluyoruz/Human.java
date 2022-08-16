package org.kodluyoruz;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Human extends Player{

	Scanner scanner = new Scanner(System.in);
	
	public Human(String name, int score) {
		super(name, score);
		
	}

	@Override
	public void play(int size) {
		try {
			setX(scanner.nextInt());
			setY(scanner.nextInt());
			setCh(scanner.next(".").charAt(0));
		}catch (InputMismatchException e) {
			System.out.println("Please check the input values!");
			scanner.nextLine();
		}
		
	}
	
}
