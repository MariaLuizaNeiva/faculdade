package persistencia;

import java.sql.PreparedStatement;

import negocio.Parte;
import negocio.Processo;

public class ProcessoParteDAO {
	// Propriedades da classe
	private BancoDeDados objBanco = new BancoDeDados();
	private PreparedStatement objExecucao = null;
	
	// Métodos da classe
	public void persistir(Processo objProcesso) throws Exception {
		objBanco.conectar();
		
		for(Parte objParte : objProcesso.getColecao()) {
			objExecucao = objBanco.getObjConexao().prepareStatement(
					"INSERT INTO PRC_PRT " +
					"(PRC_PRT_IDPROCESSO, PRC_PRT_IDPARTE) " +
					"VALUES " +
					"(?, ?)");
		
			objExecucao.setInt(1, objProcesso.getId());
			objExecucao.setInt(2, objParte.getId());
		
			objExecucao.executeUpdate();
		}
		
		objBanco.desconectar();
	}

}
