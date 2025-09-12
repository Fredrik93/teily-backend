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
curl -X DELETE http://localhost:8080/teilys/636b39d8-21fe-476f-8556-315f2f4aa424
#### Toggle a teily as completed / not completed 
curl -X PATCH http://localhost:8080/teilys/636b39d8-21fe-476f-8556-315f2f4aa424


### Docker 
##### Build an image
docker build -t teily-backend . 
##### Run a container (since you have a .env file you need to run this from root teily-backend project)
docker run --env-file .env -p 8080:8080 teily-backend:latest
##### Run a container detached mode (it runs until you type docker stop <container> in the terminal)
docker run -d --env-file .env -p 8080:8080 --name teily-backend teily-backend:latest
##### View logs realtime in docker container 
1. start the docker container and run following command in the terminal from project root 
docker logs -f teily-backend


#### Render (deployed backend docker image)
This is a saas service that allow me to deploy my docker image that i created above. i needed to push the image to docker registry first. 
Just replace localhost:8080 url with backend https://teily-backend.onrender.com

e.g., 
##### Get all teilys 
curl -X GET https://teily-backend.onrender.com/teilys
##### Create a teily 
curl -X POST https://teily-backend.onrender.com/teilys \
-H "Content-Type: application/json" \
-d '{
"task": "Cleaning"
}'
