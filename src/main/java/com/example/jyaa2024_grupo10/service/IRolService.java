package com.example.jyaa2024_grupo10.service;

import com.example.jyaa2024_grupo10.model.Rol;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;

@Contract
public interface IRolService {
    List<Rol> getAll();

    Rol getById(Long id);

    Rol create(Rol rol);

    Rol update(Rol rol);

    void delete(Long id);
}
