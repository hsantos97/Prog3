import java.time.LocalDate; 
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
	private double valorPendente;
	private String dataAluguel;
	private String dataEntrega;
	
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
	public String getModelo() { return this.modelo; }
	public int getQuilometragem() { return this.quilometragem; }
	public boolean getSituacao() { return this.situacao; }
	public double getTaxaDiaria() { return this.taxaDiaria; }
	public String getObservacoes() { return this.observacoes; }
	public double getValorPendente() { return this.valorPendente; }
	public String getDataAluguel() { return this.dataAluguel; }
	public String getDataEntrega() { return this.dataEntrega; }

	//sets
	public void setQuilometragem(int quilometragem) { this.quilometragem += quilometragem; }
	public void setSituacao(boolean situacao) { this.situacao = situacao; }
	public void setTaxaDiaria(double taxaDiaria) { this.taxaDiaria = taxaDiaria; }
	public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
	public void setValorPendente(double valorPendente) { this.valorPendente = valorPendente; }
	public void setDataAluguel(String dataAluguel) { this.dataAluguel = dataAluguel; }
	public void setDataEntrega(String dataEntrega) { this.dataEntrega = dataEntrega; }
	//metodo para imprimir os atributos do carro
	public void printCarro()
	{
		System.out.printf("Placa: %s\nAno: %d\nModelo: %s\nQuilometragem: %d\nSituação: %b\nTaxa Diaria: %.2f\n", 
				this.placa, this.ano, this.modelo, this.quilometragem, this.situacao, this.taxaDiaria);
	}

	@Override
	public void calculaValorDiaria() {
		if(this.ano == 2021)
		{
			double aumentoTaxa = this.taxaDiaria + (this.taxaDiaria * 0.5);
			//setTaxaDiaria(aumentoTaxa);
			this.taxaDiaria = aumentoTaxa;
			//return aumentoTaxa;
		}
		else if(this.ano >= 2019)
		{
			double aumentoTaxa = this.taxaDiaria + (this.taxaDiaria * 0.2);
			//setTaxaDiaria(aumentoTaxa);
			this.taxaDiaria = aumentoTaxa;
			//return aumentoTaxa;
		}
	}
}
