# java-framework
java开源框架

>项目列表

>&nbsp;&nbsp;&nbsp;&nbsp;因为这个项目中的项目极多。所在这这里建立一个项目列表用来说明
项目中的每一个子项目的作用。

| 项目名称  | 项目说明 |
|---|---|
|eureka-server   |  eureka的服务端。spring cloud其他组件使用的eureka集群模式,所以这个项目基本上没有使用  |
|feign-eureka-producer        | eureka作为注册中心,feign组件的服务端    |
|feign-eureka-consumer|eureka作为注册中心,feign组件的消费端。和feign-eureka-producer配合使用|
|feign-eureka-hystrix-producer|eureka作为注册中心,feign组件的服务端,同时feign和Hystrix结合使用|
|feign-eureka-hystrix-consumer|eureka作为注册中心,feign组件的服务端,同时feign和Hystrix结合使用的消费端,和feign-eureka-hystrix-producer配合使用|
|hystrix-eureka-demo|eureka作为注册中心,Hystrix的简单小例子|
|hystrix-eureka-turbine|eureka作为注册中心,hystrix和turbine组合使用|
|hystrix-eureka-exception|eureka作为注册中心，Hystrix的异常说明|
|hystrix-eureka-cache|eureka作为注册中心，Hystrix的缓存使用
|hystrix-eureka-cache-producer|eureka作为注册中心,Hystrix使用缓存的服务端|
|hystrix-eureka-collasper|eureka作为注册中心,Hystrix请求合并|
|hystrix-eureka-thread|eureka作为注册中心,Hystrix线程传递|
