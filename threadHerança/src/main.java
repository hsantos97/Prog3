
public class main {
	public static void main(String[] args)
	{
		//Criando as threads
		minhaThread t1 = new minhaThread(1);
		minhaThread t2 = new minhaThread(2);
		
		//executa as threads
		t1.start();
		t2.start();
		
		//faz a thread pricipal esperar por t1 e t2
		try
		{
			t1.join();
			t2.join();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
		System.out.println("Encerrando a thread principal !!");
	}
}
