package com.example.jyaa2024_grupo10.service;

import com.example.jyaa2024_grupo10.model.TipoMateriaPrima;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;

@Contract
public interface ITipoMateriaPrimaService {
    List<TipoMateriaPrima> getAll();

    TipoMateriaPrima getById(Long id);

    TipoMateriaPrima create(TipoMateriaPrima tipoMateriaPrima);

    TipoMateriaPrima update(TipoMateriaPrima tipoMateriaPrima);

    void delete(Long id);
}
