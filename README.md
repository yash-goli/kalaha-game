# How to Run
Run the Kalaha game using Docker-compose.

## Build

Navigate to `kahala-api` and run `./mvnw clean install` :

```
./mvnw clean install
```

## Build container for Game Backend

```
docker build -t kalaha-api:1 .
```

## Build container for Game Frontend

Navigate to `kahala-app` :

```
docker build -t kalaha-app:1 .
```

## Up containers using docker compose

```
docker-compose up -d
```

Note: if you have problem running frontend app from docker-compose, please the docker run from `kahala-app`
```
docker run --name kalaha-app-new -p 3000:3000 kalaha-app:1
```
