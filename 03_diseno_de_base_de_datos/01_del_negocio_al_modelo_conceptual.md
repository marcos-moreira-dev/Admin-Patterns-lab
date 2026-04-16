# Del negocio al modelo conceptual

## Propósito

Este documento fija el primer paso serio del diseño de base de datos: pasar de lo que el cliente cuenta sobre su negocio a un modelo conceptual claro. Aquí todavía no se diseña SQL ni tipos físicos. Primero se entiende qué cosas existen, cómo se relacionan y qué papel cumplen dentro de la operación.

## Qué es el modelo conceptual

El modelo conceptual describe el negocio en términos de entidades, relaciones, eventos y restricciones importantes, sin casarse todavía con PostgreSQL, nombres de columnas ni detalles de implementación.

Su pregunta base es:

**¿Qué cosas existen en el negocio y cómo se relacionan entre sí?**

## Insumos de entrada

Este modelo no se inventa. Se construye a partir de:

- levantamiento de información
- entidades detectadas
- procesos principales
- flujos relevantes
- estados del negocio
- reglas de negocio
- documentos y reportes
- excepciones frecuentes

## Criterio de contención

El modelo conceptual no debe convertirse en un mapa de todos los futuros posibles del negocio. Debe representar el dominio actual y el siguiente salto razonable.

## Procedimiento recomendado

### 1. Listar entidades principales

Preguntarse qué cosas existen de forma estable o recurrente en el negocio.

Ejemplos:
- cliente
- producto
- proveedor
- pedido
- orden de reparación
- pago
- garantía
- receta
- laboratorio

### 2. Separar entidades de procesos

No todo lo que el cliente menciona es una entidad.

Conviene separar:
- entidades estables
- procesos
- documentos
- catálogos
- eventos

Ejemplo:
- `cliente` sí es entidad
- `venta` puede tratarse como transacción o proceso
- `factura` puede ser documento
- `tipo de pago` puede ser catálogo

### 3. Detectar relaciones principales

Preguntas clave:
- ¿quién pertenece a quién?
- ¿quién depende de quién?
- ¿qué cosa tiene muchas de otra?
- ¿qué cosa no puede existir sin otra?

Ejemplos:
- un cliente puede tener muchos pedidos
- un pedido pertenece a un cliente
- una orden de reparación puede tener muchos eventos de historial

### 4. Identificar cardinalidades y opcionalidad

Todavía a nivel de negocio, debes aclarar:
- uno a uno
- uno a muchos
- muchos a muchos
- obligatorio u opcional

Esto evita confusiones cuando luego pases al modelo lógico.

### 5. Identificar ciclo de vida y estados

Algunas entidades son vivas y requieren estados.

Ejemplos:
- orden de reparación: recibida, en diagnóstico, aprobada, reparando, lista, entregada
- pedido de lentes: registrado, enviado, recibido, listo, entregado

No todo estado implica una tabla aparte, pero sí conviene modelarlo desde el inicio.

### 6. Identificar documentos y evidencias

Preguntarse:
- ¿qué documentos genera el proceso?
- ¿qué documentos recibe?
- ¿qué evidencia debe quedar?

Ejemplos:
- orden de recepción
- receta
- factura
- comprobante de abono
- fotos del equipo

### 7. Detectar catálogos

Los catálogos ayudan a estabilizar valores repetidos.

Ejemplos:
- tipos de lente
- métodos de pago
- tipos de servicio
- prioridades
- estados permitidos

### 8. Detectar histórico y trazabilidad

Preguntas:
- ¿importa saber quién cambió esto?
- ¿importa saber cuándo cambió?
- ¿importa conservar comentarios o eventos?

Si sí, conviene marcarlo desde el modelo conceptual aunque aún no decidas tabla física exacta.

## Qué evitar

- inventar entidades solo por elegancia
- fragmentar el negocio demasiado pronto
- modelar futuros hipotéticos sin uso claro
- convertir cualquier sustantivo en tabla

## Resultado esperado

Al terminar este paso, deberías tener un mapa conceptual suficientemente claro para pasar al modelo lógico sin arrastrar fantasías de complejidad innecesaria.
