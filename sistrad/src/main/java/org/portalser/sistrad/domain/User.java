package org.portalser.sistrad.domain;

import java.security.Principal;

public class User implements Principal {

	private String name;
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	

}
