package com.drools.example.rules.bo;

import lombok.Data;

/**
 * 规则信息BO
 */
@Data
public class RuleParamBo {

    private Long id;
    private int age;
    private int sex;

    public RuleParamBo() {
    }

    public RuleParamBo(PersonBo personBo) {
        this.id = personBo.getId();
        this.age = personBo.getAge();
        this.sex = personBo.getSex();

    }


}
