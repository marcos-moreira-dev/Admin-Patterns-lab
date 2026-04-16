# Plantilla maestra de levantamiento

## Propósito

Esta plantilla sirve para conducir una reunión de levantamiento de información de forma ordenada. No está pensada para preguntar por pantallas desde el inicio, sino para descubrir cómo funciona el negocio, qué problemas existen y qué partes del sistema realmente valen la pena.

## Regla general

Primero se entiende la operación, luego se modela el negocio y recién después se proponen módulos, base de datos, backend y UI.

## Bloque 1. Contexto general del negocio

### Preguntas guía
- ¿A qué se dedica el negocio exactamente?
- ¿Qué servicios o productos ofrece?
- ¿Qué parte del negocio es la más importante hoy?
- ¿Qué parte les genera más desorden, retraso o pérdida de tiempo?
- ¿Qué quieren mejorar primero?
- ¿Qué tarea sienten que hoy llevan de forma muy manual?

### Qué se busca detectar
- problema principal
- objetivo real del proyecto
- nivel de urgencia
- visión general del negocio

---

## Bloque 2. Actores y roles

### Preguntas guía
- ¿Quiénes participan en la operación?
- ¿Qué hace cada persona?
- ¿Quién registra?
- ¿Quién aprueba?
- ¿Quién solo consulta?
- ¿Quién necesita reportes?
- ¿Todos deberían ver lo mismo?

### Qué se busca detectar
- actores del negocio
- roles operativos
- primeras ideas de permisos
- posibles handoffs entre personas

---

## Bloque 3. Entidades y objetos importantes

### Preguntas guía
- ¿Qué cosas existen en el negocio y conviene registrar?
- ¿Clientes?
- ¿Productos?
- ¿Pedidos?
- ¿Órdenes?
- ¿Pagos?
- ¿Equipos?
- ¿Garantías?
- ¿Documentos?
- ¿Reportes?

### Qué se busca detectar
- entidades maestras
- entidades transaccionales
- entidades vivas o expedientes
- documentos relevantes

---

## Bloque 4. Procesos principales

### Preguntas guía
- ¿Cuáles son los procesos más importantes que hacen todos los días?
- ¿Qué empieza cuando llega un cliente?
- ¿Qué se hace paso a paso?
- ¿Qué proceso tiene inicio y final claros?
- ¿Qué proceso involucra a varias personas?
- ¿Qué proceso es el más delicado o crítico?

### Qué se busca detectar
- flujos centrales del negocio
- procesos repetitivos
- operaciones críticas

---

## Bloque 5. Flujos y decisiones

### Preguntas guía
- Cuénteme este proceso como si estuviera ocurriendo ahora mismo, desde que empieza hasta que termina.
- ¿Qué lo dispara?
- ¿Qué pasa primero?
- ¿Qué pasa después?
- ¿Quién interviene en cada etapa?
- ¿Qué pasa si el cliente acepta?
- ¿Qué pasa si no acepta?
- ¿Qué decisiones cambian el camino?
- ¿Qué casos raros aparecen?

### Qué se busca detectar
- pasos del flujo
- decisiones y bifurcaciones
- handoffs
- datos capturados por etapa
- cierre del flujo

---

## Bloque 6. Estados y ciclo de vida

### Preguntas guía
- ¿En qué estados puede quedar esto?
- ¿Cuándo está pendiente?
- ¿Cuándo pasa a en proceso?
- ¿Cuándo se considera listo o cerrado?
- ¿Se puede cancelar?
- ¿Se puede reabrir?
- ¿Qué acciones cambian el estado?

### Qué se busca detectar
- entidades vivas
- estados válidos
- transiciones
- acciones por estado

---

## Bloque 7. Reglas de negocio

### Preguntas guía
- ¿Qué está permitido y qué no?
- ¿Qué condiciones deben cumplirse para continuar?
- ¿Quién puede aprobar o cambiar algo crítico?
- ¿Qué pasa si falta pago, stock o autorización?
- ¿Qué restricciones no se deberían romper?

### Qué se busca detectar
- validaciones de negocio
- restricciones operativas
- decisiones humanas críticas
- reglas candidatas a backend y base de datos

---

## Bloque 8. Documentos y evidencia

### Preguntas guía
- ¿Qué documentos generan?
- ¿Qué documentos reciben?
- ¿Qué se imprime?
- ¿Qué se firma?
- ¿Qué se entrega al cliente?
- ¿Qué debe quedar como evidencia?
- ¿Se adjuntan fotos o archivos?

### Qué se busca detectar
- módulo documental
- soportes legales u operativos
- adjuntos y evidencias

