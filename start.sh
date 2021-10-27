#!/bin/bash
docker compose down
./mvnw clean install
cd service1
docker build -t service1 .
cd ..
cd service2
docker build -t service2 .
cd ..
docker compose up -d