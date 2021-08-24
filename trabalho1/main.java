import java.time.format.DateTimeParseException;

public class main {
	public static void main(String[] args) 
	{
		/*PessoaFisica pf = new PessoaFisica("harison", "Goiabal", "24999162280", "11989768709");
		PessoaJuridica pj = new PessoaJuridica("goiabas fc", "Goiabal", "24999162280", "Clube", "24/6464-3");
		
		pf.printPessoaFisica();
		pj.printPessoaJuridica();*/
		
		Carros c = new Carros("KVG-123", 2021, "SUV", 100, true, 7.5, "novo");
		c.calculaValorDiaria();
		c.printCarro();

		c.getRecibo(200, "10/05/2021", "15/05/2021)");
		
	}
}
