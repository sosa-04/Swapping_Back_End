package hn.unah.ingenieriasf.swapping.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "facturas")
public class Facturas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfacturas")
    private long idfacturas;

    @Column(name = "nombrecomprador")
    private String nombrecomprador;

    @Column(name = "nombrevendedor")
    private String nombrevendedor;

    @Column(name = "totalpagar")
    private float totalpagar;

    @Column(name = "fechaemision")
    private LocalDate fechaemision;

    private float isv;

    @Column(name = "subtotal")
    private long subtotal; 

    @OneToOne
    @JoinColumn(name = "idventa", referencedColumnName = "idventa")
    private Ventas venta;
}