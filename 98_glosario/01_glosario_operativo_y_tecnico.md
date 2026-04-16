# Glosario operativo y técnico

Este glosario reúne términos que aparecen de forma transversal en análisis, modelado, backend, base de datos, UI, despliegue, mantenimiento, negociación y uso de IA.

No pretende reemplazar los documentos de criterio de la biblioteca. Su función es más concreta:

- dar una definición simple,
- ubicar el término en una categoría,
- mostrar un ejemplo breve,
- y ayudarte a reconocer por qué importa en el día a día.

## Cómo usar este glosario

Cuando un término te suene bonito pero borroso, busca aquí primero. Si luego ese término afecta decisiones de arquitectura, diseño o negociación, el siguiente paso es ir al bloque temático correspondiente.

## Mapa de categorías

- Negocio, producto y negociación
- Modelado y base de datos
- Arquitectura y diseño
- Backend e integración
- UI, interacción y frontend
- Despliegue, operación y mantenimiento
- IA, productividad y flujo de trabajo
- Acrónimos y referencias de calidad

---

## Negocio, producto y negociación

### Scope
**Categoría:** proyecto / cliente / producto  
**Idea simple:** alcance real del trabajo acordado.  
**Ejemplo:** “esta fase incluye recepción, estado y entrega; no incluye reportes avanzados ni facturación electrónica”.  
**Por qué importa:** si el scope no se define, el proyecto se infla y el trabajo deja de ser defendible.

### Scope creep
**Categoría:** proyecto / negociación / riesgo  
**Idea simple:** crecimiento descontrolado del alcance por pequeños agregados no gestionados.  
**Ejemplo:** al proyecto inicial le empiezan a meter garantías, inventario, reportes y WhatsApp “de una vez”.  
**Por qué importa:** es una de las formas más comunes de regalar trabajo y perder tiempo.

### MVP
**Categoría:** producto / priorización  
**Idea simple:** versión mínima útil que resuelve lo esencial y permite validar o cobrar.  
**Ejemplo:** en una tienda de reparación, recepción + estado + entrega + cobro básico.  
**Por qué importa:** te obliga a cortar alcance y a construir lo que realmente mueve el negocio.

### V1
**Categoría:** producto / evolución  
**Idea simple:** primera versión más estable que el MVP, ya pensada para operar mejor y crecer con menos fricción.  
**Ejemplo:** después de validar el flujo central, agregar roles, mejores reportes y trazabilidad más sólida.  
**Por qué importa:** evita confundir un MVP táctico con un producto ya más asentado.

### Product-market fit
**Categoría:** producto / mercado  
**Idea simple:** momento en que el producto encaja de forma clara con una necesidad real del mercado.  
**Ejemplo:** varios negocios del mismo rubro empiezan a querer el mismo sistema con pequeñas variaciones.  
**Por qué importa:** antes de ese punto, la prioridad suele ser validar; después, la prioridad cambia hacia estabilidad y crecimiento.

### Roadmap
**Categoría:** producto / planificación  
**Idea simple:** mapa de fases y mejoras previstas para un producto o sistema.  
**Ejemplo:** MVP, luego V1, luego reportes, luego inventario más fino.  
**Por qué importa:** permite hablar de evolución sin prometer todo de una vez.

### Backlog
**Categoría:** proyecto / operación  
**Idea simple:** lista de pendientes o cosas por hacer.  
**Ejemplo:** mejoras solicitadas por el cliente, bugs, refactors y nuevas fases.  
**Por qué importa:** te da un lugar ordenado donde aterrizar lo que todavía no entra.

### Handoff
**Categoría:** flujo / operación / UX  
**Idea simple:** momento en que una tarea pasa de una persona, área o sistema a otra.  
**Ejemplo:** recepción registra una orden y luego el caso pasa al técnico.  
**Por qué importa:** ayuda a detectar fricciones, responsables y puntos donde se pierde información.

### Workflow
**Categoría:** negocio / procesos  
**Idea simple:** secuencia real de trabajo de una operación.  
**Ejemplo:** recibir equipo, diagnosticar, aprobar, reparar, entregar.  
**Por qué importa:** modelar software sin workflow suele producir pantallas que no siguen la realidad.

### Ownership
**Categoría:** operación / equipo / soporte  
**Idea simple:** responsabilidad clara sobre una tarea, módulo, incidente o decisión.  
**Ejemplo:** “el estado de las órdenes lo mantiene recepción, no caja”.  
**Por qué importa:** sin ownership, los problemas quedan difusos y nadie se hace cargo.

### Blocker
**Categoría:** proyecto / flujo / soporte  
**Idea simple:** impedimento que bloquea el avance.  
**Ejemplo:** falta una decisión del cliente sobre cómo manejar garantías.  
**Por qué importa:** detectar blockers temprano ahorra días de espera improductiva.

### Incident
**Categoría:** mantenimiento / operación  
**Idea simple:** problema reportado en operación real.  
**Ejemplo:** una orden quedó en estado imposible y no se puede entregar.  
**Por qué importa:** no todo bug es igual; un incidente tiene impacto operativo.

### SLA
**Categoría:** operación / soporte / servicio  
**Idea simple:** acuerdo o expectativa de tiempos de respuesta y resolución.  
**Ejemplo:** responder tickets en menos de 24 horas hábiles.  
**Por qué importa:** ayuda a separar soporte serio de disponibilidad ilimitada e informal.

