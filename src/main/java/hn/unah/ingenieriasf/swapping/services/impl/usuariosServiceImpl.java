package hn.unah.ingenieriasf.swapping.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.ingenieriasf.swapping.dtos.Login;
import hn.unah.ingenieriasf.swapping.entities.FotosDNI;
import hn.unah.ingenieriasf.swapping.entities.Roles;
import hn.unah.ingenieriasf.swapping.entities.Usuarios;
import hn.unah.ingenieriasf.swapping.repositories.fotosDNIRepositorie;
import hn.unah.ingenieriasf.swapping.repositories.rolesRepositorie;
import hn.unah.ingenieriasf.swapping.repositories.usuariosRepositorie;
import hn.unah.ingenieriasf.swapping.services.usuariosService;

@Service
public class usuariosServiceImpl implements usuariosService{
    
    @Autowired
    private usuariosRepositorie UsuariosRepositorie;

    @Autowired
    private rolesRepositorie RolesRepositorie;

    @Autowired
    private fotosDNIRepositorie FotosDNIRepositorie;


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


    @Override
    public Usuarios obtenerUsuario(Long idusuario) {
        return this.UsuariosRepositorie.findById(idusuario).get();
    }


    @Override
    public Usuarios crearVendedor(Usuarios vendedor) {
        
        if (this.UsuariosRepositorie.findByEmail(vendedor.getEmail()).isEmpty()) {
            
            Roles rolDefault = this.RolesRepositorie.findById(2).get();

            vendedor.setRoles(rolDefault);
            vendedor.setStatususuario(1);
            vendedor.setUsuarioreportado(0);
            
            FotosDNI fotoDNI = (FotosDNI) vendedor.getFotodni();
            fotoDNI.setUsuario(vendedor);

            this.FotosDNIRepositorie.save(fotoDNI);

            Usuarios usuarioActual = this.UsuariosRepositorie.findByEmail(vendedor.getEmail()).get(0);

            return usuarioActual;
        }
        return null;
    }
    
}
