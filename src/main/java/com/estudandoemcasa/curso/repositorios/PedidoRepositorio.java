package com.estudandoemcasa.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudandoemcasa.curso.entidades.Pedido;

public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {

}
