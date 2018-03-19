#!/bin/bash

#Generate random uuid
uuid=$(uuidgen)

#UUID
uuid=${uuid,,}

#Start Container
echo "Starting eureka-server..."
docker run --name eureka-server-${uuid} -d -p 9090:9090 --net host eureka-server-service:latest

#Check for service availability
source $SCRIPTPATH/99.waitForService.sh localhost 9090 health;