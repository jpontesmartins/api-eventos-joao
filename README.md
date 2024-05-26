# api-eventos-joao


## Ambiente local

- JDK: GraalVM JDK 22
- Maven: 3.9.6

## Início

### 1. Clonar `api-eventos-joao`

    $ git clone https://github.com/jpontesmartins/api-eventos-joao


### 2. Agendador

- Configurar a expressão cron do agendador no `application.properties`
- No exemplo abaixo ele está rodando todos os dias as 10:55 da manhã  

    ```
    cron.expr=0 55 10 * * ?
    ```

### 3. Compilar e iniciar o projeto utilizando o maven

    $ mvn compile quarkus:dev

### 4. Banco de dados

- H2
    - Ao subir a aplicação com o comando acima, a base H2 já contém dois registros de Instituicao.  
    Para verificar os dados, executar o `GET` para o endpoint `/instituicoes`, como mostrado abaixo:

        ```
            $ curl --location 'localhost:8080/instituicoes'
        ```

        O resultado deve ser algo como (beautified):
        ```
            [
                {
                    "id": 1,
                    "nome": "Prefeitura",
                    "tipo": "Publica"
                },
                {
                    "id": 2,
                    "nome": "Escola",
                    "tipo": "Particular"
                }
            ]
        ```

### 5. Execução da tarefa agendada
- Após o horário para a exceução da tarefa agendada, pode-se realizar um cURL para consultar todos os eventos e ver quais tiveram seu status alterado.
```
    $ curl --location 'localhost:8080/eventos'
```
