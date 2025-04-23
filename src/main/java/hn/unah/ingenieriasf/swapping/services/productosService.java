package hn.unah.ingenieriasf.swapping.services;

import java.util.List;

import hn.unah.ingenieriasf.swapping.dtos.producto;
import hn.unah.ingenieriasf.swapping.entities.Productos;

public interface productosService {
    
    public List<Productos> productosCategoria(Long idCategoria);

    public Productos productosXid(Long idproducto);

    public List<Productos> obtenerProductos();

    public List<Productos> obtenerProductoxVendedor(Long idVendedor);

    public Boolean guardarProducto(producto producto);

    public Boolean actualizarProducto(producto producto);

    public Boolean eliminarProducto(Long idProducto);
}
