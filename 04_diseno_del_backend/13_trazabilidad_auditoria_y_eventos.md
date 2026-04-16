# Trazabilidad, auditoría y eventos

## Trazabilidad
Permite responder:
- quién hizo qué
- cuándo
- sobre qué entidad
- con qué resultado

## Auditoría
Es la capa más de negocio del rastro:
- quién aprobó
- quién anuló
- quién cambió configuración
- quién cerró una orden

## Eventos
Ayudan a representar hechos importantes del sistema.
Ejemplos:
- venta registrada
- orden creada
- estado cambiado
- documento generado

## Qué mínimo conviene registrar
- actor
- acción
- entidad
- timestamp
- resultado
- correlation_id cuando aplique

## Por qué importa
- soporte
- investigación de errores
- responsabilidad operativa
- cumplimiento y confianza
