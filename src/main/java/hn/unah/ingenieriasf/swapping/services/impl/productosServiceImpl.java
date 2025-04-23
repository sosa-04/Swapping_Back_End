package hn.unah.ingenieriasf.swapping.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.ingenieriasf.swapping.dtos.producto;
import hn.unah.ingenieriasf.swapping.entities.Almacenamientos;
import hn.unah.ingenieriasf.swapping.entities.Categorias;
import hn.unah.ingenieriasf.swapping.entities.Colores;
import hn.unah.ingenieriasf.swapping.entities.Fotos_Productos;
import hn.unah.ingenieriasf.swapping.entities.Marcas;
import hn.unah.ingenieriasf.swapping.entities.Productos;
import hn.unah.ingenieriasf.swapping.entities.Usuarios;
import hn.unah.ingenieriasf.swapping.repositories.almacenamientosRepositorie;
import hn.unah.ingenieriasf.swapping.repositories.categoriasRepositorie;
import hn.unah.ingenieriasf.swapping.repositories.colorersRepositorie;
import hn.unah.ingenieriasf.swapping.repositories.marcasRepositorie;
import hn.unah.ingenieriasf.swapping.repositories.productosRepositorie;
import hn.unah.ingenieriasf.swapping.repositories.usuariosRepositorie;
import hn.unah.ingenieriasf.swapping.services.productosService;

@Service
public class productosServiceImpl implements productosService {

    @Autowired
    private categoriasRepositorie CategoriasRepositorie;

    @Autowired
    private productosRepositorie ProductosRepositorie;

    @Autowired
    private usuariosRepositorie UsuariosRepositorie;

    @Autowired
    private marcasRepositorie MarcasRepositorie;

    @Autowired
    private colorersRepositorie ColorersRepositorie;

    @Autowired
    private almacenamientosRepositorie AlmacenamientosRepositorie;

    @Override
    public List<Productos> productosCategoria(Long idCategoria) {

        Categorias categoria = CategoriasRepositorie.findById(idCategoria).get();
        return this.ProductosRepositorie.findByCategoria(categoria);
    }

    @Override
    public Productos productosXid(Long idproducto) {
        return this.ProductosRepositorie.findById(idproducto).get();
    }

    @Override
    public List<Productos> obtenerProductos() {
        return (List<Productos>) this.ProductosRepositorie.findByEstado(1);
    }

    @Override
    public List<Productos> obtenerProductoxVendedor(Long idVendedor) {
        
        try {
            Usuarios vendedor = UsuariosRepositorie.findById(idVendedor).get();
            return this.ProductosRepositorie.findByUsuario(vendedor);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Boolean guardarProducto(producto productoDTO) {
        
        try {
            Usuarios usuario = this.UsuariosRepositorie.findById(productoDTO.getIdUsuario()).get();
            Categorias categoria = this.CategoriasRepositorie.findById(productoDTO.getIdCategoria()).get();
            Marcas marca = this.MarcasRepositorie.findById(productoDTO.getIdMarca()).get();
            Colores color = this.ColorersRepositorie.findById(productoDTO.getIdColor()).get();
            Almacenamientos almacenamiento = this.AlmacenamientosRepositorie.findById(productoDTO.getIdAlmacenamiento()).get();

            String nombre = marca.getNombre() + " " + productoDTO.getModelo().getNombre();

            Productos producto = new Productos();
            producto.setNombre(nombre);
            producto.setPrecio(productoDTO.getPrecio());
            producto.setDescripcion(productoDTO.getDescripcion());
            producto.setStock(productoDTO.getStock());
            producto.setUsuario(usuario);
            producto.setCategoria(categoria);
            producto.setMarca(marca);
            producto.setColor(color);
            producto.setAlmacenamiento(almacenamiento);
            producto.setEstado(1);
            producto.setProductovendido(0);
            producto.setModelo(productoDTO.getModelo());
            
            // agregamo el producto a la lista de fotos para poder utilizar el cascade
            if (productoDTO.getFotos() != null && !productoDTO.getFotos().isEmpty()) {
                List<Fotos_Productos> listaFotos = new ArrayList<>();
                for (Fotos_Productos foto : productoDTO.getFotos()) {
                    foto.setProducto(producto); // Relación inversa
                    listaFotos.add(foto);
                }
                producto.setFotos(listaFotos);
            }

            this.ProductosRepositorie.save(producto);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    
}
