package testaException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class main {
	public static void main(String[] args)
	{
		/*System.out.println("Inicio main");
		metodo1();
		
		try 
		{
			int x = 10;
			System.out.println("resultado: "+ (x/0));
		}catch(ArithmeticException e)
		{
			System.out.println("Excecao da divisão tratada"+ e.getMessage());
		}
		
		
		System.out.println("Fim main"); */
		
		Conta cc = new Conta();
		cc.deposita(100);
		cc.deposita(100);
		System.out.println("Saldo depois do deposito:"+cc.getSaldo());
		try
		{
			cc.saque(250);
		}catch(IllegalArgumentException e)
		{
			System.out.println("saque realizado!");
		}
		
		System.out.println("Saldo depois do saque:"+cc.getSaldo());
		
		try
		{
			cc.deposita(-35);
		}catch(TrataExceptionDeposito e)
		{
			System.out.println("Tratamento da classe criada");
		}
		
	}
	
	public static void metodo1() {
		System.out.println("Inicio metodo 1");
		metodo2();
		
		//exceção checada
		try {
			FileInputStream f = new FileInputStream("meuAquivo.txt");
		} catch (FileNotFoundException e) {
			System.out.println("exceção tratada do File"+e.getLocalizedMessage());
		}
		
		System.out.println(""+ "Fim do metodo 1");
	}
	public static void metodo2() 
	{
		System.out.println("Inicio metodo 2");
		Conta cc = new Conta();
		
		try
		{
			for(int i=0; i < 15; i++) 
			{
				cc.deposita(i+100);
				System.out.println("Saldo: "+ cc.getSaldo());
				if(i == 5) 
				{
					cc = null;
				}
			}
		}catch(NullPointerException e)
		{
			System.out.println("Erro tratado!!");
		}
		System.out.println("Fim metodo 2");
	}
}
