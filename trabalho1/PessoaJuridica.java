public class PessoaJuridica extends Pessoa{
	private String razaoSocial;
	private String cnpj;
	
	public PessoaJuridica(String nome, String endereco, String telefone, String razaoSocial, String cnpj) {
		super(nome, endereco, telefone);
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
	}
	
	//gets
	public String getRazaoSocial() { return this.razaoSocial; }
	public String getCnpj() { return this.cnpj; }
	
	public void printPessoaJuridica()
	{
		System.out.printf("Nome: %s\nEndereço: %s\nTelefone: %s\nCNPJ: %s\nRazao Social: %s\n", getNome(), getEndereco(), getTelefone(), this.cnpj, this.razaoSocial);
	}
}
