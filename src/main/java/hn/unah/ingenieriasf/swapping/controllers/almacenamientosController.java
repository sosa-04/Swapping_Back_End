package hn.unah.ingenieriasf.swapping.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.ingenieriasf.swapping.entities.Almacenamientos;
import hn.unah.ingenieriasf.swapping.services.impl.almacenamientosServiceImpl;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api")
public class almacenamientosController {

    @Autowired
    private almacenamientosServiceImpl AlmacenamientosServiceImpl;

    @GetMapping("/almacenamientos/obtenerAlmacenamientos")
    public List<Almacenamientos> obtenerAlmacenamientos() {
        return this.AlmacenamientosServiceImpl.obtenerAlmacenamientos();
    }
    
}
