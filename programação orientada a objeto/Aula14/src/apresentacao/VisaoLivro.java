package apresentacao;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import negocio.Autor;

public class VisaoLivro extends JFrame {
	// Propriedades da classe
	private static final long serialVersionUID = 1L;

	private JLabel lblTitulo = new JLabel("Título");
	private JTextField txtTitulo = new JTextField();
	
	private JLabel lblAutor = new JLabel("Autor");
	private JComboBox<String> cboAutor = new JComboBox<String>();
	
	private JButton btnGravar = new JButton("Gravar");
	private JButton btnLimpar = new JButton("Limpar");
	private JButton btnSair = new JButton("Sair");
	
	// Método principal de execução da classe
	public static void main(String[] args) {
		new VisaoLivro().setVisible(true);
	}
	
	// Método construtor da classe
	public VisaoLivro() {
		// Configuração da janela
		setTitle("Cadastro de Livros");
		setSize(500, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		
		// Configuração do título
		lblTitulo.setBounds(10, 10, 200, 20);
		add(lblTitulo);
		txtTitulo.setBounds(10, 30, 465, 20);
		add(txtTitulo);
		
		// Configuração do autor
		lblAutor.setBounds(10, 60, 200, 20);
		add(lblAutor);
		cboAutor.setBounds(10, 80, 465, 20);
		add(cboAutor);
		cboAutor.addItem("--- Selecione o Autor ---");
		try {
			for (Autor objAutor : Autor.getTodos()) {
				cboAutor.addItem(objAutor.getNome());
			}
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro);
		}
		
		// Configuração dos botões
		btnGravar.setBounds(90, 120, 100, 30);
		add(btnGravar);
		btnGravar.addActionListener(new ControladorGravar(txtTitulo, cboAutor));
		
		btnLimpar.setBounds(200, 120, 100, 30);
		add(btnLimpar);
		btnLimpar.addActionListener(new ControladorLimpar(txtTitulo, cboAutor));
		
		btnSair.setBounds(310, 120, 100, 30);
		add(btnSair);
		btnSair.addActionListener(new ControladorSair());
	}
}