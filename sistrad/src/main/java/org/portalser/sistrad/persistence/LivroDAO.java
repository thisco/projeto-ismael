package org.portalser.sistrad.persistence;

import java.util.List;

import javax.persistence.Query;

import org.portalser.sistrad.domain.Livro;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;


@PersistenceController
public class LivroDAO extends JPACrud<Livro, Long> {

	private static final long serialVersionUID = 1L;

	public List<Livro> loadByNumeroCapitulo(String nomeLivro, Long numeroCapitulo) {
		 	
			Query query = getEntityManager().createQuery("from Livro l where l.nome = :nomeLivro and l.capitulo = :capitulo order by l.versiculo");

			query.setParameter("nomeLivro", nomeLivro);
	        query.setParameter("capitulo", numeroCapitulo);

	        List<Livro> resultList = query.getResultList();
			return resultList;
	}
	
	@Override
	public List<Livro> findAll() {
		
		return findByJPQL("from Livro l order by l.nome, l.capitulo, l.versiculo");
	}
	
	
}
