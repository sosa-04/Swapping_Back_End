package hn.unah.ingenieriasf.swapping.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.ingenieriasf.swapping.entities.Colores;
import hn.unah.ingenieriasf.swapping.services.impl.coloresServiceImpl;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api")
public class coloresController {
    
    @Autowired
    coloresServiceImpl ColoresServiceImpl;

    @GetMapping("/colores/obtenerColores")
    public List<Colores> obtenerColores() {
        return this.ColoresServiceImpl.obtenerColores();
    }

}
