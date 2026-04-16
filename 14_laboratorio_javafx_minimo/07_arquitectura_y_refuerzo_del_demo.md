# Arquitectura y refuerzo del demo

El laboratorio JavaFX se apoya en una shell fija con sidebar, top bar, workspace y footer. La lógica de demostración usa datos en memoria y un estado compartido simple para que varios módulos reaccionen a las mismas colecciones.

## Piezas principales
- Shell con navegación por categoría y variante.
- Workspace central donde se intercambia el contenido.
- `AppState` como estado compartido en memoria.
- `VariantContentFactory` como ensamblador de las variantes.
- `SharedUiFactory` como fuente de botones, paneles y encabezados reutilizables.

## Qué se reforzó
- Contraste visual y footer más legible.
- Botones con estilos coherentes y menos compresión.
- Sidebar colapsable.
- Mensajes de ayuda por módulo.
- Más seeds demo para tablas, agenda, casos y gastos.
