# Cambios evolutivos y control del alcance

## Idea principal
No todo cambio es un bug. Mucho mantenimiento real son ajustes de proceso, reglas nuevas, campos adicionales o reportes que el negocio descubre después.

## Antes de aceptar un cambio
Pregúntate:
- es corrección o evolución
- afecta base de datos
- afecta backend
- afecta UI
- rompe contratos o compatibilidad
- requiere migración o datos históricos
- entra en la fase actual o debe pasar a la siguiente

## Riesgo común
Llamar “detalle pequeño” a un cambio que en realidad toca flujo, estados, permisos o reportes.

## Regla práctica
Cada cambio nuevo debe evaluarse por impacto, no por cómo suena en conversación.