### Pilot
**Categoría:** validación / producto  
**Idea simple:** uso controlado de una versión inicial en un entorno real o casi real.  
**Ejemplo:** poner el sistema solo en caja o solo en recepción antes de extenderlo a todo el negocio.  
**Por qué importa:** reduce riesgo y te da feedback real sin soltar toda la complejidad de una vez.

### Rollout
**Categoría:** despliegue / adopción  
**Idea simple:** despliegue gradual o controlado de una versión o funcionalidad.  
**Ejemplo:** primero se activa el nuevo módulo en una sucursal o con un usuario piloto.  
**Por qué importa:** evita cambios bruscos que rompan operación o confundan usuarios.

---

## Modelado y base de datos

### Entity
**Categoría:** dominio / base de datos  
**Idea simple:** cosa importante del negocio o del modelo de datos que tiene identidad propia.  
**Ejemplo:** cliente, orden, receta, producto, reparación.  
**Por qué importa:** distinguir bien las entidades evita tablas innecesarias o datos mal agrupados.

### Attribute
**Categoría:** modelado / datos  
**Idea simple:** dato propio de una entidad.  
**Ejemplo:** nombre, teléfono, fecha_ingreso, estado.  
**Por qué importa:** ayuda a no convertir cada dato en entidad separada sin necesidad.

### Relationship
**Categoría:** modelado / datos  
**Idea simple:** vínculo entre entidades.  
**Ejemplo:** un cliente puede tener muchas órdenes.  
**Por qué importa:** de aquí salen cardinalidades, claves foráneas y reglas importantes del sistema.

### Cardinality
**Categoría:** base de datos / modelado  
**Idea simple:** relación de cantidad entre entidades.  
**Ejemplo:** uno a muchos, muchos a muchos.  
**Por qué importa:** si la cardinalidad está mal entendida, la base y el backend nacen torcidos.

### Catalog
**Categoría:** modelado / datos / configuración  
**Idea simple:** lista relativamente estable de valores que se reutilizan.  
**Ejemplo:** tipos de falla, categorías de gasto, métodos de pago.  
**Por qué importa:** un catálogo bien detectado evita texto libre caótico.

### Constraint
**Categoría:** datos / reglas / arquitectura  
**Idea simple:** restricción o límite que algo debe respetar.  
**Ejemplo:** no permitir monto negativo o duplicar un código único.  
**Por qué importa:** protege la coherencia de los datos.

### Normalization
**Categoría:** base de datos / modelado  
**Idea simple:** organizar tablas para reducir redundancia e inconsistencias.  
**Ejemplo:** separar clientes de órdenes en lugar de repetir todos los datos del cliente en cada registro.  
**Por qué importa:** da una base más mantenible, aunque no debe convertirse en purismo ciego.

### Denormalization
**Categoría:** base de datos / rendimiento / pragmatismo  
**Idea simple:** duplicar o simplificar ciertos datos de forma controlada para ganar velocidad o facilidad operativa.  
**Ejemplo:** guardar un total calculado si recalcularlo siempre sería caro o poco práctico.  
**Por qué importa:** recuerda que no toda solución correcta pasa por máxima pureza teórica.

### Index
**Categoría:** base de datos / rendimiento  
**Idea simple:** estructura que acelera búsquedas, a cambio de cierto costo.  
**Ejemplo:** índice por número de orden o por fecha de ingreso.  
**Por qué importa:** mejora consultas frecuentes, pero abusar de índices también tiene costo.

### Migration
**Categoría:** base de datos / versionado  
**Idea simple:** cambio versionado del esquema o los datos.  
**Ejemplo:** agregar una columna, crear una tabla o transformar estados.  
**Por qué importa:** es la forma sana de evolucionar la base sin tocar producción a mano y sin rastro.

### Rollback
**Categoría:** backend / base de datos / despliegue  
**Idea simple:** volver atrás una operación o cambio cuando algo falla.  
**Ejemplo:** si una migración o una transacción sale mal, se deshacen los cambios parciales.  
**Por qué importa:** evita dejar el sistema en estado inconsistente.

### Seed
**Categoría:** base de datos / arranque / pruebas  
**Idea simple:** datos iniciales para arrancar o probar un sistema.  
**Ejemplo:** usuarios demo, categorías, estados, registros simulados.  
**Por qué importa:** permite desarrollar, demostrar y probar sin trabajar sobre vacío.

### Schema
**Categoría:** base de datos / estructura  
**Idea simple:** organización general de tablas, columnas, claves y restricciones.  
**Ejemplo:** el conjunto de tablas académicas o administrativas de un sistema.  
**Por qué importa:** es la forma estructural de la base; cambiarlo sin control puede romper todo alrededor.

### Mapping
**Categoría:** backend / datos / arquitectura  
**Idea simple:** transformación de una estructura a otra.  
**Ejemplo:** convertir una entidad persistida a un DTO o un formulario a un comando.  
**Por qué importa:** el mapping ayuda, pero mapear por reflejo sin necesidad también genera ruido.

### Data dictionary
**Categoría:** base de datos / documentación  
**Idea simple:** documento que explica qué significa cada tabla y cada columna.  
**Ejemplo:** propósito, tipo, nulidad, PK/FK y observaciones de negocio por columna.  
**Por qué importa:** el SQL dice cómo está hecho; el diccionario dice qué significa.

