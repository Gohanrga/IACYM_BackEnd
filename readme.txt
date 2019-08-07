----------------------------------------------
----------------------------------------------
REQUISITOS
----------------------------------------------
1.- TENER INSTALADO jdk desde la version 7
2.- Maven para bajar las dependencias
3.- Preferentemente tener instalado STS, eclipse optimizado por la gente de Spring para un mejor manejo
    (cualquier otro editor deberia de funcionar igual correctamente, ojo que puede tener otro tipo de consideraciones)
4.- Tener instalado postman
----------------------------------------------
INSTALACION
----------------------------------------------
1.- COPIAR EN EL WORSPACE DE STS
2.- ABRIR EL PROYECTO CON EL EXPLORADOR DE PAQUETES Y UBICAR EL ARCHIVO POM.XML
3.- CLIC DERECHO, IR A RUN AS/MAVEN INSTALL, ESTE DEBERA BAJAR TODAS LAS DEPENDENCIAS QUE ESTAN CONFIGURADAS EN EL MAVEN
----------------------------------------------
EJECUCION
----------------------------------------------
1.- HACER CLIC DERECHO EN EL DIRECTORIO RAIZ IR A RUN AS/SPRING BOOT APP
    (Spring tiene un servidor tomcat incorporado por lo que no hay que configurar nada)
2.- La Url para la prueba es "localhost:8080/api/getUsuario/1"
3.-Si se quiere cambiar el puerto configurarlo en el application.properties
