package hn.unah.ingenieriasf.swapping.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.ingenieriasf.swapping.entities.Productos;
import hn.unah.ingenieriasf.swapping.services.impl.productosServiceImpl;

@RestController
@RequestMapping("/api")
public class productosController {
    
    @Autowired
    private productosServiceImpl ProductosServiceImpl;

    @GetMapping("/productos/productosCategoria")
    public List<Productos> productosxCategoria(@RequestParam Long idCategoria) {
        return this.ProductosServiceImpl.productosCategoria(idCategoria);
    }
}
