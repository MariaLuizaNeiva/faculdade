package apresentacao;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Visao extends JFrame {
	// Propriedades da classe
	private static final long serialVersionUID = 1L;
	
	private JMenuBar barraDeMenu = new JMenuBar();
	private JMenu mnuArquivo = new JMenu("Arquivo");
	private JMenu mnuEditar = new JMenu("Editar");
	private JMenuItem mniNovo = new JMenuItem("Novo");
	private JMenuItem mniAbrir = new JMenuItem("Abrir");
	private JMenuItem mniSair = new JMenuItem("Sair");
	private JMenuItem mniCopiar = new JMenuItem("Copiar");
	private JMenuItem mniColar = new JMenuItem("Colar");
	
	private JButton btnSair = new JButton("Sair");
	
	private JLabel lblCaixaDeTexto = new JLabel("Caixa de Texto");
	private JTextField txtCaixaDeTexto = new JTextField();
	
	private JLabel lblAreaDeTexto = new JLabel("Área de Texto");
	private JTextArea txtAreaDeTexto = new JTextArea();
	private JScrollPane jspAreaDeTexto = new JScrollPane(txtAreaDeTexto);
	
	private JLabel lblCaixaDeOpcoes = new JLabel("Caixa de Opções");
	private JComboBox<String> cboCaixaDeOpcoes = new JComboBox<String>();
	
	private JCheckBox chkAceiteTermo = new JCheckBox("Aceite os Termos");
	
	private JLabel lblAlternativa = new JLabel("Alternativa");
	private ButtonGroup btgAlternativa = new ButtonGroup();
	private JRadioButton optSim = new JRadioButton("Sim"); 
	private JRadioButton optNao = new JRadioButton("Não"); 
	
	private JLabel lblListaDeOpcoes = new JLabel("Lista de Opções");
	private JList<String> lstListaDeOpcoes = new JList<String>();
	private DefaultListModel<String> dlmListaDeOpcoes = new DefaultListModel<String>();
	private JScrollPane jspListaDeOpcoes = new JScrollPane(lstListaDeOpcoes);
	
	// Método principal de execução da classe
	public static void main(String[] args) {
		new Visao().setVisible(true);
	}
	
	// Método construtor da classe
	public Visao() {
		// Configuração da janela
		setTitle("Janela padrão de Exemplificação de Controles ");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		
		// Configuração do menu
		setJMenuBar(barraDeMenu);
		barraDeMenu.add(mnuArquivo);
		barraDeMenu.add(mnuEditar);
		mnuArquivo.add(mniNovo);
		mnuArquivo.add(mniAbrir);
		mnuArquivo.addSeparator();
		mnuArquivo.add(mniSair);
		mnuEditar.add(mniCopiar);
		mnuEditar.add(mniColar);
		
		mniNovo.addActionListener(new ControladorNovo());
		
		// Configuração do botão
		btnSair.setBounds(650, 480, 100, 30);
		add(btnSair);
		btnSair.addActionListener(new ControladorSair());
		
		// Configuração da caixa de texto
		lblCaixaDeTexto.setBounds(10, 10, 200, 20);
		add(lblCaixaDeTexto);
		txtCaixaDeTexto.setBounds(10, 30, 400, 20);
		add(txtCaixaDeTexto);
		
		// Configuração da área de texto
		lblAreaDeTexto.setBounds(10, 60, 200, 20);
		add(lblAreaDeTexto);
		jspAreaDeTexto.setBounds(10, 80, 765, 150);
		add(jspAreaDeTexto);
		txtAreaDeTexto.setLineWrap(true);
		
		// Configuração da caixa de opções
		lblCaixaDeOpcoes.setBounds(10, 240, 200, 20);
		add(lblCaixaDeOpcoes);
		cboCaixaDeOpcoes.setBounds(10, 260, 200, 20);
		add(cboCaixaDeOpcoes);
		cboCaixaDeOpcoes.addItem("--- Selecione a Opção ---");
		cboCaixaDeOpcoes.addItem("Opção 1");
		cboCaixaDeOpcoes.addItem("Opção 2");
		cboCaixaDeOpcoes.addItem("Opção 3");
		cboCaixaDeOpcoes.addItem("Opção 4");
		cboCaixaDeOpcoes.addItem("Opção 5");
		
		// Configuração do aceite de termo
		chkAceiteTermo.setBounds(10 , 290, 200, 20);
		add(chkAceiteTermo);
		
		// Configuração das alternativas
		lblAlternativa.setBounds(10, 320, 200, 20);
		add(lblAlternativa);
		optSim.setBounds(10, 340, 80, 20);
		add(optSim);
		optNao.setBounds(90, 340, 80, 20);
		add(optNao);
		btgAlternativa.add(optSim);
		btgAlternativa.add(optNao);
		optSim.setSelected(true);
		
		// Configuração da lista de opções
		lblListaDeOpcoes.setBounds(10, 370, 200, 20);
		add(lblListaDeOpcoes);
		jspListaDeOpcoes.setBounds(10, 390, 765, 80);
		add(jspListaDeOpcoes);
		lstListaDeOpcoes.setModel(dlmListaDeOpcoes);
		dlmListaDeOpcoes.addElement("Opção 1");
		dlmListaDeOpcoes.addElement("Opção 2");
		dlmListaDeOpcoes.addElement("Opção 3");
		dlmListaDeOpcoes.addElement("Opção 4");
		dlmListaDeOpcoes.addElement("Opção 5");		
	}	
}