package assig3_3;

public class TomatoesThread extends Thread {
	
	private final SlicerMachine slicerMachine;
    
    public TomatoesThread (SlicerMachine slicerMachine) {
    	this.slicerMachine=slicerMachine;
    }
    
    public void run(){ 
    	while (!Thread.currentThread().isInterrupted()) { // Loop until the thread is interrupted
    		try {
    			slicerMachine.addOneTomato();// Add one tomato to the slicer machine
    			Thread.sleep(1000); // Sleep for 1 second
    		}	
			catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
			}
    	}
    }
}
