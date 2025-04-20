package hn.unah.ingenieriasf.swapping.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "productos")
public class Productos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproducto")
    private Long idproducto;

    private String nombre;

    private Long precio;

    private String descripcion;

    @Column(columnDefinition = "TINYINT(1)" )
    private Integer estado;

    private Long stock;

    @Column(name = "productovendido", columnDefinition = "TINYINT(1)" )
    private Integer productovendido;

    @OneToOne
    @JoinColumn(name = "idalmacenamiento", referencedColumnName = "idalmacenamiento" )
    private Almacenamientos almacenamiento;

    @ManyToOne
    @JoinColumn(name = "idcolor", referencedColumnName = "idcolor")
    private Colores color;

    @OneToOne
    @JoinColumn(name = "idmodelo", referencedColumnName = "idmodelo")
    private Modelos modelo;

    @ManyToOne
    @JoinColumn(name = "idmarca", referencedColumnName = "idmarca")
    private Marcas marca;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idcategoria", referencedColumnName = "idcategoria")
    private Categorias categoria;


    
    @ManyToOne
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    private Usuarios usuario;

    @OneToMany(mappedBy = "producto")
    private List<Fotos_Productos> fotos;


}
