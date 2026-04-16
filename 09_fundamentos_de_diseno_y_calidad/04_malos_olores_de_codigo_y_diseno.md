# Malos olores de código y diseño

## Propósito
Listar señales tempranas de que el software necesita atención antes de que el problema se vuelva estructural.

## Olores frecuentes
### Clase dios
Una clase demasiado grande que sabe, coordina y controla demasiado.

### Controller gordo
En backend o JavaFX, cuando el controller acumula reglas, validaciones, queries y decisiones.

### Método kilométrico
Difícil de leer, probar y modificar.

### Duplicación
La misma lógica aparece en varios lugares.

### Ifs raros por todas partes
Suele indicar falta de modelo de dominio, estados o estrategia.

### Dependencia circular
A depende de B y B depende de A.

### Nombres ambiguos
Objetos o métodos que no expresan intención.

### Banderas o flags mágicos
Parámetros booleanos o estados ambiguos que controlan demasiadas variantes.

### UI que sabe demasiado
Pantallas o controllers que contienen reglas de negocio profundas.

### Persistencia pegada a todo
El proyecto entero gira alrededor de entities y repositories, y el negocio no tiene espacio propio.

## Qué hacer
- no refactorizar por ansiedad
- identificar primero el olor dominante
- mejorar por pequeñas decisiones con sentido
