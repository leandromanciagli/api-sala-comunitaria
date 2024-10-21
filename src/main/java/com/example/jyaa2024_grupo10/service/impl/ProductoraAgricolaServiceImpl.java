package com.example.jyaa2024_grupo10.service.impl;

import com.example.jyaa2024_grupo10.dao.IGenericDAO;
import com.example.jyaa2024_grupo10.model.ModoAlmacenamiento;
import com.example.jyaa2024_grupo10.model.ProductoraAgricola;
import com.example.jyaa2024_grupo10.service.IProductoraAgricolaService;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.jvnet.hk2.annotations.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Singleton
@Service
public class ProductoraAgricolaServiceImpl implements IProductoraAgricolaService {

    @Inject
    private IGenericDAO<ProductoraAgricola, Long> productoraAgricolaDAO;


    @Transactional
    public List<ProductoraAgricola> getAll() {
        return productoraAgricolaDAO.findAll();
    }

    @Transactional
    public ProductoraAgricola getById(Long id) {
        return productoraAgricolaDAO.find(id);
    }

    @Transactional
    public ProductoraAgricola create(ProductoraAgricola productoraAgricola) {
        return productoraAgricolaDAO.create(productoraAgricola);
    }

    @Transactional
    public ProductoraAgricola update(ProductoraAgricola productoraAgricola) {
        return productoraAgricolaDAO.update(productoraAgricola);
    }

    @Transactional
    public void delete(Long id) {
        ProductoraAgricola productoraAgricola = productoraAgricolaDAO.find(id);
        if (productoraAgricola != null) {
            productoraAgricola.setFechaHasta(new Date());
            productoraAgricolaDAO.update(productoraAgricola);
        }
    }
}
