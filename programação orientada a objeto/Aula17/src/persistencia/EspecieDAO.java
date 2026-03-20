package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import negocio.Especie;

public class EspecieDAO {
	// Propriedades da classe
	private BancoDeDados objBanco = new BancoDeDados();
	private PreparedStatement objExecucao = null;
	private ResultSet objCursor = null;
			
	// Métodos da classe
	public ArrayList<Especie> getTodos() throws Exception {
		ArrayList<Especie> colecao = new ArrayList<Especie>();
				
		objBanco.conectar();
				
		objExecucao = objBanco.getObjConexao().prepareStatement(
									"SELECT * FROM ESP_ESPECIE");
		objCursor = objExecucao.executeQuery();
		while (objCursor.next()) {
			colecao.add(new Especie(objCursor.getInt("ESP_ID"),
									objCursor.getString("ESP_DESCRICAO")));
		}
				
		objBanco.desconectar();
				
		return colecao;
	}
}
