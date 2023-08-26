# Se elimina la configuración donde descarga el webdriver automaticamente.

Se debe descarga la versión del driver del chrome de la maquina donde se ejecutara la automatización.
En caso de reactivar la descarga automatica se debe cambiar el estado de la siguiente propiedad en el archivo serenity.conf

+ webdriver.autodownload = false

Se recomienda ejecutar la automatización preferiblemente en intellig.

## Se debe descargar las dependencias

Se debe ejecutar Gradle para que descarge las dependencias

##
Se debe ejecutar el runner ModuloBookRooner O en caso de que tenga gradle y java configurado, ejecutar el siguinte comando 
+ gradle clean test