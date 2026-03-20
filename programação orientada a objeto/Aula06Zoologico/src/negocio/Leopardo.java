package negocio;

public class Leopardo extends Mamifero{
	// Propriedades da classe
	private double velocidade = 0;

	// Métodos construtores da classe
	public Leopardo() {
		super();
	}

	public Leopardo(double peso, double altura, String nome, int litrosLeite, double velocidade) {
		super(peso, altura, nome, litrosLeite);
		this.velocidade = velocidade;
	}

	// Métodos de acesso da classe
	public double getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(double velocidade) {
		this.velocidade = velocidade;
	}
	
	// Métodos da classe
	public void correr() {
		System.out.println("Run, Forrest ! Run !");
	}
}
