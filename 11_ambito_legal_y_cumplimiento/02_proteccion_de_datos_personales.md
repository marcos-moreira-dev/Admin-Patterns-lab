# Protección de datos personales

## Idea base
Si el sistema trata datos personales, la protección de datos no es un extra cosmético. Debe influir en diseño, permisos, trazabilidad, respaldos y forma de trabajo.

## Qué datos suelen aparecer en software administrativo
- nombres y apellidos
- cédulas u otros identificadores
- teléfonos y correos
- direcciones
- historiales de clientes o pacientes
- fotografías y documentos
- datos de empleados o proveedores

## Qué significa proteger datos en la práctica
No significa esconder todo. Significa decidir con criterio:
- qué datos realmente necesitas
- para qué los guardas
- quién puede verlos
- cuánto tiempo deben permanecer
- cómo se corrigen o eliminan
- qué pasa si hay acceso no autorizado o pérdida

## Principios prácticos para ti
### Minimización
No pidas ni guardes datos por costumbre. Si no ayudan a operar o cumplir, probablemente sobran.

### Acceso por rol
No todo usuario debe ver todo. Un sistema pequeño también necesita separar accesos.

### Trazabilidad básica
Debe quedar registro mínimo de acciones sensibles: creación, edición, cambio de estado, eliminación lógica, descarga o exportación.

### Seguridad razonable
No se trata de paranoia. Se trata de no dejar datos personales expuestos por descuido, logs indiscretos o usuarios demasiado poderosos.

### Respaldo y eliminación
Debes tener idea de cómo se respaldan los datos y qué pasa cuando un dato ya no debería seguir tratándose.

## Preguntas que debes hacer en levantamiento
- ¿qué datos personales guarda hoy el negocio?
- ¿qué datos son realmente obligatorios?
- ¿quién puede ver cada tipo de dato?
- ¿qué datos son sensibles o delicados?
- ¿qué reportes o exportaciones contienen datos personales?
- ¿se necesita corregir, ocultar o eliminar información?

## Señales de alerta
- guardar cédulas, fotos, historiales o documentos sin justificar
- dar acceso amplio a demasiados usuarios
- exportar datos sensibles sin control
- usar datos reales en demos o repos públicos
- no distinguir entre dato operativo y dato sensible

## Regla práctica
Si el sistema trata datos personales, eso debe impactar tu arquitectura, tu UI, tus permisos, tus respaldos y tu forma de negociar el alcance.
