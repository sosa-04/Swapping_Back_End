package hn.unah.ingenieriasf.swapping.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.ingenieriasf.swapping.dtos.Login;
import hn.unah.ingenieriasf.swapping.entities.Usuarios;
import hn.unah.ingenieriasf.swapping.services.impl.usuariosServiceImpl;

@CrossOrigin(origins = "*") // Permitir solicitudes desde Live Server

@RestController
@RequestMapping("/api")
public class usuariosController {

    @Autowired
    private usuariosServiceImpl UsuariosServiceImpl;

    @PostMapping("/usuarios/crearUsuario")
    public Boolean crearUsuario( @RequestBody Usuarios usuario ) {
        return this.UsuariosServiceImpl.crearUsuario(usuario);
    }

// Debe ser una solicitud Post
    @GetMapping("/usuarios/iniciarSecion")
    public Usuarios iniciarSecion( Login login  ) {
        return this.UsuariosServiceImpl.iniciarSecion ( login );
    }   

@GetMapping("/usuarios/obtenerUsuario")
public Usuarios obtenerUsuario( Long idusuario ) {
    return this.UsuariosServiceImpl.obtenerUsuario(idusuario);
} 


}
