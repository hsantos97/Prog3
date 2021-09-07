public class Pessoa {

	private String nome;
	private String endereco;
	private String telefone;
	private boolean pendencia;
	private double valorPendencia;
	
	//construtor
	public Pessoa(String nome, String endereco, String telefone)
	{
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	
	//gets
	public String getNome() { return this.nome; }
	public String getEndereco() { return this.endereco; }
	public String getTelefone() { return this.telefone; }
	public boolean getPendencia() { return this.pendencia; } 
	public double getValorPendencia() { return this.valorPendencia; }
	
	//setts
	public void setEndereco(String endereco) { this.endereco = endereco; }
	public void setTelefone(String telefone) { this.telefone = telefone; }
	public void setPendencia(boolean pendencia) { this.pendencia = pendencia; }
	public void setValorPendencia(double valorPendencia) 
	{ 
		if(valorPendencia > 0)
		{
			this.valorPendencia = this.valorPendencia+(valorPendencia);
			this.setPendencia(true);
		}
		else
			this.setPendencia(false);
	}	
	//metodo para imprimir a pessoa
	public void printPessoa()
	{
		System.out.printf("Nome: %s\nEndereço: %s\nTelefone: %s\n", this.nome, this.endereco, this.telefone);
	}
	//metodo para pagar as pendencias
	public void pagar(double valor){
		this.valorPendencia -= valor;
		if(this.valorPendencia == 0){
			this.pendencia = false;
		}
	}
}
