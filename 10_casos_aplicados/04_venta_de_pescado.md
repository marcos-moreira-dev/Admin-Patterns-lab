# Caso aplicado: venta de pescado

## Objetivo
Demostrar que el método sirve también para un negocio comercial más simple y operativo.

## Problemas típicos del negocio
- ventas rápidas sin registro ordenado
- stock difícil de controlar por peso o lote
- compras y entradas mal anotadas
- precios cambiantes
- merma o desperdicio no registrado
- cuentas pendientes con clientes frecuentes o proveedores

## Entidades probables
- cliente
- proveedor
- producto
- lote
- compra
- venta
- detalle de venta
- pago
- merma
- usuario

## Flujos típicos
- ingreso de mercadería
- pesaje o clasificación
- actualización de precios
- venta diaria
- cierre de caja
- control de merma
- reportes diarios

## Módulos que suelen aparecer
- CRUD: clientes, proveedores, productos, precios base
- transaccional: compra, venta, cierre de caja
- bandeja: pedidos o entregas pendientes si aplica
- reportes: ventas por día, producto, margen, merma
- dashboard: ventas del día, stock estimado, producto crítico

## Riesgos operativos típicos
- registrar mal unidades o peso
- stock que no coincide con realidad
- cambios de precio sin control
- mermas invisibles
- ventas sin comprobante o cierre poco claro

## Pregunta maestra al cliente
“Cuénteme cómo entra el pescado, cómo se vende y cómo cierran el día.”
