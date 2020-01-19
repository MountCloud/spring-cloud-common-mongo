# USE 使用
```
Application Main class add
@ComponentScan(basePackages={"you project package","org.mountcloud.springcloud"})
```
##  USE spring cloud common ，使用spring cloud common方式
```
<parent>
  <groupId>org.mountcloud</groupId>
  <artifactId>spring-cloud-common-parent</artifactId>
  <version>2.2.1.RELEASE-Hoxton.RELEASE-1.1</version>
</parent>
<dependency>
  <groupId>org.mountcloud</groupId>
  <artifactId>spring-cloud-common-mongo</artifactId>
</dependency>
```
## OR Use alone，或者单独引用。
```
<dependency>
  <groupId>org.mountcloud</groupId>
  <artifactId>spring-cloud-common-mongo</artifactId>
  <version>1.1</version>
</dependency>
```

# Description
   The main function is to implement Spring cloud common, which provides mongodb components for spring cloud common, which simplifies the use cost of mongodb and increases the connection pool of mongodb.
 
# How to use
   The configuration of mongo is the same as that of spring boot and spring cloud.
  
   After referencing the project, the mongo function will be enabled. If you need to use the mongo connection pool, you need to:
```
Use @EnableMongoConnectionPool to enable mongo connection pool function and configure:

mongo:
    connectionsPerHost: 20
    connectTimeout: 50000
    heartbeatConnectTimeout: 15000
    maxConnectionIdleTime: 45000
    maxConnectionLifeTime: 0
    minConnectionsPerHost: 5
    requiredReplicaSetName: #ReplicaSet
    minHeartbeatFrequency: 10000
    heartbeatSocketTimeout: 0
    socketKeepAlive: true
    threadsAllowedToBlockForConnectionMultiplier: 10
```

# 描述
  主要功能是实现了Spring cloud common，为spring cloud common提供了mongodb的组件，简化mongodb的使用成本，增加了mongodb的连接池。
 
# 使用方式
  mongo配置与spring boot、spring cloud的配置方式一样。
  
  引用项目后会开启mongo功能，如果需要使用mongo连接池则需要：
```
使用@EnableMongoConnectionPool开启mongo连接池功能，并且配置：

mongo:
   connectionsPerHost: 20
   connectTimeout: 50000
   heartbeatConnectTimeout: 15000
   maxConnectionIdleTime: 45000
   maxConnectionLifeTime: 0
   minConnectionsPerHost: 5
   requiredReplicaSetName:    #ReplicaSet 有就填没有则不填
   minHeartbeatFrequency: 10000
   heartbeatSocketTimeout: 0
   socketKeepAlive: true
   threadsAllowedToBlockForConnectionMultiplier: 10
```

# Files 文件列表
```
.
├── .gitignore
├── pom.xml
├── README.md
└── src
    ├── main
    │   ├── java
    │   │   └── org
    │   │       └── mountcloud
    │   │           └── springcloud
    │   │               └── common
    │   │                   └── mybatis
    │   │                       ├── config
    │   │                       │   ├── JdbcConfig.java
    │   │                       │   ├── MyBatisMapperScannerConfig.java
    │   │                       │   └── MyBatisPropertyConfig.java
    │   │                       ├── dao
    │   │                       │   └── BaseDao.java
    │   │                       ├── EnableMyBatis.java
    │   │                       ├── entity
    │   │                       │   └── BaseExample.java
    │   │                       ├── mapper
    │   │                       │   └── BaseMapper.java
    │   │                       ├── property
    │   │                       │   └── MyBatisProperty.java
    │   │                       └── service
    │   │                           └── BaseMybatisService.java
    │   └── resources
    │       └── META-INF
    │           └── spring.factories
    └── test
        └── java
            └── org
                └── mountcloud
                    └── springcloud
                        └── common
                            └── mybatis
                                └── util
                                    └── TestClass.java
```
