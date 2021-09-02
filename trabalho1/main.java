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
		//ut.criaArqTxt();
		pessoas = ut.getPessoaTxt();
		carro = ut.getCarroTxt();
		//aluguel = ut.getAlugueis(carro, pessoas); 
		
		while(flag)
		{
			System.out.printf("1-Cadastrar Pf\n2-Cadastrar Pj\n3-Cadastrar Carro\n4-Print Clientes Cadastrados\n"
					+ "5-Print Carros cadastrados\n6-Buscar Cliente\n7-Buscar Carro\n8-Alugar\n9-Devolver\n10-Pagar Pendencia\n");
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
					pessoas = ut.getPessoaTxt(); // atualizando o arquivo txt
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
					if(pes.getPendencia())
					{
						System.out.println("CLIENTE COM PENDENCIA !!");
						break;
					}

					System.out.println("Entre com o Modelo:");
					String modol = leitor.next();
					carro = ut.getCarroTxt();
					//obter carros do banco
					Carros corr = ut.buscaCarro(carro, modol);
					if(corr == null)
						break;
					if(!corr.getSituacao())
					{
						System.out.println("CARRO JA ESTÁ ALUGADO !!");
						break;
					}
					corr.setDataAluguel(ut.dataAtual());
					corr.setDataEntrega("***");
					corr.setSituacao(false);

					ut.atualizaTxtAluguel(aluguel);
					aluguel = ut.getAlugueis(carro, pessoas);
					ut.atualizaCarroTxt(carro, corr);//atualiza txt de carro
					carro = ut.getCarroTxt();
					aluguel = ut.getAlugueis(carro, pessoas);
					Aluguel alu = new Aluguel(corr, pes);
					//System.out.printf("Nome:%s | Modelo:%s \n",alu.getNome(),alu.getModelo());
					/*aluguel.add(alu);
					boolean test = alu.alugar();
					if(!test){
						System.out.printf(" Carro nao disponivel!\n");
						break;
					}*/
					aluguel.add(alu);
					ut.atualizaTxtAluguel(aluguel);
					aluguel = ut.getAlugueis(carro, pessoas);
					break;
				case 9:
					//case para devolver o carro
					//aluguel = ut.getAlugueis(carro, pessoas);
					System.out.printf("Tamanho array:%d |\n",aluguel.size());
					System.out.println("Entre com o Modelo:");
					pessoas = ut.getPessoaTxt();
					String model = leitor.next();
					Carros c2 = ut.buscaCarro(carro, model);
					if(c2 == null)
					{
						System.out.println("CARRO NÃO ENCONTRADO !!");
						break;
					}
					System.out.println("Entre com o nome do Cliente:");
					String n3 = leitor.next();
					Pessoa pesso = ut.buscaCliente(pessoas, n3);
					if(pesso ==  null)
					{
						System.out.println("CLIENTE NÃO ENCONTRADO !!");
						break;
					}
					if(pesso.getPendencia()){
						System.out.println("CLIENTE POSSUI PENDÊNCIA !!");
						break;
					}
					System.out.println("Data do aluguel:");
					String ini = leitor.next();
					
					System.out.println("Data da entrega:");
					String fim = leitor.next();
					
					System.out.println("Cliente Pagou ? (sim) 0 (não) 1");
					int pago = leitor.nextInt();
					
					System.out.println("Quilometragem final");
					int qf = leitor.nextInt();
					
					//c2.calculaValorDiaria();
												
					Aluguel alu2 = ut.buscaAluguel(aluguel, n3, model);
					if(alu2 == null)
					{
						System.out.println("ALUGUEL NÃO ENCONTRADO !!");
						break;
					}
					//pessoas = ut.getPessoaTxt(); // COLOQUEI ISSO AQUI
					//ut.atualizaPessoaTxt(pessoas, pesso); //mudei aquiii

					alu2.devolverCarro(qf, ini, fim, n3, model, pago);
					c2.setDataEntrega(fim);
					c2.setSituacao(true);
					
					Pessoa p = alu2.getPessoa();

					System.out.printf("Valor pendencia :%.2f\n",p.getValorPendencia());

					ut.atualizaCarroTxt(carro, c2); 

					carro = ut.getCarroTxt();
					Aluguel al = new Aluguel(c2,p);
					ut.atualizaPessoaTxt(pessoas, p);
					//al.devolverCarro(qf, ini, fim, n3, model, pago); //comentei aqui
					
					pessoas = ut.getPessoaTxt();
					aluguel = ut.atualizaAluguel(aluguel, al);
					ut.atualizaTxtAluguel(aluguel);
					//colaca aqui pra pegar o aluguel do txts
					aluguel = ut.getAlugueis(carro, pessoas);

					break;
				case 10:

					System.out.println("Entre com o nome do Cliente:");
					String n4 = leitor.next();
					//pega as pessoas que estão no arquivo pessoas .txt e retorna um array de pessoas
					pessoas = ut.getPessoaTxt();//retorna um array de pessoas
					//buscar no array de pessoas recem atualizado, a pessoa n4
					Pessoa pe2 = ut.buscaCliente(pessoas, n4);
					if(pe2.getValorPendencia() > 0)
					{
						System.out.println("Valor a pagar: ");
						double v = leitor.nextDouble();
						pe2.pagar(v);
						ut.atualizaPessoaTxt(pessoas, pe2);
						System.out.printf("Pen: %.2f\nNome:%s\nEntrada:%.2f\n",pe2.getValorPendencia(),pe2.getNome(),v);
						pessoas = ut.getPessoaTxt();
						System.out.println("Valor pendencia att: "+pe2.getValorPendencia());
					}
					else
					{
						System.out.println("CLIENTE NÃOO TEM PENDENCIA !!");
						break;
					}
					break;			
				default:
					System.out.println("ENCERRADO !!");
					flag = false;
					break;
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