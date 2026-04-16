# Bases de datos en despliegue

## Qué debes pensar
Desplegar una base de datos no es solo crear tablas.

## Piezas mínimas
- entorno de base por ambiente
- migraciones
- usuario y permisos mínimos
- backups
- restauración básica
- datos semilla cuando apliquen

## Migraciones
Sirven para que el esquema evolucione de forma controlada y repetible.

## Qué evitar
- tocar la base “a mano” sin registro
- cambiar columnas en producción sin pensar impacto
- usar una sola base para todo
- no saber restaurar un respaldo

## Mapa mental sano
- diseño conceptual y lógico primero
- esquema físico versionado
- migraciones controladas
- respaldo antes de cambios delicados
