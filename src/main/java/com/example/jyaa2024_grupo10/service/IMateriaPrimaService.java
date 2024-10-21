package com.example.jyaa2024_grupo10.service;

import com.example.jyaa2024_grupo10.model.MateriaPrima;
import org.jvnet.hk2.annotations.Contract;
import java.util.List;

@Contract
public interface IMateriaPrimaService {
    List<MateriaPrima> getAll();

    MateriaPrima getById(Long id);

    MateriaPrima create(MateriaPrima materiaPrima);

    MateriaPrima update(MateriaPrima materiaPrima);

    void delete(Long id);
}
