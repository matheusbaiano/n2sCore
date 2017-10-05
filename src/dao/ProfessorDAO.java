package dao;

import java.util.List;

import model.Professor;

public interface ProfessorDAO {

	public void cadastrar(Professor professor);
	
	public Professor buscar(int id);
	
	public List<Professor> listar();

	void editar(Professor professor);
}