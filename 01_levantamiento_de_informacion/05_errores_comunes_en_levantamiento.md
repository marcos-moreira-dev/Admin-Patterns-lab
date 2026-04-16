# Errores comunes en levantamiento

## Propósito

Este documento existe para recordar qué errores destruyen la calidad del levantamiento, aunque la conversación haya sonado bien.

## Error 1. Empezar por pantallas

### Qué pasa
El cliente pide algo visual y uno se va directo a imaginar vistas, botones y tablas.

### Problema
Se diseña una interfaz antes de entender el proceso real.

### Corrección
Primero entender operación, actores, flujos, estados y reglas. Después hablar de módulos y UI.

---

## Error 2. Quedarse solo con el caso feliz

### Qué pasa
Solo se documenta el camino ideal, donde todo sale bien.

### Problema
Luego explotan garantías, rechazos, retrasos, faltantes, errores de datos y casos raros.

### Corrección
Siempre preguntar qué sale mal, qué casos raros ocurren y qué pasa cuando el proceso se rompe.

---

## Error 3. No distinguir entidad estable de entidad viva

### Qué pasa
Se trata todo como si fuera CRUD.

### Problema
Pedidos, tickets, órdenes y garantías terminan mal modelados.

### Corrección
Preguntar si la entidad vive en el tiempo, cambia de estado, tiene historial y seguimiento.

---

## Error 4. No detectar reglas de negocio

### Qué pasa
Se anotan datos y pasos, pero no restricciones.

### Problema
El sistema queda hueco y permisivo.

### Corrección
Preguntar qué está permitido, qué no, quién autoriza, qué condición frena o habilita un paso.

---

## Error 5. Confundir reportes con pantallas operativas

### Qué pasa
Se cree que todo lo consultable es solo una tabla.

### Problema
No aparecen dashboards, búsquedas especializadas ni reportes reales.

### Corrección
Preguntar qué se consulta a diario, qué se exporta y qué indicadores ayudan a decidir.

---

## Error 6. No detectar documentos ni evidencia

### Qué pasa
Se olvida preguntar por órdenes, comprobantes, recetas, garantías, fotos o archivos.

### Problema
Luego aparecen requerimientos ocultos importantes.

### Corrección
Preguntar siempre qué documento se genera, qué se imprime, qué se firma y qué queda guardado como evidencia.

---

## Error 7. No separar prioridad de deseo

### Qué pasa
Todo parece importante.

### Problema
El proyecto se infla sin control.

### Corrección
Preguntar qué es indispensable en la primera versión y qué puede esperar.

---

## Error 8. No resumir al final

### Qué pasa
La reunión termina y todo queda flotando.

### Problema
No sabes si el cliente y tú entendieron lo mismo.

### Corrección
Siempre cerrar resumiendo: problema principal, procesos detectados, entidades principales, prioridades y siguiente paso.

---

## Error 9. No escuchar el vocabulario natural del cliente

### Qué pasa
Uno traduce todo demasiado rápido a lenguaje técnico.

### Problema
Se pierden términos del negocio que luego ayudan muchísimo en naming y modelado.

### Corrección
Anotar cómo llama el cliente a sus cosas, procesos y documentos.

---

## Error 10. Prometer demasiado pronto

### Qué pasa
Para sonar resolutivo, uno promete módulos, pantallas, tiempos o incluso arquitectura demasiado rápido.

### Problema
Se genera deuda de expectativa.

### Corrección
Hablar en términos de entendimiento, estructura inicial, propuesta por fases y siguientes pasos, no de promesas cerradas antes de tiempo.

---

## Regla final

Un levantamiento bueno no termina cuando se habló bastante. Termina cuando ya puedes explicar con claridad:

- qué problema se quiere resolver
- qué entidades existen
- qué flujos hay
- qué reglas importan
- qué estados existen
- qué documentos aparecen
- qué entra primero y qué no
