package com.example.jyaa2024_grupo10.service;

import com.example.jyaa2024_grupo10.model.ModoAlmacenamiento;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;

@Contract
public interface IModoAlmacenamientoService {
    List<ModoAlmacenamiento> getAll();

    ModoAlmacenamiento getById(Long id);

    ModoAlmacenamiento create(ModoAlmacenamiento modoAlmacenamiento);

    ModoAlmacenamiento update(ModoAlmacenamiento modoAlmacenamiento);

    void delete(Long id);
}
