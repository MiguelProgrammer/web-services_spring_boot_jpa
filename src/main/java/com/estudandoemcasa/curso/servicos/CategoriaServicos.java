package com.estudandoemcasa.curso.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudandoemcasa.curso.entidades.Categoria;
import com.estudandoemcasa.curso.repositorios.CategoriaRepositorio;

@Service
public class CategoriaServicos {

	@Autowired
	private CategoriaRepositorio repositorio;
	
	public List<Categoria> procurarTodos(){
		return repositorio.findAll();
	}
	
	public Categoria procurarPorId(Long id) {
		Optional<Categoria> obj = repositorio.findById(id);
		return obj.get();
	}
}
