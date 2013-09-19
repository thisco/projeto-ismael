package org.portalser.sistrad.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.portalser.sistrad.business.LivroBC;
import org.portalser.sistrad.domain.Livro;
import org.portalser.sistrad.dto.LivroDTO;
import org.portalser.sistrad.dto.LivroFactory;

@Path("/livro")
@RequestScoped
public class LivroService {

	
	@Inject
	private LivroBC livroBC;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<LivroDTO> listAllLivros() {
		
		List<Livro> livros = livroBC.findAll();
		
		List<LivroDTO> livrosDTO = LivroFactory.assembleDTO(livros);
		
		return livrosDTO;
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Livro lookupLivroById(@PathParam("id") long id) {
		Livro livro = livroBC.load(id);
		if (livro == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return livro;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createMember(Livro livro) {

		Response.ResponseBuilder builder = null;

		try {
			// Validates member using bean validation
			validateLivro(livro);

			livroBC.insert(livro);

			// Create an "ok" response
			builder = Response.ok();
		} catch (ConstraintViolationException ce) {
			// Handle bean validation issues
			builder = createViolationResponse(ce.getConstraintViolations());
		} catch (ValidationException e) {
			// Handle the unique constrain violation
			
			// TODO criar resposta de validação para inserir */
			
			 
			
			//Map<String, String> responseObj = new HashMap<String, String>();
			//responseObj.put("email", "Email taken");
			//builder = Response.status(Response.Status.CONFLICT).entity(
			//		responseObj);
		} catch (Exception e) {
			// Handle generic exceptions
			Map<String, String> responseObj = new HashMap<String, String>();
			responseObj.put("error", e.getMessage());
			builder = Response.status(Response.Status.BAD_REQUEST).entity(
					responseObj);
		}

		return builder.build();
	}

	private void validateLivro(Livro livro) {
		// TODO Criar validação do livro
		
	}
	private Response.ResponseBuilder createViolationResponse(
			Set<ConstraintViolation<?>> violations) {

		Map<String, String> responseObj = new HashMap<String, String>();

		for (ConstraintViolation<?> violation : violations) {
			responseObj.put(violation.getPropertyPath().toString(),
					violation.getMessage());
		}

		return Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
	}
	
}
