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
	//private double taxaPorKm;
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
		//this.taxaPorKm = taxaPorKm;
		this.observacoes = observacoes;
		//this.valorPendente = valorPendente;
	}
	
	//getts
	public String getPlaca() { return this.placa; }
	public int getAno() { return this.ano; }
	public String getModelo() { return this.modelo; }
	public int getQuilometragem() { return this.quilometragem; }
	public boolean getSituacao() { return this.situacao; }
	public double getTaxaDiaria() { return this.taxaDiaria; }
	//public double getTaxaPorKm() { return this.taxaPorKm; }
	public String getObservacoes() { return this.observacoes; }
	public double getValorPendente() { return this.valorPendente; }
	public String getDataAluguel() { return this.dataAluguel; }
	public String getDataEntrega() { return this.dataEntrega; }

	//sets
	public void setQuilometragem(int quilometragem) { this.quilometragem += quilometragem; }
	public void setSituacao(boolean situacao) { this.situacao = situacao; }
	public void setTaxaDiaria(double taxaDiaria) { this.taxaDiaria = taxaDiaria; }
	//public void setTaxaPorKm(double taxaPorKm) { this.taxaPorKm = taxaPorKm; }
	public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
	public void setValorPendente(double valorPendente) { this.valorPendente = valorPendente; }
	public void setDataAluguel(String dataAluguel) { this.dataAluguel = dataAluguel; }
	public void setDataEntrega(String dataEntrega) { this.dataEntrega = dataEntrega; }
	
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
	
	/*public double calculaValorKm() {
		if(this.ano == 2021)
		{
			double aumentoTaxa = (getTaxaPorKm() + (getTaxaPorKm() * 0.5));
			setTaxaPorKm(aumentoTaxa);
			return aumentoTaxa;
		}
		else if(this.ano >= 2019)
		{
			double aumentoTaxa = getTaxaPorKm() + (getTaxaPorKm() * 0.2);
			setTaxaPorKm(aumentoTaxa);
			return aumentoTaxa;
		}
		else
		{
			double aumentoTaxa = getTaxaPorKm();
			return aumentoTaxa;
		}
		
	} */
	
	/*public void devolverCarro(int quilometragem, String inicio, String fim, int pago)
	{
		int quilometragemAndada = (quilometragem - getQuilometragem());
		setQuilometragem(quilometragemAndada);
		System.out.printf("Quilometragem atualizada: %dKm\nQuilometros andados:%dKm\n", getQuilometragem(), quilometragemAndada);
		
		/* diferença de dias entre duas datas, transforme-as para milissegundos, obtenha a diferença, 
		  some 1 hora (devido a problemas de horário de verão etc.) e divida por 86400000. 
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
        double valorPendente =(dt / 86400000L)*(this.taxaDiaria);
        
        //sett na pendencia, caso pago = 0 quer dizer que o cliente pagou o carro e não vai ficar com pendencia
        if(pago == 0)
        	setValorPendente(0.0);
        else
        	setValorPendente(valorPendente);
        
        System.out.println ("valor a pagar:"+valorPendente);
        
        //colocando o carro disponivel novamente
        setSituacao(true);
	}
*/	
	/*public boolean alugarCarro(boolean pendencia)
	{
		if(this.situacao && !pendencia)
		{
			System.out.println("Carro alugado !!");
			Date data = new Date(System.currentTimeMillis()); 
			SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyy"); 
			System.out.println("Data do alugel: "+formatarDate.format(data));
			//Date data = new Date();
			//DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
			//df.format(data);
			//System.out.println("Data do aluguel: "+data);
			this.dataAluguel = formatarDate.format(data);
			setSituacao(false); //deixando o carro indisponivel
			return true;
		}
		else if(!this.situacao)
		{
			System.out.println("Carro não pode ser alugado !!");
			return false;
		}
		else if(pendencia)
		{
			System.out.println("Cliente com pendencia");
			return false;
		}
		return false;
	}*/
	
}
