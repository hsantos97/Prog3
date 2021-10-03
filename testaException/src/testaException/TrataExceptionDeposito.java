package testaException;

public class TrataExceptionDeposito extends RuntimeException{
	private double valor;
	
	public TrataExceptionDeposito(String str, double valor)
	{
		super(str);
		this.valor = valor;
	}
	public double getValor() { return this.valor; }
	
}
