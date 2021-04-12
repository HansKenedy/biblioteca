package com.biblioteca.biblioteca.presentation.web.controller;

import com.biblioteca.biblioteca.application.mainmodule.dto.BibliotecaDto;
import com.biblioteca.biblioteca.application.mainmodule.dto.ProductDto;
import com.biblioteca.biblioteca.application.mainmodule.service.IBibliotecaService;
import com.biblioteca.biblioteca.presentation.web.client.IProductController;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bibliotecas")
public class BibliotecaController {

    @Autowired
    private Environment environment;

    @Autowired
    private IBibliotecaService bibliotecaService;

    @Autowired
    private IProductController productController;

    @GetMapping("/getAll")
    @ApiOperation("Get all libros.")
    @ApiResponse(code = 200, message = "SUCCESS")
    public List<BibliotecaDto> getAll(){
        return bibliotecaService.getAll().stream().map(
                p -> {
                    p.setPortInUse(environment.getProperty("local.server.port"));
                    return p;
                }).collect(Collectors.toList());
    }

    @GetMapping("/getBiblioteca/{bibliotecaId}")
    @ApiOperation("Get libro by ID.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "SUCCESS"),
            @ApiResponse(code = 404, message = "LIBRO NOT FOUND")
    })
    public BibliotecaDto getBiblioteca(@ApiParam(value = "This ID of the libro.", example = "5", required = true)
                                     @PathVariable("bibliotecaId") long bibliotecaId){

        BibliotecaDto bibliotecaDto = bibliotecaService.getBiblioteca(bibliotecaId).get();
        bibliotecaDto.setPortInUse(environment.getProperty("local.server.port"));
        ProductDto productDto = productController.getProduct(bibliotecaId);
        bibliotecaDto.setProductDto(productDto);
        return bibliotecaDto;
    }
}
