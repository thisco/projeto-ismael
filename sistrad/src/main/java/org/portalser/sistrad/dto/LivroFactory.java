package org.portalser.sistrad.dto;

import java.util.ArrayList;
import java.util.List;

import org.portalser.sistrad.domain.Livro;

public class LivroFactory {

	public static List<LivroDTO> assembleDTO(List<Livro> livros) {

		List<LivroDTO> livrosDTO = new ArrayList<LivroDTO>();
		String nome = null;
		Long capitulo = null;

		LivroDTO livroDTO = null;

		List<CapituloDTO> capitulos = new ArrayList<CapituloDTO>();
		List<VersiculoDTO> versiculos = new ArrayList<VersiculoDTO>();
		CapituloDTO capituloDTO;

		for (Livro livro : livros) {

			if (livro != null && !livro.getNome().equals(nome)) {

				livroDTO = new LivroDTO();
				capitulos = new ArrayList<CapituloDTO>();
				versiculos = new ArrayList<VersiculoDTO>();

				livroDTO.setNome(livro.getNome());
				livroDTO.setId(livro.getId());

				capituloDTO = new CapituloDTO();
				capituloDTO.setNumero(livro.getCapitulo());
				capitulos.add(capituloDTO);

				VersiculoDTO versiculoDTO = new VersiculoDTO();
				assembleVersiculo(versiculos, livro, versiculoDTO);

				capituloDTO.setVersiculos(versiculos);
				livroDTO.setCapitulos(capitulos);
				livrosDTO.add(livroDTO);

			} else {

				if (livro.getCapitulo() != capitulo) {
					capituloDTO = new CapituloDTO();
					capituloDTO.setNumero(livro.getCapitulo());
					capitulos.add(capituloDTO);

					VersiculoDTO versiculoDTO = new VersiculoDTO();
					assembleVersiculo(versiculos, livro, versiculoDTO);
				} else {
					VersiculoDTO versiculoDTO = new VersiculoDTO();
					assembleVersiculo(versiculos, livro, versiculoDTO);
				}
			}

			nome = livro.getNome();
			capitulo = livro.getCapitulo();

		}

		return livrosDTO;
	}

	private static void assembleVersiculo(List<VersiculoDTO> versiculos,
			Livro livro, VersiculoDTO versiculoDTO) {

		versiculoDTO.setNumero(livro.getVersiculo());
		versiculoDTO.setOriginal(livro.getOriginal());
		versiculoDTO.setTraduzido(livro.getTraduzido());
		if (livro.getTraduzido() == null || livro.getTraduzido().trim().equals("")) {
			versiculoDTO.setTexto(livro.getOriginal());
		} else {
			versiculoDTO.setTexto(livro.getTraduzido());
		}
		versiculoDTO.setId(livro.getId());
		versiculos.add(versiculoDTO);
	}

}
