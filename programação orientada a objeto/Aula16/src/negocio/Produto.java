package negocio;

import java.util.ArrayList;

import persistencia.ProdutoDAO;

public class Produto {
	// Propriedades da classe
	private int id = 0;
	private String nome = "";
	private double preco = 0;
	
	// Métodos construtores da classe
	public Produto() {
		super();
	}

	public Produto(int id, String nome, double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

	// Métodos de acesso da classe
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}	
	
	// Métodos da classe
	public static ArrayList<Produto> getTodos() throws Exception {
		return new ProdutoDAO().getTodos();
	}
}