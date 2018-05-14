INSTRUCCIONES: Para ejecutar la aplicación

1. La base de datos fue creada con ProstgreSQL 10
2. Una vez instalado el motos de base de datos cree una base de datos con el nombre de su preferencia
3. modifique el archivo store.properties ubicado en {PATH_PROJECT}/src/main/resouces/store.properties

jdbc.user=postgres
jdbc.password=
dataSource.database=
dataSource.server=
dataSource.port=5432

4. Una vez tenga la base de datos ejecute el scrip ubicado en {PATH_PROJECT}/src/main/resouces/database
Si se genera algun error, verifique el orden de ejecución del script.

5. Instale el componente Lombok segun el IDE donde haya importado el proyecto, siga las instrucciones de la pagina https://projectlombok.org/

6. Para poblar la base de datos los puede hacer con los edpoint expuestos para cliente, tienda, producto, la tabla inventario debe ser poblada
directamente en la base de datos para poder ejecutar una orden de compra.

7. Para ejecutar la aplicacion se debe hacer desde la clase RestStoreApplication, desde el IDE se puede ejecutar como una aplicación Java.

8. La consulta para cliente, tienda y producto no se maneja ningun filtro los endpoint consultan todos los registros de la DB

9. Se adjunta una colleccion de postman para ejecutar cad uno de las funcionalidades solicitadas

Si no cuenta con posrtaman:

----- Cliente

- Consulta: tipo GET = http://localhost:8080/client
- Delete: tipo GET = http://localhost:8080/client/delete/{ID}
- Create: tipo POST = http://localhost:8080/client/create
{
	"clientName": "John JQ",
	"document": "123",
	"age": "31",
	"email": "j@j.com",
	"clientUser": "jota",
	"password": "123"
}

----- Producto

- Consulta: tipo GET = http://localhost:8080/product
- Delete: tipo GET = http://localhost:8080/product/delete/{ID}
- Create: tipo POST = http://localhost:8080/product/create
{
	"productName": "Un Producto",
	"barcode": "123",
	"cost": "3500",
	"description": "La descripción"
}

----- Tienda

- Consulta: tipo GET = http://localhost:8080/shop
- Delte: tipo GET = http://localhost:8080/shop/delete/{ID}
- CReate: tipo POST = http://localhost:8080/shop/create
{
	"shopName": "Shop JJ",
	"address": "cll 123 N 10 -2",
	"schedule": "L-V"
}

----- Login

- CReate: tipo POST = http://localhost:8080/login
{
	"user": "jota",
	"password": "123"
}

----- Compra

- CReate: tipo POST = http://localhost:8080/buy
{
	"user": "jota",
	"password": "123",
	"shopId": 4,
	"product": {
		"123": 3
	}
}

