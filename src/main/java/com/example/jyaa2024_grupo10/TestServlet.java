package com.example.jyaa2024_grupo10;

import java.io.*;

import com.example.jyaa2024_grupo10.dao.impl.GenericDAO;
import com.example.jyaa2024_grupo10.model.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.util.Date;
import java.util.List;

@WebServlet(name = "testServlet", value = "/test-servlet")
public class TestServlet extends HttpServlet {



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println(
                "-----------------------------------------------ROLES--------------------------------------------------"
        );

        GenericDAO<Rol, Long> rolDAO = new GenericDAO<>(Rol.class);

        // Crear rol administrador
        Rol rolAdministrador = new Rol(
                "ADMINISTRADOR",
                "Administrador",
                null
        );
        rolDAO.create(rolAdministrador);
        System.out.println("Nuevo rol: " + rolAdministrador.toString());

        // Crear rol encargado de sala
        Rol rolEncargado = new Rol(
                "ENCARGADO",
                "Encargado de sala",
                "El rol encargado de sala sólo puede realizar y consultar elaboraciones, registrar lotes e ingresos de materia prima."
        );
        rolDAO.create(rolEncargado);
        System.out.println("Nuevo rol: " + rolEncargado.toString());

        // Crear Otro rol
        Rol rolAyudante = new Rol(
                "AYUDANTE",
                "Ayudante de sala",
                "El rol ayudante de sala sólo puede consultar elaboraciones."
        );
        rolDAO.create(rolAyudante);
        System.out.println("Nuevo rol: " + rolAyudante.toString());

        // Actualizar un rol
        rolAdministrador.setDescripcion("El rol administrador puede consultar cualquier tipo de información y realizar todas las operaciones disponibles en el sistema.");
        rolDAO.update(rolAdministrador);
        System.out.println("Se actualizó el rol administrador: " + rolAdministrador.toString());

        // Buscar un rol
        Rol rol = rolDAO.find(1L);
        System.out.println("Se recupera el rol: " + rol.toString());

        // Listar todos los roles
        List<Rol> roles = rolDAO.findAll();
        System.out.println("Lista de roles: " + roles);

        // Eliminar un rol
        rolDAO.delete(rolAyudante);
        roles = rolDAO.findAll();
        System.out.println("Se eliminó el rol ayudante de sala. Lista de roles actualizada: " + roles);





        System.out.println(
                "--------------------------------------------USUARIOS--------------------------------------------------"
        );

        GenericDAO<Usuario, Long> usuarioDAO = new GenericDAO<>(Usuario.class);

        // Crear usuario
        Usuario usuario1 = new Usuario(
            "leandromanciagli",
            "1234",
            "Leandro Manciagli",
            "leandromanciagli@gmail.com",
            "2214207932",
            rolDAO.findAll()
        );
        usuarioDAO.create(usuario1);
        System.out.println("Nuevo usuario: " + usuario1);

        // Crear usuario
        Usuario usuario2 = new Usuario(
            "juanperez",
            "1234",
            "Juan Perez",
            "juanperez@gmail.com",
            "2214528963",
            rolDAO.findAll()
        );
        usuarioDAO.create(usuario2);
        System.out.println("Nuevo usuario: " + usuario2);

        // Actualizar un usuario
        usuario2.setEmail("juanperezalternativo@gmail.com");
        usuarioDAO.update(usuario2);
        System.out.println("Se actualizó el usuario Juan Perez: " + usuario2.toString());

        // Buscar un usuario
        Usuario usuario = usuarioDAO.find(1L);
        System.out.println("Se recupera el usuario: " + usuario.toString());

        // Listar todos los usuarios All
        List<Usuario> usuarios = usuarioDAO.findAll();
        System.out.println("Lista de usuarios: " + usuarios);

        // Eliminar un usuario
        usuarioDAO.delete(usuario2);
        usuarios = usuarioDAO.findAll();
        System.out.println("Se eliminó el usuario 2. Lista de usuarios actualizada: " + usuarios);




        System.out.println(
                "------------------------------------------UNIDADES DE MEDIDA--------------------------------------------------"
        );

        GenericDAO<UnidadDeMedida, Long> unidadDeMedidaDAO = new GenericDAO<>(UnidadDeMedida.class);

        // Crear unidad de medida
        UnidadDeMedida kilogramos = new UnidadDeMedida(
                "Kilogramos",
                "Kg"
        );
        unidadDeMedidaDAO.create(kilogramos);
        System.out.println("Nueva unidad de medida: " + kilogramos.toString());

        // Crear unidad de medida
        UnidadDeMedida gramos = new UnidadDeMedida(
                "Gramos",
                "Gr"
        );
        unidadDeMedidaDAO.create(gramos);
        System.out.println("Nueva unidad de medida: " + gramos.toString());

        // Crear unidad de medida
        UnidadDeMedida litros = new UnidadDeMedida(
                "Litros",
                "Lt"
        );
        unidadDeMedidaDAO.create(litros);
        System.out.println("Nueva unidad de medida: " + litros.toString());


        // Listar todas las unidades de medida
        List<UnidadDeMedida> unidadesDeMedida = unidadDeMedidaDAO.findAll();
        System.out.println("Lista de unidades de medida: " + unidadesDeMedida);





