# kotlin-with-springboot

install docker && run
```bash
docker pull postgres
```
```bash
docker run -it --name postgres.test -e POSTGRES_PASSWORD=1q2w3e -p 5432:5432 -d postgres
```
exec postgres.test and create database
```bash
docker exec -it postgres.test bash

psql -U postgres
create database testdb;
```



