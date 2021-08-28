import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
		java.io.File diretorio = new java.io.File("/home/harison/Documents/prog3/Prog3/trabalho1");
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
			FileWriter fileWriter = new FileWriter("cliente.txt", true);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.printf("%s %s %s %s %.2f %n", pf.getNome(), pf.getEndereco(), pf.getTelefone(), pf.getCpf(), 
					pf.getValorPendencia());
			//printWriter.println(pf.getNome()+" "+pf.getEndereco()+" "+pf.getTelefone()+" "+pf.getCpf()+" "+pf.getValorPendencia());
			/*printWriter.println(pf.getEndereco());
			printWriter.println(pf.getTelefone());
			printWriter.println(pf.getCpf());
			printWriter.println(pf.getValorPendencia()); */
			
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
			FileWriter fileWriter = new FileWriter("cliente.txt", true);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.printf("%s %s %s %s %s %.2f %n", pj.getNome(), pj.getEndereco(), pj.getTelefone(), pj.getRazaoSocial(), 
					pj.getCnpj(), pj.getValorPendencia());
			/*printWriter.println(pj.getNome()+" "+pj.getEndereco()+" "+pj.getTelefone()+" "+pj.getCnpj()
			+" "+pj.getRazaoSocial()+" "+pj.getValorPendencia()); */
			//printWriter.println(pj.getEndereco());
			//printWriter.println(pj.getTelefone());
			//printWriter.println(pj.getCnpj());
			//printWriter.println(pj.getRazaoSocial());
			//printWriter.println(pj.getValorPendencia());
			
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
			FileWriter fileWriter = new FileWriter("carros.txt", true);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			/*printWriter.println(c.getModelo()+" "+c.getAno()+" "+c.getPlaca()+" "+c.getQuilometragem()+" "+c.getSituacao()
					+" "+c.getObservacoes()); */
			printWriter.printf("%s %d %s %d %b %.2f %s %n", c.getPlaca(), c.getAno(), c.getModelo(), 
					c.getQuilometragem(), c.getSituacao(), c.getTaxaDiaria(), c.getObservacoes());
			/*printWriter.println(c.getAno());
			printWriter.println(c.getPlaca());
			printWriter.println(c.getQuilometragem());
			printWriter.println(c.getSituacao());
			printWriter.println(c.getObservacoes()); */
			
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
		File dir = new File("/home/harison/Documents/prog3/Prog3/trabalho1");
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
		File dir = new File("/home/harison/Documents/prog3/Prog3/trabalho1");
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
	
	/*public String busca(String nome) {
		try {
			FileReader reader = new FileReader("cliente.txt");
			BufferedReader leitor = new BufferedReader(reader);
			String linha = "";
			

			while(true) {
				linha = leitor.readLine();
				if( linha == null ) {
					break;
				}
				if( linha.matches(nome) ) {
					return linha;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "texto não encontrado";
	} */
	
	public ArrayList<Carros> getCarroTxt()
	{
		File dir = new File("/home/harison/Documents/prog3/Prog3/trabalho1");
		File arq = new File(dir, "carros.txt");
		ArrayList<Carros> car = new ArrayList<>();
		
		try {
			Scanner arquivo = new Scanner(new FileReader(arq));
			while(arquivo.hasNextLine())
			{
				String linha = arquivo.nextLine();
				//System.out.println(linha);
				String[] itens = linha.split(" ");
				
				car.add(new Carros(itens[0], Integer.parseInt(itens[1]), itens[2], Integer.parseInt(itens[3]), 
						Boolean.parseBoolean(itens[4]), Double.parseDouble(itens[5]), itens[6]));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return car;
	}
	
	public ArrayList<Pessoa> getPessoaTxt()
	{
		File dir = new File("/home/harison/Documents/prog3/Prog3/trabalho1");
		File arq = new File(dir, "cliente.txt");
		ArrayList<Pessoa> pe = new ArrayList<>();
		
		try {
			Scanner arquivo = new Scanner(new FileReader(arq));
			while(arquivo.hasNextLine())
			{
				String linha = arquivo.nextLine();
				String[] itens = linha.split(" ");

				if(itens.length == 5)
					pe.add(new PessoaFisica(itens[0], itens[1], itens[2], itens[3]));
				else if(itens.length == 6)
					pe.add(new PessoaJuridica(itens[0], itens[1], itens[2], itens[3], itens[4]));
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
			FileWriter fileWriter = new FileWriter("alugueis.txt", true);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			if(alugar)
			{
				if(p instanceof PessoaFisica)
					printWriter.printf("%s %s %s %s %s %b %n", p.getNome(), ((PessoaFisica) p).getCpf(), 
							c.getModelo(), c.getPlaca(), c.getDataAluguel(), c.getSituacao());
				if(p instanceof PessoaJuridica)
					printWriter.printf("%s %s %s %s %s %b %n", p.getNome(), ((PessoaJuridica) p).getCnpj(), 
							c.getModelo(), c.getPlaca(), c.getDataAluguel(), c.getSituacao());
			}
			else
				System.out.println("FALHA NO ALUGUEL !!");
			
			//o método flush libera a escrita no arquivo
            printWriter.flush();
            
            //No final precisamos fechar o arquivo
            printWriter.close();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}	
	}
}
