package hn.unah.ingenieriasf.swapping.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.ingenieriasf.swapping.dtos.facturaDto;
import hn.unah.ingenieriasf.swapping.dtos.ventasDto;
import hn.unah.ingenieriasf.swapping.services.impl.ventasServiceImpl;

@CrossOrigin(origins = "*") // Permitir solicitudes desde Live Server

@RestController
@RequestMapping("/api")
public class ventasController {
    
    @Autowired
    private ventasServiceImpl VentasServiceImpl;

    @PostMapping("/ventas/crearVenta")
    public facturaDto crearVenta(ventasDto VentasDTO) {
        return this.VentasServiceImpl.crearVenta(VentasDTO);
    }
}
