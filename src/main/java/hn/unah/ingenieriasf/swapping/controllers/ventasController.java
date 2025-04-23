package hn.unah.ingenieriasf.swapping.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.ingenieriasf.swapping.dtos.facturaDto;
import hn.unah.ingenieriasf.swapping.dtos.ventasDto;
import hn.unah.ingenieriasf.swapping.entities.Ventas;
import hn.unah.ingenieriasf.swapping.services.impl.ventasServiceImpl;

@CrossOrigin(origins = "*") // Permitir solicitudes desde Live Server

@RestController
@RequestMapping("/api")
public class ventasController {
    
    @Autowired
    private ventasServiceImpl VentasServiceImpl;

    @PostMapping("/ventas/crearVenta")
    public facturaDto crearVenta(@RequestBody ventasDto VentasDTO) {
        return this.VentasServiceImpl.crearVenta(VentasDTO);
    }

    @GetMapping("/ventas/obtenerVentas")
    public List<Ventas> obtenerVentas() {
        return this.VentasServiceImpl.obtenerVentas();
    }
}
