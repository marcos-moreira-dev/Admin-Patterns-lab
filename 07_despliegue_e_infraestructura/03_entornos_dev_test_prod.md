# Entornos dev, test y prod

## Idea principal
Un sistema no debería comportarse igual en todos los entornos, aunque el código base sea el mismo.

## Entornos mínimos
### Desarrollo
Donde programas y pruebas rápido.
Características:
- logs más verbosos
- base de datos de desarrollo
- configuraciones más flexibles
- datos de prueba

### Test o staging
Entorno intermedio para validar antes de producción.
Características:
- más parecido a producción
- menos ruido que desarrollo
- validación de despliegue y configuración

### Producción
Entorno real del cliente.
Características:
- datos reales
- configuración estricta
- logs útiles pero no excesivos
- acceso controlado
- backups y monitoreo

## Qué no mezclar
- credenciales
- bases de datos
- archivos subidos
- URLs de servicios
- configuración de correo o integraciones

## Regla práctica
El sistema debe poder arrancar en varios entornos cambiando configuración, no código fuente.
