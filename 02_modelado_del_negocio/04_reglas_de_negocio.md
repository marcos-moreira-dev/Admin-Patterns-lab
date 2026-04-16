# Reglas de negocio

## Propósito
Centralizar las reglas que gobiernan el sistema para que no queden regadas entre backend, UI, base de datos y cabeza del cliente.

## Idea central
Una regla de negocio no es “el campo no puede ser null”. Eso es una restricción técnica. Una regla de negocio dice qué está permitido, qué está prohibido y bajo qué condiciones puede ocurrir una acción relevante del negocio.

## 1. Qué suele ser una regla de negocio
- no se entrega una reparación sin cierre válido
- no se rehacen lentes sin validar garantía
- no se registra pago negativo
- no se aprueba una solicitud sin observación mínima
- no se consume stock si la operación no se confirma

## 2. Qué debe tener cada regla
- nombre corto
- descripción clara
- contexto donde aplica
- actor involucrado
- condición
- excepción si existe
- consecuencia si no se cumple
- capa donde se valida

## 3. Plantilla recomendada
### Nombre de la regla

**Descripción:**

**Contexto:**

**Actor principal:**

**Condición:**

**Excepción:**

**Consecuencia si no se cumple:**

**Dónde se valida:**
- backend
- UI
- base de datos
- proceso humano

## 4. Ejemplos: óptica
### R1. No entregar pedido sin estado listo
**Descripción:** un pedido solo puede entregarse cuando el trabajo fue recibido correctamente y marcado como listo.

**Contexto:** entrega de lentes.

**Actor principal:** recepción / caja.

**Condición:** el pedido debe estar en `LISTO_PARA_ENTREGA` o equivalente definido.

**Excepción:** ninguna, salvo corrección manual por administrador con trazabilidad.

**Consecuencia:** se bloquea la entrega.

**Dónde se valida:** backend y UI.

### R2. Una garantía requiere motivo registrado
**Descripción:** todo ingreso por garantía debe dejar motivo y referencia al trabajo original.

**Dónde se valida:** backend.

## 5. Ejemplos: tienda de accesorios + reparación
### R3. No pasar a reparación sin aprobación
**Descripción:** una orden no debe entrar en reparación si todavía está esperando aprobación del cliente.

**Dónde se valida:** backend y expediente.

### R4. Todo ingreso de equipo debe registrar estado físico básico
**Descripción:** al recibir equipo se debe dejar constancia mínima de estado físico y accesorios entregados.

**Dónde se valida:** wizard / backend.

## 6. Dónde viven las reglas
### Backend
Lugar principal para reglas relevantes.

### UI
Sirve para ayudar, guiar y prevenir errores obvios, pero no debe ser la única defensa.

### Base de datos
Conviene para reglas estructurales o invariantes simples:
- unicidad
- checks simples
- no null
- FK

## 7. Clasificación útil de reglas
### Reglas operativas
Gobiernan el flujo de trabajo.

### Reglas transaccionales
Protegen dinero, stock o integridad fuerte.

### Reglas de autorización
Definen quién puede hacer qué.

### Reglas documentales
Exigen evidencia, comprobante o adjunto.

### Reglas temporales
Dependen de fechas, vencimientos o plazos.

## 8. Errores comunes
- dejar reglas importantes solo en la UI
- mezclar reglas de negocio con validaciones de formato
- no documentar excepciones
- usar nombres ambiguos
- no dejar evidencia cuando una regla se fuerza manualmente

## 9. Resultado esperado
Al terminar este documento deberías poder responder:
- qué está permitido
- bajo qué condiciones
- quién puede hacerlo
- dónde se valida
- qué pasa si falla
