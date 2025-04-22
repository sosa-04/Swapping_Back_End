package hn.unah.ingenieriasf.swapping.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.ingenieriasf.swapping.entities.Marcas;
import hn.unah.ingenieriasf.swapping.repositories.marcasRepositorie;
import hn.unah.ingenieriasf.swapping.services.marcasService;

@Service
public class marcasServiceImpl implements marcasService {

    @Autowired
    private marcasRepositorie MarcasRepositorie;

    @Override
    public List<Marcas> obtenerMarcas() {
        return (List<Marcas>) this.MarcasRepositorie.findAll();
    }
    
}
