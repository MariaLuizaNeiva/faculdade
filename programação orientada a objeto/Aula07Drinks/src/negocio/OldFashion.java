package negocio;

public class OldFashion extends Drink implements Mixer {
	public void misturar() {
		super.adicionar(new Ingrediente("Whisky", 50, "ml"));
		super.adicionar(new Ingrediente("Bitter", 5, "ml"));
		super.adicionar(new Ingrediente("Laranja", 1, "rodela"));
		super.adicionar(new Ingrediente("Gelo", 1, "bola"));
	}
}