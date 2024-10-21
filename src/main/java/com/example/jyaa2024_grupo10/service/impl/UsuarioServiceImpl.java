package com.example.jyaa2024_grupo10.service.impl;

import com.example.jyaa2024_grupo10.dao.IGenericDAO;
import com.example.jyaa2024_grupo10.model.Rol;
import com.example.jyaa2024_grupo10.model.TipoMateriaPrima;
import com.example.jyaa2024_grupo10.model.Usuario;
import com.example.jyaa2024_grupo10.service.IRolService;
import com.example.jyaa2024_grupo10.service.IUsuarioService;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.jvnet.hk2.annotations.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Singleton
@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Inject
    private IGenericDAO<Usuario, Long> usuarioDAO;

    @Inject
    private IRolService rolService;


    @Transactional
    public List<Usuario> getAll() {
        return usuarioDAO.findAll();
    }

    @Transactional
    public Usuario getById(Long id) {
        return usuarioDAO.find(id);
    }

    @Transactional
    public Usuario create(Usuario usuario) {
        List<Rol> roles = new ArrayList<>();
        for (Rol rol : usuario.getRoles()) {
            Rol rolEncontrado = rolService.getById(rol.getRolId());
            if (rolEncontrado != null) {
                roles.add(rolEncontrado);
            }
        }
        usuario.setRoles(roles);
        return usuarioDAO.create(usuario);
    }

    @Transactional
    public Usuario update(Usuario usuario) {
        List<Rol> roles = new ArrayList<>();
        for (Rol rol : usuario.getRoles()) {
            Rol rolEncontrado = rolService.getById(rol.getRolId());
            if (rolEncontrado != null) {
                roles.add(rolEncontrado);
            }
        }
        usuario.setRoles(roles);
        return usuarioDAO.update(usuario);
    }

    @Transactional
    public void delete(Long id) {
        Usuario usuario = usuarioDAO.find(id);
        if (usuario != null) {
            usuario.setFechaHasta(new Date());
            usuarioDAO.update(usuario);
        }
    }
}
