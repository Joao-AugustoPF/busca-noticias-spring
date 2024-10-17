# Projeto NewsAPI com Spring Boot

Este projeto consome a API de notícias e retorna as últimas manchetes ou realiza buscas de notícias por palavra-chave.

## Requisitos

- Docker
- Java 17

## Como executar o projeto

1. Clone o repositório.
2. Compile o projeto usando Docker:
   ```bash
   docker compose up -d --build
   ```
   Se já houver realizado o build apenas:
   ```bash
   docker compose up
   ```
3. O aplicativo estará rodando no endereço: [http://localhost:8080](http://localhost:8080).

---

## Documentação das Rotas

A API tem três rotas principais: uma para obter as últimas notícias, outra para buscar notícias por palavra-chave e uma rota `/sobre` com informações sobre o projeto.

### 1. **GET /api/news/latest**

Esta rota retorna as últimas notícias disponíveis consumidas da API externa.

- **Método HTTP**: `GET`
- **URL**: `/api/news/latest`
- **Resposta**: Um JSON com as últimas manchetes.

#### Exemplo de Requisição

```bash
curl http://localhost:8080/api/news/latest
```

#### Exemplo de Resposta (JSON)

```json
{
  "status": "ok",
  "totalResults": 10,
  "articles": [
    {
      "author": "Author Name",
      "title": "Título da Notícia",
      "description": "Descrição da Notícia",
      "url": "https://link-para-noticia.com",
      "publishedAt": "2024-10-17T10:00:00Z"
    },
    {
      "author": "Outro Autor",
      "title": "Outra Notícia",
      "description": "Mais uma descrição",
      "url": "https://link-para-outra-noticia.com",
      "publishedAt": "2024-10-16T10:00:00Z"
    }
    // Outros artigos...
  ]
}
```

### 2. **POST /api/news/search**

Esta rota permite realizar buscas de notícias por palavra-chave. A requisição deve conter a palavra-chave no corpo em formato JSON.

- **Método HTTP**: `POST`
- **URL**: `/api/news/search`
- **Corpo da Requisição**:
  - Parâmetro `keyword`: A palavra-chave para a busca.
  
#### Exemplo de Requisição

```bash
curl -X POST http://localhost:8080/api/news/search \
  -H "Content-Type: application/json" \
  -d '{
        "keyword": "tecnologia"
      }'
```

#### Exemplo de Corpo da Requisição (JSON)

```json
{
  "keyword": "tecnologia"
}
```

#### Exemplo de Resposta (JSON)

```json
{
  "status": "ok",
  "totalResults": 5,
  "articles": [
    {
      "author": "Tech Author",
      "title": "Nova tecnologia revolucionária",
      "description": "Detalhes sobre a tecnologia...",
      "url": "https://link-para-noticia-de-tecnologia.com",
      "publishedAt": "2024-10-15T08:30:00Z"
    },
    {
      "author": "Outro Autor",
      "title": "Outro avanço tecnológico",
      "description": "Mais detalhes sobre tecnologia...",
      "url": "https://link-para-outra-noticia-de-tecnologia.com",
      "publishedAt": "2024-10-14T12:00:00Z"
    }
    // Outros artigos...
  ]
}
```

### 3. **GET /api/news/sobre**

Esta rota retorna informações sobre o projeto e seu desenvolvedor.

- **Método HTTP**: `GET`
- **URL**: `/api/news/sobre`
- **Resposta**: Um JSON com informações sobre o desenvolvedor e a versão do projeto.

#### Exemplo de Requisição

```bash
curl http://localhost:8080/api/news/sobre
```

#### Exemplo de Resposta (JSON)

```json
{
  "estudante": "João Augusto",
  "projeto": "Busca notícias",
}
```

---

## Resumo das Rotas

| Método | URL                  | Descrição                                              |
|--------|----------------------|--------------------------------------------------------|
| GET    | `/api/news/latest`    | Retorna as últimas manchetes de notícias.              |
| POST   | `/api/news/search`    | Realiza busca de notícias com base em uma palavra-chave.|
| GET    | `/api/news/sobre`     | Exibe informações sobre o projeto.                     |

---