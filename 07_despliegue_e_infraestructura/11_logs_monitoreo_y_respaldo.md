# Logs, monitoreo y respaldo

## Logs
Sirven para entender qué pasó.
Mínimo útil:
- inicio y fin de operaciones críticas
- errores con contexto
- ids de entidades relevantes
- correlation id si existe

## Monitoreo
No necesitas una plataforma gigantesca desde el día uno.
Sí conviene saber al menos:
- si el sistema está arriba
- si responde
- si la base conecta
- si hay errores recurrentes

## Respaldo
Respaldo sin restauración probada no da demasiada seguridad.
Debes pensar:
- qué se respalda
- cada cuánto
- dónde
- cómo se restaura

## Error clásico
Tener producción “funcionando” pero sin logs útiles, sin respaldo verificable y sin saber qué pasó cuando algo falla.
