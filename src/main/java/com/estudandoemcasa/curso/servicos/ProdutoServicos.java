package com.estudandoemcasa.curso.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudandoemcasa.curso.entidades.Produto;
import com.estudandoemcasa.curso.repositorios.ProdutoRepositorio;

@Service
public class ProdutoServicos {

	@Autowired
	private ProdutoRepositorio repositorio;
	
	public List<Produto> procurarTodos(){
		return repositorio.findAll();
	}
	
	public Produto procurarPorId(Long id) {
		Optional<Produto> obj = repositorio.findById(id);
		return obj.get();
	}
}
