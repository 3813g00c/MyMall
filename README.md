# MyMall
学习开源项目Mall
# vhr/mall笔记
## RabbitMQ
* 后台管理地址：http://localhost:15672/#/
* 默认用户名密码：guest/guest
## Redis
### Redis服务器基本配置
https://blog.csdn.net/hzlarm/article/details/99432240

启动客户端：redis-cli -a password

## 开发
### resulttype和resultmap的区别

## 注解
### @JsonFormat与@DateTimeFormat注解的使用 
从数据库获取时间传到前端进行展示的时候，我们有时候可能无法得到一个满意的时间格式的时间日期，在数据库中显示的是正确的时间格式，获取出来却变成了很丑的时间戳，@JsonFormat注解很好的解决了这个问题，我们通过使用@JsonFormat可以很好的解决：后台到前台时间格式保持一致的问题，其次，另一个问题是，我们在使用WEB服务的时，可能会需要用到，传入时间给后台，比如注册新用户需要填入出生日期等，这个时候前台传递给后台的时间格式同样是不一致的，而我们的与之对应的便有了另一个注解，@DataTimeFormat便很好的解决了这个问题

### JSON转换错误
错误信息：Could not write JSON: (was java.lang.NullPointerException); nested exception is com.faster
原因：字段与实体类不相符
解决办法：对应实体类的熟悉加@JsonIgnore

## Get接受参数
### 参数在路径中 @PathVariable
1. 假设请求地址是如下这种 RESTful 风格，hangge 这个参数值直接放在路径里面：
```url
http://localhost:8080/hello/hangge
```
2. Controller 可以这么获取该参数：  
```java
package com.example.demo;
 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
 
@RestController
public class HelloController {
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        return "获取到的name是：" + name;
    }
}
```
### 参数跟在 ? 号后面
#### 获取参数的基本方法
1. 假设请求地址是如下这种传统方式，参数跟在问号后面：
```url
http://localhost:8080/hello?name=hangge
```
2. Controller 可以这么获取该参数：
```java
package com.example.demo;
 
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
 
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name) {
        return "获取到的name是：" + name;
    }
}
```
详情：https://www.hangge.com/blog/cache/detail_2484.html