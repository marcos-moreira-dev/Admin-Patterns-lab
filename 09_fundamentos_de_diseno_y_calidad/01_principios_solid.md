# Principios SOLID

## Propósito
Este documento resume los principios SOLID como criterio práctico para diseñar software administrativo mantenible. No se trata de memorizar definiciones de libro, sino de reconocer cuándo una clase, módulo o flujo se está volviendo confuso, rígido o frágil.

## Idea general
SOLID es un conjunto de principios orientados a objetos que ayudan a bajar acoplamiento, subir cohesión y distribuir mejor responsabilidades.

## 1. SRP: Single Responsibility Principle
Una clase o componente debería tener una sola razón fuerte para cambiar.

### Señales de que se viola
- una clase valida, persiste, calcula y además formatea para UI
- un controller JavaFX carga datos, aplica reglas de negocio y muestra diálogos complejos
- un service de Spring Boot hace demasiadas cosas sin un límite claro

### Aplicación práctica
- separar validación superficial de reglas de negocio
- separar orquestación de acceso a datos
- separar pantalla de caso de uso

## 2. OCP: Open/Closed Principle
El software debería poder extenderse sin tocar demasiado lo que ya funciona.

### Idea útil
Cuando una nueva variante obliga a editar cinco lugares del sistema, probablemente falta una abstracción o una decisión de diseño mejor contenida.

### En sistemas administrativos
- nuevos tipos de reporte
- nuevos criterios de búsqueda
- nuevos tipos de documento
- nuevas reglas de aprobación

## 3. LSP: Liskov Substitution Principle
Si un tipo sustituye a otro, debería comportarse de forma compatible con lo que promete el tipo base.

### Señal de alerta
Cuando una subclase obliga a poner if raros o rompe expectativas del contrato original.

## 4. ISP: Interface Segregation Principle
Es mejor varias interfaces pequeñas y precisas que una interfaz gigante que obliga a implementar métodos inútiles.

### Aplicación práctica
- puertos específicos por capacidad
- contratos de UI o servicios más pequeños
- no mezclar lectura, escritura, exportación y aprobación en una sola interfaz masiva

## 5. DIP: Dependency Inversion Principle
Las capas de más alto nivel no deberían depender directamente de detalles concretos de infraestructura.

### Aplicación práctica
- casos de uso dependen de puertos
- infraestructura implementa esos puertos
- el dominio no depende de Spring, JPA ni JavaFX

## Cómo usar SOLID sin fanatismo
- no convertirlo en religión
- no crear diez capas innecesarias por sonar elegante
- usarlo como criterio para discutir claridad, responsabilidad y dependencias

## Traducción al día a día
Cuando digas “bájale el acoplamiento” o “esto hace demasiadas cosas”, muchas veces estás señalando una violación de SOLID de forma intuitiva.
