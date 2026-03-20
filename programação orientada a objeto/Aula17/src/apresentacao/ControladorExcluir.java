package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class ControladorExcluir implements ActionListener {
	// Propriedades da classe
	private JList<String> lstPartes = null;
	private DefaultListModel<String> dlmPartes = null;
	
	// Método construtor cheio da classe
	public ControladorExcluir(JList<String> lstPartes, DefaultListModel<String> dlmPartes) {
		super();
		this.lstPartes = lstPartes;
		this.dlmPartes = dlmPartes;
	}

	// Método sobrescrito da interface
	public void actionPerformed(ActionEvent e) {
		if (lstPartes.getSelectedIndex() == -1) return;
		
		dlmPartes.remove(lstPartes.getSelectedIndex());
	}

}
