# Del modelo conceptual al lógico

## Propósito

Este documento explica cómo traducir el modelo conceptual del negocio a un modelo lógico relacional. Aquí el dominio ya empieza a convertirse en tablas, claves y relaciones estructuradas, pero todavía con foco en diseño más que en detalles de motor.

## Qué es el modelo lógico

El modelo lógico responde a esta pregunta:

**¿Cómo se representa el negocio dentro de un modelo relacional claro, consistente y mantenible?**

Aquí ya aparecen:

- tablas
- claves primarias
- claves foráneas
- tablas puente
- restricciones de unicidad
- opcionalidad
- estructura de relaciones

## Criterio de contención

No todo concepto conceptual merece tabla propia. El modelo lógico debe ser lo bastante rico para sostener el negocio actual y lo bastante sobrio para seguir siendo fácil de consultar y mantener.

## Traducción básica

### Entidad conceptual → tabla lógica

Si en el negocio existe una entidad clara y persistente, normalmente termina como tabla.

Ejemplos:
- cliente → `cliente`
- producto → `producto`
- orden de reparación → `orden_reparacion`

### Relación 1:N → clave foránea

Si una entidad padre tiene muchas hijas, la tabla hija suele llevar la FK.

### Relación N:M → tabla intermedia

Si ambas entidades se relacionan muchas veces entre sí, normalmente necesitas tabla puente.

### Catálogo → tabla propia o constraint

Depende del nivel de cambio y consulta.

## Procedimiento recomendado

### 1. Confirmar qué sí será tabla

No todo concepto del negocio merece tabla propia. Debes decidir qué se persistirá explícitamente.

### 2. Definir clave primaria por tabla

Regla práctica conservadora:
- usar PK técnica simple, normalmente `id`
- evitar PK compuestas salvo cuando haya razón fuerte

### 3. Definir relaciones

Para cada relación preguntar:
- ¿quién referencia a quién?
- ¿es obligatoria u opcional?
- ¿debe existir tabla intermedia?
- ¿cuál es el lado dependiente?

### 4. Resolver catálogos

Decidir si un valor repetido conviene modelarlo como:
- tabla catálogo
- enum de aplicación
- constraint en base de datos

### 5. Separar transacción de historial

No mezclar lo que representa el estado actual con lo que representa eventos pasados.

### 6. Decidir qué no va como tabla

Ejemplos típicos de cosas que a veces no merecen tabla:
- valores derivados
- agrupaciones demasiado pequeñas
- catálogos diminutos sin vida propia
- conceptos que solo viven en una pantalla y no en el negocio

## Olores de sobreingeniería lógica

- una tabla nueva para cada valor repetido aunque no cambie ni se consulte
- demasiadas tablas puente sin justificación real
- claves compuestas por purismo cuando complican el sistema
- estructuras difíciles de consultar para operaciones normales

## Resultado esperado

El modelo lógico debe ser más concreto que el conceptual, pero no más sofisticado de lo que el negocio actual realmente necesita.
