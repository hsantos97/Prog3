import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.*;

public class main {
	public static void main(String[] args) 
	{
		ArrayList<Pessoa> pessoas = new ArrayList<>(); // criando um ArrayList para cadastrar clientes
		ArrayList<Carros> carro = new ArrayList<>(); // criando ArrayList para cadastrar os carros
		ArrayList<Aluguel> aluguel = new ArrayList<>();
		
		Scanner leitor = new Scanner(System.in);
		int op;
		boolean flag = true;
		
		utilidades ut = new utilidades();
		ut.criaArqTxt();
		pessoas = ut.getPessoaTxt();
		carro = ut.getCarroTxt();
		//aluguel = ut.getAlugueis(carro, pessoas); 
		
		while(flag)
		{
			System.out.printf("1-Cadastrar Pf\n2-Cadastrar Pj\n3-Cadastrar Carro\n4-Print Clientes Cadastrados\n"
					+ "5-Print Carros cadastrados\n6-Buscar Cliente\n7-Buscar Carro\n8-Alugar\n9-Devolver");
			op = leitor.nextInt();
			switch(op)
			{
				case 1:
					//case pegar os dados de PF para cadastro
					System.out.println("Entre com o nome: ");
					String nome = leitor.next();
					System.out.println("Entre com o endereco: ");
					String endereco = leitor.next();
					System.out.println("Entre com o telefone: ");
					String telefone = leitor.next();
					System.out.println("Entre com o cpf: ");
					String cpf = leitor.next();
					if(ut.verificar(pessoas, cpf))
					{
						System.out.println("CPF JA EXISTENTE");
						break;
					}
					PessoaFisica pf = new PessoaFisica(nome, endereco, telefone, cpf);
					ut.escreveArqPf(pf);//passando o objeto pf, para escrever no arquivo
					ut.getPessoaTxt();//atualizar o arquivo txt
					//pessoas.add(new PessoaFisica(nome, endereco, telefone, cpf)); //adicionando a pessoa fisica no arraylist
					System.out.println("PF CADASTRADO ");
					break;
				case 2:
					//case pegar os dados de PJ para cadastro
					System.out.println("Entre com o nome: ");
					String nomePj = leitor.next();
					System.out.println("Entre com o endereco: ");
					String enderecoPj = leitor.next();
					System.out.println("Entre com o telefone: ");
					String telefonePj = leitor.next();
					System.out.println("Entre com o cnpj: ");
					String cnpj = leitor.next();
					if(ut.verificar(pessoas, cnpj))
					{
						System.out.println("CNPJ JA CADASTRADO !!");
						break;
					}
					System.out.println("Entre com o Razao Social: ");
					String razaoSocial = leitor.next();
					PessoaJuridica pj = new PessoaJuridica(nomePj, enderecoPj, telefonePj, razaoSocial, cnpj);
					ut.escreveArqPj(pj); //passando o objeto pj para escrever no arquivo
					ut.getPessoaTxt(); // atualizando o arquivo txt
					//pessoas.add(new PessoaJuridica(nomePj, enderecoPj, telefonePj, cnpj, razaoSocial)); // adicionadno ao arraylist
					System.out.println("PJ CADASTRADO ");
					break;
				case 3:
					//case para cadastrar os carros
					boolean situacao;					
					System.out.println("Entre com o Modelo: ");
					String modelo = leitor.next();
					System.out.println("Entre com a placa: ");
					String placa = leitor.next();
					if(ut.verificarCarro(carro, placa))
					{
						System.out.print("CARRO JA CADASTRADO !!");
						break;
					}
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
					
					Carros c3 = new Carros(placa, ano, modelo, quilometragem, situacao, txDiaria, observacao);
					ut.escreveArqCarro(c3);// passando um objeto carro para escrever no arquivo
					carro = ut.getCarroTxt();//atualizar os carros no txt
					//carro.add(new Carros(placa, ano, modelo, quilometragem, situacao, txDiaria, observacao));
					
					System.out.println("CARRO CADASTRADO ");
					break;
				case 4:
					//case para imprimir os clientes cadastrados
					/*for(Pessoa p : pessoas)
					{
						if(p instanceof PessoaFisica) 
							((PessoaFisica) p).printPessoaFisica();
						if(p instanceof PessoaJuridica)
							((PessoaJuridica) p).printPessoaJuridica();
					}*/
					ut.lerArqCliente();
					break;
				case 5:
					//case para imprimir os carros cadastrados
					/*for(Carros c : carro)
						c.printCarro(); */
					ut.lerArqCarro();
					break;
				case 6:
					//case para buscar cliente
					System.out.println("Entre com o nome do Cliente:");
					String n = leitor.next();

					pessoas = ut.getPessoaTxt();
					Pessoa pe = ut.buscaCliente(pessoas, n);
					if(pe == null)
						break;
					break;
				case 7:
					//case para buscar o carro
					System.out.println("Entre com o Modelo:");
					String mod = leitor.next();
					carro = ut.getCarroTxt();
					Carros co = ut.buscaCarro(carro, mod);
					if(co == null)
						break;
					break;
				case 8:
					//case para alugar o carro
					System.out.println("Entre com o nome do Cliente:");
					String n2 = leitor.next();
					pessoas = ut.getPessoaTxt();
					//obter pessoas do banco
					Pessoa pes = ut.buscaCliente(pessoas, n2);
					if(pes == null)
						break;
					
					System.out.println("Entre com o Modelo:");
					String modol = leitor.next();
					carro = ut.getCarroTxt();
					//obter carros do banco
					Carros corr = ut.buscaCarro(carro, modol);
					if(corr == null)
						break;
					
					Aluguel alu = new Aluguel(corr, pes);
					System.out.printf("Nome:%s | Modelo:%s \n",alu.getNome(),alu.getModelo());
					
					aluguel = ut.getAlugueis(carro, pessoas);
					boolean test = alu.alugar();
					if(!test){
						System.out.printf(" Carro nao disponivel!\n");
						break;
					}
					//System.out.println(alu.getStatus());
					aluguel.add(alu);
					System.out.printf("Tamanho array:%d |\n",aluguel.size());
					//aluguel = ut.atualizaAluguel(aluguel,alu);
					System.out.printf("Tamanho array:%d |\n",aluguel.size());
					ut.atualizaTxtAluguel(aluguel);
					aluguel = ut.getAlugueis(carro, pessoas);
					/*
					if(!alu.getStatus())
					{
						alu.alugar();
						ut.atualizaCarroTxt(carro, corr);
						carro = ut.getCarroTxt();						
						
						//aluguel = ut.getAlugueis(carro, pessoas);
						ut.escreveArqAlugueis(pes, corr, true);
						ut.atualizaTxtAluguel(aluguel);
						break;
					}
					else
						break;
					*/
					break;
				case 9:
					//case para devolver o carro
					aluguel = ut.getAlugueis(carro, pessoas);
					System.out.println("Entre com o Modelo:");
					String model = leitor.next();
					Carros c2 = ut.buscaCarro(carro, model);
					
					System.out.println("Entre com o nome do Cliente:");
					String n3 = leitor.next();
					
					System.out.println("Data do aluguel:");
					String ini = leitor.next();
					
					System.out.println("Data da entrega:");
					String fim = leitor.next();
					
					System.out.println("Cliente Pagou ? (sim) 0 (não) 1");
					int pago = leitor.nextInt();
					
					System.out.println("Quilometragem final");
					int qf = leitor.nextInt();
					
					c2.calculaValorDiaria();

					Pessoa pesso = ut.buscaCliente(pessoas, n3);

					pessoas = ut.getPessoaTxt();
					ut.atualizaCarroTxt(carro, c2);
					carro = ut.getCarroTxt();
					ut.atualizaPessoaTxt(pessoas, pesso);
							
					Aluguel alu2 = ut.buscaAluguel(aluguel, n3, model);
					if(alu2 == null)
					{
						System.out.println("ALUGUEL NÃO ENCONTRADO !!");
						break;
					}
					alu2.devolverCarro(qf, ini, fim, n3, model, pago);
					
					aluguel = ut.atualizaAluguel(aluguel, alu2);
					ut.atualizaTxtAluguel(aluguel);
					
					break;
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
