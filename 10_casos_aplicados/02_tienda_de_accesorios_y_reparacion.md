# Caso aplicado: tienda de accesorios y reparación

## Objetivo
Aterrizar la biblioteca a un negocio mixto donde conviven venta rápida e intervención técnica.

## Problemas típicos del negocio
- órdenes de reparación sin seguimiento claro
- equipos recibidos sin evidencia suficiente
- diagnósticos y presupuestos no trazados
- repuestos y accesorios mezclados en inventario
- garantías confusas
- cliente pregunta por el estado y nadie sabe exactamente

## Entidades probables
- cliente
- producto
- accesorio
- repuesto
- marca
- modelo
- equipo recibido
- orden de reparación
- diagnóstico
- técnico
- pago
- garantía

## Flujos típicos
- venta de accesorio
- recepción de equipo
- diagnóstico
- aprobación de presupuesto
- reparación
- prueba
- entrega
- cobro
- garantía o reingreso

## Módulos que suelen aparecer
- CRUD: clientes, productos, repuestos, marcas, modelos, tipos de falla
- wizard: recepción de equipo
- expediente: orden de reparación
- bandeja: pendientes por etapa
- aprobación: presupuesto o reparación adicional
- documental: orden de recepción, presupuesto, garantía, fotos
- dashboard: pendientes, ventas, garantías, stock bajo
- reportes: reparaciones por falla, ingresos por técnico, tiempos promedio

## Estados probables de una orden
- recibida
- en_diagnostico
- esperando_aprobacion
- aprobada
- en_reparacion
- lista
- entregada
- garantia
- cancelada

## Riesgos operativos típicos
- equipo recibido sin fotos ni accesorios anotados
- falla adicional descubierta tarde
- repuesto no disponible
- orden lista pero cliente no responde
- garantía reclamada sin historia técnica

## Pregunta maestra al cliente
“Cuénteme qué hacen cuando un cliente llega con un celular dañado, desde que lo reciben hasta que se lo entregan.”
