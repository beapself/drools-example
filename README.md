# drools-example
drools规则引擎入门

1、引入MAVEN依赖，POM如下
~~~~
<dependency>
    <groupId>org.drools</groupId>
    <artifactId>drools-core</artifactId>
    <version>7.45.0.Final</version>
</dependency>
<dependency>
    <groupId>org.drools</groupId>
    <artifactId>drools-compiler</artifactId>
    <version>7.45.0.Final</version>
</dependency>
<dependency>
    <groupId>org.drools</groupId>
    <artifactId>drools-templates</artifactId>
    <version>7.45.0.Final</version>
</dependency>
~~~~
2、初始化知识库
默认启动加载DroolsConfig类中init方法，将drl文件加载到内存中生成DRL规范

3、drl静态文件编写
在resources/drools目录下创建drl文件并编写规则

4、规则参数构造并执行