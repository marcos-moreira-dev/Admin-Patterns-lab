# Puertos y adaptadores

## Qué problema resuelven

Ayudan a que el núcleo del sistema no quede pegado a detalles externos.

## Puerto

Es una interfaz que expresa algo que el sistema necesita.

Ejemplos:
- guardar orden
- buscar cliente
- generar documento
- enviar notificación
- almacenar un archivo
- consumir una API externa

## Adaptador

Es la implementación concreta de ese puerto.

Ejemplos:
- repositorio JPA
- generador de PDF
- cliente de correo
- almacenamiento local o en nube
- cliente HTTP a un tercero

## Cuándo vale la pena

Conviene usarlos en fronteras externas o cambiantes, por ejemplo:
- persistencia principal cuando quieres aislarla con intención
- generación de documentos
- notificaciones
- integraciones externas
- almacenamiento de archivos
- pagos o servicios de terceros

## Cuándo no hace falta exagerar

No conviene crear un puerto y un adaptador:
- para cada helper interno
- para una clase que nunca cambió y no es frontera externa
- para una consulta simple que solo vive en tu backend
- para esconder una dependencia estable sin ganancia real

## Versión simple primero

Primero separa responsabilidades.
Luego identifica fronteras.
Solo después abstrae donde la variación, el riesgo o el costo de cambio lo justifican.

## Olores de sobreingeniería aquí

- interfaz con una única implementación que jamás cambia y no es frontera externa
- adaptador que solo reenvía llamadas sin agregar aislamiento real
- muchas clases para ejecutar una operación trivial
- repository encima de otra abstracción que ya resolvía el problema

## Beneficios reales

- pruebas más limpias en puntos importantes
- reemplazo más fácil de dependencias externas
- menos acoplamiento al framework o a terceros
- mejor separación de responsabilidades

## Regla práctica

No toda dependencia necesita una abstracción propia. Los puertos y adaptadores son una herramienta útil, pero deben aparecer donde haya frontera externa o variación real.
