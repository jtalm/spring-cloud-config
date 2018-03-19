#!/bin/bash

#Get this script folder
scriptPath=`dirname "$0"`

#Set Number of Instances
eurekaInstances=3
zuulInstances=3

#Set services ports
eurekaPorts=( "9090" "9091" "9092")
zuulPorts=( "9001" "9002" "9003")

#Start Config Server
source $scriptPath/01.StartConfigServer.sh

#Start Eureka Servers
for eurekaPortIndex in `seq 0 $eurekaInstances`
do
	source $scriptPath/02.StartEurekaServer.sh ${eurekaPorts[eurekaPortIndex]}
done

#Start Zuuls
for zuulPortIndex in `seq 0 $zuulInstances`
do
	source $scriptPath/03.StartZuul.sh ${eurekaPorts[zuulPortIndex]}
done

#Start management services
source $scriptPath/04.StartAdminServer.sh
source $scriptPath/05.StartOrdinaDashboard.sh