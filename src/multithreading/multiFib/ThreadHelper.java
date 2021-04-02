package multithreading.multiFib;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadHelper {
	
//	public static void main(String[] args) throws Exception {
//		int sum = fib(23);
//		Thread.sleep(1000);
//		System.out.println("\nFib = " + sum);
//	}
	
	 public static int fib(final int numberToCalculate) throws Exception {
	        final FibCalculator fibCalculator = new FibCalculator(numberToCalculate);
	        fibCalculator.start();
	        fibCalculator.join();
	        return fibCalculator.getResult();
	    }

	    private static class FibCalculator extends Thread {
	        // BEGIN (write your solution here)
	    	final int numberToCalculate;
	    	static int counThrread = 0;
	    	static AtomicInteger result = new AtomicInteger(0);
	    	
	    	
	        public FibCalculator(int numberToCalculate) {
	        	this.numberToCalculate = numberToCalculate;
	        }
	    	
	    	public int getResult() {	
	    		System.out.println(counThrread);
	    		int fib = result.get();
	    		return fib;
	        }

			@Override
			public void run() {			
				try {
					threadFib(numberToCalculate-1);
					threadFib(numberToCalculate-2);	
				} catch (Exception e) {					
					e.printStackTrace();
				}						
			}
	    	
	    	private void threadFib(int num) throws Exception {
	    		
	    		if((num==1)||(num==2)) {
	    			result.incrementAndGet();
	    		} else {
	    			FibCalculator fibcal  = new FibCalculator(num);
	    			fibcal.start();
	    			fibcal.join();
	    		}
	    	}		
			
	        // END
	    }

}
