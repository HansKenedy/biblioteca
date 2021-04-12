package com.biblioteca.biblioteca.domain.repository;

import com.biblioteca.biblioteca.application.mainmodule.dto.BibliotecaDto;

import java.util.List;
import java.util.Optional;

public interface IBibliotecaRepository {
    List<BibliotecaDto> getAll();
    Optional<BibliotecaDto> getBiblioteca(long bibliotecaId);
}
