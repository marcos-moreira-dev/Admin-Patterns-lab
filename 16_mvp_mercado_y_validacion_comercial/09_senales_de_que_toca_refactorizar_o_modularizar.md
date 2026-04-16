# Señales de que toca refactorizar o modularizar

## Cuándo empieza a justificarse

Refactorizar o modularizar no debe nacer del aburrimiento ni del perfeccionismo. Debe responder a un dolor claro.

## Señales técnicas

- un cambio pequeño toca demasiados archivos
- las mismas reglas aparecen duplicadas
- una pantalla o módulo hace demasiadas cosas
- el backend se vuelve difícil de cambiar sin miedo
- aparecen conflictos frecuentes entre responsabilidades
- el modelo de datos ya no se deja explicar fácil

## Señales de negocio

- crece la cantidad de usuarios
- crece el número de flujos importantes
- ya hay nuevas fases del producto
- el cliente pide mejoras que chocan con la estructura actual
- la operación ya depende seriamente del sistema

## Modularizar no es microservicios

En muchos casos, modularizar significa simplemente poner límites más claros dentro del mismo sistema, no reventarlo en diez servicios.

## Regla práctica

Primero modulariza dentro. Solo después evalúa si separar fuera realmente tiene sentido.
