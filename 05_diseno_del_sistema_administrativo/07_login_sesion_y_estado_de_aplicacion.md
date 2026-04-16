# Login, sesión y estado de aplicación

## Login
Debe resolver acceso inicial con claridad.
No debe ser solo una pantalla bonita.
Debe responder:
- quién entra
- con qué rol
- a qué contexto entra

## Sesión
En desktop administrativo normalmente importa:
- usuario autenticado
- rol o permisos
- sede o contexto activo si aplica
- token o credencial temporal
- cierre de sesión y expiración

## Estado global de aplicación
Hay información que varias vistas necesitan conocer:
- usuario actual
- permisos
- configuración base
- conexión con backend
- contexto seleccionado

## Qué conviene centralizar
- `SessionContext`
- `AppState`
- servicios de autenticación
- notificaciones globales

## Qué no conviene
- pasar el usuario logueado manualmente por todas las vistas
- duplicar chequeos de permisos por todos lados sin orden
- mezclar estado de sesión con estado del formulario actual

## En JavaFX
Piezas comunes:
- vista de login en FXML
- controller de autenticación
- service de auth
- clase central de sesión
- navegación condicionada por login
