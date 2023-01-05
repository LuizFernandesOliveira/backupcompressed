# Backup Compressed 
É uma API criada para praticar a compactação de arquivo com zip e publicar o arquivo compactado no AWS S3.

## Como rodar o projeto?
### Pré-requisitos
- [Docker](https://docs.docker.com/get-docker/)
- [Docker Compose](https://docs.docker.com/compose/install/)

### 1) Adicionar as variáveis de ambiente
```shell
export AWS_ACCESS_KEY=sua_access_key_da_aws
export AWS_SECRET_KEY=sua_secret_key_da_aws
```
### 2) iniciando o projeto
```shell
docker-compose up
```