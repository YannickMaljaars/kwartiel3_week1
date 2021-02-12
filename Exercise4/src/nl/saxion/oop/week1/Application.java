package nl.saxion.oop.week1;

import nl.saxion.app.SaxionApp;

public class Application implements Runnable {
	public static void main(String[] args) {
		SaxionApp.start(new Application(), 1000,500);
	}

	public void run() {

		Car car = new Car("Volvo","GH-34-SS",50,16);

		// Usage example, assume the car does 10 km to a litre gas:
		// myCar.getCurrentFuel(); --> Suppose this returns 50 litres
		// myCar.drive(100);
		// myCar.getCurrentFuel(); --> This should now return 40 litres

		int menuInput = -1;
		do {
			SaxionApp.clear();
			SaxionApp.printLine("***************************************");
			SaxionApp.printLine("* 1) Display statistics of the car ");
			SaxionApp.printLine("* 2) Drive some kilometers");
			SaxionApp.printLine("* 3) Refuel");
			SaxionApp.printLine("* 0) Exit program");
			SaxionApp.printLine("***************************************");

			SaxionApp.print("Please make a selection from the menu: ");
			menuInput = SaxionApp.readInt();

			SaxionApp.printLine();

			if(menuInput == 1) {

				SaxionApp.printLine(car.toString());

				SaxionApp.pause();
			} else if (menuInput == 2) {

				SaxionApp.print("How many kilometers do you want to drive? ");
				int input = SaxionApp.readInt();
				car.drive(input);

				SaxionApp.pause();
			} else if (menuInput == 3) {

				SaxionApp.print("How much liters of fuel do you want to fill your tank with? ");
				int l = SaxionApp.readInt();
				car.fuel(l);

				SaxionApp.pause();
			} else {
				SaxionApp.printLine("Goodbye!");
			}

		} while(menuInput != 0);
	}


}
