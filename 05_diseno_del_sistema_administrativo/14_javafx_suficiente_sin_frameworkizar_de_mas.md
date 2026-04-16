# JavaFX suficiente sin frameworkizar de más

## Propósito

Este documento fija criterios para construir desktop administrativos serios en JavaFX sin convertir el proyecto en un mini framework interno innecesario.

## Idea principal

Una app desktop administrativa necesita:
- shell claro
- navegación estable
- módulos entendibles
- controllers legibles
- estado compartido donde aporte
- servicios simples
- componentes reutilizables con criterio

No necesita una fábrica abstracta para cada botón ni una jerarquía compleja de controllers si el flujo aún es pequeño.

## Qué conviene mantener simple

- una vista FXML por pantalla o módulo principal
- un controller por vista principal
- componentes reutilizables solo donde hay repetición real
- navegación centralizada sin magia excesiva
- estado compartido simple cuando varios módulos lo necesitan
- servicios in-memory o de integración claros

## Qué no conviene hacer todavía

- framework propio de UI sin necesidad
- 10 helpers para abrir una vista simple
- demasiados subcontrollers diminutos
- factories y wrappers para controles comunes que apenas cambian
- jerarquías complejas de layouts solo por elegancia
- un sistema sofisticado de eventos internos para flujos simples

## Cuándo sí subir de nivel

- muchas pantallas comparten comportamiento real
- varios módulos necesitan el mismo patrón de navegación
- el estado compartido ya aparece en varias áreas
- la app ya tiene suficiente tamaño como para justificar convenciones más fuertes

## Señales de sobreingeniería en JavaFX

- cambiar un texto obliga a pasar por demasiadas clases
- abrir una vista requiere demasiadas capas
- hay más infraestructura de UI que interacción real
- los nombres de componentes ya no ayudan a orientarse
- el proyecto parece construido para demostrar patrones, no para operar

## Regla práctica

Empieza con una shell clara, un workspace bien definido, módulos bien nombrados y ayudas compartidas razonables. Solo extrae infraestructura adicional cuando varias pantallas o variantes la exijan de verdad.

## Resultado esperado

JavaFX debe sentirse como herramienta operativa, no como campo de experimentación arquitectónica.
