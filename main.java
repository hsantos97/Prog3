import java.util.ArrayList;
import java.util.Scanner;

public class main {
	public static void main(String[] args)
	{
		//criar lista de funcionarios
		ArrayList<Funcionario> lista = new ArrayList<>();
		
		Scanner leitor = new Scanner(System.in);
		
		String nome = "";
		double salario;
		
		while(true)
		{
			System.out.println("Entre com o nome do funcionario ou fim para sair:");
			nome = leitor.nextLine();
			if(nome.equalsIgnoreCase("fim"))
			{
				break;
			}
			System.out.println("Entre com o salario:");
			salario = Double.parseDouble(leitor.nextLine());
			lista.add(new Funcionario(nome, salario));
		}
		
		for(Funcionario f: lista)
		{
			System.out.printf("Nome: %s, Salario: %.2f", f.getNome(), f.getSalario());
		}
		
		// aumento de 10% para todos os funcionarios
		for(Funcionario f: lista)
		{
			f.aumentarSalario(10.0);
			System.out.printf("Nome: %s, Salario: %.2f", f.getNome(), f.getSalario());
		}
		
	}
}
