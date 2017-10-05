package model;

import java.io.Serializable;

public class Modulo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String titulo;
	private String url;
	private String imagem;
	
		public Modulo() {
		super();
	}
	public Modulo(String titulo, String url, String imagem) {
		super();
		this.titulo = titulo;
		this.url = url;
		this.imagem = imagem;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		if(titulo != null && titulo.length() > 0){
			this.titulo = titulo;
		}else{
			throw new IllegalArgumentException("Erro: O titulo não pode ser nulo e deve ter pelo menos 1 caractere, valor informado: "+titulo);
		}
		
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		if(url != null && url.length() >0 ){
			this.url = url;
		}else{
			throw new IllegalArgumentException("Erro: A url não pode ser nula e deve ter pelo menos 1 caractere, valor informado: "+url);
		}
		
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		if(imagem != null){
		this.imagem = imagem;
		}else{
			throw new IllegalArgumentException("Erro: A imagem não pode ser nula, valor informado: "+imagem);
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}