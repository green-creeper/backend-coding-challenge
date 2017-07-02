## Solution for coding task

### Execution

- Build front end part 
```
#> cd webapp
#> npm install -g gulp && npm install
#> gulp dev
```
- Build a JAR file

```
#> cd expensemanager
#> gradle clean build shadowJar
```

- Setup postgres on docker
```
### run postgres container
#> docker run --name expensedb -p 5432:5432 -e POSTGRES_PASSWORD=mysecretpassword -d postgres
### now you need to enter to psql with password provided above
#> docker run -it --link expensedb:postgres --rm postgres sh -c 'exec psql -h "$POSTGRES_PORT_5432_TCP_ADDR" -p "$POSTGRES_PORT_5432_TCP_PORT" -U postgres'
### Create database for application
postgres=# create database expensedb;
postgres=# \q
```

- Migrate database

```
#> java -jar build/libs/expensemanager-1.0-SNAPSHOT-all.jar db migrate config.yml

```

- Run service
```
#> java -jar build/libs/expensemanager-1.0-SNAPSHOT-all.jar server config.yml
```

- application should now be available on `http://localhost:8095/`  