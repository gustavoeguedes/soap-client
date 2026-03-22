# SOAP Client (Projeto de Teste)

Projeto de teste em **Spring Boot** para consumir uma API SOAP pública (Number Conversion) e expor endpoints REST simples.

## Objetivo

Este projeto existe para validar, de forma prática, como:
- consumir um serviço SOAP em Java;
- transformar a resposta em uma API REST;
- empacotar e executar a aplicação com Docker.

## Tecnologias

- Java 21
- Spring Boot 4
- Maven
- Apache CXF (geração/consumo SOAP)
- Docker

## Pré-requisitos

- Docker instalado e em execução

## Executando localmente com Docker

### 1) Build da imagem

```bash
docker build -t soap-client:latest .
```

Durante o build, o Maven executa `mvn clean package -DskipTests` e a geracao das classes SOAP acontece automaticamente via `cxf-codegen-plugin` (fase `generate-sources`).

> Importante: como o WSDL esta configurado por URL remota no `pom.xml`, o build precisa de acesso a internet para gerar as classes.

### 2) Subir o container

```bash
docker run -d --name soap-client-local -p 8080:8080 soap-client:latest
```

A aplicação ficará disponível em:

- `http://localhost:8080`

> Observação: não existe endpoint na raiz (`/`), então o esperado é usar os endpoints abaixo.

### 3) Testar os endpoints

Converter número para palavras:

```bash
curl "http://localhost:8080/number/words?numero=7"
```

Exemplo de resposta:

```json
{"response":"seven "}
```

Converter número para dólares:

```bash
curl "http://localhost:8080/number/dollar?numero=25"
```

Exemplo de resposta:

```json
{"response":"twenty five dollars"}
```


## Parar e remover o container

```bash
docker stop soap-client-local
docker rm soap-client-local
```

## Estrutura principal

- `src/main/java/.../controller/NumberController.java`: endpoints REST
- `src/main/java/.../service/NumberService.java`: integração com SOAP
- `target/generated-sources/cxf`: classes geradas a partir do WSDL
- `Dockerfile`: build e runtime da aplicação


