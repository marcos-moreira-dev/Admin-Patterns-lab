# Heurísticas prácticas para dirigir IA y código

## Propósito
Convertir intuiciones útiles en instrucciones concretas para revisar o pedir código de forma más precisa.

## Heurísticas base
- baja el acoplamiento entre módulos
- sube la cohesión interna de cada pieza
- no mezcles UI con lógica de negocio
- no metas reglas de negocio profundas en controllers
- separa caso de uso de acceso a datos
- usa nombres que expresen intención
- evita abstracciones que todavía no se justifican
- cuando una clase hace demasiado, divídela por responsabilidad
- cuando una pantalla hace demasiado, separa flujo, detalle y acciones
- encapsula dependencias externas importantes
- evita que el dominio dependa de detalles de framework
- usa errores con contexto y mensajes entendibles

## Cómo pedirle mejor a una IA
En vez de decir “ordena esto”, conviene decir cosas como:
- separa responsabilidades entre controller, caso de uso y repositorio
- evita duplicación de validaciones
- crea un servicio de aplicación para orquestar el flujo
- extrae una abstracción para reducir acoplamiento con la librería externa
- diseña esta pantalla como expediente, no como CRUD
