package hn.unah.ingenieriasf.swapping.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.ingenieriasf.swapping.dtos.Login;
import hn.unah.ingenieriasf.swapping.entities.Roles;
import hn.unah.ingenieriasf.swapping.entities.Usuarios;
import hn.unah.ingenieriasf.swapping.repositories.rolesRepositorie;
import hn.unah.ingenieriasf.swapping.repositories.usuariosRepositorie;
import hn.unah.ingenieriasf.swapping.services.usuariosService;

@Service
public class usuariosServiceImpl implements usuariosService{
    
    @Autowired
    private usuariosRepositorie UsuariosRepositorie;

    @Autowired
    private rolesRepositorie RolesRepositorie;


    @Override
    public Boolean crearUsuario(Usuarios usuario) {

        if (this.UsuariosRepositorie.findByEmail(usuario.getEmail()).isEmpty()) {
            
            Roles rolDefault = this.RolesRepositorie.findById(1).get();

            usuario.setRoles(rolDefault);
            usuario.setStatususuario(1);
            usuario.setUsuarioreportado(0);
            this.UsuariosRepositorie.save(usuario);
            return true;
        }
        return false;
    }


    @Override
    public Usuarios iniciarSecion(Login login ) {
        if (null != this.UsuariosRepositorie.findByEmail(login.getCorreo())) {
            try {
                Usuarios usuarioActual = (Usuarios) this.UsuariosRepositorie.findByEmail(login.getCorreo()).get(0);
                if (usuarioActual.getPassword().equals(login.getContrasena())) {
                    return usuarioActual;
                }
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
    
}
