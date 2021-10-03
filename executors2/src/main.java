import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class main {
	public static void main(String[] args)
	{
		Callable<Integer> tarefa = () -> {
			Random rand = new Random();
			int acc = 0;
			for(int i = 0; i < 10000; i++)
				acc += rand.nextInt(100);
			
			return acc;
			
		};
		
		//criando o pool de threads
		ExecutorService threadPool = Executors.newFixedThreadPool(4);
		Future<Integer> retorno = threadPool.submit(tarefa);
		
		while(!retorno.isDone())
		{
			System.out.println("Tarefa ainda não concluida !!");
		}
		int resultado = 0;
		System.out.println("Tarefa conlcuida !!");
		try {
			resultado = retorno.get();
		}catch(InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("O resultado é: "+resultado);
		threadPool.shutdown();
	}
}
