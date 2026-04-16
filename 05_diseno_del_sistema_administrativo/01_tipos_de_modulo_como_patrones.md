# Tipos de módulo como patrones

## Idea principal
Un módulo administrativo no debe pensarse primero como pantalla, sino como patrón de interacción sobre una necesidad del negocio.

## Tipos principales
- catálogo / CRUD
- wizard / flujo guiado
- expediente / caso vivo
- bandeja / cola operativa
- dashboard / tablero
- configuración / parametrización
- aprobación / revisión
- reportes / informes
- hub de acceso / navegación
- transaccional
- búsqueda / consulta especializada
- comunicación / soporte
- documental
- agenda / calendario

## Cómo usarlos como patrones
### Catálogo / CRUD
Sirve para administrar entidades relativamente estables.
Patrón típico:
- filtros
- tabla
- alta / edición
- activación o inactivación

### Wizard / flujo guiado
Sirve para procesos por pasos.
Patrón típico:
- pasos secuenciales
- contexto acumulado
- validación por etapa
- confirmación final

### Expediente / caso vivo
Sirve para entidades que viven en el tiempo.
Patrón típico:
- cabecera con estado
- detalle principal
- historial
- comentarios
- acciones por estado

### Bandeja
Sirve para trabajo pendiente.
Patrón típico:
- lista de pendientes
- filtros por estado, prioridad y responsable
- preview o detalle corto
- acciones rápidas

### Dashboard
Sirve para monitoreo.
Patrón típico:
- KPIs
- alertas
- gráficos
- accesos rápidos

### Configuración
Sirve para parámetros del sistema.
Patrón típico:
- categorías
- formularios de configuración
- control de permisos

### Aprobación
Sirve para separar solicitud y autorización.
Patrón típico:
- pendientes
- detalle
- observación
- aprobar / rechazar / devolver

### Reportes
Sirve para resumir y exportar.
Patrón típico:
- filtros
- resultados
- exportación

### Hub
Sirve como puerta de entrada a una familia funcional.
Patrón típico:
- tarjetas o bloques de acceso
- organización por áreas

### Transaccional
Sirve para operaciones con consecuencias reales.
Patrón típico:
- captura
- resumen
- confirmación
- resultado

### Búsqueda especializada
Sirve para explorar información compleja.
Patrón típico:
- filtros avanzados
- resultados
- detalle

### Comunicación / soporte
Sirve para conversaciones y seguimiento.
Patrón típico:
- lista de casos o conversaciones
- hilo de mensajes
- respuesta

### Documental
Sirve para comprobantes y evidencias.
Patrón típico:
- lista de documentos
- metadatos
- vista previa
- generar / descargar

### Agenda
Sirve para programación temporal.
Patrón típico:
- fecha
- disponibilidad
- eventos
- reprogramación

## Regla práctica
Primero clasifica la necesidad del negocio.
Después eliges el patrón de interacción.
Por último aterrizas la vista, los controles y la navegación.


## Apoyo visual

Este documento se complementa con estas referencias visuales:

- [Galería visual de módulos](13_galeria_visual_de_modulos.md)

### Vista rápida

#### Hub de acceso

![Hub de acceso](../97_assets/mod/navegacion-hub-de-acceso.png)

#### Configuración / parametrización

![Configuración / parametrización](../97_assets/mod/configuracion-parametrizacion.png)

#### Aprobación / revisión

![Aprobación / revisión](../97_assets/mod/aprobacion-revision.png)

#### Reportes / informes

![Reportes / informes](../97_assets/mod/reportes-informes.png)

#### Transaccional

![Transaccional](../97_assets/mod/transaccional.png)

#### Búsqueda / consulta especializada

![Búsqueda / consulta especializada](../97_assets/mod/busqueda-consulta-especializada.png)

#### Comunicación / soporte

![Comunicación / soporte](../97_assets/mod/comunicacion-soporte.png)

#### Documental

![Documental](../97_assets/mod/documental.png)
