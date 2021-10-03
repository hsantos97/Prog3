import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class main {
	public static void main(String[] args)
	{
		//definindo a tarefa 1
		Runnable tarefa1 = () -> {
			for(int i = 0; i < 10; i++)
			{
				System.out.println("Hello "+i);
			}
		};
		
		//definindo a tarefa 2
		Runnable tarefa2 = () -> {
			for(int i = 0; i < 10; i++)
			{
				System.out.println("Bye "+i);
			}
		};
		
		//Cria o serviço executor
		ExecutorService executor = Executors.newCachedThreadPool(); // para threads rapidas
		executor.execute(tarefa1);
		executor.execute(tarefa2);
		executor.shutdown();
	}
}
