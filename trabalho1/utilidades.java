import java.util.ArrayList;

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
				c.calculaValorDiaria();
				c.printCarro();
				return c;
			}
		}
		System.out.println("CARRO NÃO ENCONTRADO !!");
		return null;
		
	}
}
