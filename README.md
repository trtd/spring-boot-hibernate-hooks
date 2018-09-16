# Hibernate pre-insert and pre-update event listeners

Simple demonstration how to integrate Hibernate preInsert and preUpdate event listeners in the Spring Boot application

Possible alternative: https://stackoverflow.com/a/16045272

## Running

    mvn package && mvn spring-boot:run

## Call service

    curl -i -X POST \
        -H "Content-Type:application/json" \
        -d \
        '{"from":"USD","to":"EUR","conversionMultiple":1.0}' \
        'http://localhost:8000/currency-exchange'
    curl -i -X PUT \
        -H "Content-Type:application/json" \
        -d \
        '{"conversionMultiple":1.1}' \
        'http://localhost:8000/currency-exchange/from/USD/to/EUR'
