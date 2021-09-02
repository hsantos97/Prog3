
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
	public Pessoa buscaCliente(ArrayList<Pessoa> pessoa, String nome)
	{
		for(Pessoa p : pessoa)
		{
			if(p instanceof PessoaFisica)
			{
				if(nome.equalsIgnoreCase(p.getNome()))
				{
					((PessoaFisica) p).printPessoaFisica();
					return p;
				}
			}
			else if(p instanceof PessoaJuridica)
			{
				if(nome.equalsIgnoreCase(p.getNome()))
				{
					((PessoaJuridica) p).printPessoaJuridica();
					return p;
				}
			}
		}
		System.out.println("CLIENTE NÃO ENCONTRADO !!");
		return null;	
	}
	
	public Carros buscaCarro(ArrayList<Carros> carro, String modelo)
	{
		for(Carros c : carro)
		{
			if(modelo.equalsIgnoreCase(c.getModelo()))
			{
				//c.calculaValorDiaria();
				c.printCarro();
				//System.out.println("valor pendente:"+c.getValorPendente());
				return c;
			}
		}
		System.out.println("CARRO NÃO ENCONTRADO !!");
		return null;	
	}
	
	public void criaArqTxt()
	{
		java.io.File diretorio = new java.io.File("arquivo");
		java.io.File arquivo = new java.io.File(diretorio, "cliente.txt");
		java.io.File arquivo2 = new java.io.File(diretorio, "carros.txt");
		java.io.File arquivo3 = new java.io.File(diretorio, "alugueis.txt");
		try {
			boolean statusArq = arquivo.createNewFile(); //criando o arquivo fisico
			boolean statusArq2 = arquivo2.createNewFile();
			boolean statusArq3 = arquivo3.createNewFile();
			System.out.print(statusArq);
			System.out.print(statusArq2); 
			System.out.print(statusArq3);
		} catch (IOException e) {
		    e.printStackTrace(); 
		}
		if (diretorio.exists()) {
			System.out.println("Diretório existe!");
		    if (arquivo.exists())
		    	System.out.println("Arquivo existe!");
		    if(arquivo2.exists())
		    	System.out.println("Arquivo existe!");
		    if(arquivo3.exists())
		    	System.out.println("Arquivo existe!");
		}	
	}
	
	public void escreveArqPf(PessoaFisica pf)
	{
		try 
		{	
			FileWriter fileWriter = new FileWriter("./arquivos/cliente.txt", true);
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
	
	public void escreveArqPj(PessoaJuridica pj)
	{
		try 
		{
			FileWriter fileWriter = new FileWriter("./arquivos/cliente.txt", true);
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

	public ArrayList<Carros> getCarroTxt()
	{
		File dir = new File("arquivos");
		File arq = new File(dir, "carros.txt");
		ArrayList<Carros> car = new ArrayList<>();
		
		try {
			Scanner arquivo = new Scanner(new FileReader(arq));
			while(arquivo.hasNextLine())
			{
				String linha = arquivo.nextLine();
				//System.out.println(linha);
				String[] itens = linha.split(" ");
				Carros c = new Carros(itens[0], Integer.parseInt(itens[1]), itens[2], Integer.parseInt(itens[3]), 
						Boolean.parseBoolean(itens[4]), Double.parseDouble(itens[5]), itens[6]);
				c.setDataEntrega(itens[8]!= null ? itens[8]:"null" );
				c.setDataAluguel(itens[7]);
				car.add(c);
			}//PODE TESTAR
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return car;
	}
	
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

				if(itens.length == 5){
					PessoaFisica pf = new PessoaFisica(itens[0], itens[1], itens[2], itens[3]);
					if(Double.parseDouble(itens[4])>0){
						pf.setPendencia(true);
						pf.setValorPendencia(Double.parseDouble(itens[4]));
					}else{
						pf.setPendencia(false);
						pf.setValorPendencia(0);
					} 
					pe.add(pf);
				}
				else if(itens.length == 6){
					PessoaJuridica pj = new PessoaJuridica(itens[0], itens[1], itens[2], itens[3], itens[4]);
					if(Double.parseDouble(itens[5])>0){
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
	
	public void escreveArqAlugueis(Pessoa p, Carros c, boolean alugar)
	{
		try 
		{
			
			if(alugar)
			{
				FileWriter fileWriter = new FileWriter("./arquivos/alugueis.txt", true);
				PrintWriter printWriter = new PrintWriter(fileWriter);
				
				if(p instanceof PessoaFisica)
					printWriter.printf("%s %s %s %s %s %n", p.getNome(), ((PessoaFisica) p).getCpf(), 
							c.getModelo(), c.getPlaca(), c.getDataAluguel());
				if(p instanceof PessoaJuridica)
					printWriter.printf("%s %s %s %s %s %n", p.getNome(), ((PessoaJuridica) p).getCnpj(),
							c.getModelo(), c.getPlaca(), c.getDataAluguel());
				
				//System.out.println(p.getNome()+" ESCREVE ALUGUEIS");
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
	
	public boolean verificar(ArrayList<Pessoa> pessoa, String documento)
	{
		for(Pessoa p : pessoa)
		{
			if(p instanceof PessoaFisica)
			{
				if(documento.equals(((PessoaFisica) p).getCpf()))
					return true;
			}
			if(p instanceof PessoaJuridica)
			{
				if(documento.equals(((PessoaJuridica) p).getCnpj()))
					return true;
			}
		}
		return false;	
	}
	
	public boolean verificarCarro(ArrayList<Carros> carros, String placa)
	{
		for(Carros c : carros)
		{
			if(placa.equals(c.getPlaca()))
					return true;
		}
		return false;	
	}
	
	public void atualizaCarroTxt(ArrayList<Carros> carros, Carros c)
	{
		for(int i = 0; i <= carros.size()-1; i++)
		{	
			Carros aux = carros.get(i);
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
					//System.out.println("Entrou fisico");
					printWriter.printf("%s %s %s %s %.2f %n", pes.getNome(), pes.getEndereco(), pes.getTelefone(), 
						((PessoaFisica) pes).getCpf(), pes.getValorPendencia());
					
						//o método flush libera a escrita no arquivo
					printWriter.flush();
				}else if(pes instanceof PessoaJuridica && ((PessoaJuridica)pes).getCnpj()!=null){
					//System.out.println("Entrou juridico");
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
	
	public Aluguel buscaAluguel(ArrayList<Aluguel> alugueis, String nome, String modelo)
	{
		for(Aluguel aluguel : alugueis)
		{
			Pessoa pessoa;
			Carros carro;
			pessoa = aluguel.getPessoa();
			carro = aluguel.getCarro();
			if((pessoa.getNome().equals(nome)) && (carro.getModelo().equals(modelo)))	
				return aluguel;

		}
		return null;	
	}
	
	public ArrayList<Aluguel> atualizaAluguel(ArrayList<Aluguel> alugueis, Aluguel aluguel)
	{
		for(int i = 0; i < alugueis.size()-1; i++)
		{
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
	
	//sobrescreve txt alugueis passando array de objetos alugueis como parâmetro
	public void atualizaTxtAluguel(ArrayList<Aluguel> alugueis)
	{	
		System.out.println("-> ATUALIZA TXT ALUGUEL !");
		System.out.printf("Tamanho array:%d |\n",alugueis.size());
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
						c.getPlaca(), c.getDataAluguel(), c.getDataEntrega());
				}
				if(p instanceof PessoaJuridica)
					printWriter.printf("%s %s %s %s %s %s %n", p.getNome(), ((PessoaJuridica) p).getCnpj(), c.getModelo(), 
							c.getPlaca(), c.getDataAluguel(), c.getDataEntrega());
				
				printWriter.flush();
			}
			
			printWriter.close();
			/*
			for(int i = 0; i < alugueis.size()-1; i++)
			{
				Aluguel alu = alugueis.get(i);
				Pessoa p = alu.getPessoa();
				Carros c = alu.getCarro();
				System.out.println("-> entrou!");
				if(p instanceof PessoaFisica)
					printWriter.printf("%s %s %s %s %s %s %n", p.getNome(), ((PessoaFisica) p).getCpf(), c.getModelo(), 
							c.getPlaca(), c.getDataAluguel(), alu.getFim());
				if(p instanceof PessoaJuridica)
					printWriter.printf("%s %s %s %s %s %s %n", p.getNome(), ((PessoaJuridica) p).getCnpj(), c.getModelo(), 
							c.getPlaca(), c.getDataAluguel(), alu.getFim());
					
				System.out.println(p.getNome()+" ->ATUALIZA TXT ALUGUEL !");
				//o método flush libera a escrita no arquivo
				printWriter.flush();
			}
			//No final precisamos fechar o arquivo
            printWriter.close();
			*/
	            
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
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

	public String dataAtual(){
		Date data = new Date(System.currentTimeMillis()); 
		SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyy");
		return formatarDate.format(data);
	}
}
