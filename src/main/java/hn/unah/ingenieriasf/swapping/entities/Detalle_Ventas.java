package hn.unah.ingenieriasf.swapping.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "detalles_ventas")
public class Detalle_Ventas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddetallesventa")
    private long iddetallesventa;

    private long precio;

    @ManyToOne
    @JoinColumn(name = "idventa", referencedColumnName = "idventa")
    private Ventas venta;

    @OneToOne
    @JoinColumn(name = "idproducto", referencedColumnName = "idproducto")
    private Productos producto;
}
