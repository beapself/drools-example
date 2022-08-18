package com.drools.example.rules;

import com.drools.example.rules.bo.RuleParamBo;
import com.drools.example.rules.bo.RuleResultBo;

/**
 * 公式计算
 */
public interface IRulesService {

    public Boolean initDroolsRule();
    /**
     * 匹配规则
     */
    RuleResultBo match(RuleParamBo ruleParamBo);

    /**
     *  执行方法
     */
    void execute(RuleResultBo ruleResultBo);

}
