# CRUD de Carros, Modelos e Marcas

Este é um projeto de exemplo que implementa um CRUD (Create, Read, Update, Delete) de carros, modelos e marcas. O objetivo deste projeto é demonstrar como criar uma aplicação Java que interage com um banco de dados PostgreSQL para gerenciar informações de carros, incluindo modelo e marca.

## Tecnologias Utilizadas

- Java 17: A linguagem de programação principal para o desenvolvimento do projeto.
- Maven: Gerenciador de dependências e construção de projetos Java.
- PostgreSQL 14.9: Sistema de gerenciamento de banco de dados relacional.

## Configuração do Banco de Dados

Antes de executar a aplicação, você precisará configurar o banco de dados PostgreSQL. Certifique-se de que o PostgreSQL 14.9 esteja instalado e crie um banco de dados com o nome de sua escolha. Em seguida, atualize as informações de configuração do banco de dados no arquivo `application.properties`.

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco_de_dados
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

## Como Executar o Projeto
Siga os passos abaixo para executar a aplicação:

Clone este repositório para o seu ambiente local:
```properties
git clone https://github.com/guilhermebarrosf/crud-veiculos.git
```
Navegue até o diretório do projeto:

```properties
cd seu-repositorio
```
Construa o projeto usando o Maven:

```properties
mvn clean install
```
Suba o projeto Spring

Acesse a aplicação em seu navegador:

```properties
http://localhost:8080/carro/listar
```
## Endpoints da API
Este projeto oferece os seguintes endpoints da API para executar operações CRUD:

## Carros
**GET** /carro/listar: Retorna a lista de todos os carros. <br />
**POST**/carro/incluir: Adiciona um novo carro. <br />
**PUT** /carro/editar: Atualiza os detalhes de um carro específico pelo ID. <br />
**DELETE** /carro/{id}/excluir: Exclui um carro específico pelo ID. <br />

## Modelos
**GET** /modelo/listar: Retorna a lista de todos os modelos de carro. <br />
**POST** /modelo/incluir: Adiciona um novo modelo de carro. <br />
**PUT** /modelo/editar: Atualiza os detalhes de um modelo de carro específico pelo ID. <br />
**DELETE** /modelo/{id}/excluir: Exclui um modelo de carro específico pelo ID. <br />
## Marcas
**GET** /marca/listar: Retorna a lista de todas as marcas de carro. <br />
**POST** /marca/incluir: Adiciona uma nova marca de carro. <br />
**PUT** /marca/editar: Atualiza os detalhes de uma marca de carro específica pelo ID. <br />
**DELETE** /marca/{id}/excluir: Exclui uma marca de carro específica pelo ID. <br />


## Com esse projeto, pude demostrar um pouco meus conhecimentos em: <br />
 **Clean Code** <br />
 **TDD** <br />
 **Java** <br />
 **Hibernate** <br />
 **Spring boot** <br />
 **Banco de Dados Relacionais** <br />
 **JPA** <br />
 **Testes Unitários** <br />
 **HTML** <br />
 **CSS** <br />
 **JS** <br />
 
