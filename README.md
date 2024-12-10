# Desafio Back-end PicPay
**O PicPay Simplificado é uma plataforma de pagamentos simplificada. Nela é possível depositar e realizar transferências de dinheiro entre usuários. Temos 2 tipos de usuários, os comuns e lojistas, ambos têm carteira com dinheiro e realizam transferências entre eles.**

# Requisitos
* **Para ambos tipos de usuário, precisamos do Nome Completo, CPF, e-mail e Senha. CPF/CNPJ e e-mails devem ser únicos no sistema. Sendo assim, seu sistema deve permitir apenas um cadastro com o mesmo CPF ou endereço de e-mail;**

* **Usuários podem enviar dinheiro (efetuar transferência) para lojistas e entre usuários;**

* **Lojistas só recebem transferências, não enviam dinheiro para ninguém;**

* **Validar se o usuário tem saldo antes da transferência;**

* **Antes de finalizar a transferência, deve-se consultar um serviço autorizador externo, use este mock https://util.devi.tools/api/v2/authorize para simular o serviço utilizando o verbo GET;**

* **A operação de transferência deve ser uma transação (ou seja, revertida em qualquer caso de inconsistência) e o dinheiro deve voltar para a carteira do usuário que envia;**

* **No recebimento de pagamento, o usuário ou lojista precisa receber notificação (envio de email, sms) enviada por um serviço de terceiro e eventualmente este serviço pode estar indisponível/instável. Use este mock https://util.devi.tools/api/v1/notify)) para simular o envio da notificação utilizando o verbo POST;**

* **Este serviço deve ser RESTFul.**

# Métodos http
* API - Cliente
  
*POST*
**http://localhost:8080/api/v1/cliente -> Cria um novo cliente**

*GET*
**http://localhost:8080/api/v1/cliente -> Lista todos os clientes cadastrados**

*GET*
**http://localhost:8080/api/v1/cliente/id/{id} -> Filtra cliente por id**

*GET*
**http://localhost:8080/api/v1/cliente/email/{email} -> Filtra cliente pelo email**

*PATCH*
**http://localhost:8080/api/v1/cliente/update/{id} -> Altera a senha do usuário através da busca pelo id**

*DELETE*
**http://localhost:8080/api/v1/cliente/delete/email/{email} -> Deleta cadastro do cliente através do email**

* API - Transação

*POST*
**http://localhost:8080/api/v1/transacao -> Cria uma nova transação**

*GET*
**http://localhost:8080/api/v1/transacao -> Lista todas as transações realizadas**

*GET*
**http://localhost:8080/api/v1/transacao/email/remetente/{email} -> Filtra transações pelo email através do remetente**

*GET*
**http://localhost:8080/api/v1/transacao/email/destinatario/{email} -> Filtra transações pelo email através do destinatário**

# Plataformas utilizadas
* Linguagem de programação -> JAVA
* Framework -> SpringBoot
* IDE -> Intellij
* Banco de Dados -> PostgreSQL
* Ambiente para versionamento de código -> Git e GitHub
* Ambiente para Contêinerização -> Docker

# URL para documentação da API
**http://localhost:8080/picPay-docs.html**



