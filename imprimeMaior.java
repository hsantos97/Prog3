package imprimeMaior;

import java.util.Scanner;

public class imprimeMaior {
	public static void main(String[] args)
	{
		Scanner leitor = new Scanner(System.in);
		System.out.println("informe três números inteiros:");
		int n = leitor.nextInt();
		int n2 = leitor.nextInt();
		int n3 = leitor.nextInt();
		
		int maior = retornaMaior(n, n2, n3);
		System.out.printf("Maior: %d\n", maior);
		
		int maior2 = retornaComMath(n, n2, n3);
		System.out.printf("Maior com Math: %d\n", maior2);
	}
	
	public static int retornaMaior(int n, int n2, int n3)
	{
		if((n > n2) && (n > n3))
		{
			return n;
		}
		else if((n2 > n) && (n2 > n3))
		{
			return n2;
		}
		else if((n3 > n) && (n3 > n2))
		{
			return n3;
		}
		else
		{
			return -1;
		}
	}
	
	public static int retornaComMath(int n, int n2, int n3)
	{
		int maior = Math.max(n, n2);
		maior = Math.max(n, n3);
		int maior2 = Math.max(n2, n3);
		int maior3 = Math.max(maior,  maior2);
		return maior3;
	}
}
