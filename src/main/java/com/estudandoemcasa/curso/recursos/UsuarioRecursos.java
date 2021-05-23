package com.estudandoemcasa.curso.recursos;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<Usuario> insert(@RequestBody Usuario obj){
		obj = servico.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.
					fromCurrentRequest().
						path("/{id}").
							buildAndExpand(obj.getId()).
								toUri();
	 
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		servico.delete(id);
		return ResponseEntity.noContent().build();
	}
}