        System.out.println(
                "------------------------------------------TIPOS DE MATERIA PRIMA--------------------------------------------------"
        );

        GenericDAO<TipoMateriaPrima, Long> tipoMateriaPrimaDAO = new GenericDAO<>(TipoMateriaPrima.class);

        // Crear tipo de materia prima
        TipoMateriaPrima tipoFruta = new TipoMateriaPrima(
                "Fruta",
                "Tipo de materia prima para generar elaboraciones, generalmente mermeladas"
        );
        tipoMateriaPrimaDAO.create(tipoFruta);
        System.out.println("Nuevo tipo de materia prima: " + tipoFruta.toString());

        // Crear tipo de materia prima
        TipoMateriaPrima tipoVerdura = new TipoMateriaPrima(
                "Verdura",
                "Tipo de materia prima para generar productos agrícolas."
        );
        tipoMateriaPrimaDAO.create(tipoVerdura);
        System.out.println("Nuevo tipo de materia prima: " + tipoVerdura.toString());

        // Crear tipo de materia prima
        TipoMateriaPrima tipoEndulzante = new TipoMateriaPrima(
                "Endulzante",
                "Tipo de materia prima para endulzar naturalmente los productos agroecológicos elaborados."
        );
        tipoMateriaPrimaDAO.create(tipoEndulzante);
        System.out.println("Nuevo tipo de materia prima: " + tipoEndulzante.toString());

        // Actualizar un tipo de materia prima
        tipoVerdura.setDescripcion("Verduras para productos de la sala comunitaria");
        tipoMateriaPrimaDAO.update(tipoVerdura);
        System.out.println("Se actualizó el tipo de materia prima: " + tipoVerdura.toString());

        // Buscar un tipo de materia prima
        TipoMateriaPrima tipoMateriaPrima = tipoMateriaPrimaDAO.find(1L);
        System.out.println("Se recupera el tipo de materia prima: " + tipoMateriaPrima.toString());

        // Listar todos los tipos de materia prima
        List<TipoMateriaPrima> tiposMateriaPrima = tipoMateriaPrimaDAO.findAll();
        System.out.println("Lista de tipos de materia prima: " + tiposMateriaPrima);

        // Eliminar un tipo de materia prima
        tipoMateriaPrimaDAO.delete(tipoVerdura);
        tiposMateriaPrima = tipoMateriaPrimaDAO.findAll();
        System.out.println("Se eliminó el tipo de materia prima verdura. Lista de materias primas actualizada: " + tiposMateriaPrima);





        System.out.println(
                "-----------------------------------------MODOS DE ALMACENAMIENTO--------------------------------------------------"
        );

        GenericDAO<ModoAlmacenamiento, Long> modoAlmacenamientoDAO = new GenericDAO<>(ModoAlmacenamiento.class);

        // Crear modo de almacenamiento
        ModoAlmacenamiento almacenamientoEnHeladera = new ModoAlmacenamiento(
                "En heladera",
                "Para productos perecederos que necesitan mantenerse a baja temperatura pero no congelados, como lácteos, frutas y verduras."
        );
        modoAlmacenamientoDAO.create(almacenamientoEnHeladera);
        System.out.println("Nuevo modo de almacenamiento: " + almacenamientoEnHeladera);

        // Crear modo de almacenamiento
        ModoAlmacenamiento almacenamientoEnFreezer = new ModoAlmacenamiento(
                "En freezer",
                "Almacenamiento en freezer a bajas temperaturas."
        );
        modoAlmacenamientoDAO.create(almacenamientoEnFreezer);
        System.out.println("Nuevo modo de almacenamiento: " + almacenamientoEnFreezer);

        // Crear modo de almacenamiento
        ModoAlmacenamiento almacenamientoEnEstante = new ModoAlmacenamiento(
                "En estante",
                "Tipo de materia prima para generar productos elaborados."
        );
        modoAlmacenamientoDAO.create(almacenamientoEnEstante);
        System.out.println("Nuevo modo de almacenamiento: " + almacenamientoEnEstante);

        // Crear modo de almacenamiento
        ModoAlmacenamiento almacenamiento1 = new ModoAlmacenamiento(
                "Modo almacenamiento de prueba",
                ""
        );
        modoAlmacenamientoDAO.create(almacenamiento1);
        System.out.println("Nuevo modo de almacenamiento: " + almacenamiento1);

        // Actualizar un modo de almacenamiento
        almacenamientoEnFreezer.setDescripcion(almacenamientoEnFreezer.getDescripcion() + " Generalmente a temperaturas bajo 0");
        modoAlmacenamientoDAO.update(almacenamientoEnFreezer);
        System.out.println("Se actualizó el modo de almacenamiento: " + almacenamientoEnFreezer.toString());

        // Buscar un modo de almacenamiento
        ModoAlmacenamiento modoAlmacenamiento = modoAlmacenamientoDAO.find(1L);
        System.out.println("Se recupera el modo de almacenamiento: " + modoAlmacenamiento.toString());

        // Listar todos los modos de almacenamiento
        List<ModoAlmacenamiento> modosAlmacenamiento = modoAlmacenamientoDAO.findAll();
        System.out.println("Lista de modos de almacenamiento: " + modosAlmacenamiento);

