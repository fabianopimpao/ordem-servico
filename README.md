# ordem-servico
 - Projeto básico de uma api para realizar algumas funcionalidades do gerênciamento de uma ordem de serviço
 
## Executando local
 - Clonar o projeto
 - `cd ordem-servico`
 - `mvn clean install`
 - Executar:
   - `java -jar target/ordem-servico-0.0.1-SNAPSHOT.jar`
   
# Como testar
  - Enviar um `POST` request para `http://your-ip-here:8081/clientes`, com as informações do cliente no corpo da requisição. Será retornado no header da resposta o id do novo cliente.
```
{
    "nome": "Abelardo Barbosa",
    "enderecos": [
        {
            "logradouro": "Rua Professor Germano Timm",
            "numero": "68",
            "complemento": null,
            "bairro": "Saguaçú",
            "cep": "89202-404",
            "cidade": "Joinville",
            "estado": "Santa Catarina"            
        }   
    ],
    "telefone": "(47)3455-3599",
    "email": "abelardo@gmail.com"
}

```

- Enviar um `POST` request para `http://your-ip-here:8081/equipamentos`, com as informações do equipamento e o id cliente no corpo da requisição. Será retornado no header da resposta o id do novo equipamento.
```
{
    "descricao": "Televisor 55 polegadas",
    "marca": "Qualquer uma",
    "tipo": "LED",
    "situacao": "Problema na fonte",
    "clienteId": "3fc2e208-a4d0-49c5-a0e6-0deb944183a0"
}
```
- Enviar um `POST` request para `http://your-ip-here:8081/ordens`, com as informações do id equipamento e o id cliente no corpo da requisição. Será retornado no header da resposta o id da nova ordem de serviço.

```
{    
    "clienteId": "3fc2e208-a4d0-49c5-a0e6-0deb944183a0",
    "equipamentoId": "ece9544e-af79-4484-95b6-9a4b2dd775ea"
}
```
# Outras funcionalidades

## Responsável assumir uma ordem 
 - Enviar um `PUT` request para `http://your-ip-here:8081/ordens/assumirOrdem/{ordemId}`, com as informação do responsável no corpo da requisição. Será retornado status HTTP 200 OK.

```
{
    "responsavel": "Sandoval"
}
```

## Iniciar uma ordem
- Enviar um `PUT` request para `http://your-ip-here:8081/ordens/iniciarOrdem/{ordemId}`, com as informação do responsável no corpo da requisição. Será retornado status HTTP 200 OK.

```
{
    "responsavel": "Sandoval Quaresma"
}
```

## Concluir uma ordem
- Enviar um `PUT` request para `http://your-ip-here:8081/ordens/concluirOrdem/{ordemId}`, com as informação do responsável no corpo da requisição. Será retornado status HTTP 200 OK.

```
{
    "responsavel": "Sandoval Quaresma"
}
```

## Consultar ordens pendentes por responsavel
- Enviar um `GET` request para `http://your-ip-here:8081/ordens/ordensPendentes/{responsavel}`. Será retornado as informações das ordens que estão pendentes para o responsável informado:

```
[
    {
        "ordemId": "09209bc8-8035-4278-92c0-57b4b41d0546",
        "clienteId": "0f597ca1-3f56-483c-92fe-8515b9f09fe2",
        "equipamentoId": "33962ed5-52cc-40df-8111-c436871c5bf1",
        "dataCriacao": "2020-09-21T07:49:44.202869",
        "dataInicial": null,
        "dataConclusao": null,
        "status": "PENDENTE",
        "responsavel": "Sandoval"
    }
]
```

```
  - Tentar utilizar algum cliente Http para realizar as requsisações.  
```

# E sobre o banco de dados?
Esse projeto está utilizando banco de dados em memório H2DB. Para acessar o console do h2 informe http://your-ip-here:8081/h2-console

## Observação
 - Não foram implementados alguns verbos https no projeto, falta implementa os teste unitários e o detalhe da ordem serviço.
