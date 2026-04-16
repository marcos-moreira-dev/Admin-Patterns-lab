# Cómo leer este bloque

Este bloque no defiende una arquitectura pesada por defecto. Defiende una arquitectura suficiente para el nivel de madurez del sistema.

## Tesis principal

**el backend debe crecer al ritmo del problema real.**

## Cómo leerlo bien

### Nivel 1. MVP o V1 inicial
- monolito modular
- capas mínimas razonables
- servicios claros
- pocas abstracciones
- puertos y adaptadores solo donde haya frontera externa real

### Nivel 2. Sistema ya usado
- módulos más definidos
- más trazabilidad
- más disciplina de errores, contratos y seguridad
- más claridad entre aplicación, dominio e infraestructura

### Nivel 3. Sistema complejo
- patrones más sofisticados solo si ya existen señales reales de escala, equipos múltiples, integración fuerte o despliegue independiente

## Qué no hay que interpretar mal

- hexagonal no significa ceremonias obligatorias
- DI no significa una interfaz por cada clase
- adaptador no significa envolver todo con otra capa porque sí
- profesional no significa pesado

## Cómo está organizado

- `01` a `03`: marco general y postura arquitectónica
- `04` a `07`: módulos, casos de uso, dominio y adaptadores
- `08` a `15`: contratos, validaciones, seguridad, filtros, trazabilidad y operación técnica
- `16` y `17`: testing y estructura base
- `18`: conceptos arquitectónicos y cuándo usarlos


## Cross-links útiles
- Para criterio de complejidad: `../09_fundamentos_de_diseno_y_calidad/14_arquitectura_suficiente_y_sobreingenieria.md`
- Para MVP y V1: `../16_mvp_mercado_y_validacion_comercial/README.md`
- Para sistema administrativo y UI: `../05_diseno_del_sistema_administrativo/README.md`
