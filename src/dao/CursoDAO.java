package dao;

import model.Curso;

public interface CursoDAO {
	
	public void cadastrar(Curso curso);
	
	public void editar(Curso curso);
	
	public void remover(int id);
	
	public Curso buscar(int id);
	
	public Curso buscarPorNome(String nome);
	
	
}
