# Refactorización con sentido

## Idea general
Refactorizar no es reescribir por capricho. Es mejorar estructura interna sin cambiar el comportamiento externo esperado.

## Cuándo sí conviene
- el código se entiende mal
- una nueva funcionalidad está costando demasiado por desorden previo
- hay duplicación clara
- los límites entre responsabilidades están rotos
- una pieza se volvió demasiado riesgosa de tocar

## Cuándo no conviene todavía
- no entiendes bien el problema
- el proyecto está en medio de una crisis operativa
- vas a refactorizar a ciegas algo que aún no está probado
- el cambio estructural no tiene objetivo claro

## Estrategia sana
- asegurar comportamiento actual con pruebas o validaciones mínimas
- mover poco a poco
- dejar el código mejor de lo que estaba
- preferir mejoras locales antes que grandes reescrituras

## Objetivos válidos
- claridad
- separación de responsabilidades
- reducción de acoplamiento
- mejor testabilidad
- mejor capacidad de extensión
