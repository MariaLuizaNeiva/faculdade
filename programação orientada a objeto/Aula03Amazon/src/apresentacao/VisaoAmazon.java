package apresentacao;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import negocio.Compra;
import negocio.Produto;
import negocio.Tipo;

public class VisaoAmazon {
	public static void main(String[] args) {
		// Declaração de variáveis
		BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
		Produto objProduto = new Produto();
		Compra objCompra = new Compra();
		
		// Entrada de dados
		try {
			System.out.print("Digite o nome do produto: ");
			objProduto.setNome(leitor.readLine());
			
			System.out.print("Digite o tipo do produto: ");
			objProduto.setObjTipo(new Tipo(leitor.readLine()));
			
			System.out.print("Digite o preço do produto: ");
			objProduto.setPreco(Double.parseDouble(leitor.readLine()));
			
			// Colocar o produto dentro da compra
			objCompra.setObjProduto(objProduto);
			
			System.out.print("Digite a quantidade da compra: ");
			objCompra.setQuantidade(Integer.parseInt(leitor.readLine()));
			
			System.out.print("Digite a data da compra: ");
			objCompra.setData(leitor.readLine());
			
			System.out.print("Digite o número do cartão: ");
			objCompra.setCartao(leitor.readLine());
		}
		catch (Exception erro) {
			System.out.println(erro);
	    }
		
		// Saída de dados
		System.out.println("Produto: " + objCompra.getObjProduto().getNome());
		System.out.println("Valor total da compra: R$ " + objCompra.getObjProduto().getPreco() * objCompra.getQuantidade());
		System.out.println("Data: " + objCompra.getData());
	}
}