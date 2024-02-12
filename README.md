# Description
Create a basic full-stack application where users can enter an address in Angular.js
frontend. The Spring Boot backend should first check if the address's geolocation data
is in the database. If not, fetch it from a third-party API, store it in the database, and
then return it to the frontend. Include an option to email the geolocation results in the
frontend

### important notes
Please note that hosting is free so you may have to wait a couple of minutes for it to open : 
> Your free instance will spin down with inactivity, which can delay requests by 50 seconds or more. Upgrade now. - Render.com

# API Docs
[docmuntion](https://geolocator-app-nfcj.onrender.com/swagger-ui/index.html)

# FrontEnd
[GeoLocatorApp-Front Repo](https://github.com/IsmaelE77/GeoLocatorApp-Front)

[live preview](https://ismaele77.github.io/GeoLocatorApp-Front/)

# deploy
you can use the dockerfile from proejct or run:
```
mvn clean package
```
after that you need to add a secret file or add these variables to the environment, which contains sensitive data, so it is separated from the Spring properties file.
```yaml
 spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/geo
    username: postgres
    password: postgres
    driver-class-name: org.postgresql.Driver
  mail:
    username: "your gamil"
    password: "your password"
geolocation:
  api:
    key: "your-Key"
    url: "https://us1.locationiq.com/v1/search/structured"
```
modify it as appropriate for you
