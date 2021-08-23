
public class Carros implements CalculaValor{
	private String placa;
	private int ano;
	private String modelo;
	private int quilometragem;
	private String situacao;
	private double taxaDiaria;
	
	//construtor
	public Carros(String placa, int ano, String modelo, int quilometragem, String situacao, double taxaDiaria)
	{
		this.placa = placa;
		this.ano = ano;
		this.modelo = modelo;
		this.quilometragem = quilometragem;
		this.situacao = situacao;
		this.taxaDiaria = taxaDiaria;
	}
	
	//getts
	public String getPlaca() { return this.placa; }
	public int getAno() { return this.ano; }
	public String modelo() { return this.modelo; }
	public int getQuilometragem() { return this.quilometragem; }
	public String getSituacao() { return this.situacao; }
	public double getTaxaDiaria() { return this.taxaDiaria; }
	
	//sets
	public void setQuilometragem(int quilometragem) { this.quilometragem = quilometragem; }
	public void setSituacao(String situacao) { this.situacao = situacao; }
	public void setTaxaDiaria(double taxaDiaria) { this.taxaDiaria = taxaDiaria; }
	
	public void printCarro()
	{
		System.out.printf("Placa: %s\nAno: %d\nModelo: %s\nQuilometragem: %d\nSituação: %s\nTaxa Diaria: %.2f\n", 
				this.placa, this.ano, this.modelo, this.quilometragem, this.situacao, this.taxaDiaria);
	}

	@Override
	public void calculaValorDiaria() {
		if(this.ano == 2021)
		{
			double aumentoTaxa = getTaxaDiaria() + (getTaxaDiaria() * 0.5);
			setTaxaDiaria(aumentoTaxa);
		}
		else if(this.ano >= 2019)
		{
			double aumentoTaxa = getTaxaDiaria() + (getTaxaDiaria() * 0.2);
			setTaxaDiaria(aumentoTaxa);
		}
		else
			getTaxaDiaria();
	}
}
