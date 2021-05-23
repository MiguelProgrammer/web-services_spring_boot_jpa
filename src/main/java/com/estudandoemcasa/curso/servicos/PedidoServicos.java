package com.estudandoemcasa.curso.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudandoemcasa.curso.entidades.Pedido;
import com.estudandoemcasa.curso.repositorios.PedidoRepositorio;

@Service
public class PedidoServicos {

	@Autowired
	private PedidoRepositorio repositorio;
	
	public List<Pedido> procurarTodos(){
		return repositorio.findAll();
	}
	
	public Pedido procurarPorId(Long id) {
		Optional<Pedido> obj = repositorio.findById(id);
		return obj.get();
	}
}
