
public class minhaThread implements Runnable{
	private int numero;
	
	//construtor
	minhaThread(int numero)
	{
		this.numero = numero;
	}
	
	@Override
	public void run()
	{
		for(int i = 0; i < 10; i++)
		{
			System.out.println("Eu sou a thread numero "+this.numero);
			try
			{
				Thread.sleep(10000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
