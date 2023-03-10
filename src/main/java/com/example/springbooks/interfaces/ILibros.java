package com.example.springbooks.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.example.springbooks.model.Libros;

public interface ILibros extends CrudRepository<Libros, Integer>{
    
}
