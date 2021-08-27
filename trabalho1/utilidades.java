import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
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
				System.out.println("valor pendente:"+c.getValorPendente());
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
		try {
			boolean statusArq = arquivo.createNewFile();
			boolean statusArq2 = arquivo2.createNewFile();
			System.out.print(statusArq);
			System.out.print(statusArq2);
		} catch (IOException e) {
		    e.printStackTrace(); 
		}
		if (diretorio.exists()) {
			System.out.println("Diretório existe!");
		    if (arquivo.exists())
		    	System.out.println("Arquivo existe!");
		    if(arquivo2.exists())
		    	System.out.println("Arquivo existe!");
		}	
	}
	
	public void escreveArqPf(PessoaFisica pf)
	{
		try 
		{
			FileWriter fileWriter = new FileWriter("cliente.txt", true);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.println(pf.getNome()+" "+pf.getEndereco()+" "+pf.getTelefone()+" "+pf.getCpf()+" "+pf.getValorPendencia());
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
			printWriter.println(pj.getNome()+" "+pj.getEndereco()+" "+pj.getTelefone()+" "+pj.getCnpj()
			+" "+pj.getRazaoSocial()+" "+pj.getValorPendencia());
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
			printWriter.println(c.getModelo()+" "+c.getAno()+" "+c.getPlaca()+" "+c.getQuilometragem()+" "+c.getSituacao()
					+" "+c.getObservacoes());
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
	
	public void busca(String nome)
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
	        	if(bufferedReader.readLine().equalsIgnoreCase(nome))
	        		System.out.println(linha);
	        	else
	        		System.out.println("CLIENTE NÃO ENCONTRADO !!");
	    }
			//liberamos o fluxo dos objetos ou fechamos o arquivo
	        fileReader.close();
	        bufferedReader.close();
		} catch (IOException e) {
	    	e.printStackTrace();
	    }
	}
}
