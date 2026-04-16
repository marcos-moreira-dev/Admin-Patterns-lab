# Endpoints, DTOs y contratos API

## Endpoint
Es un punto de entrada expuesto por la API para realizar una consulta u operación.

## DTO
Objeto de transferencia de datos. Sirve para definir con claridad qué entra y qué sale del backend.

## Por qué importan
Evitan exponer el modelo interno tal cual y ayudan a:
- controlar el contrato
- validar datos
- mantener compatibilidad
- diseñar respuestas consistentes

## Convenciones sanas
### Requests
Deben ser explícitos y alineados con la operación.
Ejemplo:
- CreateOrderRequest
- ApproveBudgetRequest

### Responses
Deben ser claras y estables.
Ejemplo:
- OrderDetailResponse
- PageResponse<T>

## Contratos API
Conviene documentar:
- rutas
- métodos HTTP
- payloads
- códigos de respuesta
- errores esperados
- paginación y filtros
- autenticación requerida

## Respuesta uniforme
En proyectos administrativos conviene usar contratos consistentes.
Ejemplo de idea:
- `ok`
- `data`
- `meta`
- `error`