        // Eliminar un modo de almacenamiento
        modoAlmacenamientoDAO.delete(almacenamiento1);
        modosAlmacenamiento = modoAlmacenamientoDAO.findAll();
        System.out.println("Se eliminó el modo de almacenamiento de prueba. Lista de modos de almacenamiento actualizada: " + modosAlmacenamiento);





        System.out.println(
                "-----------------------------------------------MATERIAS PRIMAS--------------------------------------------------"
        );

        GenericDAO<MateriaPrima, Long> materiaPrimaDAO = new GenericDAO<>(MateriaPrima.class);

        // Crear materia prima
        MateriaPrima tomate = new MateriaPrima(
                "Tomate",
                "Tomates frescos de huerta.",
                tipoFruta,
                kilogramos
        );
        materiaPrimaDAO.create(tomate);
        System.out.println("Nueva materia prima: " + tomate);

        // Crear materia prima
        MateriaPrima azucar = new MateriaPrima(
                "Azúcar",
                "Endulzante proveniente de la caña de azúcar",
                tipoEndulzante,
                kilogramos
        );
        materiaPrimaDAO.create(azucar);
        System.out.println("Nueva materia prima: " + azucar);

        // Crear materia prima
        MateriaPrima durazno = new MateriaPrima(
                "Durazno",
                "Duraznos provenientes de plantaciones naturales.",
                tipoFruta,
                kilogramos
        );
        materiaPrimaDAO.create(durazno);
        System.out.println("Nueva materia prima: " + durazno);

        // Actualizar una materia prima
        tomate.setDescripcion(tomate.getDescripcion() + " Ideal para mermelada.");
        materiaPrimaDAO.update(tomate);
        System.out.println("Se actualizó la materia prima: " + tomate);

        // Buscar una materia prima
        MateriaPrima materiaPrima = materiaPrimaDAO.find(1L);
        System.out.println("Se recuperó la materia prima: " + materiaPrima);

        // Listar todas las materias primas
        List<MateriaPrima> materiasPrimas = materiaPrimaDAO.findAll();
        System.out.println("Lista de materias primas: " + materiasPrimas);

        // Eliminar una materia prima
        materiaPrimaDAO.delete(durazno);
        System.out.println("Se eliminó la materia prima durazno. Lista de materias primas actualizada: " + materiaPrimaDAO.findAll());





        System.out.println(
                "--------------------------------------------PRODUCTORAS AGRÍCOLAS--------------------------------------------------"
        );

        GenericDAO<ProductoraAgricola, Long> productoraAgricolaDAO = new GenericDAO<>(ProductoraAgricola.class);

        // Crear productora agrícola
        ProductoraAgricola productora1 = new ProductoraAgricola(
                "Productora Abasto",
                "Calle 208 e/ 515 y 516",
                "2214578232",
                "productora1@gmail.com"
        );
        productoraAgricolaDAO.create(productora1);
        System.out.println("Nueva productora agrícola: " + productora1);

        // Crear productora agrícola
        ProductoraAgricola productora2 = new ProductoraAgricola(
                "Productora Dos",
                "Calle 456",
                "2214452323",
                "productora2@gmail.com"
        );
        productoraAgricolaDAO.create(productora2);
        System.out.println("Nueva productora agrícola: " + productora2);

        // Actualizar una productora agrícola
        productora1.setEmail("productoraabasto@gmail.com");
        productoraAgricolaDAO.update(productora1);
        System.out.println("Se actualizó la productora agrícola: " + productora1);

        // Buscar una productora agrícola
        ProductoraAgricola productoraAgricola = productoraAgricolaDAO.find(1L);
        System.out.println("Se recuperó la productora agrícola: " + productoraAgricola);

        // Listar todas las productoras agrícolas
        List<ProductoraAgricola> productorasAgricola = productoraAgricolaDAO.findAll();
        System.out.println("Lista de productoras agrícolas: " + productorasAgricola);

        // Eliminar una productora agrícola
        productoraAgricolaDAO.delete(productora2);
        System.out.println("Se eliminó la productora agrícola. Lista de productoras agrícolas actualizada: " + productoraAgricolaDAO.findAll());




        System.out.println(
                "---------------------------------------INGRESOS DE MATERIA PRIMA---------------------------------------------"
        );

        GenericDAO<IngresoMateriaPrima, Long> ingresoMateriaPrimaDAO = new GenericDAO<>(IngresoMateriaPrima.class);

        // Crear ingreso de materia prima
        IngresoMateriaPrima ingreso1 = new IngresoMateriaPrima(
                new Date(),
                materiaPrima,
                productoraAgricola,
                20,
                new Date("10/3/2024"),
                'S',
                modoAlmacenamiento,
                new Date()
        );
        ingresoMateriaPrimaDAO.create(ingreso1);

        materiaPrima.setCantidad(materiaPrima.getCantidad() + ingreso1.getCantidad());
        materiaPrimaDAO.update(materiaPrima);

        System.out.println("Nuevo ingreso de materia prima: " + ingreso1);

        // Crear ingreso de materia prima
        IngresoMateriaPrima ingreso2 = new IngresoMateriaPrima(
                new Date(),
                azucar,
                productoraAgricola,
                10,
                new Date("25/5/2024"),
                'N',
                modoAlmacenamiento,
                new Date()
        );
        ingresoMateriaPrimaDAO.create(ingreso2);
        System.out.println("Nuevo ingreso de materia prima: " + ingreso2);

