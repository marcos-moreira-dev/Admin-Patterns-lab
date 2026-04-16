# Caso simulado de conversación con cliente: panadería

## Propósito

Este archivo funciona como ejemplo práctico de una conversación profesional con cliente en una etapa temprana. No es una obra de teatro literal, sino una referencia de tono, dirección y acotaciones para conducir mejor una reunión.

## Contexto del caso

- **Cliente:** Marta, dueña de una panadería pequeña
- **Desarrollador:** Marcos
- **Etapa:** primera reunión con algo de descubrimiento y prelevantamiento
- **Problema probable:** desorden en pedidos, control de ventas, producción y entregas

## Objetivo de la conversación

- entender cómo opera la panadería
- detectar el dolor real
- descubrir procesos importantes
- evitar prometer pantallas demasiado pronto
- preparar una segunda reunión más estructurada

## Acotaciones previas

- entrar escuchando, no vendiendo
- dejar que Marta cuente el negocio con ejemplos concretos
- no interrumpir con tecnología demasiado pronto
- detectar si el dolor principal está en caja, pedidos, producción o entregas
- anotar términos naturales del negocio: pedido, encargo, producción, entrega, saldo, abono, retiro

---

## Conversación simulada

### Apertura

**Marcos:** Marta, antes de hablar del sistema como tal, me gustaría entender cómo trabajan hoy, qué cosas les generan más desorden y qué parte del negocio quisieran controlar mejor primero.

**Acotación:** apertura suave, sobria y orientada al problema, no al software.

**Marta:** Ahorita lo que más se me complica son los pedidos. Hay gente que encarga tortas, bocaditos o pan especial, y a veces una chica lo anota en papel, otra por WhatsApp, y luego toca estar preguntando qué se pagó, qué falta hacer o qué día se entrega.

**Marcos:** Perfecto. Entonces, si entiendo bien, el problema principal no sería solo vender, sino controlar mejor los pedidos y que no se pierda información entre quienes atienden.

**Marta:** Exactamente. Porque vender en mostrador se vende normal, pero lo otro sí se enreda.

**Acotación:** Marcos ya empieza a separar operación rápida de mostrador contra proceso de pedidos especiales.

---

### Descubrimiento del flujo principal

**Marcos:** Cuénteme ese caso como si estuviera pasando ahora mismo. Llega una persona y quiere encargar una torta para dentro de tres días. ¿Qué hacen primero?

**Marta:** Primero le preguntamos qué quiere: tamaño, sabor, decoración y para qué fecha. A veces deja abono y a veces no.

**Marcos:** ¿Eso quién lo anota?

**Marta:** Cualquiera de las chicas que esté atendiendo.

**Marcos:** ¿Y luego qué pasa con esa información?

**Marta:** Se le pasa a producción, pero a veces por WhatsApp, a veces en un cuaderno, y a veces yo misma reviso.

**Marcos:** ¿Y cómo saben si el pedido ya fue producido, si ya está pagado o si ya se entregó?

**Marta:** Ahí es donde más nos enredamos.

**Acotación:** aquí ya aparecen entidades y estados implícitos: pedido, abono, producción, entrega.

---

### Detección de entidades y estados

**Marcos:** Entonces veo al menos estas piezas: cliente, pedido, producto encargado, fecha prometida, abono o pago, estado del pedido y entrega. ¿Eso le suena correcto?

**Marta:** Sí, así mismo.

**Marcos:** ¿Qué estados cree usted que tiene un pedido? Por ejemplo, anotado, confirmado, en producción, listo, entregado.

**Marta:** Sí. Y también a veces cancelado, porque cambian de opinión.

**Marcos:** Perfecto. Eso ya me ayuda porque no sería solo una lista de pedidos, sino un proceso que va cambiando de estado.

**Acotación:** aquí Marcos empieza a identificar que no es solo CRUD, sino expediente + bandeja + algo transaccional.

---

### Detección de documentos y comprobantes

**Marcos:** Cuando alguien deja abono, ¿qué comprobante entregan?

**Marta:** A veces un papelito simple, a veces nada más se le dice verbalmente.

**Marcos:** ¿Y eso después les trae problemas?

**Marta:** Sí, porque luego dicen que pagaron más o que no era ese valor.

**Marcos:** Entonces también hay un problema de evidencia o respaldo, no solo de organización.

**Marta:** Sí.

---

### Recorte y conducción profesional

**Marta:** ¿Y ahí me harías una app completa con todo, caja, inventario, pedidos, producción y reportes?

**Marcos:** Se puede construir bastante, pero mi recomendación sería no meter todo de una sola vez. Primero conviene resolver bien el núcleo del problema.

**Marta:** ¿Qué sería el núcleo?

**Marcos:** En su caso, yo diría que pedidos, estados, abonos, producción y entrega. Si esa base queda ordenada, luego ya se puede crecer a inventario, caja más detallada y reportes más amplios.

**Acotación:** aquí Marcos recorta con criterio y no se deja arrastrar por la expansión inmediata.

---

### Cierre de primera reunión

**Marcos:** Por ahora, lo que entiendo es esto: el dolor principal está en el seguimiento de pedidos especiales, el control de abonos y la coordinación con producción. En una siguiente reunión me gustaría bajar eso mejor a pasos, estados, excepciones y prioridades para proponer una primera versión seria.

**Marta:** Sí, me parece bien.

**Marcos:** Perfecto. En esa siguiente conversación ya podemos revisar cómo empieza un pedido, qué información debe registrarse, qué estados debe tener y qué parte conviene resolver primero.

---

## Qué logró bien esta conversación

- detectó el problema principal
- separó venta rápida de pedidos especiales
- descubrió un flujo importante
- identificó entidades iniciales
- detectó estados
- detectó necesidad documental
- evitó prometer un sistema gigante
- dejó clara la siguiente etapa

## Qué no hizo todavía

- no cerró alcance final
- no habló de precio definitivo
- no definió pantallas exactas
- no discutió tecnología de implementación
- no se comprometió a resolver todo en una sola fase

## Módulos que ya se intuyen en este caso

- **pedido especial** → expediente / caso vivo
- **lista de pedidos pendientes** → bandeja / cola operativa
- **registro inicial del pedido** → wizard o flujo guiado ligero
- **abonos y cobros** → transaccional
- **comprobante** → documental
- **resumen de pedidos del día** → dashboard o reportes

## Lección práctica

Una buena conversación inicial no intenta cerrar el sistema. Intenta descubrir el problema real, separar lo esencial de lo accesorio y preparar una segunda reunión con más estructura.
