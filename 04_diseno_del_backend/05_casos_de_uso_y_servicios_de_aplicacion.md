# Casos de uso y servicios de aplicación

## Idea principal
El backend no debería girar solo en torno a CRUDs de tablas. Debe girar alrededor de acciones útiles del negocio.

## Qué es un caso de uso
Es una operación significativa para el sistema.
Ejemplos:
- registrar venta
- aprobar presupuesto
- crear orden de reparación
- cerrar ticket
- generar comprobante

## Qué hace un servicio de aplicación
Un servicio de aplicación:
- recibe la intención
- valida contexto general
- coordina entidades y puertos
- ejecuta la operación
- devuelve un resultado entendible

No debería:
- saber detalles de UI
- mezclar SQL o JPA con toda la lógica del caso
- volverse una clase dios

## Forma mental útil
Caso de uso = verbo importante del negocio.
Ejemplos:
- CrearOrdenReparacion
- AprobarPresupuesto
- RegistrarPago
- AnularVenta

## Qué debe contener
- entrada del caso de uso
- validaciones de negocio de alto nivel
- coordinación de puertos
- control transaccional cuando aplique
- resultado claro