---

## Arquitectura y diseño

### Layered architecture
**Categoría:** arquitectura / diseño  
**Idea simple:** organización por capas según responsabilidad.  
**Ejemplo:** controller, servicio, repositorio, persistencia.  
**Por qué importa:** sigue siendo útil, pero no debe convertirse en carpetas vacías sin propósito.

### Clean Architecture
**Categoría:** arquitectura / diseño  
**Idea simple:** enfoque donde las dependencias deberían apuntar hacia el núcleo del negocio.  
**Ejemplo:** que el dominio no dependa directamente de Spring o de la base de datos.  
**Por qué importa:** da criterio para proteger el negocio, pero aplicada a lo loco puede inflar el proyecto.

### Hexagonal architecture
**Categoría:** arquitectura / diseño  
**Idea simple:** enfoque de puertos y adaptadores alrededor de un núcleo.  
**Ejemplo:** puertos para persistencia y adaptadores concretos para JPA o archivos.  
**Por qué importa:** es útil donde hay fronteras reales, no como religión universal.

### Modular monolith
**Categoría:** arquitectura / diseño / producto  
**Idea simple:** sistema desplegado como una sola aplicación, pero organizado en módulos claros.  
**Ejemplo:** clientes, ventas, inventario y soporte en un mismo backend bien delimitado.  
**Por qué importa:** suele ser la vieja confiable para sistemas administrativos pequeños y medianos.

### Port
**Categoría:** arquitectura / diseño  
**Idea simple:** contrato que expresa una necesidad del sistema hacia afuera.  
**Ejemplo:** “guardar orden”, “generar PDF”, “enviar notificación”.  
**Por qué importa:** útil en fronteras reales; innecesario si solo duplica una llamada trivial.

### Adapter
**Categoría:** arquitectura / integración  
**Idea simple:** implementación concreta que conecta una necesidad abstracta con una tecnología real.  
**Ejemplo:** adaptador JPA para un puerto de persistencia.  
**Por qué importa:** aporta cuando hay una frontera o posible cambio; no por costumbre.

### Anti-corruption layer
**Categoría:** arquitectura / integración  
**Idea simple:** capa que protege tu modelo interno cuando te integras con un sistema externo raro o sucio.  
**Ejemplo:** transformar datos de una API externa antes de mezclarlos con tu dominio.  
**Por qué importa:** evita contaminar tu modelo con reglas ajenas.

### Bounded context
**Categoría:** arquitectura / dominio  
**Idea simple:** límite semántico dentro del cual un modelo tiene sentido propio.  
**Ejemplo:** “inventario” y “ventas” pueden hablar de producto, pero no exactamente igual.  
**Por qué importa:** ayuda a no mezclar significados y a modularizar con criterio.

### App context
**Categoría:** arquitectura / frontend / desktop  
**Idea simple:** contexto compartido de aplicación donde viven dependencias, estado global o servicios comunes.  
**Ejemplo:** estado de sesión, navegación, seeds en memoria y servicios compartidos del laboratorio JavaFX.  
**Por qué importa:** ayuda a centralizar piezas comunes, pero si se vuelve cajón de sastre ensucia la arquitectura.

### Bootstrap
**Categoría:** arquitectura / arranque / despliegue  
**Idea simple:** proceso inicial mediante el cual la aplicación prepara su configuración, dependencias y componentes base.  
**Ejemplo:** levantar shell, servicios in-memory y estado compartido al iniciar una app.  
**Por qué importa:** te obliga a decidir qué debe existir desde el arranque y qué se carga luego.

### Bootstrapping
**Categoría:** arquitectura / arranque / proyecto  
**Idea simple:** acción de poner en marcha un proyecto o sistema desde su base mínima funcional.  
**Ejemplo:** crear estructura inicial, levantar entorno local y dejar una primera versión corriendo.  
**Por qué importa:** conecta muy bien con la idea de MVP y arranque controlado.

### Separation of concerns
**Categoría:** arquitectura / diseño / calidad  
**Idea simple:** separar responsabilidades para que no se mezclen sin necesidad.  
**Ejemplo:** no meter reglas de negocio dentro de una vista JavaFX ni de un controller HTTP.  
**Por qué importa:** es una de las defensas más útiles contra el caos.

### Coupling
**Categoría:** diseño / arquitectura / calidad  
**Idea simple:** nivel de dependencia entre piezas.  
**Ejemplo:** un módulo que necesita demasiados detalles internos de otro.  
**Por qué importa:** mucho acoplamiento vuelve caro cualquier cambio.

### Cohesion
**Categoría:** diseño / arquitectura / calidad  
**Idea simple:** qué tan bien encajan las responsabilidades dentro de una misma pieza.  
**Ejemplo:** una clase que solo trata órdenes frente a una que mezcla órdenes, PDF, email y reportes.  
**Por qué importa:** alta cohesión suele hacer el código más entendible y mantenible.

### Trade-off
**Categoría:** transversal / diseño / producto  
**Idea simple:** elegir una ventaja aceptando un costo o desventaja.  
**Ejemplo:** menos capas para ganar velocidad, a costa de menor flexibilidad futura.  
**Por qué importa:** casi toda decisión seria de arquitectura implica trade-offs.

