># ServiceManager

## Descripción del proyecto

Este proyecto tiene como finalidad notificar tickets en la plataforma Service Manager a través de un servicio web.

- Este servicio deberá ser consumido por un WS Puente creado en Remedy Control.
- Avisa a la plataforma Service Manager que una WO se abre o cierra dentro de la plataforma de Remedy.
- Las WO generadas son un incidente tipo alarma.

## Estado del proyecto

Este proyecto actualmente se encuentra en uso y está desplegado en los 2 ambientes (desarrollo y producción MX 151 y 152).

## Requerimientos

Se recomienda encarecidamente respetar estos puntos para poder usar la aplicación de forma correcta:

-   Tener instalado Java 1.8
-   Hacer deploy en un servidor Tomcat 7

## Ejecutar

Divido que el programa se ejecuta por factores externos no se puede ejecutar de manera local.

## Despliegue en el servidor

Para desplegar la aplicación, se requiere colocar el archivo `ServiceManager.war` en el servidor de aplicaciones, siguiendo estos pasos:

1.  Accede al servidor de aplicaciones.
2.  Navega hasta la ubicación `/webapps8` del servidor.
3.  En la anterior ruta mencionada, coloca el arhcivo `ServiceManager.war`, ubicado en la ruta `/ServiceManager/dist/ServiceManager.war` del proyecto ya ejecutado.
4.  Una vez que hayas colocado el archivo en el servidor, el servidor de aplicaciones automáticamente desplegará el proyecto. Esto resultará en la creación de un directorio dedicado al proyecto en la siguiente ubicación: `/webapps8/ServiceManager`.
