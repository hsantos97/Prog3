import java.time.LocalDate; 
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Period;

public class Carros implements CalculaValor {
	private String placa;
	private int ano;
	private String modelo;
	private int quilometragem;
	private boolean situacao;
	private double taxaDiaria;
	private String observacoes;
	
	//construtor
	public Carros(String placa, int ano, String modelo, int quilometragem, boolean situacao, double taxaDiaria, String observacoes)
	{
		this.placa = placa;
		this.ano = ano;
		this.modelo = modelo;
		this.quilometragem = quilometragem;
		this.situacao = situacao;
		this.taxaDiaria = taxaDiaria;
		this.observacoes = observacoes;
	}
	
	//getts
	public String getPlaca() { return this.placa; }
	public int getAno() { return this.ano; }
	public String modelo() { return this.modelo; }
	public int getQuilometragem() { return this.quilometragem; }
	public boolean getSituacao() { return this.situacao; }
	public double getTaxaDiaria() { return this.taxaDiaria; }
	public String getObservacoes() { return this.observacoes; }
	
	//sets
	public void setQuilometragem(int quilometragem) { this.quilometragem += quilometragem; }
	public void setSituacao(boolean situacao) { this.situacao = situacao; }
	public void setTaxaDiaria(double taxaDiaria) { this.taxaDiaria = taxaDiaria; }
	public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
	
	public void printCarro()
	{
		System.out.printf("Placa: %s\nAno: %d\nModelo: %s\nQuilometragem: %d\nSituação: %b\nTaxa Diaria: %.2f\n", 
				this.placa, this.ano, this.modelo, this.quilometragem, this.situacao, this.taxaDiaria);
	}

	@Override
	public double calculaValorDiaria() {
		if(this.ano == 2021)
		{
			double aumentoTaxa = getTaxaDiaria() + (getTaxaDiaria() * 0.5);
			setTaxaDiaria(aumentoTaxa);
			return aumentoTaxa;
		}
		else if(this.ano >= 2019)
		{
			double aumentoTaxa = getTaxaDiaria() + (getTaxaDiaria() * 0.2);
			setTaxaDiaria(aumentoTaxa);
			return aumentoTaxa;
		}
		else
		{
			double aumentoTaxa = getTaxaDiaria();
			return aumentoTaxa;
		}
		
	}
	
	public void getRecibo(int quilometragem, String inicio, String fim)
	{
		setQuilometragem(quilometragem);
		System.out.println("quilometragem atualizada: " +getQuilometragem()+"km");
		
		/* diferença de dias entre duas datas, transforme-as para milissegundos, obtenha a diferença, 
		  some 1 hora (devido a problemas de horário de verão etc.) e divida por 86400000. */
		DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
        df.setLenient(false);
        Date d1 = null;
		try {
			d1 = df.parse (inicio);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        Date d2 = null;
		try {
			d2 = df.parse (fim);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        long dt = (d2.getTime() - d1.getTime()) + 3600000; // 1 hora para compensar horário de verão
        System.out.println ("Dias com o carro:"+dt / 86400000L);
        System.out.println ("valor a pagar:"+(dt / 86400000L)*(this.taxaDiaria));
	}
	
	
}
