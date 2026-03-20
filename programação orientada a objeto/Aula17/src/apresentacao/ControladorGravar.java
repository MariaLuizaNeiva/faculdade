package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import negocio.Especie;
import negocio.Parte;
import negocio.Processo;

public class ControladorGravar implements ActionListener {
	// Propriedades da classe
	private JTextField txtNumero = null;
	private JComboBox<String> cboEspecie = null;
	private JTextField txtVara = null;
	private DefaultListModel<String> dlmPartes = null;
	
	// Método construtor cheio da classe
	public ControladorGravar(JTextField txtNumero, JComboBox<String> cboEspecie, JTextField txtVara,
			DefaultListModel<String> dlmPartes) {
		super();
		this.txtNumero = txtNumero;
		this.cboEspecie = cboEspecie;
		this.txtVara = txtVara;
		this.dlmPartes = dlmPartes;
	}

	// Método implementado da interface
	public void actionPerformed(ActionEvent e) {
		// ComposiParteos objetos
		try {
		ArrayList<Parte> colecao = new ArrayList<Parte>();
		for (int i = 0 ; i < dlmPartes.getSize() ; i++) {
			colecao.add(new Parte(0,
					dlmPartes.getElementAt(i).split(",")[0],
					dlmPartes.getElementAt(i).split(",")[1],
					dlmPartes.getElementAt(i).split(",")[2].equals("1")));
		}
		
		Processo objProcesso = new Processo();
		objProcesso.setNumero(txtNumero.getText());
		objProcesso.setObjEspecie(Especie.getTodos().get(cboEspecie.getSelectedIndex() -1));
		objProcesso.setVara(txtVara.getText());
		objProcesso.setColecao(colecao);
		
		objProcesso.persistir();
		JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso !");
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro);
		}
	}

}
