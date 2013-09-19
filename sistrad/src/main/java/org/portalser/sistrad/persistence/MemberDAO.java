package org.portalser.sistrad.persistence;

import javax.persistence.Query;

import org.portalser.sistrad.domain.Member;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;


@PersistenceController
public class MemberDAO extends JPACrud<Member, Long> {

	private static final long serialVersionUID = 1L;
	
	public Member findByEmail(String email) {
		
		Query query = getEntityManager().createQuery("select * from member where member.email = :email ");

        query.setParameter("email", email);

        return (Member) query.getSingleResult();
	}
	
	
}
