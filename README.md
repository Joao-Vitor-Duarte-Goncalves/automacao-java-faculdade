## 🧪 Projeto de Automação de Testes (API & Web)
- Este repositório contém a automação de dois desafios técnicos distintos, utilizando Java e Maven.

## 📍 O que é testado?
### 1. Automação de API (Swagger Petstore):
- Testes de integração que validam o "contrato" e o funcionamento dos endpoints de um sistema de petshop.
* User: Criação e consulta de usuários.
* Pet: Cadastro e manutenção de animais.
* Store: Consulta de inventário e realização de pedidos.

### 2.Automação Web (SauceDemo):
- Automação Web (SauceDemo).
* Fluxo: Login -> Adição de produtos ao carrinho -> Preenchimento de dados de entrega -> Finalização da compra.
* Padrão: Implementado utilizando Page Objects para melhor manutenção.

## 🚀 Como Rodar as Automações

### 1. Clonar o Repositório:
```bash
git clone [URL_DO_REPOSITORIO]
cd automacao-java-faculdade/testes-automacao
```

### Teste Automação API
```bash
mvn test "-Dtest=UserTest,PetTest,StoreTest" --file testes-automacao/pom.xml
```

### Teste Automação Web
```bash
mvn test "-Dtest=CompraTest" --file testes-automacao/pom.xml
```