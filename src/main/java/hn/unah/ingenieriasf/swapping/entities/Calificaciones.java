package hn.unah.ingenieriasf.swapping.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "calificaciones")
public class Calificaciones {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcalificacion")
    private long idcalificacion;

    private long estrellas;

    @Column(name = "fechacalificacion")
    private LocalDate fechacalificacion;
}
