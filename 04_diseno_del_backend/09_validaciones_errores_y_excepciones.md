# Validaciones, errores y excepciones

## Validaciones
No todas son iguales. Conviene separar mentalmente:

### Validación de formato o entrada
Ejemplos:
- campo vacío
- email inválido
- número fuera de rango

### Validación de negocio
Ejemplos:
- no hay stock
- el estado actual no permite aprobar
- el cliente no cumple condición de garantía

### Validación de seguridad
Ejemplos:
- rol insuficiente
- usuario no autorizado para esa sucursal

## Errores
Conviene distinguir:
- error de usuario
- error de negocio
- error técnico
- error inesperado

## Excepciones
Úsalas para representar condiciones realmente anómalas o de negocio importantes, no como sustituto de cualquier `if`.

## Qué debe hacer el backend
- responder con mensajes claros
- registrar contexto técnico
- no filtrar detalles sensibles
- mantener consistencia del contrato de error
