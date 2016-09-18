# Service Discovery Client using Ribbon #

## Quick summary ##

This sample application implements a service discovery client using Netflix open source [Ribbon](https://github.com/Netflix/ribbon) project.

It's a Spring based application. It uses [Spring Boot](http://projects.spring.io/spring-boot/) to start Spring context and run the application and [Spring Cloud Netflix](https://cloud.spring.io/spring-cloud-netflix/) to integrate Netflix Ribbon implementation into Spring.

##Version

* Spring Boot 1.4.0
* Spring Cloud 1.1.5

## How do I get set up? ##

In order to use service discovery pattern in a common Spring Boot application only three steps are needed:

* Add Spring Cloud dependencies:

    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-eureka</artifactId>
        <version>1.1.5.RELEASE</version>
    </dependency>
        	
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-hystrix</artifactId>
        <version>1.1.5.RELEASE</version>
    </dependency>

These dependencies add Ribbon client classes to the project as well as Neflix circuit breaker implementation: [Hystrix](https://github.com/Netflix/Hystrix).

* Enable Service discovery during Spring Boot startup using the annotation `@EnableEurekaClient` and circuit breaker using annotation `@EnableCircuitBreaker` on the main class:

    @SpringBootApplication
    @EnableEurekaClient
    @EnableCircuitBreaker
    @RestController
    public class SngDemoConsumerApplication {    
    ...
    }

* Add some configuration. Two configuration files are needed:

*bootstrap.yml*

    spring:
      application:
        name: consumer

*application.yml*

    server:
      port: 8002 
    
    eureka:
      client:
        serviceUrl:
          defaultZone: http://eureka-server:8000/eureka/

These parameters tell the application where the service registry is available. The first time the application tries to call another service, Ribbon will try to resolve service name to a list of URLs calling any Eureka Server configured in these parameters.

### Deployment instructions ###

The application starts as a normal Spring Boot application:

* Run `mvn install` inside the proeject
* Go to `target` folder
* Run `java -jar sng-demo-service-consumer-1.0.0-SNAPSHOT.jar`
* _Optional_: If you're using [STS IDE](https://spring.io/tools/sts/all) you can use a view called `Boot Dashboard` to start/stop any Spring Boot project you have in your workspace