package CuestionariosModulos1Al4MasPruebaFinal;

public class Teorico_SQL_Parcial_3_Setiembre {

    public static void main(String[] args) {

        /*
        =====================================================================
        TEÓRICO SQL / POSTGRESQL PARA EL PARCIAL
        =====================================================================

        Este archivo reúne en un solo código:

        1. Sublenguajes SQL
        2. SELECT y WHERE
        3. IN / NOT IN / BETWEEN
        4. INSERT
        5. UPDATE
        6. DELETE / TRUNCATE / DROP
        7. Tipos de datos
        8. Restricciones
        9. LIKE / ILIKE
        10. Expresiones regulares
        11. Agregaciones
        12. GROUP BY
        13. WHERE vs HAVING
        14. DISTINCT / LIMIT
        15. ORDER BY
        16. JOIN
        17. JOIN + agregación
        18. Subconsultas
        19. Funciones de texto
        20. Funciones de fecha
        21. Roles y privilegios
        22. Transacciones
        23. ACID
        24. Vistas
        25. Índices
        26. Tablespaces
        27. Logs
        28. PL/pgSQL
        29. %TYPE / %ROWTYPE
        30. IN / OUT / INOUT
        31. Funciones
        32. Procedimientos
        33. IF / ELSIF / ELSE
        34. FOR
        35. WHILE
        36. LOOP / EXIT
        37. CASE
        38. CONSTANT
        39. TRIGGERS
        40. BEFORE / AFTER
        41. FOR EACH ROW / STATEMENT
        42. NEW / OLD
        43. CREATE TRIGGER
        44. Chuletas finales

        Todo el SQL está dentro de comentarios para que este archivo Java
        pueda compilar sin errores.
        =====================================================================
        */


        // =================================================================
        // 1. SUBLENGUAJES SQL
        // =================================================================

        /*
        DDL = Data Definition Language
        Define o modifica la estructura de la base.

        CREATE
        ALTER
        DROP


        DML = Data Manipulation Language
        Trabaja con los datos.

        SELECT
        INSERT
        UPDATE
        DELETE


        DCL = Data Control Language
        Administra permisos.

        GRANT
        REVOKE


        TCL = Transaction Control Language
        Controla transacciones.

        BEGIN
        COMMIT
        ROLLBACK
        SAVEPOINT


        MEMORIA:

        DDL -> estructura
        DML -> datos
        DCL -> permisos
        TCL -> transacciones
        */


        // =================================================================
        // 2. SELECT
        // =================================================================

        /*
        SELECT recupera datos.


        SELECT *
        FROM empleados;


        * significa:

        todas las columnas.


        Columnas específicas:

        SELECT nombre, salario
        FROM empleados;


        RECORDAR:

        SELECT = recuperar / consultar datos
        */


        // =================================================================
        // 3. WHERE
        // =================================================================

        /*
        WHERE filtra FILAS.


        SELECT *
        FROM empleados
        WHERE salario > 50000;


        OPERADORES:

        =    igual
        <>   distinto
        !=   distinto
        >    mayor
        <    menor
        >=   mayor o igual
        <=   menor o igual


        AND:

        ambas condiciones deben ser TRUE.


        SELECT *
        FROM empleados
        WHERE edad >= 18
        AND activo = true;


        OR:

        alcanza con una condición.


        NOT:

        niega una condición.
        */


        // =================================================================
        // 4. IN / NOT IN
        // =================================================================

        /*
        IN:

        incluir valores.


        SELECT *
        FROM empleados
        WHERE departamento IN (1, 2, 3);


        NOT IN:

        excluir valores.


        SELECT *
        FROM empleados
        WHERE departamento NOT IN (1, 2, 3);


        MEMORIA:

        IN     -> incluir
        NOT IN -> excluir
        */


        // =================================================================
        // 5. BETWEEN
        // =================================================================

        /*
        BETWEEN trabaja con rangos.

        INCLUYE los extremos.


        SELECT *
        FROM libros
        WHERE anio_publicacion
        BETWEEN 2000 AND 2010;


        Equivale a:

        anio_publicacion >= 2000
        AND
        anio_publicacion <= 2010
        */


        // =================================================================
        // 6. INSERT
        // =================================================================

        /*
        Agregar un registro:


        INSERT INTO empleados (nombre, salario)
        VALUES ('Ana', 50000);


        Si ID es SERIAL normalmente no lo ponemos.


        EJEMPLO:

        CREATE TABLE empleados (
            id SERIAL PRIMARY KEY,
            nombre VARCHAR(100),
            salario NUMERIC
        );


        INSERT:

        INSERT INTO empleados (nombre, salario)
        VALUES ('Ana', 50000);


        INSERTAR VARIOS:

        INSERT INTO departamentos (nombre, ubicacion)
        VALUES
        ('Recursos Humanos', 'Piso 1'),
        ('Finanzas', 'Piso 2'),
        ('Marketing', 'Piso 3');
        */


        // =================================================================
        // 7. UPDATE
        // =================================================================

        /*
        UPDATE modifica registros.


        UPDATE empleados
        SET salario = 60000
        WHERE id = 1;


        AUMENTAR 10%:

        UPDATE empleados
        SET salario = salario * 1.10;


        CUIDADO:

        UPDATE sin WHERE
        modifica TODAS las filas.
        */


        // =================================================================
        // 8. DELETE / TRUNCATE / DROP
        // =================================================================

        /*
        DELETE:

        elimina filas.


        DELETE FROM clientes
        WHERE id = 5;


        TRUNCATE:

        vacía la tabla completa.


        TRUNCATE TABLE clientes;


        DROP:

        elimina el objeto completo.


        DROP TABLE clientes;


        DIFERENCIA:

        DELETE
        -> filas

        TRUNCATE
        -> vaciar tabla

        DROP
        -> eliminar tabla/objeto
        */


        // =================================================================
        // 9. TIPOS DE DATOS
        // =================================================================

        /*
        INTEGER
        -> enteros


        NUMERIC / DECIMAL
        -> decimales exactos


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
        -> fecha + hora con zona horaria


        BOOLEAN
        -> TRUE / FALSE


        CHAR vs VARCHAR:

        CHAR
        -> longitud fija

        VARCHAR
        -> longitud variable
        */


        // =================================================================
        // 10. RESTRICCIONES
        // =================================================================

        /*
        PRIMARY KEY

        identifica una fila de forma única.


        id SERIAL PRIMARY KEY


        -------------------------------------


        FOREIGN KEY

        relaciona tablas.


        FOREIGN KEY (cliente_id)
        REFERENCES clientes(id);


        -------------------------------------


        UNIQUE

        no permite duplicados.


        email VARCHAR(100) UNIQUE


        -------------------------------------


        NOT NULL

        dato obligatorio.


        nombre VARCHAR(100) NOT NULL


        -------------------------------------


        CHECK

        valida condición.


        edad INTEGER CHECK (edad >= 0)
        */


        // =================================================================
        // 11. LIKE / ILIKE
        // =================================================================

        /*
        LIKE busca patrones.


        CONTIENE Juan:

        WHERE nombre LIKE '%Juan%';


        EMPIEZA con Juan:

        WHERE nombre LIKE 'Juan%';


        TERMINA con Juan:

        WHERE nombre LIKE '%Juan';


        %:

        cero o más caracteres.


        _:

        exactamente UN carácter.


        ILIKE:

        búsqueda ignorando mayúsculas/minúsculas.
        */


        // =================================================================
        // 12. EXPRESIONES REGULARES
        // =================================================================

        /*
        PostgreSQL:


        ~

        regex sensible a mayúsculas.


        ~*

        regex sin distinguir mayúsculas/minúsculas.


        SÍMBOLOS:


        ^

        inicio


        $

        final


        [A-Z]

        letra mayúscula


        [A-Za-z]

        cualquier letra


        \d

        dígito


        {4}

        exactamente 4 veces


        EJEMPLO:

        una letra + cuatro números


        SELECT *
        FROM productos
        WHERE codigo ~ '^[A-Za-z]\d{4}$';
        */


        // =================================================================
        // 13. FUNCIONES DE AGREGACIÓN
        // =================================================================

        /*
        COUNT
        -> contar


        SUM
        -> sumar


        AVG
        -> promedio


        MAX
        -> máximo


        MIN
        -> mínimo


        EJEMPLO:

        SELECT SUM(cantidad)
        FROM ventas;


        RECORDAR:

        COUNT(columna)
        no cuenta NULL.

        COUNT(*)
        cuenta filas.
        */


        // =================================================================
        // 14. GROUP BY
        // =================================================================

        /*
        GROUP BY agrupa registros.


        SELECT producto,
               SUM(cantidad)
        FROM ventas
        GROUP BY producto;


        Si preguntan:

        "total por producto"

        pensar:

        SUM
        +
        GROUP BY


        Si preguntan:

        "cantidad por departamento"

        pensar:

        COUNT
        +
        GROUP BY
        */


        // =================================================================
        // 15. WHERE vs HAVING
        // =================================================================

        /*
        WHERE:

        filtra FILAS.


        WHERE salario > 50000


        HAVING:

        filtra GRUPOS.


        HAVING SUM(cantidad) > 100


        EJEMPLO COMPLETO:

        SELECT producto,
               AVG(precio)

        FROM ventas

        GROUP BY producto

        HAVING SUM(cantidad) > 100;


        MEMORIA:

        WHERE  -> filas
        HAVING -> grupos
        */


        // =================================================================
        // 16. ORDEN DE CLÁUSULAS
        // =================================================================

        /*
        ORDEN CORRECTO:


        SELECT

        FROM

        WHERE

        GROUP BY

        HAVING

        ORDER BY

        LIMIT


        MUY IMPORTANTE:

        GROUP BY
        va ANTES de
        HAVING.
        */


        // =================================================================
        // 17. DISTINCT
        // =================================================================

        /*
        DISTINCT elimina duplicados.


        SELECT DISTINCT fecha_pedido
        FROM pedidos;


        COUNT DISTINCT:

        SELECT COUNT(DISTINCT nombre)
        FROM estudiantes;
        */


        // =================================================================
        // 18. LIMIT
        // =================================================================

        /*
        LIMIT limita resultados.


        SELECT *
        FROM empleados
        LIMIT 5;


        Las 5 fechas más recientes sin repetir:


        SELECT DISTINCT fecha_pedido
        FROM pedidos
        ORDER BY fecha_pedido DESC
        LIMIT 5;
        */


        // =================================================================
        // 19. ORDER BY
        // =================================================================

        /*
        ASC:

        ascendente.


        ORDER BY salario ASC;


        DESC:

        descendente.


        ORDER BY salario DESC;


        DESC suele usarse para:

        mayor a menor
        más reciente primero
        valor más alto primero
        */


        // =================================================================
        // 20. INNER JOIN
        // =================================================================

        /*
        INNER JOIN:

        muestra SOLO COINCIDENCIAS.


        SELECT c.nombre,
               p.fecha

        FROM clientes c

        INNER JOIN pedidos p

        ON c.id = p.id_cliente;


        MEMORIA:

        INNER JOIN
        -> solo coincidencias
        */


        // =================================================================
        // 21. LEFT JOIN
        // =================================================================

        /*
        LEFT JOIN:

        TODO lo de la izquierda
        +
        coincidencias de la derecha.


        SELECT e.nombre,
               d.direccion

        FROM empleados e

        LEFT JOIN direcciones d

        ON e.id = d.id_empleado;


        MEMORIA:

        LEFT
        -> TODO IZQUIERDA
        */


        // =================================================================
        // 22. RIGHT JOIN
        // =================================================================

        /*
        RIGHT JOIN:

        TODO lo de la derecha
        +
        coincidencias de la izquierda.


        MEMORIA:

        RIGHT
        -> TODO DERECHA
        */


        // =================================================================
        // 23. FULL JOIN
        // =================================================================

        /*
        FULL JOIN:

        muestra todas las filas
        de ambas tablas.

        Cuando no hay coincidencia:

        aparece NULL.


        MEMORIA:

        FULL
        -> TODO AMBOS
        */


        // =================================================================
        // 24. CHULETA JOIN
        // =================================================================

        /*
        INNER
        -> coincidencias


        LEFT
        -> todo izquierda


        RIGHT
        -> todo derecha


        FULL
        -> todo ambos
        */


        // =================================================================
        // 25. JOIN + AGREGACIÓN
        // =================================================================

        /*
        Si preguntan:

        "total de compras por cliente"


        pensar:


        JOIN
        +
        SUM
        +
        GROUP BY


        EJEMPLO:


        SELECT
            c.nombre,
            SUM(v.monto_total)

        FROM clientes c

        JOIN ventas v
            ON c.id_cliente = v.id_cliente

        GROUP BY c.nombre;
        */


        // =================================================================
        // 26. SUBCONSULTAS
        // =================================================================

        /*
        Una subconsulta es una consulta
        dentro de otra.


        EJEMPLO:


        SELECT producto

        FROM ventas

        WHERE precio >
        (
            SELECT AVG(precio)
            FROM ventas
        );


        SIGNIFICA:

        productos cuyo precio
        es mayor al promedio.
        */


        // =================================================================
        // 27. EXISTS
        // =================================================================

        /*
        EXISTS pregunta:

        ¿EXISTE al menos una fila?


        EJEMPLO:


        SELECT nombre
        FROM clientes c

        WHERE EXISTS
        (
            SELECT 1
            FROM pedidos p
            WHERE p.cliente_id = c.id
        );
        */


        // =================================================================
        // 28. FUNCIONES DE TEXTO
        // =================================================================

        /*
        LEFT(texto, n)

        primeros caracteres.


        LEFT(nombre, 3)


        ----------------------------------


        RIGHT(texto, n)

        últimos caracteres.


        RIGHT(apellido, 2)


        ----------------------------------


        CONCAT(...)

        unir textos.


        CONCAT(nombre, '.', apellido)


        ----------------------------------


        LENGTH(texto)

        longitud.


        LENGTH(nombre)


        ----------------------------------


        REPLACE(texto, viejo, nuevo)

        reemplazar.


        REPLACE(
            descripcion,
            'nuevo',
            'antiguo'
        )
        */


        // =================================================================
        // 29. FUNCIONES DE TEXTO COMBINADAS
        // =================================================================

        /*
        Primeros 3 caracteres del nombre
        +
        últimos 2 del apellido:


        SELECT CONCAT(
            LEFT(nombre, 3),
            RIGHT(apellido, 2)
        ) AS usuario

        FROM empleados;


        -----------------------------------


        Reemplazar texto
        y obtener longitud:


        SELECT LENGTH(
            REPLACE(
                descripcion,
                'nuevo',
                'antiguo'
            )
        ) AS longitud

        FROM productos;
        */


        // =================================================================
        // 30. FUNCIONES DE FECHA
        // =================================================================

        /*
        DATE_PART:


        DATE_PART('year', fecha)

        año


        DATE_PART('month', fecha)

        mes


        DATE_PART('day', fecha)

        día


        DATE_PART('hour', fecha)

        hora


        DATE_PART('minute', fecha)

        minuto


        DATE_PART('second', fecha)

        segundo


        DATE_PART('quarter', fecha)

        trimestre
        */


        // =================================================================
        // 31. TRIMESTRES
        // =================================================================

        /*
        Q1
        -> enero
        -> febrero
        -> marzo


        Q2
        -> abril
        -> mayo
        -> junio


        Q3
        -> julio
        -> agosto
        -> septiembre


        Q4
        -> octubre
        -> noviembre
        -> diciembre
        */


        // =================================================================
        // 32. ROLES
        // =================================================================

        /*
        Crear rol con LOGIN:


        CREATE ROLE usuario
        WITH LOGIN
        PASSWORD 'clave';


        PostgreSQL también acepta:


        CREATE USER usuario
        PASSWORD 'clave';


        CREATE USER
        implica LOGIN.
        */


        // =================================================================
        // 33. GRANT
        // =================================================================

        /*
        GRANT:

        DAR permiso.


        GRANT SELECT
        ON empleados
        TO usuario;


        MEMORIA:

        GRANT
        -> DAR
        -> TO
        */


        // =================================================================
        // 34. REVOKE
        // =================================================================

        /*
        REVOKE:

        QUITAR permiso.


        REVOKE SELECT
        ON empleados
        FROM usuario;


        MEMORIA:

        REVOKE
        -> QUITAR
        -> FROM
        */


        // =================================================================
        // 35. ASIGNAR ROL
        // =================================================================

        /*
        GRANT rol_ventas
        TO user2;


        Significa:

        user2 recibe los privilegios
        asociados al rol.
        */


        // =================================================================
        // 36. PRIVILEGIOS
        // =================================================================

        /*
        CONNECT
        -> DATABASE


        USAGE
        -> SCHEMA / SEQUENCE


        SELECT
        -> TABLE / VIEW


        EXECUTE
        -> FUNCTION / PROCEDURE
        */


        // =================================================================
        // 37. TRANSACCIONES
        // =================================================================

        /*
        BEGIN;

        -- operaciones

        COMMIT;


        BEGIN
        -> iniciar


        COMMIT
        -> confirmar


        ROLLBACK
        -> deshacer


        SAVEPOINT
        -> punto de guardado
        */


        // =================================================================
        // 38. SAVEPOINT
        // =================================================================

        /*
        EJEMPLO:


        BEGIN;


        UPDATE cuentas
        SET saldo = saldo - 100
        WHERE id = 1;


        SAVEPOINT punto1;


        INSERT INTO transacciones
        VALUES (...);


        ROLLBACK TO SAVEPOINT punto1;


        COMMIT;


        RESULTADO:

        UPDATE
        -> permanece


        INSERT posterior al savepoint
        -> se deshace
        */


        // =================================================================
        // 39. ACID
        // =================================================================

        /*
        A
        -> Atomicidad

        todo o nada.


        C
        -> Consistencia

        mantiene la base válida.


        I
        -> Aislamiento

        transacciones concurrentes separadas.


        D
        -> Durabilidad

        después de COMMIT
        los cambios permanecen.
        */


        // =================================================================
        // 40. VISTAS
        // =================================================================

        /*
        Una VIEW es una tabla virtual
        basada en un SELECT.


        CREATE VIEW vista_empleados AS

        SELECT nombre, salario

        FROM empleados;


        CONSULTAR:


        SELECT *
        FROM vista_empleados;


        ELIMINAR:


        DROP VIEW vista_empleados;


        SEGURO:


        DROP VIEW IF EXISTS vista_empleados;
        */


        // =================================================================
        // 41. CREATE OR REPLACE VIEW
        // =================================================================

        /*
        CREATE OR REPLACE VIEW
        sirve para modificar una vista.


        IMPORTANTE:

        PostgreSQL real
        no permite quitar libremente
        columnas existentes con
        CREATE OR REPLACE VIEW.


        Para quitar columnas:

        DROP VIEW
        +
        CREATE VIEW
        */


        // =================================================================
        // 42. VISTA + COUNT + GROUP BY
        // =================================================================

        /*
        Cantidad de empleados
        por departamento:


        CREATE VIEW vista_departamento_empleados AS

        SELECT
            d.nombre,
            COUNT(e.id_empleado)

        FROM departamentos d

        INNER JOIN empleados e

            ON d.id_departamento =
               e.departamento_id

        GROUP BY d.nombre;


        MEMORIA:


        cantidad por grupo
        =
        JOIN
        +
        COUNT
        +
        GROUP BY
        */


        // =================================================================
        // 43. ÍNDICES
        // =================================================================

        /*
        Crear índice:


        CREATE INDEX idx_apellido
        ON clientes(apellido);


        Índice compuesto:


        CREATE INDEX idx_nombre_fecha
        ON personas(
            nombre,
            fecha_nacimiento
        );


        Eliminar:


        DROP INDEX IF EXISTS idx_apellido;
        */


        // =================================================================
        // 44. TIPOS DE ÍNDICES
        // =================================================================

        /*
        B-tree

        general / default
        igualdad
        rangos
        ORDER BY


        ----------------------------------


        Hash

        igualdad


        ----------------------------------


        GiST

        geoespacial
        estructuras complejas


        ----------------------------------


        GIN

        texto
        arrays
        JSONB


        MEMORIA:


        B-tree
        -> GENERAL


        Hash
        -> =


        GiST
        -> GEO


        GIN
        -> TEXTO
        */


        // =================================================================
        // 45. TABLESPACE
        // =================================================================

        /*
        TABLESPACE:

        ubicación de almacenamiento
        para objetos PostgreSQL.


        CREATE TABLESPACE espacio_datos
        LOCATION '/datos/postgresql';


        Crear base en tablespace:


        CREATE DATABASE universidad
        TABLESPACE espacio_datos;


        Propósito:

        distribuir datos
        entre discos o ubicaciones.
        */


        // =================================================================
        // 46. LOGS
        // =================================================================

        /*
        Archivo principal:

        postgresql.conf


        Parámetros:


        logging_collector

        habilitar recolección.


        log_directory

        dónde guardar logs.


        log_filename

        nombre del archivo.


        log_duration

        duración de consultas.


        log_min_duration_statement

        registrar consultas lentas.


        log_min_messages

        nivel mínimo.


        log_rotation_age

        rotación por tiempo.


        log_rotation_size

        rotación por tamaño.


        log_error_verbosity

        nivel de detalle del error.
        */


        // =================================================================
        // 47. PL/pgSQL
        // =================================================================

        /*
        PL/pgSQL agrega lógica procedural
        a PostgreSQL.


        Permite:


        variables

        IF

        ELSIF

        ELSE

        CASE

        FOR

        WHILE

        LOOP

        funciones

        procedimientos

        triggers
        */


        // =================================================================
        // 48. %TYPE
        // =================================================================

        /*
        %TYPE:

        toma el tipo de UNA COLUMNA.


        DECLARE

            v_nombre personas.nombre%TYPE;


        MEMORIA:

        %TYPE
        -> columna
        */


        // =================================================================
        // 49. %ROWTYPE
        // =================================================================

        /*
        %ROWTYPE:

        representa una FILA COMPLETA.


        DECLARE

            v_producto productos%ROWTYPE;


        MEMORIA:

        %ROWTYPE
        -> fila completa
        */


        // =================================================================
        // 50. IN / OUT / INOUT
        // =================================================================

        /*
        IN

        entra.


        OUT

        sale.


        INOUT

        entra
        +
        puede salir modificado.


        MEMORIA:

        IN
        -> entra

        OUT
        -> sale

        INOUT
        -> entra y sale
        */


        // =================================================================
        // 51. FUNCTION
        // =================================================================

        /*
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


        RETURNS:

        define TIPO DE SALIDA.


        RETURN:

        devuelve VALOR.
        */


        // =================================================================
        // 52. PROCEDURE
        // =================================================================

        /*
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


        EJECUTAR:


        CALL agregar_producto('Mouse');
        */


        // =================================================================
        // 53. PROCEDURE vs FUNCTION
        // =================================================================

        /*
        PROCEDURE

        CREATE PROCEDURE

        CALL nombre()

        ejecuta acciones

        no necesita devolver valor


        --------------------------------


        FUNCTION

        CREATE FUNCTION

        RETURNS

        RETURN

        normalmente devuelve resultado
        */


        // =================================================================
        // 54. RAISE NOTICE
        // =================================================================

        /*
        Mostrar mensaje:


        RAISE NOTICE 'Hola';


        Con variable:


        RAISE NOTICE
        'Edad: %',
        edad;
        */


        // =================================================================
        // 55. IF
        // =================================================================

        /*
        IF edad >= 18 THEN

            RAISE NOTICE 'Mayor';

        ELSE

            RAISE NOTICE 'Menor';

        END IF;
        */


        // =================================================================
        // 56. ELSIF
        // =================================================================

        /*
        IF nota >= 8 THEN

            ...

        ELSIF nota >= 6 THEN

            ...

        ELSE

            ...

        END IF;


        IMPORTANTE:

        PostgreSQL real usa:

        ELSIF


        Moodle en algún cuestionario
        mostró:

        ELSEIF
        */


        // =================================================================
        // 57. FOR
        // =================================================================

        /*
        FOR i IN 1..10 LOOP

            RAISE NOTICE '%', i;

        END LOOP;


        MEMORIA:

        FOR variable
        IN inicio..fin
        LOOP
        */


        // =================================================================
        // 58. WHILE
        // =================================================================

        /*
        WHILE condicion LOOP

            ...

        END LOOP;


        Se ejecuta mientras
        la condición sea TRUE.
        */


        // =================================================================
        // 59. LOOP + EXIT
        // =================================================================

        /*
        LOOP

            contador := contador + 1;

            EXIT WHEN contador > 5;

        END LOOP;


        EXIT:

        salir del bucle.
        */


        // =================================================================
        // 60. CASE
        // =================================================================

        /*
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


        // =================================================================
        // 61. CONSTANT
        // =================================================================

        /*
        DECLARE

            iva CONSTANT NUMERIC := 0.22;


        Una CONSTANT:

        debe inicializarse
        al declararla

        y después

        NO cambia.
        */


        // =================================================================
        // 62. TRIGGER
        // =================================================================

        /*
        TRIGGER:

        se ejecuta AUTOMÁTICAMENTE
        cuando ocurre un evento.


        Eventos típicos:


        INSERT

        UPDATE

        DELETE


        SELECT

        NO activa un trigger
        normal de tabla.
        */


        // =================================================================
        // 63. BEFORE / AFTER
        // =================================================================

        /*
        BEFORE

        antes del evento.


        AFTER

        después del evento.


        INSTEAD OF

        en lugar del evento.
        */


        // =================================================================
        // 64. FOR EACH ROW / STATEMENT
        // =================================================================

        /*
        FOR EACH ROW

        una vez
        POR CADA FILA.


        FOR EACH STATEMENT

        una vez
        POR SENTENCIA.
        */


        // =================================================================
        // 65. NEW / OLD
        // =================================================================

        /*
        INSERT

        -> NEW


        DELETE

        -> OLD


        UPDATE

        -> OLD + NEW
        */


        // =================================================================
        // 66. FUNCIÓN PARA TRIGGER
        // =================================================================

        /*
        CREATE FUNCTION log_venta()

        RETURNS TRIGGER

        AS $$

        BEGIN

            RAISE NOTICE
            'Venta registrada';

            RETURN NEW;

        END;

        $$

        LANGUAGE plpgsql;
        */


        // =================================================================
        // 67. CREATE TRIGGER
        // =================================================================

        /*
        PostgreSQL moderno:


        CREATE TRIGGER antes_insertar_venta

        BEFORE INSERT

        ON ventas

        FOR EACH ROW

        EXECUTE FUNCTION log_venta();


        Materiales antiguos pueden mostrar:


        EXECUTE PROCEDURE log_venta();


        Para PostgreSQL moderno:

        EXECUTE FUNCTION
        */


        // =================================================================
        // 68. AUDITORÍA CON TRIGGER
        // =================================================================

        /*
        Si queremos registrar
        cada inserción en empleados:


        AFTER INSERT

        ON empleados

        FOR EACH ROW


        idea:


        INSERT empleados
        ↓
        TRIGGER
        ↓
        INSERT log_empleados
        */


        // =================================================================
        // 69. CHULETA PRINCIPAL
        // =================================================================

        /*
        WHERE
        -> filas


        HAVING
        -> grupos


        GROUP BY
        -> agrupar


        DISTINCT
        -> sin repetidos


        LIMIT
        -> limitar


        INNER JOIN
        -> coincidencias


        LEFT JOIN
        -> todo izquierda


        RIGHT JOIN
        -> todo derecha


        FULL JOIN
        -> todo ambos


        GRANT
        -> dar


        REVOKE
        -> quitar


        COMMIT
        -> confirmar


        ROLLBACK
        -> deshacer


        %TYPE
        -> columna


        %ROWTYPE
        -> fila completa
        */


        // =================================================================
        // 70. CHULETA AGREGACIONES
        // =================================================================

        /*
        COUNT
        -> contar


        SUM
        -> sumar


        AVG
        -> promedio


        MAX
        -> máximo


        MIN
        -> mínimo
        */


        // =================================================================
        // 71. CHULETA TEXTO
        // =================================================================

        /*
        LEFT
        -> primeros


        RIGHT
        -> últimos


        CONCAT
        -> unir


        LENGTH
        -> longitud


        REPLACE
        -> reemplazar
        */


        // =================================================================
        // 72. CHULETA TRANSACCIONES
        // =================================================================

        /*
        BEGIN
        -> iniciar


        COMMIT
        -> confirmar


        ROLLBACK
        -> deshacer


        SAVEPOINT
        -> guardar punto


        ROLLBACK TO
        -> volver al punto
        */


        // =================================================================
        // 73. CHULETA PL/pgSQL
        // =================================================================

        /*
        IF
        -> condición


        ELSIF
        -> condición adicional


        ELSE
        -> caso contrario


        CASE
        -> múltiples opciones


        FOR
        -> rango


        WHILE
        -> mientras TRUE


        LOOP
        -> bucle


        EXIT
        -> salir
        */


        // =================================================================
        // 74. CHULETA TRIGGER
        // =================================================================

        /*
        TRIGGER
        -> automático


        BEFORE
        -> antes


        AFTER
        -> después


        INSERT
        UPDATE
        DELETE
        -> eventos


        FOR EACH ROW
        -> por fila


        NEW
        -> nueva fila


        OLD
        -> fila anterior
        */


        // =================================================================
        // 75. FRASES DEL ENUNCIADO
        // =================================================================

        /*
        "total por..."

        -> SUM + GROUP BY


        "cantidad por..."

        -> COUNT + GROUP BY


        "promedio por..."

        -> AVG + GROUP BY


        "grupos cuyo..."

        -> HAVING


        "solo coincidencias"

        -> INNER JOIN


        "todos los de la izquierda"

        -> LEFT JOIN


        "todos los de la derecha"

        -> RIGHT JOIN


        "sin repetir"

        -> DISTINCT


        "más recientes"

        -> ORDER BY DESC


        "primeros caracteres"

        -> LEFT


        "últimos caracteres"

        -> RIGHT


        "reemplazar"

        -> REPLACE


        "contiene"

        -> LIKE '%texto%'


        "no pertenece"

        -> NOT IN


        "entre"

        -> BETWEEN


        "antes de insertar"

        -> BEFORE INSERT


        "después de insertar"

        -> AFTER INSERT


        "por cada fila"

        -> FOR EACH ROW
        */


        // =================================================================
        // 76. ESTRUCTURAS QUE DEBERÍAS SABER DE MEMORIA
        // =================================================================

        /*
        1)

        SELECT *
        FROM tabla
        WHERE condicion;


        ------------------------------------------


        2)

        SELECT columna,
               SUM(valor)

        FROM tabla

        GROUP BY columna;


        ------------------------------------------


        3)

        SELECT columna,
               COUNT(*)

        FROM tabla

        GROUP BY columna

        HAVING COUNT(*) > 1;


        ------------------------------------------


        4)

        SELECT *

        FROM tabla1

        INNER JOIN tabla2

        ON tabla1.id = tabla2.id;


        ------------------------------------------


        5)

        BEGIN;

        -- operaciones

        COMMIT;


        ------------------------------------------


        6)

        CREATE FUNCTION nombre()

        RETURNS INTEGER

        AS $$

        BEGIN

            RETURN 1;

        END;

        $$

        LANGUAGE plpgsql;


        ------------------------------------------


        7)

        CREATE PROCEDURE nombre()

        LANGUAGE plpgsql

        AS $$

        BEGIN

            -- acciones

        END;

        $$;


        ------------------------------------------


        8)

        CREATE TRIGGER nombre

        BEFORE INSERT

        ON tabla

        FOR EACH ROW

        EXECUTE FUNCTION funcion();
        */


        System.out.println("Teorico SQL completo cargado.");
    }
}