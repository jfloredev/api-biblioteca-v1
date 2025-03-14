package com.jfloresdev.apibibliotecav1.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "LIBRO") //BD
@Entity(name = "LibroEntity") //Java
public class LibroEntity {

    @Id
    @Column(name = "ID", nullable = false, length = 4)
    private Long id;
    @Column(name = "TITULO", nullable = false, length = 120)
    private String titulo;
    @Column(name = "RESUMEN", nullable = false, length = 4000)
    private String resumen;
    @Column(name = "NRO_PAGINAS", nullable = false, length = 3)
    private Integer nroPaginas;

    @Column(name = "ESTADO", nullable = false , length = 1)
    private String estado;



    public LibroEntity() {
    }

    public LibroEntity(long id, String titulo, String resumen, Integer nroPaginas) {
        this.id = id;
        this.titulo = titulo;
        this.resumen = resumen;
        this.nroPaginas = nroPaginas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public Integer getNroPaginas() {
        return nroPaginas;
    }

    public void setNroPaginas(Integer nroPaginas) {
        this.nroPaginas = nroPaginas;
    }

    public String getEstado() {
        return estado;
    }

    public  void setEstado(String estado) {
        this.estado = estado;
    }
}

