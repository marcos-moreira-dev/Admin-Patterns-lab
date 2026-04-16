# Integración desktop-backend

## Idea principal
El desktop no debe saber más de la cuenta sobre HTTP, JSON o detalles de infraestructura.
Conviene encapsular esa integración.

## Piezas recomendadas
- cliente HTTP o capa de acceso remoto
- DTOs de request y response
- mappers hacia modelos de vista
- servicios de aplicación del lado UI
- manejo consistente de errores remotos

## Qué debe hacer la capa de integración
- enviar peticiones
- recibir respuestas
- transformar datos
- traducir errores técnicos a mensajes útiles

## Qué no debe hacer la vista
- construir URLs por todos lados
- parsear JSON manualmente en controllers
- mezclar estado de formulario con lógica de conexión

## Casos importantes
- login
- carga de tablas
- detalle de expedientes
- operaciones transaccionales
- generación o descarga de documentos

## Regla práctica
UI habla con servicios.
Servicios hablan con backend.
La vista no debería quedar acoplada a detalles de red.
