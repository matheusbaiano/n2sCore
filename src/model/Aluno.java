package model;

import java.time.LocalDate;

public class Aluno extends Pessoa{

	private static final long serialVersionUID = 1L;
	private String matricula;
	private Curso curso;
	private String semestreIngresso;
	
	public Aluno() {
	}
	
	public Aluno(String nome, String cpf, String email, Usuario usuario, LocalDate dataNascimento,String matricula, Curso curso, String semestreIngresso){
		super(nome, cpf,email,usuario,dataNascimento);
		this.matricula = matricula;
		this.curso = curso;
		this.semestreIngresso = semestreIngresso;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		if(matricula != null && matricula.length() == 6 && matricula.matches("^[0-9]+$")){
			this.matricula = matricula;
		}else{
			throw new IllegalArgumentException("Erro: O parâmetro MATRICULA não pode ser nulo e deve conter apenas dígitos, valor informado " + matricula);
		}
	}
	
	public Curso getCurso() {
		return curso;
	}
	
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getSemestreIngresso() {
		return semestreIngresso;
	}
	
	public void setSemestreIngresso(String semestreIngresso) {
		if (semestreIngresso != null && semestreIngresso.matches("^[0-9]{4}.[1-2]$")){
			this.semestreIngresso = semestreIngresso;
		}else{
			throw new IllegalArgumentException("Erro: O parâmetro SEMESTRE INGRESSO deve seguir o modelo <ano>.<1 ou 2> Ex: 2017.1, valor informado " + semestreIngresso);
		}
	}

}