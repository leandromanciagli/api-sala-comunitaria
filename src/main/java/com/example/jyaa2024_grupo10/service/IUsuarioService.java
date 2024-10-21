package com.example.jyaa2024_grupo10.service;

import com.example.jyaa2024_grupo10.model.Usuario;
import org.jvnet.hk2.annotations.Contract;
import java.util.List;

@Contract
public interface IUsuarioService {
    List<Usuario> getAll();

    Usuario getById(Long id);

    Usuario create(Usuario usuario);

    Usuario update(Usuario usuario);

    void delete(Long id);
}
