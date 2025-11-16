package apresentacao;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VisaoProduto extends JFrame {
	// Propriedades da classe
	private static final long serialVersionUID = 1L;
	
	private JLabel lblCodigo = new JLabel("Código");
	private JTextField txtCodigo = new JTextField();
	
	private JLabel lblNome = new JLabel("Nome");
	private JTextField txtNome = new JTextField();
	
	private JButton btnInserir = new JButton("Inserir");
	private JButton btnAlterar = new JButton("Alterar");
	private JButton btnExcluir = new JButton("Excluir");
	private JButton btnConsultar = new JButton("Consultar");
	
	private JTextArea txtResultado = new JTextArea();
	
	// Método principal de exedcução da classe
	public static void main(String[] args) {
		new VisaoProduto().setVisible(true);
	}
	
	public VisaoProduto() {
		// Configuração da janela
		setTitle("Cadastro de Produtos");
		setSize(500, 240);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		
		// Configuração do código
		lblCodigo.setBounds(10, 10, 100, 20);
		add(lblCodigo);
		txtCodigo.setBounds(10, 30, 150, 20);
		add(txtCodigo);
		
		// Configuração do nome
		lblNome.setBounds(10, 60, 200, 20);
		add(lblNome);
		txtNome.setBounds(10, 80, 465, 20);
		add(txtNome);
		
		// Configuração dos botões
		btnInserir.setBounds(10, 130, 100, 30);
		add(btnInserir);
		btnInserir.addActionListener(new ControladorInserir(txtNome));
		
		btnAlterar.setBounds(130, 130, 100, 30);
		add(btnAlterar);
		btnAlterar.addActionListener(new ControladorAlterar(txtCodigo, txtNome));
		
		btnExcluir.setBounds(250, 130, 100, 30);
		add(btnExcluir);
		btnExcluir.addActionListener(new ControladorExcluir(txtCodigo));
		
		btnConsultar.setBounds(370, 130, 100, 30);
		add(btnConsultar);
		btnConsultar.addActionListener(new ControladorConsultar(txtResultado));
		btnConsultar.addActionListener(e -> new VisaoConsulta().setVisible(true));		
	}
}
