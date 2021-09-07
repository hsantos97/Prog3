
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;

public class utilidades {
	//metodo que recebe o arraylist de pessoa e o nome de um cliente percorre o arraylist
	// e retorna o cliente que o nome foi passado, se não for encontrado retorna null
	public Pessoa buscaCliente(ArrayList<Pessoa> pessoa, String nome)
	{
		for(Pessoa p : pessoa)
		{
			if(p instanceof PessoaFisica) //verificando se o cliente passado é fisico
			{
				if(nome.equalsIgnoreCase(p.getNome()))
				{
					//((PessoaFisica) p).printPessoaFisica();
					return p;
				}
			}
			else if(p instanceof PessoaJuridica) //verificando se o cliente passado é juridico
			{
				if(nome.equalsIgnoreCase(p.getNome()))
				{
					//((PessoaJuridica) p).printPessoaJuridica();
					return p;
				}
			}
		}
		System.out.println("CLIENTE NÃO ENCONTRADO !!");
		return null;	
	}
	//metodo que recebe um arraylist de carros e o modelo de carrro percorre o arraylist
	//retorna o carro caso encontre, se não retorna null 
	public Carros buscaCarro(ArrayList<Carros> carro, String modelo)
	{
		for(Carros c : carro)
		{
			if(modelo.equalsIgnoreCase(c.getModelo()))
			{
				//c.printCarro();
				//System.out.println("valor pendente:"+c.getValorPendente());
				return c;
			}
		}
		System.out.println("CARRO NÃO ENCONTRADO !!");
		return null;	
	}
	//metodo para criar os arquivos 
	public void criaArqTxt()
	{
		java.io.File diretorio = new java.io.File("arquivo");
		java.io.File arquivo = new java.io.File(diretorio, "cliente.txt");
		java.io.File arquivo2 = new java.io.File(diretorio, "carros.txt");
		java.io.File arquivo3 = new java.io.File(diretorio, "alugueis.txt");
		java.io.File arquivo4 = new java.io.File(diretorio, "faturamento.txt");
		try {
			boolean statusArq = arquivo.createNewFile(); //criando o arquivo fisico
			boolean statusArq2 = arquivo2.createNewFile();
			boolean statusArq3 = arquivo3.createNewFile();
			boolean statusArq4 = arquivo4.createNewFile();
			System.out.print(statusArq); //status dos arquivos criados
			System.out.print(statusArq2); 
			System.out.print(statusArq3);
			System.out.print(statusArq4);
		} catch (IOException e) {
		    e.printStackTrace(); 
		}
		if (diretorio.exists()) { //verificando o diretorio dos arquivos
			System.out.println("Diretório existe!");
		    if (arquivo.exists())
		    	System.out.println("Arquivo existe!");
		    if(arquivo2.exists())
		    	System.out.println("Arquivo existe!");
		    if(arquivo3.exists())
		    	System.out.println("Arquivo existe!");
		}	
	}
	//metodo que recebe um objeto pf e escreve no arquivo cliente.txt
	public void escreveArqPf(PessoaFisica pf)
	{
		try 
		{	
			FileWriter fileWriter = new FileWriter("./arquivos/cliente.txt", true); //true para que o arquivo não sobreescreva 
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.printf("%s %s %s %s %.2f %n", pf.getNome(), pf.getEndereco(), pf.getTelefone(), pf.getCpf(), 
					pf.getValorPendencia());
			
			//o método flush libera a escrita no arquivo
            printWriter.flush();
            
            //No final precisamos fechar o arquivo
            printWriter.close();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}	
	}
	//metodo que recebe um objeto pj e escreve no arquivo cliente.txt
	public void escreveArqPj(PessoaJuridica pj)
	{
		try 
		{
			FileWriter fileWriter = new FileWriter("./arquivos/cliente.txt", true);//true para que o arquivo não sobreescreva
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.printf("%s %s %s %s %s %.2f %n", pj.getNome(), pj.getEndereco(), pj.getTelefone(), pj.getRazaoSocial(), 
					pj.getCnpj(), pj.getValorPendencia());
			
			//o método flush libera a escrita no arquivo
            printWriter.flush();
            
            //No final precisamos fechar o arquivo
            printWriter.close();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}	
	}
	//metodo que recebe um objeto carro e escreve no arquivo carros.txt
	public void escreveArqCarro(Carros c)
	{
		try 
		{
			FileWriter fileWriter = new FileWriter("./arquivos/carros.txt", true);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.printf("%s %d %s %d %b %.2f %s %s %s %n", c.getPlaca(), c.getAno(), c.getModelo(), 
					c.getQuilometragem(), c.getSituacao(), c.getTaxaDiaria(), c.getObservacoes(), c.getDataAluguel(), c.getDataEntrega());
		
			//o método flush libera a escrita no arquivo
            printWriter.flush();
            
            //No final precisamos fechar o arquivo
            printWriter.close();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}	
	}
	//metodo que le o arquivo cliente.txt
	public void lerArqCliente()
	{
		File dir = new File("arquivos");
		File arq = new File(dir, "cliente.txt");
		
		try {
	        //Indicamos o arquivo que será lido
	        FileReader fileReader = new FileReader(arq);

	        //Criamos o objeto bufferReader que nos
	        // oferece o método de leitura readLine()
	        BufferedReader bufferedReader = new BufferedReader(fileReader);

	        //String que irá receber cada linha do arquivo
	        String linha = "";

	        //Fazemos um loop linha a linha no arquivo,
	        // enquanto ele seja diferente de null.
	        //O método readLine() devolve a linha na
	        // posicao do loop para a variavel linha.
	        while ( ( linha = bufferedReader.readLine() ) != null) {
	        //Aqui imprimimos a linha
	        	
	        System.out.println(linha);
	    }
			//liberamos o fluxo dos objetos ou fechamos o arquivo
	        fileReader.close();
	        bufferedReader.close();
		} catch (IOException e) {
	    	e.printStackTrace();
	    }
	}
	//metodo para ler o arquivo carros.txt
	public void lerArqCarro()
	{
		File dir = new File("arquivos");
		File arq = new File(dir, "carros.txt");
		
		try {
	        //Indicamos o arquivo que será lido
	        FileReader fileReader = new FileReader(arq);

	        //Criamos o objeto bufferReader que nos
	        // oferece o método de leitura readLine()
	        BufferedReader bufferedReader = new BufferedReader(fileReader);

	        //String que irá receber cada linha do arquivo
	        String linha = "";

	        //Fazemos um loop linha a linha no arquivo,
	        // enquanto ele seja diferente de null.
	        //O método readLine() devolve a linha na
	        // posicao do loop para a variavel linha.
	        while ( ( linha = bufferedReader.readLine() ) != null) {
	        //Aqui imprimimos a linha
	        System.out.println(linha);
	    }
			//liberamos o fluxo dos objetos ou fechamos o arquivo
	        fileReader.close();
	        bufferedReader.close();
		} catch (IOException e) {
	    	e.printStackTrace();
	    }
	}
	//metodo que recupera os valores do txt de carros e armazena em um arraylist do tipo carros
	//e retorna o arrylist de carros
	public ArrayList<Carros> getCarroTxt()
	{
		File dir = new File("arquivos");
		File arq = new File(dir, "carros.txt");
		ArrayList<Carros> car = new ArrayList<>();//criando um arraylist do tipo carros
		
		try {
			Scanner arquivo = new Scanner(new FileReader(arq));
			while(arquivo.hasNextLine())
			{
				String linha = arquivo.nextLine();
				//System.out.println(linha);
				String[] itens = linha.split(" "); //delimitador 
				Carros c = new Carros(itens[0], Integer.parseInt(itens[1]), itens[2], Integer.parseInt(itens[3]), 
						Boolean.parseBoolean(itens[4]), Double.parseDouble(itens[5]), itens[6]);
				c.setDataEntrega(itens[8]!= null ? itens[8]:"null" ); // O QUE É ISSSO ?
				c.setDataAluguel(itens[7]);
				car.add(c);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return car;
	}
	//metodo para pegar os dados de cliente.txt e armazenar em um arraylist do tipo pessoa
	//e retorna o arraylist
	public ArrayList<Pessoa> getPessoaTxt()
	{
		File dir = new File("arquivos");
		File arq = new File(dir, "cliente.txt");
		ArrayList<Pessoa> pe = new ArrayList<>();
		
		try {
			Scanner arquivo = new Scanner(new FileReader(arq));
			while(arquivo.hasNextLine())
			{
				String linha = arquivo.nextLine();
				String[] itens = linha.split(" ");

				if(itens.length == 5){ //verificando se o cliente é fisico
					PessoaFisica pf = new PessoaFisica(itens[0], itens[1], itens[2], itens[3]);
					if(Double.parseDouble(itens[4])>0){ //verificando a pendencia
						pf.setPendencia(true);
						pf.setValorPendencia(Double.parseDouble(itens[4]));
					}else{
						pf.setPendencia(false);
						pf.setValorPendencia(0);
					} 
					pe.add(pf);
				}
				else if(itens.length == 6){ //verificando se o cliente é juridico
					PessoaJuridica pj = new PessoaJuridica(itens[0], itens[1], itens[2], itens[3], itens[4]);
					if(Double.parseDouble(itens[5])>0){ //verificando a pendencia
						pj.setPendencia(true);
						pj.setValorPendencia(Double.parseDouble(itens[5]));
					}else{
						pj.setPendencia(false);
						pj.setValorPendencia(0);
					} 
					pe.add(pj);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return pe;
	}
	//metodo que recebe um objeto de pessoa e carro e um boolean alugar caso o carro for alugado true false
	// caso contrario
	public void escreveArqAlugueis(Pessoa p, Carros c, boolean alugar)
	{
		try 
		{
			if(alugar)// testo pra ver se alugar é true
			{
				FileWriter fileWriter = new FileWriter("./arquivos/alugueis.txt", true);
				PrintWriter printWriter = new PrintWriter(fileWriter);
				
				if(p instanceof PessoaFisica) //teste para verificar se a pessoa é fisica
					printWriter.printf("%s %s %s %s %s %n", p.getNome(), ((PessoaFisica) p).getCpf(), 
							c.getModelo(), c.getPlaca(), c.getDataAluguel(),p.getValorPendencia());
				if(p instanceof PessoaJuridica) //teste para verificar se a pessoa é juridica
					printWriter.printf("%s %s %s %s %s %n", p.getNome(), ((PessoaJuridica) p).getCnpj(),
							c.getModelo(), c.getPlaca(), c.getDataAluguel(),c.getValorPendente(),p.getValorPendencia());
				
				//o método flush libera a escrita no arquivo
	            printWriter.flush();
	          	//No final precisamos fechar o arquivo
	            printWriter.close();
			}
			else
				System.out.println("FALHA NO ALUGUEL !!");     
            
		} catch (IOException e) 
		{
			e.printStackTrace();
		}	
	}
	//metodo que recebe um arraylist do tipo pessoa e uma string documento que sera passado cpf caso seja
	//pessoa fisica e cnpj caso seja pessoa juridica e retorna um boolean encontrado
	public boolean verificar(ArrayList<Pessoa> pessoa, String documento)
	{
		for(Pessoa p : pessoa)//percorre o arraylist
		{
			if(p instanceof PessoaFisica)
			{
				if(documento.equals(((PessoaFisica) p).getCpf()))//verificando se o documento é igual ao cpf
					return true;
			}
			if(p instanceof PessoaJuridica)
			{
				if(documento.equals(((PessoaJuridica) p).getCnpj()))//verificando se o documento é igual ao cnpj
					return true;
			}
		}
		return false;	
	}
	//metodo que recebe um arraylist do tipo carros e uma String placa para verificar e retorna true caso encontrado
	public boolean verificarCarro(ArrayList<Carros> carros, String placa)
	{
		for(Carros c : carros)
		{
			if(placa.equals(c.getPlaca()))
					return true;
		}
		return false;	
	}
	//metodo que recebe um arraylist do tipo carro e um objeto carro
	//reescre o arquivo carros.txt com base no arraylist passado
	public void atualizaCarroTxt(ArrayList<Carros> carros, Carros c)
	{
		for(int i = 0; i <= carros.size()-1; i++)
		{	
			Carros aux = carros.get(i); //auxiliar recebendo o carro na posição
			aux = carros.get(i);
			if(c.getPlaca().equals(aux.getPlaca()))
				carros.set(i, c);	
		}
		
		try 
		{
			FileWriter fileWriter = new FileWriter("./arquivos/carros.txt", false);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			for(Carros car : carros)
			{
				printWriter.printf("%s %d %s %d %b %.2f %s %s %s %n", car.getPlaca(), car.getAno(), car.getModelo(), 
					car.getQuilometragem(), car.getSituacao(), car.getTaxaDiaria(), car.getObservacoes(),car.getDataAluguel(),car.getDataEntrega());
				
				//o método flush libera a escrita no arquivo
	            printWriter.flush();
			}
				
	            
			//No final precisamos fechar o arquivo
            printWriter.close();
	            
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	//metodo que recebe um arraylist do tipo pessoa e um objeto pessoa
	//reescre o arquivo cliente.txt com base no arraylist passado
	public void atualizaPessoaTxt(ArrayList<Pessoa> pessoas, Pessoa p)
	{	
		for(int i = 0; i <= pessoas.size()-1; i++)
		{	
			Pessoa aux = pessoas.get(i);
			aux = pessoas.get(i);
			if(p.getTelefone().equals(aux.getTelefone()))
				pessoas.set(i, p);	
		}
		try 
		{
			FileWriter fileWriter = new FileWriter("./arquivos/cliente.txt", false);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			for(Pessoa pes:pessoas){
				if(pes instanceof PessoaFisica && ((PessoaFisica)pes).getCpf()!=null){
					printWriter.printf("%s %s %s %s %.2f %n", pes.getNome(), pes.getEndereco(), pes.getTelefone(), 
						((PessoaFisica) pes).getCpf(), pes.getValorPendencia());
					
					//o método flush libera a escrita no arquivo
					printWriter.flush();
				}else if(pes instanceof PessoaJuridica && ((PessoaJuridica)pes).getCnpj()!=null){
					printWriter.printf("%s %s %s %s %s %.2f %n", pes.getNome(), pes.getEndereco(), pes.getTelefone(), 
						((PessoaJuridica)pes).getRazaoSocial(), ((PessoaJuridica)pes).getCnpj(), pes.getValorPendencia());
					
						//o método flush libera a escrita no arquivo
					printWriter.flush();
				}
			}		
			//No final precisamos fechar o arquivo
			printWriter.close();		
		} catch (IOException e) 
		{
			e.printStackTrace();
		}	
	}
	//metodo que recebe um arraylist do tipo aluguel e duas strings
	//retorna um objeto aluguel caso seja encontrado
	public Aluguel buscaAluguel(ArrayList<Aluguel> alugueis, String nome, String modelo)
	{
		for(Aluguel aluguel : alugueis)
		{
			Pessoa pessoa;
			Carros carro;
			pessoa = aluguel.getPessoa(); //pega do txt e armazena no arraylist
			carro = aluguel.getCarro();
			if((pessoa.getNome().equals(nome)) && (carro.getModelo().equals(modelo)))	
				return aluguel;
		}
		return null;	
	}
	//metodo que recebe um arraylist de aluguel e um objeto aluguel
	//e retorna um arraylist atulizado de aluguel
	public ArrayList<Aluguel> atualizaAluguel(ArrayList<Aluguel> alugueis, Aluguel aluguel)
	{
		for(int i = 0; i < alugueis.size()-1; i++)
		{
			//comparando as pessoa e pessoa2, carro e carro2
			//do aluguel que foi passado com cada posição do arraylist de alugueis
			Pessoa pessoa, pessoa2;
			Carros carro, carro2;
			Aluguel alu = alugueis.get(i);
			pessoa2 = alu.getPessoa();
			carro2 = alu.getCarro();
			pessoa = aluguel.getPessoa();
			carro = aluguel.getCarro();
			if((pessoa.getNome().equals(pessoa2.getNome())) && (carro.getModelo().equals(carro2.getModelo())))
			{
				alugueis.set(i, aluguel);
				return alugueis;
			}
		}
		return alugueis;
	}
	//metodo que recebe um arraylist do tipo aluguel e reescreve o arquivo alugueis.txt
	public void atualizaTxtAluguel(ArrayList<Aluguel> alugueis)
	{	
		try 
		{
			FileWriter fileWriter = new FileWriter("./arquivos/alugueis.txt", false);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			for (Aluguel aluguel : alugueis)
			{
				Pessoa p = aluguel.getPessoa();
				Carros c = aluguel.getCarro();
				//System.out.println("Entrou");
				if(p instanceof PessoaFisica){
					printWriter.printf("%s %s %s %s %s %s %n", p.getNome(), ((PessoaFisica) p).getCpf(), c.getModelo(), 
						c.getPlaca(), c.getDataAluguel(), c.getDataEntrega(),aluguel.getValorDeAluguel());
				}
				if(p instanceof PessoaJuridica)
					printWriter.printf("%s %s %s %s %s %s %n", p.getNome(), ((PessoaJuridica) p).getCnpj(), c.getModelo(), 
							c.getPlaca(), c.getDataAluguel(), c.getDataEntrega(),aluguel.getValorDeAluguel());
				
				printWriter.flush();
			}
			
			printWriter.close();
 
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	//metodo que recebe arraylist do tipo carros e pessoa
	//recupera os dados do arquivo alugueis.txt
	//retorna um arraylist de aluguel
	public ArrayList<Aluguel> getAlugueis(ArrayList<Carros> carros, ArrayList<Pessoa> pessoas)
	{
		ArrayList<Aluguel> alugueis = new ArrayList<>();
		
		File dir = new File("arquivos");
		File arq = new File(dir, "alugueis.txt");
		
		try {
			Scanner arquivo = new Scanner(new FileReader(arq));
			while(arquivo.hasNextLine())
			{
				String linha = arquivo.nextLine();
				String[] itens = linha.split(" ");
				
				Carros c = buscaCarro(carros, itens[2]);
				Pessoa p = buscaCliente(pessoas, itens[0]);
				Aluguel a = new Aluguel(c, p);
				//a.alugar();
				alugueis.add(a);
			}
			return alugueis;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;	
	}
	//metodo para retornar a data atual
	public String dataAtual(){
		Date data = new Date(System.currentTimeMillis()); 
		SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyy");
		return formatarDate.format(data);
	}
	// metodo que recebe arraylist de carros e imprime os carros que estão alugados
	public void imprimeRelatorioCarros(ArrayList<Carros> carros){
		ArrayList<Carros> cars = new ArrayList<>();

		// separar apenas carros indisponiveis(false)
		for( Carros item: carros){	
			if(item.getSituacao()==false){
				cars.add(item);
			}
		}
		// imprimir os carros com situação == false
		System.out.println("Relatório de carros alugados");
		System.out.printf("Total de carros alugados: %d\n", cars.size());
		for(Carros car : cars){
			car.printCarro();
		}
	}

	//metodo que recebe um arraylist de pessoa e calcula faturamento
	public void imprimeFaturamento(ArrayList<Pessoa> pessoas){
		Double faturamento = 0.0;
		for(Pessoa item: pessoas){
			faturamento += item.getValorPendencia();
		}
		System.out.println("FATURAMENTO TOTAL: "+faturamento);
	}
	//metodo que recebe um double como parametro guarda um double em um txt
	public void escreveFaturamento(Double p)
	{
		try 
		{
			FileWriter fileWriter = new FileWriter("./arquivos/faturamento.txt", false);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.printf("%.2f %n", p);
		
			//o método flush libera a escrita no arquivo
            printWriter.flush();
            
            //No final precisamos fechar o arquivo
            printWriter.close();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}	
	}
	//metodo que le fatuamento.txt e tranforma a string em um Double e retorna esse double
	public double getFaturamentoTxt()
	{
		File dir = new File("arquivos");
		File arq = new File(dir, "faturamento.txt");
		Double val = 0.0;

		try {
			Scanner arquivo = new Scanner(new FileReader(arq));
			while(arquivo.hasNextLine())
			{
				String linha = arquivo.nextLine();
				val = linha != null ? Double.parseDouble(linha): 0.0;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return val;
	}
	//metodo que recebe um double p, e atualiza o faturamento
	public void atualizaFaturamentoTxt(double p)
	{
		double b = this.getFaturamentoTxt();
		this.escreveFaturamento(p+b);
	}
	//metodo que recebe um arraylist de aluguel
	//procura os clientes que tem pendencia
	//imprime nome, valor da pendencia e o carro.
	public void imprimeDevedores(ArrayList<Aluguel> alugueis)
	{
		Carros c;
		Pessoa p;
		for(Aluguel itens : alugueis)
		{
			c = itens.getCarro();
			p = itens.getPessoa();
			if(p.getValorPendencia() > 0 && p.getPendencia())
			{
				System.out.printf("Nome: %s\nValor: %.2f\nModelo: %s\n", itens.getNome(), 
				p.getValorPendencia(), itens.getModelo());
			}
		}
	}
}
