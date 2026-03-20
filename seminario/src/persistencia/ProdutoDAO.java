package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import negocio.Produto;

public class ProdutoDAO {
	// Propriedades da classe
	private BancoDeDados objBanco = new BancoDeDados();
	private PreparedStatement objExecucao = null;
	
	// Métodos da classe
	// inserir
	public void persistir(Produto objProduto) throws Exception {
		objBanco.conectar();
		
		objExecucao = objBanco.getObjConexao().prepareStatement(
						"INSERT INTO TB_PRODUTO " +
						"(NOME_PRODUTO) " +
						"VALUES" +
						"(?)");
		objExecucao.setString(1, objProduto.getNome());
		
		objExecucao.executeUpdate();
		
		objBanco.desconectar();
	}
	
	// alterar
	public void alterar(Produto objProduto) throws Exception {
		objBanco.conectar();
		
		objExecucao = objBanco.getObjConexao().prepareStatement(
						"UPDATE TB_PRODUTO " +
						"SET NOME_PRODUTO = ? " +
						"WHERE CD_PRODUTO = ?");
		objExecucao.setString(1, objProduto.getNome());
		objExecucao.setInt(2, objProduto.getId());
		
		objExecucao.executeUpdate();
		
		objBanco.desconectar();
	}
	
	// excluir
	public void excluir(int id) throws Exception {
		objBanco.conectar();
		
		objExecucao = objBanco.getObjConexao().prepareStatement(
						"DELETE FROM TB_PRODUTO " +
						"WHERE CD_PRODUTO = ?");
		objExecucao.setInt(1, id);
		
		objExecucao.executeUpdate();
		
		objBanco.desconectar();
	}
	
	// consultar
	public List<Produto> consultarTodos() throws Exception {
		objBanco.conectar();
		
		List<Produto> lista = new ArrayList<>();
		
		objExecucao = objBanco.getObjConexao().prepareStatement(
						"SELECT CD_PRODUTO, NOME_PRODUTO FROM TB_PRODUTO");
		
		ResultSet rs = objExecucao.executeQuery();
		
		while (rs.next()) {
			Produto objProduto = new Produto();
			objProduto.setId(rs.getInt("CD_PRODUTO"));
			objProduto.setNome(rs.getString("NOME_PRODUTO"));
			lista.add(objProduto);
		}
		
		objBanco.desconectar();
		return lista;
	}
}
