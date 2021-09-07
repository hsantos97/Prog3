import java.util.ArrayList;
import java.util.Scanner;


public class main {
	public static void main(String[] args) 
	{
		ArrayList<Pessoa> pessoas = new ArrayList<>(); // criando um ArrayList para cadastrar clientes
		ArrayList<Carros> carro = new ArrayList<>(); // criando ArrayList para cadastrar os carros
		ArrayList<Aluguel> aluguel = new ArrayList<>(); // criando um ArraList para cadastrar os alugueis
		
		Scanner leitor = new Scanner(System.in); 
		int op;
		boolean flag = true;
		
		utilidades ut = new utilidades();
		//ut.criaArqTxt(); //metodo da classe utiliade que criar os arquivos
		pessoas = ut.getPessoaTxt();//pega do txt e atualiza o arraylist
		carro = ut.getCarroTxt();//pega do txt e atualiza o arraylist
		aluguel = ut.getAlugueis(carro, pessoas); 
		
		while(flag)
		{
			System.out.printf("1-Cadastrar Pf\n2-Cadastrar Pj\n3-Cadastrar Carro\n4-Print Clientes Cadastrados\n"
					+ "5-Print Carros cadastrados\n6-Alugar\n7-Devolver\n8-Pagar Pendencia\n9-Relatorio Carros\n"
					+"10-Relatorio de Faturamento\n11-Relatorio de Clientes devedores\n");
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
					if(ut.verificar(pessoas, cpf)) //verifica se ja existe algum cliente com esse cpf
					{
						System.out.println("CPF JA EXISTENTE");
						break;
					}
					PessoaFisica pf = new PessoaFisica(nome, endereco, telefone, cpf);
					ut.escreveArqPf(pf);//passando o objeto pf, para escrever no arquivo
					ut.getPessoaTxt();//pega do txt e atualiza o arraylist
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
					pessoas = ut.getPessoaTxt(); //pega do txt e atualiza o arraylist
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
					c3.calculaValorDiaria();	
					ut.escreveArqCarro(c3);// passando um objeto carro para escrever no arquivo
					carro = ut.getCarroTxt();//pega do txt e atualiza o arraylist
					
					System.out.println("CARRO CADASTRADO ");
					break;
				case 4:
					//case para imprimir os clientes cadastrados
					ut.lerArqCliente();
					break;
				case 5:
					//case para imprimir os carros cadastrados
					ut.lerArqCarro();
					break;
				case 6:
					//case para alugar o carro
					pessoas = ut.getPessoaTxt();
					carro = ut.getCarroTxt();
					aluguel = ut.getAlugueis(carro, pessoas);

					System.out.println("Entre com o nome do Cliente:");
					String n2 = leitor.next();
					Pessoa pes = ut.buscaCliente(pessoas, n2);
					if(pes == null)
						break;

					System.out.println("Entre com o Modelo:");
					String modol = leitor.next();
					Carros corr = ut.buscaCarro(carro, modol);
					if(corr == null)
						break;

					Aluguel alu = new Aluguel(corr, pes);
					if(alu.alugar())
					{
						aluguel.add(alu);
						corr.setDataAluguel(ut.dataAtual());
						corr.setDataEntrega("***");
					}	

					ut.atualizaCarroTxt(carro, corr);
					ut.atualizaPessoaTxt(pessoas, pes);
					ut.atualizaTxtAluguel(aluguel);

					System.out.println("ALUGOU O CARRO !!");
					break;
				case 7:
					//case para devolver o carro
					pessoas = ut.getPessoaTxt();
					carro = ut.getCarroTxt();
					aluguel = ut.getAlugueis(carro, pessoas);
					
					System.out.println("Entre com o Modelo:");
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

					System.out.println("Data do aluguel:");
					String ini = leitor.next();
					
					System.out.println("Data da entrega:");
					String fim = leitor.next();
					
					System.out.println("Cliente Pagou ? (sim) 0 (não) 1");
					int pago = leitor.nextInt();
					
					System.out.println("Quilometragem final");
					int qf = leitor.nextInt();
					
												
					Aluguel alu2 = ut.buscaAluguel(aluguel, n3, model);
					if(alu2 == null)
					{
						System.out.println("ALUGUEL NÃO ENCONTRADO !!");
						break;
					}

					alu2.devolverCarro(qf, ini, fim, n3, model, pago);
					System.out.printf("Valor pendencia :%.2f\n",pesso.getValorPendencia());

					ut.atualizaPessoaTxt(pessoas, pesso);				
					ut.atualizaCarroTxt(carro, c2);
					ut.atualizaTxtAluguel(aluguel); 
					ut.atualizaFaturamentoTxt(alu2.getValorDeAluguel()); 
					System.out.println("CARRO DEVOLVIDO !!");

					break;
				case 8:
					//case para pagar as pendencia dos clientes
					pessoas = ut.getPessoaTxt();

					System.out.println("Entre com o nome do Cliente:");
					String n4 = leitor.next();
					Pessoa pe2 = ut.buscaCliente(pessoas, n4);
					if(pe2.getValorPendencia() > 0)
					{
						System.out.println("Pendencia: "+pe2.getValorPendencia());
						System.out.println("Valor a pagar: ");
						double v = leitor.nextDouble();
						pe2.pagar(v);
						System.out.printf("Nome:%s\nValor Pago:%.2f\n", pe2.getNome(),v);
						System.out.println("Valor pendencia att: "+pe2.getValorPendencia());
					}
					else
					{
						System.out.println("CLIENTE NÃOO TEM PENDENCIA !!");
						break;
					}

					ut.atualizaPessoaTxt(pessoas, pe2);

					break;
				case 9:
					//case para imprimir os relatorio dos carros alugados
					carro = ut.getCarroTxt();
					ut.imprimeRelatorioCarros(carro);
					break;
				case 10:
					//case para imprimir os relatorios de faturamento
					System.out.println("VALOR FATURADO TOTAL !!");
					System.out.println(ut.getFaturamentoTxt());
					break;
				case 11:
					//case para clientes devedores
					carro = ut.getCarroTxt();
					pessoas = ut.getPessoaTxt();
					aluguel = ut.getAlugueis(carro, pessoas);
					ut.imprimeDevedores(aluguel);
					break;
				default:
					System.out.println("ENCERRADO !!");
					flag = false;
					break;
			}
		}
	}
}