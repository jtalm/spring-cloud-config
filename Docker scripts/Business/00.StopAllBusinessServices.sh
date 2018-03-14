docker rm $(docker stop $(docker ps -f "label=module=business-services" --format {{.ID}}))