### Fancy
**Categoría:** coloquial / criterio técnico  
**Idea simple:** algo que suena elegante o impresionante, pero no necesariamente útil en el contexto real.  
**Ejemplo:** meter CQRS, eventos y 20 capas en un MVP de tres tablas.  
**Por qué importa:** te recuerda que “sofisticado” no siempre significa “correcto”.

### Overengineering
**Categoría:** arquitectura / criterio / producto  
**Idea simple:** meter más complejidad de la necesaria para el problema actual.  
**Ejemplo:** interfaces, mappers y adaptadores por todas partes para un CRUD que aún ni se valida con usuarios.  
**Por qué importa:** drena tiempo, claridad y velocidad de aprendizaje.

### Single source of truth
**Categoría:** datos / arquitectura / consistencia  
**Idea simple:** lugar principal y confiable donde vive una verdad del sistema.  
**Ejemplo:** el estado real de una orden no debería depender de tres listas distintas.  
**Por qué importa:** evita contradicciones y reduce confusión.

### Code smell
**Categoría:** calidad / diseño / código  
**Idea simple:** olor o señal de que algo podría estar mal diseñado o mal ubicado.  
**Ejemplo:** controller enorme, duplicación, estado ambiguo, demasiados if anidados.  
**Por qué importa:** no siempre implica rehacer todo, pero sí merece atención.

### Technical debt
**Categoría:** calidad / mantenimiento  
**Idea simple:** costo futuro acumulado por decisiones rápidas o imperfectas.  
**Ejemplo:** copiar lógica en tres lugares para salir del paso.  
**Por qué importa:** no toda deuda es mala, pero sí debe ser consciente.

### Refactor
**Categoría:** calidad / mantenimiento / código  
**Idea simple:** mejorar la estructura sin cambiar el comportamiento externo esperado.  
**Ejemplo:** dividir una clase gorda o aclarar nombres y responsabilidades.  
**Por qué importa:** mantiene saludable el sistema sin reescribirlo todo.

---

## Backend e integración

### Endpoint
**Categoría:** backend / API  
**Idea simple:** punto de entrada de una API.  
**Ejemplo:** `POST /ordenes`, `GET /clientes`.  
**Por qué importa:** es la forma visible en que otros consumen tu backend.

### Payload
**Categoría:** API / integración  
**Idea simple:** datos que viajan en una petición o respuesta.  
**Ejemplo:** el JSON que envías para crear una orden.  
**Por qué importa:** es parte del contrato entre sistemas o capas.

### DTO
**Categoría:** backend / API / contratos  
**Idea simple:** objeto de transferencia de datos entre capas o sistemas.  
**Ejemplo:** respuesta resumida de una orden o formulario de creación.  
**Por qué importa:** ayuda a no exponer todo tu modelo interno, pero no conviene multiplicarlos sin necesidad.

### Mapper
**Categoría:** backend / transformación  
**Idea simple:** pieza que transforma un objeto en otro.  
**Ejemplo:** entidad a DTO, comando a entidad.  
**Por qué importa:** útil cuando realmente hay dos modelos distintos; si no, puede ser puro boilerplate.

### Validation
**Categoría:** backend / UI / negocio  
**Idea simple:** comprobación de que los datos o acciones cumplen reglas.  
**Ejemplo:** no permitir registrar una entrega sin pago completo cuando la regla lo prohíbe.  
**Por qué importa:** sin validación, el sistema deja pasar errores del negocio y de los datos.

### Exception
**Categoría:** backend / errores / negocio  
**Idea simple:** error controlado o inesperado que altera el flujo normal.  
**Ejemplo:** “orden no encontrada”, “usuario sin permiso”, “monto inválido”.  
**Por qué importa:** el manejo de excepciones define mucho la robustez y claridad del sistema.

### Timeout
**Categoría:** integración / red / backend  
**Idea simple:** tiempo máximo de espera antes de considerar que algo falló.  
**Ejemplo:** esperar demasiado por una API externa o una operación de red.  
**Por qué importa:** evita quedarse colgado indefinidamente y mejora resiliencia.

### Retry
**Categoría:** integración / resiliencia  
**Idea simple:** reintento de una operación.  
**Ejemplo:** volver a intentar una llamada externa si hubo un fallo transitorio.  
**Por qué importa:** puede salvar integraciones inestables, pero abusar de retries también genera ruido o duplicados.

### Fallback
**Categoría:** backend / resiliencia / UX  
**Idea simple:** alternativa cuando algo falla.  
**Ejemplo:** mostrar una versión degradada del dato o usar una ruta simple de respaldo.  
**Por qué importa:** ayuda a mantener operación mínima cuando una dependencia externa falla.

### Idempotency
**Categoría:** backend / API / transacciones  
**Idea simple:** repetir una operación sin duplicar sus efectos.  
**Ejemplo:** reenviar una confirmación de pago sin generar dos cobros.  
**Por qué importa:** reduce muchos errores en operaciones críticas.

### Pagination
**Categoría:** API / UI / consulta  
**Idea simple:** dividir resultados grandes en páginas.  
**Ejemplo:** listar órdenes de 20 en 20.  
**Por qué importa:** protege rendimiento y usabilidad.

### Sorting
**Categoría:** consulta / API / UI  
**Idea simple:** ordenamiento de resultados.  
**Ejemplo:** por fecha descendente o por prioridad.  
**Por qué importa:** permite navegar mejor grandes listas.

