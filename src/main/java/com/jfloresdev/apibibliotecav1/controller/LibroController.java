package com.jfloresdev.apibibliotecav1.controller;


import com.jfloresdev.apibibliotecav1.entity.LibroEntity;
import com.jfloresdev.apibibliotecav1.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private  LibroRepository libroRepository;

    @GetMapping("/{id}")
    public LibroEntity getOne(@PathVariable Long id){
        /*
       return new LibroEntity(
               1L,
               "El señor de los anillos",
               "Un libro de aventuras",
               1000
       );*/
        return this.libroRepository.findById(id).orElse(null);
    }

    @GetMapping("/all")
    public List<LibroEntity> getAll(){
        /*
        List<LibroEntity> libros = new ArrayList<>();
        libros.add(new LibroEntity(
                1L,
                "El señor de los anillos",
                "Un libro de aventuras",
                1000
        ));
        libros.add(new LibroEntity(
                2L,
                "El principito",
                "Un libro de aventuras",
                100
        ));*/

        return this.libroRepository.findAll();
    }

    @PostMapping
    public LibroEntity save(@RequestBody LibroEntity libro){
        return this.libroRepository.save(libro);
    }

}

/*
no debe haber datos
 en la capa controller
 */