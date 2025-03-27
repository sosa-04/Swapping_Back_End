package hn.unah.ingenieriasf.swapping.repositories;

import org.springframework.data.repository.CrudRepository;

import hn.unah.ingenieriasf.swapping.entities.Facturas;

public interface facturasRepositorie extends CrudRepository<Facturas, Long> {
    
}
