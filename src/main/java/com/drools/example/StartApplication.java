package com.drools.example;

import com.alibaba.fastjson.JSON;
import com.drools.example.rules.SpringContextHandle;
import com.drools.example.rules.bo.RuleParamBo;
import com.drools.example.rules.bo.RuleResultBo;
import com.drools.example.rules.impl.IRulesServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@ImportResource("classpath:config/spring-boot.xml")
public class StartApplication {
    public static void main(String[] args) {

    	long starTime = System.currentTimeMillis();
        SpringApplication.run(StartApplication.class,args);
        long endTime=System.currentTimeMillis();
        long Time=endTime-starTime;
        System.out.println("\n启动时间:"+ Time/1000 +"秒");
        System.out.println("...............................................................");
        System.out.println("..................Service starts successfully..................");

        RuleParamBo ruleParamBo = new RuleParamBo();
        ruleParamBo.setAge(11);
        ruleParamBo.setId(1L);
        ruleParamBo.setSex(1);
        IRulesServiceImpl rulesServiceImpl = (IRulesServiceImpl) SpringContextHandle.getApplicationContext().getBean("rulesServiceImpl");
        RuleResultBo ruleResultBo = rulesServiceImpl.match(ruleParamBo);
        System.out.println(JSON.toJSONString(ruleResultBo));
    }
    
}