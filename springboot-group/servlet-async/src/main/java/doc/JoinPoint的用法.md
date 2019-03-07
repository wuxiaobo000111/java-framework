```text


AspectJ中的切入点匹配的执行点称作连接的（Join Point），在通知方法中可以声明一个JoinPoint类型的参数。通过JoinPoint可以访问连接点的细节。下面简要介绍JponPoint的方法：
 
1.java.lang.Object[] getArgs()：获取连接点方法运行时的入参列表； 
2.Signature getSignature() ：获取连接点的方法签名对象； 
3.java.lang.Object getTarget() ：获取连接点所在的目标对象； 
4.java.lang.Object getThis() ：获取代理对象本身； 
 
ProceedingJoinPoint继承JoinPoint子接口，它新增了两个用于执行连接点方法的方法： 
 
5.java.lang.Object proceed() throws  java.lang.Throwable：通过反射执行目标对象的连接点处的方 法； 
6.java.lang.Object proceed(java.lang.Object[] args) throws java.lang.Throwable：通过反射执行目标对象连接点处的方法，不过使用新的参数替换原来的参数。

```