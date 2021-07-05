public class Funcionario {
	//variaveis de instancia
	private String nome;
	private double salario;
	
	//construtor
	public Funcionario()
	{
		this.nome = "";
		this.salario = 0.0;
	}
	
	public Funcionario(String nome)
	{
		this(nome, 0.0);
	}
	
	public Funcionario(String nome, double salario)
	{
		this.nome = nome;
		this.salario = salario;
	}
	
	//getters
	public String getNome()
	{
		return this.nome;
	}
	
	public double getSalario()
	{
		return this.salario;
	}
	
	public void aumentarSalario(double percentual)
	{
		double aumento = this.salario * (percentual/100);
		this.salario += aumento;
	}
}
