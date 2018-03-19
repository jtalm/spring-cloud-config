#!/bin/bash

#Get this script folder
scriptPath=`dirname "$0"`

#Generate random uuid
uuid=$(uuidgen)

#Container Name
containerName="config-server-${uuid,,}"

#Start Container
echo "Instantiating new Config-Server on container: ${containerName}"
docker run --name ${containerName} -d -p 8072:8072 --net host admin-server-service:latest

#Check for service availability
source $scriptPath/99.waitForService.sh localhost 8072 health;