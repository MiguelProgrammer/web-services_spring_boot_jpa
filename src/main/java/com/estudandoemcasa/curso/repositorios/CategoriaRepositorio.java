package com.estudandoemcasa.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudandoemcasa.curso.entidades.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {

}
