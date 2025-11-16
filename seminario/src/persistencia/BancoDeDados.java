package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class BancoDeDados {
	// Propriedades da classe
	private Connection objConexao = null;
	
	// Métodos da classe
	Connection getObjConexao() throws Exception {
		return objConexao;
	}
	
	void conectar() throws Exception {
		objConexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco?user=root" +
												"&password=malu123456&serverTimezone=UTC&useSSL=false");
	}
	
	void desconectar() throws Exception {
		objConexao.close();
	}
}