---

## Bloque 9. Reportes, búsqueda y consultas

### Preguntas guía
- ¿Qué quieren consultar rápido?
- ¿Qué buscan con frecuencia?
- ¿Qué reportes necesitan sacar?
- ¿Qué indicadores ayudan a decidir?
- ¿Qué información desean exportar?
- ¿Qué les gustaría ver apenas entran al sistema?

### Qué se busca detectar
- reportes
- dashboards
- búsquedas especializadas
- consultas operativas recurrentes

---

## Bloque 10. Contexto técnico y operativo

### Preguntas guía
- ¿Cuántas personas usarían el sistema?
- ¿Lo usarán en una sola computadora o varias?
- ¿Habrá Internet siempre?
- ¿Usan impresora, escáner, cámara o lector?
- ¿Hoy manejan Excel, WhatsApp o papel?
- ¿Hay algo que definitivamente deba integrarse o migrarse?

### Qué se busca detectar
- restricciones reales de operación
- periféricos
- entorno de uso
- alcance técnico mínimo

---

## Bloque 11. Prioridad y fases

### Preguntas guía
- ¿Qué es indispensable en una primera versión?
- ¿Qué puede esperar?
- ¿Qué les duele más hoy?
- ¿Qué módulo o flujo daría valor rápido?
- ¿Qué idea les gustaría, pero no es urgente?

### Qué se busca detectar
- MVP
- V1
- futuras fases
- recortes saludables

---

## Cierre sugerido de la reunión

### Qué conviene resumir al final
- problema principal detectado
- procesos principales detectados
- entidades principales detectadas
- flujos o casos vivos detectados
- prioridades aparentes
- dudas pendientes
- siguiente paso propuesto

### Frase útil
"Con lo que me han contado, ya tengo una visión inicial. El siguiente paso es ordenar mejor procesos, entidades, reglas y prioridades para devolverles una propuesta más clara del sistema."


---

## Bloque 11. Extracción del modelo de datos desde la conversación

### Propósito
Este bloque existe para evitar el error clásico de saltar demasiado rápido a tablas y columnas. Primero se debe guiar al cliente para que describa la operación y, desde allí, detectar entidades, relaciones, atributos, catálogos, estados, documentos e histórico.

### Preguntas para detectar entidades
- ¿Qué cosas existen por sí mismas dentro del negocio?
- ¿Qué cosas registran, buscan, editan o consultan después?
- ¿Qué cosas tienen identidad propia, número, nombre o historial?
- ¿Qué cosas pueden existir varias veces al mismo tiempo?
- ¿Qué cosas cambian de estado o participan en varios procesos?

### Preguntas para detectar relaciones
- Un cliente puede tener cuántos pedidos, órdenes o pagos.
- Un pedido pertenece a uno o a varios clientes.
- Un producto puede aparecer en muchas ventas o en una sola.
- Un documento pertenece a una sola operación o a varias.
- Un técnico puede atender muchos casos o uno por vez.
- ¿Qué no puede existir sin otra cosa previa?

### Preguntas para detectar atributos
- ¿Qué datos necesitan registrar cuando esto se crea?
- ¿Qué datos son obligatorios y cuáles pueden quedar pendientes?
- ¿Qué datos luego se usan para buscar?
- ¿Qué datos cambian con frecuencia y cuáles casi nunca?
- ¿Qué datos son sensibles o delicados?
- ¿Qué dato se calcula y qué dato sí vale la pena guardar?

### Preguntas para detectar catálogos
- ¿Qué listas fijas o semifijas usan con frecuencia?
- ¿Qué valores se repiten mucho y convendría elegir en vez de escribir cada vez?
- ¿Qué cosas cambian de vez en cuando, pero no en cada operación?
- ¿Qué debería poder activarse, desactivarse o parametrizarse?

### Preguntas para detectar estados e histórico
- ¿En qué estados puede quedar esto?
- ¿Qué acción cambia el estado?
- ¿Importa saber quién cambió esto y cuándo?
- ¿Importa guardar comentarios, eventos, observaciones o evidencia?
- ¿Hay necesidad de reabrir, anular o rehacer?

### Qué debe hacer Marcos en la reunión
- pedir un caso real y no una descripción abstracta
- escuchar primero el flujo y recién después bajar a datos
- resumir en voz alta lo entendido para que el cliente corrija
- distinguir si algo es entidad, proceso, documento, catálogo o historial
- marcar dudas cuando una relación todavía no esté clara

### Error a evitar
Preguntar “¿qué campos lleva la tabla?” demasiado pronto. El cliente suele responder peor a esa pregunta que a una narración real del proceso.