        // Actualizar un ingreso de materia prima
        ingreso1.setAgroecologico('N');
        ingresoMateriaPrimaDAO.update(ingreso1);
        System.out.println("Se actualizó el ingreso de materia prima: " + ingreso1);

        // Buscar un ingreso de materia prima
        IngresoMateriaPrima ingresoMateriaPrima = ingresoMateriaPrimaDAO.find(1L);
        System.out.println("Se recuperó el ingreso de materia prima: " + ingresoMateriaPrima);

        // Listar todos los ingresos de materia prima
        List<IngresoMateriaPrima> ingresosMateriaPrima = ingresoMateriaPrimaDAO.findAll();
        System.out.println("Lista de ingresos de materia prima: " + ingresosMateriaPrima);

        // Eliminar un ingreso de materia prima
        ingresoMateriaPrimaDAO.delete(ingreso2);
        ingresosMateriaPrima = ingresoMateriaPrimaDAO.findAll();
        System.out.println("Se eliminó el ingreso de materia prima. Lista de ingresos de materia prima actualizada: " + ingresosMateriaPrima);





        System.out.println(
                "--------------------------------------------------PRODUCTO--------------------------------------------------"
        );

        GenericDAO<Producto, Long> productoDAO = new GenericDAO<>(Producto.class);

        // Crear producto
        Producto productoMermeladaDeTomate = new Producto(
                "Mermelada de tomate",
                "Mermelada hecha a base de tomates cuidadosamente seleccionados.",
                "unidad",
                0,
                null
        );
        productoDAO.create(productoMermeladaDeTomate);
        System.out.println("Nuevo producto: " + productoMermeladaDeTomate.toString());

        // Crear producto
        Producto productoBerenjenasAlEscabeche = new Producto(
                "Berenjenas al escabeche",
                "Conserva de berenjenas avinagradas, condimentadas con ajo y perejil.",
                "unidad",
                0,
                null
        );
        productoDAO.create(productoBerenjenasAlEscabeche);
        System.out.println("Nuevo producto: " + productoBerenjenasAlEscabeche.toString());

        // Crear producto
        Producto productoMermeladaDeFrutilla = new Producto(
                "Mermelada de frutilla",
                "Mermelada hecha a base de frutillas cuidadosamente seleccionadas.",
                "unidad",
                0,
                null
        );
        productoDAO.create(productoMermeladaDeFrutilla);
        System.out.println("Nuevo producto: " + productoMermeladaDeFrutilla.toString());

        // Actualizar un producto
        productoMermeladaDeTomate.setStock(productoMermeladaDeTomate.getStock() + 20);
        productoDAO.update(productoMermeladaDeTomate);
        System.out.println("Se actualizó el producto: " + productoMermeladaDeTomate.toString());

        // Buscar un producto
        Producto producto = productoDAO.find(1L);
        System.out.println("Se recuperó el producto: " + producto.toString());

        // Listar todos los productos
        List<Producto> listaProductos = productoDAO.findAll();
        System.out.println("Lista de productos: " + listaProductos);

        // Eliminar un producto
        productoDAO.delete(productoMermeladaDeFrutilla);
        listaProductos = productoDAO.findAll();
        System.out.println("Producto eliminado. Lista de productos actualizada: " + listaProductos);





        System.out.println(
                "--------------------------------------PRESENTACION DE PRODUCTO--------------------------------------"
        );

        GenericDAO<PresentacionProducto, Long> presentacionProductoDAO = new GenericDAO<>(PresentacionProducto.class);

        // Crear presentación de producto
        PresentacionProducto presentacionProducto1 = new PresentacionProducto(
                "Mermelada de tomate x 500gr",
                productoMermeladaDeTomate,
                0,
                null
        );
        presentacionProductoDAO.create(presentacionProducto1);
        System.out.println("Nueva presentación de producto: " + presentacionProducto1.toString());

        // Crear presentación de producto
        PresentacionProducto presentacionProducto2 = new PresentacionProducto(
                "Berenjenas al escabeche x 250gr",
                productoBerenjenasAlEscabeche,
                0,
                null
        );
        presentacionProductoDAO.create(presentacionProducto2);
        System.out.println("Nueva presentación de producto: " + presentacionProducto2.toString());

        // Actualizar una presentación de producto
        presentacionProducto1.setStock(60);
        presentacionProductoDAO.update(presentacionProducto1);
        System.out.println("Se actualizó la presentación de producto: " + presentacionProducto1.toString());

        // Buscar una presentación de producto
        PresentacionProducto presentacionProducto = presentacionProductoDAO.find(1L);
        System.out.println("Se recuperó la presentación de producto: " + presentacionProducto.toString());

        // Listar todas las presentaciones de productos
        List<PresentacionProducto> listaPresentacionesProducto = presentacionProductoDAO.findAll();
        System.out.println("Lista de presentaciones de productos: " + listaPresentacionesProducto);

