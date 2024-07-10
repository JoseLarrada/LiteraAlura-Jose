package com.challengueAlura.literaula.model;

import jakarta.persistence.*;

import java.util.List;



@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    @OneToMany(mappedBy = "libro",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Autor> autor;
    private List<String> idioma;
    private Double numeroDeDescargas;

    public Libro(DatosLibros datosLibros) {
        this.titulo=datosLibros.titulo();
        this.idioma=datosLibros.idioma();
        this.numeroDeDescargas=datosLibros.numeroDeDescargas();

    }

    public Libro() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutor() {
        return autor;
    }

    public void setAutor(List<Autor> autor) {
        this.autor = autor;
    }

    public List<String> getIdioma() {
        return idioma;
    }

    public void setIdioma(List<String> idioma) {
        this.idioma = idioma;
    }

    public Double getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Double numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor=" + autor +
                ", idioma=" + idioma +
                ", numeroDeDescargas=" + numeroDeDescargas +
                '}';
    }
}