### Filtering
**Categoría:** consulta / API / UI  
**Idea simple:** filtrado de resultados por criterios.  
**Ejemplo:** solo órdenes abiertas, solo gastos del mes, solo documentos activos.  
**Por qué importa:** sin filtros, una aplicación administrativa se vuelve torpe.

### Contract
**Categoría:** API / integración / diseño  
**Idea simple:** forma esperada de una interacción entre partes.  
**Ejemplo:** estructura JSON, códigos de respuesta y reglas de un endpoint.  
**Por qué importa:** si el contrato cambia sin control, rompes consumidores.

### Concurrency
**Categoría:** backend / datos / rendimiento  
**Idea simple:** varias operaciones ocurriendo al mismo tiempo.  
**Ejemplo:** dos usuarios editando estados o registrando ventas.  
**Por qué importa:** introduce choques, bloqueos y necesidad de consistencia.

### Consistency
**Categoría:** base de datos / negocio / arquitectura  
**Idea simple:** mantener los datos en un estado válido y coherente.  
**Ejemplo:** que una orden no esté “entregada” si el pago aún figura pendiente.  
**Por qué importa:** sin consistencia, el sistema puede “funcionar” técnicamente y aun así mentir.

### Transaction
**Categoría:** backend / base de datos / negocio  
**Idea simple:** conjunto de operaciones que deben confirmarse o fallar como una unidad.  
**Ejemplo:** registrar venta, descontar stock y guardar comprobante juntos.  
**Por qué importa:** protege integridad en operaciones críticas.

### Commit
**Categoría:** base de datos / control de versiones  
**Idea simple:** confirmar un cambio. En base de datos confirma una transacción; en Git guarda un cambio versionado.  
**Ejemplo:** confirmar la operación completa o registrar una versión del código.  
**Por qué importa:** es un término transversal y muy usado en contextos distintos.

### CQRS
**Categoría:** arquitectura / backend  
**Idea simple:** separar modelos de lectura y escritura cuando el problema lo justifica.  
**Ejemplo:** un backend donde las consultas complejas y las escrituras críticas necesitan caminos distintos.  
**Por qué importa:** puede ser útil, pero meterlo por moda en un MVP suele inflar el sistema.

### Event sourcing
**Categoría:** arquitectura / backend / persistencia  
**Idea simple:** guardar cambios como eventos en lugar de guardar solo el estado actual.  
**Ejemplo:** almacenar cada transición de una cuenta o proceso como evento histórico.  
**Por qué importa:** es potente, pero trae mucha complejidad; no es punto de partida normal para admin apps pequeñas.

### Domain event
**Categoría:** arquitectura / dominio  
**Idea simple:** evento que representa algo importante ocurrido dentro del negocio.  
**Ejemplo:** “orden aprobada”, “reparación cerrada”, “pago registrado”.  
**Por qué importa:** ayuda a desacoplar reacciones del sistema, pero no debe introducir maquinaria innecesaria.

### Multitenancy
**Categoría:** arquitectura / producto / SaaS  
**Idea simple:** una misma solución sirve a varios clientes o tenants compartiendo parte de la infraestructura.  
**Ejemplo:** una plataforma donde varias ópticas usan la misma aplicación con sus datos aislados.  
**Por qué importa:** es una preocupación de otra escala; rara vez es prioridad del primer MVP para un solo negocio.

### Distributed system
**Categoría:** arquitectura / infraestructura  
**Idea simple:** sistema compuesto por varias partes que se comunican por red.  
**Ejemplo:** microservicios, colas, procesos separados, APIs entre componentes.  
**Por qué importa:** aporta flexibilidad en algunos contextos, pero sube mucho la complejidad operativa.

### Service autonomy
**Categoría:** arquitectura / sistemas distribuidos  
**Idea simple:** capacidad de un servicio para evolucionar, desplegarse y operar con cierta independencia.  
**Ejemplo:** un módulo que tiene su propio ciclo de cambios y despliegues.  
**Por qué importa:** suele usarse para justificar separación, pero solo vale cuando el contexto lo exige.

---

## UI, interacción y frontend

### Layout
**Categoría:** UI / frontend / desktop  
**Idea simple:** estructura visual general de una pantalla o sección.  
**Ejemplo:** sidebar a la izquierda, top bar arriba y workspace al centro.  
**Por qué importa:** organiza la interfaz y condiciona cómo se entiende.

### Padding
**Categoría:** UI / diseño visual / layout  
**Idea simple:** espacio interno entre el borde de un contenedor y su contenido.  
**Ejemplo:** una tarjeta con texto que respira y no queda pegado al borde.  
**Por qué importa:** mejora legibilidad y sensación de orden.

### Margin
**Categoría:** UI / diseño visual / layout  
**Idea simple:** espacio externo entre un componente y otros.  
**Ejemplo:** separación entre dos tarjetas o dos botones.  
**Por qué importa:** evita interfaces comprimidas o sucias.

### Spacing
**Categoría:** UI / layout  
**Idea simple:** separación entre hijos dentro de un contenedor.  
**Ejemplo:** separación vertical entre campos de un formulario.  
**Por qué importa:** da ritmo visual y claridad.

