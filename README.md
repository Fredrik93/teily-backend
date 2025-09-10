# teily-backend

#### Starting 
1. Connect to the mongdb cluster TeilyCluster (this should be automatic but the cluster might be paused)
2. Spin up spring server
3. Run post request below in terminal 

#### Kan vara bra att veta  
* Du har sparat mongos uri till intellijs Run -> Edit Configurations -> Environment variables. Utan detta så vet inte intellij vilka miljövariabler du har

#### Requests 
##### Get a teily
curl -X GET http://localhost:8080/teilys/12
##### Create a teily 
Create a teily
curl -X POST http://localhost:8080/teilys \
-H "Content-Type: application/json" \
-d '{
"task": "Clean"
}'

##### Get all teilys 
curl -X GET http://localhost:8080/teilys

##### Delete all teilys 
curl -X DELETE http://localhost:8080/teilys/all

##### Delete one teily 
curl -X DELETE http://localhost:8080/teilys/12