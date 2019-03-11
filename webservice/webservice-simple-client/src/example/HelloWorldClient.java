package example;

import mypackage.HelloWorldService;

public class HelloWorldClient {
  public static void main(String[] argv) {
      mypackage.HelloWorld service = new HelloWorldService().getHelloWorldPort();
      //invoke business method
      System.out.println(service.sayHelloWorldFrom("wuxiaobo"));
  }
}
