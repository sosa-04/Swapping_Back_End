package hn.unah.ingenieriasf.swapping.services;

import java.util.List;

import hn.unah.ingenieriasf.swapping.entities.Productos;

public interface productosService {
    
    public List<Productos> productosCategoria(Long idCategoria);

    public Productos productosXid(Long idproducto);
}
