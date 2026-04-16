# Seguridad operativa básica

## Enfoque
No se trata de blindar como banco, sino de no cometer errores gruesos.

## Mínimos razonables
- secretos fuera del código
- acceso restringido a producción
- usuarios con permisos mínimos
- HTTPS donde corresponda
- respaldos
- roles claros
- logs sin exponer datos sensibles
- no exponer paneles o servicios innecesarios

## En backend
- JWT o mecanismo de autenticación equivalente
- autorización por roles y permisos
- validación del lado servidor
- errores sin filtrar información sensible

## En operación
- no compartir contraseñas por cualquier lado
- no usar cuentas genéricas para todo
- registrar cambios importantes
