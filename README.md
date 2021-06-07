Ejercicios-Residencias-2021
App demo para solicitud de residencias en Punto Singular

Dentro del codigo estan los archivos necesarios para la ejecucion de los archivos, decidi hacerlo en forma de app de android porque usa lenguaje java y aparte es mas amigable para mi tener una interfaz visual que simplemente hacerlo en una consola.

La app se separa en 3 activities encargado cada uno de cada ejercicio planteado, todo se ejecuta en tiempo real por lo que inmediatamente cuando comience a escribir en la caja de texto comenzará a ver los resultados de la traduccion o calculos necesarios.

En el caso del traductor morse, para invertir la direccion de traduccion de español-morse a morse-español dispone de un boton que permite hacerlo de manera sencilla y conservando el texto traducido que tenia del otro lado, estilo google traductor.

En el caso del traductor de numeros romanos solo acepta numeros enteros de 0 a 1000 y considera los errores de entrada posibles, tambien realiza el calculo en tiempo real por lo que no necesita botones de confirmacion.

Por ultimo para el calculador de areas se crearon las dos clases especificas requeridas y se aplicó el concepto de herencia en la subclase, tanto para los constructores como para el metodo CalcularPerimetro, que aparecia como requisito en la clase y subclase, por lo que en la subclase lo sobreescribi con el tag "@Override" y utilicé el modificador "protected" en la super clase para que las subs pudieran acceder de forma segura a la variable "Lado". Tambien consideré los casos de error mas comunes a la hora de intentar calcular y cree excepciones acorde a para dispararlas en el momento en que se generen.

Adjunto unas imagenes de evidencia y el APK compilado para que disponga de el.
