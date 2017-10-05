package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class JDBCUsuarioDAO extends JDBCDAO implements UsuarioDAO {

	protected JDBCUsuarioDAO() {

	}

	@Override
	public void cadastrar(Usuario usuario) {
		super.open();
		try {
			String SQL = "UPDATE pessoa_usuario SET login=?, senha=?, nivel=? WHERE id_pessoa_usuario=?";
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);

			ps.setString(1, usuario.getLogin());
			ps.setString(2, usuario.getSenha());
			ps.setInt(3, usuario.getNivel() != null ? usuario.getNivel().getValorNivel() : 2);
			ps.setInt(4, usuario.getPessoa().getId());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao cadastrar usuarios em JDBCUsuaruioDAO", e);
		} finally {
			super.close();
		}

	}

	@Override
	public void editar(Usuario usuario) {
		super.open();
		try {
			String SQL = "UPDATE pessoa_usuario SET login=?, senha=? WHERE id_pessoa_usuario = ?";
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setString(1, usuario.getLogin());
			ps.setString(2, usuario.getSenha());
			ps.setInt(3, usuario.getPessoa().getId());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao editar registro de usuario", e);
		} finally {
			super.close();
		}

	}

	@Override
	public boolean autenticar(String login, String senha) {
		super.open();
		try {
			String SQL = "SELECT * FROM pessoa_usuario as u WHERE u.login = ?";
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);

			ps.setString(1, login);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Usuario usuario = new Usuario(rs.getString("login"), rs.getString("senha"));
				if (usuario.getSenha().equals(senha)) {
					return true;
				}
			}
			ps.close();
			rs.close();

		} catch (SQLException e) {
			throw new RuntimeException("Erro: login e senha inválidos");
		} finally {
			super.close();
		}
		return false;
	}

	@Override
	public void editarNivel(Usuario usuario) {
		super.open();
		try {
			String SQL = "UPDATE pessoa_usuario SET nivel =? WHERE id_pessoa_usuario =?";

			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setInt(1, usuario.getNivel().getValorNivel());
			ps.setInt(2, usuario.getPessoa().getId());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erroao editar nível de usuario");
		} finally {
			super.close();
		}

	}

	@Override
	public void salvarToken(String token, int id_usuario) {
		super.open();

		try {
			String SQL = "UPDATE pessoa_usuario SET token_sessao =? WHERE id_pessoa_usuario = ?";
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setString(1, token);
			ps.setInt(2, id_usuario);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao gravar token do usuário" + e.getMessage());
		} finally {
			super.close();
		}
	}

	@Override
	public void salvarTokenUsuario(String token, int id_usuario) {
		super.open();
		try {
			String SQL = "UPDATE pessoa_usuario SET token_usuario =? WHERE id_pessoa_usuario = ?";
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setString(1, token);
			ps.setInt(2, id_usuario);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao gravar token do usuário" + e.getMessage());
		} finally {
			super.close();
		}
	}

}
