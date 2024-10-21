package com.example.jyaa2024_grupo10.service.impl;

import com.example.jyaa2024_grupo10.dao.IGenericDAO;
import com.example.jyaa2024_grupo10.model.IngresoMateriaPrima;
import com.example.jyaa2024_grupo10.model.ModoAlmacenamiento;
import com.example.jyaa2024_grupo10.service.IModoAlmacenamientoService;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.jvnet.hk2.annotations.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Singleton
@Service
public class ModoAlmacenamientoServiceImpl implements IModoAlmacenamientoService {

    @Inject
    private IGenericDAO<ModoAlmacenamiento, Long> modoAlmacenamientoDAO;


    @Transactional
    public List<ModoAlmacenamiento> getAll() {
        return modoAlmacenamientoDAO.findAll();
    }

    @Transactional
    public ModoAlmacenamiento getById(Long id) {
        return modoAlmacenamientoDAO.find(id);
    }

    @Transactional
    public ModoAlmacenamiento create(ModoAlmacenamiento modoAlmacenamiento) {
        return modoAlmacenamientoDAO.create(modoAlmacenamiento);
    }

    @Transactional
    public ModoAlmacenamiento update(ModoAlmacenamiento modoAlmacenamiento) {
        return modoAlmacenamientoDAO.update(modoAlmacenamiento);
    }

    @Transactional
    public void delete(Long id) {
        ModoAlmacenamiento modoAlmacenamiento = modoAlmacenamientoDAO.find(id);
        if (modoAlmacenamiento != null) {
            modoAlmacenamiento.setFechaHasta(new Date());
            modoAlmacenamientoDAO.update(modoAlmacenamiento);
        }
    }
}
