package com.biblioteca.biblioteca.domain.service;

import com.biblioteca.biblioteca.application.mainmodule.dto.BibliotecaDto;
import com.biblioteca.biblioteca.application.mainmodule.service.IBibliotecaService;
import com.biblioteca.biblioteca.domain.repository.IBibliotecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BibliotecaService implements IBibliotecaService {
    @Autowired
    private IBibliotecaRepository bibliotecaRepository;

    public List<BibliotecaDto> getAll() {
        return bibliotecaRepository.getAll();
    }

    public Optional<BibliotecaDto> getBiblioteca(long bibliotecaId) {
        return bibliotecaRepository.getBiblioteca(bibliotecaId);
    }

}
