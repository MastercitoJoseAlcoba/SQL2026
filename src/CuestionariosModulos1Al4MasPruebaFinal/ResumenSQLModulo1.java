package CuestionariosModulos1Al4MasPruebaFinal;

/*
============================================================
RESUMEN SQL - PARCIAL MODULO 1
============================================================

OBJETIVO:
Aprender a reconocer sentencias SQL, restricciones,
errores de sintaxis y entender qué hace cada código.

En el parcial pueden aparecer:

- Preguntas teóricas.
- Preguntas de múltiple opción.
- Imágenes con código SQL.
- Código correcto e incorrecto.
- Preguntas sobre qué hace determinada sentencia.

IMPORTANTE:
Todo el SQL de este archivo está guardado dentro de Strings.
Por eso Java NO intenta ejecutarlo como código Java.
============================================================
*/

public class ResumenSQLModulo1 {

    public static void main(String[] args) {

        System.out.println("Resumen SQL - Parcial Modulo 1");
        System.out.println("Usar este archivo como material de estudio.");
    }


    // ========================================================
    // 1. CREATE DATABASE
    // ========================================================

    /*
    CREATE DATABASE sirve para crear una base de datos.

    CREATE = crear
    DATABASE = base de datos
    */

    String crearBaseDatos = """

            CREATE DATABASE parcial_sql;

            """;


    // ========================================================
    // 2. TIPOS DE DATOS
    // ========================================================

    /*
    INTEGER
    --------
    Guarda números enteros.

    Ejemplo:
    10
    25
    100


    VARCHAR
    -------
    Guarda texto.

    VARCHAR(50)

    significa que permite hasta 50 caracteres.


    NUMERIC
    -------
    Guarda números decimales.

    NUMERIC(10,2)

    Ejemplo:
    1250.50


    DATE
    ----
    Guarda fechas.


    BOOLEAN
    -------
    Guarda:

    TRUE
    FALSE
    */


    // ========================================================
    // 3. CREATE TABLE
    // ========================================================

    /*
    CREATE TABLE sirve para crear una tabla.

    Una tabla contiene:

    - columnas
    - tipos de datos
    - restricciones
    */

    String crearTabla = """

            CREATE TABLE personas (

                id_persona INTEGER PRIMARY KEY,

                nombre VARCHAR(50) NOT NULL,

                email VARCHAR(100) UNIQUE,

                edad INTEGER CHECK (edad >= 0),

                activo BOOLEAN

            );

            """;


    // ========================================================
    // 4. PRIMARY KEY
    // ========================================================

    /*
    PRIMARY KEY = clave primaria.

    Sirve para identificar de manera única cada fila.

    Características:

    - No permite valores repetidos.
    - No permite NULL.
    - Cada tabla normalmente tiene una PRIMARY KEY.

    Ejemplo:

    id_persona INTEGER PRIMARY KEY
    */

    String primaryKey = """

            CREATE TABLE productos (

                id_producto INTEGER PRIMARY KEY,

                nombre VARCHAR(50)

            );

            """;


    // ========================================================
    // 5. NOT NULL
    // ========================================================

    /*
    NOT NULL significa:

    "Este campo debe tener un valor".

    No permite que quede vacío mediante NULL.

    Ejemplo:

    nombre VARCHAR(50) NOT NULL

    Significa que el nombre es obligatorio.
    */

    String notNull = """

            CREATE TABLE clientes (

                id_cliente INTEGER PRIMARY KEY,

                nombre VARCHAR(50) NOT NULL

            );

            """;


    // ========================================================
    // 6. UNIQUE
    // ========================================================

    /*
    UNIQUE evita valores repetidos.

    Ejemplo típico:

    email VARCHAR(100) UNIQUE

    Dos usuarios no deberían tener el mismo email.
    */

    String unique = """

            CREATE TABLE usuarios (

                id_usuario INTEGER PRIMARY KEY,

                email VARCHAR(100) UNIQUE

            );

            """;


    // ========================================================
    // 7. CHECK
    // ========================================================

    /*
    CHECK permite validar una condición.

    Por ejemplo:

    edad >= 18

    salario > 0

    cantidad >= 0

    Si el dato no cumple la condición,
    PostgreSQL rechaza la operación.
    */

