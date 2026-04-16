# Compatibilidad entre base de datos, backend y UI

## Idea principal

En un sistema administrativo serio, base de datos, backend y UI no evolucionan aislados. Cada uno depende de supuestos sobre los otros. Cuando esos supuestos dejan de coincidir, aparecen errores difíciles de diagnosticar.

## La cadena real

Normalmente la cadena es esta:

- la base de datos guarda la estructura y los datos
- el backend interpreta esa estructura y expone reglas y contratos
- la UI consume esos contratos y espera ciertos nombres, estados y comportamientos

Si cambias una parte sin pensar en las otras, rompes compatibilidad.

## Ejemplos típicos de incompatibilidad

### Caso 1. Columna nueva obligatoria
Agregas una columna `estado_pago` como obligatoria.

Problema:
- la BD exige el dato
- el backend viejo no lo envía
- la UI vieja ni siquiera sabe que existe

### Caso 2. Estado renombrado
Cambias `PENDIENTE` por `POR_ATENDER`.

Problema:
- el backend filtra por el valor nuevo
- reportes viejos siguen esperando el valor anterior
- la UI colorea estados según nombres que ya no coinciden

### Caso 3. Campo eliminado
Borras una columna porque “ya no la usa nadie”.

Problema:
- el backend todavía la mapea
- el desktop la muestra en una tabla
- un reporte la usa como filtro oculto

## Compatibilidad mínima que conviene cuidar

### Compatibilidad estructural
La BD debe tener la estructura que la versión actual del backend espera.

### Compatibilidad contractual
El backend no debe cambiar respuestas o nombres de forma brusca sin que la UI lo sepa.

### Compatibilidad temporal
A veces conviene que una versión nueva del sistema conviva unos días con una anterior.

## Regla práctica

No pienses solo “¿la migración corre?”. Piensa también:

- ¿la app actual entiende este nuevo esquema?
- ¿la siguiente versión del backend necesita convivir con datos viejos?
- ¿la UI seguirá funcionando mientras el despliegue se completa?

## Estrategias sanas

### 1. Cambios aditivos primero
Primero agregar, luego migrar uso, y solo después retirar lo viejo.

### 2. Compatibilidad temporal
Durante una transición, el backend puede soportar estructura vieja y nueva si el cambio lo amerita.

### 3. Despliegue por fases
En ciertos cambios, conviene:
1. desplegar migración compatible
2. desplegar backend nuevo
3. desplegar UI nueva
4. limpiar legado en una fase posterior

## Qué documentos deberían conversar entre sí

Este documento no vive solo. Debe conectarse con:

- migraciones y versionado
- orden de despliegue
- mantenimiento en producción
- contratos API
- diseño de estados y reglas

## Señales de que no estás cuidando compatibilidad

- cada despliegue rompe algo inesperado
- una pantalla deja de mostrar información sin error claro
- el backend “compila”, pero falla al guardar
- empiezan a aparecer if raros para soportar versiones mezcladas
- ya nadie sabe qué versión conversa con cuál

## Resultado esperado

La compatibilidad entre BD, backend y UI debe verse como una responsabilidad de diseño y despliegue. No basta con que cada parte funcione sola; tienen que evolucionar con coordinación.
