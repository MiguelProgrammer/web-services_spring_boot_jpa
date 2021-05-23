package com.estudandoemcasa.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudandoemcasa.curso.entidades.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {

}
