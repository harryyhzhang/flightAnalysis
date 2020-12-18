cp ./target/scala-2.11/flightanalysis_2.11-0.1.jar ./data/
#docker exec -it testbed-master hadoop fs -put ./data/flights /
#docker exec -it testbed-master hadoop fs -put -p ./data/airlines.csv /data/
docker exec -it testbed-master spark-submit --class org.runStatistics \
    --master yarn  \
    --deploy-mode cluster \
    --num-executors 1 \
    --driver-memory 1g \
    --executor-memory 1g \
    --executor-cores 1 \
    /data/flightanalysis_2.11-0.1.jar
