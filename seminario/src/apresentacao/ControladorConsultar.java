package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import negocio.Produto;
import persistencia.ProdutoDAO;

public class ControladorConsultar implements ActionListener {
	// Propriedades da classe
	private JTextArea txtResultado;
	
	// Método construtor cheio da classe
	public ControladorConsultar(JTextArea txtResultado) {
		super();
		this.txtResultado = txtResultado;
	}

	// Método implementado da interface
	public void actionPerformed(ActionEvent e) {
		// Composição de objeto
		try {
            ProdutoDAO dao = new ProdutoDAO();
            List<Produto> produtos = dao.consultarTodos();

            if (produtos.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum produto encontrado.");
                txtResultado.setText("");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("ID\tNOME\n");
                sb.append("------------------------\n");
                for (Produto p : produtos) {
                    sb.append(p.getId()).append("\t").append(p.getNome()).append("\n");
                }
                txtResultado.setText(sb.toString());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar produtos: " + ex.getMessage());
        }
	}
}
