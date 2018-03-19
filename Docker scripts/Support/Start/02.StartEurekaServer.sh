#!/bin/bash

#Get this script folder
scriptPath=`dirname "$0"`

#Generate random uuid
uuid=$(uuidgen)

#Container Name
containerName="eureka-server-${uuid,,}"

#Container binding port (defaults to 9090)
containerPort=$1
if [ "$containerPort" == "" ]; then
	containerPort=9090;
fi

#Start Container
echo "Instantiating new Eureka-Server on container: ${containerName}"
echo "Port is set to $containerPort"
docker run --name ${containerName} -d -p $containerPort:9090 --net host eureka-server-service:latest

#Check for service availability
source $scriptPath/99.waitForService.sh localhost $containerPort health;