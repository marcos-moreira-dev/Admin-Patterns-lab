# Diccionario de datos

## Propósito

El diccionario de datos explica el significado del esquema. No reemplaza al SQL; lo acompaña. Su función es dejar claro qué representa cada tabla y qué significa cada columna desde el punto de vista del negocio y del sistema.

## Qué debe contener

### Por tabla
- nombre de la tabla
- propósito
- módulo o dominio
- observaciones importantes

### Por columna
- nombre
- tipo
- null o no
- PK/FK
- default
- descripción
- observaciones de negocio

## Formato recomendado

```md
## Tabla: orden_reparacion

**Propósito:** representa el caso de reparación de un equipo recibido del cliente.

| Columna | Tipo | Null | PK/FK | Default | Descripción | Observaciones |
|---|---|---:|---|---|---|---|
| id | bigint | No | PK | - | Identificador interno | Autogenerado |
| cliente_id | bigint | No | FK | - | Cliente dueño del equipo | Referencia a cliente |
| estado | varchar(30) | No | - | 'RECIBIDA' | Estado actual de la orden | Validado por constraint |
| fecha_ingreso | timestamp | No | - | now() | Fecha y hora de ingreso | Importante para trazabilidad |
```

## Recomendación de entrega

### Fuente maestra interna
- Markdown

### Apoyos útiles
- diagrama ER
- SQL del esquema
- migraciones
- seeds

### Para compartir con cliente o validar
- PDF del diccionario o del diseño de base de datos

## Qué no debe pasar

- que el SQL sea el único lugar donde vive el significado
- que las columnas tengan nombre técnico pero sin semántica documentada
- que el equipo no sepa qué se puede tocar y qué no

## Plantilla sugerida

### Tabla: [nombre]

**Propósito:**

**Módulo o dominio:**

**Observaciones:**

| Columna | Tipo | Null | PK/FK | Default | Descripción | Observaciones |
|---|---|---:|---|---|---|---|
|  |  |  |  |  |  |  |

## Resultado esperado

El diccionario de datos debe permitir que otra persona entienda qué representa la base sin tener que adivinarlo leyendo SQL crudo.
