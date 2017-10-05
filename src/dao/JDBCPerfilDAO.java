package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Perfil;


public class JDBCPerfilDAO extends JDBCDAO implements PerfilDAO{
	
	
	
	protected JDBCPerfilDAO(){

	}

	@Override
	public void cadastrar(Perfil perfil) {
		
		super.open();
		
		try {
			String SQL = "INSERT INTO perfil(nome) VALUES (?)";

			PreparedStatement ps = super.getConnection().prepareStatement(SQL);

			ps.setString(1, perfil.getNome());

			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao cadastrar pessoas em JDBCPerfilDAO: "+e.getMessage());
		}finally {
			super.close();

		}

	}

	@Override
	public void editar(Perfil perfil) {
		super.open();
		try {
			String SQL = "UPDATE perfil SET  nome=? WHERE id= ?;";

			PreparedStatement ps = super.getConnection().prepareStatement(SQL);

			ps.setString(1, perfil.getNome());
			ps.setInt(2, perfil.getId());

			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao cadastrar pessoas em JDBCPerfilDAO: "+e.getMessage());
		}finally {
			super.close();
		}

	}

	@Override
	public void excluir(int id) {
		super.open();
		try {
			String SQL = "DELETE FROM perfil WHERE id = ? ";
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setInt(1, id);
			ps.executeUpdate();

			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao remover registro de pessoas em JDBC pessoaDAO", e);

		}finally {
			super.close();
		}

	}

	@Override
	public Perfil buscarPorId(int id) {

		super.open();


		Perfil perfil = new Perfil();
		String SQL = "SELECT * FROM perfil WHERE id = ?";
		try {

			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				perfil.setId(rs.getInt("id"));
				perfil.setNome(rs.getString("nome"));

				ps.close();
				rs.close();

				return perfil;
			} else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();

			throw new RuntimeException("Erro ao buscar registro do perfil: "+e.getMessage());
		}finally {
			super.close();
		}
	}

	@Override
	public Perfil buscarPorNome(String nome){
		super.open();

		Perfil perfil = new Perfil();
		String SQL = "SELECT id, nome FROM public.perfil WHERE UPPER(nome) like UPPER(?)";
		try {

			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setString(1, '%'+nome+'%');

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				perfil.setId(rs.getInt("id"));
				perfil.setNome(rs.getString("nome"));

				ps.close();
				rs.close();

				return perfil;
			} else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();

			throw new RuntimeException("Erro ao buscar registro do perfil: "+e.getMessage());
		}finally {
			super.close();
		}
	}

	@Override
	public List<Perfil> Listar() {
		super.open();
		List<Perfil> perfis = new ArrayList<>();

		try {
			String SQL = "SELECT * FROM perfil ";
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Perfil p = new Perfil();
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				perfis.add(p);

			}

			ps.close();
			rs.close();

			return perfis;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao listar pessoas em JDBC perfilDAO, erro: " + e.getMessage());


		}finally {
			super.close();
		}
	}

}
