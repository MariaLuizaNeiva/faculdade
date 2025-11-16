package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import negocio.Autor;

public class AutorDAO {
	// Propriedades da classe
	private BancoDeDados objBanco = new BancoDeDados();
	private PreparedStatement objExecucao = null;
	private ResultSet objCursor = null;
	
	// Métodos da classe
	public Collection<Autor> getTodos() throws Exception {
		ArrayList<Autor> colecao = new ArrayList<Autor>();
		
		objBanco.conectar();
		
		objExecucao = objBanco.getObjConexao().prepareStatement("SELECT * FROM AUT_AUTOR");
		
		objCursor = objExecucao.executeQuery();
		while (objCursor.next()) {
			colecao.add(new Autor(objCursor.getInt("AUT_ID"),
					              objCursor.getString("AUT_NOME")));
		}
		
		objBanco.desconectar();
		
		return colecao;
	}
}
