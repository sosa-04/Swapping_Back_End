package hn.unah.ingenieriasf.swapping.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.ingenieriasf.swapping.dtos.producto;
import hn.unah.ingenieriasf.swapping.entities.Productos;
import hn.unah.ingenieriasf.swapping.services.impl.productosServiceImpl;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api")
public class productosController {
    
    @Autowired
    private productosServiceImpl ProductosServiceImpl;

    @GetMapping("/productos/productosCategoria")
    public List<Productos> productosxCategoria(@RequestParam Long idCategoria) {
        return this.ProductosServiceImpl.productosCategoria(idCategoria);
    }

    @GetMapping("/productos/productosXid")
    public Productos productosXid(@RequestParam Long idproducto) {
        return this.ProductosServiceImpl.productosXid(idproducto);
    }

    @GetMapping("/productos/obtenerProductos")
    public List<Productos> obtenerProductos() {
        return this.ProductosServiceImpl.obtenerProductos();
    }

    @GetMapping("/productos/productosXvendedor")
    public List<Productos> obtenerProductosxVendedor(@RequestParam Long idVendedor) {
        return this.ProductosServiceImpl.obtenerProductoxVendedor(idVendedor);
    }

    @PostMapping("/productos/guardarProducto")
    public Boolean guardarProducto(@RequestBody producto producto) {
        return this.ProductosServiceImpl.guardarProducto(producto);
    }

    @PutMapping("/productos/actualizarProducto")
    public Boolean actualizarProducto(@RequestBody producto producto) {
        return this.ProductosServiceImpl.actualizarProducto(producto);
    }

    @GetMapping("/productos/eliminarProducto")
    public Boolean eliminarProducto(@RequestParam Long idProducto) {
        return this.ProductosServiceImpl.eliminarProducto(idProducto);
    }
}
