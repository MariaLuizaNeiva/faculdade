package apresentacao;

import negocio.Pessoa;

public class Visao {
	// Jeito de explicar para o Java que isso aqui
	// não é uma classe: isso aqui é um programa
	public static void main(String[] args) {
		// Sintaxe padrão para instanciação de objetos
		// Classe objeto = new Construtor();
		Pessoa obj1 = new Pessoa();  // ctrl+shift+o
		obj1.setNome("Junior");
		obj1.setEndereco("SQNW 307");
		obj1.setTelefone("99995");
		
		Pessoa obj2 = new Pessoa("Fulano", "Asa Norte", "234-5678");
		
		System.out.println("Nome: " + obj1.getNome());
		System.out.println("Endereco: " + obj1.getEndereco());
		System.out.println("Telefone: " + obj1.getTelefone());
		
		System.out.println("Nome: " + obj2.getNome());
		System.out.println("Endereco: " + obj2.getEndereco());
		System.out.println("Telefone: " + obj2.getTelefone());
	}
}