    String check = """

            CREATE TABLE empleados (

                id_empleado INTEGER PRIMARY KEY,

                nombre VARCHAR(50),

                edad INTEGER CHECK (edad >= 18),

                salario NUMERIC(10,2) CHECK (salario > 0)

            );

            """;


    // ========================================================
    // 8. DEFAULT
    // ========================================================

    /*
    DEFAULT establece un valor predeterminado.

    Si no ingresamos un valor,
    PostgreSQL utiliza el valor definido.

    Ejemplo:

    activo BOOLEAN DEFAULT TRUE
    */

    String defaultEjemplo = """

            CREATE TABLE cuentas (

                id_cuenta INTEGER PRIMARY KEY,

                nombre VARCHAR(50),

                activo BOOLEAN DEFAULT TRUE

            );

            """;


    // ========================================================
    // 9. FOREIGN KEY
    // ========================================================

    /*
    FOREIGN KEY = clave foránea.

    Sirve para relacionar tablas.

    Ejemplo:

    Una carrera puede tener muchos estudiantes.

    carreras
       |
       |
       +---- estudiantes

    El estudiante guarda el id de su carrera.

    REFERENCES indica:

    "Esta columna hace referencia
    a esta otra tabla y columna".
    */

    String foreignKey = """

            CREATE TABLE carreras (

                id_carrera INTEGER PRIMARY KEY,

                nombre VARCHAR(50) NOT NULL

            );


            CREATE TABLE estudiantes (

                id_estudiante INTEGER PRIMARY KEY,

                nombre VARCHAR(50) NOT NULL,

                id_carrera INTEGER,

                FOREIGN KEY (id_carrera)
                    REFERENCES carreras(id_carrera)

            );

            """;


    // ========================================================
    // 10. INSERT
    // ========================================================

    /*
    INSERT sirve para insertar registros.

    Estructura:

    INSERT INTO tabla (columnas)
    VALUES (valores);
    */

    String insertar = """

            INSERT INTO carreras (id_carrera, nombre)
            VALUES (1, 'Ingenieria en Informatica');

            """;


    // ========================================================
    // 11. INSERT VARIOS REGISTROS
    // ========================================================

    /*
    También podemos agregar varias filas
    utilizando un solo INSERT.
    */

    String insertarVarios = """

            INSERT INTO productos (id_producto, nombre)
            VALUES
                (1, 'Teclado'),
                (2, 'Mouse'),
                (3, 'Monitor');

            """;


    // ========================================================
    // 12. SELECT
    // ========================================================

    /*
    SELECT sirve para consultar información.

    SELECT *
    significa:

    seleccionar todas las columnas.
    */

    String selectTodo = """

            SELECT *
            FROM estudiantes;

            """;


    /*
    También podemos seleccionar columnas específicas.
    */

    String selectColumnas = """

            SELECT id_estudiante, nombre
            FROM estudiantes;

            """;


    // ========================================================
    // 13. WHERE
    // ========================================================

    /*
    WHERE sirve para filtrar filas.

    SELECT
        qué quiero mostrar

    FROM
        de qué tabla

    WHERE
        bajo qué condición
    */

    String where = """

            SELECT *
            FROM estudiantes
            WHERE id_estudiante = 1;

            """;


    // ========================================================
    // 14. OPERADORES
    // ========================================================

    /*
    OPERADORES IMPORTANTES

    =       igual

    <>      diferente

    !=      diferente

    >       mayor

    <       menor

    >=      mayor o igual

    <=      menor o igual
    */

    String operadores = """

            SELECT *
            FROM empleados
            WHERE edad >= 18;

            """;


    // ========================================================
    // 15. AND
    // ========================================================

    /*
    AND significa que TODAS las condiciones
    deben cumplirse.

    edad >= 18
    Y
    salario > 30000
    */

    String and = """

            SELECT *
            FROM empleados
            WHERE edad >= 18
            AND salario > 30000;

            """;


    // ========================================================
    // 16. OR
    // ========================================================

    /*
    OR significa que puede cumplirse
    una condición O la otra.
    */

    String or = """

            SELECT *
            FROM empleados
            WHERE edad < 20
            OR salario > 50000;

            """;


