# Cuándo no meter complejidad

## Propósito

Este documento existe para poner freno donde la intuición técnica puede volverse ansiedad arquitectónica.

## Idea principal

La complejidad no es señal automática de profesionalismo. Muchas veces es solo costo anticipado.

## Cuándo no conviene meter complejidad

### 1. Cuando el flujo principal todavía no está validado
Si todavía no sabes con claridad cuál es el proceso central que el cliente realmente necesita, endurecer arquitectura es prematuro.

### 2. Cuando el sistema sigue en MVP o V1
En una primera versión suelen pesar más la claridad, la operatividad y la velocidad razonable que la sofisticación invisible.

### 3. Cuando la supuesta abstracción no protege de nada real
Si una clase nunca cambió, la librería lleva años estable y no existe frontera externa importante, meter interfaz, adaptador y otra capa puede ser puro ruido.

### 4. Cuando el equipo es pequeño y el dominio todavía es acotado
Con uno o pocos desarrolladores, un monolito modular bien ordenado suele ser más sano que una arquitectura distribuida o demasiado fragmentada.

### 5. Cuando la complejidad dificulta cambiar algo pequeño
Si agregar un campo o una validación trivial obliga a tocar demasiados archivos, probablemente la estructura dejó de servir al problema y empezó a servirse a sí misma.

### 6. Cuando aparece también en base de datos o UI
La sobreingeniería no vive solo en backend. También aparece cuando:
- llenas la BD de catálogos y tablas que nadie usa
- fragmentas el desktop en demasiados componentes
- metes state management o routing complejo sin necesidad
- haces el diseño de pantallas más sofisticado que el flujo real

## Complejidad que sí puede valer la pena

- seguridad básica real
- trazabilidad mínima real
- migraciones controladas
- separación por módulos de negocio
- contratos claros en puntos de integración
- pruebas mínimas sobre lo crítico

## Regla práctica

Antes de agregar una capa, una interfaz o un patrón, conviene preguntar:

- ¿qué problema real resuelve?
- ¿qué dolor actual evita?
- ¿qué costo me agrega hoy?
- ¿qué señal me demuestra que ya lo necesito?

Si no hay una respuesta concreta, probablemente todavía no hace falta.

## Resultado esperado

Debes salir de aquí con una disciplina de contención: construir lo suficiente para avanzar sin bloquear el crecimiento futuro, pero sin inflar el sistema antes de tiempo.
