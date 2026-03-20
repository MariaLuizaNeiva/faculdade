package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import negocio.Produto;
import persistencia.ProdutoDAO;

public class ControladorAlterar implements ActionListener {
	// Propriedades da classe
	private JTextField txtCodigo;
	private JTextField txtNome;
	
	// Método construtor cheio da classe
	public ControladorAlterar(JTextField txtCodigo, JTextField txtNome) {
		super();
		this.txtCodigo = txtCodigo;
		this.txtNome = txtNome;
	}

	// Método implementado da interface
	public void actionPerformed(ActionEvent e) {
		// Crítica de dados
		if (txtCodigo.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Código obrigatório !");
			return;
		}
		if (txtNome.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Nome obrigatório !");
			return;
		}
		
		// Composição de objeto
		try {
			Produto objProduto = new Produto();
			objProduto.setId(Integer.parseInt(txtCodigo.getText()));
			objProduto.setNome(txtNome.getText());
			
			ProdutoDAO dao = new ProdutoDAO();
			dao.alterar(objProduto);
			
			JOptionPane.showMessageDialog(null, "Produto alterado com sucesso !");
			txtCodigo.setText("");
			txtNome.setText("");
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro);
		}
	}

}
