# alert-mannager

Nuestro sistema se encarga de recibir un objeto JSON que representa a una atención médica y en base a esa entrada, generar una salida con alertas dependiendo de la lógica.

Ese JSON se genera partiendo de un texto codificado bajo el estandar de traspaso de información médica mundial HL7.


## Tareas
Al momento de tomar un ticket lo primero que se analiza es si es crear una nueva regla o actualizarla.

## Cosas a tener en cuenta antes de modificar/crear una regla

### Cuenta de testeo
Por lo general los tickets son provistos de una cuenta de test, estas pueden estar indicadas por su código BHT03 o por su PRS UUID.

Si solo tenemos BHT03: Para obtener un JSON el cual podamos usar para testear si nuestros cambios estan de a cuerdo a lo pedido, utilizamos un sitio el cual consiste en un formulario en donde ponemos el BHT03 y nos recupera la información de esa accion médica y junto con ello un PRS UUID, el cual nos va a servir para recuperar el JSON de la base de datos.

Paginas para obtener el PRS UUID en base al BHT03:

1. PRS Multitool v1
(se puede obtener el PRS UUID a traves de un GET)

2. PRS Multitool v2

3. Sherpa
 
## Crear una regla
