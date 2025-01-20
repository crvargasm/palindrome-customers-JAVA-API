# API Proyecto SpringBoot

Este proyecto es una API REST desarrollada con SpringBoot que contiene dos funcionalidades principales:

* Analizador de Palíndromos: Determina si una palabra es un palíndromo.
* CRUD de Customers: Permite gestionar un conjunto de clientes mediante operaciones CRUD.

## Tecnologías Utilizadas

* Java
* SpringBoot
* Maven

## Requisitos

* Java 17 o superior

* Maven 3.8+

## Acceder a la API:

URL Base: ```http://localhost:8080```

## Funcionalidades

### 1. Analizador de Palíndromos

Determina si una palabra es un palíndromo (una palabra que se lee igual de adelante hacia atrás y viceversa).

Endpoint:

```GET /palindrome/{word}```

Parámetros:
```
{word}: Palabra que se desea analizar.
```
Ejemplo de Uso:
```
GET http://localhost:8080/palindrome/radar
```
Respuesta:

Si es un palíndromo:
```
"La palabra " + word + " es palíndroma 🤗"
```
Si no es un palíndromo:

```
"La palabra " + word + " no es palíndroma 🙁"
```

### 2. CRUD de Customers

Gestiona un conjunto de clientes con operaciones de Crear, Leer, Actualizar y Eliminar (CRUD).

Endpoints Disponibles

Crear un nuevo cliente:
```POST /customers```

Body (JSON):
```json
{
	"id": 567,
	"name": "Roberto López",
	"username": "robertol",
	"password": "roberto123"
}
```
Respuesta (201 Created):
```json
{
	"id": 567,
	"name": "Roberto López",
	"username": "robertol",
	"password": "roberto123"
}
```

Obtener todos los clientes:
```GET /customers```

Respuesta (200 OK):
```json
[
	{
		"id": 123,
		"name": "Gerardo López",
		"username": "gerardol",
		"password": "1234"
	},
	{
		"id": 456,
		"name": "Alejandra García",
		"username": "alejandrag",
		"password": "4321"
	}
]
```
Obtener un cliente por Username:
```GET /customers/{username}```

Parámetros:
```
{username}: Username del cliente.
```
Respuesta (200 OK):
```json
{
	"id": 123,
	"name": "Gerardo López",
	"username": "gerardol",
	"password": "1234"
}
```
Actualizar un cliente existente:
```PUT /customers```

Body (JSON):
```json
{
	"id": 567,
	"name": "Roberto López",
	"username": "robertol",
	"password": "roberto1234"
}
```
Respuesta (200 OK):
```json
{
	"id": 567,
	"name": "Roberto López",
	"username": "robertol",
	"password": "roberto1234"
}
```
Actualizar parcialmente un cliente:
```PATCH /customers/```

Body (JSON):
```json
{
	"id": 567,
	"password": "robert2o12345"
}
```
Respuesta (200 OK):
```json
{
	"id": 567,
	"name": "Roberto López",
	"username": "robertol",
	"password": "robert2o12345"
}
```
Eliminar un cliente:
```DELETE /customers/{id}```

Parámetros:
```
{id}: ID del cliente.
```
Respuesta (200 OK):
```json
{
	"id": 567,
	"name": "Roberto López",
	"username": "robertol",
	"password": "roberto123"
}
```
## Notas Adicionales

Se recomienda realizar pruebas utilizando herramientas como [Postman](https://www.postman.com), [Insomnia](https://insomnia.rest/download), o [cURL](https://curl.se).

## Autor

Este proyecto fue desarrollado por [wolfghost23](https://github.com/crvargasm/).
