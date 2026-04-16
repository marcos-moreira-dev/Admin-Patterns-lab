# Seeds y datos de prueba

## Propósito

Este documento fija cómo pensar los datos iniciales de una base de datos para desarrollo, demos, pruebas funcionales y validación de flujos.

## Qué son los seeds

Los seeds son datos iniciales o de referencia que permiten arrancar el sistema sin una base vacía.

Ejemplos:
- usuarios base
- roles
- catálogos
- estados iniciales
- registros demo mínimos

## Para qué sirven

- probar flujos
- acelerar desarrollo de backend y UI
- mostrar demos
- facilitar onboarding
- dejar entornos reproducibles

## Qué tipos de seeds conviene separar

### 1. Seeds estructurales
Catálogos y datos base relativamente estables.

### 2. Seeds de demo
Datos creíbles para mostrar el sistema.

### 3. Datos de prueba técnica
Casos extremos o controlados para test.

## Reglas sanas

- no mezclar todo sin criterio en un solo script
- mantener seeds reproducibles
- usar nombres y datos entendibles
- evitar datos absurdos si la demo debe verse profesional
- no meter datos sensibles reales

## Qué debería existir como mínimo

- usuario administrador de desarrollo
- roles base
- catálogos esenciales
- algunos registros que permitan probar flujos principales

## Ejemplos por dominio

### Óptica
- clientes demo
- monturas
- tipos de lente
- laboratorios
- pedidos en distintos estados

### Tienda + reparación
- clientes demo
- accesorios
- repuestos
- técnicos
- órdenes de reparación en distintos estados

## Relación con migraciones

- migraciones: estructura
- seeds: datos iniciales

Ambas piezas se complementan, pero no cumplen la misma función.

## Resultado esperado

Un entorno nuevo debe poder levantarse con estructura y datos mínimos razonables para trabajar, probar y demostrar sin empezar desde cero absoluto.
