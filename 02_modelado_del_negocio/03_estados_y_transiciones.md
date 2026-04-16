# Estados y transiciones

## Propósito
Documentar cómo cambian las entidades vivas dentro del sistema y bajo qué condiciones.

## Idea central
Cuando una entidad tiene ciclo de vida, el sistema debe dejar claro:
- en qué estado puede estar
- quién puede moverla
- hacia qué otros estados puede pasar
- qué reglas desbloquean o bloquean el cambio

## 1. Qué entidades suelen tener estados
- orden de reparación
- pedido de lentes
- ticket
- trámite
- solicitud de aprobación
- garantía
- pago pendiente

## 2. Qué debe definirse por cada entidad viva
### a. Estado inicial
Ejemplo: `RECIBIDA`

### b. Estados válidos
Ejemplo:
- RECIBIDA
- EN_DIAGNOSTICO
- ESPERANDO_APROBACION
- APROBADA
- EN_REPARACION
- LISTA_PARA_ENTREGA
- ENTREGADA
- CANCELADA
- GARANTIA

### c. Transiciones válidas
No todos los saltos deben permitirse.

Ejemplo:
- RECIBIDA → EN_DIAGNOSTICO
- EN_DIAGNOSTICO → ESPERANDO_APROBACION
- ESPERANDO_APROBACION → APROBADA
- APROBADA → EN_REPARACION
- EN_REPARACION → LISTA_PARA_ENTREGA
- LISTA_PARA_ENTREGA → ENTREGADA

### d. Actor que ejecuta el cambio
- recepción
- técnico
- supervisor
- caja
- administrador

### e. Condiciones
- solo si hay diagnóstico
- solo si existe aprobación del cliente
- solo si el pago está confirmado
- solo si se adjuntó documento

### f. Evidencia del cambio
- comentario
- usuario
- fecha y hora
- estado anterior y nuevo
- motivo

## 3. Plantilla recomendada
### Entidad

### Estado inicial

### Estados válidos
- 
- 
- 

### Transiciones válidas
| Desde | Hacia | Quién puede | Condición | Evidencia requerida |
|---|---|---|---|---|
|  |  |  |  |  |

### Transiciones inválidas importantes
- 
- 

### Reapertura o reversión
- ¿se puede reabrir?
- ¿quién puede hacerlo?
- ¿qué evidencia debe quedar?

## 4. Ejemplo: orden de reparación
### Estado inicial
- RECIBIDA

### Estados válidos
- RECIBIDA
- EN_DIAGNOSTICO
- ESPERANDO_APROBACION
- APROBADA
- EN_REPARACION
- LISTA_PARA_ENTREGA
- ENTREGADA
- CANCELADA
- GARANTIA

### Transiciones
| Desde | Hacia | Quién puede | Condición | Evidencia requerida |
|---|---|---|---|---|
| RECIBIDA | EN_DIAGNOSTICO | técnico / recepción | orden creada correctamente | registro de ingreso |
| EN_DIAGNOSTICO | ESPERANDO_APROBACION | técnico | diagnóstico y costo estimado | observación técnica |
| ESPERANDO_APROBACION | APROBADA | recepción / cliente | cliente acepta | evidencia de aprobación |
| APROBADA | EN_REPARACION | técnico | repuesto disponible o trabajo autorizado | asignación |
| EN_REPARACION | LISTA_PARA_ENTREGA | técnico | prueba final exitosa | observación o checklist |
| LISTA_PARA_ENTREGA | ENTREGADA | caja / recepción | entrega confirmada y cobro resuelto | comprobante o cierre |

## 5. Ejemplo: pedido de lentes
Estados posibles:
- REGISTRADO
- ENVIADO_A_LABORATORIO
- EN_PROCESO
- RECIBIDO
- LISTO_PARA_ENTREGA
- ENTREGADO
- AJUSTE
- GARANTIA

## 6. Reglas prácticas
- evita estados ambiguos como “EN_PROCESO” si necesitas más precisión
- no permitas transiciones arbitrarias “por si acaso”
- documenta quién puede saltarse pasos y por qué
- si una transición es delicada, exige comentario o motivo
- diferencia entre cancelar, anular y cerrar

## 7. Relación con otros documentos
Este archivo alimenta:
- reglas de negocio
- backend de cambios de estado
- trazabilidad
- bandejas operativas
- expedientes
