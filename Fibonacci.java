import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args)
	{
		Scanner leitor = new Scanner(System.in);
		System.out.println("Informe um numero maior que 1:");
		int n = leitor.nextInt();
		
		for(int i = 1; i <= n; i++)
		{
			System.out.printf("(" + i + "):" + Fibonacci.fibo(i) + "\t"); 
		}
	}
	
	public static int fibo(int n)
	{
		if(n < 2)
		{	
			return n;
		}	
		else
		{
			return fibo(n-1) + fibo(n-2);
		}
	}	
}