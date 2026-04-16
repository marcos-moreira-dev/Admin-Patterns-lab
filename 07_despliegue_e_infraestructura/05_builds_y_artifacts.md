# Builds y artifacts

## Qué es un build
El proceso de compilar, empaquetar y dejar el software listo para ejecutarse o distribuirse.

## Qué es un artifact
El resultado del build.
Ejemplos:
- JAR o WAR del backend
- instalador o paquete desktop
- carpeta de frontend compilado
- imagen de contenedor si aplica

## Qué conviene cuidar
- que el build sea reproducible
- que no dependa de pasos mágicos manuales
- que quede claro qué versión se generó
- que los artefactos no mezclen configuración sensible

## En tu contexto
### Backend
- JAR ejecutable de Spring Boot
- versión clara
- documentación de cómo correrlo

### Desktop
- entrega empaquetada
- instrucciones de ejecución
- ubicación de configuración externa si existe

## Error común
Tener un proyecto que “funciona en la máquina del desarrollador” pero no tiene un artefacto claro ni un proceso de construcción confiable.
