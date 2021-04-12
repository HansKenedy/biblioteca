package com.biblioteca.biblioteca.application.mainmodule.mapper;

import com.biblioteca.biblioteca.application.mainmodule.dto.BibliotecaDto;
import com.biblioteca.biblioteca.domain.entity.Biblioteca;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
@Mapper(componentModel = "spring")
public interface IBibliotecaMapper {

    @Mappings({
            @Mapping(source = "id", target = "bibliotecaId"),
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "descripcion", target = "descripcion"),
            @Mapping(source = "autor", target = "autor"),
            @Mapping(source = "paginas", target = "paginas"),
            @Mapping(target = "portInUse", ignore = true)
    })
    BibliotecaDto toBibliotecaDto(Biblioteca biblioteca);

    List<BibliotecaDto> toBibliotecasDto(List<Biblioteca> bibliotecas);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "createAt", ignore = true)
    })
    Biblioteca toBiblioteca(BibliotecaDto bibliotecaDto);
}
