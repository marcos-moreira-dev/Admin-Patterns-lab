# Relación entre módulos

## Idea principal
En un sistema administrativo, los módulos rara vez viven aislados.
Una operación suele tocar varias áreas.

## Ejemplos típicos
### Venta
Puede impactar:
- clientes
- stock
- caja
- comprobantes
- reportes

### Orden de reparación
Puede impactar:
- clientes
- diagnóstico
- aprobación
- repuestos
- garantía
- documentos
- reportes

### Pedido de lentes
Puede impactar:
- cliente
- receta
- laboratorio
- abonos
- entrega
- garantía

## Qué conviene documentar
- módulo origen
- módulo afectado
- tipo de relación
- documento generado
- cambio de estado
- impacto en reportes

## Riesgo común
Diseñar módulos demasiado separados a nivel visual y olvidar que el negocio los cruza todo el tiempo.

## Regla práctica
Cada módulo debe tener identidad propia, pero también puntos de integración claros.
