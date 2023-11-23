# Serialization_Issue

Ensure that you have a local 9.15.3+ system running locally.

```
start locator --name=locator1
configure pdx --auto-serializable-classes=org.springframework.data.gemfire.serialization.Order --read-serialized=true
start server --name=server1
list members
create region --name=Orders --type=REPLICATE
```

In the code there is a client `SpringBootClient`

The `SpringBootClient` is configured to use both `MappingPdxSerializer` and `ReflectionBasedAutoSerializer`. Which serialization is used is selected in the `application.properties` file.
By defaut the `MappingPdxSerializer` is used, but can be changed by (un)commenting the lines. 

```
spring.profiles.active=MappingPdxSerializer
#spring.profiles.active=ReflectionBasedAutoSerializer
```
This app also starts a REST endpoint. `localhost:8080/order`. Using a post command with a request body of:
```
{
  "orderId": "150",
  "settlementInstruction": "settle"
}
``` 

