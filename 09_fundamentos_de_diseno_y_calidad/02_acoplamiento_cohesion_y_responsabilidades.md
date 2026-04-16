# Acoplamiento, cohesión y responsabilidades

## Propósito
Dar lenguaje y criterio para evaluar si una pieza de software está bien delimitada o si está empezando a volverse una masa difícil de mantener.

## Acoplamiento
El acoplamiento describe cuánto depende una pieza de otra.

### Conviene
- dependencias claras
- pocas dependencias innecesarias
- límites estables entre módulos

### Señales de acoplamiento alto
- una clase toca muchas otras para hacer una tarea simple
- cambiar una regla obliga a editar muchos lugares
- la UI conoce demasiados detalles del backend
- el dominio depende de librerías o frameworks externos de forma dura

## Cohesión
La cohesión describe qué tan bien encajan las responsabilidades internas de una pieza.

### Alta cohesión
Una clase, módulo o componente tiene propósito claro y sus partes empujan en la misma dirección.

### Baja cohesión
- mezcla cálculo, persistencia y formato visual
- una pantalla administra cosas sin relación
- un módulo de negocio se vuelve cajón de sastre

## Responsabilidades
Una responsabilidad es una razón clara por la que una pieza existe.

### Regla práctica
- si una pieza tiene demasiadas razones para cambiar, probablemente está mal delimitada
- si no puedes explicar en una frase para qué existe, probablemente está dispersa

## Aplicación en backend
- controller: entrada y respuesta HTTP
- caso de uso: orquestación de una operación
- dominio: reglas y comportamiento del negocio
- adapter/repository: acceso a infraestructura

## Aplicación en JavaFX
- FXML: estructura visual
- controller: eventos y coordinación básica
- service/view model/coordinator: lógica de interacción y comunicación
- componentes reutilizables: piezas de UI con propósito claro

## Heurística útil
Bajo acoplamiento y alta cohesión no significan “más capas por deporte”, sino responsabilidades más limpias y cambios más localizados.
