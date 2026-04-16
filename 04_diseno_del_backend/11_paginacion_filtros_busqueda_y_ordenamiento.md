# Paginación, filtros, búsqueda y ordenamiento

## Por qué importan
En sistemas administrativos casi siempre aparecen listas grandes. Si no diseñas esto bien desde el backend, la UI se vuelve inconsistente o lenta.

## Paginación
Sirve para:
- limitar volumen de respuesta
- mejorar experiencia
- estandarizar listados

Conviene definir:
- tamaño de página
- número de página o cursor
- total de elementos si aplica
- orden por defecto

## Filtros
Deben responder a necesidades reales del negocio.
Ejemplos:
- estado
- fecha
- responsable
- categoría
- sucursal

## Búsqueda
Suele ser distinta del filtro exacto. Puede ser:
- texto libre
- coincidencia parcial
- búsqueda por varios campos

## Ordenamiento
Conviene permitirlo solo en campos controlados o whitelists, para evitar caos o problemas de seguridad y rendimiento.

## Respuesta típica
Una buena respuesta paginada debería incluir:
- items
- page
- size
- totalElements
- totalPages
- sort
