# Twittard 
Sample Microservice Cloud Application

## List of Service
- config-service
- discovery-service
- gateway-service
- comment-service
- tweet-service

## How to run?
Because the services depend on remote config, `config-service` must run first than the other services.

1. Build the application
    ```shell
    mvn clean install
    ```

2. Run service,
   assumed we are in root directory of project `/twittard`.
    
    config-service
    
    ```shell
    java -jar config-service/target/config-service-0.0.1-SNAPSHOT.jar
    ```

    discover-service

    ```shell
    java -jar discovery-service/target/discovery-service-0.0.1-SNAPSHOT.jar
    ```

    comment-service

    ```shell
    java -jar comment-service/target/comment-service-0.0.1-SNAPSHOT.jar
    ```
    tweet-service   

    ```shell
    java -jar tweet-service/target/tweet-service-0.0.1-SNAPSHOT.jar
    ```
   
    gateway-service

    ```shell
    java -jar gateway-service/target/gateway-service-0.0.1-SNAPSHOT.jar
    ```


## Project stack/feature detail

- **SPRING BOOT** `v2.5.14`
   
   In this version each library seems more stable and not much bug/break changes to each other libs.

- **SPRING CLOUD** `v2020.0.5`

   To match spring boot version

- **JAVA** `jdk17`

   Because the project itself is for demo purposed, then I use the newest LTS version of JDK.

```
For sake of simplicity services developed in maven multi module and stored in git monorepo 
```


| Module/Feature         | INCLUDE | DETAIL                                       |
|------------------------|---------|----------------------------------------------|
| Spring Cloud Config    | YES     | to centralized config of service/application |
| Spring Cloud Eureka    | YES     | Service discovery/registry                   |
| Spring Cloud Gateway   | YES     | gateway                                      |
| Spring Cloud OpenFeign | YES     | http client                                  |
| Spring Data REST       | YES     | to simplify/auto generate CRUD               |
| Swagger                | YES     | auto generate api documentation              |
| Spring Security OAuth  | NO      | security                                     |
| Unit Testing           | NO      | automate testing                             |

## Swagger endpoints

**COMMENT-SERVICE** swagger
- http://localhost:9090/v2/api-docs
- http://localhost:9090/swagger-ui/

**TWEET-SERVICE** swagger
- http://localhost:8080/v2/api-docs
- http://localhost:8080/swagger-ui/

**USER-SERVICE** swagger
- http://localhost:7070/v2/api-docs
- http://localhost:7070/swagger-ui/

## Demo http request (Gateway)

```
NOTE:
For the sake of simplicity, then
1. In comment-service the database used is H2 in memory database, so the data will not persisted to disk, or the data will be lost if the application terminated.
2. In tweet-service the data is not store to any of database, the data is in memory in code(hard-coded), so the data will remain same, everytime the application is run.
```

### 1. Create Comment

*Request*
```shell
curl --location --request POST 'localhost/comments' \
--header 'Content-Type: application/json' \
--data-raw '{
   "tweetId": 1,
   "userId": 1,
   "content": "Monrning!"
}'
```
*Response*
```json
{
    "id": 1,
    "userId": 1,
    "tweetId": 1,
    "content": "Monrning!",
    "_links": {
        "self": {
            "href": "http://192.168.245.112:9090/comments/1"
        },
        "comment": {
            "href": "http://192.168.245.112:9090/comments/1"
        }
    }
}
```

### 2. Get Comments
*Request*
```shell
curl --location --request GET 'localhost/comments'
```
*Response*
```json
{
    "_embedded": {
        "comments": [
            {
                "userId": 1,
                "tweetId": 1,
                "content": "Morning!",
                "_links": {
                    "self": {
                        "href": "http://192.168.245.112:9090/comments/1"
                    },
                    "comment": {
                        "href": "http://192.168.245.112:9090/comments/1"
                    }
                }
            }
        ]
    },
    "_links": {
        "self": {
            "href": "http://192.168.245.112:9090/comments"
        },
        "profile": {
            "href": "http://192.168.245.112:9090/profile/comments"
        }
    },
    "page": {
        "size": 20,
        "totalElements": 1,
        "totalPages": 1,
        "number": 0
    }
}
```

### 3. Get Tweet
*Request*
```shell
curl --location --request GET 'localhost/tweets/1'
```
*Response*
```json
{
    "id": 1,
    "userId": 1,
    "content": "Hello, Good Morning!",
    "comments": [
        {
            "id": 1,
            "userId": 1,
            "tweetId": 1,
            "content": "Monrning!"
        }
    ]
}
```

### 4. Get Tweets
*Request*
```shell
curl --location --request GET 'localhost/tweets?userId=1'
```
*Response*
```json
[
    {
        "id": 1,
        "userId": 1,
        "content": "Hello, Good Morning!"
    },
    {
        "id": 2,
        "userId": 1,
        "content": "Hello, Good Afternoon!"
    },
    {
        "id": 3,
        "userId": 1,
        "content": "Hello, Good Evening!"
    }
]
```