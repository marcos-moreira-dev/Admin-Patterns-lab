# Cómo extraer el modelo de datos desde el cliente

## Propósito
Este documento explica cómo pasar de una conversación con el cliente a un primer modelo de datos con sentido. La meta no es arrancar dibujando tablas al azar, sino detectar entidades, relaciones, atributos, estados, documentos e histórico a partir de cómo funciona el negocio.

## Idea central
Primero se escucha la operación real. Después se detectan estructuras. Recién al final se traduce eso a modelo conceptual, lógico y físico.

## Paso 1. Hacer que el cliente cuente un caso real
La mejor entrada suele ser una narración.

Preguntas útiles:
- Cuénteme este proceso como si estuviera ocurriendo ahora mismo.
- ¿Qué pasa primero?
- ¿Quién lo hace?
- ¿Qué se registra?
- ¿Qué pasa después?
- ¿Qué condición permite avanzar?
- ¿Qué pasa al final?

## Paso 2. Subrayar sustantivos fuertes
Mientras el cliente habla, Marcos debería anotar palabras que parezcan “cosas” del negocio.

Ejemplos:
- cliente
- pedido
- producto
- equipo
- orden
- pago
- garantía
- receta
- documento

No todos esos sustantivos terminarán siendo tablas, pero sí sirven como materia prima para el análisis.

## Paso 3. Clasificar lo detectado
Luego conviene clasificar cada cosa en una de estas categorías:
- entidad
- proceso
- catálogo
- documento
- estado
- evento o historial

### Preguntas para decidir si algo es entidad
- ¿Existe por sí mismo dentro del negocio?
- ¿Se registra, busca o edita?
- ¿Tiene datos propios?
- ¿Se relaciona con otras cosas?
- ¿Puede cambiar de estado?

### Preguntas para decidir si algo es catálogo
- ¿Es una lista de apoyo?
- ¿Se repite mucho?
- ¿Cambia poco?
- ¿Conviene elegirlo de una lista y no escribirlo siempre a mano?

### Preguntas para decidir si algo es documento
- ¿Se imprime, exporta o adjunta?
- ¿Sirve como comprobante o evidencia?
- ¿Tiene versión borrador y final?

## Paso 4. Detectar relaciones
Una vez que aparecen las entidades, hay que preguntar cómo se conectan.

Preguntas útiles:
- ¿Un cliente puede tener cuántos pedidos u órdenes?
- ¿Una orden pertenece a uno o a varios clientes?
- ¿Una venta tiene muchos productos?
- ¿Un producto puede aparecer en muchas ventas?
- ¿Un documento pertenece a una sola operación o a varias?

## Paso 5. Detectar atributos con preguntas operativas
No conviene preguntar por columnas demasiado pronto. Conviene preguntar por la operación.

Preguntas útiles:
- ¿Qué datos anotan cuando crean esto?
- ¿Qué datos son obligatorios?
- ¿Qué datos luego necesitan consultar?
- ¿Qué datos se usan para buscar?
- ¿Qué datos cambian con frecuencia?
- ¿Qué datos son sensibles?
- ¿Qué se calcula y qué realmente vale la pena guardar?

## Paso 6. Detectar estados, histórico y trazabilidad
Algunas entidades son vivas y requieren más que una tabla simple.

Preguntas útiles:
- ¿En qué estados puede quedar esto?
- ¿Qué acciones cambian ese estado?
- ¿Importa saber quién hizo el cambio?
- ¿Importa guardar fecha y hora?
- ¿Importa guardar comentarios, evidencia o eventos?

Si la respuesta es sí, puede hacer falta:
- estado actual en la entidad principal
- tabla de historial de estados
- tabla de comentarios o eventos
- evidencia documental asociada

## Paso 7. Hacer un resumen y validarlo con el cliente
Marcos debería decir algo como:

“Entonces entiendo que aquí existen cliente, pedido, pago y documento. Un cliente puede tener muchos pedidos. Un pedido puede tener varios pagos. El pedido cambia de estado y además deja comprobantes. ¿Es correcto?”

Esta validación corrige muchos errores antes de tocar el modelo lógico.

## Paso 8. Recién ahí pasar al modelo conceptual
Cuando ya tienes:
- lista de entidades
- relaciones principales
- atributos relevantes
- estados importantes
- documentos
- catálogos
- histórico

recién conviene dibujar o escribir el modelo conceptual.

## Errores frecuentes
- pedir tablas y columnas demasiado pronto
- confundir proceso con entidad
- meter catálogos como texto libre por todas partes
- olvidar histórico y trazabilidad
- olvidar documentos y comprobantes
- asumir cardinalidades sin validarlas
- no resumir al cliente lo entendido

## Regla práctica final
Si algo se registra, se consulta después, participa en flujos y tiene identidad propia, probablemente es una entidad.
Si algo solo clasifica y se repite mucho, probablemente es un catálogo.
Si algo deja evidencia formal, probablemente es un documento.
Si algo cambia varias veces durante su vida, probablemente necesita estados e histórico.
