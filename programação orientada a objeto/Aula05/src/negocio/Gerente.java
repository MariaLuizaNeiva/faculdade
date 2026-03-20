package negocio;
// extends indica a herança -> gerente é filho de colaborador
public class Gerente extends Colaborador {
	// Propriedades da classe
	private double bonus = 0;

	// Métodos construtores da classe
	public Gerente() {
		super();
	}
	// Mudar o colaborador, lá em cima
	// Método construtor de subclasse tem que estar totalmente cheio!!!
	public Gerente(int matricula, String nome, double salario, double bonus) {
		super(matricula, nome, salario);
		this.bonus = bonus;
	}
	
	// Métodos de acesso da classe
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	// Métodos sobrescritos da classe
	public double getSalario() {
		// o super referencia a superclasse; já o this referencia a classe em que estamos trabalhando no momento
		return(super.getSalario() + this.getBonus());
	}
}
