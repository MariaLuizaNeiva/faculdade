package apresentacao;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import negocio.Caipirinha;
import negocio.Drink;
import negocio.DryMartini;
import negocio.Mixer;
import negocio.MoscowMule;
import negocio.OldFashion;

public class VisaoDrink {
	public static void main(String[] args) {
		// Declaração de variáveis
		BufferedReader leitor = new BufferedReader (new InputStreamReader(System.in));
		Drink objDrink = null;
		int opcao = 0;
		
		// Entrada de dados
		try {
			System.out.println("+=================+");
			System.out.println("|   Menu de Bar   |");
			System.out.println("+=================+");
			System.out.println("| 1 - Caipirinha  |");
			System.out.println("| 2 - Dry Martini |");
			System.out.println("| 3 - Old Fashion |");
			System.out.println("| 4 - Moscow Mule |");
			System.out.println("+=================+");
			System.out.print("Digite a sua opção: ");
			opcao = Integer.parseInt(leitor.readLine());
			
			if (opcao == 1) {
				objDrink = new Caipirinha();
			} else if (opcao == 2) {
				objDrink = new DryMartini();
			} else if (opcao == 3) {
				objDrink = new OldFashion();
			} else {
				objDrink = new MoscowMule();
			}
			
			((Mixer) objDrink).misturar();
		} catch (Exception erro) {
			System.out.println(erro);
		}
		
		// Saída de dados
		objDrink.beber(); 
	}
}
