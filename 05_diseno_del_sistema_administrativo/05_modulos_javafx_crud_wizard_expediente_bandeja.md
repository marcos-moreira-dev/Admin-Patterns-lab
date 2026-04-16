# Módulos JavaFX: CRUD, wizard, expediente y bandeja

## Regla general

Cada módulo debe tener:
- propósito visible
- acciones mínimas comprensibles
- patrón de interacción coherente
- componentes suficientes, no ornamentales

## CRUD

### Estructura visual
- `BorderPane`
- top con filtros y acciones
- center con `TableView`
- bottom con paginación o estado

### Piezas comunes
- `TableView`
- `TableColumn`
- `TextField`
- `ComboBox`
- `DatePicker`
- `Button`
- formulario con `GridPane`

### Qué conviene mantener simple
- una vista de lista principal
- un diálogo o panel de edición
- filtros claros
- paginación simple

### Qué sería sobreingeniería aquí
- una jerarquía de controllers para una tabla simple
- demasiados wrappers sobre controles básicos
- factories o builders que dificultan leer la pantalla

## Wizard

### Estructura visual
- `BorderPane`
- top con título y `ProgressBar`
- center con paso actual
- bottom con navegación

### Modelado técnico
- `WizardContext`
- `enum Step`
- coordinador del wizard
- controllers por paso o subcomponentes por etapa cuando haga falta

### Qué conviene mantener simple
- pasos bien delimitados
- contexto compartido claro
- validación por etapa
- resumen final cuando aporte

### Qué sería sobreingeniería aquí
- máquina de estados exagerada para un flujo lineal
- arquitectura de pasos demasiado abstracta
- helpers y factories por cada paso sin reutilización real

## Expediente

### Estructura visual
- cabecera con estado y acciones
- cuerpo con detalle
- historial y comentarios en `TabPane` o secciones

### Modelado técnico
- modelo del caso
- eventos de historial
- acciones habilitadas por estado
- refresh del detalle

### Qué conviene mantener simple
- tabs o secciones claras
- historial legible
- acciones según estado
- un solo controller principal mientras siga siendo manejable

### Qué sería sobreingeniería aquí
- demasiadas subpantallas para algo que se entiende mejor junto
- patrones de evento internos complicados para acciones básicas
- módulos visuales minúsculos sin valor real

## Bandeja

### Estructura visual
- lista o tabla de pendientes
- filtros arriba
- detalle o preview al lado

### Modelado técnico
- criterios de filtro
- selección actual
- acciones rápidas
- actualización de la lista después de cambios

### Qué conviene mantener simple
- un listado fuerte
- filtros claros
- preview o detalle si aporta
- acciones rápidas con feedback visible

### Qué sería sobreingeniería aquí
- demasiadas capas de selección y navegación
- sistemas de comandos complejos para tareas directas
- exceso de abstracción para cargar una lista de pendientes

## Refuerzo práctico

Además del contenido conceptual, conviene contar con un laboratorio JavaFX mínimo aparte, con categorías de módulo y variantes por categoría. Ese laboratorio permite copiar estructuras base con nombres autoexplicativos como `topBarContainer`, `leftSidebarContainer`, `catalogTableView`, `wizardStepTitleLabel`, `queuePreviewPane` y similares.

## Referencias visuales

### CRUD

![Catálogo / CRUD](../97_assets/mod/catalogo-crud.png)

### Wizard

![Wizard / flujo guiado](../97_assets/mod/wizard-flujo.png)

### Expediente

![Expediente / caso vivo](../97_assets/mod/expediente-caso-vivo.png)

### Bandeja

![Bandeja / cola operativa](../97_assets/mod/bandeja-cola-operativa.png)
