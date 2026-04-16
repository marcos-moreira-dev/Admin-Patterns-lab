# Entidades y procesos

## Propósito
Este documento sirve para no mezclar cosas distintas durante el análisis. En un sistema administrativo no todo es “tabla”, ni todo es “módulo”. Aquí se separa qué es una **entidad**, qué es un **proceso**, qué es un **documento**, qué es una **transacción** y qué es una **consulta**.

## Idea central
Primero se entiende **qué existe en el negocio** y **qué ocurre en el negocio**. Después recién se traduce eso a base de datos, backend y UI.

## 1. Entidad
Una entidad es una cosa relevante del dominio que necesita identidad propia.

Ejemplos:
- cliente
- producto
- orden de reparación
- pedido de lentes
- pago
- garantía
- técnico
- proveedor

### Señales de que algo es entidad
- se puede nombrar como “una cosa” del negocio
- tiene datos propios
- puede relacionarse con otras cosas
- puede existir más de una vez
- suele terminar teniendo identificador

### Preguntas útiles
- ¿esto existe por sí mismo dentro del negocio?
- ¿hay que registrarlo, buscarlo o seguirlo?
- ¿tiene datos propios y relaciones con otros elementos?

## 2. Proceso
Un proceso es una secuencia de trabajo con inicio, desarrollo y cierre.

Ejemplos:
- recepción de equipo
- diagnóstico
- aprobación de presupuesto
- entrega
- registro de venta
- pedido al laboratorio

### Señales de que algo es proceso
- ocurre paso a paso
- tiene actores y decisiones
- transforma estados
- puede generar documentos o transacciones

### Preguntas útiles
- ¿esto se hace en pasos?
- ¿quién lo inicia y quién lo cierra?
- ¿qué decisiones cambian el camino?

## 3. Documento
Un documento es evidencia formal o soporte de algo que ocurrió.

Ejemplos:
- factura
- receta
- orden de recepción
- garantía
- comprobante de abono
- presupuesto

### Preguntas útiles
- ¿esto se imprime, exporta o adjunta?
- ¿sirve como prueba o comprobante?
- ¿tiene versión borrador y final?

## 4. Transacción
Una transacción es una acción con impacto fuerte en dinero, stock, estados o trazabilidad.

Ejemplos:
- venta
- pago
- devolución
- cierre de caja
- consumo de repuesto

### Preguntas útiles
- ¿qué cambia realmente cuando esto ocurre?
- ¿si sale mal se daña dinero, stock o integridad?
- ¿requiere confirmación fuerte?

## 5. Consulta
Una consulta es una interacción centrada en encontrar o resumir información.

Ejemplos:
- búsqueda avanzada de clientes
- historial de reparaciones
- reporte de pedidos pendientes
- ventas por período

## 6. Relación entre entidades y procesos
Una entidad rara vez vive sola. Casi siempre es atravesada por procesos.

Ejemplo de tienda de reparación:
- entidad: orden de reparación
- procesos: recibir equipo, diagnosticar, aprobar, reparar, entregar, gestionar garantía

Ejemplo de óptica:
- entidad: pedido de lentes
- procesos: registrar receta, tomar medidas, seleccionar lente, enviar a laboratorio, recibir, entregar

## 7. Regla práctica
Cuando estudies una parte del negocio, pregúntate:
1. ¿esto es una cosa o una acción?
2. ¿esto necesita identidad propia?
3. ¿esto cambia de estado?
4. ¿esto genera documento?
5. ¿esto mueve dinero, stock o responsabilidad?
6. ¿esto se consulta más de lo que se edita?

## 8. Resultado esperado de este análisis
Al terminar esta etapa deberías tener:
- lista de entidades principales
- lista de procesos principales
- relación entre entidades y procesos
- primeras hipótesis de estados, documentos y transacciones

## 9. Ejemplo resumido
### Óptica
- entidades: cliente, receta, pedido de lentes, abono, garantía
- procesos: registrar receta, tomar medidas, crear pedido, entregar, ajustar
- documentos: receta, comprobante, factura
- transacciones: abono, cobro final, devolución
- consultas: historial del cliente, pedidos pendientes

### Tienda de accesorios y reparación
- entidades: cliente, producto, repuesto, orden de reparación, pago, técnico
- procesos: recepción, diagnóstico, aprobación, reparación, entrega
- documentos: orden de recepción, garantía, comprobante
- transacciones: venta, cobro, consumo de repuesto
- consultas: búsqueda por IMEI, historial, bandeja de pendientes


## 9. Cómo detectar entidades desde una conversación real

### Regla práctica
Una entidad suele aparecer cuando, durante el relato del cliente, una “cosa” cumple varias de estas condiciones:
- se registra
- se busca después
- tiene datos propios
- se relaciona con otras cosas
- puede cambiar de estado
- puede tener historial o documentos

### Técnica útil
Mientras el cliente narra un flujo, subrayar sustantivos fuertes.

Ejemplo:
“cliente”, “equipo”, “orden”, “diagnóstico”, “pago”, “garantía”, “documento”.

Luego separar esos sustantivos en grupos:
- entidad
- proceso
- documento
- catálogo
- estado o evento

## 10. Cómo distinguir una entidad de un catálogo

Una entidad suele tener identidad propia y vida operativa.
Un catálogo suele ser una lista de apoyo, más estable y repetitiva.

Ejemplo:
- `orden de reparación` suele ser entidad
- `tipo de falla` suele ser catálogo

## 11. Cómo orientar al cliente para extraer mejor el modelo

### Marcos debería hacer esto
- pedir ejemplos reales
- no empezar hablando de tablas
- preguntar “qué anotan” en cada etapa
- preguntar “qué buscan después”
- preguntar “qué cambia de estado”
- preguntar “qué comprobante queda”
- resumir y validar lo entendido

### Señal de buen progreso
Cuando ya puedes decir algo como:
- estas son las entidades principales
- estas son sus relaciones
- estas son las entidades vivas
- estos son los catálogos
- estos son los documentos

En ese punto recién conviene pasar al modelo conceptual de datos.
