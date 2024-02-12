package assig3_3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Please Type How Many Salads To Prepare:");
		Scanner scan = new Scanner(System.in);
		final int numOfSaladsToPrepare = scan.nextInt();
		System.out.println("Preparing " + numOfSaladsToPrepare + " Salads...");

		
		 // Create instances of the slicer machine and threads for cucumbers, tomatoes, and slicing
		SlicerMachine slicerMachine= new SlicerMachine();
		CucumbersThread cucumbersThread = new CucumbersThread(slicerMachine);
		TomatoesThread tomatoesThread = new TomatoesThread(slicerMachine);
		SlicerThread slicerThread = new SlicerThread(slicerMachine, numOfSaladsToPrepare);
		
		// Start the threads for cucumbers, tomatoes, and slicing
		cucumbersThread.start();
		tomatoesThread.start();
		slicerThread.start();
	
		// Wait for slicer thread to complete
		try {
			slicerThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Stop cucumber and tomato threads after slicer thread completes
		cucumbersThread.interrupt();
		tomatoesThread.interrupt();

		// Wait for cucumber and tomato threads to complete
		try {
			cucumbersThread.join();
			tomatoesThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		System.out.println("Done");
		scan.close();
	}

}
