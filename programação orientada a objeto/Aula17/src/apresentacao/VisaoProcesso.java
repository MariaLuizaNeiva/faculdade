package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import negocio.Especie;

public class VisaoProcesso extends JFrame {
	// Propriedades da classe
	private static final long serialVersionUID = 1L;
	
	private JLabel lblNumero = new JLabel("Número do Processo");
	private JTextField txtNumero = new JTextField();
	
	private JLabel lblEspecie = new JLabel("Espécie do Processo");
	private JComboBox<String> cboEspecie = new JComboBox<String>();
	
	private JLabel lblVara = new JLabel("Vara do Processo");
	private JTextField txtVara = new JTextField();
	
	private JLabel lblCPF = new JLabel("CPF da Parte");
	private JTextField txtCPF = new JTextField();
	
	private JLabel lblNome = new JLabel("Nome da Parte");
	private JTextField txtNome = new JTextField();
	
	private JLabel lblTipo = new JLabel("Tipo da Parte");
	private JRadioButton optAutor = new JRadioButton("Autor");
	private JRadioButton optReu = new JRadioButton("Réu");
	private ButtonGroup btgTipo = new ButtonGroup();
	
	private JList<String> lstPartes = new JList<String>();
	private DefaultListModel<String> dlmPartes = new DefaultListModel<String>();
	private JScrollPane jspPartes = new JScrollPane(lstPartes);
	
	private JButton btnIncluir = new JButton("=>");
	private JButton btnExcluir = new JButton("<=");
	private JButton btnGravar = new JButton("Gravar");
	private JButton btnLimpar = new JButton("Limpar");
	private JButton btnSair = new JButton("Sair");
	
	// Método principal de execução da classe
	public static void main(String[] args) {
		new VisaoProcesso().setVisible(true);
	}
	
	// Método construtor da classe
	public VisaoProcesso() {
		// Configuração da janela
		setTitle("Cadastro de Processos Judiciais");
		setSize(800, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		
		// Configuração do número do processo
		lblNumero.setBounds(10, 10, 200, 20);
		add(lblNumero);
		txtNumero.setBounds(10, 30, 200, 20);
		add(txtNumero);
		
		// Configuração da espécie do processo
		lblEspecie.setBounds(10, 60, 200, 20);
		add(lblEspecie);
		cboEspecie.setBounds(10, 80, 300, 20);
		add(cboEspecie);
		cboEspecie.addItem("--- Selecione a Espécie ---");
		try {
			for (Especie objEspecie : Especie.getTodos()) {
				cboEspecie.addItem(objEspecie.getDescricao());
			}
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro);
		}
		
		// Configuração da vara do processo
		lblVara.setBounds(10, 110, 200, 20);
		add(lblVara);
		txtVara.setBounds(10, 130, 600, 20);
		add(txtVara);
		
		// Configuração do CPF da parte
		lblCPF.setBounds(10, 200, 200, 20);
		add(lblCPF);
		txtCPF.setBounds(10, 220, 100, 20);
		add(txtCPF);
		
		// Configuração do nome da parte
		lblNome.setBounds(10, 250, 200, 20);
		add(lblNome);
		txtNome.setBounds(10, 270, 300, 20);
		add(txtNome);
		
		// Configuração do tipo da parte
		lblTipo.setBounds(10, 300, 200, 20);
		add(lblTipo);
		optAutor.setBounds(10, 320, 100, 20);
		add(optAutor);
		optReu.setBounds(110, 320, 100, 20);
		add(optReu);
		btgTipo.add(optAutor);
		btgTipo.add(optReu);
		optAutor.setSelected(true);
		
		// Configuração da lista
		jspPartes.setBounds(410, 200, 350, 150);
		add(jspPartes);
		lstPartes.setModel(dlmPartes);
		
		// Configuração dos botões
		btnIncluir.setBounds(340, 240, 50, 20);
		add(btnIncluir);
		btnIncluir.addActionListener(new ControladorIncluir(txtCPF, txtNome, optAutor, dlmPartes));
		
		btnExcluir.setBounds(340, 280, 50, 20);
		add(btnExcluir);
		btnExcluir.addActionListener(new ControladorExcluir(lstPartes, dlmPartes));
		
		btnGravar.setBounds(240, 370, 100, 30);
		add(btnGravar);	
		btnGravar.addActionListener(new ControladorGravar(txtNumero, cboEspecie, txtVara, dlmPartes));
		
		btnLimpar.setBounds(360, 370, 100, 30);
		add(btnLimpar);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNumero.setText("");
				cboEspecie.setSelectedIndex(0);
				txtVara.setText("");
				txtCPF.setText("");
				txtNome.setText("");
				optAutor.setSelected(true);
				dlmPartes.removeAllElements();
			}
		});
		
		btnSair.setBounds(480, 370, 100, 30);
		add(btnSair);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}	
		});	
	}
}
