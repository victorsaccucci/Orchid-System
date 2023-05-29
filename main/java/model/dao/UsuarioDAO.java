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

			String sql = " SELECT U.IDUSUARIO, U.SENHA, U.EMAIL " + " FROM	USUARIO U "
					+ " WHERE	U.EMAIL LIKE '" + usuarioVO.getEmail() + "' " + " AND U.SENHA LIKE '" + usuarioVO.getSenha()
					+ "' ";
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

		public UsuarioVO cadastrarUsuarioDAO(UsuarioVO usuarioVO) {
			String sql = "INSERT INTO usuario (nome, email, senha) VALUES (?, ?, ?)";
			Connection conn = Banco.getConnection();
			PreparedStatement pstmt = Banco.getPreparedStatementWithPk(conn, sql);
			try {
				pstmt.setString(1, usuarioVO.getNome());
				pstmt.setString(2, usuarioVO.getEmail());
				pstmt.setString(3, usuarioVO.getSenha());
				pstmt.execute();

				ResultSet resultado = pstmt.getGeneratedKeys();
				if (resultado.next()) {
					usuarioVO.setIdUsuario(resultado.getInt(1));
				}
			} catch (SQLException e) {
				System.out.println("Erro ao cadastrar usuário! \nCausa: " + e.getMessage());
			} finally {
				Banco.closeStatement(pstmt);
				Banco.closeConnection(conn);
			}
			return usuarioVO;
		}
	
	}


