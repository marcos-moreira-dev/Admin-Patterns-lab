# Versionado, migraciones y compatibilidad

## Qué debes cuidar
- versión del backend
- versión de la base de datos
- migraciones aplicadas
- compatibilidad entre frontend o desktop y backend
- compatibilidad de librerías y runtime

## Riesgos comunes
- desplegar backend nuevo con base vieja
- cambiar contratos sin avisar
- romper el desktop por asumir respuestas nuevas
- mezclar migraciones manuales y automáticas sin control

## Regla práctica
Versiona de forma visible y asegúrate de saber qué versión del sistema conversa con qué versión de la base y de la UI.


## Cómo usar este documento

Este archivo funciona como vista resumida. Para profundizar, conviene cruzarlo con:

- `03_diseno_de_base_de_datos/06_migraciones_y_versionado.md`
- `03_diseno_de_base_de_datos/09_que_es_una_migracion_y_como_pensarla.md`
- `03_diseno_de_base_de_datos/10_cuidados_al_evolucionar_el_esquema.md`
- `03_diseno_de_base_de_datos/11_compatibilidad_entre_bd_backend_y_ui.md`
- `08_mantenimiento_y_operacion/14_migraciones_en_produccion_y_riesgos.md`
