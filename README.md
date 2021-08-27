# modular-monolith-helloworld
A hello world style example of a [producer](https://github.com/bertilmuth/modular-monolith-helloworld/blob/main/producer/src/main/java/com/example/monolith/producer/behavior/ProducerBehaviorModel.java) and [consumer](https://github.com/bertilmuth/modular-monolith-helloworld/blob/main/consumer/src/main/java/com/example/monolith/consumer/behavior/ConsumerBehaviorModel.java) communicating via a [connector](https://github.com/bertilmuth/modular-monolith-helloworld/blob/main/connector/src/main/java/com/example/monolith/consumer/behavior/ProducerConsumerConnector.java), using an event bus. The event bus sends and receives events asynchronously.

Each module is contained in its own Gradle project.
Apart from `main` and `connector`, the modules have no dependencies.

This modular style of development potentially has the following benefits:
* The modules mark *team boundaries*. Each team can work on its own data and behavior, hardly affected by the work of other teams. That can reduce the time to market of development teams.
* Isolating the modules *reduces cognitive load*. A developer no longer needs to understand the whole application, but only the module she works on.
* Reducing the dependencies avoids the dreaded *big ball of mud*, and makes the application in general more maintainable. In particular, it avoids cyclic dependencies between parts of the application.

This modular style has the following downsides:
* It leads to *eventual consistency*. Since the modules communicate asynchronously, there is no guarantee for immediate consistency of data between modules.
* More effort for *reliable messaging*. In a real world application, it must be made sure that no events get lost. This complicates the infrastructure logic.

# Getting started
1. Clone the project
2. Change directory to `modular-monolith-helloworld`
3. In one windows, run the server with `./gradlew :main:bootRun`
4. In another window, send a POST request with:

`curl -H "Content-Type: application/json" -X POST -d '{"@type": "RequestGreeting", "userName":"Sandra"} http://localhost:8080/producer` (Unix)

`iwr http://localhost:8080/producer -Method 'POST' -Headers @{'Content-Type' = 'application/json'} -Body '{"@type": "RequestGreeting", "userName":"Sandra"}` (Windows)
