package org.portalser.sistrad.business;

import org.portalser.sistrad.domain.Member;
import org.portalser.sistrad.persistence.MemberDAO;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class MemberBC extends DelegateCrud<Member, Long, MemberDAO> {

	private static final long serialVersionUID = 1L;

	public Member findByEmail(String email) {
		
		return getDelegate().findByEmail(email);
	}

	

	
}
