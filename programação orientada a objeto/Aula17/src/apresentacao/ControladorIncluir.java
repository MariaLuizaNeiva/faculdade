package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ControladorIncluir implements ActionListener {
	// Propriedades da classe
	private JTextField txtCpf = null;
	private JTextField txtNome = null;
	private JRadioButton optAutor = null;
	private DefaultListModel<String> dlmPartes = null;
	
	// Método construtor cheio da classe
	public ControladorIncluir(JTextField txtCpf, JTextField txtNome, JRadioButton optAutor,
			DefaultListModel<String> dlmPartes) {
		super();
		this.txtCpf = txtCpf;
		this.txtNome = txtNome;
		this.optAutor = optAutor;
		this.dlmPartes = dlmPartes;
	}

	// Método implementado da interface
	public void actionPerformed(ActionEvent e) {
		dlmPartes.addElement(txtCpf.getText() + ", " +
							txtNome.getText() + ", " +
							(optAutor.isSelected() ? 1 : 0));
	}
}
