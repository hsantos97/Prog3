import java.time.format.DateTimeParseException;

public class main {
	public static void main(String[] args) 
	{
		PessoaFisica pf = new PessoaFisica("harison", "Goiabal", "24999162280", "11989685272");
		//PessoaJuridica pj = new PessoaJuridica("goiabas fc", "Goiabal", "24999162280", "Clube", "24/6464-3");
		
		System.out.println("PRINT DA PESSOA CADASTRADA !!");
		pf.printPessoaFisica();
		//pj.printPessoaJuridica();
		
		Carros c = new Carros("KVG-123", 2021, "SUV", 100, true, 10.0, "novo");
		Carros c2 = new Carros("KVG-122", 2019, "SUV", 1000, true, 10.0, "semi-novo");
		c.calculaValorDiaria();
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
		c.alugarCarro(pf.getPendencia());

	}
}