        // Eliminar una presentación de producto
        presentacionProductoDAO.delete(presentacionProducto2);
        listaPresentacionesProducto = presentacionProductoDAO.findAll();
        System.out.println("Presentación de producto eliminada. Lista de presentaciones de productos actualizada: " + listaPresentacionesProducto);





        System.out.println(
            "-----------------------------------------------RECETAS-----------------------------------------------"
        );

        GenericDAO<Receta, Long> recetaDAO = new GenericDAO<>(Receta.class);

        // Crear nueva receta
        Receta recetaMermeladaTomate = new Receta(
                "Mermelada de tomate",
                "10",
                "1 hora y 30 minutos",
                null,
                productoMermeladaDeTomate
        );
        recetaDAO.create(recetaMermeladaTomate);
        System.out.println("Nueva receta: " + recetaMermeladaTomate.toString());

        // Crear nueva receta
        Receta recetaBerenjenas = new Receta(
                "Berenjenas al escabeche",
                "10",
                "2 horas",
                null,
                productoBerenjenasAlEscabeche
        );
        recetaDAO.create(recetaBerenjenas);
        System.out.println("Nueva receta: " + recetaBerenjenas.toString());

        // Crear nueva receta
        Receta recetaMermeladaFrutilla = new Receta(
                "Mermelada de frutilla",
                "10",
                "2 horas",
                null,
                productoMermeladaDeTomate
        );
        recetaDAO.create(recetaMermeladaFrutilla);
        System.out.println("Nueva receta: " + recetaMermeladaFrutilla.toString());

        // Actualizar una receta
        recetaBerenjenas.setPorcion("20");
        recetaDAO.update(recetaBerenjenas);
        System.out.println("Se actualizó la receta: " + recetaBerenjenas.toString());

        // Buscar una receta
        Receta receta = recetaDAO.find(1L);
        System.out.println("Se recuperó la receta: " + receta.toString());

        // Listar todas las recetas
        List<Receta> listaRecetas = recetaDAO.findAll();
        System.out.println("Lista de recetas: " + listaRecetas);

        // Eliminar una receta
        recetaDAO.delete(recetaMermeladaFrutilla);
        listaRecetas = recetaDAO.findAll();
        System.out.println("Se eliminó la receta. Lista de recetas actualizada: " + listaRecetas);




        System.out.println(
                "------------------------------------------PASOS DE RECETA---------------------------------------------"
        );

        GenericDAO<PasoReceta, Long> pasoRecetaDAO = new GenericDAO<>(PasoReceta.class);

        // Crear pasos de receta
        // Paso 1
        PasoReceta paso1 = new PasoReceta(
                recetaMermeladaTomate,
                1,
                "Cortar los tomates maduros con piel y semillas en cubos regulares pequeños."
        );
        pasoRecetaDAO.create(paso1);
        System.out.println("Se registró un nuevo paso para la receta " + paso1.getReceta().getDescripcion() + ": " + paso1.toString());

        // Paso 2
        PasoReceta paso2 = new PasoReceta(
                recetaMermeladaTomate,
                2,
                "Colocar en un bol con azúcar, cubrir con papel film y dejar reposar por una noche en la heladera, para que suelte todo su jugo."
        );
        pasoRecetaDAO.create(paso2);
        System.out.println("Se registró un nuevo paso para la receta " + paso2.getReceta().getDescripcion() + ": " + paso2.toString());

        // Paso 3
        PasoReceta paso3 = new PasoReceta(
                recetaMermeladaTomate,
                3,
                "Colocar medio tomate con un clavo de olor para aportar mayor sabor a la preparación."
        );
        pasoRecetaDAO.create(paso3);
        System.out.println("Se registró un nuevo paso para la receta " + paso3.getReceta().getDescripcion() + ": " + paso3.toString());

        // Paso 4
        PasoReceta paso4 = new PasoReceta(
                recetaMermeladaTomate,
                4,
                "Colocar los tomates con su jugo dentro de una cacerola junto con una rama de canela."
        );
        pasoRecetaDAO.create(paso4);
        System.out.println("Se registró un nuevo paso para la receta " + paso4.getReceta().getDescripcion() + ": " + paso4.toString());

        // Paso 5
        PasoReceta paso5 = new PasoReceta(
                recetaMermeladaTomate,
                5,
                "Llevar al fuego y dejar cocinar a fuego bajo hasta que los tomates se deshagan y la preparación tome punto."
        );
        pasoRecetaDAO.create(paso5);
        System.out.println("Se registró un nuevo paso para la receta " + paso5.getReceta().getDescripcion() + ": " + paso5.toString());

        // Paso 6
        PasoReceta paso6 = new PasoReceta(
                recetaMermeladaTomate,
                6,
                "Para verificar el punto colocar una cucharada de mermelada en un platito, dejar que se enfrie y pasarle el dedo o una espátula de goma para hacer un surco. Si se mantiene el surco está lista, si se vuelve a unir le falta cocción."
        );
        pasoRecetaDAO.create(paso6);
        System.out.println("Se registró un nuevo paso para la receta " + paso6.getReceta().getDescripcion() + ": " + paso6.toString());

        // Actualizar un paso de receta
        paso1.setIndicacion("Cortar los tomates maduros con piel y semillas en cubos regulares medianos.");
        pasoRecetaDAO.update(paso1);
        System.out.println("Se actualizó la receta: " + recetaMermeladaTomate.toString());

