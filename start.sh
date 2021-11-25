#!/bin/bash
docker compose down
./mvnw clean install
docker compose up -d