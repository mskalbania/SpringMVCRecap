#!/usr/bin/env bash
#while true
#do
    docker container kill mvc #$(docker ps -a -q)
    docker container rm mvc #$(docker ps -a -q)
    docker rmi $(docker image list -q | head -n1)
    mvn clean install -DskipTests
    docker build -t mvc .
    docker run -d --network dbnet -p 9999:8080 --name mvc -t mvc
    docker logs -f mvc
#    sleep 3030303
#done