        // Buscar un paso de receta
        PasoReceta pasoReceta = pasoRecetaDAO.find(1L);
        System.out.println("Se recuperó el paso de receta: " + pasoReceta.toString());

        // Listar todos los pasos de receta
        List<PasoReceta> listaPasosReceta = pasoRecetaDAO.findAll();
        System.out.println("Lista de pasos de receta: " + listaPasosReceta);

        // Eliminar un paso de receta
        pasoRecetaDAO.delete(paso6);
        listaPasosReceta = pasoRecetaDAO.findAll();
        System.out.println("Se eliminó el paso de receta. Lista de pasos de recetas actualizada: " + listaPasosReceta);





        System.out.println(
                "--------------------------------------------INGREDIENTES--------------------------------------------"
        );

        GenericDAO<Ingrediente, Long> ingredienteDAO = new GenericDAO<>(Ingrediente.class);

        // Crear ingrediente
        Ingrediente ingrediente1 = new Ingrediente(
                recetaMermeladaTomate,
                tomate,
                200.0
        );
        ingredienteDAO.create(ingrediente1);
        System.out.println("Nuevo ingrediente: " + ingrediente1.toString());

        // Crear ingrediente
        Ingrediente ingrediente2 = new Ingrediente(
                recetaMermeladaTomate,
                azucar,
                50.0
        );
        ingredienteDAO.create(ingrediente2);
        System.out.println("Nuevo ingrediente: " + ingrediente2.toString());

        // Actualizar un ingrediente
        ingrediente1.setCantidad(250.0);
        ingredienteDAO.update(ingrediente1);
        System.out.println("Se actualizó el ingrediente: " + ingrediente1.toString());

        // Buscar un ingrediente
        Ingrediente ingrediente = ingredienteDAO.find(1L);
        System.out.println("Se recuperó el ingrediente de receta: " + ingrediente.toString());

        // Listar todos los ingredientes
        List<Ingrediente> listaIngredientes = ingredienteDAO.findAll();
        System.out.println("Lista de ingredientes: " + listaIngredientes);

        // Eliminar un ingrediente
        ingredienteDAO.delete(ingrediente2);
        listaIngredientes = ingredienteDAO.findAll();
        System.out.println("Ingrediente eliminado. Lista de ingredientes actualizada: " + listaIngredientes);




        System.out.println(
                "------------------------------------------ELABORACIONES----------------------------------------------"
        );

        GenericDAO<Elaboracion, Long> elaboracionDAO = new GenericDAO<>(Elaboracion.class);

        // Crear elaboración
        Elaboracion elaboracion1 = new Elaboracion(
                new Date(),
                null,
                recetaMermeladaTomate,
                100.0,
                null
        );
        elaboracionDAO.create(elaboracion1);
        System.out.println("Nueva elaboración: " + elaboracion1.toString());

        // Crear elaboración
        Elaboracion elaboracion2 = new Elaboracion(
                new Date(),
                null,
                recetaBerenjenas,
                150.0,
                null
        );
        elaboracionDAO.create(elaboracion2);
        System.out.println("Nueva elaboración: " + elaboracion2.toString());

        // Crear elaboración
        Elaboracion elaboracion3 = new Elaboracion(
                new Date(),
                null,
                recetaBerenjenas,
                100.0,
                null
        );
        elaboracionDAO.create(elaboracion3);
        System.out.println("Nueva elaboración: " + elaboracion3.toString());

        // Crear elaboración
        Elaboracion elaboracion4 = new Elaboracion(
                new Date(),
                null,
                recetaMermeladaTomate,
                100.0,
                null
        );
        elaboracionDAO.create(elaboracion4);
        System.out.println("Nueva elaboración: " + elaboracion4.toString());

        // Actualizar una elaboración
        elaboracion1.setCantidadProducida(120.0);
        elaboracionDAO.update(elaboracion1);
        System.out.println("Se actualizó la elaboración: " + elaboracion1.toString());

        // Buscar una elaboración
        Elaboracion elaboracion = elaboracionDAO.find(1L);
        System.out.println("Se recuperó la elaboración: " + elaboracion.toString());

        // Listar todas las elaboraciones
        List<Elaboracion> listaElaboraciones = elaboracionDAO.findAll();
        System.out.println("Lista de elaboraciones: " + listaElaboraciones);

        // Eliminar una elaboración
        elaboracionDAO.delete(elaboracion4);
        listaElaboraciones = elaboracionDAO.findAll();
        System.out.println("Elaboración eliminada. Lista de elaboraciones actualizada: " + listaElaboraciones);




        System.out.println(
            "----------------------------------------NOTAS DE ELABORACIÓN------------------------------------------"
        );

        GenericDAO<NotaElaboracion, Long> notaElaboracionDAO = new GenericDAO<>(NotaElaboracion.class);

        // Crear nota de elaboración
        NotaElaboracion nota1 = new NotaElaboracion(
                elaboracion,
                paso1,
                "Agregar azúcar a gusto."
        );
        notaElaboracionDAO.create(nota1);
        System.out.println("Nueva nota de elaboración: " + nota1.toString());

        // Actualizar una nota de elaboración
        nota1.setObservacion("Agregar azúcar y canela al gusto.");
        notaElaboracionDAO.update(nota1);
        System.out.println("Se actualizó la nota de elaboración: " + nota1.toString());

