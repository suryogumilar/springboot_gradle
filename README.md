# Springboot using gradle as build mgm

masih memakai application.properties


### how to build

#### gradle

menggunakan gradle versi 7.4.2, masuk ke dir dan jalankan:   

`gradle build`   

pastikan database running karena ada task test, lihat di pakcage test folder `src/test/java`. Untuk skip test jalankan dengan argumen `-x test`:

`gradle build -x test`

##### via eclipse IDE

menggunakan buildship eclipse plugin untuk gradle

 - buka window -> show view-> other -> Gradle -> pilih Gradle Tasks dan Gradle Executions
 - pada view Gradle Taks akan terlihat task yg bisa dijalankan
 - pilih dan run task yg diinginkan

### some notes and trouble shoot


##### baris dibawah diperlukan jika menemui error table does not exist oleh hibernate:   
`spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl`   

[lihat:](https://stackoverflow.com/questions/46625996/spring-boot-hibernate-table-does-not-exists)

##### pemisahan scan base package, entity dan repository

jika lokasi jpa repository berbeda path atau pakcagenya dengan Configuration class dan spring boot runner maka harus dipisah menggunakan anotasi sbb:   

```java
@EnableJpaRepositories("my.package.repository.base.*")
@ComponentScan(basePackages = { "my.package.base.*" })
@EntityScan("my.package.entity.base.*")   
```

referensi:   
 - [not a managed type pada entity](https://stackoverflow.com/questions/28664064/spring-boot-not-a-managed-type)
 - [cant-autowire-repository](https://stackoverflow.com/questions/29221645/cant-autowire-repository-annotated-interface-in-spring-boot)