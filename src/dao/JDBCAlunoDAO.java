package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import model.Curso;
import model.Usuario;

public class JDBCAlunoDAO extends JDBCDAO implements AlunoDAO {
	

	protected JDBCAlunoDAO() {
	
	}

	@Override
	public void cadastrar(Aluno aluno) {
		super.open();
		
		try {

			String SQL = "INSERT INTO aluno (matricula, id_curso, semestre_ingresso, id_pessoa_usuario) VALUES"
					+ "(?,?,?,?)";

			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setString(1, aluno.getMatricula());
			ps.setInt(2, aluno.getCurso().getId());
			ps.setString(3, aluno.getSemestreIngresso());
			ps.setInt(4, aluno.getId());

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
	public Aluno buscar(int id) {
		super.open();
		try {
			String SQL = "SELECT * FROM aluno AS u_a, pessoa_usuario AS u, curso AS c WHERE u_a.id_pessoa_usuario=? AND u_a.id_pessoa_usuario = u.id_pessoa_usuario AND u_a.id_curso = c.id_curso";

			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				Aluno aluno = new Aluno();
				Curso curso = new Curso();
				Usuario usuario = new Usuario();
				curso.setId(rs.getInt("id_curso"));
				curso.setNome(rs.getString("nome_curso"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setNivel(rs.getInt("nivel"));
				aluno.setUsuario(usuario);
				aluno.setMatricula(rs.getString("matricula"));
				aluno.setSemestreIngresso(rs.getString("semestre_ingresso"));
				aluno.setId(rs.getInt("id_pessoa_usuario"));
				aluno.setCurso(curso);
				aluno.setNome(rs.getString("nome"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setDataNascimento(LocalDate.parse(rs.getString("data_nascimento")));
				aluno.setEmail(rs.getString("email"));
				
				rs.close();
				ps.close();
				
				return aluno;
				
			}else{
				return null;
			}


		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao buscar registro de aluno", e);
		}finally {
			super.close();
		}
	}
	@Override
	public Aluno buscarPorMatricula(String matricula) {
		super.open();
		try {
			String SQL = "SELECT * FROM aluno AS a, pessoa_usuario AS p_u, curso AS c WHERE a.matricula= ? AND a.id_pessoa_usuario = p_u.id_pessoa_usuario AND a.id_curso = c.id_curso";

			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setString(1, matricula);

			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				Aluno aluno = new Aluno();
				Curso curso = new Curso();
				Usuario usuario = new Usuario();
				curso.setId(rs.getInt("id_curso"));
				aluno.setMatricula(rs.getString("matricula"));
				aluno.setSemestreIngresso(rs.getString("semestre_ingresso"));
				aluno.setId(rs.getInt("id_pessoa_usuario"));
				aluno.setCurso(curso);
				aluno.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				aluno.setUsuario(usuario);
				
				
				rs.close();
				ps.close();
				
				return aluno;
				
			}else{
				return null;
			}


		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao buscar registro de aluno", e);
		}finally {
			super.close();
		}
	}
	@Override
	public List<Aluno> buscarPorNome(String nome){
		super.open();
		List<Aluno> alunos = new ArrayList<Aluno>();

		try {
			String SQL = "SELECT * FROM aluno AS u_a, pessoa_usuario AS u, curso AS c WHERE u_a.id_pessoa_usuario = u.id_pessoa_usuario AND u_a.id_curso = c.id_curso AND  UPPER(u.nome) like UPPER(?)";
			
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setString(1, '%'+nome+'%');
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Aluno aluno = new Aluno();
				Curso curso = new Curso();
				Usuario usuario = new Usuario();
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setNivel(rs.getInt("nivel"));
				aluno.setUsuario(usuario);
				curso.setId(rs.getInt("id_curso"));
				curso.setNome(rs.getString("nome_curso"));
				aluno.setMatricula(rs.getString("matricula"));
				aluno.setSemestreIngresso(rs.getString("semestre_ingresso"));
				aluno.setId(rs.getInt("id_pessoa_usuario"));
				aluno.setCurso(curso);
				aluno.setNome(rs.getString("nome"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setDataNascimento(LocalDate.parse(rs.getString("data_nascimento")));
				aluno.setEmail(rs.getString("email"));
				
				alunos.add(aluno);
			}
			rs.close();
			ps.close();
			return alunos;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao listar pessoas em JDBC AlunoDAO", e);

		}finally {
			super.close();
		}
	}
	

	@Override
	public List<Aluno> listar() {
		super.open();
		List<Aluno> alunos = new ArrayList<Aluno>();

		try {
			String SQL = "SELECT * FROM aluno AS u_a, pessoa_usuario AS u, curso AS c WHERE u_a.id_pessoa_usuario = u.id_pessoa_usuario AND u_a.id_curso = c.id_curso";
			
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Aluno aluno = new Aluno();
				Curso curso = new Curso();
				Usuario usuario = new Usuario();
				curso.setId(rs.getInt("id_curso"));
				curso.setNome(rs.getString("nome_curso"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setNivel(rs.getInt("nivel"));
				aluno.setUsuario(usuario);
				aluno.setMatricula(rs.getString("matricula"));
				aluno.setSemestreIngresso(rs.getString("semestre_ingresso"));
				aluno.setId(rs.getInt("id_pessoa_usuario"));
				aluno.setCurso(curso);
				aluno.setNome(rs.getString("nome"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setDataNascimento(LocalDate.parse(rs.getString("data_nascimento")));
				aluno.setEmail(rs.getString("email"));
				
				alunos.add(aluno);
			}
			rs.close();
			ps.close();
			return alunos;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao listar pessoas em JDBC AlunoDAO", e);

		}finally {
			super.close();
		}
	}

	@Override
	public void editar(Aluno aluno) {
		super.open();
		try {
			String SQL = "UPDATE aluno SET semestre_ingresso=?,matricula=?, id_curso=? WHERE id_pessoa_usuario = ?";

			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setString(1, aluno.getSemestreIngresso());
			ps.setString(2, aluno.getMatricula());
			ps.setInt(3, aluno.getCurso().getId());
			ps.setInt(4, aluno.getId());
			
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao editar registro de aluno", e);
		}finally {
			super.close();
		}

	}

	@Override
	public Aluno buscarTokenRecuperacao(String token){
		super.open();

		try {
			String SQL = "SELECT * FROM aluno AS a, pessoa_usuario AS p_u, curso AS c WHERE p_u.token_recuperacao = ? AND a.id_pessoa_usuario = p_u.id_pessoa_usuario AND a.id_curso = c.id_curso";

			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setString(1, token);

			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				Aluno aluno = new Aluno();
				Curso curso = new Curso();
				Usuario usuario = new Usuario();
				curso.setId(rs.getInt("id_curso"));	
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setNivel(rs.getInt("nivel"));
				aluno.setUsuario(usuario);			
				
				rs.close();
				ps.close();
				
				return aluno;
				
			}else{
				return null;
			}


		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao buscar registro de aluno", e);
		}finally {
			super.close();
		}
	}

	@Override
	public List<Aluno> buscarPorNome(String nome, int inicio, int fim) {
		super.open();
		List<Aluno> alunos = new ArrayList<Aluno>();

		try {
			String SQL = "SELECT * FROM aluno AS u_a, pessoa_usuario AS u, curso AS c WHERE u_a.id_pessoa_usuario = u.id_pessoa_usuario AND u_a.id_curso = c.id_curso AND  UPPER(u.nome) like UPPER(?) LIMIT ? OFFSET ?";
			
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setString(1, '%'+nome+'%');
			ps.setInt(2, fim - inicio);
			ps.setInt(3, inicio);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Aluno aluno = new Aluno();
				Curso curso = new Curso();
				Usuario usuario = new Usuario();
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setNivel(rs.getInt("nivel"));
				aluno.setUsuario(usuario);
				curso.setId(rs.getInt("id_curso"));
				curso.setNome(rs.getString("nome_curso"));
				aluno.setMatricula(rs.getString("matricula"));
				aluno.setSemestreIngresso(rs.getString("semestre_ingresso"));
				aluno.setId(rs.getInt("id_pessoa_usuario"));
				aluno.setCurso(curso);
				aluno.setNome(rs.getString("nome"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setDataNascimento(LocalDate.parse(rs.getString("data_nascimento")));
				aluno.setEmail(rs.getString("email"));
				
				alunos.add(aluno);
			}
			rs.close();
			ps.close();
			return alunos;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao listar pessoas em JDBC AlunoDAO", e);

		}finally {
			super.close();
		}
	}

	@Override
	public Integer getQuantidadePorNome(String nome) {
		super.open();
		try {
			String SQL = "SELECT COUNT(*) AS quantidade FROM aluno AS u_a, pessoa_usuario AS u, curso AS c WHERE u_a.id_pessoa_usuario = u.id_pessoa_usuario AND u_a.id_curso = c.id_curso AND  UPPER(u.nome) like UPPER(?)";			
			PreparedStatement ps = super.getConnection().prepareStatement(SQL);
			ps.setString(1, '%'+nome+'%');
			ResultSet rs = ps.executeQuery();
			Integer quantidade = null;
			if (rs.next()) {				
				quantidade = rs.getInt("quantidade");								
			}else {
				quantidade = 0;
			}
			rs.close();
			ps.close();
			return quantidade;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao listar pessoas em JDBC AlunoDAO", e);
		}finally {
			super.close();
		}
	}
	
	
}
