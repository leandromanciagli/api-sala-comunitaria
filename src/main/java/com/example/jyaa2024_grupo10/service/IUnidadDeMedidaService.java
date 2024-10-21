package com.example.jyaa2024_grupo10.service;

import com.example.jyaa2024_grupo10.model.UnidadDeMedida;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;

@Contract
public interface IUnidadDeMedidaService {
    List<UnidadDeMedida> getAll();

    UnidadDeMedida getById(Long id);
}
