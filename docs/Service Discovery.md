Spring Boot Microservice Full Project From Sctrach Implementation Notes
1. Model Mapper Dependency why it is used in the spring boot

What is Service Discovery ?
-> It acts as a registry in which addresses of all the instances are tracked.
-> Service Discovery helps us to know where each instances are located
-> Service Discovery helps us to know whether the services are down or up.
-> While communicating with different microservices, each services requires IP address and PORT of
other. Hence we need Service Discovery.
-> While communication with other microservice, we can use SERVICE NAME instead of Host and Port

Properties of Eureka Server:
eureka.client.register-with-eureka=false

# By default, every service(including the Eureka Server itself) tries to register itself with a Eureka Server.
# Setting this to false means this application will not register itself as a client.
# Example: If you are running a Eureka Server, you don't want the server to register itself into it's own registry

eureka.client.fetch.registry=false

# Normally, Eureka Clients fetch the registry (list of all registered services) from the Eureka Server So they can
Discover other services.
# Setting this to false means this application will try to fetch any service registry.

eureka.client.serviceUrl.defaultZone=https://localhost:8761/eureka

#Defines the Eureka Server URL where clients should register themselves or fetch registry info from.

eureka.instance.hostname=localhost

# Defines the hostnames that will be registered with Eureka for this service.
# Other services will use this hostname when they want to call this service.

