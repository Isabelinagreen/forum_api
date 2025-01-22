# Foro API REST con Spring Boot

Este proyecto consiste en el desarrollo de una API REST para un sistema de foros utilizando Spring Boot. La API permite gestionar temas (topics) creados por usuarios, relacionándolos con cursos y facilitando la interacción entre los usuarios del sistema. La aplicación utiliza una base de datos MySQL para almacenar la información.

## Tecnologías Utilizadas

- **Java**: Lenguaje principal del proyecto.
- **Spring Boot**: Framework para el desarrollo rápido de aplicaciones Java.
- **Spring Data JPA**: Acceso y manipulación de datos con JPA.
- **MySQL**: Base de datos relacional.
- **Hibernate**: Implementación de JPA utilizada en el proyecto.
- **Lombok**: Reducción de boilerplate en el código.
- **Spring Security**: Manejo de la seguridad de la aplicación.
- **HikariCP**: Gestión de conexiones a la base de datos.

## Funcionalidades

La API ofrece las siguientes funcionalidades:

1. **Crear Tema**: Permite a los usuarios crear un nuevo tema en el foro.
2. **Listar Temas**: Recupera una lista de temas registrados en la base de datos.
3. **Actualizar Tema**: Actualiza la información de un tema existente.
4. **Eliminar Tema**: Elimina un tema de la base de datos.
5. **Consultar Tema por ID**: Recupera un tema específico a partir de su identificador.

## Requisitos

Antes de ejecutar la aplicación, asegúrate de tener los siguientes requisitos instalados:

- Java 17 o superior.
- Maven.
- MySQL.

## Configuración Inicial

1. Clona el repositorio en tu máquina local:

   ```bash
   git clone <URL_DEL_REPOSITORIO>
   cd <NOMBRE_DEL_PROYECTO>
   ```

2. Configura la base de datos en el archivo `application.properties` o `application.yml`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/nombre_de_base_de_datos
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
   ```

3. Asegúrate de que la base de datos MySQL esté en ejecución y que la tabla requerida (topic) esté correctamente creada. El esquema se puede generar automáticamente utilizando `spring.jpa.hibernate.ddl-auto=update` o de forma manual.

## Ejecución

1. Compila y ejecuta la aplicación:

   ```bash
   mvn spring-boot:run
   ```

2. La API estará disponible en `http://localhost:8080`.

## Endpoints Principales

| Método | Endpoint          | Descripción                     |
|--------|-------------------|---------------------------------|
| POST   | `/api/topics`     | Crear un nuevo tema.            |
| GET    | `/api/topics`     | Listar todos los temas.         |
| GET    | `/api/topics/{id}`| Consultar un tema por su ID.    |
| PUT    | `/api/topics/{id}`| Actualizar un tema existente.   |
| DELETE | `/api/topics/{id}`| Eliminar un tema por su ID.     |

## Solución de Problemas Comunes

### Error 500: `Unknown column 'id_usuario' in 'field list'`

Este error ocurre cuando hay un desajuste entre el modelo de datos de la aplicación y la base de datos. Asegúrate de:

1. Verificar que la columna `id_usuario` esté creada en la tabla `topic` en la base de datos.
2. Si estás utilizando `ddl-auto=update`, revisa el modelo de la entidad `Topic` para garantizar que todas las columnas requeridas estén definidas correctamente.

Ejemplo de una entidad correctamente configurada:

```java
@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;

    @ManyToOne
    private Usuario autor;

    @ManyToOne
    private Curso curso;

    @Enumerated(EnumType.STRING)
    private StatusTopico status;

    // Getters y setters
}
```

## Contribuciones

Si deseas contribuir a este proyecto, por favor:

1. Crea un fork del repositorio.
2. Realiza tus cambios en una rama nueva.
3. Envía un pull request explicando los cambios realizados.

## Licencia

Este proyecto está bajo la licencia MIT. Consulta el archivo `LICENSE` para más información.