        // Buscar una nota de elaboración
        NotaElaboracion notaElaboracion = notaElaboracionDAO.find(1L);
        System.out.println("Se recuperó la nota de elaboración: " + notaElaboracion.toString());

        // Listar todas las notas de elaboración
        List<NotaElaboracion> listaNotasElaboracion = notaElaboracionDAO.findAll();
        System.out.println("Lista de notas de elaboraciones: " + listaPasosReceta);

        // Eliminar una nota de elaboración
        notaElaboracionDAO.delete(nota1);
        listaNotasElaboracion = notaElaboracionDAO.findAll();
        System.out.println("Nota de elaboración eliminada. Lista de notas de elaboración actualizada: " + listaNotasElaboracion);




        System.out.println(
                "---------------------------------------------LOTES---------------------------------------------"
        );

        GenericDAO<Lote, Long> loteDAO = new GenericDAO<>(Lote.class);

        // Crear lote
        Lote lote1 = new Lote(
                100,
                new Date(),
                elaboracion1,
                null
        );
        loteDAO.create(lote1);
        System.out.println("Nuevo lote: " + lote1);

        // Crear lote
        Lote lote2 = new Lote(
                150,
                new Date(),
                elaboracion2,
                null
        );
        loteDAO.create(lote2);
        System.out.println("Nuevo lote: " + lote2.toString());

        // Crear lote
        Lote lote3 = new Lote(
                150,
                new Date(),
                elaboracion3,
                null
        );
        loteDAO.create(lote3);
        System.out.println("Nuevo lote: " + lote3.toString());

        // Actualizar un lote
        lote1.setCantidadProductos(120);
        loteDAO.update(lote1);
        System.out.println("Se modificó el lote: " + lote1.toString());

        // Buscar un lote
        Lote lote = loteDAO.find(1L);
        System.out.println("Se recuperó el lote: " + lote.toString());

        // Listar todos los lotes
        List<Lote> listaLotes = loteDAO.findAll();
        System.out.println("Lista de lotes: " + listaLotes);

        // Eliminar un lote
        loteDAO.delete(lote3);
        listaLotes = loteDAO.findAll();
        System.out.println("Lote eliminado. Lista de lotes actualizada: " + listaLotes);





        System.out.println(
                "---------------------------------------------LOTE PRESENTACION PRODUCTO DETALLE---------------------------------------------"
        );

        GenericDAO<LotePresentacionProductoDetalle, Long> lotePresentacionProductoDetalleDAO = new GenericDAO<>(LotePresentacionProductoDetalle.class);

        // Crear detalle de lote
        LotePresentacionProductoDetalle loteDetalle1 = new LotePresentacionProductoDetalle(
                lote1,
                presentacionProducto1,
                50.0,
                0.5
        );
        lotePresentacionProductoDetalleDAO.create(loteDetalle1);
        System.out.println("Nuevo detalle de lote creado: " + loteDetalle1.toString());

        // Crear presentación de producto
        PresentacionProducto presentacionProducto3 = new PresentacionProducto(
                "Mermelada de tomate x 1KG",
                productoMermeladaDeTomate,
                0,
                null
        );
        presentacionProductoDAO.create(presentacionProducto3);

        // Crear detalle de lote
        LotePresentacionProductoDetalle loteDetalle2 = new LotePresentacionProductoDetalle(
                lote2,
                presentacionProducto3,
                60.0,
                0.25
        );
        lotePresentacionProductoDetalleDAO.create(loteDetalle2);
        System.out.println("Nuevo detalle de lote creado: " + loteDetalle2.toString());

        // Actualizar un detalle de lote presentación producto
        loteDetalle1.setCostoUnitario(2500);
        lotePresentacionProductoDetalleDAO.update(loteDetalle1);
        System.out.println("Se actualizó el detalle de lote: " + loteDetalle1.toString());

        // Buscar un detalle de lote presentación producto
        LotePresentacionProductoDetalle loteDetalle = lotePresentacionProductoDetalleDAO.find(1L);
        System.out.println("Se recuperó el detalle de lote: " + loteDetalle.toString());

        // Listar todos los detalles de lote presentación producto
        List<LotePresentacionProductoDetalle> listaDetalles = lotePresentacionProductoDetalleDAO.findAll();
        System.out.println("Lista de detalle de lotes: " + listaDetalles);

        // Eliminar un detalle de lote presentación producto
        lotePresentacionProductoDetalleDAO.delete(loteDetalle2);
        listaDetalles = lotePresentacionProductoDetalleDAO.findAll();
        System.out.println("Detalle de lote presentación producto eliminado. Lista de detalles actualizada: " + listaDetalles);




        System.out.println(
                "------------------------------------------TIPOS DE INSUMOS--------------------------------------------"
        );

        GenericDAO<TipoInsumo, Long> tipoInsumoDAO = new GenericDAO<>(TipoInsumo.class);

        // Crear tipo de insumo
        TipoInsumo tipoInsumoEnvasado = new TipoInsumo(
                "Envasado",
                null
        );
        tipoInsumoDAO.create(tipoInsumoEnvasado);
        System.out.println("Nuevo tipo de insumo: " + tipoInsumoEnvasado.toString());

