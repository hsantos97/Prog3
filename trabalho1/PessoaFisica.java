
public class PessoaFisica extends Pessoa {
	private String cpf;

	public PessoaFisica(String nome, String endereco, String telefone, String cpf) {
		super(nome, endereco, telefone);
		this.cpf = cpf;
	}
	
	//get
	public String getCpf() { return this.cpf; }
	
	public void printPessoaFisica()
	{
		System.out.printf("Nome: %s\nEndereço: %s\nTelefone: %s\nCPF: %s\nValor da Pendencia: %.2f\n", getNome(), 
				getEndereco(), getTelefone(), this.cpf, getValorPendencia());
	}
}
