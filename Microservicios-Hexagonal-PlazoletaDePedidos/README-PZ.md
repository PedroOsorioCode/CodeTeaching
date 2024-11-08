# Arquitectura Hexagonal - Microservicios - Springboot

> Proyecto para la creación de restaurantes, pedidos

### El proyecto incluye:

- 4 microservicios
- Aplicación de arquitectura Hexagonal
- Springboot
- Spring security
- Interconexión entre microservicios
- Test unitarios automatizados
- Aplicación Web con Angular

## Instrucciones

1. **Crear las bases de datos locales con docker**
   ```
    docker run --name mysql-db-usuario -e MYSQL_ROOT_PASSWORD=micro132*  -e MYSQL_DATABASE=usuarios  -e MYSQL_PASSWORD=micro132*  -p 3310:3306 -d mysql:latest
    ```
    ```
    docker run --name mysql-db-plazoleta -e MYSQL_ROOT_PASSWORD=micro132*  -e MYSQL_DATABASE=plazoleta  -e MYSQL_PASSWORD=micro132* -p 3311:3306  -d mysql:latest
    ```
2. **Conectar con dbeaver**  
   MySQL: 
   ```
   URL: jdbc:mysql://localhost:3310/[database name]
   User: root
   Pass: [El indicado en docker]
   ```
   Si genera error "Public Key Retrieval is not allowed", entonces en Driver Settings colocar o agregar allowPublicKeyRetrieval en true

3. **Scripts base de datos**  
   ```
   CREATE DATABASE IF NOT EXISTS usuarios;

	CREATE TABLE roles (
		id BIGINT AUTO_INCREMENT PRIMARY KEY,
		nombre VARCHAR(100) NOT NULL,
		descripcion VARCHAR(255)
	);

	CREATE TABLE usuarios (
		id BIGINT AUTO_INCREMENT PRIMARY KEY,
		nombre VARCHAR(100) NOT NULL,
		apellido VARCHAR(100) NOT NULL,
		numero_documento VARCHAR(50) NOT NULL UNIQUE,
		celular VARCHAR(20),
		fecha_nacimiento DATE,
		correo VARCHAR(100) NOT NULL UNIQUE,
		clave VARCHAR(255) NOT NULL, -- Para almacenar la clave encriptada
		id_rol BIGINT,
		FOREIGN KEY (id_rol) REFERENCES roles(id) ON DELETE SET NULL
	);
   ```

   ```
   CREATE DATABASE IF NOT EXISTS plazoleta;


   ```


4. **Microservicio de tecnología**  
   [Ir al repositorio](https://github.com/PedroOsorioCode/hexagonal-webflux-tecnologia)

5. **Microservicio de capacidades**  
   [Ir al repositorio](https://github.com/PedroOsorioCode/hexagonal-webflux-capacidad)

6. **Microservicio de bootcamps**  
   [Ir al repositorio](https://github.com/PedroOsorioCode/hexagonal-webflux-bootcamp)  

7. **Aplicación Angular para consumo de microservicios**  
   [Ir al repositorio](https://github.com/PedroOsorioCode/hexagonal-webflux-angular-frontend)

8. **Swagger**  
[Tecnología](http://localhost:8080/swagger-ui/webjars/swagger-ui/index.html#/)  
[Capacidades](http://localhost:8081/swagger-ui/webjars/swagger-ui/index.html#/)  
[Bootcamp](http://localhost:8082/swagger-ui/webjars/swagger-ui/index.html#/)

9. **Resultado**
 - ![](doc/1_web_tecnologias.png)
 - ![](doc/2_web_capacidades.png)
 - ![](doc/3_web_bootcamp.png)  

**Arquetipo Arquitectura Hexagonal**

 - ![](doc/4_arquietipo_arquitectura_puertos_adaptadores.png)

**Configuración Run Proyectos**

 - ![](doc/5_configuracion_run_proyectos.png)

### Recursos adicionales
- [Guía configurar Swagger Webflux](https://medium.com/@kamomillte/tutorial-adding-swagger-ui-to-a-spring-webflux-application-3ff7aebb63b8)
- [Teoría Spring Webflux](https://www.youtube.com/watch?v=NMDL8fkZT0U)
- [Metodos Spring Webflux](https://www.youtube.com/playlist?list=PLvimn1Ins-41pwh18gh_ZkxPOkrEEhXz6)
- [Colección Postman](Reto%20Hexagonal%20-%20Webflux%20-%20Mysql.postman_collection.json)
---

**Author**: Pedro Luis Osorio Pavas [Linkedin](www.linkedin.com/in/pedro-luis-osorio-pavas-68b3a7106)  
**Start Date**: 01-11-2024

