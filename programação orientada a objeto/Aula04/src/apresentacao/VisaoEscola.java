package apresentacao;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import negocio.Aluno;
import negocio.Cadeira;
import negocio.Professor;
import negocio.Turma;

public class VisaoEscola {
	public static void main(String[] args) {
		// Declaração de variáveis
		BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
		Professor objProfessor = new Professor();
		Turma objTurma = new Turma();
		
		// Entrada de dados
		try {
			System.out.print("Digite o nome da cadeira: ");
			objTurma.setObjCadeira(new Cadeira(leitor.readLine()));
			
			System.out.print("Digite o nome do professor: ");
			objProfessor.setNome(leitor.readLine());
			
			System.out.print("Digite a titulação do professor: ");
			objProfessor.setTitulo(leitor.readLine());
			
			System.out.print("Digite o salário do professor: ");
			objProfessor.setSalario(Double.parseDouble(leitor.readLine()));
			
			objTurma.setObjProfessor(objProfessor);
			
			do {
				Aluno objAluno = new Aluno();
				
				System.out.println("Digite a matrícula do aluno: ");
				objAluno.setMatricula(Integer.parseInt(leitor.readLine()));
				
				System.out.println("Digite o nome do aluno: ");
				objAluno.setNome(leitor.readLine());
				
				objTurma.adicionarAluno(objAluno);
				
				System.out.print("Digite <S> se houver mais alunos: ");
			} while (leitor.readLine().equalsIgnoreCase("S"));
		} catch (Exception erro) {
			System.out.println(erro);		
		}
		
		// Saída de dados
		System.out.println("Cadeira: " + objTurma.getObjCadeira().getNome());
		System.out.println("Professor: " + objTurma.getObjProfessor().getTitulo() + " " + objTurma.getObjProfessor().getNome());
		objTurma.listarAlunos();
	}
}