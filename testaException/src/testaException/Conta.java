package testaException;

public class Conta {
	private double saldo;
	public Conta()
	{
		this.saldo = 0.0;
	}
	
	public double getSaldo() { return  this.saldo; }
	
	public void deposita(double valor)
	{
		if(valor < 0)
			throw new TrataExceptionDeposito("Valor de desposito negativo", valor);
		else
		{
			this.saldo += valor;
		}
	}
	
	public void saque(double valor)
	{
		if(this.saldo < valor)
			throw new IllegalArgumentException("Valor de saque maior que o saldo");
		else
		{
			this.saldo -= valor;
		}
	}
}
