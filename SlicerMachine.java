package assig3_3;

public class SlicerMachine {
	
	int numOfCucumbers = 0;
	int numOfTomatoes = 0;
	int numOfPreparedSalads = 0;
	
	final int cucumbersNeededForOneSalad = 3;
	final int tomatoesNeededForOneSalad = 2;
	
	// add one cucumber into the slicer chamber
	synchronized void addOneCucumber () throws InterruptedException {
		while (numOfCucumbers >= cucumbersNeededForOneSalad) {
			wait();// Wait until there's enough space in the slicer for another cucumber
		}
		System.out.println("adding one cucumber to the machine");
		numOfCucumbers++; // Increase the number of cucumbers in the slicer
		notifyAll(); // Notify waiting threads that there's space for more vegetables
	}

	// add one tomato into the slicer chamber
	synchronized void addOneTomato() throws InterruptedException {
		while (numOfTomatoes >= tomatoesNeededForOneSalad) { 
			wait();// Wait until there's enough space in the slicer for another tomato
		}
		System.out.println("adding one tomato to the machine");
		numOfTomatoes++;// Increase the number of tomatoes in the slicer
		notifyAll();// Notify waiting threads that there's space for more vegetables
	}
	
	// if there are enough vegetables in the slicer
	// chamber, make another salad
	synchronized void sliceVegetables() throws InterruptedException { 
		while ((numOfCucumbers < cucumbersNeededForOneSalad) || (numOfTomatoes < tomatoesNeededForOneSalad)) {
			wait(); // Wait until there are enough cucumbers and tomatoes for one salad
		}
		makeNewSalad(); // Increment the count of prepared salads
		notifyAll(); //Notify waiting threads that salad preparation is done
	}

	synchronized private void makeNewSalad() {
		System.out.println("== preparing one more salad ==");
		numOfPreparedSalads++; 
		// update stock
		numOfTomatoes = numOfTomatoes - tomatoesNeededForOneSalad;
		numOfCucumbers = numOfCucumbers - cucumbersNeededForOneSalad;
	}	
	
	int getNumOfPreparedSalads() {
		return numOfPreparedSalads;
	}

}
