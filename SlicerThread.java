package assig3_3;

public class SlicerThread extends Thread {
	
    private final SlicerMachine slicerMachine;
    private final int amountSalads;
    
    public SlicerThread (SlicerMachine slicerMachine , int amountSalads) {
    	this.slicerMachine=slicerMachine;
    	this.amountSalads=amountSalads;	
    }
    @Override
    public void run() {
    	while (!isInterrupted() && slicerMachine.getNumOfPreparedSalads() < amountSalads) { // Loop until the thread is interrupted or the desired number of salads is prepared
    		try {
                slicerMachine.sliceVegetables(); // Try to slice vegetables for another salad
            }
    		catch (InterruptedException e) {
            Thread.currentThread().interrupt();// If interrupted while waiting for vegetables, interrupt the thread again
    		}
    	}
    }
 }