#!/bin/bash

#Generate random uuid
uuid=$(uuidgen)

#UUID
uuid=${uuid,,}

#Start Container
echo "Starting ordina-dashboard..."
docker run --name ordina-dashboard-${uuid} -d -p 8073:8073 --net host ordina-dashboard-service:latest

#Check for service availability
source $SCRIPTPATH/99.waitForService.sh localhost 8073 health;