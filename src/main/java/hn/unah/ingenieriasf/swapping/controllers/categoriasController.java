package hn.unah.ingenieriasf.swapping.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.ingenieriasf.swapping.entities.Categorias;
import hn.unah.ingenieriasf.swapping.services.impl.categoriasServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(origins = "http://127.0.0.7:5500") // Permitir solicitudes desde Live Server

@RestController
@RequestMapping("/api")
public class categoriasController {
    
    @Autowired
    private categoriasServiceImpl CategoriasServiceImpl;
    
    @GetMapping("/categorias/obtenerCategorias")
    public List<Categorias> obtenerCategorias() {
        return this.CategoriasServiceImpl.obtenerCategorias();
    }

}
