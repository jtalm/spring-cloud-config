#!/bin/bash

#Get this script folder
SCRIPTPATH=`dirname "$0"`

#Generate random uuid
uuid=$(uuidgen)

#Container Name
containerName="zuul-${uuid,,}"

#Start Container
echo "Instantiating new Zuul on container: ${containerName}"
docker run --name ${containerName} -d -p 9002:9001 --net host zuul-service:latest

#Check for service availability
source $SCRIPTPATH/99.waitForService.sh localhost 9002 health;