#!/bin/bash

#Get this script folder
SCRIPTPATH=`dirname "$0"`

#Generate random uuid
uuid=$(uuidgen)

#Container Name
containerName="eureka-server-${uuid,,}"

#Start Container
echo "Instantiating new Eureka-Server on container: ${containerName}"
docker run --name ${containerName} -d -p 9090:9090 --net host eureka-server-service:latest

#Check for service availability
source $SCRIPTPATH/99.waitForService.sh localhost 9090 health;