package hn.unah.ingenieriasf.swapping.entities;

import java.time.LocalDate;
import java.time.LocalTime;

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
@Table(name = "ventas")
public class Ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idventa")
    private long idventa;

    @Column(name = "totalventa")
    private long totalventa;

    @Column(name = "horaventa")
    private LocalTime horaventa;

    @Column(name = "fechaventa")
    private LocalDate fechaventa;

    @OneToOne
    @JoinColumn(name = "idvendedor", referencedColumnName = "idusuario")
    private Usuarios vendedor;

    @OneToOne
    @JoinColumn(name = "idcomprador", referencedColumnName = "idusuario")
    private Usuarios comprador;

    @OneToOne
    @JoinColumn(name = "idcalificacion", referencedColumnName = "idcalificacion")
    private Calificaciones calificacion;
}
