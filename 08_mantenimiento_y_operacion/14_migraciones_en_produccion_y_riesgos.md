# Migraciones en producción y riesgos

## Idea principal

Una migración en producción no es solo un script técnico. Es una intervención sobre un sistema vivo que puede afectar operación, datos y confianza del cliente.

## Qué vuelve riesgosa una migración en producción

- la base ya tiene datos reales importantes
- el sistema está siendo usado por personas mientras aplicas el cambio
- backend y UI dependen del esquema actual
- un error puede bloquear registros, cobros, búsquedas o reportes

## Riesgos más comunes

### 1. Pérdida de datos
Borrar, renombrar o transformar columnas sin plan claro puede dejar datos huérfanos o imposibles de recuperar.

### 2. Incompatibilidad temporal
La migración se aplica, pero el backend o la UI siguen esperando el esquema viejo.

### 3. Bloqueos o tiempos de espera
Algunas migraciones grandes pueden bloquear tablas o degradar consultas en momentos sensibles.

### 4. Datos inconsistentes
La estructura cambia, pero no se completa el backfill o la adaptación de registros existentes.

### 5. Confianza rota con el cliente
Aunque la migración se repare luego, una caída o fallo visible puede afectar percepción de estabilidad.

## Qué hacer antes de una migración delicada

- identificar impacto exacto
- revisar si el cambio puede dividirse en dos fases
- respaldar la base si el riesgo lo amerita
- probar en entorno parecido
- definir plan de validación posterior
- definir plan de reversa o corrección

## Qué hacer durante la migración

- aplicar el cambio en el orden planeado
- observar logs y errores
- validar pasos clave del sistema
- registrar qué se hizo y cuándo

## Qué hacer después

- confirmar que los flujos críticos siguen funcionando
- revisar registros viejos y nuevos
- confirmar reportes o consultas importantes
- dejar evidencia del cambio aplicado

## Regla práctica

Mientras más crítico sea el sistema o más sensibles sean los datos, menos se justifica improvisar. En producción la disciplina vale más que la velocidad impulsiva.

## Señales de alarma

- “mejor lo arreglo a mano y luego vemos”
- “no hace falta respaldo, es un cambio pequeño”
- “no importa si la UI queda rota un rato”
- “ya después documentamos”

## Resultado esperado

Las migraciones en producción deben tratarse como operaciones de riesgo controlado: preparadas, trazables y verificadas.
