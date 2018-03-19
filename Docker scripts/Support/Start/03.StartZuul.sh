#!/bin/bash

#Generate random uuid
uuid=$(uuidgen)

#UUID
uuid=${uuid,,}

#Start Container
echo "Starting zuul..."
docker run --name zuul-${uuid} -d -p 9001:9001 --net host zuul-service:latest

#Check for service availability
source $SCRIPTPATH/99.waitForService.sh localhost 9001 health;