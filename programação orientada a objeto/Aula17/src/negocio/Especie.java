package negocio;

import java.util.ArrayList;

import persistencia.EspecieDAO;

public class Especie {
	// Propriedades da classe
	private int id = 0;
	private String descricao = "";
	
	// Métodos construtores da classe
	public Especie() {
		super();
	}
	
	public Especie(int id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}
	
	// Métodos de acesso da classe
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	// Métodos da classe
	public static ArrayList<Especie> getTodos() throws Exception {
		return new EspecieDAO().getTodos();
	}
}
