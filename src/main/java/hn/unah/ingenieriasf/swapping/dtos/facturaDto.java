package hn.unah.ingenieriasf.swapping.dtos;

import java.time.LocalDate;

import lombok.Data;

@Data
public class facturaDto {
    
    private String nombrecomprador;

    private String nombrevendedor;

    private long subtotal;

    private float isv;

    private float totalpagar;
    
    private LocalDate fechaemision;

    private String nombreProducto;
}
