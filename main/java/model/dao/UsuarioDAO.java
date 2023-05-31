package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.vo.UsuarioVO;

public class UsuarioDAO {

	public UsuarioVO realizarLogin(UsuarioVO usuarioVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
	
		
		String sql = " select "
				+ " usuario.idusuario, "
			    + " usuario.nome, "
				+ " usuario.email, "
			    + " usuario.senha "
			+ " from usuario "
			+ " where usuario.email like '" + usuarioVO.getEmail() + "' "
			+ " and usuario.senha like '" + usuarioVO.getSenha() + "' ";
		try {
			resultado = stmt.executeQuery(sql);
			if (resultado.next()) {	
				usuarioVO.setIdUsuario(Integer.parseInt(resultado.getString(1)));
				usuarioVO.setNome(resultado.getString(2));
				usuarioVO.setEmail(resultado.getString(3));
				usuarioVO.setSenha(resultado.getString(4));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao realizar login! \nCausa: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeConnection(conn);
			Banco.closeStatement(stmt);
		}
		return usuarioVO;
	}

	public UsuarioVO cadastrarUsuarioDAO(UsuarioVO novoUsuario) {
		Connection conexao = Banco.getConnection();
		String sql = " INSERT INTO USUARIO(NOME, EMAIL, SENHA) " + " VALUES (?,?,?) ";
		PreparedStatement stmt = Banco.getPreparedStatementWithPk(conexao, sql);

		try {
			stmt.setString(1, novoUsuario.getNome());
			stmt.setString(2, novoUsuario.getEmail());
			stmt.setString(3, novoUsuario.getSenha());
			stmt.execute();

			ResultSet resultado = stmt.getGeneratedKeys();
			if (resultado.next()) {
				novoUsuario.setIdUsuario(resultado.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir novo usuarioooooo!" + "\nCausa: " + e.getMessage());
		}
		return novoUsuario;
	}

}
