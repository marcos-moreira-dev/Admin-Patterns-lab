# Configuración y variables de entorno

## Idea principal
La configuración sensible o variable no debe quedar pegada al código.

## Qué suele ir en variables de entorno
- URL de base de datos
- usuario y contraseña
- JWT secret o claves equivalentes
- puertos
- rutas de almacenamiento
- correo y credenciales
- perfil activo
- URLs de servicios externos

## Qué no debe ir en el repositorio
- contraseñas reales
- secretos
- tokens
- certificados privados
- rutas locales de una sola máquina

## En Spring Boot
Esto suele aterrizarse con:
- perfiles
- `application.yml`
- `application-dev.yml`
- `application-prod.yml`
- variables inyectadas desde el entorno

## Buen criterio
- configuración técnica fuera del código
- defaults razonables solo para desarrollo
- ejemplo de `.env` o documentación clara
- fallar pronto si falta una variable crítica
