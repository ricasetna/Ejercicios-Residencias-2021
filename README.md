Ejercicios-Residencias-2021
App demo para solicitud de residencias en Punto Singular

Dentro del codigo estan los archivos necesarios para la ejecucion de los archivos, decidi hacerlo en forma de app de android porque usa lenguaje java y aparte es mas amigable para mi tener una interfaz visual que simplemente hacerlo en una consola.

La app se separa en 3 activities encargado cada uno de cada ejercicio planteado, puede acceder a ellas a traves de los 3 puntos en la esquina superior derecha, todo se ejecuta en tiempo real por lo que inmediatamente cuando comience a escribir en la caja de texto comenzará a ver los resultados de la traduccion o calculos necesarios.

<p align="center">
  <img src="Capturas%20de%20Pantalla/TraductorMorse.jpg" width="200" title="Traductor Morse">
  <img src="Capturas%20de%20Pantalla/Numeros%20Romanos.jpg" width="200" title="Numeros Romanos">
  <img src="Capturas%20de%20Pantalla/CalculadorObjetos.jpg" width="200" title="Calculador Objetos">
</p>

En el caso del traductor morse, para invertir la direccion de traduccion de español-morse a morse-español dispone de un boton que permite hacerlo de manera sencilla y conservando el texto traducido que tenia del otro lado, estilo google traductor.

<p align="center">
  <img src="Capturas%20de%20Pantalla/Espa-Morse.jpg" width="200" title="Español a Morse">
  <img src="Capturas%20de%20Pantalla/Morse-Espa.jpg" width="200" title="Morse a Español">
</p>

En el caso del traductor de numeros romanos solo acepta numeros enteros de 0 a 1000 y considera los errores de entrada posibles, tambien realiza el calculo en tiempo real por lo que no necesita botones de confirmacion.

<p align="center">
  <img src="Capturas%20de%20Pantalla/Romanos1.jpg" width="200" title="Romanos 1">
  <img src="Capturas%20de%20Pantalla/Romanos2.jpg" width="200" title="Romanos 2">
  <img src="Capturas%20de%20Pantalla/Romanos3.jpg" width="200" title="Romanos 3">
  <img src="Capturas%20de%20Pantalla/Romanos4.jpg" width="200" title="Romanos 4">
</p>

Por ultimo para el calculador de areas se crearon las dos clases especificas requeridas y se aplicó el concepto de herencia en la subclase, tanto para los constructores como para el metodo CalcularPerimetro, que aparecia como requisito en la clase y subclase, por lo que en la subclase lo sobreescribi con el tag "@Override" y utilicé el modificador "protected" en la super clase para que las subs pudieran acceder de forma segura a la variable "Lado". Tambien consideré los casos de error mas comunes a la hora de intentar calcular y cree excepciones acorde a para dispararlas en el momento en que se generen.

<p align="center">
  <img src="Capturas%20de%20Pantalla/Objetos1.jpg" width="200" title="Objetos 1">
  <img src="Capturas%20de%20Pantalla/Objetos2.jpg" width="200" title="Objetos 2">
</p>

Adjunto unas imagenes de evidencia y el APK compilado para que disponga de el.
