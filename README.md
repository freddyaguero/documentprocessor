Prerequisitos en Windows 11:
--------------
Tener instalado el siguiente software:
A) Java Development Kit (JDK) versión 8 o 11
    Para instalar el JDK (Java Development Kit) en Windows 11, debes descargar el instalador desde el sitio web de Oracle, ejecutarlo como administrador, y luego configurar las variables de entorno. 
Aquí tienes los pasos detallados:
1. Descargar el JDK:
Accede a la página de descargas de Java SE en Oracle. 

https://www.oracle.com/cl/java/technologies/javase/jdk11-archive-downloads.html

Busca la versión del JDK que deseas instalar (por ejemplo, JDK 17 o JDK 21) y acepta el acuerdo de licencia. 
Descarga el instalador (.exe) para Windows. 
2. Ejecutar el instalador:
Localiza el archivo descargado y haz doble clic para iniciar el proceso de instalación. 
Acepta los términos de la licencia y continúa con la instalación. 
Elige la ubicación de instalación o acepta la predeterminada. 
Espera a que finalice la instalación. 
3. Configurar las variables de entorno:
Busca "variables de entorno" en la barra de búsqueda de Windows y selecciona "Editar las variables de entorno del sistema". 
Haz clic en "Variables de entorno". 
En la sección "Variables del sistema", busca la variable "Path" y selecciónala. 
Haz clic en "Editar". 
Añade una nueva entrada con la ruta de instalación del JDK, generalmente algo como: C:\Program Files\Java\jdk-21\bin (ajusta el número de versión según tu instalación). 
Crea una nueva variable de sistema llamada JAVA_HOME y asigna la ruta de instalación del JDK sin el \bin (ej: C:\Program Files\Java\jdk-21). 
Haz clic en "Aceptar" en todas las ventanas para guardar los cambios. 
4. Verificar la instalación:
Abre una nueva ventana de símbolo del sistema (cmd). 
Escribe java -version y presiona Enter. 
Debería mostrar la versión del JDK instalada. 


B) Maven
Para instalar Maven en Windows 11, se deben descargar los binarios, extraerlos, configurar las variables de entorno y verificar la instalación. Primero, descarga el archivo ZIP de Maven desde la página oficial. Luego, descomprime el archivo en una ubicación deseada, por ejemplo, en C:\apache-maven-[versión]. Después, configura las variables de entorno: crea una variable llamada MAVEN_HOME apuntando a la ruta de instalación de Maven y agrega la ruta de los binarios de Maven al PATH. Finalmente, abre una nueva terminal y verifica la instalación ejecutando mvn -version. 
Aquí están los pasos detallados:

1. Descargar Maven:
Visita la página de descarga de Apache Maven. 
https://maven.apache.org/download.cgi

Descarga el archivo ZIP de la última versión. 

2. Extraer Maven:
Descomprime el archivo ZIP en una ubicación de tu preferencia, por ejemplo, C:\apache-maven-[versión]. 
3. Configurar variables de entorno:
En windows11 barra inferior BUSQUEDA: Editar variable de entorno. Click en variables de entorno.
Click en Nueva variable de sistema.
MAVEN_HOME con la ruta de donde está instalada la version de maven instalada.
Ejemplo: C:\Desarrollo\apache-maven-3.9.11-bin.zip\apache-maven-3.9.11
MAVEN_HOME: Crea una nueva variable de entorno llamada MAVEN_HOME y asígnale la ruta donde descomprimiste Maven (ej. C:\apache-maven-[versión]). 
PATH: Edita la variable de entorno PATH y agrega (opción nueva)la ruta %MAVEN_HOME%\bin. 

4. Verificar la instalación:
Abre una nueva ventana de la terminal (cmd o PowerShell). 
Ejecuta el comando mvn -version. 
Debe mostra la versión de maven instalada.


C) Git
    Descargar el instalable de git he instalar en windows:
    https://gitforwindows.org/
    Verifica  en una ventana de comando de windows con:
    git --version

    Debiera mostrar la versión de git instalada.

Nota:Este proyecto fue desarrollado con Visual Studio Code.


Clonar el proyecto desde el repositorio GITHUB
----------------------------------------------
En una ventana de comandos.
1. Crear una carpeta donde se desea clonar el proyecto, por ejemplo proyecto:
   mkdir proyecto
2. Entrar a la carpeta:
   cd proyecto
3. Clonar proyecto con el comando:
    git clone https://github.com/freddyaguero/documentprocessor.git
4. Entrar a la carpeta del proyecto clonado:
   cd documentprocessor
5. Verificar que estén todos los archivos del proyecto
   dir


Generar ejecutable y Ejecutar Proyecto documentprocessor
-----------------------------------
1. Siguendo los pasos de la ventana de comandos anterior se construye el proyecto con maven y genera jar a ejecutar con:
   mvn clean install

2. Ejecutar la aplicación que utiliza el archivo lote.ejemplo.json de entrada ubicado en la carpeta actual del proyecto descargado con:
   java -jar target/documentprocessor-1.0-SNAPSHOT.jar

3. Verificar los archivos de salida en la carpeta output:
 cd output
 dir

4. Abrir con un editor el archivo:
lote.xml

5. Abrir con un navegador como chrome el archivo:
reporte.html

   

   

