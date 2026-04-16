# Obsolescencia de librerías y dependencias

## Idea principal
No se trata de actualizar por moda ni de congelar todo para siempre. Se trata de estabilidad con vigilancia mínima.

## Principios útiles
- usar pocas dependencias, bien elegidas
- preferir librerías maduras y justificadas
- evitar meter una dependencia para resolver algo trivial
- encapsular librerías importantes detrás de una capa propia
- revisar compatibilidad con tu versión de Java, Spring Boot o JavaFX

## Señales de riesgo
- librería abandonada
- documentación vieja
- issues graves sin resolver
- incompatibilidad con el runtime
- licencia problemática
- demasiado acoplamiento a una API externa

## Regla práctica
Si mañana quisieras reemplazar esa dependencia, el costo no debería destruir medio proyecto.
