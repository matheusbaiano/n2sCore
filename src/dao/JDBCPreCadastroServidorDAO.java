package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class JDBCPreCadastroServidorDAO extends JDBCDAO implements PreCadastroServidorDAO {
	

	protected JDBCPreCadastroServidorDAO() {
	
	}

	@Override
	public void preCadastrarServidor(String siape, String nome) {
		super.open();
		try {

			String SQL = "INSERT INTO pre_cadastro_servidor( siape, nome) VALUES (?, ?);";

			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setString(1, siape);
			ps.setString(2, nome);

			ps.execute();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao cadastrar um servidor:"+ e.getMessage());
		}finally {
			super.close();
		}
		
	}

	@Override
	public boolean buscarPreCadastro(String siape, String nome){
		super.open();
		try {
			String SQL = "SELECT * FROM pre_cadastro_servidor WHERE siape = ? AND UPPER(nome) LIKE UPPER(?)";

			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setString(1, siape);
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
			throw new RuntimeException("Erro ao buscar registro do servidor", e);
		}finally {
			super.close();
		}
	}

	@Override
	public void excluirPreCadastro(String siape, String nome) {
		super.open();
		try {
			String SQL = "DELETE FROM pre_cadastro_servidor WHERE siape=? AND UPPER(nome) like UPPER(?)";

			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setString(1, siape);
			ps.setString(2, "%"+nome+"%");
			ps.executeUpdate();
			
				
				
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao buscar registro do servidor", e);
		}finally {
			super.close();
		}
		
	}

}
