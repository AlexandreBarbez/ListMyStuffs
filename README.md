# Minimalist lifestyle

L'objectif du projet est de mettre en place une app permettant de lister toute mes possessions terrestres #GuruLifeStyle #Minimalist

### Technos ? :
- SpringBoot
- JPA (Hibernate ORM)
- postgresSql

### Pourquoi ce projet ? :
- Pour bosser les API RESTful via SpringBoot
- Pour créer un outil me servant a lister mes objets, objectif que je me suis fixé


### Quoi de beau ? :
- Lombok ma gueule !! c'est trop fort !!! @Data ou @SLF4J, c'est vraiment surpuissant ! On peut installer un plugin sur Intelij pour gérer le bousin, ca pète le feu !!

### Curl :

C(reate) with POST
>curl -X POST localhost:8080/stuffs -H 'Content-type:application/json' -d '{"nom":"test","description":"testDescri","quantite":"12","prix":"42"}'

R(ead) with GET
> curl -v localhost:8080/stuffs  
> curl -v localhost:8080/stuffs/1

U(pdate) with PUT
>curl -X PUT localhost:8080/stuffs/2 -H 'Content-type:application/json' -d '{"nom":"test","description":"testDescri","quantite":"42","prix":"42"}'  

D(elete) with DELETE
>curl -X DELETE localhost:8080/stuffs/2

## Dockerisation :

Commandes docker utiles en local:
>- docker container ls
>- docker images
>- docker rmi --force

Creer l'image en local et la push
>- docker logs mystuffs
>- docker build -t halx/mystuffs .
>- docker tag halx/mystuffs halx/mystuffs
>- docker login
>- docker push halx/mystuffs

Depuis le serveur, recup image et run
>- docker pull halx/mystuffs
>- docker-compose up -d


Pour debug, ou juste accéder au conteneur : 

> - docker exec -it nomDuContainer /bin/bash (ou /bin/sh si c'est pas dispo) 