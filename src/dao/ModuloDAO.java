package dao;

import java.util.List;

import model.Modulo;
import model.Perfil;
import model.Pessoa;

public interface ModuloDAO {
	
	public void cadastrar(Modulo modulo);
	
	public void editar(Modulo modulo);
	
	public void remover(int id);
	
	public Modulo buscar(int id);
	
	public Modulo buscarPorNome(String nome);
	
	public List<Modulo> buscar(Pessoa pessoa);
	
	public List<Modulo> buscar(Perfil perfil);
	
	public List<Modulo> listar();
	
	public List<Modulo> listarDisponiveisParaPessoa(Pessoa pessoa);
	
	public List<Modulo> listarAssociadosParaPessoa(Pessoa pessoa);
	
	public void associarUsuarioModulo(int idUsuario, int idModulo);
	
	public void desassociarUsuarioModulo(int idUsuario, int idModulo);
	
	public void associarPerfilModulo (int idPerfil, int idModulo);
	
	public void desassociarPerfilModulo (int idPerfil, int idModulo);

	public List<Modulo> getModulosDePerfil(Perfil perfil);
	
	public List<Modulo> getModulosDisponiveisParaPerfil(Perfil perfil);
}