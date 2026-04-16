# Trazabilidad básica en backend

## Objetivo
Poder responder preguntas como:
- quién hizo la acción
- qué pasó
- cuándo pasó
- sobre qué entidad ocurrió
- con qué resultado terminó

## Mínimo que conviene registrar
- usuario o actor
- acción o evento
- entidad afectada
- identificador de entidad
- estado anterior y nuevo, si aplica
- timestamp
- resultado: OK o ERROR
- correlation_id o identificador de seguimiento
- endpoint o caso de uso involucrado

## Operaciones donde sí conviene trazar
- login y logout
- creación de entidades importantes
- cambio de estado
- aprobaciones y rechazos
- anulaciones
- generación de documentos
- subida o eliminación de archivos
- errores inesperados
- operaciones transaccionales críticas

## Ejemplo mental de evento trazado
- usuario: marcos
- accion: APROBAR_PRESUPUESTO
- entidad: orden_reparacion
- id_entidad: 123
- estado_anterior: ESPERANDO_APROBACION
- estado_nuevo: APROBADA
- resultado: OK
- correlation_id: abc-123

## Regla práctica
Traza lo importante para diagnóstico y auditoría, pero no llenes el sistema de ruido inútil.
