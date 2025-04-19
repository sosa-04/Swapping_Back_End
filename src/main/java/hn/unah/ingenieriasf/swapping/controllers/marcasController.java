package hn.unah.ingenieriasf.swapping.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.ingenieriasf.swapping.entities.Marcas;
import hn.unah.ingenieriasf.swapping.services.impl.marcasServiceImpl;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api")
public class marcasController {
    
    @Autowired
    marcasServiceImpl MarcasServiceImpl;

    @GetMapping("/marcas/obtenerMarcas")
    public List<Marcas> obtenerMarcas() {
        return this.MarcasServiceImpl.obtenerMarcas();
    }
}
