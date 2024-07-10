package com.challengueAlura.literaula.principal;

import com.challengueAlura.literaula.repository.AutorRepository;
import com.challengueAlura.literaula.repository.LibroRepository;
import com.challengueAlura.literaula.service.AutoresService;
import com.challengueAlura.literaula.service.LibrosService;

import java.util.Scanner;

public class Principal {
    private LibroRepository repositorio;
    private AutorRepository autorRepository;
    private Scanner teclado = new Scanner(System.in);

    public Principal(LibroRepository repositorio,AutorRepository autorRepository) {
        this.repositorio = repositorio;
        this.autorRepository=autorRepository;
    }
    public void principal(){
        LibrosService librosService=new LibrosService(repositorio);
        AutoresService autoresService=new AutoresService(autorRepository);
        menu(librosService,autoresService);
    }

    public void menu(LibrosService librosService,AutoresService autoresService){
        boolean salir=false;
        String menu= """
        ------------ Biblioteca LiterAlura ------------
        1. Buscar libro por titulo
        2. Listar libros registrados
        3. Listar Autores Registrados
        4. Listar autores vivos en un determinado año
        5. Listar libros por idioma
        6. Salir
        """;
        while (salir==false){
            System.out.println(menu);
            int opcion= teclado.nextInt();
            switch (opcion){
                case 1:
                    librosService.buscarLibro();
                    break;
                case 2:
                    librosService.listarLibrosGuardados();
                    break;
                case 3:
                    autoresService.listarAutoresGuardado();
                    break;
                case 4:
                    System.out.println("Ingrese el año en el cual dese saber que autores estaban vivos");
                    int año=teclado.nextInt();
                    autoresService.buscarAutoresVivos(año);
                    break;
                case 6:
                    System.out.println("Gracias por usar nuestro sistema");
                    salir=true;
                    break;
                default:
                    System.out.println("Seleccione una opcion Valida");
            }
        }
    }


}
