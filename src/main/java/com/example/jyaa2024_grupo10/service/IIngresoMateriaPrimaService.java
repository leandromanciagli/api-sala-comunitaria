package com.example.jyaa2024_grupo10.service;

import com.example.jyaa2024_grupo10.model.IngresoMateriaPrima;
import org.jvnet.hk2.annotations.Contract;
import java.util.List;

@Contract
public interface IIngresoMateriaPrimaService {
    List<IngresoMateriaPrima> getAll();

    IngresoMateriaPrima getById(Long id);

    IngresoMateriaPrima create(IngresoMateriaPrima ingresoMateriaPrima);

    IngresoMateriaPrima update(IngresoMateriaPrima ingresoMateriaPrima);

    void delete(Long id);
}
