import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class main {
	public static void main(String[] args) throws InterruptedException, ExecutionException
	{
		//Callable sempre que for retorna um valor
		Callable<Integer> tarefa = () -> {
			Random rand = new Random();
			int valor = rand.nextInt(100);
			System.out.println("Valor Gerado: "+valor);
			return valor;
		};
		
		//cria o pool de threads
		System.out.println("Criando as threads ...");
		ExecutorService threadPool = Executors.newFixedThreadPool(5);
		Future<Integer> retorno1 = threadPool.submit(tarefa);
		Future<Integer> retorno2 = threadPool.submit(tarefa);
		Future<Integer> retorno3 = threadPool.submit(tarefa);
		Future<Integer> retorno4 = threadPool.submit(tarefa);
		Future<Integer> retorno5 = threadPool.submit(tarefa);
		
		System.out.println("Aguardando finalização !!");
		int res1 = retorno1.get();
		int res2 = retorno2.get();
		int res3 = retorno3.get();
		int res4 = retorno4.get();
		int res5 = retorno5.get();
		
		int total = res1+res2+res3+res4+res5;
		System.out.println("Soma = "+total);
		threadPool.shutdown();
	}
}
