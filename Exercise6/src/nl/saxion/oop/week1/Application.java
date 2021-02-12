package nl.saxion.oop.week1;

import nl.saxion.app.SaxionApp;

import java.util.ArrayList;

public class Application implements Runnable {
	public static void main(String[] args) {
		SaxionApp.start(new Application(),1000,600);
	}

	public void run() {


//		 We used the following code to produce the sample_output.png file
		BingoMill bm = new BingoMill();
		bm.shuffle();

		SaxionApp.printLine("Drawing 10 random numbers using the Bingo Mill!");
		for (int i = 0; i < 10; i++) {
			SaxionApp.printLine("Draw " + (i+1) + ": " + bm.draw() + " (" + bm.getNumberOfBallsRemaining() + " balls remaining)");
		}


	}
}
