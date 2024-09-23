# SanGiorgioApplication

Este é um projeto Spring Boot que gerencia o processamento de pagamentos para vendedores, validando os pagamentos e enviando informações para diferentes filas do AWS SQS com base no status do pagamento (parcial, total ou excedente).

<img src="assets/images/Diagrama_Arquitetura.png">

## Funcionalidades

- Processamento de pagamentos com validação de vendedor e código da cobrança.
- Diferenciação de pagamentos parciais, totais ou excedentes.
- Envio de mensagens para filas SQS específicas conforme o tipo de pagamento.
- Integração com AWS SDK para enviar mensagens às filas SQS.
- Exposição de uma API REST para o recebimento e processamento de pagamentos.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3
- PostgreSQL
- AWS SDK (SQS)
- Jakarta Persistence API (JPA)
- JUnit 5 para testes unitários
- Maven como ferramenta de build

## Pré-requisitos

- Java 17 instalado
- Maven instalado
- PostgreSQL configurado e em execução
- AWS SQS configurado (credenciais de acesso configuradas no arquivo application.yaml)

## Configuração

###Simulando AWS para enviar  objeto para fila SQS 

#### Ativar o Perfil mock-sqs no application.yaml
	spring:
	  profiles:
       active: mock-sqs
    		
    aws:  
      sqs:  
        region: us-east-1  
    	 access-key: fake-access-key  
        secret-key: fake-secret-key  
        queue-urls:  
          partial: http://localhost:4566/000000000000/partial-payments  
          total: http://localhost:4566/000000000000/total-payments  
          excess: http://localhost:4566/000000000000/excess-payments  

## Configuração do Perfil mock-sqs no Eclipse 
	Para rodar o projeto com o perfil mock-sqs (simulação de SQS), siga esses passos:
	Clique com o botão direito do mouse no projeto.
    Selecione Run As > Run Configurations.
    Na aba Arguments, no campo VM arguments, adicione o seguinte para definir o perfil ativo:
   -Dspring.profiles.active=mock-sqs

	Depois, vá até a aba "Arguments":
	No campo VM arguments, você pode colocar parâmetros de JVM, como memória, etc.
	No campo Program arguments, que é onde você pode adicionar argumentos de execução da aplicação 
	Spring Boot, adicione o seguinte:
   --spring.profiles.active=mock-sqs
	



#### 1. Clone o repositório: git@github.com:augustczar/san-giorgio-api.git

