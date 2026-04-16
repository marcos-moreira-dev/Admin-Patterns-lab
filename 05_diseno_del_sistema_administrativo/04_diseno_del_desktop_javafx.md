# Diseño del desktop JavaFX

## Rol del desktop

El desktop administrativo sirve bien cuando importa:
- formalidad operativa
- estabilidad visual
- entorno cerrado
- flujo continuo de trabajo
- menor dependencia del navegador

## Estructura recomendada

- `Stage` principal
- shell administrativo reutilizable
- sidebar
- topbar
- footer simple
- contenedor central para módulos o workspace

## Piezas clave

- FXML para estructura visual
- Controllers para eventos e interacción
- Services para orquestar acciones
- Models o row models para representar datos de vista
- componentes reutilizables para tablas, formularios y tarjetas
- app state compartido solo cuando varios módulos lo necesitan

## Qué no conviene hacer

- meter reglas de negocio fuertes en controllers
- hacer una sola vista inmensa con todo mezclado
- pegar llamadas HTTP o SQL en cualquier evento de UI
- usar el controller como clase dios
- crear un mini framework propio antes de validar la estructura real de la app

## Principio práctico

UI coordina.
Aplicación orquesta.
Dominio decide.
Infraestructura conecta.

## Navegación sugerida

- un `MainShellController`
- un `Navigator` o coordinador de vistas sencillo
- vistas por módulo
- diálogos y subflujos aislados
- workspace central bien definido

## Cuándo subir de nivel

Se justifica extraer más infraestructura de UI cuando:
- varias vistas comparten patrones reales
- los flujos se repiten de forma clara
- el estado compartido deja de ser trivial
- la app ya es suficientemente grande para necesitar más convenciones

## JavaFX y los tipos de módulo

Sí o sí deben traducirse a patrones concretos de UI.
No basta decir qué problema resuelven; hay que aterrizarlos en FXML, controllers y estructura de navegación.
