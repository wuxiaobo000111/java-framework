@[toc]

### 目标
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190120110127335.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzI1NDg0MTQ3,size_16,color_FFFFFF,t_70)
>搭建的rocketmq是两主两从，namserver有两台。
>我在我的电脑的虚拟机上安装了两台contos7的虚拟机。首先将rocketmq的二进制包传入到机器上，然后进入到这个文件夹下面（rocketmq依赖java环境，所以首先要安装好jdk）
>![在这里插入图片描述](https://img-blog.csdnimg.cn/20190120110459631.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzI1NDg0MTQ3,size_16,color_FFFFFF,t_70)
>![在这里插入图片描述](https://img-blog.csdnimg.cn/20190120110938602.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzI1NDg0MTQ3,size_16,color_FFFFFF,t_70)
>分别编辑broker-a.properties和broker-b-s.properties
>broker-a.properties中的内容是：
```properties
namesrvAddr=rocketmq.master:9876;rocketmq.slave:9876
brokerClusterName=DefaultCluster
brokerName=broker-a
brokerId=0
deleteWhen=04
fileReservedTime=48
brokerRole=ASYNC_MASTER
flushDiskType=ASYNC_FLUSH
sstorePathRootDir=/opt/logs/rocketmqmaster/store
storePathCommitLog=/opt/logs/rocketmqmaster/store/commitlog
listenPort=10000
```
>其中rocketmq.master:9876;rocketmq.slave:9876表示的是两台机器的地址。在host文件下配置一下就行了。
>broker-b-s.properties的配置信息
```properties
namesrvAddr=rocketmq.master:9876;rocketmq.slave:9876
brokerClusterName=DefaultCluster
brokerName=broker-b
brokerId=1
deleteWhen=04
fileReservedTime=48
brokerRole=SLAVE
flushDiskType=ASYNC_FLUSH
listenPort=10913
storePathRootDir=/opt/logs/rocketmqlogs/store
storePathCommitLog=/opt/logs/rocketmqlogs/store/commitlog
~
```
>上面所说的是rocketmq.master机器上的配置。同时在rocketmq.slave机器上也需要进行配置。在slave机器上配置的是broker-b.properties和broker-a-s.propertes两个文件。
>broker-b.properties配置文件的信息
```properties
namesrvAddr=rocketmq.master:9876;rocketmq.slave:9876
brokerClusterName=DefaultCluster
brokerName=broker-b
brokerId=0
deleteWhen=04
fileReservedTime=48
brokerRole=ASYNC_MASTER
flushDiskType=ASYNC_FLUSH
storePathRootDir=/opt/logs/rocketmqlogs/store
storePathCommitLog=/opt/logs/rocketmqlogs/store/commitlog
```
>broker-a-s.propertes的内容
```properties
namesrvAddr=rocketmq.master:9876;rocketmq.slave:9876
brokerClusterName=DefaultCluster
brokerName=broker-a
brokerId=1
deleteWhen=04
fileReservedTime=48
brokerRole=SLAVE
flushDiskType=ASYNC_FLUSH
listenPort=10913
storePathRootDir=/opt/logs/rocketmqslave/store
storePathCommitLog=/opt/logs/rocketmqslave/store/commitlog
listenPort=10000
```

>在master机器上启动 ./mqnamesrv & ./mqbroker -c /usr/local/java/rocketmq/conf/2m-2s-async/broker-a.properties  & ./mqbroker -c /usr/local/java/rocketmq/conf/2m-2s-async/broker-b-s.properties 
>在slave机器上启动： ./mqnamesrv & ./mqbroker -c /usr/local/java/rocketmq/conf/2m-2s-async/broker-b.properties & ./mqbroker -c /usr/local/java/rocketmq/conf/2m-2s-async/broker-a-s.properties 
>可能会报如下错误：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190120112629650.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzI1NDg0MTQ3,size_16,color_FFFFFF,t_70)
>原因不明，但是需要改个端口号就行。listenPort=10913
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190120112740657.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzI1NDg0MTQ3,size_16,color_FFFFFF,t_70)

>这个原因是因为master和slave公共了一个文件夹，修改一下，没啥难度。

>最后启动rockermq console。完美。最后附上rockermq的基本配置

```properties
#所属集群名字
brokerClusterName=rocketmq-cluster
#broker名字，注意此处不同的配置文件填写的不一样
brokerName=broker-a|broker-b
#0 表示 Master，>0 表示 Slave
brokerId=0
#nameServer地址，分号分割
namesrvAddr=rocketmq-nameserver1:9876;rocketmq-nameserver2:9876
# 在发送消息时，自动创建服务器不存在的topic，默认创建的队列数
defaultTopicQueueNums=4
# 是否允许 Broker 自动创建Topic，建议线下开启，线上关闭
autoCreateTopicEnable=true
# 是否允许 Broker 自动创建订阅组，建议线下开启，线上关闭
autoCreateSubscriptionGroup=true
# Broker 对外服务的监听端口
listenPort=10911
# 删除文件时间点，默认凌晨 4点
deleteWhen=04
#文件保留时间，默认 48 小时
fileReservedTime=120
#commitLog每个文件的大小默认1G
mapedFileSizeCommitLog=1073741824
#ConsumeQueue每个文件默认存30W条，根据业务情况调整
mapedFileSizeConsumeQueue=300000
#destroyMapedFileIntervalForcibly=120000
#redeleteHangedFileInterval=120000
#检测物理文件磁盘空间
diskMaxUsedSpaceRatio=88
#存储路径
storePathRootDir= /usr/local/rocketmq/store
#commitLog 存储路径
storePathCommitLog= /usr/local/rocketmq/store /commitlog
#消费队列存储路径存储路径
storePathConsumeQueue=/usr/local/rocketmq/store/consumequeue
#消息索引存储路径
storePathIndex=/usr/local/rocketmq/store/index
#checkpoint 文件存储路径
storeCheckpoint=/usr/local/rocketmq/store/checkpoint
#abort 文件存储路径
abortFile=/usr/local/rocketmq/store/abort
#限制的消息大小
maxMessageSize=65536
#flushCommitLogLeastPages=4
#flushConsumeQueueLeastPages=2
#flushCommitLogThoroughInterval=10000
#flushConsumeQueueThoroughInterval=60000
#Broker 的角色
#- ASYNC_MASTER 异步复制Master
#- SYNC_MASTER 同步双写Master
#- SLAVE
brokerRole=ASYNC_MASTER
#刷盘方式
#- ASYNC_FLUSH 异步刷盘
#- SYNC_FLUSH 同步刷盘
flushDiskType=ASYNC_FLUSH
#checkTransactionMessageEnable=false
#发消息线程池数量
#sendMessageThreadPoolNums=128
#拉消息线程池数量
#pullMessageThreadPoolNums=128
```

>注意，如果不是线上环境，还是修改一下java配置，在bin.runbroker.sh文件中
![在这里插入图片描述](https://img-blog.csdnimg.cn/201901201132286.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzI1NDg0MTQ3,size_16,color_FFFFFF,t_70)
>常用的几个JVM参数。不多解释。