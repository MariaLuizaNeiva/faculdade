package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import negocio.Produto;
import persistencia.ProdutoDAO;

public class ControladorInserir implements ActionListener {
	// Propriedades da classe
	private JTextField txtNome;
	
	// Método construtor cheio da classe 
	public ControladorInserir(JTextField txtNome) {
		super();
		this.txtNome = txtNome;
	}

	// Método implementado da interface
	public void actionPerformed(ActionEvent e) {
		// Crítica de dados
		if (txtNome.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Nome obrigatório !");
			return;
		}
		
		// Composição de objeto
		try {
			Produto objProduto = new Produto();
			objProduto.setNome(txtNome.getText());
			
			ProdutoDAO dao = new ProdutoDAO();
			dao.persistir(objProduto);
			
			JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso !");
			txtNome.setText("");
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro);
		}
	}
}
