package com.biblioteca.biblioteca.infrastructure.crud;

import com.biblioteca.biblioteca.domain.entity.Biblioteca;
import org.springframework.data.repository.CrudRepository;

public interface IBibliotecaCrudRepository extends CrudRepository<Biblioteca, Long> {
}
