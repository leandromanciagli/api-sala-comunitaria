package com.example.jyaa2024_grupo10.service;

import com.example.jyaa2024_grupo10.model.ProductoraAgricola;
import org.jvnet.hk2.annotations.Contract;
import java.util.List;

@Contract
public interface IProductoraAgricolaService {
    List<ProductoraAgricola> getAll();

    ProductoraAgricola getById(Long id);

    ProductoraAgricola create(ProductoraAgricola productoraAgricola);

    ProductoraAgricola update(ProductoraAgricola productoraAgricola);

    void delete(Long id);
}
