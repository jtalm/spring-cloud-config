HOST=$1
PORT=$2
ENDP=$3

if [ "$HOST" == "" ] || [ "$PORT" == "" ] || [ "$ENDP" == "" ]; then
	echo "The command takes 3 args: host, port and endpoint"
	exit 0
fi


until $(curl --output /dev/null --silent --head --fail $HOST:$PORT/$ENDP); do
	sleep 1
done

echo "Service ready on $HOST:$PORT/$ENDP"
