package com.challengueAlura.literaula.repository;

import com.challengueAlura.literaula.model.Autor;
import com.challengueAlura.literaula.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro,Long> {
}
