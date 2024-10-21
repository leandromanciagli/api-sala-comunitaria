package com.example.jyaa2024_grupo10.service.impl;

import com.example.jyaa2024_grupo10.dao.IGenericDAO;
import com.example.jyaa2024_grupo10.model.ProductoraAgricola;
import com.example.jyaa2024_grupo10.model.Rol;
import com.example.jyaa2024_grupo10.service.IRolService;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.jvnet.hk2.annotations.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Singleton
@Service
public class RolServiceImpl implements IRolService {

    @Inject
    private IGenericDAO<Rol, Long> rolDAO;


    @Transactional
    public List<Rol> getAll() {
        return rolDAO.findAll();
    }

    @Transactional
    public Rol getById(Long id) {
        return rolDAO.find(id);
    }

    @Transactional
    public Rol create(Rol rol) {
        return rolDAO.create(rol);
    }

    @Transactional
    public Rol update(Rol rol) {
        return rolDAO.update(rol);
    }

    @Transactional
    public void delete(Long id) {
        Rol rol = rolDAO.find(id);
        if (rol != null) {
            rol.setFechaHasta(new Date());
            rolDAO.update(rol);
        }
    }
}
