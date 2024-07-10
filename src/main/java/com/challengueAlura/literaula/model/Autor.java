package com.challengueAlura.literaula.model;

import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Long AñoNacimiento;
    private Long AñoFallecimiento;
    @ManyToOne
    private Libro libro;

    public Autor(DatosAutor autor,Libro libro) {
        this.nombre=autor.nombre();
        this.AñoNacimiento=autor.nacimiento();
        this.AñoFallecimiento= autor.fallecimiento();
        this.libro=libro;
    }

    public Autor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getAñoNacimiento() {
        return AñoNacimiento;
    }

    public void setAñoNacimiento(Long añoNacimiento) {
        this.AñoNacimiento = añoNacimiento;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Long getAñoFallecimiento() {
        return AñoFallecimiento;
    }

    public void setAñoFallecimiento(Long añoFallecimiento) {
        AñoFallecimiento = añoFallecimiento;
    }

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ", AñoNacimiento=" + AñoNacimiento +
                ", AñoFallecimiento=" + AñoFallecimiento;
    }
}
