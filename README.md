# BankAccountManagement

O objetivo foi criar uma API REST com algumas funções essenciais relacionadas ao gerenciamento de contas bancárias em Java.

Neste projeto foi utilizado o banco de dados H2.

O endereço para acessar os dados do H2 é http://localhost:8080/h2-console.

Os endopints são:
  POST http://localhost:8080/h2-console/customers , enviando no body em JSON informações do cliente (documento, nome, senha), para criar usuário
  PUT http://localhost:8080/h2-console/customers , enviando no body em JSON informações do cliente (documento, nome, senha), para alterar usuário
  GET http://localhost:8080/h2-console/customers , para listar todos usuários
  DELETE http://localhost:8080/h2-console/customers/{id}, enviando o número do id do usuário que vai ser deletado
  
  GET http://localhost:8080/h2-console/bank , enviando como parâmetro 'document', 'password', 'branch' e 'account', para ter acesso ao saldo da conta em questão.
  PUT http://localhost:8080/h2-console/bank/deposits
  PUT http://localhost:8080/h2-console/bank/withdraws 
  PUT http://localhost:8080/h2-console/bank/transfers


