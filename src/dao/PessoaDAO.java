package dao;

import java.util.List;

import model.Pessoa;
import model.Usuario;

public interface PessoaDAO {

	public void cadastrar(Pessoa pessoa);

	public void editar(Pessoa pessoa);

	public void remover(int id);

	public Pessoa buscarPorId(int id);

	public Pessoa buscarPorLogin(String login);

	public Pessoa buscarPorCpf(String cpf);

	public List<Pessoa> buscarPorNome(String nome);

	public List<Pessoa> listar();
	
	public List<Pessoa> buscarPorNivel(int nivel, int inicio, int fim);
	
	public List<Pessoa> buscarPorNomeENivel(String nome, int nivel, int inicio, int fim);
	
	public Integer getQuantidadePorNomeENivel(String nome, int nivel);

    public Pessoa buscarPorEmail(String email);
	
	public Integer getQuantidadePorNivel(int nivel);

	public Pessoa buscarPorMatriculaAndCPF(String matricula, String cpf);
	
	public Usuario buscarPorSiapeAndCPF(String siape, String cpf);
	
	public String buscarTokenRecuperacao(Pessoa pessoa);
	
	public void inserirTokenRecuperacao(Pessoa pessoa);

	public List<Pessoa> buscarPorNome(String nome, int inicio, int fim);

	public Integer getQuantidadePorNome(String nome);

}