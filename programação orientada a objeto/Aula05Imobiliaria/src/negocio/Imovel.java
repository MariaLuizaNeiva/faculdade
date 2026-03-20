package negocio;

public abstract class Imovel {
	// Propriedades da classe
	private String endereço = "";
	private double metragem = 0;
	private double valor = 0;
	
	// Métodos construtores da classe
	public Imovel() {
		super();
	}

	public Imovel(String endereço, double metragem, double valor) {
		super();
		this.endereço = endereço;
		this.metragem = metragem;
		this.valor = valor;
	}

	// Métodos de acesso da classe
	public String getEndereço() {
		return endereço;
	}

	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}

	public double getMetragem() {
		return metragem;
	}

	public void setMetragem(double metragem) {
		this.metragem = metragem;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
