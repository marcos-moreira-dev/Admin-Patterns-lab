# Matriz entidad → módulo → flujo → estado

## Propósito
Esta matriz es el puente entre el levantamiento y el diseño del sistema. Su función es tomar cada entidad o proceso importante y ubicarlo dentro del sistema administrativo.

## Idea central
No toda entidad pide el mismo tipo de módulo. Algunas son catálogo. Otras entran por wizard y luego viven como expediente. Otras aparecen en bandeja, generan documentos y además alimentan reportes.

## Cómo usar esta matriz
Por cada entidad o proceso importante, completa:
- qué es dentro del negocio
- qué tipo de módulo principal la representa
- qué módulos secundarios la acompañan
- si tiene flujo
- si tiene estados
- si genera documentos
- si tiene impacto transaccional
- si aparece en bandejas o reportes

## Plantilla recomendada
| Entidad o proceso | Qué representa | Tipo principal | Módulos asociados | Tiene flujo | Tiene estados | Documentos | Impacto transaccional | Reportes / consultas | Observaciones |
|---|---|---|---|---|---|---|---|---|---|
|  |  |  |  |  |  |  |  |  |  |

## Ejemplo: óptica
| Entidad o proceso | Qué representa | Tipo principal | Módulos asociados | Tiene flujo | Tiene estados | Documentos | Impacto transaccional | Reportes / consultas | Observaciones |
|---|---|---|---|---|---|---|---|---|---|
| Cliente | Persona atendida | CRUD | búsqueda, historial | No | No fuerte | No directo | Bajo | Sí | puede conectarse con pedidos y recetas |
| Pedido de lentes | Trabajo en curso | Expediente | wizard, bandeja, documental, reportes | Sí | Sí | Sí | Sí | Sí | pasa por laboratorio y entrega |
| Receta | Base técnica del trabajo | Documental / expediente ligero | búsqueda, historial | A veces | Puede tener vigencia | Sí | Bajo | Sí | puede venir externa o generarse internamente |
| Abono | Pago parcial | Transaccional | reportes, documentos | Sí puntual | No fuerte | Sí | Alto | Sí | afecta saldo pendiente |

## Ejemplo: tienda de accesorios + reparación
| Entidad o proceso | Qué representa | Tipo principal | Módulos asociados | Tiene flujo | Tiene estados | Documentos | Impacto transaccional | Reportes / consultas | Observaciones |
|---|---|---|---|---|---|---|---|---|---|
| Producto / accesorio | Ítem vendible | CRUD | reportes, stock, búsqueda | No | No fuerte | No | Medio | Sí | puede tener categorías y stock |
| Orden de reparación | Caso vivo de servicio | Expediente | wizard, bandeja, aprobación, documental, reportes | Sí | Sí | Sí | Sí | Sí | suele ser la entidad central del taller |
| Recepción de equipo | Inicio del caso | Wizard / transaccional ligero | expediente, documental | Sí | Sí indirecto | Sí | Medio | Sí | debe capturar estado físico y evidencia |
| Pago de reparación | Cobro del servicio | Transaccional | reportes, documentos | Sí puntual | No fuerte | Sí | Alto | Sí | puede incluir anticipo |

## Criterios de decisión rápidos
### Suele ser CRUD si:
- representa una lista estable
- se crea y edita sin flujo largo
- sirve como base para otros procesos

### Suele ser expediente si:
- vive en el tiempo
- cambia de estado
- necesita historial y trazabilidad

### Suele ser transaccional si:
- mueve dinero, stock o estados críticos
- requiere confirmación y control

### Suele pedir bandeja si:
- hay pendientes por atender
- importa prioridad, fecha o responsable

### Suele pedir documental si:
- genera comprobante o evidencia
- maneja adjuntos, PDF o impresión

## Cómo usarla después
Esta matriz alimenta directamente:
- diseño de base de datos
- diseño de backend
- arquitectura de interacción
- priorización de módulos
- definición del MVP

## Error común
Un error frecuente es pensar que una entidad tiene un solo módulo. En la práctica, una entidad importante suele tocar varios patrones de interacción.

Ejemplo típico:
- orden de reparación: wizard inicial + expediente + bandeja + aprobación + documental + reportes
