# Orden de despliegue y migraciones

## Propósito

Este documento explica el orden mental sano para desplegar cambios cuando el esquema de base de datos también evoluciona.

## Idea principal

Desplegar no es solo subir código nuevo. Cuando hay migraciones, el orden importa. Si lo haces mal, puedes dejar una combinación incompatible entre base de datos, backend y UI.

## Regla general

Primero se piensa en compatibilidad, luego en orden de aplicación.

## Pregunta madre

Antes de desplegar, debes preguntarte:

- ¿la migración es compatible con la versión actual del backend?
- ¿el backend nuevo puede convivir unos minutos o unas horas con el esquema anterior?
- ¿la UI nueva depende de respuestas que el backend viejo aún no entrega?

## Orden típico más sano

### Escenario simple
Cuando el cambio es aditivo y no rompe compatibilidad:

1. aplicar migración
2. desplegar backend nuevo
3. desplegar UI nueva si hace falta
4. validar flujo principal

### Escenario delicado
Cuando el cambio toca datos o rompe supuestos anteriores:

1. backup o respaldo razonable
2. aplicar migración compatible o de transición
3. desplegar backend preparado para convivir con cambio
4. desplegar UI nueva
5. validar uso real
6. limpiar estructura vieja en una iteración posterior

## Qué NO conviene hacer

- desplegar primero una UI que depende de respuestas que el backend aún no expone
- cambiar el esquema de forma destructiva sin validar el backend
- asumir que “como el cambio es pequeño” no afecta al sistema
- mezclar migración manual, backend nuevo y parche de UI sin orden claro

## Checklist de predespliegue

- migración revisada
- respaldo disponible si el cambio es delicado
- backend compatible preparado
- variables de entorno correctas
- revisión de contratos o endpoints afectados
- revisión de estados o reportes afectados
- ventana de despliegue razonable

## Validación mínima posterior

- login
- flujo principal
- búsqueda o consulta clave
- reporte más sensible
- guardado de nuevo registro
- lectura de registros viejos

## Resultado esperado

El despliegue con migraciones debe sentirse como una secuencia controlada, no como una apuesta. Cuando el orden está bien pensado, reduces roturas innecesarias y ganas confianza para evolucionar el sistema.
