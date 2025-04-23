package hn.unah.ingenieriasf.swapping.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hn.unah.ingenieriasf.swapping.entities.Categorias;
import hn.unah.ingenieriasf.swapping.entities.Productos;
import hn.unah.ingenieriasf.swapping.entities.Usuarios;

public interface productosRepositorie extends CrudRepository<Productos, Long> {
    
    public List<Productos> findByCategoria(Categorias categoria);

    public List<Productos> findByUsuarioAndProductovendido(Usuarios usuario, Integer productoVendido);

    public List<Productos> findByEstado(Integer estado);

}
