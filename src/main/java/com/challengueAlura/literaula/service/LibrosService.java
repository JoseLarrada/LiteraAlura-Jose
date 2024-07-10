package com.challengueAlura.literaula.service;

import com.challengueAlura.literaula.model.*;
import com.challengueAlura.literaula.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LibrosService {
    private Scanner teclado = new Scanner(System.in);
    private ConsumirApi llamadoApi = new ConsumirApi();
    private final String URL_BASE="https://gutendex.com/books/";
    private ConvierteDatos convierteDatos=new ConvierteDatos();
    private LibroRepository repositorio;
    public LibrosService(LibroRepository repository) {
        this.repositorio=repository;
    }
    public Optional<DatosLibros> buscarLibro(){
        System.out.println("Ingrese el nombre del libro que desea buscar");
        String titulo=teclado.nextLine();
        var json=llamadoApi.obtenerDatos(URL_BASE+"?search="+titulo.replace(" ","+"));
        var datosBusquedas=convierteDatos.ConvertirDatos(json, Datos.class);
        Optional<DatosLibros> libroBuscado=datosBusquedas.resultados().stream()
                .filter(l->l.titulo().toUpperCase().contains(titulo.toUpperCase()))
                .findFirst();
        guardarLibroEnBaseDeDatos(libroBuscado);
        return libroBuscado;
    }

    public void listarLibrosGuardados(){
         repositorio.findAll().forEach(System.out::println);
    }

    private void guardarLibroEnBaseDeDatos(Optional<DatosLibros> libroBuscado){
        if (libroBuscado.isPresent()){
            System.out.println("Libro Encontrado");
            Libro libro= new Libro(libroBuscado.get());
            List<DatosAutor> autores=libroBuscado.get().autor();
            libro.setAutor(autores.stream()
                    .map(autor->new Autor(autor,libro))
                    .collect(Collectors.toList())
            );
            repositorio.save(libro);
        }else{
            System.out.println("Libro no encontrado");
        }
    }
}
