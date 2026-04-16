# Base de datos suficiente para MVP, V1 y evolución

## Propósito

Este documento fija un criterio de contención para base de datos: modelar lo necesario para sostener la operación real del producto actual y su siguiente evolución razonable, sin inventar complejidad anticipada.

## Nivel 1. MVP

### Qué conviene
- tablas claras y pocas
- relaciones necesarias
- estados básicos
- catálogos donde aportan de verdad
- migraciones simples y controladas
- historial solo si el flujo lo necesita
- índices mínimos en búsquedas reales

### Qué no conviene
- catálogos porque “suena elegante”
- tablas históricas para todo
- relaciones puente innecesarias
- desnormalización prematura sin motivo
- campos “por si acaso” sin uso real
- modelos pensados para una escala imaginaria

## Nivel 2. V1

### Qué conviene
- pulir nombres y restricciones
- reforzar unicidades reales
- agregar índices sobre consultas usadas
- separar mejor histórico y estado actual
- mejorar migraciones y compatibilidad
- introducir columnas o tablas para trazabilidad si ya hay uso real

## Nivel 3. Sistema en evolución

### Qué conviene
- revisar rendimiento y cuellos de botella
- introducir historial más fuerte donde haya necesidad
- desnormalizar solo donde la consulta o el histórico lo justifiquen
- ordenar mejor migraciones, despliegues y compatibilidad
- refinar catálogos y constraints con uso real

## Señales de sobreingeniería en base de datos

- demasiadas tablas con pocos datos y poco valor
- catálogos diminutos que nunca se consultan ni cambian
- relaciones muy abstractas que complican consultas normales
- histórico creado para entidades donde nadie revisa la historia
- migraciones frecuentes por diseño prematuro, no por uso real

## Preguntas guía

- ¿esta tabla representa una cosa con identidad propia?
- ¿este dato se consulta o solo lo imaginé?
- ¿este historial se necesita por operación, auditoría o soporte?
- ¿este catálogo aporta control o solo infla el modelo?
- ¿esta relación complica más de lo que aclara?

## Regla práctica

Modela para la operación real, no para la fantasía de un producto gigante. La base de datos debe crecer con el dominio que de verdad existe y con los cambios que el negocio confirma.