    // ========================================================
    // 17. NOT
    // ========================================================

    /*
    NOT niega una condición.
    */

    String not = """

            SELECT *
            FROM empleados
            WHERE NOT edad = 18;

            """;


    // ========================================================
    // 18. UPDATE
    // ========================================================

    /*
    UPDATE modifica datos existentes.

    Estructura:

    UPDATE tabla

    SET columna = nuevo_valor

    WHERE condicion;


    MUY IMPORTANTE:

    UPDATE sin WHERE puede modificar
    TODAS las filas.
    */

    String update = """

            UPDATE estudiantes

            SET nombre = 'Jose Enrique'

            WHERE id_estudiante = 1;

            """;


    // ========================================================
    // 19. UPDATE VARIAS COLUMNAS
    // ========================================================

    String updateVariasColumnas = """

            UPDATE empleados

            SET nombre = 'Pedro',
                salario = 45000

            WHERE id_empleado = 1;

            """;


    // ========================================================
    // 20. DELETE
    // ========================================================

    /*
    DELETE elimina registros.

    DELETE FROM tabla
    WHERE condicion;
    */

    String delete = """

            DELETE FROM estudiantes

            WHERE id_estudiante = 2;

            """;


    /*
    ATENCIÓN:

    DELETE FROM estudiantes;

    elimina TODOS los registros.

    Pero la tabla continúa existiendo.
    */


    // ========================================================
    // 21. ALTER TABLE
    // ========================================================

    /*
    ALTER TABLE modifica la estructura
    de una tabla existente.

    Puede:

    - agregar columnas
    - eliminar columnas
    - modificar columnas
    - agregar restricciones
    - eliminar restricciones
    */


    // ========================================================
    // 22. ADD COLUMN
    // ========================================================

    String agregarColumna = """

            ALTER TABLE estudiantes

            ADD COLUMN edad INTEGER;

            """;


    // ========================================================
    // 23. DROP COLUMN
    // ========================================================

    String eliminarColumna = """

            ALTER TABLE estudiantes

            DROP COLUMN edad;

            """;


    // ========================================================
    // 24. MODIFICAR TIPO DE DATO
    // ========================================================

    String modificarTipo = """

            ALTER TABLE estudiantes

            ALTER COLUMN nombre TYPE VARCHAR(100);

            """;


    // ========================================================
    // 25. AGREGAR NOT NULL
    // ========================================================

    String agregarNotNull = """

            ALTER TABLE estudiantes

            ALTER COLUMN nombre SET NOT NULL;

            """;


    // ========================================================
    // 26. QUITAR NOT NULL
    // ========================================================

    String quitarNotNull = """

            ALTER TABLE estudiantes

            ALTER COLUMN nombre DROP NOT NULL;

            """;


    // ========================================================
    // 27. ADD CONSTRAINT
    // ========================================================

    /*
    CONSTRAINT permite darle un nombre
    a una restricción.
    */

    String agregarConstraint = """

            ALTER TABLE empleados

            ADD CONSTRAINT check_salario

            CHECK (salario >= 0);

            """;


    // ========================================================
    // 28. DROP CONSTRAINT
    // ========================================================

    String eliminarConstraint = """

            ALTER TABLE empleados

            DROP CONSTRAINT check_salario;

            """;


    // ========================================================
    // 29. DROP TABLE
    // ========================================================

    /*
    DROP TABLE elimina completamente
    la tabla.

    Se eliminan:

    - estructura
    - columnas
    - registros

    DELETE y DROP NO son lo mismo.
    */

    String dropTable = """

            DROP TABLE empleados;

            """;


    // ========================================================
    // 30. DELETE VS DROP
    // ========================================================

    /*
    DELETE
    ------

    Borra registros.

    DELETE FROM productos;


    DROP
    ----

    Borra la tabla completa.

    DROP TABLE productos;
    */


    // ========================================================
    // 31. CASCADE
    // ========================================================

    /*
    CASCADE permite eliminar también
    objetos que dependen del objeto eliminado.

    Hay que usarlo con cuidado.
    */

    String cascade = """

            DROP TABLE carreras CASCADE;

            """;


