package com.example.jyaa2024_grupo10.service.impl;

import com.example.jyaa2024_grupo10.dao.IGenericDAO;
import com.example.jyaa2024_grupo10.model.UnidadDeMedida;
import com.example.jyaa2024_grupo10.service.IUnidadDeMedidaService;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.jvnet.hk2.annotations.Service;

import javax.transaction.Transactional;
import java.util.List;

@Singleton
@Service
public class UnidadDeMedidaServiceImpl implements IUnidadDeMedidaService {

    @Inject
    private IGenericDAO<UnidadDeMedida, Long> unidadDeMedidaDAO;


    @Transactional
    public List<UnidadDeMedida> getAll() {
        return unidadDeMedidaDAO.findAll();
    }

    @Transactional
    public UnidadDeMedida getById(Long id) {
        return unidadDeMedidaDAO.find(id);
    }

}
