package hn.unah.ingenieriasf.swapping.dtos;

import java.util.List;

import hn.unah.ingenieriasf.swapping.entities.Fotos_Productos;
import hn.unah.ingenieriasf.swapping.entities.Modelos;
import lombok.Data;

@Data
public class producto {
    
    private Long precio;

    private String descripcion;

    private Long stock;

    private Long idAlmacenamiento;

    private Long idColor;

    private Modelos modelo;

    private Long idMarca;

    private Long idCategoria;

    private Long idUsuario;

    private List<Fotos_Productos> fotos;
}
