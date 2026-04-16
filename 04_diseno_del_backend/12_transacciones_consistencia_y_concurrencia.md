# Transacciones, consistencia y concurrencia

## Transacción
Agrupa operaciones que deben ejecutarse como una unidad lógica. Si algo falla, no conviene dejar cambios a medias.

## Consistencia
El sistema debe evitar estados inválidos.
Ejemplos:
- venta registrada sin detalle
- orden aprobada sin presupuesto
- stock negativo por doble operación

## Concurrencia
Aparece cuando varias acciones o usuarios pueden tocar lo mismo al mismo tiempo.

## Qué pensar
- qué operaciones deben ser atómicas
- qué riesgos de doble acción existen
- si hace falta bloqueo optimista o pesimista
- qué hacer ante conflicto

## Rollback
Si una operación crítica falla a mitad, a veces necesitas deshacer lo parcial para no dejar el sistema inconsistente.

## Criterio práctico
No conviertas todo en paranoia transaccional, pero sí protege:
- pagos
- ventas
- aprobaciones críticas
- cambios de estado sensibles
- movimientos de stock
