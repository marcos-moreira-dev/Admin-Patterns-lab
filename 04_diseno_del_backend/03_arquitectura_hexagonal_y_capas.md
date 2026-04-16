# Arquitectura hexagonal y capas

## Qué problema resuelve

Spring Boot empuja con facilidad a una arquitectura en capas clásica:
- controller
- service
- repository
- entity

Eso funciona, pero puede terminar mezclando demasiado el negocio con detalles del framework. La inspiración hexagonal ayuda a separar mejor:

- qué necesita el sistema
- cómo se conecta con lo externo

## Qué es hexagonal en simple

La idea es:
- un núcleo interno con lógica de negocio
- puertos que expresan necesidades
- adaptadores que conectan con el mundo externo

Ejemplos:
- puerto de persistencia de órdenes
- adaptador JPA que implementa ese puerto
- puerto de generación de documentos
- adaptador PDF que implementa ese puerto

## Relación con arquitectura en capas

No hay que verlo como una guerra de religiones.

Lo práctico aquí es:
- capas para ordenar responsabilidades
- hexagonal para proteger el dominio y desacoplar integraciones importantes

## Cuándo sí vale la pena acercarte a hexagonal

- integraciones externas con cierta probabilidad de cambio
- módulos que generan documentos, archivos o notificaciones
- persistencia que quieres aislar con intención
- dominios donde ya importa proteger reglas importantes del framework

## Cuándo no hace falta exagerar

No conviene crear una abstracción vacía por cada cosa pequeña.

No hace falta:
- una interfaz por cada clase
- un adaptador por cada repository interno
- múltiples proyectos o módulos técnicos para un CRUD simple
- separar con fanatismo un dominio que todavía cambia cada semana

## Versión simple primero

Una estrategia sana suele ser:

1. capas claras y pocos módulos
2. fronteras explícitas solo en puntos externos o delicados
3. puertos cuando ya exista variación real, riesgo o costo de cambio

## Señales de que ya puedes endurecer más

- integraciones con terceros importantes
- necesidad de probar lógica sin tocar infraestructura
- varias piezas externas que cambian de forma distinta
- costo creciente por acoplamiento al framework

## Resultado esperado

Hexagonal debe ayudarte a proteger el sistema de dependencias externas importantes, no convertirse en una excusa para multiplicar archivos.
