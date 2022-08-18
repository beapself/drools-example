package com.drools.example.rules;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class DroolsConfig {

    @Autowired
    private IRulesService iRulesService;

    @PostConstruct
    public void init() {
        //规则的初始化
        if(iRulesService.initDroolsRule()){
            log.info("规则初始化完成============");
        }else{
            throw new RuntimeException("Drools规则文件加载失败");
        }

        //公式信息加载
        log.info("加载公式配置信息============");
    }



}
