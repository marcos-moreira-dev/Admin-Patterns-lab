# Catálogo de flujos

## Propósito
Tener una biblioteca organizada de los flujos principales del negocio para reutilizar criterio, detectar patrones y diseñar el sistema con menos improvisación.

## Idea central
Un flujo no es una pantalla. Es una secuencia real de trabajo. Este documento conserva los flujos más importantes y los resume de forma uniforme.

## Plantilla de cada flujo
### Nombre del flujo

**Objetivo:**

**Disparador:**

**Actores:**

**Paso a paso:**
1. 
2. 
3. 

**Decisiones o bifurcaciones:**
- 
- 

**Datos capturados:**
- 
- 

**Estados involucrados:**
- 
- 

**Documentos o evidencia:**
- 
- 

**Cierre:**

**Módulos asociados:**

## Ejemplo 1. Recepción de equipo para reparación
**Objetivo:** registrar formalmente el ingreso del equipo y abrir el caso.

**Disparador:** llega un cliente con un equipo dañado.

**Actores:** cliente, recepción.

**Paso a paso:**
1. Se identifica o registra al cliente.
2. Se registran datos del equipo.
3. Se consigna la falla reportada.
4. Se registra estado físico y accesorios entregados.
5. Se genera orden de recepción.
6. El caso queda listo para diagnóstico.

**Decisiones:**
- si el cliente ya existe, se reutiliza registro
- si falta información crítica, no se cierra el ingreso

**Estados:**
- RECIBIDA
- EN_DIAGNOSTICO

**Documentos:**
- orden de recepción
- evidencia fotográfica si aplica

**Módulos asociados:** wizard, expediente, documental, bandeja.

## Ejemplo 2. Pedido de lentes
**Objetivo:** registrar y seguir un trabajo óptico hasta su entrega.

**Disparador:** cliente solicita lentes.

**Actores:** vendedor, recepción, laboratorio, cliente.

**Paso a paso:**
1. Se identifica al cliente.
2. Se registra receta o datos técnicos.
3. Se eligen montura y lente.
4. Se toman medidas necesarias.
5. Se registra abono o pago según política.
6. Se genera pedido.
7. Se envía a laboratorio.
8. Se recibe trabajo terminado.
9. Se marca como listo y se entrega.

**Módulos asociados:** wizard, expediente, bandeja, transaccional, documental, reportes.

## Cómo construir este catálogo
### Paso 1
Lista los procesos principales del negocio.

### Paso 2
Pide que te los narren como si estuvieran ocurriendo en tiempo real.

### Paso 3
Resume cada flujo con la plantilla.

### Paso 4
Marca qué módulos del sistema lo representan.

## Uso posterior
Este catálogo sirve para:
- diseñar módulos
- definir estados
- construir casos de uso backend
- preparar pruebas
- detectar qué sí entra al MVP
