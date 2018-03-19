#!/bin/bash

#Get this script folder
scriptPath=`dirname "$0"`

#Generate random uuid
uuid=$(uuidgen)

#Container Name
containerName="ordina-dashboard-${uuid,,}"

#Start Container
echo "Instantiating new Ordina-Dashboard on container: ${containerName}"
docker run --name ${containerName} -d -p 8073:8073 --net host ordina-dashboard-service:latest

#Check for service availability
source $scriptPath/99.waitForService.sh localhost 8073 health;