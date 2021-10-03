
public class main {
	public static void main(String[] artgs)
	{
		//cria uma thread
		Runnable r1 = () ->{
			while(true)
			{
				System.out.println("Thread da lambda !!");
				if(Thread.currentThread().isInterrupted())
				{
					System.out.println("Alguem quer me interromper ...");
					return;
				}
			}
		};
		
		//cria e executa a thread
		Thread t1 = new Thread(r1);
		t1.start();
		
		//faz a thread principal esperar por t1
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		//interromper a thread r1
		t1.interrupt();
		
		try {
			t1.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Encerrando a thread principal !!");
	}
}
