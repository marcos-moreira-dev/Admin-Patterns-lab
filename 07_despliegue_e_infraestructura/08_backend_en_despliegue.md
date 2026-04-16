# Backend en despliegue

## Qué debes definir
- dónde corre
- con qué configuración
- cómo se conecta a la base
- cómo se reinicia
- cómo deja logs
- cómo se versiona

## Elementos mínimos
- artefacto claro
- variables de entorno
- perfil de producción
- acceso controlado
- logs consultables
- healthcheck básico si es posible

## Qué debes poder responder
- ¿cómo se arranca?
- ¿cómo se detiene?
- ¿qué puerto usa?
- ¿qué necesita para conectarse a la base?
- ¿dónde se revisan errores?
- ¿qué versión está desplegada?

## Error común
Tener el backend funcionando sin saber reproducir el despliegue ni explicar cómo operarlo.
