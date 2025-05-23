﻿# Sistema de Cadastro

Um sistema simples de cadastro de usuários desenvolvido em Java, utilizando JDBC para interação com o banco de dados. Este projeto serve como uma introdução prática à manipulação de dados em aplicações Java.

## Funcionalidades Principais

O sistema implementa as seguintes funcionalidades:

*   **Cadastro de Pets:** Permite registrar novos pets com informações como nome, sobrenome, tipo (Cachorro/Gato), sexo (Masculino/Feminino), endereço completo (rua, número, cidade), idade, peso e raça. Inclui validações para cada campo. 
*   **Atualização de Dados de Pets:** Possibilita a modificação das informações de pets já cadastrados. O usuário pode optar por manter os dados existentes ou fornecer novos valores para cada campo.
*   **Exclusão de Pets:** Permite remover pets do sistema apenas após **confirmação** do usuário.
*   **Listagem de Todos os Pets:** Exibe uma lista completa de todos os pets cadastrados.
*   **Listagem de Pets com Filtros Avançados:** Oferece um submenu para buscar e listar pets com base em critérios:
    *   Nome do pet
    *   Tipo (Cachorro/Gato)
    *   Gênero (Masculino/Feminino)
    *   Faixa etária (idade mínima e máxima)
    *   Faixa de peso (peso mínimo e máximo)
    *   Cidade onde foi encontrado

## Tecnologias Utilizadas

- Java
- JDBC (Java Database Connectivity)
- Banco de dados relacional MySQL

## Estrutura do Projeto

O projeto está estruturado da seguinte forma:

```
Sistema-de-cadastro/
├── src/
│   ├── db/
│   │   ├── DB.java
│   │   ├── DbException.java
│   │   ├── DbIntegrityException.java
│   │   └── TransactionManager
│   ├── main/
│   │   ├── java/
│   │   │   └── Main.java
│   │   └── resources/
│   │       └── sql.properties
│   ├── model/
│   │   ├── Dao/
│   │   │   ├── PetDao.java
│   │   │   └── PetDaoJDBC.java
│   │   ├── Enum/
│   │   │   ├── PetGender.java
│   │   │   └── PetType.java
│   │   └── entities/
│   │       ├── Pet.java
│   │       └── PetAddress.java
│   ├── services/
│   │   ├── AtualizaPet.java
│   │   ├── CadastroPet.java
│   │   ├── DeletarPet.java
│   │   ├── ListarAllPets.java
│   │   ├── ListarPetFiltros.java
│   │   └── PrintMenu.java
│   └── utils/
│       ├── QueryLoader.java
│       └── Validator.java
├── db.properties
├── Sistema de Cadastro.iml
├── .gitignore
└── README.md
```

* src/: Diretório principal do código-fonte
* db/: Classes para gerenciamento de conexão com banco de dados
* main/: Contém a classe principal e recursos
* model/: Define as entidades, DAOs e enumerações
* services/: Implementa a lógica de negócio para cada funcionalidade
* utils/: Classes utilitárias para validação e carregamento de queries
* db.properties: Arquivo de configuração para conexão com o banco de dados
* Sistema de Cadastro.iml: Arquivo de configuração do projeto
* README.md: Documentação do projeto

## Configuração do Banco de Dados

Para que o sistema funcione corretamente, é necessário configurar o banco de dados. As configurações de conexão estão no arquivo `db.properties` localizado na raiz do projeto. Certifique-se de que o servidor MySQL esteja em execução e que as credenciais (usuário, senha) e o nome do banco de dados (`dburl`) estejam corretos neste arquivo.

Exemplo de `db.properties`:

```properties
dburl=jdbc:mysql://localhost:3306/nome_do_seu_database
user=seu_usuario_mysql
password=sua_senha_mysql
```

## Como Executar o Projeto

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/SamuelFontess/Sistema-de-cadastro.git
    ```
2.  **Navegue até o diretório do projeto.**
3.  **Configure o Banco de Dados:**
    *   Crie um banco de dados no seu servidor MySQL.
    *   Atualize o arquivo `db.properties` (na raiz do projeto) com a URL do seu banco, seu usuário e senha do MySQL.
4.  **Configure o Driver JDBC:** Certifique-se de que o driver JDBC do MySQL (ex: `mysql-connector-java.jar`) esteja configurado no classpath do seu projeto ou na sua IDE.
5.  **Compile e Execute:** Compile e execute a classe principal `Main.java` localizada em `src/main/java/`.
