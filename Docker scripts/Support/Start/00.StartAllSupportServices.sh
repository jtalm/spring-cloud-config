#!/bin/bash

#Get this script folder
SCRIPTPATH=`dirname "$0"`

#Execute start scripts for each support service
source $SCRIPTPATH/01.StartConfigServer.sh
source $SCRIPTPATH/02.StartEurekaServer.sh
source $SCRIPTPATH/03.StartZuul.sh
source $SCRIPTPATH/04.StartAdminServer.sh
source $SCRIPTPATH/05.StartOrdinaDashboard.sh