# Cuidados al evolucionar el esquema

## Idea principal

Cambiar el esquema de una base de datos no es solo “editar tablas”. Cada cambio puede afectar datos existentes, backend, reportes, integraciones y UI. Por eso, la evolución del esquema debe tratarse como parte del diseño del sistema, no como detalle de última hora.

## Riesgos típicos

Cuando se evoluciona el esquema sin cuidado, suelen aparecer problemas como estos:

- pérdida de datos
- columnas viejas que ya nadie usa pero nadie se atreve a borrar
- backend nuevo hablando con base vieja
- reportes rotos por cambios de nombres o tipos
- desktop o frontend esperando campos que ya no existen
- datos inconsistentes por cambios incompletos

## Cuidados mínimos

### 1. No cambies producción “a mano” sin rastro

Si en algún momento haces un arreglo manual por emergencia, ese cambio debe quedar documentado y convertido luego en migración formal. Lo ideal sigue siendo que el cambio real viva en el repositorio, no solo en la memoria de alguien.

### 2. No mezcles demasiadas intenciones en una sola migración

Si una migración:
- crea tablas
- cambia restricciones
- mueve datos
- renombra columnas
- y además mete catálogos

entonces será más difícil de revisar, probar y corregir.

### 3. Ten especial cuidado con operaciones destructivas

Estos cambios merecen doble atención:

- borrar columnas
- borrar tablas
- cambiar tipos incompatibles
- volver obligatoria una columna que hoy tiene nulos
- poner restricciones nuevas sobre datos viejos

### 4. Piensa en los datos existentes, no solo en la estructura nueva

Muchas veces el problema no es crear la nueva columna, sino decidir qué pasa con los registros que ya están guardados.

Preguntas útiles:
- ¿qué valor tendrán los registros viejos?
- ¿se necesita backfill?
- ¿hay datos que deben mapearse o traducirse?
- ¿qué registros quedarían inválidos?

### 5. Coordina el cambio con backend y UI

Toda evolución importante del esquema debe preguntarse:

- ¿qué versión del backend necesita este cambio?
- ¿qué versión del desktop o frontend espera esta estructura?
- ¿se puede desplegar primero la migración y luego el backend?
- ¿se necesita compatibilidad temporal entre versiones?

## Operaciones que conviene manejar con dos pasos

Hay cambios que suelen ser más seguros si se hacen en dos fases.

Ejemplo:
1. agregas columna nueva y convives un tiempo con la vieja
2. migras datos y cambias backend/UI
3. borras lo viejo en una migración posterior

Este enfoque suele ser más sano que renombrar o borrar todo de golpe.

## Qué revisar antes de aplicar una migración delicada

- respaldo reciente
- script revisado
- entorno de prueba similar
- impacto en integraciones
- impacto en reportes
- impacto en consultas pesadas
- plan de reversa o de corrección
- ventana razonable para aplicar el cambio

## Qué conviene evitar por defecto

- tocar nombres históricos por capricho
- rehacer la base completa si el cambio real es pequeño
- corregir datos masivamente sin respaldo previo
- confiar en que “como es un cambio simple, no pasa nada”

## Regla práctica

Si una migración puede romper algo visible del negocio, deja de ser una simple tarea técnica y pasa a ser una operación que necesita contexto, validación y cuidado.

## Resultado esperado

Evolucionar el esquema debe sentirse como una actividad controlada: pequeña cuando se pueda, gradual cuando convenga, y siempre coordinada con el resto del sistema.
