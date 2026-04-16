# Guía de descubrimiento de flujos

## Propósito

Este documento sirve para descubrir flujos reales del negocio. Un flujo no es una pantalla ni una tabla. Un flujo es una secuencia de acciones, decisiones, responsables, estados, documentos y cierres.

## Pregunta maestra

La pregunta más útil suele ser esta:

**"Cuénteme este proceso como si estuviera ocurriendo ahora mismo, desde que empieza hasta que termina."**

## Qué se debe descubrir en cada flujo

- disparador
- objetivo
- actor inicial
- pasos principales
- decisiones y bifurcaciones
- datos capturados por etapa
- estados
- tiempos de espera
- excepciones
- documentos o evidencia
- condición de cierre
- impacto en otros módulos

---

## Paso 1. Identificar qué flujos existen

### Preguntas útiles
- ¿Cuáles son los procesos principales que hacen todos los días?
- ¿Qué procesos se repiten más?
- ¿Qué cosas tienen inicio y final claros?
- ¿Qué cosas pasan por varias etapas?
- ¿Qué cosas requieren aprobación, seguimiento o entrega?

### Objetivo
Sacar una lista inicial de flujos importantes.

---

## Paso 2. Elegir un flujo y pedir que lo narren

### Preguntas útiles
- Cuénteme este proceso paso a paso.
- ¿Qué lo dispara?
- ¿Qué pasa primero?
- ¿Qué pasa después?
- ¿Quién hace ese paso?
- ¿Qué información se registra ahí?
- ¿Qué condición permite pasar al siguiente paso?

### Objetivo
Convertir una explicación difusa en una secuencia clara.

---

## Paso 3. Detectar decisiones y bifurcaciones

### Preguntas útiles
- ¿Siempre sigue el mismo camino?
- ¿Qué pasa si el cliente acepta?
- ¿Qué pasa si no acepta?
- ¿Qué pasa si falta algo?
- ¿Qué pasa si aparece un problema nuevo?
- ¿Qué casos especiales rompen el camino normal?

### Objetivo
Descubrir si el flujo es lineal o si tiene ramas.

---

## Paso 4. Detectar estados

### Preguntas útiles
- ¿En qué estados puede quedar esto?
- ¿Cuándo pasa de pendiente a en proceso?
- ¿Cuándo queda listo?
- ¿Cuándo queda cerrado?
- ¿Se puede reabrir?
- ¿Qué acciones cambian de estado?

### Objetivo
Pasar del paso a paso al ciclo de vida de la entidad.

---

## Paso 5. Detectar tiempos y esperas

### Preguntas útiles
- ¿En qué parte se espera algo?
- ¿Qué depende de un tercero?
- ¿Cuánto tarda normalmente cada etapa?
- ¿Hay fecha prometida?
- ¿Qué pasa si se retrasa?

### Objetivo
Descubrir bandejas, alertas, vencimientos y puntos de fricción.

---

## Paso 6. Detectar excepciones

### Preguntas útiles
- ¿Qué sale mal a veces?
- ¿Qué casos raros ocurren?
- ¿Qué hacen cuando el proceso no puede seguir normal?
- ¿Qué pasa si el cliente no responde?
- ¿Qué pasa si el cliente no retira?
- ¿Qué pasa si la información inicial era incompleta o incorrecta?

### Objetivo
Ir más allá del caso feliz.

---

## Paso 7. Detectar documentos y evidencia

### Preguntas útiles
- ¿Qué comprobante se genera?
- ¿Qué se entrega al cliente?
- ¿Qué se imprime o firma?
- ¿Qué queda guardado como evidencia?
- ¿Se adjuntan archivos o fotos?

### Objetivo
Conectar el flujo con soporte documental y trazabilidad.

---

## Paso 8. Detectar el cierre

### Preguntas útiles
- ¿Cuándo se considera realmente terminado?
- ¿Qué condición marca el cierre?
- ¿Se cobra, entrega, aprueba o archiva?
- ¿Qué estado final queda?
- ¿Qué documento o evidencia marca ese cierre?

### Objetivo
Evitar flujos mal cerrados o ambiguos.

---

## Cómo documentar un flujo

### Plantilla corta
- nombre del flujo
- objetivo
- disparador
- actores
- paso a paso
- decisiones
- datos por etapa
- estados
- esperas
- excepciones
- documentos
- cierre

---

## Ejemplos de preguntas orientadas a óptica

- Cuénteme cómo atienden a un cliente que viene con receta y quiere sus lentes, desde que entra hasta que se va con el trabajo entregado.
- ¿Qué ocurre primero: cliente, receta, montura, lente, medidas o pago?
- ¿Cuándo se envía el trabajo al laboratorio?
- ¿Qué estados atraviesa el pedido?
- ¿Qué pasa si el trabajo llega mal o requiere ajuste?
- ¿Qué pasa si el cliente deja abono y vuelve después?

## Ejemplos de preguntas orientadas a tienda de accesorios y reparación

- Cuénteme qué hacen cuando un cliente llega con un celular dañado, desde que lo reciben hasta que se lo entregan.
- ¿Qué se registra al recibir el equipo?
- ¿Quién hace el diagnóstico?
- ¿Cómo se aprueba el presupuesto?
- ¿Qué pasa si aparece una falla adicional?
- ¿Qué estados recorre la orden?
- ¿Qué pasa si el cliente no aprueba o no retira?

---

## Regla práctica

Si una explicación del cliente todavía no te deja claro quién hace qué, en qué orden, bajo qué condición y cómo termina, entonces el flujo todavía no está suficientemente descubierto.


---

## Cómo orientar al cliente para que responda mejor

### 1. Pedir narración, no teoría
En vez de pedir definiciones abstractas, conviene pedir un caso real o típico.

Ejemplo mejor:
- “Imagínese que entra un cliente ahora mismo. ¿Qué hacen primero?”

Ejemplo peor:
- “Explíqueme el proceso general de forma conceptual.”

### 2. Bajar de lo general a lo concreto
Primero se pide el flujo general. Luego se baja a:
- actores
- datos por etapa
- decisiones
- estados
- documentos
- excepciones

### 3. Usar preguntas que obliguen a precisar
- ¿Quién hace exactamente ese paso?
- ¿Qué se registra en ese momento?
- ¿Qué pasa si eso falta?
- ¿Qué condición permite avanzar?
- ¿Qué comprobante queda?
- ¿Quién recibe el caso después?

### 4. Repetir y validar lo entendido
Marcos debería cerrar cada bloque diciendo algo como:
“Entonces, hasta aquí entiendo que el flujo es así…”

Eso ayuda a que el cliente corrija vacíos, ambigüedades o supuestos.

### 5. Marcar handoffs y puntos de pérdida de información
Cuando la responsabilidad pasa de una persona a otra, hay riesgo de olvido, retraso o inconsistencia. Esos puntos deben destacarse porque suelen definir bandejas, estados y trazabilidad.
