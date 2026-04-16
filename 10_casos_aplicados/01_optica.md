# Caso aplicado: óptica

## Objetivo
Usar el caso de una óptica para aterrizar la biblioteca completa a un negocio real.

## Problemas típicos del negocio
- pedidos de lentes desordenados
- recetas y medidas dispersas
- dificultad para seguir trabajos enviados a laboratorio
- saldos pendientes o abonos mal controlados
- entregas sin trazabilidad
- garantías o ajustes sin historial

## Entidades probables
- cliente
- receta
- medida
- montura
- lente
- tratamiento
- laboratorio
- pedido de lentes
- pago
- entrega
- garantía

## Flujos típicos
- registrar cliente
- registrar receta o examen
- elegir montura y tipo de lente
- tomar medidas
- crear pedido
- enviar a laboratorio
- recibir trabajo terminado
- cobrar saldo
- entregar
- gestionar ajuste o garantía

## Módulos que suelen aparecer
- CRUD: clientes, monturas, tipos de lente, laboratorios
- wizard: creación de pedido de lentes
- expediente: seguimiento de pedido y garantía
- bandeja: pedidos pendientes o listos para entregar
- dashboard: pedidos del día, pendientes y saldos
- documental: receta, orden, comprobante, garantía
- reportes: ventas por tipo de lente, pendientes, laboratorio

## Estados probables del pedido
- borrador
- registrado
- enviado_a_laboratorio
- recibido
- listo_para_entrega
- entregado
- ajuste
- garantia
- cancelado

## Riesgos operativos típicos
- medidas incompletas
- pedido enviado sin validar datos
- trabajo listo pero cliente no avisado
- garantía sin evidencia
- diferencia entre receta, trabajo pedido y trabajo recibido

## Pregunta maestra al cliente
“Cuénteme cómo atienden a un cliente que viene con receta y quiere sus lentes, desde que entra hasta que se va con el trabajo entregado.”
