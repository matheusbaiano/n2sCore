package model;

import java.time.LocalDate;

public class Professor extends Servidor{

	private static final long serialVersionUID = 1L;
	private boolean coordenador;

	public Professor(){
		super();
	}
	
	public Professor(String nome, String cpf, String email, Usuario usuario, LocalDate dataNascimento,String siape, boolean coordenador){
		super(nome,cpf,email,usuario,dataNascimento,siape);
		this.coordenador=coordenador;
		this.cargo = EnumCargo.PROFESSOR;
	}

	public boolean isCoordenador() {
		return coordenador;
	}

	public void setCoordenador(boolean coordenador) {
		this.coordenador = coordenador;
	}
}