#!/bin/bash

declare infrastructure=docker-compose.yml
declare application=docker-compose-application.yml

function build_service() {
    cd bookmark-service
    ./mvnw clean package -DskipTests
    cd ..
}

function start_infra() {
    echo "Starting infra docker containers...."
    docker-compose -f ${infrastructure} up -d
    docker-compose -f ${infrastructure} logs -f
}

function stop_infra() {
    echo "Stopping infra docker containers...."
    docker-compose -f ${infrastructure} stop
    docker-compose -f ${infrastructure} rm -f
}

function start() {
    build_service
    echo "Starting all docker containers...."
    docker-compose -f ${infrastructure} -f ${application} up --build -d
    docker-compose -f ${infrastructure} -f ${application} logs -f
}

function stop() {
    echo "Stopping all docker containers...."
    docker-compose -f ${infrastructure} -f ${application} stop
    docker-compose -f ${infrastructure} -f ${application} rm -f
}

function restart() {
    stop
    sleep 3
    start
}

action="start"

if [[ "$#" != "0"  ]]
then
    action=$@
fi

eval ${action}