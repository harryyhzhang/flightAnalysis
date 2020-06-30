docker rm testbed-master
docker rm testbed-slave-1
docker rm testbed-slave-2
docker rm testbed-slave-3
docker network create  --driver bridge    --subnet=192.168.33.0/24    --gateway=192.168.33.10   --opt "com.docker.network.bridge.name"="docker1"  shared_nw 
docker-compose -f ./env/docker-compose_rstudioserver2.yml up -d 
