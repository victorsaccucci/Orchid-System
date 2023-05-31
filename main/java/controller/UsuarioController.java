package controller;

import model.bo.UsuarioBO;
import model.exception.ExceptionSystem;
import model.vo.UsuarioVO;

public class UsuarioController {
	UsuarioBO usuarioBO = new UsuarioBO();

	public UsuarioVO realizarLoginController(UsuarioVO usuarioVO) {
		return usuarioBO.realizarLoginBO(usuarioVO);

	}
	
	public boolean verificaLogin(UsuarioVO usuarioVO) {
		boolean login = false;
		
		if(this.camposObrigatoriosLogin(usuarioVO)) {
			login = realizarLoginController(usuarioVO) != null;
		}if(login) {
			System.out.println("Logado com sucesso");
		}else {
			System.out.println("Erro ao realizar login");
		}
		
		return login;
	}

	public UsuarioVO cadastrarUsuarioController(UsuarioVO usuarioVO) throws ExceptionSystem {

		this.validarCamposObrigatorios(usuarioVO);

		return usuarioBO.cadastrarUsuarioBO(usuarioVO);
	}

	public void validarCamposObrigatorios(UsuarioVO usuarioVO) throws ExceptionSystem {
		String mensagemValidacao = "";

		if (usuarioVO.getNome() == null) {
			mensagemValidacao += "Insira o nome";
		}
		if (usuarioVO.getEmail() == null) {
			mensagemValidacao += "Insira o email";
		}
		if (usuarioVO.getSenha() == null) {
			mensagemValidacao += "Insira a senha";
		}
		if (!mensagemValidacao.isEmpty()) {
			throw new ExceptionSystem(mensagemValidacao);
		}
	}

	public boolean camposObrigatoriosLogin(UsuarioVO usuarioVO) {
		boolean resultado = false;
		if (usuarioVO.getEmail() == null || usuarioVO.getEmail().isEmpty()) {
			System.out.println("O campo e-mail é obrigatório.");
			resultado = false;
			if (usuarioVO.getSenha() == null || usuarioVO.getSenha().isEmpty()) {
				System.out.println("O campo senha é obrigatório.");
				resultado = false;
			}
		}
		return resultado;
	}

}
