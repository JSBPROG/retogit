# RETO 2 :computer: 

<p><strong>Repositorio</strong> creado para la asignatura de <em>entornos de desarrollo</em></p>

***************

## ENUNCIADO DEL EJERCICIO

### FICHEROS

<p>1- Vamos a escribir un <strong>bot automatizado</strong> para ciertos tipos de respuestas.

Este bot es un trigger ante la aparición de ciertas palabras en un texto, por ejemplo, siempre que el texto escrito por usuario contenga la subcadena "hola", el bot va a enviar el mensaje ¿Qué tal?.
Para esto:
	Crea una clase Fichero que contenga:
		-Atributos: nombre del chat, permisos de escritura y lectura (boolean), diseño (boolean).
		-Métodos: constructor, comprobar permisos, cambiar permisos, escribe, lee, diseña chat (para hacer una pequeña cabecera si interesa). 

	Crea una clase Bot que contenga lo necesario para que si se escribe: (hereda nombre de Fichero)
		Atributos:
		 Expresiones (constante y array multidimensional).
		
		"hola" (da igual si mayus o minus) responda algo a tu elección
		"adiós" (da igual si mayus o minus) responda algo a tu elección
		"no repitas" (da igual si mayus o minus) responda algo a tu elección
		"no eres real" (da igual si mayus o minus) responda algo a tu elección
		"Default" para que en caso de que no tenga coincidencias responda algo.
		 
		NombreIA (constante) para la entrada de texto. 
		
		Método: responde (tiene que saber cuándo responde el usuario para que sea automático y mostrar por consola la respuesta).
	Crea una clase Main donde pongas todo esto en funcionamiento. Todo lo que escriba el bot debe poder verse por consola junto con todo lo anterior y 
	todo debe ser escrito en el fichero a modo de chat.
</p>
