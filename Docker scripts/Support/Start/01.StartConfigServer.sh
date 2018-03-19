#!/bin/bash

#Get this script folder
SCRIPTPATH=`dirname "$0"`

#Generate random uuid
uuid=$(uuidgen)

#UUID
uuid=${uuid,,}

#Start Container
echo "Starting config-server..."
docker run --name config-server-${uuid} -d -p 8071:8071 --net host config-server-service:latest

#Check for service availability
source $SCRIPTPATH/99.waitForService.sh localhost 8071 health;