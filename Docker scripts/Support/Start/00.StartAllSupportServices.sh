#!/bin/bash

#Get this script folder
SCRIPTPATH=`dirname "$0"`

#Set Number of Instances
EUREKAINSTACES=3
ZUULINSTANCES=2

#Start Config Server
source $SCRIPTPATH/01.StartConfigServer.sh

#Start Eureka Servers
source $SCRIPTPATH/02.1.StartFirstEurekaServer.sh

if [ "$EUREKAINSTACES" -le 2]; then
	source $SCRIPTPATH/02.2.StartSecondEurekaServer.sh
fi

if [ "$EUREKAINSTACES" -le 3]; then
	source $SCRIPTPATH/02.3.StartThirdEurekaServer.sh
fi

#Start Zuuls
source $SCRIPTPATH/03.1.StartFirstZuul.sh

if [ "$ZUULINSTACES" -le 2]; then
source $SCRIPTPATH/03.2.StartSecondZuul.sh
fi

#Start management services
source $SCRIPTPATH/04.StartAdminServer.sh
source $SCRIPTPATH/05.StartOrdinaDashboard.sh