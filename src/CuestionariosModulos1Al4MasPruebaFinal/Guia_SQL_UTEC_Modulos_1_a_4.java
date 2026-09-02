public class Guia_SQL_UTEC_Modulos_1_a_4 {

    public static void main(String[] args) {

        /*
        ======================================================================
        GUÍA UNIFICADA SQL / PostgreSQL - UTEC
        MÓDULOS 1, 2, 3 y 4 + PRE-EVALUACIÓN
        ======================================================================

        OBJETIVO:
        - Tener todo en un solo archivo Java.
        - El archivo compila porque todo el SQL está dentro de comentarios.
        - Incluye teoría, sintaxis, ejemplos, trampas de Moodle y diferencias
          importantes con PostgreSQL real.
        - Pensado para preguntas múltiple opción y análisis de código.

        ======================================================================
        MAPA RÁPIDO
        ======================================================================

        MÓDULO 1
        - Introducción a SQL
        - Sintaxis, tipos de datos
        - Usuarios, roles y privilegios
        - Bases de datos y esquemas
        - Restricciones y dominios
        - CREATE / ALTER / DROP
        - INSERT / UPDATE / DELETE
        - SELECT básico

        MÓDULO 2
        - Expresiones regulares y LIKE
        - Agregación
        - GROUP BY / HAVING
        - DISTINCT / LIMIT
        - JOIN
        - Subconsultas
        - Funciones de texto
        - Funciones de fecha

        MÓDULO 3
        - Roles, usuarios y privilegios
        - Transacciones
        - Alta, baja y modificación de bases
        - Vistas
        - Índices
        - Tablespaces
        - Logs y reinicio

        MÓDULO 4
        - PL/pgSQL
        - Parámetros IN / OUT / INOUT
        - %TYPE / %ROWTYPE
        - IF / ELSIF / ELSE
        - FOR / WHILE / LOOP / EXIT
        - Procedimientos
        - Funciones
        - Triggers

        ======================================================================
        */


        // ==================================================================
        // MÓDULO 1 - FUNDAMENTOS SQL
        // ==================================================================

        /*
        ----------------------------------------------------------------------
        1. SUBLENGUAJES SQL
        ----------------------------------------------------------------------

        DDL = Data Definition Language
        -> estructura de la base

        Comandos típicos:
        CREATE
        ALTER
        DROP


        DML = Data Manipulation Language
        -> trabajar con datos

        Comandos típicos:
        SELECT
        INSERT
        UPDATE
        DELETE


        DCL = Data Control Language
        -> permisos

        Comandos:
        GRANT
        REVOKE


        TCL = Transaction Control Language
        -> transacciones

        Comandos:
        BEGIN
        COMMIT
        ROLLBACK
        SAVEPOINT


        CHULETA:

        DDL -> estructura
        DML -> datos
        DCL -> permisos
        TCL -> transacciones
        */


        /*
        ----------------------------------------------------------------------
        2. SELECT
        ----------------------------------------------------------------------

        SELECT se utiliza para recuperar datos.

        SELECT * FROM empleados;

        * significa:
        todas las columnas.


        Seleccionar columnas específicas:

        SELECT nombre, salario
        FROM empleados;


        IMPORTANTE:

        Las columnas se separan con COMAS.

        CORRECTO:
        SELECT nombre, salario FROM empleados;

        INCORRECTO:
        SELECT nombre salario FROM empleados;
        */


        /*
        ----------------------------------------------------------------------
        3. WHERE
        ----------------------------------------------------------------------

        WHERE filtra FILAS.

        SELECT *
        FROM empleados
        WHERE edad > 30;


        Operadores:

        =
        <>
        !=
        >
        <
        >=
        <=


        AND:
        ambas condiciones deben cumplirse.

        SELECT *
        FROM empleados
        WHERE edad >= 18
        AND activo = true;


        OR:
        alcanza con una condición.

        NOT:
        niega una condición.
        */


        /*
        ----------------------------------------------------------------------
        4. IN Y NOT IN
        ----------------------------------------------------------------------

        IN:
        incluido en una lista

        SELECT *
        FROM empleados
        WHERE departamento IN (1, 2, 3);


        NOT IN:
        excluir valores

        SELECT *
        FROM empleados
        WHERE departamento NOT IN (1, 2, 3);


        MEMORIA:

        IN     -> incluir
        NOT IN -> excluir
        */


        /*
        ----------------------------------------------------------------------
        5. BETWEEN
        ----------------------------------------------------------------------

        BETWEEN incluye los extremos.

        SELECT *
        FROM libros
        WHERE anio_publicacion BETWEEN 2000 AND 2010;


        Equivale conceptualmente a:

        anio_publicacion >= 2000
        AND
        anio_publicacion <= 2010
        */


        /*
        ----------------------------------------------------------------------
        6. INSERT
        ----------------------------------------------------------------------

        INSERT INTO tabla (columnas)
        VALUES (valores);


        Ejemplo:

        INSERT INTO empleados (nombre, salario)
        VALUES ('Ana', 50000);


        Si id es SERIAL:
        normalmente NO lo ingresamos manualmente.


        MULTI-INSERT:

        INSERT INTO departamentos (nombre, ubicacion)
        VALUES
        ('Recursos Humanos', 'Piso 1'),
        ('Finanzas', 'Piso 2'),
        ('Marketing', 'Piso 3');


        INSERT ... SELECT:

        INSERT INTO empleados_backup (nombre, salario)
        SELECT nombre, salario
        FROM empleados;


        IMPORTANTE:
        INSERT ... SELECT NO lleva VALUES.
        */


        /*
        ----------------------------------------------------------------------
        7. UPDATE
        ----------------------------------------------------------------------

        UPDATE empleados
        SET salario = 50000
        WHERE id = 1;


        AUMENTAR 10%:

        UPDATE empleados
        SET salario = salario * 1.10;


        PELIGRO:
        UPDATE sin WHERE modifica TODAS las filas.
        */


        /*
        ----------------------------------------------------------------------
        8. DELETE / TRUNCATE / DROP
        ----------------------------------------------------------------------

        DELETE:
        elimina filas y puede usar WHERE.

        DELETE FROM clientes
        WHERE fecha_registro < '2023-01-01';


        TRUNCATE:
        vacía toda la tabla.
        No usa WHERE.

        TRUNCATE TABLE clientes;


        DROP TABLE:
        elimina la estructura completa.

        DROP TABLE clientes;


        DIFERENCIA:

        DELETE   -> filas
        TRUNCATE -> todas las filas rápidamente
        DROP     -> objeto completo


        PostgreSQL:
        TRUNCATE no reinicia automáticamente secuencias
        salvo que se use:

        TRUNCATE TABLE tabla RESTART IDENTITY;
        */


        /*
        ----------------------------------------------------------------------
        9. TIPOS DE DATOS
        ----------------------------------------------------------------------

        INTEGER
        -> enteros

        DECIMAL / NUMERIC
        -> números decimales exactos

        VARCHAR(n)
        -> texto longitud variable

        CHAR(n)
        -> texto longitud fija

        TEXT
        -> texto

        DATE
        -> fecha

        TIME
        -> hora

        TIMESTAMP
        -> fecha + hora

        TIMESTAMPTZ
        -> fecha + hora + zona horaria


        CHAR vs VARCHAR:

        CHAR    -> fijo
        VARCHAR -> variable
        */


        /*
        ----------------------------------------------------------------------
        10. SERIAL
        ----------------------------------------------------------------------

        SERIAL se usa para IDs autoincrementales.

        CREATE TABLE empleados (
            id SERIAL PRIMARY KEY,
            nombre VARCHAR(100)
        );


        INSERT:

        INSERT INTO empleados (nombre)
        VALUES ('Ana');

        El id se genera automáticamente.
        */


        /*
        ----------------------------------------------------------------------
        11. COMENTARIOS SQL
        ----------------------------------------------------------------------

        Una línea:

        -- comentario


        Varias líneas:

        / *
        comentario
        varias líneas
        * /


        En los comentarios Java de este archivo se dejó espacio entre / y *
        para evitar cerrar accidentalmente el comentario Java.
        */


        /*
        ----------------------------------------------------------------------
        12. RESTRICCIONES
        ----------------------------------------------------------------------

        PRIMARY KEY
        -> identifica una fila
        -> UNIQUE + NOT NULL

        FOREIGN KEY
        -> integridad referencial

        UNIQUE
        -> no permite valores duplicados

        NOT NULL
        -> valor obligatorio

        CHECK
        -> valida condición


        Ejemplo:

        CREATE TABLE personas (
            id SERIAL PRIMARY KEY,
            edad INTEGER CHECK (edad >= 0),
            email VARCHAR(100) UNIQUE
        );
        */


        /*
        ----------------------------------------------------------------------
        13. FOREIGN KEY
        ----------------------------------------------------------------------

        CREATE TABLE pedidos (
            id SERIAL PRIMARY KEY,
            cliente_id INTEGER,
            FOREIGN KEY (cliente_id)
            REFERENCES clientes(id)
        );


        FK:
        garantiza que el valor referenciado exista.
        */


        /*
        ----------------------------------------------------------------------
        14. DOMINIOS
        ----------------------------------------------------------------------

        Un DOMAIN es un tipo personalizado reutilizable.

        CREATE DOMAIN dom_matricula AS VARCHAR(10)
        CHECK (VALUE <> '');


        Luego:

        CREATE TABLE vehiculos (
            matricula dom_matricula
        );
        */


        /*
        ----------------------------------------------------------------------
        15. CREATE / ALTER / DROP TABLE
        ----------------------------------------------------------------------

        CREATE TABLE:

        CREATE TABLE empleados (
            id SERIAL PRIMARY KEY,
            nombre VARCHAR(100)
        );


        AGREGAR COLUMNA:

        ALTER TABLE empleados
        ADD COLUMN email VARCHAR(100);


        RENOMBRAR COLUMNA:

        ALTER TABLE empleados
        RENAME COLUMN nombre TO nombre_completo;


        RENOMBRAR TABLA:

        ALTER TABLE empleados
        RENAME TO trabajadores;


        ELIMINAR:

        DROP TABLE trabajadores;
        */


        /*
        ----------------------------------------------------------------------
        16. BASES DE DATOS Y ESQUEMAS
        ----------------------------------------------------------------------

        CREATE DATABASE universidad;

        CREATE DATABASE universidad
        OWNER jose;


        CREATE SCHEMA academico;

        CREATE SCHEMA academico
        AUTHORIZATION jose;


        Referenciar objeto:

        schema.tabla

        Ejemplo:

        SELECT *
        FROM academico.estudiantes;


        Eliminar schema con contenido:

        DROP SCHEMA academico CASCADE;


        CASCADE:
        elimina dependencias.

        RESTRICT:
        impide eliminar si existen dependencias.
        */


        // ==================================================================
        // MÓDULO 2 - CONSULTAS AVANZADAS
        // ==================================================================

        /*
        ----------------------------------------------------------------------
        17. LIKE / ILIKE
        ----------------------------------------------------------------------

        LIKE:
        patrones sensibles a mayúsculas/minúsculas según collation.

        ILIKE:
        búsqueda case-insensitive en PostgreSQL.


        %:
        cero o más caracteres

        _:
        exactamente UN carácter


        Contiene Juan:

        SELECT *
        FROM empleados
        WHERE nombre LIKE '%Juan%';


        Empieza con Juan:

        WHERE nombre LIKE 'Juan%';


        Termina con Juan:

        WHERE nombre LIKE '%Juan';


        Exactamente 3 caracteres terminando en bc:

        WHERE nombre ILIKE '_bc';
        */


        /*
        ----------------------------------------------------------------------
        18. EXPRESIONES REGULARES
        ----------------------------------------------------------------------

        PostgreSQL:

        ~
        -> regex sensible a mayúsculas

        ~*
        -> regex no sensible a mayúsculas


        ^abc
        -> comienza con abc

        abc$
        -> termina con abc


        [abc]
        -> un carácter del conjunto

        [^abc]
        -> un carácter que NO está en el conjunto


        +
        -> uno o más

        *
        -> cero o más

        ?
        -> cero o uno

        |
        -> OR


        Ejemplo:
        una letra + exactamente cuatro dígitos

        SELECT *
        FROM productos
        WHERE codigo ~ '^[A-Za-z]\d{4}$';
        */


        /*
        ----------------------------------------------------------------------
        19. FUNCIONES DE AGREGACIÓN
        ----------------------------------------------------------------------

        COUNT(*)
        -> todas las filas

        COUNT(columna)
        -> valores NO NULL

        SUM(columna)
        -> suma

        AVG(columna)
        -> promedio

        MAX(columna)
        -> máximo

        MIN(columna)
        -> mínimo


        Las agregaciones normalmente ignoran NULL,
        excepto COUNT(*), que cuenta filas.
        */


        /*
        ----------------------------------------------------------------------
        20. GROUP BY
        ----------------------------------------------------------------------

        Agrupa filas.

        SELECT producto,
               SUM(cantidad)
        FROM ventas
        GROUP BY producto;


        "total por producto"
        ->
        SUM + GROUP BY
        */


        /*
        ----------------------------------------------------------------------
        21. WHERE vs HAVING
        ----------------------------------------------------------------------

        WHERE:
        filtra FILAS antes del agrupamiento.

        HAVING:
        filtra GRUPOS después de agrupar.


        Ejemplo:

        SELECT producto,
               AVG(precio)
        FROM ventas
        GROUP BY producto
        HAVING SUM(cantidad) > 100;


        REGLA:

        condición normal -> WHERE
        condición sobre SUM/COUNT/AVG -> HAVING
        */


        /*
        ----------------------------------------------------------------------
        22. ORDEN DE CLÁUSULAS
        ----------------------------------------------------------------------

        Orden escrito:

        SELECT
        FROM
        WHERE
        GROUP BY
        HAVING
        ORDER BY
        LIMIT


        MUY IMPORTANTE:

        GROUP BY va ANTES de HAVING.


        En una pregunta de la pre-evaluación Moodle marcó una opción
        con HAVING antes de GROUP BY. La intención era reconocer
        AVG + SUM + HAVING, pero PostgreSQL real requiere:

        GROUP BY ...
        HAVING ...
        */


        /*
        ----------------------------------------------------------------------
        23. DISTINCT
        ----------------------------------------------------------------------

        Elimina duplicados.

        SELECT DISTINCT fecha_pedido
        FROM pedidos;


        COUNT DISTINCT:

        SELECT COUNT(DISTINCT nombre)
        FROM estudiantes;
        */


        /*
        ----------------------------------------------------------------------
        24. LIMIT
        ----------------------------------------------------------------------

        LIMIT limita cantidad de filas.

        SELECT *
        FROM empleados
        LIMIT 5;


        Últimas 5 fechas sin repetir:

        SELECT DISTINCT fecha_pedido
        FROM pedidos
        ORDER BY fecha_pedido DESC
        LIMIT 5;


        IMPORTANTE:
        LIMIT sin ORDER BY no garantiza un "top" lógico.
        */


        /*
        ----------------------------------------------------------------------
        25. DISTINCT ON
        ----------------------------------------------------------------------

        PostgreSQL:

        SELECT DISTINCT ON (id_cliente) *
        FROM pedidos
        ORDER BY id_cliente, fecha_pedido ASC;


        Se queda con la primera fila de cada grupo
        según ORDER BY.


        Último pedido:

        ORDER BY id_cliente, fecha_pedido DESC;
        */


        /*
        ----------------------------------------------------------------------
        26. JOIN
        ----------------------------------------------------------------------

        INNER JOIN
        -> solo coincidencias

        LEFT JOIN
        -> todo de la izquierda + coincidencias

        RIGHT JOIN
        -> todo de la derecha + coincidencias

        FULL JOIN
        -> todo de ambas + NULL donde no coinciden

        CROSS JOIN
        -> producto cartesiano


        INNER:

        SELECT c.nombre, p.fecha
        FROM clientes c
        INNER JOIN pedidos p
        ON c.id = p.id_cliente;


        LEFT:

        SELECT e.nombre, d.direccion
        FROM empleados e
        LEFT JOIN direcciones d
        ON e.id = d.id_empleado;
        */


        /*
        ----------------------------------------------------------------------
        27. MEMORIA DE JOINS
        ----------------------------------------------------------------------

        INNER
        -> intersección

        LEFT
        -> conserva izquierda

        RIGHT
        -> conserva derecha

        FULL
        -> conserva ambas


        Si LEFT JOIN tiene 100 filas en la tabla izquierda:
        todas esas filas pueden aparecer,
        aunque falte coincidencia en la derecha.
        */


        /*
        ----------------------------------------------------------------------
        28. JOIN + SUM + GROUP BY
        ----------------------------------------------------------------------

        Si preguntan:

        "total de compras por cliente"

        pensar:

        JOIN
        +
        SUM
        +
        GROUP BY


        Ejemplo:

        SELECT
            c.nombre,
            SUM(v.monto_total) AS total
        FROM clientes c
        JOIN ventas v
            ON c.id_cliente = v.id_cliente
        GROUP BY c.nombre;
        */


        /*
        ----------------------------------------------------------------------
        29. SUBCONSULTAS
        ----------------------------------------------------------------------

        Una subconsulta es una consulta dentro de otra.

        Puede aparecer en:

        SELECT
        FROM
        WHERE


        Ejemplo:

        SELECT producto
        FROM ventas
        WHERE precio >
        (
            SELECT AVG(precio)
            FROM ventas
        );


        Devuelve productos con precio mayor al promedio.
        */


        /*
        ----------------------------------------------------------------------
        30. IN / EXISTS / ESCALAR / CORRELACIONADA
        ----------------------------------------------------------------------

        IN:
        compara con varios valores.

        EXISTS:
        pregunta si existe al menos una fila.

        ESCALAR:
        devuelve un solo valor.

        CORRELACIONADA:
        usa columnas de la consulta externa.


        EXISTS:

        SELECT nombre
        FROM clientes c
        WHERE EXISTS (
            SELECT 1
            FROM pedidos p
            WHERE p.cliente_id = c.id
            AND p.estado = 'pendiente'
        );


        Subconsulta en FROM:
        se denomina tabla derivada / derived table.
        */


        /*
        ----------------------------------------------------------------------
        31. FUNCIONES DE TEXTO
        ----------------------------------------------------------------------

        LEFT(texto, n)
        -> primeros n caracteres

        RIGHT(texto, n)
        -> últimos n caracteres

        CONCAT(...)
        -> unir textos

        LENGTH(texto)
        -> cantidad de caracteres

        REPLACE(texto, viejo, nuevo)
        -> reemplazar


        Ejemplos:

        SELECT LEFT(nombre, 3)
        FROM usuarios;

        SELECT RIGHT(apellido, 2)
        FROM empleados;

        SELECT CONCAT(nombre, ' ', apellido)
        FROM personas;

        SELECT LENGTH(nombre)
        FROM personas;

        SELECT REPLACE(descripcion, 'nuevo', 'antiguo')
        FROM productos;
        */


        /*
        ----------------------------------------------------------------------
        32. COMBINAR FUNCIONES DE TEXTO
        ----------------------------------------------------------------------

        Usuario:
        primeros 3 de nombre + últimos 2 de apellido

        SELECT CONCAT(
            LEFT(nombre, 3),
            RIGHT(apellido, 2)
        ) AS usuario
        FROM empleados;


        Reemplazar y obtener longitud:

        SELECT LENGTH(
            REPLACE(descripcion, 'nuevo', 'antiguo')
        ) AS longitud
        FROM productos;


        Quitar últimos 3 caracteres y reemplazar a por x:

        SELECT REPLACE(
            LEFT(nombre_cliente, LENGTH(nombre_cliente) - 3),
            'a',
            'x'
        )
        FROM clientes;
        */


        /*
        ----------------------------------------------------------------------
        33. FECHAS
        ----------------------------------------------------------------------

        DATE
        -> fecha

        TIME
        -> hora

        TIMESTAMP
        -> fecha + hora

        TIMESTAMPTZ
        -> fecha + hora + zona horaria
        */


        /*
        ----------------------------------------------------------------------
        34. DATE_PART
        ----------------------------------------------------------------------

        DATE_PART('year', fecha)
        -> año

        DATE_PART('month', fecha)
        -> mes

        DATE_PART('day', fecha)
        -> día

        DATE_PART('hour', fecha)
        -> hora

        DATE_PART('minute', fecha)
        -> minuto

        DATE_PART('second', fecha)
        -> segundo

        DATE_PART('quarter', fecha)
        -> trimestre


        Ejemplo:

        SELECT DATE_PART(
            'minute',
            '2023-07-09 15:30:45'::TIMESTAMP
        );

        Resultado:
        30
        */


        /*
        ----------------------------------------------------------------------
        35. AÑO BISIESTO
        ----------------------------------------------------------------------

        SELECT DATE_PART(
            'day',
            '2024-02-29'::DATE
        );

        Resultado:
        29


        2024 es bisiesto.
        29/02/2024 es una fecha válida.
        */


        /*
        ----------------------------------------------------------------------
        36. QUARTER
        ----------------------------------------------------------------------

        Q1 -> enero, febrero, marzo
        Q2 -> abril, mayo, junio
        Q3 -> julio, agosto, septiembre
        Q4 -> octubre, noviembre, diciembre


        SELECT DATE_PART(
            'quarter',
            '2024-03-01'::DATE
        );

        Resultado:
        1
        */


        // ==================================================================
        // MÓDULO 3 - ADMINISTRACIÓN
        // ==================================================================

        /*
        ----------------------------------------------------------------------
        37. ROLES Y USUARIOS
        ----------------------------------------------------------------------

        PostgreSQL maneja roles.

        Crear rol con login:

        CREATE ROLE jose
        WITH LOGIN PASSWORD 'clave';


        También existe:

        CREATE USER jose PASSWORD 'clave';


        En PostgreSQL:
        CREATE USER es esencialmente CREATE ROLE con LOGIN.
        */


        /*
        ----------------------------------------------------------------------
        38. GRANT / REVOKE
        ----------------------------------------------------------------------

        GRANT
        -> DAR
        -> TO

        REVOKE
        -> QUITAR
        -> FROM


        Dar SELECT:

        GRANT SELECT
        ON TABLE empleados
        TO jose;


        Quitar:

        REVOKE SELECT
        ON TABLE empleados
        FROM jose;


        Quitar todo:

        REVOKE ALL
        ON TABLE empleados
        FROM jose;
        */


        /*
        ----------------------------------------------------------------------
        39. ASIGNAR ROL
        ----------------------------------------------------------------------

        GRANT rol_ventas
        TO user2;


        user2 pasa a ser miembro del rol.
        */


        /*
        ----------------------------------------------------------------------
        40. CONNECT / USAGE / SELECT / EXECUTE
        ----------------------------------------------------------------------

        CONNECT
        -> DATABASE

        USAGE
        -> SCHEMA / SEQUENCE

        SELECT
        -> TABLE / VIEW

        EXECUTE
        -> FUNCTION / PROCEDURE
        */


        /*
        ----------------------------------------------------------------------
        41. OWNER
        ----------------------------------------------------------------------

        Cambiar propietario de tabla:

        ALTER TABLE empleados
        OWNER TO administrador;


        Cambiar propietario de base:

        ALTER DATABASE universidad
        OWNER TO administrador;


        Cambiar propietario de tablespace:

        ALTER TABLESPACE espacio_datos
        OWNER TO administrador;
        */


        /*
        ----------------------------------------------------------------------
        42. TRANSACCIONES
        ----------------------------------------------------------------------

        BEGIN;
        ...
        COMMIT;


        BEGIN:
        inicia

        COMMIT:
        confirma

        ROLLBACK:
        deshace

        SAVEPOINT:
        marca un punto

        ROLLBACK TO:
        vuelve al punto
        */


        /*
        ----------------------------------------------------------------------
        43. SAVEPOINT
        ----------------------------------------------------------------------

        BEGIN;

        UPDATE cuentas
        SET saldo = saldo - 100
        WHERE id = 1;

        SAVEPOINT antes_insertar;

        INSERT INTO transacciones
        VALUES (...);

        ROLLBACK TO SAVEPOINT antes_insertar;

        COMMIT;


        RESULTADO:

        UPDATE
        -> permanece

        INSERT posterior al savepoint
        -> se revierte
        */


        /*
        ----------------------------------------------------------------------
        44. ACID
        ----------------------------------------------------------------------

        A = Atomicidad
        -> todo o nada

        C = Consistencia
        -> la base permanece válida

        I = Aislamiento
        -> transacciones concurrentes separadas

        D = Durabilidad
        -> después de COMMIT permanece
        */


        /*
        ----------------------------------------------------------------------
        45. CREATE / DROP / ALTER DATABASE
        ----------------------------------------------------------------------

        CREATE DATABASE universidad;

        CREATE DATABASE universidad
        OWNER jose;


        CREATE DATABASE universidad
        TABLESPACE espacio_datos;


        ALTER DATABASE universidad
        RENAME TO universidad2026;


        DROP DATABASE IF EXISTS universidad;
        */


        /*
        ----------------------------------------------------------------------
        46. TEMPLATE / LC_COLLATE / TABLESPACE / OWNER
        ----------------------------------------------------------------------

        TEMPLATE
        -> usar otra base como plantilla

        LC_COLLATE
        -> ordenamiento de texto

        TABLESPACE
        -> ubicación lógica/física

        OWNER
        -> propietario


        Ejemplo:

        CREATE DATABASE nueva
        OWNER jose
        TEMPLATE template0
        TABLESPACE pg_default;
        */


        /*
        ----------------------------------------------------------------------
        47. SET / RESET DATABASE
        ----------------------------------------------------------------------

        ALTER DATABASE universidad
        SET timezone TO 'America/Montevideo';


        Restaurar valor:

        ALTER DATABASE universidad
        RESET timezone;


        SET   -> establecer
        RESET -> restaurar
        */


        /*
        ----------------------------------------------------------------------
        48. pg_terminate_backend()
        ----------------------------------------------------------------------

        Se usa para terminar conexiones activas.

        Puede ser necesario antes de DROP DATABASE
        si otras sesiones están conectadas.
        */


        /*
        ----------------------------------------------------------------------
        49. VISTAS
        ----------------------------------------------------------------------

        Una VIEW es una tabla virtual basada en un SELECT.

        CREATE VIEW vista_estudiantes AS
        SELECT id, nombre
        FROM estudiantes;


        Consultar:

        SELECT *
        FROM vista_estudiantes;


        Eliminar:

        DROP VIEW vista_estudiantes;


        Seguro:

        DROP VIEW IF EXISTS vista_estudiantes;
        */


        /*
        ----------------------------------------------------------------------
        50. CREATE OR REPLACE VIEW
        ----------------------------------------------------------------------

        CREATE OR REPLACE VIEW vista_personas AS
        SELECT nombre, apellido, email
        FROM personas;


        IMPORTANTE POSTGRESQL REAL:

        CREATE OR REPLACE VIEW NO permite quitar libremente
        columnas existentes.

        La nueva definición debe conservar columnas existentes
        compatibles en nombre/tipo/orden y puede agregar columnas.

        Para quitar columnas:
        normalmente DROP VIEW + CREATE VIEW.
        */


        /*
        ----------------------------------------------------------------------
        51. WITH CHECK OPTION
        ----------------------------------------------------------------------

        CREATE VIEW empleados_activos AS
        SELECT *
        FROM empleados
        WHERE activo = true
        WITH CHECK OPTION;


        Ayuda a garantizar que modificaciones realizadas
        mediante la vista sigan cumpliendo la condición.
        */


        /*
        ----------------------------------------------------------------------
        52. VISTA + JOIN + COUNT + GROUP BY
        ----------------------------------------------------------------------

        "Cantidad de empleados por departamento"

        CREATE VIEW vista_departamento_empleados AS
        SELECT
            d.nombre,
            COUNT(e.id_empleado)
        FROM departamentos d
        INNER JOIN empleados e
            ON d.id_departamento = e.departamento_id
        GROUP BY d.nombre;


        FÓRMULA MENTAL:

        cantidad por grupo
        =
        JOIN + COUNT + GROUP BY
        */


        /*
        ----------------------------------------------------------------------
        53. ÍNDICES
        ----------------------------------------------------------------------

        Crear:

        CREATE INDEX idx_nombre
        ON personas (nombre);


        Eliminar:

        DROP INDEX IF EXISTS idx_nombre;


        Índice compuesto:

        CREATE INDEX idx_nombre_fecha
        ON personas (nombre, fecha_nacimiento);
        */


        /*
        ----------------------------------------------------------------------
        54. TIPOS DE ÍNDICE
        ----------------------------------------------------------------------

        B-tree
        -> default/general
        -> igualdad
        -> rangos
        -> ORDER BY
        -> valores únicos

        HASH
        -> igualdad =

        GiST
        -> geoespacial / rangos / estructuras complejas

        GIN
        -> texto completo / arrays / JSONB


        MEMORIA:

        B-tree -> GENERAL
        HASH   -> =
        GiST   -> GEO
        GIN    -> TEXTO / ARRAYS
        */


        /*
        ----------------------------------------------------------------------
        55. HASH
        ----------------------------------------------------------------------

        CREATE INDEX idx_email
        ON usuarios
        USING HASH (email);
        */


        /*
        ----------------------------------------------------------------------
        56. ÍNDICES Y ESCRITURAS
        ----------------------------------------------------------------------

        Ventaja:
        aceleran consultas.

        Costo:
        INSERT / UPDATE / DELETE pueden ser algo más lentos
        porque PostgreSQL debe mantener los índices.
        */


        /*
        ----------------------------------------------------------------------
        57. TABLESPACE
        ----------------------------------------------------------------------

        Un TABLESPACE define una ubicación donde PostgreSQL
        puede almacenar objetos.

        CREATE TABLESPACE espacio_datos
        LOCATION '/datos/postgresql';


        LOCATION:
        ruta física.
        */


        /*
        ----------------------------------------------------------------------
        58. PRIVILEGIO TABLESPACE
        ----------------------------------------------------------------------

        GRANT CREATE
        ON TABLESPACE espacio_datos
        TO jose;


        CREATE:
        permite crear objetos en ese tablespace.
        */


        /*
        ----------------------------------------------------------------------
        59. TABLA EN TABLESPACE
        ----------------------------------------------------------------------

        CREATE TABLE productos (
            id SERIAL PRIMARY KEY,
            nombre VARCHAR(100)
        ) TABLESPACE espacio_datos;
        */


        /*
        ----------------------------------------------------------------------
        60. TABLESPACE CON OBJETOS
        ----------------------------------------------------------------------

        PostgreSQL no permite eliminar un tablespace
        si todavía contiene objetos.

        Primero:
        mover o eliminar los objetos.
        */


        /*
        ----------------------------------------------------------------------
        61. LISTAR TABLESPACES
        ----------------------------------------------------------------------

        SELECT
            spcname AS "Nombre",
            pg_get_userbyid(spcowner) AS "Propietario",
            pg_tablespace_location(oid) AS "Ubicacion"
        FROM pg_tablespace;
        */


        /*
        ----------------------------------------------------------------------
        62. LOGS
        ----------------------------------------------------------------------

        Archivo principal de configuración:

        postgresql.conf


        Activar recolector:

        logging_collector = on


        Carpeta:

        log_directory = 'log'


        Nombre:

        log_filename = 'postgresql-%Y-%m-%d_%H%M%S.log'


        Duración de consultas:

        log_duration = on


        Consultas lentas:

        log_min_duration_statement = 1000


        Nivel mínimo:

        log_min_messages = 'WARNING'


        Rotación por tamaño:

        log_rotation_size = '50MB'


        Rotación por tiempo:

        log_rotation_age = '1d'


        Destinos:

        log_destination = 'stderr,csvlog,jsonlog'
        */


        /*
        ----------------------------------------------------------------------
        63. log_duration vs log_min_duration_statement
        ----------------------------------------------------------------------

        log_duration = on
        -> registra duración de las consultas.

        log_min_duration_statement = 1000
        -> registra sentencias que tardan >= 1000 ms.


        1000 ms = 1 segundo.
        */


        /*
        ----------------------------------------------------------------------
        64. log_error_verbosity
        ----------------------------------------------------------------------

        log_error_verbosity = 'verbose'

        -> más detalle en errores.
        */


        /*
        ----------------------------------------------------------------------
        65. REINICIO EN WINDOWS
        ----------------------------------------------------------------------

        net stop postgresql-x64-<version>
        net start postgresql-x64-<version>


        El nombre exacto depende de la instalación.
        */


        // ==================================================================
        // MÓDULO 4 - PL/pgSQL
        // ==================================================================

        /*
        ----------------------------------------------------------------------
        66. PL/pgSQL
        ----------------------------------------------------------------------

        PL/pgSQL extiende SQL con lógica procedural.

        Permite:

        variables
        IF
        CASE
        FOR
        WHILE
        LOOP
        funciones
        procedimientos
        triggers
        excepciones
        */


        /*
        ----------------------------------------------------------------------
        67. %TYPE
        ----------------------------------------------------------------------

        Copia el tipo de UNA COLUMNA.

        DECLARE
            v_nombre personas.nombre%TYPE;


        MEMORIA:

        %TYPE -> columna
        */


        /*
        ----------------------------------------------------------------------
        68. %ROWTYPE
        ----------------------------------------------------------------------

        Representa una FILA COMPLETA.

        DECLARE
            v_producto productos%ROWTYPE;


        MEMORIA:

        %ROWTYPE -> fila completa
        */


        /*
        ----------------------------------------------------------------------
        69. PARÁMETROS
        ----------------------------------------------------------------------

        IN
        -> entra

        OUT
        -> sale

        INOUT
        -> entra y puede salir modificado
        */


        /*
        ----------------------------------------------------------------------
        70. FUNCIÓN
        ----------------------------------------------------------------------

        CREATE FUNCTION sumar(
            a INTEGER,
            b INTEGER
        )
        RETURNS INTEGER
        AS $$
        BEGIN
            RETURN a + b;
        END;
        $$
        LANGUAGE plpgsql;


        RETURNS
        -> tipo de salida

        RETURN
        -> valor que se devuelve
        */


        /*
        ----------------------------------------------------------------------
        71. PROCEDIMIENTO
        ----------------------------------------------------------------------

        CREATE PROCEDURE agregar_producto(
            p_nombre VARCHAR
        )
        LANGUAGE plpgsql
        AS $$
        BEGIN
            INSERT INTO productos(nombre)
            VALUES (p_nombre);
        END;
        $$;


        Ejecutar:

        CALL agregar_producto('Mouse');


        Eliminar:

        DROP PROCEDURE IF EXISTS agregar_producto;
        */


        /*
        ----------------------------------------------------------------------
        72. PROCEDURE vs FUNCTION
        ----------------------------------------------------------------------

        PROCEDURE:
        CREATE PROCEDURE
        CALL nombre()
        ejecuta acciones
        no necesita devolver valor


        FUNCTION:
        CREATE FUNCTION
        SELECT nombre()
        normalmente devuelve resultado
        */


        /*
        ----------------------------------------------------------------------
        73. RAISE NOTICE
        ----------------------------------------------------------------------

        Muestra mensajes.

        RAISE NOTICE 'Hola';

        Con variable:

        RAISE NOTICE 'Edad: %', edad;
        */


        /*
        ----------------------------------------------------------------------
        74. IF
        ----------------------------------------------------------------------

        IF edad >= 18 THEN
            RAISE NOTICE 'Mayor';
        ELSE
            RAISE NOTICE 'Menor';
        END IF;
        */


        /*
        ----------------------------------------------------------------------
        75. ELSIF
        ----------------------------------------------------------------------

        PL/pgSQL real usa:

        ELSIF

        NO:
        ELSEIF


        Ejemplo:

        IF nota >= 8 THEN
            ...
        ELSIF nota >= 6 THEN
            ...
        ELSE
            ...
        END IF;


        Moodle en algunos cuestionarios escribió ELSEIF.
        Para responder ese cuestionario puede esperar "ELSEIF",
        pero PostgreSQL real usa ELSIF.
        */


        /*
        ----------------------------------------------------------------------
        76. FOR
        ----------------------------------------------------------------------

        Sintaxis real:

        FOR i IN 1..10 LOOP

            RAISE NOTICE '%', i;

        END LOOP;


        Dos puntos:
        ..
        */


        /*
        ----------------------------------------------------------------------
        77. WHILE
        ----------------------------------------------------------------------

        WHILE condicion LOOP

            -- instrucciones

        END LOOP;


        Se ejecuta mientras la condición sea TRUE.
        */


        /*
        ----------------------------------------------------------------------
        78. LOOP + EXIT
        ----------------------------------------------------------------------

        LOOP

            contador := contador + 1;

            EXIT WHEN contador > 5;

        END LOOP;


        EXIT:
        salir del bucle.
        */


        /*
        ----------------------------------------------------------------------
        79. CASE
        ----------------------------------------------------------------------

        CASE estado

            WHEN 'A' THEN
                RAISE NOTICE 'Activo';

            WHEN 'I' THEN
                RAISE NOTICE 'Inactivo';

            ELSE
                RAISE NOTICE 'Otro';

        END CASE;


        CASE:
        múltiples alternativas.
        */


        /*
        ----------------------------------------------------------------------
        80. CONSTANT
        ----------------------------------------------------------------------

        DECLARE
            iva CONSTANT NUMERIC := 0.22;


        Una CONSTANT:
        - debe inicializarse al declararla
        - luego no cambia
        */


        /*
        ----------------------------------------------------------------------
        81. TRIGGERS
        ----------------------------------------------------------------------

        Trigger:
        código que se ejecuta automáticamente
        cuando ocurre un evento.


        Eventos típicos:

        INSERT
        UPDATE
        DELETE


        SELECT no activa un trigger normal de tabla.
        */


        /*
        ----------------------------------------------------------------------
        82. BEFORE / AFTER / INSTEAD OF
        ----------------------------------------------------------------------

        BEFORE
        -> antes

        AFTER
        -> después

        INSTEAD OF
        -> en lugar de
        */


        /*
        ----------------------------------------------------------------------
        83. ROW vs STATEMENT
        ----------------------------------------------------------------------

        FOR EACH ROW
        -> una vez por fila afectada

        FOR EACH STATEMENT
        -> una vez por sentencia
        */


        /*
        ----------------------------------------------------------------------
        84. NEW / OLD
        ----------------------------------------------------------------------

        INSERT
        -> NEW

        DELETE
        -> OLD

        UPDATE
        -> OLD + NEW
        */


        /*
        ----------------------------------------------------------------------
        85. FUNCIÓN TRIGGER
        ----------------------------------------------------------------------

        CREATE FUNCTION log_venta()
        RETURNS TRIGGER
        AS $$
        BEGIN

            RAISE NOTICE 'Venta registrada';

            RETURN NEW;

        END;
        $$
        LANGUAGE plpgsql;
        */


        /*
        ----------------------------------------------------------------------
        86. CREATE TRIGGER
        ----------------------------------------------------------------------

        PostgreSQL moderno:

        CREATE TRIGGER antes_insertar_venta
        BEFORE INSERT
        ON ventas
        FOR EACH ROW
        EXECUTE FUNCTION log_venta();


        En versiones / materiales antiguos puede aparecer:

        EXECUTE PROCEDURE log_venta();


        Moodle marcó EXECUTE PROCEDURE en una pre-evaluación.
        Para PostgreSQL moderno:
        EXECUTE FUNCTION es la sintaxis recomendada.
        */


        /*
        ----------------------------------------------------------------------
        87. AUDITORÍA CON TRIGGER
        ----------------------------------------------------------------------

        AFTER INSERT
        ON empleados
        FOR EACH ROW

        -> registrar la inserción en log_empleados.


        Idea:

        empleado insertado
        ↓
        trigger
        ↓
        INSERT en tabla de log
        */


        /*
        ----------------------------------------------------------------------
        88. TRIGGER = FUNCIÓN + DISPARADOR
        ----------------------------------------------------------------------

        En el cierre M4 había una pregunta con DOS respuestas correctas:

        - una función
        - un disparador


        Conceptualmente:

        EVENTO
          ↓
        TRIGGER
          ↓
        FUNCIÓN TRIGGER
          ↓
        LÓGICA
        */


        // ==================================================================
        // PRE-EVALUACIÓN - PUNTOS CLAVE
        // ==================================================================

        /*
        ----------------------------------------------------------------------
        89. RESPUESTAS 1-60
        ----------------------------------------------------------------------

         1-B   2-A   3-B   4-B   5-D   6-B   7-D   8-D   9-C  10-C
        11-A  12-B  13-B  14-B  15-B  16-C  17-A  18-D  19-B  20-B
        21-B  22-B  23-D  24-D  25-C  26-A  27-A  28-B  29-C  30-B
        31-C  32-C  33-D  34-C  35-A  36-A  37-A  38-D  39-B  40-C
        41-A  42-D  43-D  44-C  45-A  46-D  47-A  48-D  49-B  50-C
        51-C  52-A  53-C  54-C  55-C  56-A  57-C  58-A  59-C  60-D
        */


        /*
        ----------------------------------------------------------------------
        90. ERRORES DE LA PRE-EVALUACIÓN
        ----------------------------------------------------------------------

        Preguntas con puntaje negativo:

        16
        -> AVG + GROUP BY + HAVING

        19
        -> INNER JOIN

        31
        -> JOIN + SUM + GROUP BY

        56
        -> TRIGGER BEFORE INSERT


        Son los temas que más conviene reforzar.
        */


        /*
        ----------------------------------------------------------------------
        91. PREGUNTA 16 - CORRECCIÓN IMPORTANTE
        ----------------------------------------------------------------------

        Precio promedio de productos cuyo total vendido > 100.

        SQL correcto:

        SELECT
            producto AS prod,
            AVG(precio)
        FROM ventas
        GROUP BY producto
        HAVING SUM(cantidad) > 100;


        La opción de Moodle tenía HAVING antes de GROUP BY.
        La idea conceptual era correcta,
        pero el orden sintáctico real es:

        GROUP BY
        HAVING
        */


        /*
        ----------------------------------------------------------------------
        92. PREGUNTA 19
        ----------------------------------------------------------------------

        INNER JOIN:

        SELECT c.nombre, o.fecha
        FROM clientes c
        INNER JOIN pedidos o
            ON c.id = o.id_cliente;


        Resultado:
        solo coincidencias en ambas tablas.
        */


        /*
        ----------------------------------------------------------------------
        93. PREGUNTA 31
        ----------------------------------------------------------------------

        Total de compras por cliente:

        SELECT
            vc.nombre_cliente,
            SUM(v.monto_total) AS monto_total_compras
        FROM vista_clientes vc
        JOIN vista_ventas v
            ON vc.id_cliente = v.id_cliente
        GROUP BY vc.nombre_cliente;


        Fórmula:

        TOTAL POR CLIENTE
        =
        JOIN + SUM + GROUP BY
        */


        /*
        ----------------------------------------------------------------------
        94. PREGUNTA 56
        ----------------------------------------------------------------------

        Moodle:

        CREATE TRIGGER antes_insertar_venta
        BEFORE INSERT
        ON ventas
        FOR EACH ROW
        EXECUTE PROCEDURE log_venta();


        PostgreSQL moderno:

        CREATE TRIGGER antes_insertar_venta
        BEFORE INSERT
        ON ventas
        FOR EACH ROW
        EXECUTE FUNCTION log_venta();
        */


        // ==================================================================
        // TRAMPAS DE MOODLE / DIFERENCIAS CON POSTGRESQL REAL
        // ==================================================================

        /*
        ----------------------------------------------------------------------
        95. CREATE USER vs CREATE ROLE
        ----------------------------------------------------------------------

        Moodle puede esperar:

        CREATE ROLE usuario WITH LOGIN PASSWORD '...';


        PostgreSQL también acepta:

        CREATE USER usuario PASSWORD '...';


        CREATE USER implica LOGIN.
        */


        /*
        ----------------------------------------------------------------------
        96. ELSIF vs ELSEIF
        ----------------------------------------------------------------------

        Moodle:
        puede mostrar ELSEIF.

        PL/pgSQL real:
        ELSIF.
        */


        /*
        ----------------------------------------------------------------------
        97. IF EXIST vs IF EXISTS
        ----------------------------------------------------------------------

        Moodle en una pregunta mostró:

        DROP PROCEDURE IF EXIST ...

        PostgreSQL real:

        DROP PROCEDURE IF EXISTS ...
        */


        /*
        ----------------------------------------------------------------------
        98. EXECUTE PROCEDURE vs EXECUTE FUNCTION
        ----------------------------------------------------------------------

        Materiales antiguos:
        EXECUTE PROCEDURE funcion_trigger();

        PostgreSQL moderno:
        EXECUTE FUNCTION funcion_trigger();
        */


        /*
        ----------------------------------------------------------------------
        99. CREATE OR REPLACE VIEW
        ----------------------------------------------------------------------

        Moodle puede simplificar diciendo que una columna omitida
        "se mantiene".

        PostgreSQL real:
        no se puede quitar una columna existente libremente
        mediante CREATE OR REPLACE VIEW.

        Para quitar columnas:
        DROP VIEW + CREATE VIEW.
        */


        /*
        ----------------------------------------------------------------------
        100. REVOKE CREATE ON ALL DATABASES
        ----------------------------------------------------------------------

        En el cierre M3 Moodle marcó:

        REVOKE CREATE ON ALL DATABASES FROM usuario;

        Esta sintaxis no es una forma estándar de PostgreSQL para
        revocar CREATE sobre todas las bases de una sola vez.

        Para el cuestionario:
        memorizar la respuesta que Moodle espera.

        Para PostgreSQL real:
        los privilegios se revocan sobre objetos concretos
        (base, schema, etc.) según el caso.
        */


        /*
        ----------------------------------------------------------------------
        101. DEBUG1 EN ÍNDICES
        ----------------------------------------------------------------------

        Moodle vinculó DEBUG1 con registrar operaciones internas
        relacionadas con índices.

        La idea:
        DEBUG1 = nivel de depuración detallado.

        Pero no significa literalmente que DEBUG1 registre
        automáticamente "todas las operaciones de índices".
        */


        /*
        ----------------------------------------------------------------------
        102. FECHA Y ANTIGÜEDAD
        ----------------------------------------------------------------------

        Moodle usó:

        DATE_PART('year', CURRENT_DATE)
        -
        DATE_PART('year', fecha_contratacion)


        Eso calcula diferencia de años calendario,
        pero puede sobreestimar la antigüedad
        si todavía no pasó el aniversario.


        Una opción más precisa en PostgreSQL:

        DATE_PART(
            'year',
            AGE(CURRENT_DATE, fecha_contratacion)
        )
        */


        // ==================================================================
        // CHULETAS FINALES
        // ==================================================================

        /*
        ----------------------------------------------------------------------
        103. CHULETA SQL
        ----------------------------------------------------------------------

        SELECT   -> consultar
        INSERT   -> insertar
        UPDATE   -> modificar
        DELETE   -> borrar filas
        DROP     -> eliminar objeto
        ALTER    -> modificar estructura
        CREATE   -> crear

        WHERE    -> filtrar filas
        HAVING   -> filtrar grupos
        GROUP BY -> agrupar
        ORDER BY -> ordenar
        DISTINCT -> quitar duplicados
        LIMIT    -> limitar filas
        */


        /*
        ----------------------------------------------------------------------
        104. CHULETA JOINS
        ----------------------------------------------------------------------

        INNER -> solo coincidencias
        LEFT  -> todo izquierda
        RIGHT -> todo derecha
        FULL  -> todo ambos
        CROSS -> combinaciones
        */


        /*
        ----------------------------------------------------------------------
        105. CHULETA AGREGACIONES
        ----------------------------------------------------------------------

        COUNT -> contar
        SUM   -> sumar
        AVG   -> promedio
        MAX   -> máximo
        MIN   -> mínimo
        */


        /*
        ----------------------------------------------------------------------
        106. CHULETA TEXTO
        ----------------------------------------------------------------------

        LEFT    -> primeros
        RIGHT   -> últimos
        CONCAT  -> unir
        LENGTH  -> longitud
        REPLACE -> reemplazar
        */


        /*
        ----------------------------------------------------------------------
        107. CHULETA FECHAS
        ----------------------------------------------------------------------

        DATE        -> fecha
        TIME        -> hora
        TIMESTAMP   -> fecha + hora
        TIMESTAMPTZ -> fecha + hora + zona

        year
        month
        day
        hour
        minute
        second
        quarter
        */


        /*
        ----------------------------------------------------------------------
        108. CHULETA TRANSACCIONES
        ----------------------------------------------------------------------

        BEGIN       -> iniciar
        COMMIT      -> confirmar
        ROLLBACK    -> deshacer
        SAVEPOINT   -> marcar
        ROLLBACK TO -> volver
        */


        /*
        ----------------------------------------------------------------------
        109. CHULETA ROLES
        ----------------------------------------------------------------------

        GRANT  -> DAR    -> TO
        REVOKE -> QUITAR -> FROM

        CONNECT -> DATABASE
        USAGE   -> SCHEMA / SEQUENCE
        SELECT  -> TABLE / VIEW
        EXECUTE -> FUNCTION / PROCEDURE
        */


        /*
        ----------------------------------------------------------------------
        110. CHULETA ÍNDICES
        ----------------------------------------------------------------------

        B-tree -> general / rangos / default
        Hash   -> igualdad
        GiST   -> geoespacial
        GIN    -> texto / arrays / JSONB
        */


        /*
        ----------------------------------------------------------------------
        111. CHULETA PL/pgSQL
        ----------------------------------------------------------------------

        %TYPE    -> columna
        %ROWTYPE -> fila completa

        IN       -> entra
        OUT      -> sale
        INOUT    -> entra y sale

        IF       -> condición
        ELSIF    -> condición adicional
        ELSE     -> caso contrario
        CASE     -> múltiples alternativas

        FOR      -> rango
        WHILE    -> mientras TRUE
        LOOP     -> bucle
        EXIT     -> salir
        */


        /*
        ----------------------------------------------------------------------
        112. CHULETA PROCEDURE / FUNCTION / TRIGGER
        ----------------------------------------------------------------------

        PROCEDURE:
        CREATE PROCEDURE
        CALL nombre()

        FUNCTION:
        CREATE FUNCTION
        RETURNS tipo
        RETURN valor

        TRIGGER:
        CREATE TRIGGER
        BEFORE / AFTER
        INSERT / UPDATE / DELETE
        FOR EACH ROW
        EXECUTE FUNCTION funcion_trigger()

        NEW -> fila nueva
        OLD -> fila anterior
        */


        /*
        ----------------------------------------------------------------------
        113. FRASES QUE TENÉS QUE DETECTAR EN EL ENUNCIADO
        ----------------------------------------------------------------------

        "total por..."
        -> SUM + GROUP BY

        "cantidad por..."
        -> COUNT + GROUP BY

        "promedio por..."
        -> AVG + GROUP BY

        "grupos cuyo..."
        -> HAVING

        "todos los de la izquierda"
        -> LEFT JOIN

        "solo coincidencias"
        -> INNER JOIN

        "sin repetir"
        -> DISTINCT

        "más recientes"
        -> ORDER BY ... DESC

        "primeros N"
        -> LEFT

        "últimos N"
        -> RIGHT

        "reemplazar"
        -> REPLACE

        "contiene texto"
        -> LIKE '%texto%'

        "no pertenece a"
        -> NOT IN

        "entre X e Y"
        -> BETWEEN

        "antes del evento"
        -> BEFORE

        "después del evento"
        -> AFTER

        "por cada fila"
        -> FOR EACH ROW
        */


        // ==================================================================
        // FIN
        // ==================================================================

        System.out.println("Guia SQL UTEC - Modulos 1 a 4 cargada correctamente.");
        System.out.println("Todo el contenido teorico y SQL esta dentro de comentarios.");
    }
}
