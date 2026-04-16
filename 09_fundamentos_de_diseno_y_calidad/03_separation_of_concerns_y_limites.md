# Separation of concerns y límites

## Idea central
Separar concerns significa no mezclar responsabilidades que deberían evolucionar por caminos distintos.

## Concerns típicos en una app administrativa
- reglas de negocio
- acceso a datos
- orquestación de casos de uso
- seguridad
- trazabilidad
- UI
- validación superficial
- despliegue y configuración

## Límites importantes
### Entre negocio y UI
La pantalla no debería decidir reglas centrales del negocio.

### Entre negocio e infraestructura
El dominio no debería quedar pegado a JPA, Spring, HTTP o una librería externa si eso se puede evitar.

### Entre módulos funcionales
Ventas, clientes, órdenes y soporte pueden colaborar, pero no deberían disolverse entre sí.

## Malas mezclas típicas
- controllers con lógica de negocio compleja
- repositories que toman decisiones de negocio
- clases utilitarias que saben demasiado de todo
- DTOs usados como si fueran dominio
- entidades de persistencia usadas directamente como modelo de UI

## Regla práctica
Cada capa o componente debe conocer solo lo que le corresponde para cumplir su trabajo.
