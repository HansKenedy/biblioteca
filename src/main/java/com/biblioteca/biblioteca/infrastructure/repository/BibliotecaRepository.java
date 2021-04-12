package com.biblioteca.biblioteca.infrastructure.repository;

import com.biblioteca.biblioteca.application.mainmodule.dto.BibliotecaDto;
import com.biblioteca.biblioteca.application.mainmodule.mapper.IBibliotecaMapper;
import com.biblioteca.biblioteca.domain.entity.Biblioteca;
import com.biblioteca.biblioteca.domain.repository.IBibliotecaRepository;
import com.biblioteca.biblioteca.infrastructure.crud.IBibliotecaCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class BibliotecaRepository implements IBibliotecaRepository {
    @Autowired
    private IBibliotecaCrudRepository bibliotecaCrudRepository;

    @Autowired
    private IBibliotecaMapper bibliotecaMapper;

    public List<BibliotecaDto> getAll(){
        List<Biblioteca> bibliotecas = (List<Biblioteca>)bibliotecaCrudRepository.findAll();
        return bibliotecaMapper.toBibliotecasDto(bibliotecas);
    }

    public Optional<BibliotecaDto> getBiblioteca(long id){
        return bibliotecaCrudRepository.findById(id).map(e -> bibliotecaMapper.toBibliotecaDto(e));
    }
}
