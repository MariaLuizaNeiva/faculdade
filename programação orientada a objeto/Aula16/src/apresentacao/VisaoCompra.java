package apresentacao;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import negocio.Cliente;
import negocio.Compra;
import negocio.Produto;

public class VisaoCompra extends JFrame {
	// Propriedades da classe
	private static final long serialVersionUID = 1L;

	private JLabel lblProduto = new JLabel("Produto");
	private JComboBox<String> cboProduto = new JComboBox<String>();
	
	private JLabel lblCliente = new JLabel("Cliente");
	private JComboBox<String> cboCliente = new JComboBox<String>();
	
	private JLabel lblData = new JLabel("Data");
	private JTextField txtData = new JTextField();
	
	private JLabel lblQuantidade = new JLabel("Quantidade");
	private JTextField txtQuantidade = new JTextField();
	
	private JButton btnGravar = new JButton("Gravar");
	private JButton btnExcluir = new JButton("Excluir");
	private JButton btnLimpar = new JButton("Limpar");
	private JButton btnSair = new JButton("Sair");
	
	private JList<String> lstCompra = new JList<String>();
	private DefaultListModel<String> dlmCompra = new DefaultListModel<String>();
	private JScrollPane jspCompra = new JScrollPane(lstCompra);
	
	// Método principal de execução da clase
	public static void main(String[] args) {
		new VisaoCompra().setVisible(true); 
	}
	
	// Método construtor da classe
	public VisaoCompra() {
		// Configuração da janela
		setTitle("Cadastro de Compras - AMAZONA BRAZUCA");
		setSize(400,510);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		
		// Configuração do produto
		lblProduto.setBounds(10, 10, 200, 20);
		add(lblProduto);
		cboProduto.setBounds(10, 30, 365, 20);
		add(cboProduto);
		cboProduto.addItem("--- Seleciona o Produto ---");
		try {
			for (Produto objProduto : Produto.getTodos()) {
				cboProduto.addItem(objProduto.getNome() + " (R$ " +
								   objProduto.getPreco() + ")");
			}
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro);
		}
		
		// Configuração do cliente
		lblCliente.setBounds(10, 60, 200, 20);
		add(lblCliente);
		cboCliente.setBounds(10, 80, 365, 20);
		add(cboCliente);
		cboCliente.addItem("--- Seleciona o Cliente ---");
		try {
			for (Cliente objCliente : Cliente.getTodos()) {
				cboCliente.addItem(objCliente.getNome());
			}
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro);
		}
		
		// Configuração da data
		lblData.setBounds(10, 110, 200, 20);
		add(lblData);
		txtData.setBounds(10, 130, 80, 20);
		add(txtData);
		
		// Configuração da quantidade
		lblQuantidade.setBounds(10, 160, 200, 20);
		add(lblQuantidade);
		txtQuantidade.setBounds(10, 180, 30, 20);
		add(txtQuantidade);
		
		// Configuração dos botões
		btnGravar.setBounds(20, 210, 80, 30);
		add(btnGravar);
		//btnGravar.addActionListener(new ControladorGravar
		//(cboProduto, cboCliente, txtData, txtQuantidade, lstCompra));
		
		btnExcluir.setBounds(110, 210, 80, 30);
		add(btnExcluir);
		//btnExcluir.addActionListener(new ControladorExcluir
		//(lstCompra));		
		
		btnLimpar.setBounds(200, 210, 80, 30);
		add(btnLimpar);
		btnLimpar.addActionListener(new ControladorLimpar
		(cboProduto, cboCliente, txtData, txtQuantidade, lstCompra));
		
		btnSair.setBounds(290, 210, 80, 30);
		add(btnSair);
		btnSair.addActionListener(new ControladorSair());
		
		// Configuração da lista de compras já realizadas
		jspCompra.setBounds(10, 250, 365, 200);
		add(jspCompra);
		lstCompra.setModel(dlmCompra);
		try {
			for (Compra objCompra : Compra.getTodos()) {
				dlmCompra.addElement(
						objCompra.getData() + " " +
						objCompra.getObjCliente().getNome() + " " +
						objCompra.getQuantidade() + " " +
						objCompra.getObjProduto().getNome() + " R$ " +
						(objCompra.getObjProduto().getPreco() *
						objCompra.getQuantidade()));
			}
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro);
		}
	}
}
