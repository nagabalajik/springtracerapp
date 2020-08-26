## Running
./mvnw spring-boot:run

## Application:
Listens on port 8080

## How to see traces:
Run Jaeger All-in-one
```
docker run -d --name jaeger \
     -e COLLECTOR_ZIPKIN_HTTP_PORT=9411 \
     -p 5775:5775/udp \
     -p 6831:6831/udp \
     -p 6832:6832/udp \
     -p 5778:5778 \
     -p 16686:16686 \
     -p 14268:14268 \
     -p 14250:14250 \
     -p 9411:9411 \
     jaegertracing/all-in-one:1.18
```
Access Jaeger UI: http://localhost:16686

