docker compose down
call mvn clean package
docker build -t service1 service1/.
docker build -t service2 service2/.
docker compose up -d