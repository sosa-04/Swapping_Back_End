package hn.unah.ingenieriasf.swapping.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.ingenieriasf.swapping.entities.Almacenamientos;
import hn.unah.ingenieriasf.swapping.repositories.almacenamientosRepositorie;
import hn.unah.ingenieriasf.swapping.services.almacenamientosService;

@Service
public class almacenamientosServiceImpl implements almacenamientosService {

    @Autowired
    private almacenamientosRepositorie AlmacenamientosRepositorie;

    @Override
    public List<Almacenamientos> obtenerAlmacenamientos() {
        return (List<Almacenamientos>) this.AlmacenamientosRepositorie.findAll();
    }
    
}
