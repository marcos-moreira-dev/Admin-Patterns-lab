# Arquitectura suficiente y sobreingeniería

## Propósito

Este documento fija la tesis operativa de toda la biblioteca: construir sistemas administrativos suficientemente serios para resolver el problema actual y el siguiente salto razonable, sin inflar la complejidad antes de tiempo.

## Tesis madre

La arquitectura debe ser suficiente para sostener el producto actual y el siguiente salto razonable, no para impresionar, anticipar todos los futuros posibles ni replicar la infraestructura de una empresa que todavía no existe.

## Qué es arquitectura suficiente

Arquitectura suficiente es la mínima estructura técnica que permite:

- entender el sistema sin sufrimiento innecesario
- cambiar reglas importantes sin romper todo
- operar con una base de calidad razonable
- crecer cuando el negocio de verdad lo pida
- mantener el software con dignidad técnica

No es código improvisado. Tampoco es una vitrina de patrones.

## Qué es sobreingeniería

Sobreingeniería es complejidad prematura o ornamental. Aparece cuando agregas capas, contratos, abstracciones, tablas, componentes o servicios que todavía no resuelven un dolor real.

La sobreingeniería suele oler así:

- demasiados archivos para cambiar una cosa pequeña
- demasiadas interfaces con una sola implementación que nunca cambió
- demasiados mappers, wrappers o factories para mover datos triviales
- demasiada fragmentación en pantallas, módulos o repositorios
- demasiada estructura alrededor de una operación que aún ni siquiera validó valor de negocio

## Regla de madurez

La complejidad debería crecer por niveles.

### Nivel 1. MVP o primera versión operativa
Lo importante es resolver el flujo principal con claridad.

Conviene:
- monolito modular
- capas mínimas razonables
- pocos puntos de abstracción
- base de datos clara
- UI sobria y estable
- migraciones simples y controladas

### Nivel 2. V1 ya usada
El sistema ya recibe cambios reales y el negocio depende de él en ciertas operaciones.

Conviene:
- separar mejor módulos
- fortalecer contratos y validaciones
- introducir trazabilidad con más intención
- refactorizar piezas que ya demostraron dolor
- mejorar despliegue y mantenimiento

### Nivel 3. Sistema más maduro o con varios equipos
La complejidad ya viene de uso real, volumen, integraciones o riesgos.

Conviene:
- contratos más fuertes
- fronteras entre dominios más claras
- adaptadores donde hay sistemas externos o cambios frecuentes
- decisiones arquitectónicas más costosas, pero justificadas

## Preguntas guía antes de meter complejidad

Antes de agregar una capa, un patrón o una separación nueva, conviene responder:

1. ¿Qué problema real resuelve hoy?
2. ¿Qué dolor actual evita?
3. ¿Qué costo me agrega mañana para cambiar algo pequeño?
4. ¿Qué señal me demuestra que ya lo necesito?
5. ¿Qué versión más simple puedo usar primero?

## Dónde aparece la sobreingeniería

No solo en backend. También aparece en:

- base de datos hiperabstracta
- frontend con demasiada infraestructura interna
- desktop con demasiados controllers o helpers
- sistema de navegación demasiado sofisticado
- contratos o estructuras de proyecto sobrediseñadas
- glosarios, reportes o documentos que no ayudan a decidir nada

## Señales de que todavía debes seguir simple

- el flujo principal aún cambia con frecuencia
- el cliente todavía está descubriendo qué necesita
- el equipo es pequeño
- la mayor parte del valor está en una o dos operaciones
- el software todavía no tiene uso real sostenido
- la mayoría de problemas siguen siendo de producto, no de escalado técnico

## Señales de que sí puedes subir de nivel

- un cambio pequeño exige tocar demasiadas piezas
- el mismo tipo de bug reaparece por falta de límites claros
- varias personas necesitan trabajar sin pisarse
- hay integraciones externas que sí justifican contratos más sólidos
- ya hay riesgo real de datos, errores de producción o soporte costoso
- el negocio ya validó valor y ahora necesita estabilidad

## Regla práctica

Primero separa responsabilidades reales. Luego decide si conviene abstraerlas.

No toda dependencia necesita una interfaz. No todo módulo necesita un adaptador. No toda pantalla necesita una jerarquía de componentes. No toda tabla necesita un historial. No todo proyecto necesita arquitectura heavy.

## Resultado esperado

Si aplicas esta tesis, tu software debería quedar:

- lo bastante simple para avanzar
- lo bastante serio para cobrar
- lo bastante claro para mantener
- y lo bastante flexible para evolucionar sin drama
