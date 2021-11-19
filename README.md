### K.A.N. Supunpraba.
### 18001653

## Middleware-PetStoreAssignment

## build and/or deploy the API

#### Build the project

    ./gradlew build

####  To run the application:

    java -jar build/petstore-runner.jar

####  To Run test suite

    ./gradlew test

## run a CURL/WGET command

###  Pet

View all the pets

    curl -XGET -H "Content-type: application/json" 'http://localhost:8080/v1/pets/getpets'

View a pet by id

    curl -XGET -H "Content-type: application/json" 'http://localhost:8080/v1/pets/getpets/1'

create a new pet

    curl -XPOST -H "Content-type: application/json" -d '{"petAge": 12,"petName": "Tine","petType": "Dog"}' 'http://localhost:8080/v1/pets/createpet'

Update Pet

    curl -XPUT -H "Content-type: application/json" -d '{"petAge": 4,"petId": 2,"petName": "Kity","petType": "Cat"}' 'http://localhost:8080/v1/pets/updatepet/2'
    
Delete Pet

    curl -XDELETE -H "Content-type: application/json" 'http://localhost:8080/v1/pets/deletepet/3'

Search Pet by using pet id

    curl -XGET -H "Content-type: application/json" 'http://localhost:8080/v1/pets/search?id=4'

Search Pet by using pet name

    curl -XGET -H "Content-type: application/json" 'http://localhost:8080/v1/pets/search?name=Tine'

Search Pet by using pet age

    curl -XGET -H "Content-type: application/json" 'http://localhost:8080/v1/pets/search?age=12'

###  Pet Types

View all the pet types

    curl -XGET -H "Content-type: application/json" 'http://localhost:8080/v1/pets/getpetstype'

View a pet types by id

    curl -XGET -H "Content-type: application/json" 'http://localhost:8080/v1/pets/getpetstype/2'

create a new pet types

    curl -XPOST -H "Content-type: application/json" -d '{"petTypeName": "Fish"}' 'http://localhost:8080/v1/pets/createpetsType'

update pet types

    curl -XPUT -H "Content-type: application/json" -d '{"petTypeId": 1,"petTypeName": "Cat"}' 'http://localhost:8080/v1/pets/updatepetstype/1'

delete pet types

    curl -XDELETE -H "Content-type: application/json" 'http://localhost:8080/v1/pets/deletepetstype/1'


