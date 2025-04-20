package hn.unah.ingenieriasf.swapping.services;

import hn.unah.ingenieriasf.swapping.dtos.Login;
import hn.unah.ingenieriasf.swapping.entities.Usuarios;

public interface usuariosService {
    
    public Boolean crearUsuario( Usuarios usuario );

    public Usuarios iniciarSecion( Login login );

    public Usuarios obtenerUsuario( Long idusuario );

}
