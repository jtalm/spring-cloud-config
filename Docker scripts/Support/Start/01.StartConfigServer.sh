#!/bin/bash

#Get this script folder
scriptPath=`dirname "$0"`

#Generate random uuid
uuid=$(uuidgen)

#Container Name
containerName="config-server-${uuid,,}"

#Start Container
echo "Instantiating new Config-Server on container: ${containerName}"
docker run --name ${containerName} -d -p 8071:8071 --net host config-server-service:latest

#Check for service availability
source $scriptPath/99.waitForService.sh localhost 8071 health;
