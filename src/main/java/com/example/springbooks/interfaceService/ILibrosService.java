package com.example.springbooks.interfaceService;

import java.util.List;
import java.util.Optional;

import com.example.springbooks.model.Libros;

public interface ILibrosService {
    
    public List<Libros> listar();
    public Optional<Libros> listarId(int id);
    public int save(Libros p);
    public void delete(int id);
}
