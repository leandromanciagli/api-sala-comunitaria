package com.example.jyaa2024_grupo10.service.impl;

import com.example.jyaa2024_grupo10.dao.IGenericDAO;
import com.example.jyaa2024_grupo10.model.MateriaPrima;
import com.example.jyaa2024_grupo10.model.TipoMateriaPrima;
import com.example.jyaa2024_grupo10.service.IMateriaPrimaService;
import com.example.jyaa2024_grupo10.service.ITipoMateriaPrimaService;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.jvnet.hk2.annotations.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Singleton
@Service
public class MateriaPrimaServiceImpl implements IMateriaPrimaService {

    @Inject
    private IGenericDAO<MateriaPrima, Long> materiaPrimaDAO;


    @Transactional
    public List<MateriaPrima> getAll() {
        return materiaPrimaDAO.findAll();
    }

    @Transactional
    public MateriaPrima getById(Long id) {
        return materiaPrimaDAO.find(id);
    }

    @Transactional
    public MateriaPrima create(MateriaPrima materiaPrima) {
        return materiaPrimaDAO.create(materiaPrima);
    }

    @Transactional
    public MateriaPrima update(MateriaPrima materiaPrima) {
        return materiaPrimaDAO.update(materiaPrima);
    }

    @Transactional
    public void delete(Long id) {
        MateriaPrima materiaPrima = materiaPrimaDAO.find(id);
        if (materiaPrima != null) {
            materiaPrima.setFechaHasta(new Date());
            materiaPrimaDAO.update(materiaPrima);
        }
    }
}
