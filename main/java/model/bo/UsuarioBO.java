package model.bo;

import model.dao.UsuarioDAO;
import model.exception.ExceptionSystem;
import model.vo.UsuarioVO;

public class UsuarioBO {
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	public UsuarioVO realizarLoginBO(String email, String senha) throws ExceptionSystem {	
		UsuarioVO usuarioAutenticado = usuarioDAO.realizarLogin(email, senha);
		
		if(usuarioAutenticado == null) {
			throw new ExceptionSystem("Usuário não encontrado");
		}
		
		return usuarioAutenticado;
	}
	
	public UsuarioVO cadastrarUsuarioBO(UsuarioVO usuarioVO) {
		return usuarioDAO.cadastrarUsuarioDAO(usuarioVO);
	}
}
