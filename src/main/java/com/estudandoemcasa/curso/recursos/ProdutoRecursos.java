package com.estudandoemcasa.curso.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudandoemcasa.curso.entidades.Produto;
import com.estudandoemcasa.curso.servicos.ProdutoServicos;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoRecursos {
	
	@Autowired
	private ProdutoServicos servico;

	@GetMapping
	public ResponseEntity<List<Produto>> procurarTodos(){
		List<Produto> lista = servico.procurarTodos();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> procurarPorId(@PathVariable Long id){
		Produto obj = servico.procurarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
