📦 Sistema de Cálculo de Frete - Microservices (Service A + Service B)

Projeto desenvolvido utilizando Spring Boot 3, WebFlux, Docker e OpenAPI (Swagger), simulando comunicação entre microserviços com fallback.

🏗 Arquitetura

O sistema é composto por dois serviços:

service-b → Responsável pelo cálculo do frete

service-a → Consome o service-b e implementa fallback em caso de falha

Fluxo normal:

Cliente → service-a → service-b


Fluxo com falha:

Cliente → service-a → fallback

🚀 Como subir o projeto

Na raiz do projeto, executar:

docker compose up --build


Isso irá:

Buildar os dois serviços

Subir service-a na porta 8080

Subir service-b na porta 8081

🔎 URLs de Teste
✅ 1. Teste direto no service-b
http://localhost:8081/shipping/quote?cep=31234-000&weightKg=1.2


Resposta esperada (exemplo):

{
  "cep": "31234-000",
  "weightKg": 1.2,
  "region": "MG",
  "total": 14.0
}

✅ 2. Teste via service-a (integração)
http://localhost:8080/quote?cep=31234-000&weightKg=1.2


Resposta esperada:

{
  "cep": "31234-000",
  "weightKg": 1.2,
  "region": "MG",
  "total": 14.0,
  "source": "service-b"
}

⚠️ 3. Teste de Fallback (falha parcial)
Passo 1 – Parar o service-b
docker compose stop service-b

Passo 2 – Chamar novamente o service-a
http://localhost:8080/quote?cep=31234-000&weightKg=1.2


Resposta esperada:

{
  "cep": "31234-000",
  "weightKg": 1.2,
  "region": "fallback",
  "total": 25.0,
  "source": "fallback"
}


O campo "source": "fallback" indica que o service-a utilizou o mecanismo de fallback.

📘 Swagger (Documentação da API)

Service A:

http://localhost:8080/swagger-ui/index.html


Service B:

http://localhost:8081/swagger-ui/index.html

🛠 Tecnologias Utilizadas

Java 17

Spring Boot 3

Spring WebFlux

WebClient

Docker

Docker Compose

OpenAPI / Swagger (springdoc)

📁 Estrutura do Projeto
/service-a
/service-b
compose.yaml
README.md
