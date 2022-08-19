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

    private String remark;


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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     *构建参数
     * @param ruleParamBo
     */
    public void buildParam(RuleParamBo ruleParamBo) {
        log.info("构建参数");
        remark = "构建参数，年龄为"+ruleParamBo.getAge();
    }
}
