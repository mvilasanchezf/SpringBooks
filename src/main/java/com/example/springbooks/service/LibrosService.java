package com.example.springbooks.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbooks.interfaces.ILibros;
import com.example.springbooks.model.Libros;
import com.example.springbooks.interfaceService.ILibrosService;

import java.util.List;
import java.util.Optional;

@Service
public class LibrosService  implements ILibrosService{
    
    @Autowired
    private ILibros data;

    @Override
    public List<Libros> listar() {
        return (List<Libros>)data.findAll();
    }

    @Override
    public Optional <Libros> listarId(int id) {
        return null;
    }

    @Override
    public int save(Libros p) {
       
        return 0;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
}
