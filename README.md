# Spring-Sessions-Round-3

## Session#1

- What means Web Application.
- Web server Vs Application server.
- WAR Vs JAR.
- Bootstrapping spring application.
- Inversion Of Control.
- Dependency Injection Using:
	- 1- Java based configurations.
	- 2- Annotations.

**Annotations:**  ``@Component``, ``@ComponentScan``, ``@Configuration``, ``@Bean``, ``@Autowired``
  
**Installations:**
- [java](https://www.codejava.net/java-se/download-and-install-java-11-openjdk-and-oracle-jdk)
- [Maven](https://phoenixnap.com/kb/install-maven-windows)
- [Building an Application with Spring Boot](https://spring.io/guides/gs/spring-boot)

**Links**
- [Web Server Concepts](https://www.youtube.com/watch?v=9J1nJOivdyw)
- [How a web application works](https://www.youtube.com/watch?v=zjfViRCjT5U)
- [Web server vs. Application server](https://www.educative.io/answers/web-server-vs-application-server),
- [Web server Vs Application server ](https://youtu.be/-XoXOp7Ihyc?list=PL0pSb9Km2KjLs6GA1KS20N2QEFpwFJEap&t=853)>> last 5  minutes in video
- [Dependency Injection](https://www.youtube.com/watch?v=eQ90v7HQT-Q)
- [What is difference between @Component and @Bean annotation in Spring?](https://medium.com/javarevisited/what-is-difference-between-component-and-bean-annotation-in-spring-bffdad0ab899)

**Refrences:**
- https://www.baeldung.com/java-jar-war-packaging
- https://docs.spring.io/spring-framework/docs/5.0.0.M1/spring-framework-reference/pdf/spring-framework-reference.pdf
- https://www.tutorialspoint.com/spring/index.htm
- https://www.javatpoint.com/spring-tutorial
- https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#legal

**If you just want to know how to code check this:**
- https://www.youtube.com/@amigoscode/playlists

**If you need to understand the behind reson of basics check those channels:**
  - https://www.youtube.com/@laurspilca/playlists
  - https://www.youtube.com/@SeleniumExpress/playlists
  - https://www.youtube.com/@Java.Brains/playlists?view=50&sort=dd&shelf_id=7

**mix between knowledge and practice**
  - [The ULTIMATE Guide to Spring Boot: Spring Boot for Beginners](https://www.youtube.com/watch?v=Nv2DERaMx-4&t=2985s)

**Task:**
- What is the web service?
- Comparison between REST & SOAP.
- Search for Bean Scopes.
- Search for how to resolve the issue of dependency injection for multiple interface implementations using @Autowired.

___

## Session#2

- web service (Rest & Soap) >> Rest Methods
- Maven (generate runnable jar / generate documentation)

**Annotations:** ``@Primary``, ``@Qualifier``

[Maven Tutorial](https://youtu.be/Xatr8AZLOsE)
[Maven Complete Tutorial](https://youtu.be/JhSBS2OpGdU)

[Maven Repository](https://mvnrepository.com/)

___

## Session#3

- Consume Rest APIs (signIn)
- Postman

**Annotations:** ``@Controller``, ``@ResponseBody``, ``@RestController``, ``@RequestMethod``, ``@PathVariable``, ``@RequestParam``, ``@GetMapping``, ``@PostMapping``, ``@RequestHeader``

**Task**
- What is the Bean life cycle?
- search for @RequestHeader

[Relational Database](https://youtube.com/playlist?list=PLE8kQVoC67PzGwMMsSk3C8MvfAqcYjusF&si=YpNs8W6qoSPlzjrd)

___

## Session#4

- override system properties
- Connect to database using Jdbc & JdbcTemplate
- ORM
- Intro to JPA & Hibernate
- Table generation

**Refrence:** 
[DatabaseConnection](https://docs.oracle.com/cd/E19509-01/820-3497/agqka/index.html)
[Spring Data JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query.other-methods)


  **Annotations:** ``@Entity``, ``@Table``, `` @Id``, ``@Column``
  
- [Entity Relationship Diagram](https://youtu.be/CZ46r29kyQw)

___

## Session#5
- ID generation strategies
- Column constraints
- Transient columns
- Implement custom CRUD operations Repository
- Migrate to JPA repository
- Response Entity

**Refrences:**
- [Response Entity](https://www.baeldung.com/spring-response-entity)
- [Difference Between @Size, @Length, and @Column(length=value)](https://www.baeldung.com/jpa-size-length-column-differences)

**Annotations:** ``@GeneratedValue``, ``@SequenceGenerator``, 
 ``@TableGenerator``, ``@Pattern``, ``@Tranisnt``, ``@Repository``, ``@Query``

  ____
  
## Session#6

- JPA Relations (Uni & Bidirectional mapping)
- JPA cascading operations
- Hibernate entity Lifecycle

**Refrences:**
- [Entity Relationship Diagram](https://youtu.be/CZ46r29kyQw)
- [Hibernate/JPA One-to-Many Mappings](https://howtodoinjava.com/hibernate/hibernate-one-to-many-mapping/)
- [Jackson – Bidirectional Relationships](https://www.baeldung.com/jackson-bidirectional-relationships-and-infinite-recursion)
- [JPA Cascading Operations](https://www.javatpoint.com/jpa-cascading-operations)
- [Hibernate Entity LifeCycle](https://howtodoinjava.com/hibernate/hibernate-entity-persistence-lifecycle-states/)
  
**Annotations:** ``@Lob``, ``@OneToMany``, ``@ManyToOne``, ``@JoinColumn``, ``@JsonManagedReference``, ``@JsonBackReference``, ``@JsonIgnore``
