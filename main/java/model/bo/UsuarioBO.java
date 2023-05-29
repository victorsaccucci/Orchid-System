package model.bo;

import model.dao.UsuarioDAO;
import model.vo.UsuarioVO;

public class UsuarioBO {
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	public UsuarioVO realizarLoginBO(UsuarioVO usuarioVO) {	
		return usuarioDAO.realizarLogin(usuarioVO);
	}
	public UsuarioVO cadastrarUsuarioBO(UsuarioVO usuarioVO) {
		return usuarioDAO.cadastrarUsuarioDAO(usuarioVO);
	}
}
