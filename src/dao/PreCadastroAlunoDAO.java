package dao;

public interface PreCadastroAlunoDAO {

	public void preCadastrar(String nome, String matricula, int curso);
	
	public void preCadastrar(String nome, String matricula, int curso, String semestreDeIngresso);
	
	public boolean buscarPreCadastro(String matricula, String nome);
	
	public int buscarCursoPreCadastrado (String matricula, String nome);
	
	public void excluirAlunoPreCadastro(String matricula, String nome);
	
}
