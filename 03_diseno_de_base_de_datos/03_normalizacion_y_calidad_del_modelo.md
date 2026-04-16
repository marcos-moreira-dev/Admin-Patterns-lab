# Normalización y calidad del modelo

## Propósito

Este documento recuerda cómo revisar la calidad del modelo lógico antes de convertirlo en esquema físico definitivo. En sistemas administrativos normales, una meta práctica razonable es llegar al menos a una estructura limpia cercana a 3FN.

## Qué busca la normalización

La normalización ayuda a evitar:

- redundancia innecesaria
- inconsistencias de actualización
- estructuras ambiguas
- columnas repetidas o mal agrupadas
- dependencias extrañas entre datos

## Regla práctica de trabajo

No normalizar por dogma, sino por claridad y consistencia.

La pregunta correcta no es “¿cómo llego a la teoría más pura?”, sino:

**¿esta estructura representa una sola cosa, sin duplicar datos sin necesidad y sin dejar reglas escondidas?**

## Dónde sí conviene ser estricto

- catálogos importantes
- relaciones de negocio centrales
- restricciones de unicidad
- separación entre estado actual e histórico
- tablas puente que de verdad resuelven N:M

## Dónde conviene no caer en purismo

- histórico donde sí necesitas congelar un valor
- detalles transaccionales que deben reflejar el estado del momento
- pequeñas desnormalizaciones justificadas por consulta o auditoría
- reportes que requieren materializar cierta información

## Revisión mínima por niveles

### 1FN
Preguntarse:
- ¿cada columna guarda un valor atómico?
- ¿evité listas metidas dentro de un campo?
- ¿evité columnas repetidas sin criterio?

### 2FN
Preguntarse:
- si hubiera clave compuesta, ¿todos los campos dependen de toda la clave?
- ¿no hay atributos que realmente pertenezcan a otra entidad?

### 3FN
Preguntarse:
- ¿hay campos que dependen de otro campo no clave y no de la PK?
- ¿hay descripciones duplicadas que deberían venir desde catálogo o tabla relacionada?

## Señales de modelo sano

- cada tabla representa una sola idea del negocio
- los catálogos están bien separados cuando hace falta
- el historial no se mezcla con el estado actual
- las tablas puente existen donde deben existir
- los datos derivados innecesarios no se guardan sin razón
- las unicidades importantes están claras

## Señales de modelo enfermo

- muchas columnas que parecen “parches”
- demasiados campos de texto libre para valores repetidos
- tablas que representan dos o tres conceptos mezclados
- necesidad frecuente de copiar información de otra tabla
- estado actual e historial mezclados sin criterio
- campos calculados guardados sin necesidad de negocio

## Casos donde desnormalizar puede tener sentido

La desnormalización puede ser válida cuando:
- mejora mucho la consulta
- el dato necesita congelarse históricamente
- el costo de recalcularlo es alto
- el negocio necesita ver el valor tal como existía en ese momento

Ejemplo clásico:
- guardar nombre del producto y precio en `detalle_venta` aunque el producto cambie después

## Resultado esperado

Al terminar esta revisión, el modelo lógico debe estar limpio, estable y sin purismos que vuelvan torpe el uso real del sistema.
