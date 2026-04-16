# Migraciones y versionado

## Propósito

Este documento fija una disciplina básica: la base de datos debe evolucionar de forma controlada, repetible y versionada. No conviene depender de cambios manuales hechos “a ojo” en producción.

## Qué es una migración

Una migración es un cambio versionado del esquema o de ciertos datos estructurales de la base.

Ejemplos:
- crear tabla
- agregar columna
- cambiar constraint
- crear índice
- insertar catálogos base

## Por qué importan

Porque permiten:
- reproducir el esquema
- mover cambios entre entornos
- saber en qué estado está cada base
- evitar scripts sueltos perdidos
- reducir errores manuales

## Regla práctica

Todo cambio estructural relevante debe quedar versionado.

## Qué debería incluir cada cambio

- propósito claro
- orden correcto
- compatibilidad razonable con el estado actual
- posibilidad de rollback o plan de corrección si algo falla

## Convenciones sanas

- numerar o fechar migraciones
- nombre claro
- una intención por migración cuando sea posible
- no mezclar demasiados cambios ajenos en el mismo archivo

## Qué conviene evitar

- editar migraciones ya ejecutadas en otros entornos
- hacer cambios manuales sin registro
- meter datos de prueba informales dentro de migraciones estructurales

## Relación con seeds

Las migraciones cambian estructura.

Los seeds cargan datos base o demo.

No conviene mezclar ambas cosas sin criterio.

## Preguntas guía

- ¿esto cambia el esquema o solo carga datos?
- ¿el cambio es compatible con datos existentes?
- ¿requiere backfill o adaptación de datos?
- ¿rompe versiones anteriores del sistema?

## Resultado esperado

La base debe poder levantarse y evolucionar desde cero o desde una versión anterior de manera trazable y reproducible.
