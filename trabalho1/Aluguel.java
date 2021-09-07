import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Aluguel {
	private Carros carro;
	private Pessoa pessoa;
	//private String dataInicio;
	private String fim;
	private boolean status;
	private String nome;
	private String modelo;
	private Double valorDeAluguel;
	
	//construtor
	public Aluguel(Carros carro, Pessoa pessoa)
	{
		this.carro = carro;
		this.pessoa = pessoa;
		this.nome = pessoa.getNome();
		this.modelo = carro.getModelo();
	}
	
	//setts
	public void setCarro(Carros c) { this.carro = c; }
	public void setPessoa(Pessoa p) { this.pessoa = p; }
	public void setValorDeAluguel(Double valor) { this.valorDeAluguel = valor; }
	//public void setDataInicio(String ini){ this.dataInicio = ini; }
	
	//get
	public Carros getCarro() { return this.carro; }
	public Pessoa getPessoa() { return this.pessoa; }
	public boolean getStatus() { return this.status; }
	public String getFim() { return this.fim; }
	public String getNome(){return this.nome;}
	public String getModelo(){return this.modelo;}
	public Double getValorDeAluguel() { return this.valorDeAluguel; }
	//public String getDataIniciio() { return this.dataInicio; }
	
	public void forceFim(String fim){
		this.fim = fim; //getFim
	}
	/*public String getFimReal(){
		return this.carro.getDataEntrega();
	} */
	//metodo para fazer o aluguel do carro, caso seja alugado retorna true se não retorna false
	public boolean alugar()
	{
		if(this.carro.getSituacao() && !this.pessoa.getPendencia()) //verifica a situação e a pendencia do cliente
		{
			Date data = new Date(System.currentTimeMillis()); 
			SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyy"); 
			System.out.println("Data do alugel: "+formatarDate.format(data));
			this.carro.setDataAluguel(formatarDate.format(data));
			this.carro.setSituacao(false); //deixando o carro indisponivel
			System.out.println("Carro alugado !!");
			return true;
		}
		else if(!this.carro.getSituacao())
		{
			System.out.println("Carro não pode ser alugado !!");
			return false;
		}
		else if(this.pessoa.getPendencia())
		{
			System.out.println("Cliente com pendencia");
			return false;
		}
		return false;
	}
	//metodo que recebe a quilometragem final do carro, data de inicio e fim do aluguel, nome e modelo
	//e uma variavel inteira para representar se o cliente pagou o carro.
	public void devolverCarro(int quilometragem, String inicio, String fim, String nome, String modelo, int pago)
	{
		int quilometragemAndada = (quilometragem - this.carro.getQuilometragem());//calculando quilometros andados
		this.carro.setQuilometragem(quilometragemAndada);
		System.out.printf("Quilometragem atualizada: %dKm\nQuilometros andados:%dKm\n", 
				this.carro.getQuilometragem(), quilometragemAndada);
		
		/* diferença de dias entre duas datas, transforme-as para milissegundos, obtenha a diferença, 
		  some 1 hora (devido a problemas de horário de verão etc.) e divida por 86400000. */
		DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
        df.setLenient(false); //metodo do objeto SimpleDateFormat passando false para que utilize o formato desejado
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

        double valorPendente =(dt / 86400000L)*(this.carro.getTaxaDiaria());
        this.valorDeAluguel = valorPendente;
		
        //sett na pendencia, caso pago = 0 quer dizer que o cliente pagou o carro e não vai ficar com pendencia
        if(pago == 0){
        	this.pessoa.setValorPendencia(0.0);
        }else{
			this.pessoa.setValorPendencia(valorPendente);
			//this.pessoa.pagar(valorPendente);
		}	
        
        System.out.println ("valor a pagar:"+valorPendente);
        
        //colocando o carro disponivel novamente
        this.carro.setSituacao(true);
        
        //data de devolução
        //this.fim = fim;
		this.carro.setDataEntrega(fim);
        
        //status do alugel
        this.status = true;
	}
}