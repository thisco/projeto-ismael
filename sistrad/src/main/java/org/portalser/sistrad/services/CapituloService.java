package org.portalser.sistrad.services;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.portalser.sistrad.business.LivroBC;
import org.portalser.sistrad.domain.Livro;
import org.portalser.sistrad.dto.LivroDTO;
import org.portalser.sistrad.dto.LivroFactory;
import org.portalser.sistrad.dto.VersiculoDTO;

@Path("/capitulo")
@RequestScoped
public class CapituloService {

	@Inject
	private LivroBC livroBC;
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<VersiculoDTO> lookupVersiculosById(@QueryParam("nomeLivro") String nomeLivro,   
			@QueryParam("numeroCapitulo") Long numeroCapitulo) {
		List<Livro> livros = livroBC.loadByNumeroCapitulo(nomeLivro, numeroCapitulo);
		
		List<LivroDTO> livrosDTO = LivroFactory.assembleDTO(livros);
		
		if (livrosDTO != null && livrosDTO.get(0) == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return livrosDTO.get(0).getCapitulos().get(0).getVersiculos();
	}
	
	
}
