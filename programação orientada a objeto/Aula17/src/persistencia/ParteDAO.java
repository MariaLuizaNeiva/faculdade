package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import negocio.Parte;

public class ParteDAO {
	// Propriedades da classe
	private BancoDeDados objBanco = new BancoDeDados();
	private PreparedStatement objExecucao = null;
	private ResultSet objCursor = null;
	
	// Métodos da classe
	public void persistir(Parte objParte) throws Exception {
		objBanco.conectar();
		
		objExecucao = objBanco.getObjConexao().prepareStatement(
				"INSERT INTO PRT_PARTE " +
				"(PRT_CPF, PRT_NOME, PRT_TIPO) " +
				"VALUES " +
				"(?, ?, ?)");
		
		objExecucao.setString(1, objParte.getCpf());
		objExecucao.setString(2, objParte.getNome());
		objExecucao.setInt(3, objParte.isTipo() ? 1 : 0);
		
		objExecucao.executeUpdate();
		
		objBanco.desconectar();
	}
	
	public int getUltimoId() throws Exception {
		int ultimoId = 0;
		
		objBanco.conectar();
		
		objExecucao = objBanco.getObjConexao().prepareStatement(
						"SELECT MAX(PRT_ID) FROM PRT_PARTE");
		objCursor = objExecucao.executeQuery();
		while (objCursor.next()) {
			ultimoId = objCursor.getInt(1);
		}
		
		objBanco.desconectar();
		
		return ultimoId;
	}
}
