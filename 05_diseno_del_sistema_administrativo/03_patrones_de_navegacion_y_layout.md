# Patrones de navegación y layout

## Layout administrativo base
### Sidebar
Debe concentrar áreas principales del sistema.
Conviene usarlo para:
- dashboard
- clientes
- ventas
- órdenes
- inventario
- reportes
- configuración

### Topbar
Debe mostrar contexto global.
Ejemplos:
- usuario actual
- sede o contexto activo
- búsqueda global si aplica
- notificaciones
- acceso a sesión

### Workspace central
Es la zona donde vive el módulo.
Aquí cambia el contenido según el patrón de interacción.

## Patrones de navegación útiles
### Navegación por áreas
Cuando el sistema tiene dominios funcionales claros.

### Hub intermedio
Cuando una sección tiene varios submódulos y no conviene saturar el sidebar.

### Lista y detalle
Cuando el usuario selecciona un registro y luego lo trabaja.

### Flujo paso a paso
Cuando el orden importa.

### Tabs internas
Cuando una misma entidad necesita varias perspectivas.
Usarlas con cuidado, no como excusa para meter todo junto.

## Layouts típicos por módulo
- CRUD: filtros arriba, tabla al centro, acciones visibles
- wizard: progreso arriba, contenido al centro, navegación abajo
- expediente: cabecera + tabs o secciones
- bandeja: split view entre lista y detalle
- dashboard: tarjetas y bloques en scroll

## Criterios de sobriedad
- jerarquía visual clara
- espacios suficientes
- una acción primaria por contexto
- evitar modales innecesarios
- no romper el patrón visual entre módulos sin motivo
