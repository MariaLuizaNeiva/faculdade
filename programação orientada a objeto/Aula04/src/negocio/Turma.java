package negocio;

public class Turma {
	// Propriedades da classe
	private Cadeira objCadeira = null;
	private Professor objProfessor = null;
	private String letra = "";
	private Aluno[] colecao = new Aluno[100];
	
	// Métodos construtores da classe
	public Turma() {
		
	}

	public Turma(Cadeira objCadeira, Professor objProfessor, String letra, Aluno[] colecao) {
		super();
		this.objCadeira = objCadeira;
		this.objProfessor = objProfessor;
		this.letra = letra;
		this.colecao = colecao;
	}

	// Métodos de acesso da classe
	public Cadeira getObjCadeira() {
		return objCadeira;
	}

	public void setObjCadeira(Cadeira objCadeira) {
		this.objCadeira = objCadeira;
	}

	public Professor getObjProfessor() {
		return objProfessor;
	}

	public void setObjProfessor(Professor objProfessor) {
		this.objProfessor = objProfessor;
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	public Aluno[] getColecao() {
		return colecao;
	}

	public void setColecao(Aluno[] colecao) {
		this.colecao = colecao;
	}
	
	// Métodos da classe
	private int qtdMatriculas = 0;
	
	public void adicionarAluno(Aluno objAluno) {
		if (qtdMatriculas == (colecao.length - 1)) {
			System.out.println("A turma está esgotada !");
			return;
		}
		
		colecao[qtdMatriculas] = objAluno;
		qtdMatriculas++;
	}
	
	public void listarAlunos() {
		System.out.println("+=====================+");
		System.out.println("| Lista de Matrículas |");
		System.out.println("+=====================+");
		System.out.println("| Matrículas | Nome   |");
		for (int i = 0 ; i < qtdMatriculas ; i++) {
			System.out.println("|" + colecao[i].getMatricula() + "|" + colecao[i].getNome() + "|");
		}
		System.out.println("+=====================+");
	}
}