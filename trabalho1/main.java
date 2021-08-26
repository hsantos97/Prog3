import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.*;

public class main {
	public static void main(String[] args) 
	{
		ArrayList<Pessoa> pessoas = new ArrayList<>(); // criando um ArrayList para cadastrar clientes
		ArrayList<Carros> carro = new ArrayList<>(); // criando ArrayList para cadastrar os carros
		
		Scanner leitor = new Scanner(System.in);
		int op;
		boolean flag = true;
		
		while(flag)
		{
			System.out.printf("1-Cadastrar Pf\n2-Cadastrar Pj\n3-Cadastrar Carro\n4-Print PF\n5-Print PJ");
			op = leitor.nextInt();
			switch(op)
			{
				case 1:
					//case pegar os dados de PF
					System.out.println("Entre com o nome: ");
					String nome = leitor.next();
					System.out.println("Entre com o endereco: ");
					String endereco = leitor.next();
					System.out.println("Entre com o telefone: ");
					String telefone = leitor.next();
					System.out.println("Entre com o cpf: ");
					String cpf = leitor.next();
					pessoas.add(new PessoaFisica(nome, endereco, telefone, cpf));
					System.out.println("PF CADASTRADO ");
					break;
				case 2:
					//case pegar os dados de PJ
					System.out.println("Entre com o nome: ");
					String nomePj = leitor.next();
					System.out.println("Entre com o endereco: ");
					String enderecoPj = leitor.next();
					System.out.println("Entre com o telefone: ");
					String telefonePj = leitor.next();
					System.out.println("Entre com o cnpj: ");
					String cnpj = leitor.next();
					System.out.println("Entre com o Razao Social: ");
					String razaoSocial = leitor.next();
					pessoas.add(new PessoaJuridica(nomePj, enderecoPj, telefonePj, cnpj, razaoSocial));
					System.out.println("PJ CADASTRADO ");
					break;
				case 3:
					//case para cadastrar os carros
					boolean situacao;					
					System.out.println("Entre com o Modelo: ");
					String modelo = leitor.next();
					System.out.println("Entre com a placa: ");
					String placa = leitor.next();					
					System.out.println("Entre com as observações: ");
					String observacao = leitor.next();
					System.out.println("Entre com o ano: ");
					int ano = leitor.nextInt();					
					System.out.println("Entre com o quilometragem: ");
					int quilometragem = leitor.nextInt();					
					System.out.println("situação do carro (1) disponivel ou (2) indisponivel: ");
					int situacoes = leitor.nextInt();					
					System.out.println("Entre com o valor da taxa diária: ");
					String taxaDiaria = leitor.next();
					double txDiaria = Double.parseDouble(taxaDiaria);
					
					if(situacoes == 1)
						situacao = true;
					else
						situacao = false;
					
					carro.add(new Carros(placa, ano, modelo, quilometragem, situacao, txDiaria, observacao));
					
					System.out.println("CARRO CADASTRADO ");
					break;
				case 4:
					/*for(int i = 0; i < pessoas.size(); i++)
					{
						pessoas.indexOf(i);
							
					}*/
					for(PessoaFisica pf : pessoas)
					{
						pf.printPessoaFisica();
					}
				default:
					System.out.println("ENCERRADO !!");
					flag = false;
			}
		}
		
		//PessoaFisica pf = new PessoaFisica("harison", "Goiabal", "24999162280", "11989685272");
		//PessoaJuridica pj = new PessoaJuridica("goiabas fc", "Goiabal", "24999162280", "Clube", "24/6464-3");
		
		//System.out.println("PRINT DA PESSOA CADASTRADA !!");
		//pf.printPessoaFisica();
		//pj.printPessoaJuridica();
		
		/*Carros c = new Carros("KVG-123", 2021, "SUV", 100, true, 10.0, "novo");
		Carros c2 = new Carros("KVG-122", 2019, "SUV", 1000, true, 10.0, "semi-novo");
		c.calculaValorDiaria();
		c2.calculaValorDiaria();
		//System.out.println("PRINT DA CARRO CADASTRADO !!");
		//c.printCarro();
		
		System.out.println("PRINT  PARA ALUGAR CARRO CADASTRADO !!");
		c.alugarCarro(pf.getPendencia());
		c2.alugarCarro(pf.getPendencia());
		
		System.out.println("PRINT PARA DEVOLVER CARRO CADASTRADO !!");
		c.devolverCarro(200, "10/05/2021", "15/07/2021)", 0);
		c2.devolverCarro(1200, "10/05/2021", "15/07/2021)", 1);
		
		double val = c.getValorPendente();
		pf.setValorPendencia(val);
		double val2 = c2.getValorPendente();
		pf.setValorPendencia(val2);
		
		System.out.println("PRINT PARA ALUGAR CARRO CADASTRADO !!");
		c.alugarCarro(pf.getPendencia()); */

	}
}
