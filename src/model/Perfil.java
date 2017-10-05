package model;

public class Perfil {
	private int id;
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(this.nome != null){
			this.nome = nome;
		}else{
			throw new IllegalArgumentException("Erro: O parâmetro nome não pode ser nulo ou vazio, valor informado " + nome);
		}
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if(id >0){
			this.id = id;
		}else{
			throw new IllegalArgumentException("Erro: O parâmetro nome não pode ser nulo ou menor que 1, valor informado " + id);
		}
	}

	public Perfil() {
		super();
		this.nome = "";
	}
	
	public Perfil(String nome) {
		super();
		this.nome = nome;
	}
	
	
}
