# BankAccountManagement

O objetivo foi criar uma API REST com algumas funções essenciais relacionadas ao gerenciamento de contas bancárias em Java.

Neste projeto foi utilizado o banco de dados H2.

O endereço para acessar os dados do H2 é http://localhost:8080/h2-console.

Os endopints são:

  POST http://localhost:8080/h2-console/customers , enviando no body em JSON informações do cliente (documento, nome, senha), para criar usuário
  
  PUT http://localhost:8080/h2-console/customers , enviando no body em JSON informações do cliente (documento, nome, senha), para alterar usuário
  
  GET http://localhost:8080/h2-console/customers , para listar todos usuários
  
  DELETE http://localhost:8080/h2-console/customers/{id}, enviando o número do id do usuário que vai ser deletado
  
  
 SALDO: GET http://localhost:8080/h2-console/bank/balances , enviando como parâmetros: 'document', 'password', 'branch' e 'account', para ter acesso ao saldo da conta em questão
  
  DEPÓSITO: PUT http://localhost:8080/h2-console/bank/deposits, enviando como parâmetros: 'branch', 'account', 'bank-code' e 'value' (valor a ser depositado)
  
  SAQUE: PUT http://localhost:8080/h2-console/bank/withdraws  enviando como parâmetros: 'branch', 'account', 'document' , 'password' e 'value' (valor a ser sacado)
  
 TRANFERENCIA:  PUT http://localhost:8080/h2-console/bank/transfers enviando como corpo dados da conta da onde vai partir a transferênia e parâmetros da conta de destino: 'branch', 'account', bank-code' e 'value' (valor a ser transferido)
  


