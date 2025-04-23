package hn.unah.ingenieriasf.swapping.services;

import hn.unah.ingenieriasf.swapping.dtos.facturaDto;
import hn.unah.ingenieriasf.swapping.dtos.ventasDto;

public interface ventasService {
    
    public facturaDto crearVenta(ventasDto VentasDTO);
}
