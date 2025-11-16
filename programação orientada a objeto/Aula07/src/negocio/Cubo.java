package negocio;

public class Cubo implements Solido {
	// Propriedades da classe
	private double aresta = 0;

	// Métodos construtores da classe
	public Cubo() {
		super();
	}

	public Cubo(double aresta) {
		super();
		this.aresta = aresta;
	}

	// Métodos de acesso da classe
	public double getAresta() {
		return aresta;
	}

	public void setAresta(double aresta) {
		this.aresta = aresta;
	}
	
	// Métodos implementados da interface
	public double calcularArea() {
		return (6 * Math.pow(getAresta(), 2));
	}
	
	public double calcularVolume() {
		return (Math.pow(getAresta(), 3));
	}
}
