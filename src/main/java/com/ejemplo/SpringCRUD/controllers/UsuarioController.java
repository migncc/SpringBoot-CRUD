package com.ejemplo.SpringCRUD.controllers;
import com.ejemplo.SpringCRUD.models.Usuario;
import com.ejemplo.SpringCRUD.repositories.UsuarioRepository;
import com.ejemplo.SpringCRUD.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> obtenerUsuarios(){
        return usuarioService.getAllUsuarios();
    }
    @GetMapping("/id")
    public Optional<Usuario> obtenerUsuarioPorId(@PathVariable long id){
        return usuarioService.getUsuarioById(id);
    }
    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario user){
        return usuarioService.saveUsuario(user);
    }

    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
       usuario.setId(id);
        return usuarioService.saveUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public  void eliminarusuario(@PathVariable long id){
        usuarioService.deleteusuario(id);
    }

}
