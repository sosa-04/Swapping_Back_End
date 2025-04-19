package hn.unah.ingenieriasf.swapping.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.ingenieriasf.swapping.entities.Categorias;
import hn.unah.ingenieriasf.swapping.entities.Productos;
import hn.unah.ingenieriasf.swapping.repositories.categoriasRepositorie;
import hn.unah.ingenieriasf.swapping.repositories.productosRepositorie;
import hn.unah.ingenieriasf.swapping.services.productosService;

@Service
public class productosServiceImpl implements productosService {

    @Autowired
    private categoriasRepositorie CategoriasRepositorie;

    @Autowired
    private productosRepositorie ProductosRepositorie;

    @Override
    public List<Productos> productosCategoria(Long idCategoria) {

        Categorias categoria = CategoriasRepositorie.findById(idCategoria).get();
        return this.ProductosRepositorie.findByCategoria(categoria);
    }

    @Override
    public Productos productosXid(Long idproducto) {
        return this.ProductosRepositorie.findById(idproducto).get();
    }
}
