# Constraints, índices y reglas

## Propósito

Este documento recuerda qué mecanismos de integridad y rendimiento conviene usar en la base de datos y cómo decidirlos con criterio.

## Constraints principales

### PRIMARY KEY
Identifica de forma única cada fila.

### FOREIGN KEY
Asegura relaciones válidas entre tablas.

### UNIQUE
Evita duplicados en columnas o combinaciones relevantes.

### NOT NULL
Marca que un dato es obligatorio.

### CHECK
Restringe un valor a un conjunto o rango válido.

## Cuándo conviene usar constraints

Conviene cuando la regla:
- es estable
- es objetiva
- puede validarse a nivel de datos
- protege integridad incluso si falla la aplicación

Ejemplos buenos:
- estado en conjunto permitido
- cantidad mayor que cero
- porcentaje en rango válido
- unicidad de un número de comprobante

## Qué reglas no conviene meter completas en base de datos

No todo debe vivir en SQL.

Reglas de negocio más ricas o dependientes de contexto suelen vivir mejor en backend.

Ejemplos:
- autorización por rol
- flujo de aprobación
- reglas que dependen de varias entidades y estados complejos

## Índices

## Qué problema resuelven

Aceleran búsquedas, joins y ordenamientos sobre columnas usadas con frecuencia.

## Dónde suelen hacer sentido

- PK
- FK
- columnas de búsqueda frecuente
- columnas de filtrado por estado
- fecha de consulta frecuente
- unicidades importantes

## Riesgos de indexar sin criterio

- más costo en inserts y updates
- complejidad innecesaria
- falsa sensación de optimización

## Preguntas guía para índices

- ¿esta columna se consulta mucho?
- ¿se usa en joins?
- ¿se usa en filtros frecuentes?
- ¿se usa en ordenamiento repetido?
- ¿hay volumen suficiente como para justificarlo?

## Reglas prácticas

- toda PK debe quedar bien resuelta
- las FK importantes suelen agradecer índice
- no indexar todo por ansiedad
- revisar consultas reales cuando el sistema crezca

## Resultado esperado

La base de datos debe proteger integridad sin depender ciegamente de la aplicación y, a la vez, tener una base razonable de rendimiento para uso administrativo normal.
