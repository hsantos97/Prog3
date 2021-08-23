
public class main {
	public static void main(String[] args)
	{
		/*PessoaFisica pf = new PessoaFisica("harison", "Goiabal", "24999162280", "11989768709");
		PessoaJuridica pj = new PessoaJuridica("goiabas fc", "Goiabal", "24999162280", "Clube", "24/6464-3");
		
		pf.printPessoaFisica();
		pj.printPessoaJuridica();*/
		
		Carros c = new Carros("KVG-123", 2020, "SUV", 1223, "disponivel", 7.5);
		c.calculaValorDiaria();
		c.printCarro();
	}
}
