package com.drools.example.rules.bo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RuleResultBo {
    /**
     * 条件以及属性
     */
    private RuleParamBo ruleParamBo;

    /**
     *  结果码（-1不成功、0成功）
     */
    private Integer ruleCode;


    public RuleResultBo() {
        this.ruleCode = -1;
    }

    public Integer getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(Integer ruleCode) {
        this.ruleCode = ruleCode;
    }

    public RuleParamBo getRuleParamBo() {
        return ruleParamBo;
    }

    public void setRuleParamBo(RuleParamBo ruleParamBo) {
        this.ruleParamBo = ruleParamBo;
    }


    /**
     *构建参数
     * @param ruleParamBo
     */
    public void buildParam(RuleParamBo ruleParamBo) {
        log.info("构建参数");
        if (1 == ruleParamBo.getSex()) {
            // todo
        } else{
            // todo
        }
    }
}
