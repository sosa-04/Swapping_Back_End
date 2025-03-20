package hn.unah.ingenieriasf.swapping.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.ingenieriasf.swapping.entities.Categorias;
import hn.unah.ingenieriasf.swapping.repositories.categoriasRepositorie;
import hn.unah.ingenieriasf.swapping.services.categoriasService;

@Service
public class categoriasServiceImpl implements categoriasService {

    @Autowired
    private categoriasRepositorie CategoriasRepositorie;

    @Override
    public List<Categorias> obtenerCategorias(){
        return (List<Categorias>) this.CategoriasRepositorie.findAll();
    }
    
}
