
public class main {
	public static void main(String[] args)
	{
		//cria objetos Runnable
		minhaThread r1 = new minhaThread(1);
		Runnable r2 = () -> {
			for(int i = 0; i < 10; i++)
			{
				System.out.println("Thread com lambda !!");
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		};
		
		//Cria e excuta as threads
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
		
		//faz thread principal esperar por t1 e t2
		try {
			t1.join();
			t2.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Encerrando a thread princiapl !!");
	}
}
