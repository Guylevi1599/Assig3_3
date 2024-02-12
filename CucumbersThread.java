package assig3_3;

public class CucumbersThread extends Thread {
	
    private final SlicerMachine slicerMachine;
    
    public CucumbersThread (SlicerMachine slicerMachine) {
    	this.slicerMachine=slicerMachine;
    }
    @Override
    public void run(){ 
    	while (!Thread.currentThread().isInterrupted()) {  // Loop until the thread is interrupted
    		try {
    			slicerMachine.addOneCucumber(); // Add one cucumber to the slicer machine
    			Thread.sleep(1000);  // Sleep for 1 second
    		}	
			catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
			}
    	}
    }
}

    
   
    
    