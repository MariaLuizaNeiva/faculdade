package negocio;

public class DryMartini extends Drink implements Mixer {
	public void misturar() {
		super.adicionar(new Ingrediente("Gin", 50, "ml"));
		super.adicionar(new Ingrediente("Vodka", 30, "ml"));
		super.adicionar(new Ingrediente("Vermuth", 5, "ml"));
		super.adicionar(new Ingrediente("Azeitona", 3, "unidade"));
		super.adicionar(new Ingrediente("Gelo", 10, "pedras"));
	}
}