package dao;

import java.util.List;

import model.Perfil;

public interface PerfilDAO {
	
	public void cadastrar(Perfil perfil);
	
	public void editar(Perfil perfil);
	
	public void excluir(int id);
	
	public Perfil buscarPorId(int id);
	
	public Perfil buscarPorNome(String nome);
	
	public List<Perfil> Listar();
	
}
