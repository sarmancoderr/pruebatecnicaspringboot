[ ] Ramificar commit
[ea990d7](https://github.com/sarmancoderr/pruebatecnicaspringboot/commit/ea990d7f61b16993193db69a5bce7e9946d0e0a3)
para cambiar con docker las credenciales de la autenticación básica

# Welcome to Spring boot technical test 👋
[![Version](https://img.shields.io/npm/v/Spring boot technical test.svg)](https://www.npmjs.com/package/Spring boot technical test)

> Technical test for job applyment

## Install

```sh
mvnw package # without docker
docker build -t technicaltest  . # with docker
```

## Usage

```sh
mvnw spring-boot:run # without docker
docker run -d -p 3000:8080 technicaltest # with docker
```

## Run tests

```sh
mvnw test
```

## Author

👤 **Raul Contreras**

* Github: [@sarmancoderr](https://github.com/sarmancoderr)

## Show your support

Give a ⭐️ if this project helped you!


***
_This README was generated with ❤️ by [readme-md-generator](https://github.com/kefranabg/readme-md-generator)_