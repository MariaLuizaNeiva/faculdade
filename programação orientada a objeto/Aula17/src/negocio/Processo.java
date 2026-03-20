package negocio;

import java.util.ArrayList;

import persistencia.ProcessoDAO;
import persistencia.ProcessoParteDAO;

public class Processo {
	// Propriedades da classe
	private int id = 0;
	private String numero = "";
	private Especie objEspecie = null;
	private String vara = "";
	private ArrayList<Parte> colecao = null;
	
	// Métodos construtores da classe
	public Processo() {
		super();
	}
	
	public Processo(int id, String numero, Especie objEspecie, String vara, ArrayList<Parte> colecao) {
		super();
		this.id = id;
		this.numero = numero;
		this.objEspecie = objEspecie;
		this.vara = vara;
		this.colecao = colecao;
	}
	
	// Métodos de acesso da classe
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Especie getObjEspecie() {
		return objEspecie;
	}
	public void setObjEspecie(Especie objEspecie) {
		this.objEspecie = objEspecie;
	}
	public String getVara() {
		return vara;
	}
	public void setVara(String vara) {
		this.vara = vara;
	}
	public ArrayList<Parte> getColecao() {
		return colecao;
	}
	public void setColecao(ArrayList<Parte> colecao) {
		this.colecao = colecao;
	}
	
	// Métodos da classe
	public void persistir() throws Exception {
		// Gravação das pessoas
		for (Parte objParte : this.getColecao()) {
			objParte.persistir();
			objParte.setId(objParte.getUltimoId());
		}
		
		// Gravação do Processo
		new ProcessoDAO().persistir(this);
		this.setId(this.getUltimoId());
		
		// Associação das pessoas às partes do processo
		new ProcessoParteDAO().persistir(this);
		
	}
	
	public int getUltimoId() throws Exception {
		return new ProcessoDAO().getUltimoId();
	}
}
