# Testing del backend

## Para qué sirve
No es solo para “pasar checks”. Sirve para:
- validar reglas
- proteger refactors
- evitar regresiones
- asegurar operaciones críticas

## Qué conviene probar primero
- casos de uso importantes
- validaciones de negocio
- cambios de estado
- seguridad básica
- contratos principales de la API

## Tipos de prueba útiles
### Unitarias
Prueban piezas pequeñas y lógica aislada.

### Integración
Prueban interacción entre capas o con persistencia.

### End-to-end o más funcionales
Prueban recorridos más completos.

## En proyectos administrativos
No hace falta inflar testing sin criterio. Conviene priorizar:
- operaciones críticas
- reglas de negocio delicadas
- módulos transaccionales
- autenticación y autorización
