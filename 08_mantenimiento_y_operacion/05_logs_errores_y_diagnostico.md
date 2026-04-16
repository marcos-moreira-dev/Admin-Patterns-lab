# Logs, errores y diagnóstico

## Qué deben permitir los logs
- saber dónde falló algo
- entender el contexto mínimo
- seguir un incidente de punta a punta
- separar información útil de ruido

## Tipos de mensajes útiles
- informativos
- advertencias
- errores funcionales
- errores técnicos

## Qué sí conviene incluir
- módulo
- endpoint o caso de uso
- identificador de entidad si aplica
- correlation_id
- actor cuando sea posible
- resumen del error

## Qué evitar
- logs sin contexto
- mensajes ambiguos
- imprimir datos sensibles
- llenar la salida con detalles irrelevantes en operación normal

## Regla práctica
Si mañana algo falla, el log debe ayudarte a entender la situación sin obligarte a reconstruir todo desde memoria.
