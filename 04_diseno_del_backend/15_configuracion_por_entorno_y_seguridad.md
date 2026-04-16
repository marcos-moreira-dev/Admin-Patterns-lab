# Configuración por entorno y seguridad

## Entornos
Conviene separar al menos:
- desarrollo
- pruebas
- producción

## Configuración
No debe quedar dura en el código cuando se trata de:
- claves
- URLs
- credenciales
- rutas de archivos
- parámetros sensibles

## Variables de entorno
Son la vieja confiable para no mezclar secretos con el código fuente.

## Seguridad mínima práctica
- secretos fuera del repositorio
- perfiles por entorno
- logging sin datos sensibles
- permisos mínimos
- endpoints protegidos
- configuración de CORS si aplica
- manejo razonable de errores y exposición
