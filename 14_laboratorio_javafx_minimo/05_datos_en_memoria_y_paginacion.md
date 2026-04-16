# Datos en memoria y paginación

El laboratorio no usa base de datos. Todo funciona con datos en memoria para mantener el foco en la interacción y en la estructura del código.

## Qué usar

- `ObservableList`
- servicios mock
- generadores simples de registros
- listas prellenadas

## Qué sí simular

- paginación en catálogos y búsquedas
- filtros de texto
- selección de filas
- cambio de estados
- eventos simples del wizard

## Qué no complicar

- persistencia real
- hilos avanzados
- seguridad real
- backend real

## Idea práctica

Cuando se necesite mostrar paginación, conviene tener suficientes registros en memoria para que el patrón se vea claramente.
