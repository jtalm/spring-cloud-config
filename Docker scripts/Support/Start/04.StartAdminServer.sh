#!/bin/bash

#Generate random uuid
uuid=$(uuidgen)

#UUID
uuid=${uuid,,}

#Start Container
echo "Starting admin-server..."
docker run --name admin-server-${uuid} -d -p 8072:8072 --net host admin-server-service:latest

#Check for service availability
source $SCRIPTPATH/99.waitForService.sh localhost 8072 health;