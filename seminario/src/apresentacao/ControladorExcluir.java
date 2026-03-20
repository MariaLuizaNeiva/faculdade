package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import persistencia.ProdutoDAO;

public class ControladorExcluir implements ActionListener {
	// Propriedades da classe
	private JTextField txtCodigo;
	
	// Método construtor cheio da classe
	public ControladorExcluir(JTextField txtCodigo) {
		super();
		this.txtCodigo = txtCodigo;
	}

	// Método implementado da interface
	public void actionPerformed(ActionEvent e) {
		// Crítica de dados
		if(txtCodigo.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Código obrigatório !");
			return;
		}
		
		// Composição de objeto
		try {
			int id = Integer.parseInt(txtCodigo.getText());
			ProdutoDAO dao = new ProdutoDAO();
			dao.excluir(id);
			
			JOptionPane.showMessageDialog(null, "Produto excluído com sucesso !");
			txtCodigo.setText("");
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro);
		}
	}
}
