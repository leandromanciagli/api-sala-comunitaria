package com.example.jyaa2024_grupo10.service.impl;

import com.example.jyaa2024_grupo10.dao.IGenericDAO;
import com.example.jyaa2024_grupo10.model.Rol;
import com.example.jyaa2024_grupo10.model.TipoMateriaPrima;
import com.example.jyaa2024_grupo10.service.ITipoMateriaPrimaService;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.jvnet.hk2.annotations.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Singleton
@Service
public class TipoMateriaPrimaServiceImpl implements ITipoMateriaPrimaService {

    @Inject
    private IGenericDAO<TipoMateriaPrima, Long> tipoMateriaPrimaDAO;


    @Transactional
    public List<TipoMateriaPrima> getAll() {
        return tipoMateriaPrimaDAO.findAll();
    }

    @Transactional
    public TipoMateriaPrima getById(Long id) {
        return tipoMateriaPrimaDAO.find(id);
    }

    @Transactional
    public TipoMateriaPrima create(TipoMateriaPrima tipoMateriaPrima) {
        return tipoMateriaPrimaDAO.create(tipoMateriaPrima);
    }

    @Transactional
    public TipoMateriaPrima update(TipoMateriaPrima tipoMateriaPrima) {
        return tipoMateriaPrimaDAO.update(tipoMateriaPrima);
    }

    @Transactional
    public void delete(Long id) {
        TipoMateriaPrima tipoMateriaPrima = tipoMateriaPrimaDAO.find(id);
        if (tipoMateriaPrima != null) {
            tipoMateriaPrima.setFechaHasta(new Date());
            tipoMateriaPrimaDAO.update(tipoMateriaPrima);
        }
    }
}
