# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.5/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.5/gradle-plugin/reference/html/#build-image)
* [GraalVM Native Image Support](https://docs.spring.io/spring-boot/docs/3.0.5/reference/html/native-image.html#native-image)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#web.servlet.spring-mvc.template-engines)
* [Spring Security](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#web.security)
* [Rest Repositories](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#howto.data-access.exposing-spring-data-repositories-as-rest)
* [Spring Reactive Web](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#web.reactive)
* [Spring Web Services](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#io.webservices)
* [Spring Session](https://docs.spring.io/spring-session/reference/)
* [Groovy Templates](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#web.servlet.spring-mvc.template-engines)
* [OAuth2 Client](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#web.security.oauth2.client)
* [Apache Freemarker](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#web.servlet.spring-mvc.template-engines)
* [Spring for GraphQL](https://docs.spring.io/spring-boot/docs/3.0.5/reference/html/web.html#web.graphql)
* [Spring LDAP](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#data.nosql.ldap)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#appendix.configuration-metadata.annotation-processor)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#web)
* [Spring HATEOAS](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#web.spring-hateoas)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#using.devtools)
* [Jersey](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#web.servlet.jersey)
* [OAuth2 Resource Server](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#web.security.oauth2.server)
* [Okta Spring Boot documentation](https://github.com/okta/okta-spring-boot#readme)

### Guides

The following guides illustrate how to use some features concretely:

* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
* [Accessing Neo4j Data with REST](https://spring.io/guides/gs/accessing-neo4j-data-rest/)
* [Accessing MongoDB Data with REST](https://spring.io/guides/gs/accessing-mongodb-data-rest/)
* [Building a Reactive RESTful Web Service](https://spring.io/guides/gs/reactive-rest-service/)
* [Producing a SOAP web service](https://spring.io/guides/gs/producing-web-service/)
* [Building a GraphQL service](https://spring.io/guides/gs/graphql-server/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Building a Hypermedia-Driven RESTful Web Service](https://spring.io/guides/gs/rest-hateoas/)
* [Okta-Hosted Login Page Example](https://github.com/okta/samples-java-spring/tree/master/okta-hosted-login)
* [Custom Login Page Example](https://github.com/okta/samples-java-spring/tree/master/custom-login)
* [Okta Spring Security Resource Server Example](https://github.com/okta/samples-java-spring/tree/master/resource-server)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)

### Additional Links

These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)
* [Configure AOT settings in Build Plugin](https://docs.spring.io/spring-boot/docs/3.0.5/gradle-plugin/reference/htmlsingle/#aot)

## OAuth 2.0 and OIDC with Okta

If you don't have a free Okta developer account, you can create one with [the Okta CLI](https://cli.okta.com):

```bash
$ okta register
```

Then, register your Spring Boot app on Okta using:

```bash
$ okta apps create
```

Select **Web** > **Okta Spring Boot Starter** and accept the default redirect URIs.

## GraalVM Native Support

This project has been configured to let you generate either a lightweight container or a native executable.
It is also possible to run your tests in a native image.

### Lightweight Container with Cloud Native Buildpacks

If you're already familiar with Spring Boot container images support, this is the easiest way to get started.
Docker should be installed and configured on your machine prior to creating the image.

To create the image, run the following goal:

```
$ ./gradlew bootBuildImage
```

Then, you can run the app like any other container:

```
$ docker run --rm -p 8080:8080 demo00:0.0.1-SNAPSHOT
```

### Executable with Native Build Tools

Use this option if you want to explore more options such as running your tests in a native image.
The GraalVM `native-image` compiler should be installed and configured on your machine.

NOTE: GraalVM 22.3+ is required.

To create the executable, run the following goal:

```
$ ./gradlew nativeCompile
```

Then, you can run the app as follows:

```
$ build/native/nativeCompile/demo00
```

You can also run your existing tests suite in a native image.
This is an efficient way to validate the compatibility of your application.

To run your existing tests in a native image, run the following goal:

```
$ ./gradlew nativeTest
```

