package com.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modelo.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

}
