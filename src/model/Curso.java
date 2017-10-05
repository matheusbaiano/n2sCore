package model;

public class Curso {
	
	private int id;
	private String nome;
	
	public Curso(String descricao) {
		this.nome = descricao;
	}
	
	public Curso() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}