        // Crear tipo de insumo
        TipoInsumo tipoInsumoLimpieza = new TipoInsumo(
                "Limpieza",
                null
        );
        tipoInsumoDAO.create(tipoInsumoLimpieza);
        System.out.println("Nuevo tipo de insumo: " + tipoInsumoLimpieza.toString());

        // Actualizar tipo de insumo
        tipoInsumoEnvasado.setDescripcion("Este tipo de insumos se utiliza para crear los envases de las presentaciones de los productos finales");
        tipoInsumoDAO.update(tipoInsumoEnvasado);
        System.out.println("Se actualizó el tipo de insumo: " + tipoInsumoEnvasado.toString());

        // Buscar un tipo de insumo
        TipoInsumo tipoInsumo = tipoInsumoDAO.find(1L);
        System.out.println("Se recuperó el tipo de insumo: " + tipoInsumo.toString());

        // Listar todos los tipos de insumo
        List<TipoInsumo> listaTiposInsumo = tipoInsumoDAO.findAll();
        System.out.println("Lista de tipos de insumo: " + listaTiposInsumo);

        // Eliminar un tipo de insumo
        tipoInsumoDAO.delete(tipoInsumoLimpieza);
        listaTiposInsumo = tipoInsumoDAO.findAll();
        System.out.println("Tipo de insumo eliminado. Lista de tipos de insumo actualizada: " + listaTiposInsumo);





        System.out.println(
                "---------------------------------------------INSUMOS--------------------------------------------------"
        );

        GenericDAO<Insumo, Long> insumoDAO = new GenericDAO<>(Insumo.class);

        // Crear insumo
        Insumo olla10lt = new Insumo(
                "Olla",
                "Olla de acero inoxidable de 10lt de capacidad",
                5,
                "10lt",
                tipoInsumoEnvasado
        );
        insumoDAO.create(olla10lt);
        System.out.println("Nuevo insumo: " + olla10lt.toString());

        // Crear insumo
        Insumo cucharaGastronomica = new Insumo(
                "Cuchara gastronómica",
                "Cuchara gastronómica para cocinar en grandes cantidades",
                8,
                null,
                tipoInsumoEnvasado
        );
        insumoDAO.create(cucharaGastronomica);
        System.out.println("Nuevo insumo: " + cucharaGastronomica.toString());

        // Actualizar un insumo
        cucharaGastronomica.setCantidad(10);
        insumoDAO.update(cucharaGastronomica);
        System.out.println("Se modificó el insumo: " + cucharaGastronomica.toString());

        // Buscar un insumo
        Insumo insumo = insumoDAO.find(1L);
        System.out.println("Se recuperó el insumo: " + insumo.toString());

        // Listar todos los insumos
        List<Insumo> listaInsumos = insumoDAO.findAll();
        System.out.println("Lista de insumos: " + listaInsumos);

        // Eliminar un insumo
        insumoDAO.delete(cucharaGastronomica);
        listaInsumos = insumoDAO.findAll();
        System.out.println("Insumo eliminado. Lista de insumos actualizada: " + listaInsumos);





        System.out.println(
            "---------------------------------------------INGRESO DE INSUMO--------------------------------------------"
        );

        GenericDAO<IngresoInsumo, Long> ingresoInsumoDAO = new GenericDAO<>(IngresoInsumo.class);

        Insumo bolsaZiploc = new Insumo(
                "Bolsa Ziploc",
                "Bolsas de plástico con cierre hermético que se asegura de que el contenido permanezca fresco y libre de aire",
                0.0,
                "500gr",
                tipoInsumoEnvasado
        );

        insumoDAO.create(bolsaZiploc);

        // Crear ingreso de insumo
        IngresoInsumo ingresoDeInsumoDelDia = new IngresoInsumo(
                bolsaZiploc,
                new Date(),
                500.0,
                50.0,
                "Ingreso de bolsas ziploc del día"
        );
        ingresoInsumoDAO.create(ingresoDeInsumoDelDia);
        System.out.println("Nuevo ingreso de insumo: " + ingresoDeInsumoDelDia.toString());

        // Actualizar un ingreso de insumo
        ingresoDeInsumoDelDia.setCantidad(60);
        ingresoInsumoDAO.update(ingresoDeInsumoDelDia);
        System.out.println("Se actualizó el ingreso de insumo: " + ingresoDeInsumoDelDia.toString());

        // Buscar un ingreso de insumo
        IngresoInsumo ingresoInsumo = ingresoInsumoDAO.find(1L);
        System.out.println("Se recuperó el ingreso de insumo: " + ingresoInsumo.toString());

        // Listar todos los ingresos de insumo
        List<IngresoInsumo> listaIngresosInsumo = ingresoInsumoDAO.findAll();
        System.out.println("Lista de ingresos de insumo: " + listaIngresosInsumo);

        // Eliminar un ingreso de insumo
        ingresoInsumoDAO.delete(ingresoDeInsumoDelDia);
        listaIngresosInsumo = ingresoInsumoDAO.findAll();
        System.out.println("Ingreso de insumo eliminado. Lista de ingresos de insumo actualizada: " + listaIngresosInsumo);
    }

    public void destroy() {
    }
}