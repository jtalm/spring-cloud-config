docker rm $(docker stop $(docker ps -f "label=module=support-services" --format {{.ID}}))
