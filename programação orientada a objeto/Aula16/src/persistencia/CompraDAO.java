package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import negocio.Cliente;
import negocio.Compra;
import negocio.Produto;

public class CompraDAO {
	// Propriedades da classe
	private BancoDeDados objBanco = new BancoDeDados();
	private PreparedStatement objExecucao = null;
	private ResultSet objCursor = null;
	
	// Métodos da classe
	public ArrayList<Compra> getTodos() throws Exception{
		ArrayList<Compra> colecao = new ArrayList<Compra>();
		
		objBanco.conectar();
		
		objExecucao = objBanco.getObjConexao().prepareStatement(
				"SELECT * " + 
				"FROM CMP_COMPRA, PRD_PRODUTO, CLI_CLIENTE " + 
				"WHERE CMP_IDPRODUTO = PRD_ID " +
				"  AND CMP_IDCLIENTE = CLI_ID");
		objCursor = objExecucao.executeQuery();
		while (objCursor.next()) {
			colecao.add(new Compra(objCursor.getInt("CMP_ID"),
						new Produto(objCursor.getInt("PRD_ID"),
								    objCursor.getString("PRD_NOME"),
									objCursor.getDouble("PRD_PRECO")),
						new Cliente(objCursor.getInt("CLI_ID"),
									objCursor.getString("CLI_NOME"),
									objCursor.getString("CLI_CARTAO")),
						objCursor.getString("CMP_DATA"),
						objCursor.getInt("CMP_QUANTIDADE")));
		}
		
		objBanco.desconectar();
		
		return colecao;
	}
	
	public void persistir(Compra objCompra) throws Exception{
		objBanco.conectar();
		
		if (objCompra.getId() == 0) {
		objExecucao = objBanco.getObjConexao().prepareStatement(
		"INSERT INTO CMP_COMPRA " +
		"(CMP_IDPRODUTO, CMP_IDCLIENTE, CMP_DATA, CMP_QUANTIDADE) " +
		"VALUES " +
		"(?, ?, ?, ?)");
		} else {
			objExecucao = objBanco.getObjConexao().prepareStatement(
			"UPDATE CMP_COMPRA SET " +
			"CMP_IDPRODUTO = ?, " +
			"CMP_IDCLIENTE = ?, " +
			"CMP_DATA = ?, " + 
			"CMP_QUANTIDADE = ? " +
			"WHERE CMP_ID = ?");
		}
		
		objExecucao.setInt(1, objCompra.getObjProduto().getId());
		objExecucao.setInt(2, objCompra.getObjCliente().getId());
		objExecucao.setString(3, objCompra.getDataParaBanco());
		objExecucao.setInt(4, objCompra.getQuantidade());
		if (objCompra.getId() > 0) {
			objExecucao.setInt(5, objCompra.getId());
		}
		
		objExecucao.executeUpdate();
		
		objBanco.desconectar();
	}
	
	public void despersistir(Compra objCompra) throws Exception {
		objBanco.conectar();
		
		objExecucao = objBanco.getObjConexao().prepareStatement(
				"DELETE FROM CMP_COMPRA " +
				"WHERE CMP_ID = ?");
		objExecucao.setInt(1, objCompra.getId());
		
		objExecucao.executeUpdate();
		
		objBanco.desconectar();
	}
}