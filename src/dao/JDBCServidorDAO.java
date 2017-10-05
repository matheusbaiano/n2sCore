package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Servidor;
import model.Usuario;

public class JDBCServidorDAO extends JDBCDAO implements ServidorDAO {

	protected JDBCServidorDAO() {

	}

	@Override
	public void cadastrar(Servidor servidor) {
		super.open();

		try {
			String SQL = "INSERT INTO servidor (siape, id_pessoa_usuario,cargo) VALUES (?,?,?)";
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);

			ps.setString(1, servidor.getSiape());
			ps.setInt(2, servidor.getId());
			ps.setString(3, servidor.getCargo().getCargo());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao cadastrar servidor, " + e.getMessage());
		} finally {
			super.close();
		}
	}

	@Override
	public Servidor buscar(String siape) {
		super.open();
		Servidor servidor = new Servidor();
		Usuario usuario =  new Usuario();

		String SQL = "SELECT * FROM servidor WHERE siape = ?";

		try {
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setString(1, siape);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				servidor.setNome(rs.getString("nome"));
				servidor.setCpf(rs.getString("cpf"));
				servidor.setDataNascimento(rs.getString("data_nascimento"));
				servidor.setCargo(rs.getString("cargo"));
				servidor.setEmail(rs.getString("email"));
				servidor.setSiape(rs.getString("siape"));
				servidor.setId(rs.getInt("id_pessoa_usuario"));
				usuario.setLogin(rs.getString("login"));
				usuario.setNivel(rs.getInt("nivel"));
				usuario.setSenha(rs.getString("senha"));
				servidor.setUsuario(usuario);
			}
			ps.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao buscar registro de servidor", e);
		} finally {
			super.close();
		}
		return servidor;
	}

	public Servidor buscarPorSiape(String siape) {
		super.open();
		Servidor servidor = new Servidor();
		Usuario usuario = new Usuario();

		String SQL = "SELECT * FROM servidor AS s, pessoa_usuario as p WHERE siape = ? and s.id_pessoa_usuario = p.id_pessoa_usuario;";

		try {
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);

			ps.setString(1, siape);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				servidor.setNome(rs.getString("nome"));
				servidor.setCpf(rs.getString("cpf"));
				servidor.setDataNascimento(rs.getString("data_nascimento"));
				servidor.setCargo(rs.getString("cargo"));
				servidor.setEmail(rs.getString("email"));
				servidor.setSiape(rs.getString("siape"));
				servidor.setId(rs.getInt("id_pessoa_usuario"));
				usuario.setLogin(rs.getString("login"));
				usuario.setNivel(rs.getInt("nivel"));
				usuario.setSenha(rs.getString("senha"));
				servidor.setUsuario(usuario);

				ps.close();
				rs.close();
				return servidor;

			}
			ps.close();
			rs.close();
			return null;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao buscar registro de servidor", e);
		} finally {
			super.close();
		}
	}

	public List<Servidor> buscarPorNome(String nome) {
		super.open();
		List<Servidor> servidores = new ArrayList<Servidor>();
		String SQL = "SELECT * FROM servidor AS s, pessoa_usuario as p WHERE s.id_pessoa_usuario = p.id_pessoa_usuario AND UPPER(nome) LIKE UPPER(?);";

		try {
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);

			ps.setString(1, nome);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Servidor servidor = new Servidor();
				Usuario usuario = new Usuario();
				servidor.setNome(rs.getString("nome"));
				servidor.setCpf(rs.getString("cpf"));
				servidor.setDataNascimento(rs.getString("data_nascimento"));
				servidor.setCargo(rs.getString("cargo"));
				servidor.setEmail(rs.getString("email"));
				servidor.setSiape(rs.getString("siape"));
				servidor.setId(rs.getInt("id_pessoa_usuario"));
				usuario.setLogin(rs.getString("login"));
				usuario.setNivel(rs.getInt("nivel"));
				usuario.setSenha(rs.getString("senha"));
				servidor.setUsuario(usuario);

				servidores.add(servidor);

			}
			ps.close();
			rs.close();
			return servidores;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao buscar registro de servidor", e);
		} finally {
			super.close();
		}
	}

	@Override
	public List<Servidor> listar() {
		super.open();
		ArrayList<Servidor> servidores = new ArrayList<>();

		try {
			String SQL = "SELECT * FROM servidor";

			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Servidor servidor = new Servidor();
				Usuario usuario = new Usuario();
				servidor.setNome(rs.getString("nome"));
				servidor.setCpf(rs.getString("cpf"));
				servidor.setDataNascimento(rs.getString("data_nascimento"));
				servidor.setCargo(rs.getString("cargo"));
				servidor.setEmail(rs.getString("email"));
				servidor.setSiape(rs.getString("siape"));
				servidor.setId(rs.getInt("id_pessoa_usuario"));
				usuario.setLogin(rs.getString("login"));
				usuario.setNivel(rs.getInt("nivel"));
				usuario.setSenha(rs.getString("senha"));
				servidor.setUsuario(usuario);

				ps.close();
				rs.close();
				servidores.add(servidor);

			}
			return servidores;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao listar pessoas em JDBC pessoaDAO", e);
		} finally {
			super.close();
		}

	}

	@Override
	public Servidor buscarPorToken(String token) {
		super.open();
		Servidor servidor = new Servidor();
		Usuario usuario = new Usuario();

		String SQL = "SELECT * FROM servidor AS s, pessoa_usuario as p WHERE p.token_recuperacao = ? and s.id_pessoa_usuario = p.id_pessoa_usuario";

		try {
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);

			ps.setString(1, token);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				servidor.setNome(rs.getString("nome"));
				servidor.setCpf(rs.getString("cpf"));
				servidor.setDataNascimento(rs.getString("data_nascimento"));
				servidor.setCargo(rs.getString("cargo"));
				servidor.setEmail(rs.getString("email"));
				servidor.setSiape(rs.getString("siape"));
				servidor.setId(rs.getInt("id_pessoa_usuario"));
				usuario.setLogin(rs.getString("login"));
				usuario.setNivel(rs.getInt("nivel"));
				usuario.setSenha(rs.getString("senha"));
				servidor.setUsuario(usuario);

				ps.close();
				rs.close();
				return servidor;

			}
			ps.close();
			rs.close();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao buscar registro de servidor", e);
		} finally {
			super.close();
		}
	}
	public List<Servidor> buscarPorNome(String nome, Integer inicio, Integer fim) {
		super.open();
		List<Servidor> servidores = new ArrayList<Servidor>();
		try {
			PreparedStatement ps = super.getConnection().prepareStatement("SELECT * FROM servidor AS s, pessoa_usuario as p WHERE s.id_pessoa_usuario = p.id_pessoa_usuario AND UPPER(nome) like UPPER(?) LIMIT ? OFFSET ?;");
			ps.setString(1, "%"+nome+"%");
			ps.setInt(2, fim - inicio);
			ps.setInt(3, inicio);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Servidor servidor = new Servidor();
				Usuario usuario = new Usuario();
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setNivel(rs.getInt("nivel"));
				servidor.setUsuario(usuario);
				servidor.setId(rs.getInt("id_pessoa_usuario"));
				servidor.setCpf(rs.getString("cpf"));
				servidor.setDataNascimento(LocalDate.parse(rs.getString("data_nascimento")));
				servidor.setEmail(rs.getString("email"));
				servidor.setSiape(rs.getString("siape"));
				servidor.setNome(rs.getString("nome"));
				servidores.add(servidor);
			}
			ps.close();
			rs.close();
			return servidores;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao buscar registro de servidor", e);
		} finally {
			super.close();
		}
	}

	@Override
	public Integer getQuantidadePorNome(String nome) {
		super.open();
		try {
			PreparedStatement ps = super.getConnection().prepareStatement("SELECT COUNT(*) AS quantidade FROM servidor AS s, pessoa_usuario as p WHERE s.id_pessoa_usuario = p.id_pessoa_usuario AND UPPER(nome) LIKE UPPER(?);");
			ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();
			Integer quantidade = null;
			if (rs.next()) {
				quantidade = rs.getInt("quantidade");
			}else {
				quantidade = 0;
			}
			ps.close();
			rs.close();
			return quantidade;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao buscar registro de servidor", e);
		} finally {
			super.close();
		}
	}

}
