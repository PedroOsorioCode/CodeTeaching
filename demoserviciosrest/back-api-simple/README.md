# Api Rest Básico

> Proyecto de API REST para un sistema de domótica, diseñado para extraer y gestionar información de un hogar, incluyendo sus habitaciones y dispositivos conectados. Los datos se exponen en formato JSON, facilitando la visualización del estado de los dispositivos. Además, el proyecto incluye una página web interactiva que muestra estos datos, renderizando el estado de las luces, indicando si están encendidas o apagadas según corresponda en cada habitación. Incluye una guía de como generar imagen docker y desplegarla en AWS Elastic Container Service.

## Características

- Api rest con springboot
- Openapi: swagger
- Frontend: Javascript + html + ajax
- Conexión BD mysql o H2
- Generador de imagen docker
- Instalación contenedor docker
- Despliegue ECS + Fargate + Load balancer

# Documentación

1. **Recurso guía creación bd mysql**
 - [Url Guía crear bd en aws](https://aws.amazon.com/es/getting-started/hands-on/create-mysql-db/?ref=gsrchandson)

2. **Scripts bd**
 - [ver scripts](doc/scripts-bd.sql)

3. **Desplegar en docker local y ECS AWS**
 - [Readme configuracion docker](README-DOCKER-AWS.md) 

4. **Capturas de pantalla**
 - [Ver capturas](README-IMG.md)
---

**Author**: Pedro Luis Osorio Pavas [Linkedin](www.linkedin.com/in/pedro-luis-osorio-pavas-68b3a7106)
**Start Date**: 01-10-2024 **Update Date**: 22-10-2024.

