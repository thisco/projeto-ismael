package org.portalser.sistrad.security;

import java.security.Principal;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.portalser.sistrad.domain.User;

import br.gov.frameworkdemoiselle.security.AuthenticationException;
import br.gov.frameworkdemoiselle.security.Authenticator;
import br.gov.frameworkdemoiselle.security.Credentials;
import br.gov.frameworkdemoiselle.util.Beans;

@SessionScoped
public class SistradAuthenticator implements Authenticator {

	private static final long serialVersionUID = 1L;

	@Inject
	private Credentials credentials;

	private Principal user;

	@Override
	public void authenticate() throws AuthenticationException {
		try {
			if (credentials.getUsername().equals(null)){
				throw new AuthenticationException("Usuário não Cadastrado");
			}
			User user = new User();
			user.setName(credentials.getUsername());
			this.user = user;
			
		} catch (Exception cause) {
			throw new AuthenticationException(cause);
		}
	}

	
	@Override
	public void unAuthenticate() {
		user = null;
		Beans.getReference(HttpSession.class).invalidate();
	}

	@Override
	public Principal getUser() {
		return user;
	}

	
}
