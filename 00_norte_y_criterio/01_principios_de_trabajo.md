# Principios de trabajo

## Propósito

Este documento define los principios prácticos que deberían atravesar toda la biblioteca. No son leyes sagradas ni frases decorativas. Son reglas de criterio para evitar improvisación, sobreingeniería y decisiones técnicas que no obedecen al negocio.

## Principios principales

### 1. El negocio manda
El software administrativo existe para resolver operación real. Por eso, las decisiones de arquitectura, módulos y despliegue deben responder al problema del negocio y no al deseo de aplicar un patrón interesante.

### 2. Primero claridad, luego sofisticación
Si el problema todavía no está claro, aumentar complejidad técnica solo empeora la confusión. Primero se clarifica el flujo, la entidad, la regla y el alcance. Después se decide qué estructura técnica tiene sentido.

### 3. El producto inicial debe ser defendible
Una V1 o un MVP no tienen que ser perfectos, pero sí deben poder explicarse, operar y cobrarse con dignidad. Minimal no significa descuidado.

### 4. La complejidad debe entrar con dolor real
Más capas, más abstracciones, más adaptadores o más infraestructura solo deben entrar cuando exista cambio real, frontera externa real, riesgo real o costo real de no meterlos.

### 5. No toda dependencia necesita una abstracción
Abstraer por anticipación puede generar más costo que beneficio. Conviene abstraer donde haya frontera externa, variación real o riesgo razonable de reemplazo.

### 6. Menos piezas, mejor entendidas
Un stack conservador y duradero suele ser mejor para software administrativo pequeño o mediano que una mezcla de herramientas por moda.

### 7. La documentación debe servir para trabajar
La documentación no existe para verse elegante. Existe para ayudarte a pensar, preguntar, modelar, negociar, construir, mantener y explicar.

### 8. El software es iterativo
La primera versión ordena el núcleo. Las mejoras posteriores deben justificarse por uso real, no por fantasía inicial.

### 9. La IA amplifica, no reemplaza
La IA puede acelerar redacción, análisis y código. Pero el corte de alcance, la lectura del negocio, las decisiones de riesgo y la conversación con el cliente siguen necesitando criterio humano.

### 10. La formalidad visual importa
Sobre todo en sistemas administrativos, una UI sobria, legible y consistente transmite confianza aunque no tenga lujo visual.

## Errores que estos principios intentan frenar

- arquitectura fancy por ansiedad
- capas vacías
- MVP que intenta resolver todo
- interfaces inventadas porque sí
- despliegue improvisado
- documentación bonita pero inútil
- decisiones de software desconectadas del valor real para el cliente
