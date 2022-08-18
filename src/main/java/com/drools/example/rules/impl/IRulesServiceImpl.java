package com.drools.example.rules.impl;

import com.alibaba.fastjson.JSON;
import com.drools.example.rules.IRulesService;
import com.drools.example.rules.bo.RuleParamBo;
import com.drools.example.rules.bo.RuleResultBo;
import lombok.extern.slf4j.Slf4j;
import org.drools.core.impl.InternalKnowledgeBase;
import org.drools.core.impl.KnowledgeBaseFactory;
import org.kie.api.definition.KiePackage;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Slf4j
@Service(value = "rulesServiceImpl")
public class IRulesServiceImpl implements IRulesService {

    /**
     * Drools 知识库
     */
    private static final InternalKnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();

    @Override
    public Boolean initDroolsRule() {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("drools/rule.drl"), ResourceType.DRL);
        //判断编译规则过程中是否有错误，有的话进行错误打印
        if (kbuilder.hasErrors()) {
            try {
                log.error("Drools 加载规则文件错误：{}", JSON.toJSONString(kbuilder.getErrors()));
            } catch (Exception e) {
                log.error("Drools 加载规则文件错误json格式化失败：{}", e);
            }
            return false;
        }
        Collection<KiePackage> kiePackages = kbuilder.getKnowledgePackages();
        knowledgeBase.addPackages(kiePackages);
        log.info("获取drools知识库信息：{}", JSON.toJSONString(getKnowledgePackageNames(kiePackages)));
        return true;
    }

    private List<String> getKnowledgePackageNames(final Collection<KiePackage> kiePackages) {
        try {
            if (!CollectionUtils.isEmpty(kiePackages)) {
                List<String> names = new ArrayList<>();
                for (KiePackage kiePackage : kiePackages) {
                    if (kiePackage != null) {
                        names.add(kiePackage.getName());
                    } else {
                        log.error("knowledge package Name is null " + kiePackages);
                    }
                }
                return names;
            }
        } catch (Exception e) {
            log.error("knowledge package Name exception: " + kiePackages);
        }
        return null;
    }

    /**
     * 匹配规则
     */
    @Override
    public RuleResultBo match(RuleParamBo ruleParamBo) {
        RuleResultBo ruleResultBo = new RuleResultBo();
        ruleResultBo.setRuleParamBo(ruleParamBo);
        KieSession kieSession = null;
        try {
            kieSession = knowledgeBase.newKieSession();
            if (null == kieSession) {
                log.error("Drools kieSession is null");
                return ruleResultBo;
            }

            //设置其全局变量
            kieSession.setGlobal("ruleResultBo", ruleResultBo);
            //插入变量
            kieSession.insert(ruleParamBo);
            //只匹配一个规则，匹配到不再进行其他规则匹配
            //底层drools自己处理
            kieSession.fireAllRules(1);
            log.info("匹配规则完成");
        } catch (Exception e) {
            log.error("匹配规则异常，param:{}，ex：{}", JSON.toJSONString(ruleParamBo), e);
        } finally {
            if (null != kieSession) {
                kieSession.dispose();
            }
        }
        return ruleResultBo;
    }

    @Override
    public void execute(RuleResultBo ruleResultBo) {
        /**
         * 业务处理
         */
        ruleResultBo.setRuleCode(1);
        log.info("匹配规则并处理完成");
    }


}
