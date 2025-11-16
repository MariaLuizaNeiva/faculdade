package negocio;

public class MoscowMule extends Drink implements Mixer {
	public void misturar() {
		super.adicionar(new Ingrediente("Vodka", 50, "ml"));
		super.adicionar(new Ingrediente("Gengibre", 10, "g"));
		super.adicionar(new Ingrediente("Limão", 3, "unidades"));
		super.adicionar(new Ingrediente("Açúcar", 5, "g"));
		super.adicionar(new Ingrediente("Gelo", 5, "pedras"));
		super.adicionar(new Ingrediente("Espuma de gengibre", 20, "ml"));
	}
}