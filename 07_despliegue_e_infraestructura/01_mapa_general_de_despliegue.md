# Mapa general de despliegue

## Idea principal
Desplegar no es solo “subir el backend”. Es convertir un sistema que funciona en desarrollo en una solución operable, reproducible y mantenible.

## Objetivo del despliegue
- publicar una versión utilizable
- separar entornos
- proteger configuración sensible
- asegurar trazabilidad mínima
- poder corregir y volver atrás si algo falla

## Piezas que intervienen
- repositorio Git
- build del backend
- base de datos
- variables de entorno
- artefactos o imágenes
- servidor o plataforma de ejecución
- logs y monitoreo básico
- backups
- proceso de actualización

## Cadena mental mínima
1. el código vive en Git
2. el proyecto genera un artefacto reproducible
3. la configuración sensible vive fuera del código
4. la base de datos se crea y evoluciona con migraciones
5. cada entorno tiene su propia configuración
6. el sistema deja trazas mínimas para diagnóstico
7. el despliegue debe poder repetirse y documentarse

## Entornos mínimos
- desarrollo
- pruebas o staging
- producción

## Error clásico
Creer que “despliegue” es una tarea final y menor. En sistemas serios pequeños, el despliegue debe pensarse desde el inicio:
- cómo se configura
- cómo se conecta a la base
- cómo se registran errores
- cómo se actualiza
- cómo se respalda