### Dashboard
**Categoría:** UI / análisis / monitoreo  
**Idea simple:** tablero con indicadores, alertas y resúmenes.  
**Ejemplo:** ventas del día, pedidos pendientes y alertas críticas.  
**Por qué importa:** sirve para monitorear, no para reemplazar todo el trabajo operativo.

### Wizard
**Categoría:** UI / flujo / interacción  
**Idea simple:** proceso guiado por pasos.  
**Ejemplo:** registrar pedido, luego medidas, luego pago, luego confirmación.  
**Por qué importa:** reduce errores cuando hay secuencia y dependencia entre pasos.

### Hub
**Categoría:** UI / navegación  
**Idea simple:** pantalla índice o centro de acceso a varias funciones relacionadas.  
**Ejemplo:** hub de ventas, inventario y reportes.  
**Por qué importa:** ordena mejor ciertas áreas cuando el sidebar por sí solo no basta.

### CRUD
**Categoría:** UI / interacción / administración  
**Idea simple:** patrón para crear, leer, actualizar y eliminar o activar/inactivar registros.  
**Ejemplo:** gestión de clientes, productos o categorías.  
**Por qué importa:** es una base muy común en sistemas administrativos, pero no todo módulo es un CRUD.

### Modal
**Categoría:** UI / interacción  
**Idea simple:** ventana superpuesta que exige atención puntual.  
**Ejemplo:** confirmar eliminación o editar un registro rápido.  
**Por qué importa:** útil para acciones puntuales; abusar de modales puede volver la UI torpe.

### Empty state
**Categoría:** UI / UX  
**Idea simple:** estado visual cuando no hay datos o resultados.  
**Ejemplo:** “no hay órdenes pendientes para hoy”.  
**Por qué importa:** evita pantallas muertas que parecen error.

### Feedback
**Categoría:** UI / UX  
**Idea simple:** respuesta visible del sistema a una acción del usuario.  
**Ejemplo:** mensaje de éxito, error, guardado o carga.  
**Por qué importa:** sin feedback, el usuario no sabe si su acción funcionó.

### Workspace
**Categoría:** UI / arquitectura de interacción / desktop  
**Idea simple:** área central de trabajo donde cambia el contenido del módulo activo.  
**Ejemplo:** el sidebar y la top bar permanecen fijos, pero el centro carga el dashboard, el CRUD o el expediente.  
**Por qué importa:** te ayuda a pensar la app como shell + navegación + contenido intercambiable.

### Sidebar
**Categoría:** UI / navegación  
**Idea simple:** barra lateral que contiene navegación principal o secciones del sistema.  
**Ejemplo:** acceso a dashboard, clientes, ventas, reportes y configuración.  
**Por qué importa:** estructura la entrada a la aplicación, sobre todo en desktop y admin web.

### Top bar
**Categoría:** UI / navegación / shell  
**Idea simple:** barra superior con contexto, acciones globales o estado de sesión.  
**Ejemplo:** usuario actual, botón para colapsar menú, ayuda y estado del sistema.  
**Por qué importa:** da contexto global sin saturar el workspace.

### Router
**Categoría:** frontend / web / navegación  
**Idea simple:** componente o mecanismo que decide qué vista cargar según la ruta o acción de navegación.  
**Ejemplo:** el router de Angular que carga clientes, ventas o reportes según la URL.  
**Por qué importa:** ordena navegación, guards y layouts, pero no debe sobrediseñarse.

### Routing
**Categoría:** frontend / web / navegación  
**Idea simple:** conjunto de reglas y mecanismos que controlan cómo se navega entre vistas.  
**Ejemplo:** rutas como `/clientes`, `/ventas`, `/reportes` con guards administrativos.  
**Por qué importa:** un routing limpio ayuda; uno inflado vuelve torpe el frontend.

### App shell
**Categoría:** UI / arquitectura de interacción  
**Idea simple:** estructura fija de la aplicación sobre la que se cargan los módulos.  
**Ejemplo:** top bar, sidebar, workspace y footer.  
**Por qué importa:** da coherencia y evita diseñar cada pantalla como planeta aparte.

---

## Despliegue, operación y mantenimiento

### Build
**Categoría:** despliegue / proyecto  
**Idea simple:** proceso de construcción del software.  
**Ejemplo:** compilar backend, empaquetar app desktop o generar un build web.  
**Por qué importa:** es el paso que convierte el código en algo ejecutable o distribuible.

### Artifact
**Categoría:** despliegue / build  
**Idea simple:** archivo resultante listo para usar o desplegar.  
**Ejemplo:** jar, war, instalador, zip de release.  
**Por qué importa:** es lo que realmente viaja a un entorno o cliente.

### Release
**Categoría:** despliegue / versionado  
**Idea simple:** versión publicada o preparada para entrega.  
**Ejemplo:** v1.0.0 con notas de cambio y artefactos listos.  
**Por qué importa:** ayuda a separar entregas serias de builds sueltos.

### Deploy
**Categoría:** despliegue / operación  
**Idea simple:** puesta del software en un entorno.  
**Ejemplo:** pasar el backend a producción o instalar la app desktop en un equipo cliente.  
**Por qué importa:** construir no es lo mismo que desplegar.

### Environment
**Categoría:** despliegue / operación  
**Idea simple:** entorno, por ejemplo desarrollo, pruebas o producción.  
**Ejemplo:** dev, test, staging, prod.  
**Por qué importa:** los mismos archivos no siempre deberían comportarse igual en todos los entornos.

