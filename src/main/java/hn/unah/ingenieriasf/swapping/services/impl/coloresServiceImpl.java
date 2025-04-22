package hn.unah.ingenieriasf.swapping.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.ingenieriasf.swapping.entities.Colores;
import hn.unah.ingenieriasf.swapping.repositories.colorersRepositorie;
import hn.unah.ingenieriasf.swapping.services.coloresService;

@Service
public class coloresServiceImpl implements coloresService {

    @Autowired
    private colorersRepositorie ColoresRepositorie;

    @Override
    public List<Colores> obtenerColores() {
        return (List<Colores>) this.ColoresRepositorie.findAll();
    }
    
}
