#!/bin/bash

#Get this script folder
scriptPath=$(dirname "$0")

#Set Number of Instances
eurekaInstances=3
zuulInstances=3

#Get startup type
startType=$1
if [ "$startType" == "local" ]; then
	eurekaInstances=1
	zuulInstances=1
fi

#Set services ports
eurekaPorts=( "9090" "9091" "9092")
zuulPorts=( "9001" "9002" "9003")

#Start Config Server
source $scriptPath/01.StartConfigServer.sh

#Start Eureka Servers
for eurekaPortIndex in $(seq 0 $(($eurekaInstances - 1)) )
do
	source $scriptPath/02.StartEurekaServer.sh ${eurekaPorts[eurekaPortIndex]}
done

#Start Zuuls
for zuulPortIndex in $(seq 0 $(($eurekaInstances - 1)) )
do
	source $scriptPath/03.StartZuul.sh ${zuulPorts[zuulPortIndex]}
done

#Start management services
source $scriptPath/04.StartAdminServer.sh
source $scriptPath/05.StartOrdinaDashboard.sh
