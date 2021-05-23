package com.estudandoemcasa.curso.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudandoemcasa.curso.entidades.Usuario;
import com.estudandoemcasa.curso.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServicos {

	@Autowired
	private UsuarioRepositorio repositorio;
	
	public List<Usuario> procurarTodos(){
		return repositorio.findAll();
	}
	
	public Usuario procurarPorId(Long id) {
		Optional<Usuario> obj = repositorio.findById(id);
		return obj.get();
	}
	
	public Usuario insert(Usuario obj) {
		return repositorio.save(obj);
	}
}
