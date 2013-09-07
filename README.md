# Arquitetura do Projeto

## Spring Framework
Foi escolhido o Spring por causa da implementação da arquitetura MVC e da injeção de dependências.

## JPA
Foi escolhido o JPA para fazer a camada de comunicação com o banco de dados, pois o glassfish já possui as bibliotecas necessárias para o desenvolvimento, além da facilidade em relação ao JDBC.

# Definição de Padrões do projeto

## View
As JSPs ficam no diretório WebContent/jsp.

## Controller
Todos os Controllers ficam no pacote br.com.classeencanto.controller, dentro da pasta src.
Os Controllers devem ser anotados com a anotação @Controller do Spring.

## Model
As Models ficam no pacote br.com.classeencanto.model, dentro da pasta src.
Devem ser anotadas com a anotação @Entity do Spring e serem filhas da classe AbstractModel.

## DAO
Os DAOs ficam no pacote br.com.classeencanto.dao, dentro da pasta src.
Devem ser anotados com a anotação @Repository do Spring e serem filhas da classe AbstractDAO. Devem implementar a interface equivalente (Ex: ProdutoDAO e ProdutoDAOImpl)

## Junit
Os testes ficam no pacote classeencanto, dentro da pasta test.

