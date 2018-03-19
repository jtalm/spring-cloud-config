#!/bin/bash

SCRIPTPATH=`dirname "$0"`

echo "Starting config-server..."
docker run -d -p 8071:8071 --net host config-server-service:latest > /dev/null
source $SCRIPTPATH/99.waitForService.sh localhost 8071 health;

echo "Starting eureka-server..."
docker run -d -p 9090:9090 --net host eureka-server-service:latest > /dev/null
source $SCRIPTPATH/99.waitForService.sh localhost 9090 health;

echo "Starting zuul..."
docker run -d -p 9001:9001 --net host zuul-service:latest > /dev/null
source $SCRIPTPATH/99.waitForService.sh localhost 9001 health;

echo "Starting admin-server..."
docker run -d -p 8072:8072 --net host admin-server-service:latest > /dev/null
source $SCRIPTPATH/99.waitForService.sh localhost 8072 health;

echo "Starting ordina-dashboard..."
docker run -d -p 8073:8073 --net host ordina-dashboard-service:latest > /dev/null
source $SCRIPTPATH/99.waitForService.sh localhost 8073 health;
