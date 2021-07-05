package estatistica;

import java.util.Arrays;
import java.util.Scanner;

public class estatistica {
	public static void main(String[] args)
	{
		double[] numeros = new double[5];
		
		//lê os elementos do array
		Scanner leitor = new Scanner(System.in);
		System.out.println("Entre com os elementos do array:");
		for(int i = 0; i < numeros.length; i++) 
		{
			System.out.printf("numeros[%d] =", i);
			numeros[i] = leitor.nextDouble();
		}
		
		//calcular a média do array
		double media = calculaMedia(numeros);
		
		//maior valor do array
		double maior = encontraMaior(numeros);
		
		//soma 3
		double resultado = soma(1.0, 2.0, 3.5);
		
		//Mostra os resultados
		System.out.printf("Média: %.2f, Maior:%.2f", media, maior);
		System.out.printf("Soma: %.2f", resultado);
	}
	//método para calcular a média
	public static double calculaMedia(double[] array)
	{
		double soma = 0.0;
		for(double elem: array)
		{
			soma += elem;
		}
		return soma / array.length;
	}
	
	//método para pegar o maior valor do array
	public static double encontraMaior(double[] array)
	{
		Arrays.sort(array);
		return array[array.length-1];
	}
	
	//soma numeros
	public static double soma(double... nums)
	{
		double soma = 0.0;
		for(double elem: nums)
		{
			soma += elem;
		}
		return soma;
	}
}
