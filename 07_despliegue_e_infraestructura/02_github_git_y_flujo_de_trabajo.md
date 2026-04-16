# GitHub, Git y flujo de trabajo

## Para qué sirve esta parte
Ordena el trabajo, deja evidencia y permite volver atrás con seguridad razonable.

## Mínimo que conviene dominar
- repositorio limpio
- commits con intención clara
- ramas cuando haga falta
- tags o versiones
- releases
- README útil
- `.gitignore` bien hecho
- no subir secretos ni archivos temporales

## Flujo base recomendado
### Si trabajas solo
- `main` estable
- cambios pequeños y frecuentes
- commits claros
- tag por entregas importantes

### Si el proyecto ya crece
- rama de trabajo para cambios sensibles
- revisión antes de mezclar
- versionado por hitos

## Qué dejar documentado
- cómo levantar el proyecto
- cómo correr tests básicos
- cómo construir el artefacto
- variables de entorno necesarias
- comandos importantes
- estructura del proyecto

## Buenas prácticas simples
- no mezclar cambios distintos en un solo commit
- no usar mensajes tipo “arreglo cosas”
- no subir claves, contraseñas ni `.env`
- no usar el repositorio como carpeta de basura
- usar tags para hitos reales

## Ejemplos de commits más sanos
- `feat: agrega módulo de órdenes`
- `fix: corrige validación de stock`
- `refactor: separa servicio de aprobación`
- `docs: actualiza README de despliegue`
