package org.portalser.sistrad.business;

import java.util.List;

import javax.inject.Inject;

import org.portalser.sistrad.domain.Livro;
import org.portalser.sistrad.persistence.LivroDAO;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class LivroBC extends DelegateCrud<Livro, Long, LivroDAO>{

	@Inject
	private LivroDAO livroDAO;
	
	private static final long serialVersionUID = 1L;

	public List<Livro> loadByNumeroCapitulo(String nomeLivro, Long numeroCapitulo) {
		
		return livroDAO.loadByNumeroCapitulo(nomeLivro, numeroCapitulo);
	}
	
}
