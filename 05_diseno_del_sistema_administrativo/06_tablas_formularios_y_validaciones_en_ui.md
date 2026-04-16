# Tablas, formularios y validaciones en UI

## Tablas
Las tablas son el centro de muchos sistemas administrativos.
Conviene definir bien:
- columnas útiles
- acciones por fila
- selección simple o múltiple
- formato de estados y fechas
- orden y filtros

## Formularios
Deben reflejar el flujo real del negocio.
Buenas prácticas:
- agrupar campos por sentido
- marcar obligatorios con claridad
- no pedir datos que no aportan valor
- dejar observaciones donde tengan sentido
- separar captura inicial de datos avanzados si conviene

## Validaciones en UI
La UI debe validar lo mínimo necesario para ayudar al usuario.
Ejemplos:
- campos obligatorios
- formatos básicos
- rangos de fechas o números
- selección requerida

## Qué no debe hacer la UI sola
- decidir reglas críticas del negocio
- reemplazar validaciones del backend
- ocultar errores serios detrás de mensajes genéricos

## Feedback recomendable
- error claro y localizado
- confirmación visible de acciones exitosas
- indicador de carga cuando la acción tarda
- aviso cuando no hay resultados

## En JavaFX
Piezas comunes:
- `TableView`
- `TextField`
- `TextArea`
- `ComboBox`
- `DatePicker`
- `CheckBox`
- `Label`
- `Alert`

## Regla práctica
La validación visual ayuda a trabajar.
La validación de backend protege el sistema.
Las dos deben coexistir.
