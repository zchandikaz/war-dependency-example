mvn clean install
docker-compose up &

until $(curl --output /dev/null --silent --head --fail http://localhost:8081); do
    printf '.'
    sleep 5
done

curl -X POST http://127.0.0.1:8081/child-war/