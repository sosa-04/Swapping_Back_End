package hn.unah.ingenieriasf.swapping.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "usuarios")
public class Usuarios {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private long idusuario;

    private String email;

    private String telefono;

    private String password;

    private String descripcion;

    @Column( name = "usuarioreportado", columnDefinition = "TINYINT(1)")
    private Integer usuarioreportado;

    @Column(name = "primernombre")
    private String primernombre;

    @Column(name = "segundonombre")
    private String segundonombre;

    @Column(name = "primerapellido")
    private String primerapellido;

    @Column(name = "segundoapellido")
    private String segundoapellido;

    @Column(name = "fotoperfil")
    private String fotoperfil;

    @Column( name = "statususuario", columnDefinition = "TINYINT(1)")
    private Integer statususuario;

    @OneToOne()
    @JoinColumn(name = "idrol", referencedColumnName = "idrol")
    private Roles roles;

    private Float calificacion;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<FotosDNI> fotodni;
}
