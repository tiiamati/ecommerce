# API E-commerce

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 9.1.6.

## Database

Create database ```create database ecommerce;```

Configure database in file application.properties

```
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/ecommerce
spring.datasource.username=root
spring.datasource.password=
```
## User

email: ecommer@maskara.com
pass: 12345

## Run API

Run `mvn spring-boot:run`. Configure port `http://localhost:8089/`

## In progress

**Requirements:**
- Unity Testes
- Integration with OAuth
- Validate session

**Client actions:**
- View order history
- Filter products

## References

[Imagens/Products](https://www.elo7.com.br/corujaoucorujinha?nav=sts_ps_back_str)

