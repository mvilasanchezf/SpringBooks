package com.example.springbooks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springbooks.model.Libros;
import com.example.springbooks.interfaceService.ILibrosService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        return "form";
    }
    
}