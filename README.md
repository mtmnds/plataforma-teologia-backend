# 1. Estrutura do projeto final

## 1.1. Contexto:
Desenvolver uma aplicação de acordo com o contexto de Business Agility e de acordo com os seguintes corpos de conhecimento:
* Agile.
* DevOps.
* Lean product development.

Objetivo:
* Entregar sistemas de valor considerando o lead-time mais sustentável com o menor prazo.


## 1.2. Entregas:
* Código fonte: Link do repositório.
* Readme: Documentação e diretrizes para rodar o projeto.
* Arquitetura CI/CD: Vídeo não listado no Youtube explicando as configurações.
* Apresentação dos slides 8 ao 13: Vídeo não listado com a apresentação.


## 1.3. Especificação do desenvolvimento:
* OKR estratégico e OKR de equipe (de produto).
* Desenvolvimento de uma infraestrutura com DevOps para automatizar os serviços de CI/CD, visando aligidade para colocar o produto em produção com cobertura de testes que garanta a qualidade e satisfação do cliente.
* Trabalhar com containers (ou caso não utilize, explicar os aspectos que garantam a qualidade e utilização das pipelines).
* Planejar o projeto seguindo o Scrum e, Monitorar e controlar o projeto segundo o Lean e Kanban.
* Implementar o software segundo: User Story, BDD, TDD e Agile Testing.
* Desenvolver a aplicação baseada em padrões arquiteturais (Clean Architecture) e padrões de projeto (DDD e SOLID).


## 1.4. Conteúdo da apresentação:
* Slide 1: Logo, título do projeto e os nomes dos integrantes da equipe.
* Slide 2: OKRs estratégicos e OKRs da equipe.
* Slide 3: Visão do produto.
* Slide 4: Roadmap do produto.
* Slide 5: Backlog e priorização.
* Slide 6: Arquitetura e design de software.
* Slide 7: Padrões de projeto e reúso de código.
* Slide 8: Visão de Business Agility - Portfolio, Programas e Projetos.
* Slide 9: Estrutura para inovação e business agility.
* Slide 10: Modelo de negócios e estudo de viabilidade.
* Slide 11: Dashboard de métricas - Business Agility.
* Slide 12: Análise SWOT, Lições aprendidas - Business Agility.
* Slide 13: Considerações finais.


# 2. Build e execução

## 2.1. Requisitos:
* Java JDK 20.0.1, ou superior com retrocompatibilidade.
* Maven 3.9.3, ou superior com retrocompatibilidade.
* Docker 24.0.2, ou superior com retrocompatibilidade.

## 2.2. Build do projeto:
Executar o comando abaixo na pasta raiz do projeto:
```
mvn package
```

## 2.3. Criação da imagem:
Executar o comando abaixo na pasta raiz do projeto:
```
docker build --tag=plataforma-teologia-backend:latest .
```

## 2.4. Rodar a aplicação:
Executar o comando abaixo na pasta raiz do projeto:
```
docker run -p8887:8080 plataforma-teologia-backend:latest
```

> Obs.: O comando "-p8887:8080" mapeia a porta local 8887 para a porta 8080 dentro do container, ou seja, para consumir a aplicação será necessário enviar as requisições para a porta 8887 e o container se encarregará de fazer o redirecionamento para a porta 8080.
> Exemplo de requisição: GET http://localhost:8887/api/v1/material/home


# 3. Instruções gerais de uso

## 3.1. Autenticação
Antes de realizar a autenticação é necessário criar um usuário. Este processo pode ser realizado através da seguinte requisição:
```
POST http://localhost:8887/api/v1/auth/signup

Body:
Content-type = application/json

{
    "username": "Login do usuário",
    "password": "Senha do usuário",
    "name": "Nome do usuário"
}
```

Após a criação do usuário será possível realizar o login através da seguinte requisição:
```
POST http://localhost:8887/api/v1/auth

Body:
Content-type = application/json

{
    "username": "Login do usuário",
    "password": "Senha do usuário"
}
```

O token obtido neste processo é do tipo Bearer, e poderá ser utilizado nas requisições que o exijam adicionando o seguinte Header na requisição:
Chave: Authorization
Valor: "Bearer {conteúdo do token}"


## 3.2. Documentação
Para acessar a documentação da aplicação basta abrir a seguinte URL no navegador:
* http://localhost:8887/api/v1/swagger-ui/index.html


## 3.3. Endpoints fechados
Os seguintes endpoints estão fechados para consumo externo, ou seja, será necessário se autenticar e incluir o token no cabeçalho da requisição para consumí-los:
* POST http://localhost:8887/api/v1/material
* POST http://localhost:8887/api/v1/estudo/aprovar/{Id do estudo}


## 3.4. Endpoints abertos
Todos os endpoints que utilizem o método GET estão abertos, ou seja, não é necessário a utilização de um token para consumí-los.


# 4. Ferramentas de apoio

## 4.1. Instalação do Jenkins
1. Executar o comando abaixo:
```
docker run -p 8080:8080 -p 50000:50000 -v jenkins_home:/var/jenkins_home jenkins/jenkins:lts-jdk11
```
2. Acessar a URL "http://localhost:8080".
3. Seguir com a configuração padrão.
4. Instalar os seguintes plugins:
```
Pipeline: AWS Steps
```
5. Configurar as seguintes tools:
```
Git
Node, com a versão 18.16.1
```