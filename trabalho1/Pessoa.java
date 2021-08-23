public class Pessoa {

	private String nome;
	private String endereco;
	private String telefone;
	
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
	
	//setts
	public void setEndereco(String endereco) { this.endereco = endereco; }
	public void setTelefone(String telefone) { this.telefone = telefone; }	
	
	public void printPessoa()
	{
		System.out.printf("Nome: %s\nEndereço: %s\nTelefone: %s\n", this.nome, this.endereco, this.telefone);
	}
	
	
}
