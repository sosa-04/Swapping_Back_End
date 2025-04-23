package hn.unah.ingenieriasf.swapping.services.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.ingenieriasf.swapping.dtos.facturaDto;
import hn.unah.ingenieriasf.swapping.dtos.ventasDto;
import hn.unah.ingenieriasf.swapping.entities.Detalle_Ventas;
import hn.unah.ingenieriasf.swapping.entities.Facturas;
import hn.unah.ingenieriasf.swapping.entities.Productos;
import hn.unah.ingenieriasf.swapping.entities.Usuarios;
import hn.unah.ingenieriasf.swapping.entities.Ventas;
import hn.unah.ingenieriasf.swapping.repositories.detalleVentasRepositorie;
import hn.unah.ingenieriasf.swapping.repositories.facturasRepositorie;
import hn.unah.ingenieriasf.swapping.repositories.productosRepositorie;
import hn.unah.ingenieriasf.swapping.repositories.usuariosRepositorie;
import hn.unah.ingenieriasf.swapping.repositories.ventasRepositorie;
import hn.unah.ingenieriasf.swapping.services.ventasService;

@Service
public class ventasServiceImpl implements ventasService {

    @Autowired
    private usuariosRepositorie UsuariosRepositorie;

    @Autowired
    private ventasRepositorie VentasRepositorie;

    @Autowired
    private detalleVentasRepositorie DetalleVentasRepositorie;

    @Autowired
    private facturasRepositorie FacturasRepositorie;

    @Autowired
    private productosRepositorie ProductosRepositorie;

    @Override
    public facturaDto crearVenta(ventasDto VentasDTO) {
        
        Usuarios vendedor = this.UsuariosRepositorie.findById(VentasDTO.getIdVendedor()).get();
        Usuarios comprador = this.UsuariosRepositorie.findById(VentasDTO.getIdComprador()).get();
        Productos producto = this.ProductosRepositorie.findById(VentasDTO.getIdProducto()).get();

        // Creamos la venta
        Ventas venta = new Ventas();
        venta.setVendedor(vendedor);
        venta.setComprador(comprador);
        venta.setFechaventa(LocalDate.now());
        venta.setHoraventa(LocalTime.now());
        venta.setTotalventa(producto.getPrecio());

        // Guardamos la venta en la base de datos
        Ventas ventaGuardada = this.VentasRepositorie.save(venta);

        // creamos el detalle de la venta
        Detalle_Ventas detalle = new Detalle_Ventas();
        detalle.setVenta(ventaGuardada);
        detalle.setProducto(producto);
        detalle.setPrecio(producto.getPrecio());

        // Guardamos el detalle de la venta en la base de datos
        this.DetalleVentasRepositorie.save(detalle);

        // Creamos la factura
        Facturas factura = new Facturas();

        String nombreComprador = comprador.getPrimernombre() + " " + comprador.getPrimerapellido();
        String nombreVendedor = vendedor.getPrimernombre() + " " + vendedor.getPrimerapellido();

        factura.setVenta(ventaGuardada);
        factura.setNombrecomprador(nombreComprador);
        factura.setNombrevendedor(nombreVendedor);
        factura.setFechaemision(LocalDate.now());

        long subtotal = producto.getPrecio();
        float isv = subtotal * 0.15f;
        float totalPagar = subtotal + isv;

        factura.setSubtotal(subtotal);
        factura.setIsv(isv);
        factura.setTotalpagar(totalPagar);

        // Guardamos la factura en la base de datos
        this.FacturasRepositorie.save(factura);

        // Actualizamos el stock del producto y si el stock es igual a cero cambiamos el estado a 0
        long nuevoStock = producto.getStock() - 1;
        producto.setStock(nuevoStock);

        if (nuevoStock == 0) {
            producto.setEstado(0);
        }
        this.ProductosRepositorie.save(producto);

        // Retornamos el DTO de la factura
        facturaDto facturaDTO = new facturaDto();
        facturaDTO.setNombrecomprador(nombreComprador);
        facturaDTO.setNombrevendedor(nombreVendedor);
        facturaDTO.setSubtotal(factura.getSubtotal());
        facturaDTO.setIsv(factura.getIsv());
        facturaDTO.setTotalpagar(factura.getTotalpagar());
        facturaDTO.setFechaemision(factura.getFechaemision());
        facturaDTO.setNombreProducto(producto.getNombre());

        return facturaDTO;
    }

    @Override
    public List<Ventas> obtenerVentas() {
        return (List<Ventas>) this.VentasRepositorie.findAll();
    }
    
}
