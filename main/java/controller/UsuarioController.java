package controller;

import model.bo.UsuarioBO;
import model.exception.ExceptionSystem;
import model.vo.UsuarioVO;

public class UsuarioController {
	UsuarioBO usuarioBO = new UsuarioBO();

	public UsuarioVO realizarLoginController(String email, String senha) throws ExceptionSystem {
		
		String validacao = "";
		
		if(email == null || email.trim().isEmpty()) {
			validacao += "Informe o email";
		}
		
		if(senha == null || senha.trim().isEmpty()) {
			validacao += "Informe a senha";
		}
		
		if(!validacao.isEmpty()) {
			//Alguma regra de validação foi violada
			throw new ExceptionSystem(validacao);
		}
		
		return usuarioBO.realizarLoginBO(email, senha);
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
        //teste
        
}
