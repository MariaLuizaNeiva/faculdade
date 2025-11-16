package negocio;

public class Caipirinha extends Drink implements Mixer {
	public void misturar() {
		super.adicionar(new Ingrediente("Cachaça", 50, "ml"));
		super.adicionar(new Ingrediente("Limão", 3, "unidade"));
		super.adicionar(new Ingrediente("Açúcar", 5, "g"));
		super.adicionar(new Ingrediente("Gelo", 5, "pedras"));
	}
}