    // ========================================================
    // 32. RESTRICT
    // ========================================================

    /*
    RESTRICT evita la eliminación
    si existen otros objetos que dependen
    de la tabla.

    Es una forma de protección.
    */

    String restrict = """

            DROP TABLE carreras RESTRICT;

            """;


    // ========================================================
    // 33. CREATE DOMAIN
    // ========================================================

    /*
    DOMAIN permite crear un tipo de dato
    personalizado.

    Puede incluir restricciones.

    Ejemplo:

    crear un tipo de edad
    donde únicamente aceptemos >= 18.
    */

    String domain = """

            CREATE DOMAIN edad_adulta AS INTEGER

            CHECK (VALUE >= 18);

            """;


    // ========================================================
    // 34. USAR UN DOMAIN
    // ========================================================

    String usarDomain = """

            CREATE TABLE profesores (

                id_profesor INTEGER PRIMARY KEY,

                nombre VARCHAR(50),

                edad edad_adulta

            );

            """;


    // ========================================================
    // 35. DOMAIN DE MATRICULA
    // ========================================================

    String dominioMatricula = """

            CREATE DOMAIN dom_matricula AS VARCHAR(10)

            CHECK (VALUE <> '');

            """;


    // ========================================================
    // 36. ERROR MUY COMUN: == EN SQL
    // ========================================================

    /*
    EN SQL:

    CORRECTO:

    edad = 18


    INCORRECTO:

    edad == 18


    Esto puede aparecer perfectamente
    como trampa de múltiple opción.
    */

    String igualdadCorrecta = """

            SELECT *
            FROM empleados
            WHERE edad = 18;

            """;


    // ========================================================
    // 37. ORDEN CORRECTO DE UPDATE
    // ========================================================

    /*
    CORRECTO:

    UPDATE
    SET
    WHERE


    INCORRECTO:

    UPDATE
    WHERE
    SET
    */

    String updateCorrecto = """

            UPDATE empleados

            SET salario = 40000

            WHERE id_empleado = 1;

            """;


    // ========================================================
    // 38. ORDEN DE INSERT
    // ========================================================

    /*
    Recordar:

    INSERT INTO

    tabla

    columnas

    VALUES

    valores
    */

    String insertCorrecto = """

            INSERT INTO empleados
                (id_empleado, nombre, edad, salario)

            VALUES
                (1, 'Ana', 25, 40000);

            """;


    // ========================================================
    // 39. INTERPRETAR UPDATE
    // ========================================================

    /*
    Este código:

    UPDATE productos
    SET precio = precio * 1.10
    WHERE categoria = 'Tecnologia';


    Significa:

    aumentar un 10% el precio
    de todos los productos
    cuya categoría sea Tecnologia.
    */

    String interpretarUpdate = """

            UPDATE productos

            SET precio = precio * 1.10

            WHERE categoria = 'Tecnologia';

            """;


    // ========================================================
    // 40. INTERPRETAR DELETE
    // ========================================================

    /*
    Este código elimina estudiantes
    cuya edad sea menor a 18.
    */

    String interpretarDelete = """

            DELETE FROM estudiantes

            WHERE edad < 18;

            """;


    // ========================================================
    // 41. INTERPRETAR SELECT
    // ========================================================

    /*
    Este código:

    muestra solamente:

    - nombre
    - edad

    de estudiantes con edad >= 18.
    */

    String interpretarSelect = """

            SELECT nombre, edad

            FROM estudiantes

            WHERE edad >= 18;

            """;


    // ========================================================
    // 42. PALABRAS CLAVE
    // ========================================================

    /*
    CREATE
        crear


    ALTER
        modificar estructura


    DROP
        eliminar estructura


    INSERT
        insertar registros


    UPDATE
        modificar registros


    DELETE
        eliminar registros


    SELECT
        consultar información


    FROM
        indica la tabla


    WHERE
        filtra filas


    SET
        establece valores en UPDATE


    VALUES
        indica valores en INSERT


    REFERENCES
        relaciona una FOREIGN KEY
        con otra tabla
    */


    // ========================================================
    // 43. RESTRICCIONES - TEORIA DE MEMORIA
    // ========================================================

