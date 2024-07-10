package com.challengueAlura.literaula.repository;

import com.challengueAlura.literaula.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro,Long> {
}
