# Cloud Service

- 사전 작업

  - mqtt 설치
  - .yml에 mqtt broker의 url 정보 및 topic 정보 추가
  
- Maven build (빌드)

  - Dev
    
    - mvn clean package
    
  - Local
    
    - mvn clean package
    
  - Shell script 사용

    - 해당 폴더 내에서 cloud_service 최상위 폴더 git pull (Id: IoTKETI pw:keti12#)

      ```shell
      $ git pull
      $ ./depoly-cloud
      ```

- 실행

  - java -jar cloudserver-0.0.1-SNAPSHOT.jar
  
- Config (설정)

  - src/main/resources/ 하위

  - Application.yml

  - 목록

    | property                                             | Sample               | Description                             |
    | ---------------------------------------------------- | -------------------- | ----------------------------------------|
    | server.portspring.jackson.default-property-inclusion | NON_EMPTY            | 정보 반환시 null을 가진 필드는 반환하지 않음트정보 |
    | mqtt.broker.url                                      | tcp://localhost:1883 | mqtt broker url 정보                     |
    | mqtt.broker.topic                                    | cloud                | topic 정보                               |
    
    
