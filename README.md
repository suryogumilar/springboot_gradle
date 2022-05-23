# Springboot using gradle as build mgm

masih memakai application.properties

### akses url

pada file `build.gradle` kita override `server.servlet.context-path` yang didefinisikan di file `application.properties` dengan rename war jadi akses via url:

http://hostname:8080/spbootgradle/users/allusers

cara overide war name di build.gradle

```groovy
war {
	archiveName "spbootgradle.war"
}
```

### how to build

#### gradle

menggunakan gradle versi 7.4.2, masuk ke dir dan jalankan:   

`gradle build`   

pastikan database running karena ada task test, lihat di pakcage test folder `src/test/java`. Untuk skip test jalankan dengan argumen `-x test`:

`gradle build -x test`

###### note untuk gradle wrapper:  

pada [spring intitializer](https://start.spring.io/) versi gradle yang digunakan thus gradlew nya adalah versi 7.4.1, kita upgrade gradle yang digunakan menggunakan latest version per tanggal project ini dibuat (10 Mei 2022) yaitu versi 7.4.2 (release date Mar 31, 2022, sementara 7.4.1 release date Mar 09, 2022. Lihat di laman [release](https://gradle.org/releases/) )



##### via eclipse IDE (versi : 2022-3)

menggunakan buildship eclipse plugin untuk gradle

 - buka window -> show view-> other -> Gradle -> pilih Gradle Tasks dan Gradle Executions
 - pada view Gradle Taks akan terlihat task yg bisa dijalankan
 - pilih dan run task yg diinginkan

Untuk skip test masukkan argume '-x test' pada `Program Arguments` di `Run Configuration`
insert pada separate lines dari Program Arguments

### some notes and trouble shoot


##### baris dibawah diperlukan jika menemui error table does not exist oleh hibernate:   
`spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl`   

[lihat:](https://stackoverflow.com/questions/46625996/spring-boot-hibernate-table-does-not-exists)

##### pemisahan scan base package, entity dan repository

jika lokasi jpa repository berbeda path atau pakcagenya dengan Configuration class dan spring boot runner (@SpringBootApplication class) maka harus dipisah menggunakan anotasi sbb:   

```java
@EnableJpaRepositories("my.package.repository.base.*")
@ComponentScan(basePackages = { "my.package.base.*" })
@EntityScan("my.package.entity.base.*")   
```

referensi:   
 - [not a managed type pada entity](https://stackoverflow.com/questions/28664064/spring-boot-not-a-managed-type)
 - [cant-autowire-repository](https://stackoverflow.com/questions/29221645/cant-autowire-repository-annotated-interface-in-spring-boot)
 
## docker

untuk run menggunakan docker compose ada dua file env:

#### mariadb envi files
contohnya adalah sbb

```bash
MARIADB_ROOT_PASSWORD=password
MARIADB_MYSQL_LOCALHOST_USER=maria
MARIADB_DATABASE=mariadbdev
MARIADB_USER=mariauser
MARIADB_PASSWORD=password
```

#### tomcat envi files
contohnya adalah sbb

```bash
DB_DRIVER=org.mariadb.jdbc.Driver
DB_URL=jdbc:mysql://mariadb:3306/mariadbdev?useSSL=false
DB_USER=mariauser
DB_PASSWORD=password
```

## menggunakan mongodb (docker version)

untuk run menggunakan docker compose ada dua file env:

### mongodb envi file

contohnya adalah sbb

```bash
MONGO_INITDB_ROOT_USERNAME=root
MONGO_INITDB_ROOT_PASSWORD=password

# file .js juga harus dibuat dengan nama yg sama dengan variabel ini di folder `docker-entrypoint-initdb.d`
# jika file js tidak diberikan atau tidak dipetakan melalui `volume` maka database ytg dibuat defaultnya adalah `test`
#MONGO_INITDB_DATABASE=mongodbdev
```

untuk express mongo sebagai gui untuk adminnya menggunakan envi :

#### mongo-express envi file

contohnya dalah sbb

```bash
## konfigurasi untuk mongo expressnya, untuk autentikasi

ME_CONFIG_BASICAUTH_USERNAME=mongoexpressuser
ME_CONFIG_BASICAUTH_PASSWORD=password

## theme
ME_CONFIG_OPTIONS_EDITORTHEME=dracula

## konfigurasi untuk koneksi ke mongodbnya

ME_CONFIG_MONGODB_ADMINUSERNAME=root
ME_CONFIG_MONGODB_ADMINPASSWORD=password
ME_CONFIG_MONGODB_ENABLE_ADMIN=true
ME_CONFIG_MONGODB_SERVER=mongodb

## The following are only needed if ME_CONFIG_MONGODB_ENABLE_ADMIN is "false"
# ME_CONFIG_MONGODB_AUTH_USERNAME=root
# ME_CONFIG_MONGODB_AUTH_PASSWORD=password
# ME_CONFIG_MONGODB_AUTH_DATABASE=mongodbdev
```

### tomcat for mongodb envi file

contohnya adalah sbb:

```
MONGODB_URI=mongodb://root:password@mongodbserver:27017/mongodbdev?authSource=admin
```

### build gradle dengan file `gradle.build` dengan nama yg berbeda

jika kita menggunakan file untuk build gradle dengan nama yang berbeda dengan nama default `gradle.build`, misal nama file untuk buildnya adalah `build4mongo.gradle`, maka gunakan perintah:

`gradle --build-file=build4mongo.gradle`

tapi Eclipse tidak bisa disetting menggunakan build.gradle yang berbeda


## akses url service
contoh akses : 
 - GET method:
    - http://appserver:8080/spbootgradle/users4mongo/allusers
    - http://appserver:8080/spbootgradle/users4mongo/getbyid/0 
 - DELETE method:
    - http://appserver:8080/spbootgradle/users4mongo/delete?id=0
 - POST method:
    - http://appserver:8080/spbootgradle/users4mongo/addOrUpdate
 
## mongo db Factory dan template class
 
[referensi](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#data.nosql.mongodb)

tidak perlu dua class dibawah ditambahkan ke aplikasi juga tidak apa-apa dan bisa mengurangi sedikit size package kecuali ingin melakukan kustomisasi

#### Mongo factory bean
 
To access MongoDB databases, you can inject an auto-configured org.springframework.data.mongodb.MongoDatabaseFactory. By default, the instance tries to connect to a MongoDB server at mongodb://localhost/test.  

```java
package com.sg.microservice.springbootgradle;

import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.stereotype.Component;
 
@Component
public class MyMongoFactoryBean {
	private final MongoDatabaseFactory mongo;
	public MyMongoFactoryBean(MongoDatabaseFactory mongo) {
        this.mongo = mongo;
        System.out.println(mongo);
    }
	public MongoDatabaseFactory getMongo() {
		return mongo;
	}
}
```

#### Mongo template bean

Spring Data MongoDB provides a MongoTemplate class that is very similar in its design to Spring’s JdbcTemplate. As with JdbcTemplate, Spring Boot auto-configures a bean for you to inject the template,

```java
package com.sg.microservice.springbootgradle;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;


@Component
public class MyMongoTemplateBean {
	private final MongoTemplate mongoTemplate;
	
	public MyMongoTemplateBean(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
        System.out.println(mongoTemplate);
	}

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}
}

```
### using @indexed annotation

jika sudah ada data dan kita ubah constructionnya dengan @indexed maka error duplicate key