# Reportes, documentos y trazabilidad en UI

## Reportes en UI
La interfaz debe permitir:
- elegir filtros
- ejecutar consulta
- revisar resultados
- exportar cuando corresponda

## Documentos en UI
La interfaz debe permitir:
- listar documentos
- abrir o descargar
- mostrar metadatos
- generar comprobantes cuando el flujo lo requiera

## Trazabilidad visible
No toda la auditoría se expone al usuario, pero sí conviene mostrar:
- historial del caso
- fecha de cambios importantes
- usuario responsable cuando tenga sentido
- observaciones relevantes

## Patrones visuales útiles
- tabla de reportes o documentos
- panel de metadatos
- pestaña de historial
- preview simple

## JavaFX
Piezas comunes:
- `TableView`
- `ListView`
- `TabPane`
- `TextArea`
- `Label`
- `Button`
- `WebView` cuando convenga preview HTML

## Regla práctica
No mezclar documento, reporte y auditoría como si fueran lo mismo.
Se tocan, pero cumplen papeles distintos.
