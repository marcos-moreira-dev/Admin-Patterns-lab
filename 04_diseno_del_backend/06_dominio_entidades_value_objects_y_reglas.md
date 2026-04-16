# Dominio, entidades, value objects y reglas

## Dominio
El dominio es la representación del negocio en software. No es la base de datos ni la UI. Es la lógica y el significado de lo que el sistema administra.

## Entidades
Una entidad tiene identidad propia y vive en el tiempo.
Ejemplos:
- cliente
- orden
- pedido
- venta
- ticket

## Value Objects
Son objetos que importan por su valor, no por identidad.
Ejemplos:
- dinero
- rango de fechas
- dirección
- número de documento
- estado de un proceso

## Reglas del dominio
Son restricciones o comportamientos que hacen válido el negocio.
Ejemplos:
- no se entrega una orden sin pago completo
- una venta anulada no puede facturarse
- una garantía solo aplica bajo ciertas condiciones

## Qué conviene cuidar
- que las reglas importantes no queden regadas
- que los estados y transiciones tengan sentido
- que el dominio use nombres cercanos al negocio
- que no todo se reduzca a entidades JPA anémicas
