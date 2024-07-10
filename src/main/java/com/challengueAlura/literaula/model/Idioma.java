package com.challengueAlura.literaula.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Idioma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String acronimo;
    @OneToMany(mappedBy = "idioma",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libro;
}
