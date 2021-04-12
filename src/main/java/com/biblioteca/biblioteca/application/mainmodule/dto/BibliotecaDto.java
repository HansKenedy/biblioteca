package com.biblioteca.biblioteca.application.mainmodule.dto;

import javax.persistence.Column;
import javax.persistence.Transient;

public class BibliotecaDto {
    private Long bibliotecaId;
    private String Nombre;
    private String Descripcion;
    private String Autor;
    private String Paginas;
    private String portInUse;
    @Transient
    private ProductDto productDto;



    public Long getBibliotecaId() {
        return bibliotecaId;
    }

    public void setBibliotecaId(Long bibliotecaId) {
        this.bibliotecaId = bibliotecaId;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public String getPaginas() {
        return Paginas;
    }

    public void setPaginas(String paginas) {
        Paginas = paginas;
    }

    public String getPortInUse() {
        return portInUse;
    }

    public void setPortInUse(String portInUse) {
        this.portInUse = portInUse;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }
}
