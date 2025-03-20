package hn.unah.ingenieriasf.swapping.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "almacenamientos")
public class Almacenamientos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idalmacenamiento")
    private long idalmacenamiento;

    private String tamanioalmacenamiento;
}
