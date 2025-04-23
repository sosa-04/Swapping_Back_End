package hn.unah.ingenieriasf.swapping.services;

import java.util.List;

import hn.unah.ingenieriasf.swapping.dtos.facturaDto;
import hn.unah.ingenieriasf.swapping.dtos.ventasDto;
import hn.unah.ingenieriasf.swapping.entities.Ventas;

public interface ventasService {
    
    public facturaDto crearVenta(ventasDto VentasDTO);

    public List<Ventas> obtenerVentas();
}
