package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Oferta;
import com.example.demo.repository.OfertaRepository;

@Service
public class OfertaService {
	
	private static final String NAO_ENCONTRADO = "Oferta não encontrado!";
	
	@Autowired
	private OfertaRepository ofertaRepository;

	public Oferta adicionar(Oferta oferta) {
		return this.ofertaRepository.save(oferta);
	}

	public List<Oferta> listar() {
		return this.ofertaRepository.findAll();
	}

	public Oferta editar(Oferta oferta) throws Exception {
		if (oferta.getId() == null || (oferta.getId().isEmpty())) {
			throw new Exception(NAO_ENCONTRADO);
		}
		return this.ofertaRepository.save(oferta);
	}

	public Boolean remover(String idOferta) throws Exception {
		if (idOferta == null) {
			throw new Exception(NAO_ENCONTRADO);
		}
		this.ofertaRepository.deleteById(idOferta);
		return Boolean.TRUE;
	}

	public Oferta obterById(String idOferta) throws Exception {
		if (idOferta == null) {
			throw new Exception(NAO_ENCONTRADO);
		}
		return this.ofertaRepository.findById(idOferta).orElse(new Oferta());
	}

}
