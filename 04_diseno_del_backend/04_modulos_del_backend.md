# Módulos del backend

## Objetivo
Dividir el backend por módulos ayuda a reflejar el negocio y evita que el proyecto se vuelva una masa amorfa.

## Criterio de partición
Conviene modular por áreas funcionales del negocio, no solo por tecnología.

Ejemplos:
- clientes
- productos
- ventas
- órdenes
- garantías
- soporte
- reportes

## Qué suele contener un módulo
Un módulo de backend bien organizado puede contener:
- casos de uso
- entidades o modelos del dominio
- puertos
- adaptadores de persistencia
- DTOs específicos
- validaciones del módulo
- mapeadores
- excepciones específicas

## Qué no conviene
- meter toda la lógica en un único paquete `service`
- repartir reglas del módulo por todo el proyecto
- acoplar módulos de negocio entre sí de forma circular

## Relación entre módulos
### Módulos base
- clientes
- productos
- técnicos
- catálogos

### Módulos operativos
- ventas
- órdenes
- pedidos
- reparaciones
- pagos

### Módulos transversales
- seguridad
- trazabilidad
- archivos
- reportes
- configuración
