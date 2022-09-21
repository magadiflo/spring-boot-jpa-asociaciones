# Asociaciones con JPA

## ManyToMany Bidireccional
Tomado del canal de [JavaTechie](https://www.youtube.com/watch?v=jCYonZey5dY)

## Solución al Bucle infinito 
Cuando tenemos relaciones de Muchos a Muchos Bidireccional ocurre 
que **si se exponen directamente las entities involucradas como parte de la salida en el endpoint**, ocurriría
un bucle infinito generando un Stack Overflow. Para solucionarlo se
aplicaron dos formas:

### FORMA 1: Usando @JsonBackReference (branch main)
En el entity Course, se agregó la notación @JsonBackReference:
```
@ManyToMany(mappedBy = "courses")
@JsonBackReference //Para evitar el bucle infinito cuando se retorna por el endPoint (por ejemplo /students) a los students
private Set<Student> students;
```
Como indica el comentario, es para evitar el bucle infinito al ser la
entity Student expuesta por el endPoint, ya que se tratará de 
convertir un Student en un objeto JSON, pero la entity Student
tiene una lista de Courses, que también se tratarán de convertir
en un objeto JSON, y al mismo tiempo dicha lista de Courses tienen
una lista de Students, generándose de esta manera un bucle infinito, 
cuando se esté convirtiendo a un objeto JSON, ya que recordemos, existe
una relación **BIDIRECCIONAL** entre Student y Course

### FORMA 2: Usando DTOs (branch using-dto)
Aquí ya no usamos la anotación @JsonBackReference, sino, por el contrario,
creamos dos Clases DTO (StudentDTO, CourseDTO), esto con la finalidad
de que mapeemos cada entity a su correspondiente DTO (ver la branch using-dto).
De esta forma no se estará exponiendo directamente la entity por 
el endPoint sino el DTO (esto es una buena práctica) y precisamente lo que se convertirá en objeto JSON
serán los DTOs y no las Entities

```
**NOTA:** Si queremos usar la relación de muchos a muchos BIDIRECCIONAL entre esas entidades, pero de manera
interna, es decir, sin exponerlas por el END POINT, no será necesario usar las DTO, sino se podría
usar directamente el resultado que se traiga de la BD. Por ejemplo:

Si se usará el siguiente código dentro de las clases del proyecto no habría problemas:
    User user = this.studentRepository.findById(studentId);
    
Ahora, si por ejemplo se hace lo siguiente:
    @GetMapping(path = "/{studentId}")
    public Student getStudent(@PathVariable Long studentId) {
        Student student = this.studentRepository.findById(studentId);
        return student;
    }
Podemos observar que se está exponiendo directamente la Entity Student por el End Point, eso
causará el bucle infinito, ya que el Student tiene una lista de cursos, y cada curso de esa lista
tiene asociado un Student, y al momento de hacer la conversión a JSON se generará ese bucle infinito
```
## [Entity Relationship In JPA/Hibernate/ORM](https://javatechonline.com/entity-relationship-in-jpa-hibernate-orm/?fbclid=IwAR1sBdyyECpkdFe1eulDOHdNY6DojVKgSwpJuh2qfjyUpxEJdYsfAKKL5ks)
Información sobre relaciones con jpa/hibernate 