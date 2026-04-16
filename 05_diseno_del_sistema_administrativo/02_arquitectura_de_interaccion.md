# Arquitectura de interacción

## Idea principal
La arquitectura de interacción describe cómo el usuario recorre el sistema, qué estructura visual encuentra y qué patrón de trabajo domina cada módulo.

## Capas mentales útiles
- navegación general
- patrón del módulo
- detalle de interacción
- validación y feedback

## Estructura base recomendada
Para una app administrativa sobria:
- sidebar para áreas principales
- topbar para contexto, sesión y acciones globales
- workspace central para el módulo activo
- diálogos o paneles secundarios para acciones puntuales

## Preguntas clave
- ¿qué ve primero el usuario?
- ¿qué tarea hace más veces al día?
- ¿qué cosas deben resolverse en pocos clics?
- ¿qué acciones son peligrosas o críticas?
- ¿qué parte necesita contexto histórico?

## Patrones fuertes
### Lista → detalle
Sirve para bandejas, búsqueda, expediente ligero.

### Filtros → tabla → acción
Sirve para CRUD, reportes y búsqueda.

### Pasos → resumen → confirmación
Sirve para wizard y operaciones transaccionales.

### Tarjetas → acceso
Sirve para hubs o pantallas índice.

### Cabecera + tabs + acciones
Sirve para expedientes o casos vivos.

## Buenas prácticas
- consistencia entre módulos
- acciones primarias visibles
- filtros claros
- errores entendibles
- no depender solo del color
- no saturar la pantalla
- respetar foco y orden de trabajo real

## Error común
Diseñar por inspiración visual antes de entender:
- flujo
- frecuencia de uso
- riesgo operativo
- rol del usuario
