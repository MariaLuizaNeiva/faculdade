package apresentacao;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import negocio.Aguia;
import negocio.Animal;
import negocio.Ave;
import negocio.Cachorro;
import negocio.Leopardo;
import negocio.Mamifero;

public class VisaoZoologico {
	public static void main(String[] args) {
		// Declaração de variáveis 
		BufferedReader leitor = new BufferedReader (new InputStreamReader(System.in));
		Animal objAnimal = null;
		String opcao = "";
		
		// Entrada de dados
		try {
			System.out.print("Digite <C>achorro, <L>eopardo ou <A>guia: ");
			opcao = leitor.readLine();
			
			if (opcao.equalsIgnoreCase("C")) {
				objAnimal = new Cachorro();
			} else if (opcao.equalsIgnoreCase("L")) {
				objAnimal = new Leopardo();
			} else {
				objAnimal = new Aguia();
			}
			
			System.out.print("Digite o nome do bicho: ");
			objAnimal.setNome(leitor.readLine());
			
			System.out.print("Digite a altura do bicho: ");
			objAnimal.setAltura(Double.parseDouble(leitor.readLine()));
			
			System.out.print("Digite o peso do bicho: ");
			objAnimal.setPeso(Double.parseDouble(leitor.readLine()));
			
			if (opcao.equalsIgnoreCase("C")) {
				System.out.print("Digite os litros de leite: ");
				((Mamifero) objAnimal).setLitrosLeite(Integer.parseInt(leitor.readLine()));
				System.out.print("Digite a força da mordida: ");
				((Cachorro) objAnimal).setForcaMordida(Double.parseDouble(leitor.readLine()));
			} else if (opcao.equalsIgnoreCase("L")) {
				System.out.print("Digite os litros de leite: ");
				((Mamifero) objAnimal).setLitrosLeite(Integer.parseInt(leitor.readLine()));
				System.out.print("Digite a velocidade: ");
				((Leopardo) objAnimal).setVelocidade(Double.parseDouble(leitor.readLine()));
			} else {
				System.out.print("Digite a quantidade de ovos: ");
				((Ave) objAnimal).setQuantidadeOvos(Integer.parseInt(leitor.readLine()));
				System.out.print("Digite a autonomia de vôo: ");
				((Aguia) objAnimal).setAutonomia(Double.parseDouble(leitor.readLine()));
			}	
		} catch (Exception erro) {
			System.out.println(erro);
		}
		
		// Saída de dados
		System.out.println("Nome: " + objAnimal.getNome());
		System.out.println("IMC: " + objAnimal.calcularIMC());
		if (opcao.equalsIgnoreCase("C")) {
			((Cachorro) objAnimal).morder();
		} else if (opcao.equalsIgnoreCase("L")) {
			((Leopardo) objAnimal).correr();
		} else {
			((Aguia) objAnimal).voar();
		}
	}
}
