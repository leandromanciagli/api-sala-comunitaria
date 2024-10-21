package com.example.jyaa2024_grupo10.service.impl;

import com.example.jyaa2024_grupo10.dao.IGenericDAO;
import com.example.jyaa2024_grupo10.model.*;
import com.example.jyaa2024_grupo10.service.IIngresoMateriaPrimaService;
import com.example.jyaa2024_grupo10.service.IMateriaPrimaService;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.jvnet.hk2.annotations.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Singleton
@Service
public class IngresoMateriaPrimaServiceImpl implements IIngresoMateriaPrimaService {

    @Inject
    private IGenericDAO<IngresoMateriaPrima, Long> ingresoMateriaPrimaDAO;

    @Inject
    private IMateriaPrimaService materiaPrimaService;


    @Transactional
    public List<IngresoMateriaPrima> getAll() {
        return ingresoMateriaPrimaDAO.findAll();
    }

    @Transactional
    public IngresoMateriaPrima getById(Long id) {
        return ingresoMateriaPrimaDAO.find(id);
    }

    @Transactional
    public IngresoMateriaPrima create(IngresoMateriaPrima ingresoMateriaPrima) {
        MateriaPrima materiaPrima = materiaPrimaService.getById(ingresoMateriaPrima.getMateriaPrima().getMateriaPrimaId());
        if (materiaPrima != null) {
            materiaPrima.setCantidad(materiaPrima.getCantidad() + ingresoMateriaPrima.getCantidad());
            materiaPrimaService.update(materiaPrima);
        }
        return ingresoMateriaPrimaDAO.create(ingresoMateriaPrima);
    }

    @Transactional
    public IngresoMateriaPrima update(IngresoMateriaPrima ingresoMateriaPrima) {
        return ingresoMateriaPrimaDAO.update(ingresoMateriaPrima);
    }

    @Transactional
    public void delete(Long id) {
        IngresoMateriaPrima ingresoMateriaPrima = ingresoMateriaPrimaDAO.find(id);
        if (ingresoMateriaPrima != null) {
            ingresoMateriaPrima.setFechaHasta(new Date());
            ingresoMateriaPrimaDAO.update(ingresoMateriaPrima);
        }
    }
}
