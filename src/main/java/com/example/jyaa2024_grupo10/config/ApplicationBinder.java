package com.example.jyaa2024_grupo10.config;

import com.example.jyaa2024_grupo10.dao.IGenericDAO;
import com.example.jyaa2024_grupo10.dao.impl.GenericDAOFactory;
import com.example.jyaa2024_grupo10.model.*;
import com.example.jyaa2024_grupo10.service.*;
import com.example.jyaa2024_grupo10.service.impl.*;
import org.glassfish.hk2.api.TypeLiteral;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class ApplicationBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(UsuarioServiceImpl.class).to(IUsuarioService.class);
        bind(MateriaPrimaServiceImpl.class).to(IMateriaPrimaService.class);
        bind(ProductoraAgricolaServiceImpl.class).to(IProductoraAgricolaService.class);
        bind(IngresoMateriaPrimaServiceImpl.class).to(IIngresoMateriaPrimaService.class);
        bind(RolServiceImpl.class).to(IRolService.class);
        bind(TipoMateriaPrimaServiceImpl.class).to(ITipoMateriaPrimaService.class);
        bind(ModoAlmacenamientoServiceImpl.class).to(IModoAlmacenamientoService.class);
        bind(UnidadDeMedidaServiceImpl.class).to(IUnidadDeMedidaService.class);



        bindFactory(new GenericDAOFactory<Usuario, Long>(Usuario.class, Long.class))
                .to(new TypeLiteral<IGenericDAO<Usuario, Long>>() {});
        bindFactory(new GenericDAOFactory<MateriaPrima, Long>(MateriaPrima.class, Long.class))
                .to(new TypeLiteral<IGenericDAO<MateriaPrima, Long>>() {});
        bindFactory(new GenericDAOFactory<Rol, Long>(Rol.class, Long.class))
                .to(new TypeLiteral<IGenericDAO<Rol, Long>>() {});
        bindFactory(new GenericDAOFactory<ProductoraAgricola, Long>(ProductoraAgricola.class, Long.class))
                .to(new TypeLiteral<IGenericDAO<ProductoraAgricola, Long>>() {});
        bindFactory(new GenericDAOFactory<IngresoMateriaPrima, Long>(IngresoMateriaPrima.class, Long.class))
                .to(new TypeLiteral<IGenericDAO<IngresoMateriaPrima, Long>>() {});
        bindFactory(new GenericDAOFactory<TipoMateriaPrima, Long>(TipoMateriaPrima.class, Long.class))
                .to(new TypeLiteral<IGenericDAO<TipoMateriaPrima, Long>>() {});
        bindFactory(new GenericDAOFactory<ModoAlmacenamiento, Long>(ModoAlmacenamiento.class, Long.class))
                .to(new TypeLiteral<IGenericDAO<ModoAlmacenamiento, Long>>() {});
        bindFactory(new GenericDAOFactory<UnidadDeMedida, Long>(UnidadDeMedida.class, Long.class))
                .to(new TypeLiteral<IGenericDAO<UnidadDeMedida, Long>>() {});
    }
}
