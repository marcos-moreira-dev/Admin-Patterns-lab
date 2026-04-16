# Cómo leer este bloque

Este bloque trata de la traducción del negocio a estructura de datos.

Aquí la tesis principal es:

**primero se escucha la operación, luego se detectan entidades y relaciones, y recién después se pasa al modelo conceptual, lógico y físico.**

## Qué no intenta hacer este bloque

No intenta convertir la base de datos en una religión separada del negocio.

## Cómo está organizado

- `00_como_extraer_modelo_de_datos_desde_el_cliente.md`: punto de entrada. Explica cómo pasar de conversación a entidades, relaciones, atributos y estados.
- `01_del_negocio_al_modelo_conceptual.md`: explica el primer aterrizaje del dominio a modelo.
- `02` a `05`: paso del modelo conceptual al lógico y luego al físico.
- `06` a `08`: versionado, diccionario de datos y seeds.
- `09` a `11`: migraciones, compatibilidad y evolución del esquema con más detalle.

## Qué nivel mental conviene usar

### Nivel 1
Sistema nuevo: modelo inicial claro y simple.

### Nivel 2
Sistema ya usado: cuidado con migraciones, compatibilidad e histórico.

### Nivel 3
Sistema más complejo: más disciplina de versionado y despliegue.


## Cross-links útiles
- Para pensar migraciones: `09_que_es_una_migracion_y_como_pensarla.md`
- Para compatibilidad: `11_compatibilidad_entre_bd_backend_y_ui.md`
- Para despliegue: `../07_despliegue_e_infraestructura/13_orden_de_despliegue_y_migraciones.md`
- Para riesgos en producción: `../08_mantenimiento_y_operacion/14_migraciones_en_produccion_y_riesgos.md`
