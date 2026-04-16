# Mapa del proyecto JavaFX mínimo

## Estructura sugerida

```text
javafx-admin-patterns-lab/
├── pom.xml
├── README.md
├── src/main/java/com/marcos/adminlab/
│   ├── AdminPatternsLabApp.java
│   ├── shell/
│   ├── navigation/
│   ├── shared/
│   ├── mockdata/
│   └── modules/
├── src/main/resources/com/marcos/adminlab/
│   ├── styles/
│   ├── shell/
│   └── modules/
```

## Idea de organización

- `shell/` contiene la estructura general de la aplicación
- `navigation/` organiza categorías y variantes
- `shared/` contiene modelos y utilidades reutilizables
- `mockdata/` aporta datos en memoria
- `modules/` contiene las vistas y controllers por tipo de módulo

## Regla importante

El laboratorio debe sentirse como un catálogo de patrones, no como un sistema improvisado sin criterio.