### Staging
**Categoría:** despliegue / validación  
**Idea simple:** entorno previo a producción.  
**Ejemplo:** un entorno donde validas un release antes de soltarlo.  
**Por qué importa:** reduce sustos antes del cambio real.

### Healthcheck
**Categoría:** operación / monitoreo  
**Idea simple:** verificación básica de salud del sistema.  
**Ejemplo:** endpoint o prueba simple que indica si la app está viva.  
**Por qué importa:** ayuda a detectar caída o degradación.

### Logging
**Categoría:** operación / backend / soporte  
**Idea simple:** registro de eventos para diagnóstico y trazabilidad.  
**Ejemplo:** errores, cambios de estado, accesos, operaciones críticas.  
**Por qué importa:** sin logs, el soporte se vuelve adivinanza.

### Monitoring
**Categoría:** operación / mantenimiento  
**Idea simple:** observación continua del comportamiento del sistema.  
**Ejemplo:** revisar errores, latencias o caídas.  
**Por qué importa:** te ayuda a detectar problemas antes o mientras ocurren.

### Observability
**Categoría:** operación / calidad / soporte  
**Idea simple:** capacidad de entender qué está pasando dentro del sistema usando señales como logs, métricas y trazas.  
**Ejemplo:** poder seguir una operación y entender dónde falló.  
**Por qué importa:** es una mirada más completa que solo “tener logs”.

### Correlation ID
**Categoría:** soporte / backend / trazabilidad  
**Idea simple:** identificador que permite seguir una misma operación a través de varios pasos o servicios.  
**Ejemplo:** un id incluido en logs de una solicitud, PDF y cambio de estado.  
**Por qué importa:** mejora muchísimo el diagnóstico.

### Backup
**Categoría:** operación / datos  
**Idea simple:** respaldo de información.  
**Ejemplo:** copia de la base de datos antes de una migración crítica.  
**Por qué importa:** si algo sale mal y no hay backup, el costo puede ser alto.

### Restore
**Categoría:** operación / recuperación  
**Idea simple:** restauración de un respaldo.  
**Ejemplo:** recuperar la base a un estado anterior.  
**Por qué importa:** un backup sin restore probado es una falsa seguridad.

### Pipeline
**Categoría:** CI/CD / automatización  
**Idea simple:** cadena automatizada de pasos.  
**Ejemplo:** compilar, probar, empaquetar y publicar.  
**Por qué importa:** reduce errores manuales y da repetibilidad.

### CI/CD
**Categoría:** despliegue / automatización  
**Idea simple:** integración continua y entrega o despliegue continuo.  
**Ejemplo:** correr pruebas automáticas y generar artefactos al integrar cambios.  
**Por qué importa:** te acerca a un proceso más estable y menos artesanal.

### Hotfix
**Categoría:** mantenimiento / producción  
**Idea simple:** arreglo urgente en producción.  
**Ejemplo:** corregir un bug crítico que impide cobrar o entregar.  
**Por qué importa:** exige cuidado y suele tener más presión que un cambio normal.

### Patch
**Categoría:** mantenimiento / versiones  
**Idea simple:** corrección puntual o pequeña actualización.  
**Ejemplo:** arreglar un detalle de validación sin cambiar media arquitectura.  
**Por qué importa:** no todo cambio tiene que ser una versión mayor.

### Root cause
**Categoría:** soporte / diagnóstico  
**Idea simple:** causa raíz de un problema.  
**Ejemplo:** no solo “falló el botón”, sino “faltó validar un estado previo y se rompió el flujo”.  
**Por qué importa:** arreglar síntomas sin causa raíz solo pospone el problema.

### Workaround
**Categoría:** operación / mantenimiento  
**Idea simple:** solución provisional o rodeo temporal.  
**Ejemplo:** registrar algo manualmente mientras se corrige el bug real.  
**Por qué importa:** útil para sobrevivir, pero no debe volverse solución permanente.

### Bottleneck
**Categoría:** rendimiento / operación / arquitectura  
**Idea simple:** cuello de botella que frena el sistema o proceso.  
**Ejemplo:** una consulta lenta o un paso humano que retrasa todo el flujo.  
**Por qué importa:** ayuda a priorizar mejoras con retorno real.

---

## IA, productividad y flujo de trabajo

### Placeholder
**Categoría:** UI / diseño / documentación  
**Idea simple:** contenido temporal que ocupa el lugar de algo real que todavía no está listo.  
**Ejemplo:** texto provisional en una vista o archivo vacío reservado dentro de una estructura.  
**Por qué importa:** permite avanzar en estructura sin esperar el contenido final.

### Mock
**Categoría:** testing / integración / backend  
**Idea simple:** simulación controlada de un componente o servicio.  
**Ejemplo:** servicio falso que devuelve pedidos sin conectarse a la API real.  
**Por qué importa:** ayuda a probar o demostrar sin depender de componentes reales.

### Stub
**Categoría:** testing / integración  
**Idea simple:** implementación mínima para que algo compile o responda de forma simple.  
**Ejemplo:** clase que devuelve datos fijos solo para avanzar.  
**Por qué importa:** evita bloquearte, aunque no debe quedarse para siempre sin revisión.

