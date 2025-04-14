package hn.unah.ingenieriasf.swapping.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hn.unah.ingenieriasf.swapping.entities.Usuarios;

public interface usuariosRepositorie extends CrudRepository<Usuarios, Long> {
    
    public List<Usuarios> findByEmail(String email);
    
}
