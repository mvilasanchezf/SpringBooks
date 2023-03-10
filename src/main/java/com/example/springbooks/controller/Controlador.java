package com.example.springbooks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.springbooks.model.Libros;


import com.example.springbooks.interfaceService.ILibrosService;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.nio.file.Files;

@Controller
@RequestMapping
public class Controlador {
    
    @Autowired
    private ILibrosService service;

    @GetMapping("/listar")
    public String listar(Model model) {
        List<Libros> libros = service.listar();
        model.addAttribute("libros", libros);
        return "index";
    }

    @GetMapping("/new")
    public String agregar(Model model) {
        model.addAttribute("libro", new Libros());
        return "formlibro";
    }
    @PostMapping("/save")
    public String save(@Validated Libros l, Model model, @RequestParam("file") MultipartFile imagen){
        if(!imagen.isEmpty()){
            Path ruta = Paths.get("src//main//resources//static/images");
            String rutaAbsoluta = ruta.toFile().getAbsolutePath();
            try {
                byte[] bytesImg = imagen.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);   
                l.setPortada(imagen.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        service.save(l);
        return "redirect:/listar";
    }
    
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model){
        Optional<Libros> libro = service.listarId(id);
        model.addAttribute("libro", libro);
        return "formlibro";
    }

    @GetMapping("/eliminar/{id}")
    public String delete(Model model, @PathVariable int id){
        service.delete(id);
        return "redirect:/listar";
    }
}
