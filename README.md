# bookmark-application

### Build Docker Image using Spring-Boot Maven Plugin
`
./mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=madhurtoppo/bookmark-service
`
### Run Docker Container
`
docker run -p 8080:8080 madhurtoppo/bookmark-service
`