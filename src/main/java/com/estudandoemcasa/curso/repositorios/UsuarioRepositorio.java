package com.estudandoemcasa.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudandoemcasa.curso.entidades.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

}
