#!/usr/bin/env bash
docker network rm dbnet
docker network create -d bridge dbnet
docker container kill db
docker container rm db
docker run --name db -d --network dbnet -e POSTGRES_USER=root -e POSTGRES_PASSWORD=admin -e POSTGRES_DB=exampleDB postgres