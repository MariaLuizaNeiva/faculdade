package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import negocio.Cliente;
import negocio.Compra;
import negocio.Produto;

public class ControladorGravar implements ActionListener {
	// Propriedades da classe
	private JComboBox<String> cboProduto = null;
	private JComboBox<String> cboCliente = null;
	private JTextField txtData = null;
	private JTextField txtQuantidade = null;
	
	// Método construtor cheio da classe
	public ControladorGravar(JComboBox<String> cboProduto, JComboBox<String> cboCliente, JTextField txtData,
			JTextField txtQuantidade) {
		super();
		this.cboProduto = cboProduto;
		this.cboCliente = cboCliente;
		this.txtData = txtData;
		this.txtQuantidade = txtQuantidade;
	}

	// Método implementado da interface
	public void actionPerformed(ActionEvent e) {
		try {
			Compra objCompra = new Compra();
			
			objCompra.setObjProduto(Produto.getTodos().get(cboProduto.getSelectedIndex() - 1));
			objCompra.setObjCliente(Cliente.getTodos().get(cboCliente.getSelectedIndex() - 1));
			objCompra.setData(txtData.getText());
			objCompra.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
			
			objCompra.persistir();
			JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso !");
			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro);
		}
	}	
}
