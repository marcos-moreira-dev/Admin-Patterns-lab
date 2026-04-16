# Qué cosas se rompen o se desgastan

## No todo “se rompe” igual
En mantenimiento conviene distinguir entre fallo técnico, desgaste funcional y desalineación con el negocio.

## Cosas que suelen romperse o degradarse
- validaciones incompletas
- reglas de negocio dispersas
- permisos mal resueltos
- consultas lentas
- contratos API que cambian sin disciplina
- procesos que el cliente usa distinto a como se pensaron
- mensajes de error poco claros
- seeds, catálogos o estados desactualizados
- dependencias obsoletas o incompatibles

## Cosas que no siempre se rompen, pero se desgastan
- claridad del código
- consistencia entre módulos
- usabilidad de ciertas pantallas
- comprensión del proyecto por parte de quien lo retoma
- confianza del cliente cuando no hay trazabilidad

## Qué observar en cada revisión
- qué flujo se afectó
- qué actor lo usa
- qué estado del negocio toca
- si hay impacto en datos, seguridad o documentos
- si el cambio rompe algo existente
