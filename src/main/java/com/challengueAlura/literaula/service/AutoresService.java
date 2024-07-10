package com.challengueAlura.literaula.service;

import com.challengueAlura.literaula.model.*;
import com.challengueAlura.literaula.repository.AutorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AutoresService {
    private AutorRepository autorRepository;
    private ConsumirApi llamadoApi = new ConsumirApi();
    private final String URL_BASE="https://gutendex.com/books/";
    private ConvierteDatos convierteDatos=new ConvierteDatos();

    public AutoresService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public void listarAutoresGuardado(){
        System.out.println("Autores Guardado en base de datos");
        autorRepository.findAll().forEach(System.out::println);
    }
    public void buscarAutoresVivos(int año){
        var json=llamadoApi.obtenerDatos(URL_BASE);
        var datosBusquedas=convierteDatos.ConvertirDatos(json, Datos.class);
        List<DatosAutor> lista = datosBusquedas.resultados().stream()
                .flatMap(libro -> libro.autor().stream()) // Obtener un stream plano de autores
                .filter(autor -> autor.fallecimiento() > año) // Filtrar autores que fallecieron después del año especificado
                .map(autor -> new DatosAutor(autor.nombre(), autor.nacimiento(), autor.fallecimiento())) // Mapear a DatosAutor
                .collect(Collectors.toList()); // Recolectar en una lista

        lista.forEach(autor -> System.out.println("Nombre: " + autor.nombre() + ", Nacimiento: " + autor.nacimiento()));
    }
}
