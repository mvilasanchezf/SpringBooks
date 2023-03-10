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
        return data.findById(id);
    }

    @Override
    public int save(Libros l) {
       int res = 0;
         Libros libro = data.save(l);
            if(!libro.equals(null)) {
                res = 1;
            }
        return res;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
}
