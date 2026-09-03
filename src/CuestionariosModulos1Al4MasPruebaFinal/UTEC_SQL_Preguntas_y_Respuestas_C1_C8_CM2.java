package CuestionariosModulos1Al4MasPruebaFinal;

public class UTEC_SQL_Preguntas_y_Respuestas_C1_C8_CM2 {

    public static void main(String[] args) {
        System.out.println("Banco de preguntas y respuestas SQL - UTEC");
        System.out.println("Abrí este archivo y estudiá las preguntas, respuestas y consultas comentadas.");
    }

    // ============================================================
    // BANCO SQL ORIGINAL CONVERTIDO A FORMATO JAVA
    // Las consultas están comentadas para que este archivo compile
    // correctamente en IntelliJ IDEA.
    // ============================================================
    //
    // -- ============================================================
    // -- UTEC - BASE DE DATOS
    // -- PREGUNTAS Y RESPUESTAS - MÓDULOS C1 A C8 + CM2
    // -- PostgreSQL
    // -- ============================================================
    //
    //
    // -- ============================================================
    // -- C1 - 1.1 EXPRESIONES REGULARES
    // -- ============================================================
    //
    // -- PREGUNTA 1
    // -- ¿Cuál opción coincide con cualquier cadena que termina con 'abc'?
    // -- a) '^abc'
    // -- b) '$abc'
    // -- c) 'abc^'
    // -- d) 'abc$'
    // -- RESPUESTA CORRECTA: d) 'abc$'
    //
    // -- PREGUNTA 2
    // -- ¿Cuál NO es una función o característica de las expresiones regulares?
    // -- a) Extraer texto
    // -- b) Buscar texto
    // -- c) Crear nuevos registros
    // -- d) Reemplazar texto
    // -- RESPUESTA CORRECTA: c) Crear nuevos registros
    //
    // -- PREGUNTA 3
    // -- ¿Cuál operador es insensible a mayúsculas y minúsculas en PostgreSQL?
    // -- a) ~*
    // -- b) ILIKE
    // -- c) LIKE
    // -- d) ~
    // -- RESPUESTA ESPERADA: b) ILIKE
    // -- Nota: ~* también es case-insensitive para expresiones regulares.
    //
    // -- PREGUNTA 4
    // -- Extraer un número de 'Order #1234'
    // -- RESPUESTA CORRECTA:
    // SELECT regexp_matches('Order #1234', '\d+');
    //
    // -- PREGUNTA 5
    // -- ¿Qué significa [] en una expresión regular?
    // -- RESPUESTA CORRECTA:
    // -- d) Coincide con cualquier carácter dentro del conjunto.
    //
    // -- PREGUNTA 6
    // -- Operador que indica una o más apariciones:
    // -- RESPUESTA CORRECTA: c) +
    //
    // -- PREGUNTA 7
    // -- ¿Qué significa NOT ILIKE?
    // -- RESPUESTA CORRECTA:
    // -- a) Busca patrones que no coincidan, sin distinguir mayúsculas/minúsculas.
    //
    // -- PREGUNTA 8
    // -- ¿Qué simboliza ^ ?
    // -- RESPUESTA CORRECTA: b) Inicio de una cadena
    //
    // -- PREGUNTA 9
    // -- Nombre que comienza con cualquier carácter seguido de 'bc'
    // -- RESPUESTA CORRECTA:
    // SELECT *
    // FROM users
    // WHERE name ILIKE '_bc';
    //
    // -- PREGUNTA 10
    // -- ¿Cómo negar un conjunto de caracteres?
    // -- RESPUESTA CORRECTA: c) [^]
    //
    //
    // -- ============================================================
    // -- C2 - 1.2 FUNCIONES DE AGREGACIÓN
    // -- ============================================================
    //
    // -- PREGUNTA 1
    // -- Contar todas las filas de empleados
    // -- RESPUESTA CORRECTA: c)
    // SELECT COUNT(*)
    // FROM empleados;
    //
    // -- PREGUNTA 2
    // -- Sumar precios de Electrónica y Libros
    // -- RESPUESTA CORRECTA: d)
    // SELECT SUM(precio)
    // FROM producto
    // WHERE categoria IN ('Electrónica', 'Libros');
    //
    // -- PREGUNTA 3
    // -- Salario máximo del departamento Ventas
    // -- RESPUESTA CORRECTA: b)
    // SELECT MAX(salario)
    // FROM empleado
    // WHERE departamento = 'Ventas';
    //
    // -- PREGUNTA 4
    // -- Total de precios no nulos
    // -- RESPUESTA CORRECTA: c)
    // SELECT SUM(precio)
    // FROM producto;
    //
    // -- PREGUNTA 5
    // -- Contar empleados con salario superior a 2000
    // -- RESPUESTA CORRECTA: a)
    // SELECT COUNT(*) FILTER (WHERE salario > 2000)
    // FROM empleado;
    //
    // -- PREGUNTA 6
    // -- Precio mínimo
    // -- RESPUESTA CORRECTA: c)
    // SELECT MIN(precio)
    // FROM producto;
    //
    // -- PREGUNTA 7
    // -- Promedio de edad en departamento IT
    // -- RESPUESTA CORRECTA: b)
    // SELECT AVG(edad)
    // FROM empleado
    // WHERE departamento = 'IT';
    //
    // -- PREGUNTA 8
    // -- Contar valores no nulos de una columna
    // -- RESPUESTA CORRECTA: c)
    // SELECT COUNT(columna)
    // FROM tabla;
    //
    // -- PREGUNTA 9
    // -- ¿Cuál NO es función de agregación?
    // -- a) MAX
    // -- b) SUM
    // -- c) COUNT
    // -- d) FILTER
    // -- RESPUESTA CORRECTA: d) FILTER
    //
    // -- PREGUNTA 10
    // -- Salario máximo y mínimo
    // -- RESPUESTA CORRECTA: a)
    // SELECT MAX(salario), MIN(salario)
    // FROM empleado;
    //
    //
    // -- ============================================================
    // -- C3 - 1.3 FUNCIONES DE GRUPO
    // -- ============================================================
    //
    // -- PREGUNTA 1
    // -- Categorías con más de 10 productos distintos
    // -- RESPUESTA CORRECTA: b)
    // SELECT categoria
    // FROM producto
    // GROUP BY categoria
    // HAVING COUNT(DISTINCT nombre) > 10;
    //
    // -- PREGUNTA 2
    // -- Años con más de 100 unidades vendidas
    // -- RESPUESTA CORRECTA: b)
    // SELECT año
    // FROM ventas
    // GROUP BY año
    // HAVING SUM(cantidad) > 100;
    //
    // -- PREGUNTA 3
    // -- Agrupar empleados por departamento y sumar salarios
    // -- RESPUESTA CORRECTA: c)
    // SELECT departamento, SUM(salario)
    // FROM empleado
    // GROUP BY departamento;
    //
    // -- PREGUNTA 4
    // -- Filtrar grupos con más de 5 miembros
    // -- RESPUESTA CORRECTA: d) HAVING
    //
    // -- PREGUNTA 5
    // -- Departamentos con salario promedio superior a 2000
    // -- RESPUESTA CORRECTA: b)
    // SELECT departamento
    // FROM empleado
    // GROUP BY departamento
    // HAVING AVG(salario) > 2000;
    //
    // -- PREGUNTA 6
    // -- Ordenar nombres por edad descendente
    // -- RESPUESTA CORRECTA: c)
    // SELECT nombre
    // FROM empleado
    // ORDER BY edad DESC;
    //
    // -- PREGUNTA 7
    // -- Departamentos con al menos 3 empleados y suma de salarios mayor al promedio
    // -- RESPUESTA CORRECTA: d)
    // SELECT departamento, SUM(salario)
    // FROM empleado
    // GROUP BY departamento
    // HAVING COUNT(*) > 2
    //    AND SUM(salario) > AVG(salario);
    //
    // -- PREGUNTA 8
    // -- Clientes con más de 5 pedidos
    // -- RESPUESTA CORRECTA: c)
    // SELECT cliente_id
    // FROM pedidos
    // GROUP BY cliente_id
    // HAVING COUNT(pedido_id) > 5;
    //
    // -- PREGUNTA 9
    // -- GROUP BY sin función de agregación devuelve:
    // -- RESPUESTA CORRECTA:
    // -- b) Una lista de valores únicos para las columnas especificadas.
    //
    // -- PREGUNTA 10
    // -- Departamentos con más de 30 empleados
    // -- RESPUESTA CORRECTA: b)
    // SELECT departamento
    // FROM empleado
    // GROUP BY departamento
    // HAVING COUNT(*) > 30;
    //
    //
    // -- ============================================================
    // -- C4 - 1.4 DISTINCT Y LIMIT
    // -- ============================================================
    //
    // -- PREGUNTA 1
    // -- Ventaja de LIMIT en consultas grandes:
    // -- RESPUESTA CORRECTA:
    // -- d) Reduce la cantidad de datos transferidos desde el servidor.
    //
    // -- PREGUNTA 2
    // -- Primeras 3 filas
    // -- RESPUESTA CORRECTA: c)
    // SELECT *
    // FROM datos
    // LIMIT 3;
    //
    // -- PREGUNTA 3
    // -- DISTINCT ON: ¿cómo elegir el primer registro según un criterio?
    // -- RESPUESTA CORRECTA:
    // -- c) Ordenando los datos con ORDER BY.
    //
    // -- PREGUNTA 4
    // -- ¿Qué hace DISTINCT?
    // -- RESPUESTA CORRECTA:
    // -- c) Elimina filas duplicadas de los resultados.
    //
    // -- PREGUNTA 5
    // -- Nombres únicos
    // -- RESPUESTA CORRECTA: b)
    // SELECT DISTINCT nombre
    // FROM clientes;
    //
    // -- PREGUNTA 6
    // -- Primeros 5 productos
    // -- RESPUESTA CORRECTA: b)
    // SELECT *
    // FROM productos
    // LIMIT 5;
    //
    // -- PREGUNTA 7
    // -- Número de categorías únicas
    // -- RESPUESTA CORRECTA: a)
    // SELECT COUNT(DISTINCT categoria)
    // FROM productos;
    //
    // -- PREGUNTA 8
    // -- Función de DISTINCT ON
    // -- RESPUESTA ESPERADA: b) Todas las anteriores son correctas.
    //
    // -- PREGUNTA 9
    // -- Primer pedido de cada cliente ordenado por fecha
    // -- RESPUESTA CORRECTA: d)
    // SELECT DISTINCT ON (id_cliente) *
    // FROM pedidos
    // ORDER BY id_cliente, fecha_pedido ASC;
    //
    // -- PREGUNTA 10
    // -- Dos clientes más recientes
    // -- RESPUESTA ESPERADA: c)
    // SELECT nombre
    // FROM clientes
    // ORDER BY fecha_registro DESC
    // LIMIT 2;
    //
    //
    // -- ============================================================
    // -- C5 - JOINS
    // -- ============================================================
    //
    // -- PREGUNTA 1
    // -- JOIN que devuelve solo coincidencias:
    // -- RESPUESTA CORRECTA: b) INNER JOIN
    //
    // -- PREGUNTA 2
    // -- Producto cartesiano:
    // -- RESPUESTA CORRECTA:
    // -- c) Todas las combinaciones posibles entre filas de dos tablas.
    //
    // -- PREGUNTA 3
    // -- Todos los empleados y solo departamentos coincidentes:
    // -- RESPUESTA CORRECTA: b) LEFT JOIN
    //
    // -- PREGUNTA 4
    // -- Todos los registros de la derecha y coincidencias de la izquierda:
    // -- RESPUESTA CORRECTA: b) RIGHT JOIN
    //
    // -- PREGUNTA 5
    // -- Todas las combinaciones posibles:
    // -- RESPUESTA CORRECTA: a) CROSS JOIN
    //
    // -- PREGUNTA 6
    // -- Todos los registros de ambas tablas, con NULL donde no hay coincidencia:
    // -- RESPUESTA CORRECTA: b) FULL JOIN
    //
    // -- PREGUNTA 7
    // -- INNER JOIN sin coincidencia:
    // -- RESPUESTA CORRECTA:
    // -- b) La fila no se incluye en el resultado.
    //
    // -- PREGUNTA 8
    // -- FULL JOIN entre productos y pedidos:
    // -- RESPUESTA CORRECTA:
    // -- a) Todas las filas de ambas tablas con NULL donde no hay coincidencias.
    //
    // -- PREGUNTA 9
    // -- Principal ventaja de JOIN frente a múltiples consultas:
    // -- RESPUESTA ESPERADA:
    // -- b) Mejora en la eficiencia de la consulta.
    //
    // -- PREGUNTA 10
    // -- RIGHT JOIN:
    // -- RESPUESTA CORRECTA:
    // -- b) Retorna todos los registros de la tabla derecha, con NULL donde no hay coincidencia.
    //
    //
    // -- ============================================================
    // -- C6 - 1.6 SUBCONSULTAS
    // -- ============================================================
    //
    // -- PREGUNTA 1
    // -- ¿Qué es una subconsulta?
    // -- RESPUESTA CORRECTA:
    // -- b) Una consulta dentro de otra consulta.
    //
    // -- PREGUNTA 2
    // -- Productos con ingresos superiores a 5000
    // -- RESPUESTA CORRECTA: b)
    // SELECT nombre
    // FROM productos p
    // WHERE p.id_producto IN (
    //     SELECT v.id_producto
    //     FROM ventas v
    //     JOIN productos p2
    //         ON v.id_producto = p2.id_producto
    //     GROUP BY v.id_producto
    //     HAVING SUM(p2.precio * v.cantidad) > 5000
    // );
    //
    // -- PREGUNTA 3
    // -- ¿Dónde pueden usarse subconsultas?
    // -- RESPUESTA CORRECTA:
    // -- b) SELECT, FROM y WHERE.
    //
    // -- PREGUNTA 4
    // -- Subconsulta usada como tabla dentro de FROM:
    // -- RESPUESTA ESPERADA:
    // -- a) Ninguna de las anteriores.
    // -- Nombre habitual: subconsulta derivada / derived table.
    //
    // -- PREGUNTA 5
    // -- Clientes con pedidos mayores a 1000
    // -- RESPUESTA CORRECTA: d)
    // SELECT nombre
    // FROM clientes
    // WHERE id IN (
    //     SELECT cliente_id
    //     FROM pedidos
    //     WHERE monto > 1000
    // );
    //
    // -- PREGUNTA 6
    // -- Clientes cuyo total de pedidos supera 1000
    // -- RESPUESTA CORRECTA: d)
    // SELECT nombre
    // FROM clientes
    // WHERE id IN (
    //     SELECT cliente_id
    //     FROM pedidos
    //     GROUP BY cliente_id
    //     HAVING SUM(monto) > 1000
    // );
    //
    // -- PREGUNTA 7
    // -- Subconsulta escalar:
    // -- RESPUESTA CORRECTA:
    // -- a) Devuelve exactamente un valor.
    //
    // -- PREGUNTA 8
    // -- EXISTS:
    // -- RESPUESTA CORRECTA:
    // -- b) Devuelve TRUE si la subconsulta contiene filas.
    //
    // -- PREGUNTA 9
    // -- Clientes con pedidos pendientes
    // -- RESPUESTA CORRECTA: b)
    // SELECT nombre
    // FROM clientes c
    // WHERE EXISTS (
    //     SELECT 1
    //     FROM pedidos p
    //     WHERE p.cliente_id = c.id
    //       AND p.estado = 'pendiente'
    // );
    //
    // -- PREGUNTA 10
    // -- Característica de una subconsulta correlacionada:
    // -- RESPUESTA CORRECTA:
    // -- c) Hace referencia a columnas de la consulta exterior.
    //
    //
    // -- ============================================================
    // -- C7 - 1.7 FUNCIONES DE TEXTO
    // -- ============================================================
    //
    // -- PREGUNTA 1
    // -- Extraer primeros N caracteres:
    // -- RESPUESTA CORRECTA: c) LEFT
    //
    // -- PREGUNTA 2
    // -- Combinar varias columnas:
    // -- RESPUESTA CORRECTA: d) CONCAT
    //
    // -- PREGUNTA 3
    // -- Últimos 5 caracteres de 'Bienvenidos'
    // -- RESPUESTA CORRECTA: b)
    // SELECT RIGHT('Bienvenidos', 5);
    //
    // -- PREGUNTA 4
    // -- CONCAT:
    // -- RESPUESTA CORRECTA:
    // -- b) Une dos o más cadenas en una.
    //
    // -- PREGUNTA 5
    // -- Longitud de 'computadora'
    // -- RESPUESTA CORRECTA: c)
    // SELECT LENGTH('computadora');
    //
    // -- PREGUNTA 6
    // -- Reemplazar cielo por mar
    // -- RESPUESTA CORRECTA: c)
    // SELECT REPLACE('el cielo es azul', 'cielo', 'mar');
    //
    // -- PREGUNTA 7
    // -- Concatenar nombre y apellido con un espacio
    // -- RESPUESTA CORRECTA: c)
    // SELECT CONCAT(nombre, ' ', apellido)
    // FROM personas;
    //
    // -- PREGUNTA 8
    // -- Función para comparar longitudes:
    // -- RESPUESTA CORRECTA: c) LENGTH
    //
    // -- PREGUNTA 9
    // -- Primeros 3 caracteres de cada nombre
    // -- RESPUESTA CORRECTA: c)
    // SELECT LEFT(nombre, 3)
    // FROM usuarios;
    //
    // -- PREGUNTA 10
    // -- Reemplazar 'viejo' por 'nuevo'
    // -- RESPUESTA CORRECTA: c)
    // SELECT REPLACE(descripción, 'viejo', 'nuevo')
    // FROM productos;
    //
    //
    // -- ============================================================
    // -- C8 - 1.8 FUNCIONES DE FECHA
    // -- ============================================================
    //
    // -- PREGUNTA 1
    // -- Tipo de dato para almacenar solo fecha:
    // -- RESPUESTA CORRECTA: b) DATE
    //
    // -- PREGUNTA 2
    // -- DATE_PART minute de 15:30:45:
    // -- RESPUESTA CORRECTA: c) 30
    // SELECT DATE_PART('minute', '2023-07-09 15:30:45'::TIMESTAMP);
    //
    // -- PREGUNTA 3
    // -- DATE_PART:
    // -- RESPUESTA CORRECTA:
    // -- a) Extrae una parte específica de una fecha o timestamp.
    //
    // -- PREGUNTA 4
    // -- Extraer año:
    // -- RESPUESTA CORRECTA: d)
    // SELECT DATE_PART('year', '2023-12-25'::DATE);
    //
    // -- PREGUNTA 5
    // -- Extraer mes:
    // -- RESPUESTA CORRECTA: a)
    // SELECT DATE_PART('month', fecha_registro)
    // FROM registros;
    //
    // -- PREGUNTA 6
    // -- Día de 2024-02-29:
    // -- RESPUESTA CORRECTA: b) 29
    //
    // -- PREGUNTA 7
    // -- Extraer segundos:
    // -- RESPUESTA CORRECTA: c)
    // SELECT DATE_PART('second', '2024-01-01 12:59:59'::TIMESTAMP);
    //
    // -- PREGUNTA 8
    // -- Tipo con fecha, hora y zona horaria:
    // -- RESPUESTA CORRECTA: c) TIMESTAMPTZ
    //
    // -- PREGUNTA 9
    // -- Extraer hora:
    // -- RESPUESTA CORRECTA: c)
    // SELECT DATE_PART('hour', '2024-05-20 14:45:30+02'::TIMESTAMP);
    //
    // -- PREGUNTA 10
    // -- Parte del año / trimestre:
    // -- RESPUESTA CORRECTA: d)
    // SELECT DATE_PART('quarter', '2024-03-01'::DATE);
    //
    //
    // -- ============================================================
    // -- CM2 - CIERRE DE MÓDULO
    // -- ============================================================
    //
    // -- PREGUNTA 1
    // -- Longitud luego de reemplazar 'perro' por 'gatito'
    // -- RESPUESTA CORRECTA: c)
    // SELECT LENGTH(REPLACE('mi perro es juguetón', 'perro', 'gatito'));
    //
    // -- PREGUNTA 2
    // -- Pacientes sin consultas en últimos 30 días
    // -- RESPUESTA CORRECTA: b)
    // SELECT nombre
    // FROM pacientes p
    // WHERE NOT EXISTS (
    //     SELECT 1
    //     FROM consultas c
    //     WHERE c.id_paciente = p.id_paciente
    //       AND c.fecha_consulta >= NOW() - INTERVAL '30 days'
    // );
    //
    // -- PREGUNTA 3
    // -- Minutos de 15:30:45
    // -- RESPUESTA CORRECTA: a)
    // SELECT DATE_PART('minute', '15:30:45'::TIME);
    //
    // -- PREGUNTA 4
    // -- Todos los empleados aunque no tengan departamento
    // -- RESPUESTA CORRECTA: b)
    // SELECT *
    // FROM empleados
    // LEFT JOIN departamentos
    //     ON empleados.departamento_id = departamentos.id;
    //
    // -- PREGUNTA 5
    // -- Pedidos únicos por cliente
    // -- RESPUESTA CORRECTA: b)
    // SELECT id_cliente, COUNT(DISTINCT id_pedido)
    // FROM pedidos
    // GROUP BY id_cliente;
    //
    // -- PREGUNTA 6
    // -- Categorías con precio promedio superior a 150
    // -- RESPUESTA CORRECTA: d)
    // SELECT categoria
    // FROM producto
    // GROUP BY categoria
    // HAVING AVG(precio) > 150;
    //
    // -- PREGUNTA 7
    // -- Categoría con producto de precio máximo
    // -- RESPUESTA CORRECTA: a)
    // SELECT categoria
    // FROM producto
    // WHERE precio = (
    //     SELECT MAX(precio)
    //     FROM producto
    // );
    //
    // -- PREGUNTA 8
    // -- Departamentos con menos de 3 empleados
    // -- RESPUESTA CORRECTA: a)
    // SELECT departamento
    // FROM empleado
    // GROUP BY departamento
    // HAVING COUNT(*) < 3;
    //
    // -- PREGUNTA 9
    // -- Subconsulta correcta para clientes con pedidos > 1000
    // -- RESPUESTA CORRECTA: c)
    // SELECT nombre
    // FROM clientes
    // WHERE id IN (
    //     SELECT cliente_id
    //     FROM pedidos
    //     WHERE monto > 1000
    // );
    //
    // -- PREGUNTA 10
    // -- Cantidad de productos en Electrónica
    // -- RESPUESTA CORRECTA: c)
    // SELECT COUNT(*)
    // FROM producto
    // WHERE categoria = 'Electrónica';
    //
    // -- PREGUNTA 11
    // -- Semana del año
    // -- RESPUESTA CORRECTA: c)
    // SELECT DATE_PART('week', '2023-09-05'::DATE);
    //
    // -- PREGUNTA 12
    // -- Caracteres eliminados al usar RIGHT(..., 3)
    // -- RESPUESTA CORRECTA: c)
    // SELECT LENGTH('ordenador') - 3;
    //
    // -- PREGUNTA 13
    // -- Valores distintos de columna1 y columna2
    // -- RESPUESTA CORRECTA: b)
    // SELECT DISTINCT columna1, columna2
    // FROM tabla;
    //
    // -- PREGUNTA 14
    // -- Cada empleado con todos los departamentos
    // -- RESPUESTA CORRECTA: a)
    // SELECT *
    // FROM empleados
    // CROSS JOIN departamentos;
    //
    // -- PREGUNTA 15
    // -- Correos que contienen 'edu.com'
    // -- RESPUESTA CORRECTA: d)
    // SELECT *
    // FROM clients
    // WHERE email LIKE '%edu.com%';
    //
    // -- PREGUNTA 16
    // -- Reemplazar todos los dígitos de abc123 por XYZ
    // -- RESPUESTA ESPERADA: a)
    // SELECT regexp_replace('abc123', '[0-9]+', 'XYZ');
    //
    //
    // -- ============================================================
    // -- FIN
    // -- ============================================================
}
