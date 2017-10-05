package dao;

public interface PreCadastroServidorDAO {
	
	public void preCadastrarServidor(String siape, String nome);
	
	public boolean buscarPreCadastro(String siape, String nome);
	
	public void excluirPreCadastro(String siape, String nome);
	

}