### Dummy data
**Categoría:** testing / demo / UI  
**Idea simple:** datos falsos usados para probar o mostrar comportamiento.  
**Ejemplo:** clientes y órdenes inventadas para el laboratorio JavaFX.  
**Por qué importa:** hace más realista el desarrollo temprano.

### Scaffold / scaffolding
**Categoría:** proyecto / estructura / generación  
**Idea simple:** estructura base inicial generada para arrancar más rápido.  
**Ejemplo:** carpetas, vistas y clases base de una app administrativa.  
**Por qué importa:** acelera el arranque, pero no reemplaza criterio.

### Boilerplate
**Categoría:** proyecto / arquitectura / productividad  
**Idea simple:** código o estructura repetitiva ya preparada para no empezar desde cero.  
**Ejemplo:** shell administrativo, configuración base, helpers de UI.  
**Por qué importa:** puede ahorrarte tiempo, pero si se infla demasiado se convierte en lastre.

### Onboarding
**Categoría:** proyecto / equipo / documentación  
**Idea simple:** todo lo necesario para que alguien arranque rápido y con menos fricción.  
**Ejemplo:** README, scripts, estructura clara y setup reproducible.  
**Por qué importa:** incluso si trabajas solo, te ayuda a no olvidar cómo volver a entrar a tu propio proyecto.

### Sandbox
**Categoría:** desarrollo / pruebas / entorno  
**Idea simple:** entorno aislado para probar o construir sin afectar algo real.  
**Ejemplo:** una zona donde experimentas con archivos o cambios sin tocar producción.  
**Por qué importa:** te permite experimentar con menor riesgo.

### Encoding
**Categoría:** desarrollo / archivos / interoperabilidad  
**Idea simple:** forma en que un texto se representa como bytes.  
**Ejemplo:** UTF-8, Windows-1252, UTF-16.  
**Por qué importa:** evita tildes rotas, scripts `.bat` dañados y problemas al mover archivos entre entornos.

### RAG
**Categoría:** IA / productividad / conocimiento  
**Idea simple:** técnica donde la IA consulta documentos relevantes antes de responder o generar contenido.  
**Ejemplo:** usar tu biblioteca de Markdown como memoria técnica antes de redactar o programar.  
**Por qué importa:** permite trabajar con contexto propio sin depender solo del conocimiento base del modelo.

### Prompt
**Categoría:** IA / productividad  
**Idea simple:** instrucción o contexto que le das a un modelo para que produzca una salida.  
**Ejemplo:** “genera un CRUD simple en JavaFX con datos en memoria y nombres genéricos”.  
**Por qué importa:** mejores prompts suelen producir mejores resultados, pero no reemplazan criterio.

### Context window
**Categoría:** IA / rendimiento / productividad  
**Idea simple:** cantidad de información que un modelo puede considerar a la vez.  
**Ejemplo:** archivos, reglas, fragmentos de código y conversación reciente.  
**Por qué importa:** te ayuda a decidir cuándo dividir contexto o apoyarte en RAG.

---

## Acrónimos y referencias de calidad

### SOLID
**Categoría:** diseño / orientación a objetos  
**Idea simple:** conjunto de principios para mejorar diseño, mantenibilidad y responsabilidades.  
**Ejemplo:** responsabilidad única, inversión de dependencias y segregación de interfaces.  
**Por qué importa:** útil como criterio, no como religión.

### CUPID
**Categoría:** calidad / diseño / criterio  
**Idea simple:** conjunto de cualidades deseables del código, como composable, predictable y domain-based.  
**Ejemplo:** preferir piezas que cooperen bien y reflejen el dominio.  
**Por qué importa:** complementa otras guías de diseño con una mirada más orientada a claridad y disfrute del código.

### QA
**Categoría:** calidad / testing / proceso  
**Idea simple:** aseguramiento de calidad del software.  
**Ejemplo:** probar flujos, validar requisitos y revisar que una entrega cumpla lo prometido.  
**Por qué importa:** no es solo testing; es disciplina de calidad.

### Test pyramid
**Categoría:** testing / calidad / arquitectura  
**Idea simple:** idea de distribuir las pruebas por niveles, con muchas pruebas pequeñas y menos pruebas costosas de extremo a extremo.  
**Ejemplo:** más pruebas unitarias y de servicios, menos UI end-to-end pesadas.  
**Por qué importa:** ayuda a no depender solo de pruebas manuales o de punta a punta.

### WCAG
**Categoría:** accesibilidad / UX / web  
**Idea simple:** guías de accesibilidad para contenido e interfaces web.  
**Ejemplo:** contraste suficiente, foco visible, navegación por teclado.  
**Por qué importa:** incluso en apps administrativas, la accesibilidad aporta claridad y calidad.

### ASVS
**Categoría:** seguridad / referencia / calidad  
**Idea simple:** estándar de verificación de seguridad de aplicaciones de OWASP.  
**Ejemplo:** usarlo como lista de chequeo para requisitos de seguridad.  
**Por qué importa:** te ayuda a pensar seguridad con más criterio y menos intuición vaga.

### Twelve-Factor
**Categoría:** despliegue / operación / arquitectura  
**Idea simple:** conjunto de principios para construir aplicaciones más desplegables y mantenibles.  
**Ejemplo:** configurar por variables de entorno y tratar logs como flujos de eventos.  
**Por qué importa:** no es exclusivo de SaaS gigantes; algunos principios sirven mucho en proyectos pequeños también.
