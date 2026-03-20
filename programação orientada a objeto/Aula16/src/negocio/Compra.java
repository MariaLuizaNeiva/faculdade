package negocio;

import java.util.ArrayList;

import persistencia.CompraDAO;

public class Compra {
	// Propriedades da classe
	private int id = 0;
	private Produto objProduto = null;
	private Cliente objCliente = null;
	private String data = "";
	private int quantidade = 0;
	
	// Métodos construtores da classe
	public Compra() {
		super();
	}
	
	public Compra(int id, Produto objProduto, Cliente objCliente, String data, int quantidade) {
		super();
		this.id = id;
		this.objProduto = objProduto;
		this.objCliente = objCliente;
		this.data = data;
		this.quantidade = quantidade;
	}
	
	// Métodos de acesso da classe
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Produto getObjProduto() {
		return objProduto;
	}
	public void setObjProduto(Produto objProduto) {
		this.objProduto = objProduto;
	}
	public Cliente getObjCliente() {
		return objCliente;
	}
	public void setObjCliente(Cliente objCliente) {
		this.objCliente = objCliente;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	// Métodos da classe
	public String getDataParaBanco() {
		return data.substring(6, 10) + '=' + 
			   data.substring(3, 5) + '=' + 
			   data.substring(0, 2);
	}
	
	public static ArrayList<Compra> getTodos() throws Exception {
		return new CompraDAO().getTodos();
	}
	
	public void persistir() throws Exception {
		new CompraDAO().persistir(this);
	}
	
	public void despersistir() throws Exception {
		new CompraDAO().despersistir(this);
	}
}
