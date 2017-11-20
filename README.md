# taxcalculator

mvn spring-boot:run

curl -X POST --header "Content-Type: application/json" http://localhost:8080/taxcalculator/ -d @input1.json
curl -X POST --header "Content-Type: application/json" http://localhost:8080/taxcalculator/ -d @input2.json
curl -X POST --header "Content-Type: application/json" http://localhost:8080/taxcalculator/ -d @input3.json
