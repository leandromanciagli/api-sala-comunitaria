API Sala Comunitaria de Elaboración de Productos con Agregado de Valor de
la Agricultura Familiar

Instrucciones de uso

1. Clonar el proyecto:

    - Por SSH:
      -     git@gitlab.catedras.linti.unlp.edu.ar:jyaa_2024/jyaa2024_grupo10.git
       
   - Por HTTP: 
     -      https://gitlab.catedras.linti.unlp.edu.ar/jyaa_2024/jyaa2024_grupo10.git
2. Crear base de datos:
   - Desde MySQL Workbench o linea de comandos de MySQL ingresando con usuario administrador ejecutar:
     -      CREATE DATABASE jyaa-grupo10;
3. Abrir desde IDE para ejecutar
   - IntellIJ:
     - Crear configuración de ejecución:
       - Agregar servidor TomCat
       - Agregar artifact war exploded
     - Ejecutar mvn install para instalar dependencias desde pom.xml
     - Ejecutar 'Run' desde el menu superior.
4. Al abrirse el navegador clickear en el link 'Test Servlet' para ejecutar ABM de entidades.
5. Acceder al recurso /openapi para ver documentación Swagger de servicios Rest.