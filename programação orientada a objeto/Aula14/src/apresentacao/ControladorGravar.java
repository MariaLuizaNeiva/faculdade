package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import negocio.Autor;
import negocio.Livro;

public class ControladorGravar implements ActionListener {
	// Propriedades da classe
	private JTextField txtTitulo = null;
	private JComboBox<String> cboAutor = null;
		
	// Método construtor cheio da classe
	public ControladorGravar(JTextField txtTitulo, JComboBox<String> cboAutor) {
		super();
		this.txtTitulo = txtTitulo;
		this.cboAutor = cboAutor;
	}

	// Método implementado da interface
	public void actionPerformed(ActionEvent e) {
		// Crítica de dados
		if (txtTitulo.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Título obrigatório !");
			return;
		}
		if (cboAutor.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "Autor obrigatório !");
			return;
		}	
		
		// Composição do objeto
		try {
			Livro objLivro = new Livro();
			
			objLivro.setTitulo(txtTitulo.getText());
			objLivro.setObjAutor((Autor) Autor.getTodos().toArray()[cboAutor.getSelectedIndex()]);
			
			objLivro.persistir();
			JOptionPane.showMessageDialog(null, "Gravação realizada com sucesson !");
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro);
		}
	}
}
