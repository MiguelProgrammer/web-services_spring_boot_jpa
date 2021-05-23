package com.estudandoemcasa.curso.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudandoemcasa.curso.entidades.Usuario;
import com.estudandoemcasa.curso.servicos.UsuarioServicos;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioRecursos {
	
	@Autowired
	private UsuarioServicos servico;

	@GetMapping
	public ResponseEntity<List<Usuario>> procurarTodos(){
		List<Usuario> lista = servico.procurarTodos();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> procurarPorId(@PathVariable Long id){
		Usuario obj = servico.procurarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
