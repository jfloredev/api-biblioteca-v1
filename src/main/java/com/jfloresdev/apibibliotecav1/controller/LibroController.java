package com.jfloresdev.apibibliotecav1.controller;


import com.jfloresdev.apibibliotecav1.entity.LibroEntity;
import com.jfloresdev.apibibliotecav1.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/libros")
public class LibroController {

    //autorried es inyeccion de dependencias de spring
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

       // return this.libroRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        return this.libroRepository.findByName("%");

    }


    /*
    //Requesstt Parame
    @GetMapping("/by-titulo")
     public List<LibroEntity> getByTitulo(@RequestParam String titulo){
      return this.libroRepository.findByName(titulo);
    }*/

    @GetMapping("/by-titulo")
    public List<LibroEntity> findByTitulo(@RequestParam String titulo) {
        return this.libroRepository.findByName("%" + titulo + "%");
    }



    @PostMapping
    public LibroEntity save(@RequestBody LibroEntity libro){
        libro.setEstado("1");
        return this.libroRepository.save(libro);
    }

    //UPDATE

    @PutMapping("/{id}") //FULL UPDATE
    public LibroEntity update(@PathVariable Long id, @RequestBody LibroEntity libroEntity){

       // LibroEntity oLibroEntity =   libroRepository.findById(id).orElseThrow(()-> new RuntimeException("Libro no encontrado = "+id));
        Optional<LibroEntity> optLibroEntity = libroRepository.findById(id);
        if (optLibroEntity.isPresent()) {
            LibroEntity oLibroEntity = optLibroEntity.get();
            oLibroEntity.setTitulo(libroEntity.getTitulo());
            oLibroEntity.setResumen(libroEntity.getResumen());
            oLibroEntity.setNroPaginas(libroEntity.getNroPaginas());

            return libroRepository.save(oLibroEntity);
        } else {
            // Si no existe, guarda la nueva entidad con el ID proporcionado
            libroEntity.setId(id);
            return libroRepository.save(libroEntity);
        }

    }

    @PatchMapping("/{id}") //Parcial update
    public Object updateParcial(@PathVariable Long id, @RequestBody LibroEntity libroEntity) {


        Optional<LibroEntity> optLibroEntity = libroRepository.findById(id);

        if(optLibroEntity.isEmpty()){
            return new HashMap<String, String>(){{
                put("message", "Libro no encontrado");
            }};
        }

        LibroEntity oLibroEntity = optLibroEntity.get();

        // Actualiza solo los campos proporcionados en libroEntity
        if (libroEntity.getResumen() != null) {
            oLibroEntity.setResumen(libroEntity.getResumen());
        }
        if (libroEntity.getNroPaginas() != null) {
            oLibroEntity.setNroPaginas(libroEntity.getNroPaginas());
        }
        if (libroEntity.getTitulo() != null) {
            oLibroEntity.setTitulo(libroEntity.getTitulo());
        }

        return this.libroRepository.save(oLibroEntity);

    }

    @DeleteMapping("/{id}")
    public Object delete(@PathVariable Long id){
       // this.libroRepository.deleteById(id);//Delete fisico
        Optional<LibroEntity> optLibroEntity = libroRepository.findById(id);

        if(optLibroEntity.isEmpty()){
            return new HashMap<String, String>(){{
                put("message", "Libro no encontrado");
            }};
        }

        /*
        LibroEntity oLibroEntity = optLibroEntity.get();
        oLibroEntity.setId(id);
        oLibroEntity.setEstado("0");
        return this.libroRepository.save(oLibroEntity);*/

        libroRepository.udpateEstadoById(id);
        return new HashMap<String, String>(){{
            put("message", "Libro eliminado");
        }};
    }

}

/*
no debe haber datos
 en la capa controller
 */