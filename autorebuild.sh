#!/usr/bin/env bash
docker container kill $(docker ps -a -q)
docker container rm $(docker ps -a -q)
docker rmi $(docker image list -q | head -n1)
mvn clean install -DskipTests
docker build -t mvc .
docker run -d -p 9999:8080 --name mvc -t mvc
docker logs -f mvc