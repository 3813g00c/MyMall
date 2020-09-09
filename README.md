# vhr/mall笔记

[toc]

## RabbitMQ

* 后台管理地址：<http://localhost:15672/#/>
* 默认用户名密码：guest/guest

## Redis

### Redis服务器基本配置

<https://blog.csdn.net/hzlarm/article/details/99432240>

启动客户端：redis-cli -a password\
docker: docker exec -it redis /bin/bash

* KEYS *：返回所有key

## 开发

### resulttype和resultmap的区别

### java反射之Method的invoke方法实现

<https://www.cnblogs.com/qingchen521/p/8575761.html>

## 注解

### @JsonFormat与@DateTimeFormat注解的使用

从数据库获取时间传到前端进行展示的时候，我们有时候可能无法得到一个满意的时间格式的时间日期，在数据库中显示的是正确的时间格式，获取出来却变成了很丑的时间戳，@JsonFormat注解很好的解决了这个问题，我们通过使用@JsonFormat可以很好的解决：后台到前台时间格式保持一致的问题，其次，另一个问题是，我们在使用WEB服务的时，可能会需要用到，传入时间给后台，比如注册新用户需要填入出生日期等，这个时候前台传递给后台的时间格式同样是不一致的，而我们的与之对应的便有了另一个注解，@DataTimeFormat便很好的解决了这个问题

### lombok@EqualsAndHashCode()注解详解

* 此注解会生成equals(Object other) 和 hashCode()方法
* 它默认使用非静态，非瞬态的属性
* 可通过参数exclude排除一些属性
* 可通过参数of指定仅使用哪些属性
* 它默认仅使用该类中定义的属性且不调用父类的方法
* 可通过callSuper=true解决上一点问题。让其生成的方法中调用父类的方法

    **@Data相当于@Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode这5个注解的合集**

    <https://blog.csdn.net/zhanlanmg/article/details/50392266>

### JSON转换错误

错误信息：Could not write JSON: (was java.lang.NullPointerException); nested exception is com.faster
原因：字段与实体类不相符
解决办法：对应实体类的熟悉加@JsonIgnore

### @Transactional

<https://www.cnblogs.com/xd502djj/p/10940627.html>

定义:**数据库事务是构成单一逻辑工作单元的操作集合**
一个典型的数据库事务如下所示

```sql
BEGIN TRANSACTION  //事务开始
SQL1
SQL2
COMMIT/ROLLBACK   //事务提交或回滚
```

关于事务的定义有几点需要解释下：

1. 数据库事务可以包含一个或多个数据库操作,但这些操作构成一个逻辑上的整体
2. 构成逻辑整体的这些数据库操作,要么全部执行成功,要么全部不执行。
3. 构成事务的所有操作,要么全都对数据库产生影响,要么全都不产生影响,即不管事务是否执行成功,数据库总能保持一致性状态。
4. 以上即使在数据库出现故障以及并发事务存在的情况下依然成立。

<https://www.cnblogs.com/takumicx/p/9998844.html>

## Get接受参数

### 参数在路径中 @PathVariable

1. 假设请求地址是如下这种 RESTful 风格，hangge 这个参数值直接放在路径里面：

```url
http://localhost:8080/hello/hangge
```

2.Controller 可以这么获取该参数：

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

2.Controller 可以这么获取该参数：

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

### @Transactional

* 将@Transactional 注解添加到合适的方法上，并设置合适的属性信息，@Transactional 注解的属性信息

|属性名|说明|
|----|----|
|name|当在配置文件中有多个 TransactionManager , 可以用该属性指定选择哪个事务管理器。|
|propagation| 事务的传播行为，默认值为 REQUIRED。|
|isolation|事务的隔离度，默认值采用 DEFAULT。|
|timeout|事务的超时时间，默认值为-1。如果超过该时间限制但事务还没有完成，则自动回滚事务。|
|read-only|指定事务是否为只读事务，默认值为 false；为了忽略那些不需要事务的方法，比如读取数据，可以设置 read-only 为 true。|
|rollback-for|用于指定能够触发事务回滚的异常类型，如果有多个异常类型需要指定，各类型之间可以通过逗号分隔。|
|no-rollback- for|抛出 no-rollback-for 指定的异常类型，不回滚事务。|

* @Transactional 注解也可以添加到类级别上。当把@Transactional 注解放在类级别时，表示所有该类的公共方法都配置相同的事务属

```java

@Transactional(propagation= Propagation.SUPPORTS,readOnly=true)
@Service(value ="employeeService")
public class EmployeeService
```

## vhr总结

## mall

![spring security登录后重定向至拦截前访问的url的实现原理流程](https://images2018.cnblogs.com/blog/1234892/201804/1234892-20180412160922019-944930706.png)

## SpringSecurity

### 鉴权流程
```python
# -*- coding: utf-8 -*-
import sys, threading
from PyQt5 import QtWidgets, QtCore
from PyQt5.QtCore import pyqtSignal, QObject, QThread
from QtUi import Ui_MainWindow
import sys
import time


class Work(QObject):
    count = int(0)
    count_signal = pyqtSignal(int)

    def __init__(self):
        super(Work, self).__init__()
        self.run = True

    def work(self):
        self.run = True
        while self.run:
            print(str(self.count))
            self.count += 1
            self.count_signal.emit(self.count)
            time.sleep(1)
            print(threading.currentThread().getName())

    def work_stop(self):
        self.run = False


class MyWindow(QtWidgets.QMainWindow, Ui_MainWindow):
    def __init__(self):
        super(MyWindow, self).__init__()
        self.setupUi(self)
        self.pushButton_Start.clicked.connect(self.workStart)
        self.pushButton_Stop.clicked.connect(self.workStop)

        self.thread = QThread()
        self.thread.deleteLater()
        self.thread1 = QThread()
        self.worker = Work()
        self.worker.count_signal.connect(self.flush)
        print(self.thread)
        self.worker.moveToThread(self.thread)
        self.worker.moveToThread(self.thread1)
        self.thread.started.connect(self.worker.work)
        self.thread.finished.connect(self.finished)

    def flush(self, count):
        self.label.setText(str(count))

    def workStart(self):https://blog.csdn.net/czyt1988/article/details/71194457?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.channel_param&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.channel_param
        print('button start.')
        self.pushButton_Start.setEnabled(False)
        self.thread.start()

    def workStop(self):
        print('button stop.')
        self.worker.work_stop()
        self.thread.quit()

    def finished(self):
        print('finish.')
        self.pushButton_Start.setEnabled(True)


if __name__ == "__main__":
    print(threading.currentThread().getName())
    app = QtWidgets.QApplication(sys.argv)
    myshow = MyWindow()
    print(QThread.currentThreadId())
    myshow.show()
    sys.exit(app.exec_())
```
<https://blog.csdn.net/czyt1988/article/details/71194457>