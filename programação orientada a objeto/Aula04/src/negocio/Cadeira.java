package negocio;

public class Cadeira {
	// Propriedades da classe
	private String nome="";

	// Métodos construtores da classe
	public Cadeira() {

	}

	public Cadeira(String nome) {
		this.nome = nome;
	}

	// Métodos de acesso da classe
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
