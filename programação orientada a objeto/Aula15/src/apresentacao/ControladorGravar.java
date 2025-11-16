package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import negocio.Disciplina;
import negocio.Professor;
import negocio.Turma;

public class ControladorGravar implements ActionListener {
	// Propriedades da classe
	private JComboBox<String> cboDisciplina = null;
	private JComboBox<String> cboProfessor = null;
	private JTextField txtLetra = null;
	
	// Método construtor cheio da classe
	public ControladorGravar(JComboBox<String> cboDisciplina, JComboBox<String> cboProfessor, JTextField txtLetra) {
		super();
		this.cboDisciplina = cboDisciplina;
		this.cboProfessor = cboProfessor;
		this.txtLetra = txtLetra;
	}

	// Método implementado da interface
	public void actionPerformed(ActionEvent e) {
		// Crítica de dados
		if (cboDisciplina.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "Disciplina obrigatória !");
			return;
		}
		if (cboProfessor.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "Professor obrigatório !");
			return;
		}
		if (txtLetra.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Letra obrigatório !");
			return;
		}
		
		// Compósição de objeto
		try {
			Turma objTurma = new Turma();
			
			objTurma.setObjDisciplina(
					((ArrayList<Disciplina>) Disciplina.getTodos())
					.get(cboDisciplina.getSelectedIndex() - 1));
			objTurma.setObjProfessor(
					((ArrayList<Professor>) Professor.getTodos())
					.get(cboProfessor.getSelectedIndex() - 1));
			objTurma.setLetra(txtLetra.getText());
			
			objTurma.persistir();
			
			JOptionPane.showMessageDialog(null, "Gravação com sucesso ");	
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro);
		}
	}
}
