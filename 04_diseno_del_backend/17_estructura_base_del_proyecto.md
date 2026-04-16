# Estructura base del proyecto

## Objetivo
Tener una estructura repetible y suficientemente profesional para arrancar proyectos con menos improvisación.

## Enfoque recomendado
Monolito modular con separación por capas internas.

## Ejemplo mental
```text
src/main/java/com/tuempresa/app/
  shared/
  security/
  config/
  clientes/
    application/
    domain/
    infrastructure/
    web/
  ordenes/
    application/
    domain/
    infrastructure/
    web/
  reportes/
    application/
    domain/
    infrastructure/
    web/
```

## Shared
Para piezas verdaderamente compartidas:
- paginación
- errores comunes
- seguridad común
- utilidades de infraestructura
- trazabilidad

## Qué evitar
- paquete `util` lleno de todo
- controllers separados del negocio por todo el proyecto sin modularidad
- services gigantes
- mapeadores repetidos sin criterio

## Idea final
La estructura base debe ayudarte a:
- entender el proyecto rápido
- ubicar responsabilidades
- crecer sin caos
- dirigir mejor a la IA y al mantenimiento
