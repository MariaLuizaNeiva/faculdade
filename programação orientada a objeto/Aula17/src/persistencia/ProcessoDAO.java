package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import negocio.Processo;

public class ProcessoDAO {
	// Propriedades da classe
	private BancoDeDados objBanco = new BancoDeDados();
	private PreparedStatement objExecucao = null;
	private ResultSet objCursor = null;
	
	// Métodos da classe
	public void persistir(Processo objProcesso) throws Exception {
		objBanco.conectar();
		
		objExecucao = objBanco.getObjConexao().prepareStatement(
				"INSERT INTO PRC_PROCESSO " +
				"(PRC_NUMERO, PRC_IDESPECIE, PRC_VARA) " +
				"VALUES " +
				"(?, ?, ?)");
		
		objExecucao.setString(1, objProcesso.getNumero());
		objExecucao.setInt(2, objProcesso.getObjEspecie().getId());
		objExecucao.setString(3, objProcesso.getVara());
		
		objExecucao.executeUpdate();
		
		objBanco.desconectar();
	}
	
	public int getUltimoId() throws Exception {
		int ultimoId = 0;
		
		objBanco.conectar();
		
		objExecucao = objBanco.getObjConexao().prepareStatement(
						"SELECT MAX(PRC_ID) FROM PRC_PROCESSO");
		objCursor = objExecucao.executeQuery();
		while (objCursor.next()) {
			ultimoId = objCursor.getInt(1);
		}
		
		objBanco.desconectar();
		
		return ultimoId;
	}
}
