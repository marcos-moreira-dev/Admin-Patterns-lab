# Qué sí meter y qué no meter en un MVP

## Regla general

En un MVP administrativo, todo lo que entra debe justificar su presencia por valor operativo. Si una característica no ayuda a que el negocio funcione mejor ahora, probablemente no deba entrar todavía.

## Qué sí conviene meter

### Flujo principal completo
Debe existir al menos un proceso importante que funcione de inicio a fin.

### Datos esenciales
Los datos mínimos para operar, buscar, revisar y corregir.

### Estados mínimos
Aunque sean pocos, los estados ayudan a controlar el avance del proceso.

### Validaciones visibles
No hace falta un sistema hipercomplejo, pero sí validaciones que eviten errores tontos.

### Búsqueda o consulta básica
El usuario debe poder encontrar lo que ya registró.

### Trazabilidad mínima
Quién hizo algo, cuándo cambió algo, o al menos una marca temporal básica.

### Un reporte o comprobante simple
Solo si de verdad ayuda a operar, cobrar o justificar una acción.

### Seeds o datos de prueba
Sirven para demo, pruebas y para que el sistema no se sienta vacío.

## Qué no conviene meter todavía

### Arquitectura por ansiedad
Puertos, adaptadores, interfaces y capas que no resuelven dolor real todavía.

### Permisos ultra granulares
En el MVP suele bastar con roles simples.

### Dashboards gigantes
Un tablero enorme con veinte indicadores suele ser humo si el flujo central aún no está resuelto.

### Reportes infinitos
Empieza por uno o dos reportes valiosos. Lo demás vendrá después.

### Automatizaciones prematuras
No automatices lo que ni siquiera está estable o entendido.

### Módulos satélite
Si el cliente menciona algo que usa una vez al mes, probablemente no sea núcleo todavía.

### Integraciones complejas
A menos que una integración sea imprescindible para operar, no conviene meterla en fase inicial.

## Lo que sí puede entrar aunque no sea bonito

Una V1 o MVP puede ser sobria. Puede tener una interfaz simple, pocos colores y layouts conservadores. Lo importante es que sea clara, legible y confiable.

## Lo que no debe pasar

No debe verse:

- improvisado
- confuso
- infantil
- caótico
- poco serio

## Matriz rápida de decisión

### Entra ahora si:
- reduce dolor real
- se usa seguido
- evita error frecuente
- mejora control
- forma parte del flujo central

### Se pospone si:
- es idea bonita pero no urgente
- se usa poco
- no afecta operación central
- no cambia el valor percibido del sistema
- nace de imaginar el futuro en vez de observar el presente

## Frase útil para cliente

> En esta primera versión voy a priorizar lo que sí mejora la operación desde el día uno. Lo demás se puede construir después, ya con uso real y mejor criterio.
