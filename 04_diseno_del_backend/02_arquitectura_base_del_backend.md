# Arquitectura base del backend

## Idea principal

La arquitectura no son solo carpetas. La arquitectura real se define por:

- responsabilidades
- dependencias
- límites
- flujo de información
- costo de cambiar algo pequeño

La pregunta correcta no es “¿qué arquitectura suena más profesional?”, sino “¿qué estructura sostiene bien la etapa actual del producto?”.

## Enfoque recomendado

Para sistemas administrativos pequeños y medianos, la base más sana suele ser:

- monolito modular
- capas internas claras
- reglas del negocio relativamente protegidas
- componentes transversales separados
- puertos y adaptadores solo donde realmente aporten claridad

## Capas mentales útiles

### Entrada
Recibe solicitudes y las traduce a la aplicación.

Ejemplos:
- controladores REST
- jobs
- cargas de archivos
- endpoints administrativos

### Aplicación
Orquesta casos de uso.

Ejemplos:
- servicios de aplicación
- coordinadores de flujo
- validaciones de caso de uso
- transiciones de estado

### Dominio
Representa el negocio.

Ejemplos:
- entidades del dominio
- value objects
- reglas importantes
- estados y transiciones

### Infraestructura
Conecta el sistema con lo externo.

Ejemplos:
- JPA
- repositorios concretos
- correo
- almacenamiento de archivos
- configuración técnica

## Módulos versus capas

No conviene confundirlos.

### Módulos
Son áreas del negocio:
- clientes
- ventas
- órdenes
- inventario
- soporte

### Capas
Son responsabilidades técnicas:
- entrada
- aplicación
- dominio
- infraestructura

Una forma madura de organizar es:
- modular por negocio
- y por capas dentro de cada módulo

## Componentes transversales

Hay piezas que atraviesan varios módulos:
- seguridad
- errores
- trazabilidad
- auditoría
- archivos
- paginación y filtros
- configuración
- observabilidad

## Cuándo seguir simple

Conviene mantener la arquitectura liviana cuando:
- el flujo principal todavía se está validando
- el dominio aún cambia rápido
- el equipo es pequeño
- el mayor dolor no es técnico, sino de producto o negocio

## Cuándo subir de nivel

Se justifica endurecer más la arquitectura cuando:
- pequeños cambios ya exigen tocar demasiadas piezas
- aparecen integraciones externas importantes
- ya hay uso real sostenido
- el negocio exige más seguridad, trazabilidad o estabilidad

## Regla práctica

Empieza con capas suficientes y módulos claros. No metas complejidad arquitectónica solo porque el framework o un tutorial la hacen fácil de generar.
