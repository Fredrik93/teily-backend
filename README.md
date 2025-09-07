# teily-backend

#### Requests 
Get a teily
curl -X GET http://localhost:8080/teily/1

Create a teily
curl -X POST http://localhost:8080/teilys \
-H "Content-Type: application/json" \
-d '{
"id": "12",
"name": "John"
}'
