package hn.unah.ingenieriasf.swapping.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "fotos_productos")
public class Fotos_Productos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfotosproducto")
    private long idfotosproducto;

    private String url;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idproducto", referencedColumnName = "idproducto")
    private Productos producto;
}
