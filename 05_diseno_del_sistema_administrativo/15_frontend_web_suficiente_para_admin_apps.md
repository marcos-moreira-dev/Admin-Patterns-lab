# Frontend web suficiente para admin apps

## Propósito

Este documento fija criterios para construir frontend web administrativo sobrio, mantenible y útil sin meter complejidad excesiva desde el primer día.

## Idea principal

La web administrativa necesita:
- layouts claros
- rutas entendibles
- formularios confiables
- tablas usables
- estado compartido donde realmente haga falta
- componentes reutilizables con criterio

No necesita parecer una plataforma gigante si todavía es una V1 para operación interna.

## Qué conviene mantener simple

- una estructura clara por pantallas o features
- routing directo y comprensible
- guards solo cuando realmente protegen algo útil
- servicios de acceso a API simples
- estado local o por feature cuando basta
- componentes reutilizables en tablas, formularios y layouts

## Qué no conviene hacer todavía

- state management complejo por reflejo
- capas frontend que solo envuelven otras capas
- componentes ultra genéricos que nadie entiende
- wrappers de wrappers para inputs y tablas
- overengineering del router o del layout
- “arquitectura enterprise” para un panel administrativo pequeño

## Cuándo sí subir de nivel

- varias pantallas comparten estado complejo
- la navegación ya necesita más control
- varias áreas cambian a ritmos distintos
- el frontend ya es suficientemente grande como para requerir límites más fuertes

## Señales de sobreingeniería en frontend

- demasiados archivos para una vista simple
- difícil rastrear de dónde sale el dato real
- componentes tan genéricos que cuestan más de usar que de rehacer
- servicios frontend que solo repiten nombres sin aportar control
- rutas y guards más complejos que el negocio real

## Regla práctica

El frontend web administrativo debe priorizar claridad, consistencia y operación. Primero estructura por features, layouts sobrios y formularios buenos. Solo después endurece estado, reutilización y capas si el tamaño real lo exige.

## Resultado esperado

Un frontend administrativo suficiente debe ser fácil de navegar, fácil de cambiar y suficientemente serio para operar sin volverse una maqueta inflada.
