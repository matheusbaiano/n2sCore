package dao;

import java.util.List;

import model.Servidor;

public interface ServidorDAO {

	public void cadastrar(Servidor servidor);

	public Servidor buscar(String siape);

	public Servidor buscarPorSiape(String siape);

	public List<Servidor> listar();

	public List<Servidor> buscarPorNome(String nome);

	public Servidor buscarPorToken(String token);

	public List<Servidor> buscarPorNome(String nome, Integer inicio, Integer fim);

	public Integer getQuantidadePorNome(String nome);

}