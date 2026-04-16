# Del modelo lógico al físico

## Propósito

Este documento explica cómo pasar de una estructura lógica relacional clara a un esquema físico real, por ejemplo en PostgreSQL. Aquí ya se aterrizan nombres, tipos, defaults, checks y decisiones concretas de implementación.

## Qué es el modelo físico

Es la representación ejecutable de la base de datos en un motor específico.

Aquí ya se define:
- nombre real de tablas y columnas
- tipos físicos
- constraints
- defaults
- índices
- comportamiento de claves foráneas
- nombres de objetos

## Procedimiento recomendado

### 1. Confirmar nombres finales

Elegir una convención consistente, por ejemplo:
- `snake_case`
- tablas en singular
- claves foráneas con sufijo `_id`

### 2. Elegir tipos físicos con criterio

Reglas prácticas:
- identificadores: `bigint` o `uuid` según estrategia
- texto corto: `varchar(n)` cuando haya límite real
- texto variable sin límite útil claro: `text`
- dinero o cantidades: `numeric(p,s)`
- fechas: `date`
- fecha y hora: `timestamp` o `timestamptz` según necesidad
- flags: `boolean`

### 3. Definir nulabilidad

Cada columna debe responder:
- ¿es obligatoria?
- ¿puede quedar pendiente?
- ¿admite ausencia por negocio o solo por descuido?

### 4. Definir defaults

Ejemplos:
- `created_at default now()`
- `activo default true`
- `estado default 'RECIBIDA'`

### 5. Definir claves y restricciones

- PK
- FK
- UNIQUE
- CHECK
- NOT NULL

### 6. Resolver comportamiento de FK

Pensar si aplica:
- `ON DELETE RESTRICT`
- `ON DELETE SET NULL`
- `ON DELETE CASCADE`

En sistemas administrativos, lo conservador suele ser restringir más que borrar en cascada sin control.

### 7. Definir estructura de auditoría mínima

Como base, conviene pensar en columnas como:
- `created_at`
- `updated_at`
- opcionalmente `created_by`, `updated_by`
- soft delete si el dominio lo necesita

## Criterios útiles

### Tipos por negocio, no por costumbre ciega

No usar `varchar(255)` por reflejo en todo. Elegir según sentido.

### Defaults con intención

No meter defaults solo para que deje de fallar el insert. El default debe tener significado.

### CHECK cuando la regla es estable y pequeña

Ejemplos:
- estados cerrados
- rangos válidos
- formatos simples

### Índices no van aquí todavía por impulso

Se pueden decidir después de revisar consulta y volumen, aunque algunos son obvios por PK, FK o unicidad.

## Entregables de esta etapa

- DDL inicial
- tablas finales
- columnas con tipos
- PK/FK/UNIQUE/CHECK/NOT NULL
- defaults
- primera versión implementable del esquema

## Errores comunes

- definir tipos por costumbre y no por significado
- usar cascadas agresivas sin pensar
- dejar demasiados nulos por comodidad
- no modelar auditoría mínima
- meter columnas ambiguas para “resolver después”

## Resultado esperado

Al final de esta etapa ya debe existir un esquema físico ejecutable, entendible y suficientemente sólido para convertirse en migraciones versionadas.
