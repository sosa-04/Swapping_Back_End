package hn.unah.ingenieriasf.swapping.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hn.unah.ingenieriasf.swapping.entities.Categorias;
import hn.unah.ingenieriasf.swapping.entities.Productos;

public interface productosRepositorie extends CrudRepository<Productos, Long> {
    
    public List<Productos> findByCategoria(Categorias categoria);
}
