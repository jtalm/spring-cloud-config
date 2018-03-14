docker run -d -p 8071:8071 --net host config-server-service:latest
docker run -d -p 9090:9090 --net host eureka-server-service:latest
docker run -d -p 9001:9001 --net host zuul-service:latest
docker run -d -p 8072:8072 --net host admin-server-service:latest
docker run -d -p 8073:8073 --net host ordina-dashboard-service:latest

