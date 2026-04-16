# Diseño web administrativo

## Rol de la web administrativa

Sirve cuando importa:
- acceso desde varios equipos
- despliegue más simple para usuarios finales
- disponibilidad remota
- operación desde navegador

## Diferencias con desktop

### Web
- rutas
- modales y navegación de navegador
- responsive si aplica
- sesión en navegador

### Desktop
- shell más cerrado
- foco operativo más estable
- menos dependencia del navegador

## Lo común entre ambos

- módulos
- flujos
- reglas
- estados
- validaciones
- reportes

## Patrones web típicos

- listado + filtros + drawer o modal
- tabs por entidad
- dashboard con cards
- wizard por pasos
- formularios con validación visible

## Qué conviene mantener simple

- organización por features o pantallas
- layout administrativo claro
- servicios a API entendibles
- reutilización selectiva
- routing sobrio
- estado compartido solo donde realmente haya cruce de información

## Qué sería sobreingeniería aquí

- state management complejo desde el día 1
- capas frontend que solo envuelven otras capas
- componentes ultra genéricos difíciles de entender
- router sobrediseñado para una app administrativa pequeña
- demasiados wrappers para formularios y tablas simples

## Regla práctica

No pensar web y desktop como mundos distintos.
La lógica funcional debe ser la misma.
Lo que cambia es la forma de interacción y entrega.

En la web administrativa, la complejidad debe entrar cuando la navegación, el tamaño de la app o el estado compartido ya lo exigen de verdad.
