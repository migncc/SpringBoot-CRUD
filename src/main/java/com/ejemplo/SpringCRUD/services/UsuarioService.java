package com.ejemplo.SpringCRUD.services;
import com.ejemplo.SpringCRUD.models.Usuario;
import com.ejemplo.SpringCRUD.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Lisatr todos los usuarios
     * @return lista con todos los usuarios existentes en la Base de datos
     */
    public List<Usuario> getAllUsuarios(){
        return usuarioRepository.findAll();
    }

    /**
     *Encontrar un usuario mediante su PK Id
     * @param id id del usaurio al que se desea encontrar
     * @return devuelve al usaurio, o enc asod e no existir maneja el error
     */
    public Optional<Usuario> getUsuarioById(long id){
        return usuarioRepository.findById(id);
    }

    /**
     *Guarda un usuario en la base de datos, si el id ya es existente modifica por el id
     * @param u usuario que se desea guardar
     * @return devuelve el usuario guardado
     */
    public Usuario saveUsuario(Usuario u) {
    return usuarioRepository.save(u);
    }

    /**
     * Eliminar un usaurio de la abse de datos por ID
     * @param id id del usauriuo que se desea eliminar
     */
    public  void deleteusuario(long id){
        usuarioRepository.deleteById(id);
    }



}
