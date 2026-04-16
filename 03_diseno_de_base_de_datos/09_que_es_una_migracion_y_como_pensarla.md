# Qué es una migración y cómo pensarla

## Idea central

Una migración de base de datos es un cambio controlado, versionado y reproducible sobre el esquema o sobre ciertos datos estructurales del sistema. No es el SQL “completo” de toda la base, sino cada paso de evolución que permite pasar de una versión a otra sin perder el rastro.

En una aplicación administrativa real, la base de datos no se queda congelada. El negocio cambia, aparecen nuevos campos, cambian estados, se crean reportes nuevos y ciertos procesos dejan de funcionar igual que al inicio. Por eso el esquema debe evolucionar con disciplina.

## Qué cosas sí pueden ser una migración

Una migración puede:

- crear una tabla
- agregar una columna
- cambiar un tipo de dato
- crear o quitar un índice
- agregar un constraint
- renombrar una tabla o columna
- dividir una tabla en dos
- mover datos de una estructura vieja a una nueva
- poblar catálogos base que el sistema necesita para arrancar

## Qué problema resuelve

Las migraciones resuelven algo muy concreto: evitan que cada entorno tenga una base distinta “porque alguien la tocó a mano”.

Cuando no hay migraciones serias, suelen pasar cosas como estas:

- en tu laptop una columna existe y en producción no
- el backend nuevo espera un campo que el esquema viejo no tiene
- el desktop rompe porque el backend cambió y la BD quedó atrás
- alguien hace cambios manuales en producción y luego nadie recuerda qué hizo
- una nueva instalación del sistema no puede reconstruirse de forma limpia

## Qué no es una migración

No conviene confundir migración con:

- un backup
- un seed de prueba aislado
- un script suelto “para arreglar algo rápido”
- un dump completo de la base sin contexto
- una modificación manual en producción sin registro

## Cómo pensar una migración

La manera correcta de pensar una migración no es “qué SQL me falta escribir”, sino esta secuencia:

1. qué cambio del negocio o del sistema la justifica
2. qué parte del esquema toca
3. si afecta datos existentes
4. si exige adaptación de backend o UI
5. si rompe compatibilidad con versiones anteriores
6. cómo validar que quedó bien aplicada
7. si existe forma de volver atrás o al menos de corregir

## Las tres clases mentales más útiles

### 1. Migraciones estructurales
Cambian la forma del esquema.

Ejemplos:
- crear tabla `orden_reparacion`
- agregar columna `telefono`
- crear índice en `fecha_creacion`

### 2. Migraciones de transición
Sirven cuando no basta con crear una tabla o columna, sino que hay que mover el sistema de una estructura vieja a una nueva.

Ejemplos:
- dividir `nombre_completo` en `nombres` y `apellidos`
- mover estados viejos a un catálogo nuevo
- recalcular un campo a partir de datos anteriores

### 3. Migraciones de estabilización
Afinan restricciones, índices o reglas una vez que la estructura principal ya existe.

Ejemplos:
- volver obligatoria una columna que antes era nullable
- poner `UNIQUE` donde antes no lo había
- agregar un índice porque la consulta real ya demostró que lo necesita

## Qué preguntas conviene hacerse antes de crear una migración

- ¿Este cambio nace de una necesidad del negocio o de una corrección técnica?
- ¿La base ya tiene datos reales que pueden verse afectados?
- ¿El backend actual seguirá funcionando mientras el cambio se despliega?
- ¿La UI espera el esquema viejo o el nuevo?
- ¿Se requiere una migración de datos además de una migración estructural?
- ¿El cambio debería dividirse en dos pasos más pequeños?

## Regla práctica

Mientras más cerca estés de producción o de un cliente real, más conviene preferir cambios pequeños, legibles y reversibles. Las migraciones gigantes, ambiguas o con demasiadas intenciones juntas son difíciles de validar y más caras de reparar.

## Ejemplo sencillo

Supón que en una óptica al inicio solo guardabas:

- cliente
- montura
- total

Después descubres que necesitas:

- abono inicial
- saldo pendiente
- fecha prometida de entrega
- estado del pedido

No hace falta reescribir toda la base desde cero. Lo normal sería:

1. agregar las columnas necesarias
2. dar valores por defecto o completar datos existentes
3. ajustar backend y UI
4. validar el nuevo flujo

Eso es pensar con migraciones, no con “reiniciar la base cada vez”.

## Resultado esperado

Después de leer este documento, la idea debería quedar clara:

la base de datos no evoluciona a punta de intuición ni de parches sueltos; evoluciona mediante cambios versionados que puedan explicarse, ejecutarse y rastrearse.
