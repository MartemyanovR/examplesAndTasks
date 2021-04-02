package multithreading.runnable;

import java.util.Arrays;

public class MaxRunnable implements Runnable{	

	private final int[] target;
	private int result;
	
	public MaxRunnable(int[] target) {
		this.target=target;
	}
	
	@Override
	public void run() {
		
		result = Arrays.stream(target).max().getAsInt();
		
	}
	
	public int getResult() {
		return result;
	}

}
