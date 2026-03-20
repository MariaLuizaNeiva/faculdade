package negocio;

public abstract class Mamifero extends Animal{
	// Propriedades da classe
	private int litrosLeite = 0;

	// Métodos construtores da classe
	public Mamifero() {
		super();
	}

	public Mamifero(double peso, double altura, String nome, int litrosLeite) {
		super(peso, altura, nome);
		this.litrosLeite = litrosLeite;
	}

	// Métodos de acesso da classe
	public int getLitrosLeite() {
		return litrosLeite;
	}

	public void setLitrosLeite(int litrosLeite) {
		this.litrosLeite = litrosLeite;
	}	
}
