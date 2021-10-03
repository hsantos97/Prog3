
public class minhaThread extends Thread{
	private int numero;
	
	//construtor
	minhaThread(int numero)
	{
		this.numero = numero;
	}
	
	//codigo da thread
	@Override
	public void run()
	{
		for(int i = 0; i < 10; i++)
		{
			System.out.println("Eu sou a thread numero "+this.numero);
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
