package multithreading.executorCallableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class CompletableFutureTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
	/*	CompletableFuture<Void> compFuture  = CompletableFuture.runAsync(()-> {
			try {
				TimeUnit.SECONDS.sleep(1);
				
			} catch(InterruptedException e) {
				throw new IllegalStateException();
			}		
			System.out.println("� ���� �������� � ��������� ������, � �� � �������.");
		});		
		compFuture.get();*/
		
//-------------------------------------------------------------------------------------------------------		
	
		// ������ ����������� ������, �������� �������� Supplier(����� ������ get)
/*		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
		        try {
		            TimeUnit.SECONDS.sleep(1);
		        } catch (InterruptedException e) {
		            throw new IllegalStateException(e);
		        }
		        return "��������� ����������� ������";
    	});
		 
		// ���������� � ��������� ���������� Future
		String result = future.get();
		System.out.println(result);		*/
		
		/*
		 * �� ������ ����������������: ������, runAsync() � supplyAsync() ����������� � ��������� ������,
		 * �� �� ���� ����� �� ��������� ����� �����, �����?
         * �����! CompletableFuture ��������� ��� ������ � ������,
         *  ���������� �� ����������� ForkJoinPool.commonPool().
		 */
		/*
		 * ����� �� ������ ������� ��� ������� � �������� ��� ������� runAsync() � supplyAsync(),
		 *  ����� ��� ��������� ���� ������ � ������, ���������� ��� �� ������ ���� �������.
		 */
		
//----------------------------------------------------------------------------------------------------------
		//thenApply()
		// ������ CompletableFuture
		CompletableFuture<String> whatsYourNameFuture = CompletableFuture.supplyAsync(() -> {
		   try {
		       TimeUnit.SECONDS.sleep(1);
		   } catch (InterruptedException e) {
		       throw new IllegalStateException(e);
		   }
		   return "Rajeev";
		});
		 
		// ��������� ������ � Future, ��������� thenApply()
		CompletableFuture<String> greetingFuture = whatsYourNameFuture.thenApply(name -> {
		    return "������," + name;
		});
		 
		// ���������� � ��������� ���������� Future
		System.out.println(greetingFuture.get()); // ������, Rajeev
		
//----------------------------------------------------------------------------------------------------
		CompletableFuture<String> welcomeText = CompletableFuture.supplyAsync(() -> {
		    try {
		        TimeUnit.SECONDS.sleep(1);
		    } catch (InterruptedException e) {
		       throw new IllegalStateException(e);
		    }
		    return "Rajeev";
		}).thenApply(name -> {
		    return "������," + name;
		}).thenApply(greeting -> {
		    return greeting + ". ����� ���������� � ���� CalliCoder";
		});
		 
		System.out.println(welcomeText.get());
		// �������: ������, Rajeev. ����� ���������� � ���� CalliCoder
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
