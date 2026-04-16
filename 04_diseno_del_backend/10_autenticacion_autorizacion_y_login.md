# Autenticación, autorización y login

## Autenticación
Responde a:
- quién es el usuario

## Autorización
Responde a:
- qué puede hacer ese usuario

## Login
Es la puerta de entrada al sistema y debe manejarse con seriedad mínima:
- credenciales
- expiración de sesión o token
- cierre de sesión
- mensajes de error razonables
- trazabilidad básica

## Qué conviene modelar
- usuarios
- roles
- permisos o capacidades
- relación con sucursal, área o contexto operativo

## En proyectos administrativos
Lo mínimo razonable suele ser:
- autenticación segura
- roles claros
- permisos por operación o módulo
- respuestas 401 y 403 consistentes

## Qué evitar
- meter permisos duros por todos lados
- confiar demasiado en la UI
- mezclar autenticación técnica con reglas de negocio
