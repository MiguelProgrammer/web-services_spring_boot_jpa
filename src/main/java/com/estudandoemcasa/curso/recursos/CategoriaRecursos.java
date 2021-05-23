package com.estudandoemcasa.curso.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudandoemcasa.curso.entidades.Categoria;
import com.estudandoemcasa.curso.servicos.CategoriaServicos;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaRecursos {
	
	@Autowired
	private CategoriaServicos servico;

	@GetMapping
	public ResponseEntity<List<Categoria>> procurarTodos(){
		List<Categoria> lista = servico.procurarTodos();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> procurarPorId(@PathVariable Long id){
		Categoria obj = servico.procurarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
