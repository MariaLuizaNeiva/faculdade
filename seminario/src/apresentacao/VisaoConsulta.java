package apresentacao;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import negocio.Produto;
import persistencia.ProdutoDAO;

public class VisaoConsulta extends JFrame {
	private static final long serialVersionUID = 1L;
    private JTextArea txtResultado = new JTextArea();

    public VisaoConsulta() {
        setTitle("Consulta de Produtos");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        txtResultado.setEditable(false);

        JScrollPane scroll = new JScrollPane(txtResultado);
        add(scroll, BorderLayout.CENTER);

        carregarProdutos(); 
    }

    private void carregarProdutos() {
        try {
            ProdutoDAO dao = new ProdutoDAO();
            List<Produto> produtos = dao.consultarTodos();

            if (produtos.isEmpty()) {
                txtResultado.setText("Nenhum produto encontrado.");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("ID\tNOME\n");
                sb.append("--------------------------\n");

                for (Produto p : produtos) {
                    sb.append(p.getId()).append("\t").append(p.getNome()).append("\n");
                }

                txtResultado.setText(sb.toString());
            }
        } catch (Exception e) {
            txtResultado.setText("Erro ao consultar produtos: " + e.getMessage());
        }
    }
}