    /*
    PRIMARY KEY
    ==========================================================
    Identifica de forma única cada registro.


    FOREIGN KEY
    ==========================================================
    Relaciona dos tablas.


    NOT NULL
    ==========================================================
    Obliga a ingresar un valor.


    UNIQUE
    ==========================================================
    Evita valores duplicados.


    CHECK
    ==========================================================
    Comprueba una condición.


    DEFAULT
    ==========================================================
    Asigna un valor automáticamente
    si no especificamos otro.
    */


    // ========================================================
    // 44. ESTRUCTURA CREATE TABLE
    // ========================================================

    String estructuraCreate = """

            CREATE TABLE ejemplo (

                id INTEGER PRIMARY KEY,

                nombre VARCHAR(50) NOT NULL,

                email VARCHAR(100) UNIQUE,

                edad INTEGER CHECK (edad >= 18)

            );

            """;


    // ========================================================
    // 45. ESTRUCTURA INSERT
    // ========================================================

    String estructuraInsert = """

            INSERT INTO ejemplo
                (id, nombre, email, edad)

            VALUES
                (1, 'Jose', 'jose@mail.com', 42);

            """;


    // ========================================================
    // 46. ESTRUCTURA SELECT
    // ========================================================

    String estructuraSelect = """

            SELECT *

            FROM ejemplo

            WHERE edad >= 18;

            """;


    // ========================================================
    // 47. ESTRUCTURA UPDATE
    // ========================================================

    String estructuraUpdate = """

            UPDATE ejemplo

            SET nombre = 'Jose Enrique'

            WHERE id = 1;

            """;


    // ========================================================
    // 48. ESTRUCTURA DELETE
    // ========================================================

    String estructuraDelete = """

            DELETE FROM ejemplo

            WHERE id = 1;

            """;


    // ========================================================
    // 49. ESTRUCTURA ALTER TABLE
    // ========================================================

    String estructuraAlter = """

            ALTER TABLE ejemplo

            ADD COLUMN telefono VARCHAR(20);

            """;


    // ========================================================
    // 50. ESTRUCTURA FOREIGN KEY
    // ========================================================

    String estructuraForeignKey = """

            FOREIGN KEY (id_carrera)

            REFERENCES carreras(id_carrera)

            """;


    /*
    ==========================================================
    LO PRINCIPAL PARA MEMORIZAR PARA EL PARCIAL
    ==========================================================


    1)

    CREATE TABLE tabla (...);


    2)

    INSERT INTO tabla (...)
    VALUES (...);


    3)

    SELECT *
    FROM tabla
    WHERE condicion;


    4)

    UPDATE tabla
    SET columna = valor
    WHERE condicion;


    5)

    DELETE FROM tabla
    WHERE condicion;


    6)

    ALTER TABLE tabla
    ADD COLUMN columna tipo;


    7)

    FOREIGN KEY (columna)
    REFERENCES otra_tabla(columna);


    ==========================================================
    RESTRICCIONES
    ==========================================================

    PRIMARY KEY

    FOREIGN KEY

    NOT NULL

    UNIQUE

    CHECK

    DEFAULT


    ==========================================================
    TRAMPAS DE MULTIPLE OPCION
    ==========================================================


    SQL usa:

    =

    NO:

    ==


    ----------------------------------------------------------


    UPDATE correcto:

    UPDATE tabla
    SET columna = valor
    WHERE condicion;


    NO:

    UPDATE tabla
    WHERE condicion
    SET columna = valor;


    ----------------------------------------------------------


    DELETE correcto:

    DELETE FROM tabla
    WHERE condicion;


    ----------------------------------------------------------


    INSERT correcto:

    INSERT INTO tabla (columnas)
    VALUES (valores);


    ----------------------------------------------------------


    SELECT correcto:

    SELECT columnas
    FROM tabla
    WHERE condicion;


    ==========================================================
    DIFERENCIAS MUY IMPORTANTES
    ==========================================================

    DELETE

        elimina registros


    DROP TABLE

        elimina la tabla completa


    ALTER TABLE

        modifica la estructura


    UPDATE

        modifica datos


    INSERT

        agrega datos


    SELECT

        consulta datos


    ==========================================================
    FIN DEL RESUMEN
    ==========================================================
    */
}