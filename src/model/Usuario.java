package model;

import java.io.Serializable;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String login;
	private String senha;
	private Pessoa pessoa;
	private EnumNivel nivel;
	private String token;
	private String tokenUsuario;

	public void setToken(String token) {
		this.token = token;
	}
	public Usuario(){
		
	}
	public Usuario(String login, String senha, Pessoa pessoa) {
		super();
		this.login = login;
		this.senha = senha;
		this.nivel = EnumNivel.COMUM;
		this.pessoa = pessoa;
	}
	public Usuario(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
		this.nivel = EnumNivel.COMUM;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		if(login != null &&login.length() >= 4){
			this.login = login;
		}else{
			throw new IllegalArgumentException("Erro: O valor do login não pode ser nulo e deve possuir pelo menos 4 caracteres, valor informado: "+login);
		}
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		if(senha != null && senha.length() >= 6){
			this.senha = senha;
		}else{
			throw new IllegalArgumentException("Erro: O valor da senha não pode ser nulo e deve possuir pelo menos 6 caracteres, valor informado: "+senha);
		}
	}
	public EnumNivel getNivel() {
		return nivel;
	}
	
	
	
	public void setNivel(EnumNivel nivel) {
		this.nivel = nivel;
	}
	
	public void setNivel(int nivel){
		switch (nivel) {
		case 1:
			this.nivel = EnumNivel.ADMINISTRADOR; 
			break;
		case 2:
			this.nivel = EnumNivel.COMUM;
			break;
		default:
			throw new IllegalArgumentException("Erro: O valor do nivel não pode ser nulo ou invalido, valor informado: "+nivel);
			
		}
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public String getToken() {
		return token;
	}
	public String getTokenUsuario() {
		return tokenUsuario;
	}
	public void setTokenUsuario(String tokenUsuario) {
		this.tokenUsuario = tokenUsuario;
	}
}