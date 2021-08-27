# modular-monolith-helloworld
A hello world style example of a [producer](https://github.com/bertilmuth/modular-monolith-helloworld/blob/main/producer/src/main/java/com/example/monolith/producer/behavior/ProducerBehaviorModel.java) and [consumer](https://github.com/bertilmuth/modular-monolith-helloworld/blob/main/consumer/src/main/java/com/example/monolith/consumer/behavior/ConsumerBehaviorModel.java) communicating via a [connector](https://github.com/bertilmuth/modular-monolith-helloworld/blob/main/connector/src/main/java/com/example/monolith/consumer/behavior/ProducerConsumerConnector.java), using an event bus. The event bus sends and receives events asynchronously.

Each module is contained in its own Gradle project.
Apart from `main` and `connector`, the modules have no dependencies.

This modular style of development potentially has the following benefits:
* The modules mark *team boundaries*. Each team can work on its own data and behavior, hardly affected by the work of other teams. That can reduce the time to market of development teams.
* Isolating the modules *reduces cognitive load*. A developer no longer needs to understand the whole application, but only the module she works on.
* 
