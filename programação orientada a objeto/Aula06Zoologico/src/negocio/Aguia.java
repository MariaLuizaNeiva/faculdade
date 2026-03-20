package negocio;

public class Aguia extends Ave {
	// Propriedades da classe 
	private double autonomia = 0;

	// Métodos construtores da classe
	public Aguia() {
		super();
	}

	public Aguia(double peso, double altura, String nome, int quantidadeOvos, double autonomia) {
		super(peso, altura, nome, quantidadeOvos);
		this.autonomia = autonomia;
	}

	// Métodos de acesso da classe
	public double getAutonomia() {
		return autonomia;
	}

	public void setAutonomia(double autonomia) {
		this.autonomia = autonomia;
	}
	
	// Métodos da classe
	public void voar() {
		System.out.println("Fly like a an eagle, into de future !");
	}
}
