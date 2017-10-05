package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCPreCadastroAlunoDAO extends JDBCDAO implements PreCadastroAlunoDAO{


	protected JDBCPreCadastroAlunoDAO(){
	}
	
	@Override
	public void preCadastrar(String nome, String matricula, int curso) {
		super.open();
		try {

			String SQL = "INSERT INTO pre_cadastro_aluno( matricula, nome, id_curso) VALUES (?, ?, ?);";

			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setString(1, matricula);
			ps.setString(2, nome);
			ps.setInt(3, curso);

			ps.execute();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao cadastrar um aluno:"+ e.getMessage());
		}finally {
			super.close();
		}
		
	}
	
	public void preCadastrar(String nome, String matricula, int curso, String semestreDeIngresso){
		super.open();
		try {

			String SQL = "INSERT INTO pre_cadastro_aluno( matricula, nome, id_curso, semestre) VALUES (?, ?, ?);";

			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setString(1, matricula);
			ps.setString(2, nome);
			ps.setInt(3, curso);

			ps.execute();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao cadastrar um aluno:"+ e.getMessage());
		}finally {
			super.close();
		}
		
	}
	

	@Override
	public boolean buscarPreCadastro(String matricula, String nome){
		super.open();
		try {
			String SQL = "SELECT * FROM pre_cadastro_aluno WHERE matricula = ? AND UPPER(nome) LIKE UPPER(?)";

			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setString(1, matricula);
			ps.setString(2, "%"+nome+"%");

			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				
				
				rs.close();
				ps.close();
				
				return true;
				
			}else{
				rs.close();
				ps.close();
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao buscar registro de aluno", e);
		}finally {
			super.close();
		}
	}
	@Override
	public int buscarCursoPreCadastrado (String matricula, String nome){
		super.open();
		try {
			String SQL = "SELECT id_curso FROM pre_cadastro_aluno WHERE matricula = ? AND UPPER(nome) LIKE UPPER(?)";

			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setString(1, matricula);
			ps.setString(2, "%"+nome+"%");

			ResultSet rs = ps.executeQuery();
			if(rs.next()){
			
				return rs.getInt("id_curso");
			}else{
				return -1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao buscar registro de aluno", e);
		}finally {
			super.close();
		}
	}

	public void excluirAlunoPreCadastro(String matricula, String nome){
		super.open();
		try {
			String SQL = "DELETE FROM pre_cadastro_aluno WHERE matricula=? AND UPPER(nome) like UPPER(?)";

			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setString(1, matricula);
			ps.setString(2, "%"+nome+"%");
			ps.executeUpdate();
						
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao buscar registro de aluno", e);
		}finally {
			super.close();
		}
	}


}
