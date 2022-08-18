package com.drools.example.rules;

import com.drools.example.rules.bo.RuleResultBo;
import com.drools.example.rules.impl.IRulesServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 规则执行方法
 */
@Slf4j
@Service
public class RuleExecuteAction {
    /**
     * 方法说明：执行动作，通过反射执行到execute包里面的真正动作
     */
    public static void runActions(List<Object> curMatchFacts, RuleResultBo ruleResultBo) {
        //通过包名反射到具体的动作实现类中具体实现
        try {
            IRulesServiceImpl rulesServiceImpl = (IRulesServiceImpl) SpringContextHandle.getApplicationContext().getBean("rulesServiceImpl");
            rulesServiceImpl.execute(ruleResultBo);
        }catch (Exception ex) {
            log.error("规则执行异常：",ex);
        }

    }




}
