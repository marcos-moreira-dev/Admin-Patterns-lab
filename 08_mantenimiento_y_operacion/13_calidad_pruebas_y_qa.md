# Calidad, pruebas y QA

## QA en este contexto
QA no es solo “hacer tests”. Es pensar cómo asegurar que lo construido funcione, se entienda y no rompa flujos importantes.

## Qué deberías cubrir como mínimo
- happy path de los flujos principales
- casos raros relevantes
- validaciones críticas
- permisos y restricciones
- regresiones en módulos ya usados
- mensajes de error comprensibles

## Tipos de revisión útiles
- pruebas manuales por flujo
- pruebas unitarias o de servicio donde valga la pena
- revisión de contratos API
- validación con datos demo o seeds
- smoke test antes de publicar

## Regla práctica
La calidad no aparece al final por magia. Se prepara desde el diseño, se refuerza en backend y se comprueba en los flujos reales.
