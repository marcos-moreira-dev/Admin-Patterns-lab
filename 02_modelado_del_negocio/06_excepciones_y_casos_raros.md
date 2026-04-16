# Excepciones y casos raros

## Propósito
Registrar las situaciones que salen del caso ideal para que el sistema no quede bonito pero frágil.

## Idea central
El caso feliz cualquiera lo diseña. Lo que vuelve serio un sistema administrativo es qué tan bien resiste condiciones raras, problemas operativos y decisiones humanas imperfectas.

## 1. Qué son excepciones y casos raros
### Excepción
Situación donde el flujo normal no puede continuar sin ajuste, validación adicional o decisión especial.

### Caso raro
Situación menos frecuente pero real, que si no se contempla provoca errores, parches o trabajo manual desordenado.

## 2. Preguntas para descubrirlos
- ¿Qué sale mal a veces?
- ¿Qué casos especiales ocurren?
- ¿Qué pasa si el cliente cambia de opinión?
- ¿Qué pasa si falta un dato o documento?
- ¿Qué pasa si una parte del proceso se queda esperando demasiado?
- ¿Qué hacen hoy cuando algo se rompe en el flujo normal?

## 3. Plantilla recomendada
### Nombre del caso raro

**Flujo relacionado:**

**Qué ocurre:**

**Por qué rompe el caso feliz:**

**Impacto operativo:**

**Regla o decisión necesaria:**

**Módulos afectados:**

**Evidencia o trazabilidad necesaria:**

## 4. Ejemplos: tienda de reparación
### Aparece una falla adicional después del diagnóstico inicial
**Impacto:** el presupuesto original deja de ser suficiente.

**Regla necesaria:** no continuar sin nueva aprobación.

### El cliente no responde pero el equipo ya está listo
**Impacto:** el caso queda varado en bandeja y puede ocupar espacio físico.

**Necesidad:** estados de espera y reglas de seguimiento.

### El cliente vuelve por garantía
**Impacto:** no es una orden completamente nueva; necesita referencia al trabajo original.

## 5. Ejemplos: óptica
### El laboratorio entrega el trabajo con error
**Impacto:** el pedido no puede pasar a entrega.

### El cliente pide ajuste después de usar los lentes
**Impacto:** el caso se reabre o entra en ajuste / garantía.

### Se registró abono pero luego cambia el trabajo
**Impacto:** afecta saldo pendiente y documentos.

## 6. Tipos comunes de casos raros
### Cambios de decisión
- cliente ya no quiere continuar
- cliente pide modificar trabajo iniciado

### Falta de recursos
- no hay stock
- no hay repuesto
- proveedor falla

### Problemas de datos
- nombre mal registrado
- receta incompleta
- equipo sin identificación suficiente

### Problemas de tiempos
- retrasos
- vencimientos
- no retiro

### Problemas de calidad
- diagnóstico incorrecto
- trabajo mal entregado
- documento inconsistente

## 7. Regla práctica
Cada flujo importante debería revisarse al menos con estas preguntas:
- ¿qué pasa si el cliente dice que no?
- ¿qué pasa si falta algo?
- ¿qué pasa si aparece algo nuevo?
- ¿qué pasa si se tarda demasiado?
- ¿qué pasa si hay que corregir o rehacer?

## 8. Resultado esperado
Al terminar este análisis deberías tener:
- lista de excepciones importantes
- reglas asociadas
- estados extra si hacen falta
- evidencia mínima requerida
- impacto en módulos, backend y datos
