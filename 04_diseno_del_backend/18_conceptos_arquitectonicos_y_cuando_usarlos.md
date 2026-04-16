# Conceptos arquitectónicos y cuándo usarlos

## Propósito

Este documento aterriza conceptos que suelen sonar sofisticados pero que solo valen la pena cuando resuelven un dolor real del sistema. No se trata de memorizar nombres elegantes, sino de decidir cuándo ayudan y cuándo estorban.

## Regla madre

El negocio manda, la arquitectura obedece.

## Monolito modular

### Qué es
Una aplicación desplegada como una sola unidad, pero organizada internamente por módulos de negocio con límites razonables.

### Cuándo sí
- MVP y V1 de sistemas administrativos
- equipos pequeños
- dominio todavía acotado
- necesidad de avanzar rápido sin perder orden

### Cuándo no basta
- varios equipos necesitan independencia de despliegue
- integración y escalado por áreas muy distintas
- una parte del sistema cambia a ritmo completamente distinto

### Versión simple primero
Un monolito modular bien organizado suele ser la opción sana por defecto.

## Arquitectura en capas

### Qué es
Separar entrada, aplicación, dominio e infraestructura según responsabilidad técnica.

### Cuándo sí
- siempre que ayude a ordenar
- cuando evita meter lógica de negocio en controladores o vistas
- cuando mejora la lectura del sistema

### Cuándo se deforma
- cuando agregas capas que solo reenvían llamadas
- cuando cada capa existe por costumbre y no por responsabilidad real

## Hexagonal

### Qué es
Proteger el núcleo y expresar dependencias hacia afuera mediante puertos y adaptadores.

### Cuándo sí
- integraciones externas
- persistencia importante y cambiante
- generación de documentos
- notificaciones
- archivos
- pagos o terceros

### Cuándo no todavía
- CRUD simple sin fronteras externas relevantes
- sistemas donde el mayor problema aún es validar flujo y producto

### Versión simple primero
Capas claras y pocas fronteras explícitas. Si luego aparece variación real, extraes puertos.

## CQRS

### Qué es
Separar lectura y escritura en modelos o rutas distintas.

### Cuándo sí
- consultas muy distintas a las escrituras
- reportes o búsquedas complejas
- lectura con optimización especial

### Cuándo no todavía
- CRUD normal
- un solo desarrollador
- dominio sin tensiones reales entre lectura y escritura

## Event sourcing

### Qué es
Persistir cada cambio como evento en vez de guardar solo el estado actual.

### Cuándo sí
- auditoría fuerte de dominio
- necesidad real de reconstrucción histórica
- reglas financieras o legales de alto peso

### Cuándo no todavía
- óptica, tienda, consultorio o negocio pequeño estándar en MVP/V1
- esquemas que todavía cambian toda la semana

## Multitenancy

### Qué es
Una misma solución sirve a varios clientes o tenants.

### Cuándo sí
- SaaS real
- varios clientes sobre la misma plataforma
- necesidad de aislar datos, configuración o facturación por tenant

### Cuándo no todavía
- sistema hecho para un negocio puntual
- piloto o primera implantación

## Microservicios

### Qué es
Separar capacidades en servicios desplegables y operables de forma independiente.

### Cuándo sí
- equipo más grande
- ritmos de despliegue distintos
- fuerte necesidad de separación operativa
- problemas reales de escalado y autonomía

### Cuándo no todavía
- uno o pocos desarrolladores
- negocio pequeño
- cuando todavía ni siquiera has validado el núcleo funcional

## Modularización fuerte

### Qué es
Definir límites claros entre módulos de negocio, incluso dentro de un monolito.

### Cuándo sí
- cuando el sistema ya empieza a tener varias áreas con reglas propias
- cuando quieres evitar que todo termine mezclado

### Cuándo no exagerar
No conviertas cada formulario o tabla en un “módulo” formal. El módulo debe responder a una unidad funcional reconocible del negocio.

## Regla de uso

Para cada concepto pregúntate:
- ¿qué dolor resuelve?
- ¿aparece hoy o es imaginario?
- ¿qué versión más simple puedo usar primero?
- ¿qué señal me diría que debo subir de nivel?

## Resultado esperado

Después de leer este documento, deberías poder justificar por qué un sistema administrativo sigue simple, cuándo conviene endurecer arquitectura y cuándo un concepto arquitectónico es útil de verdad.
