package com.drools.example.rules;

import org.drools.core.common.InternalFactHandle;
import org.drools.core.spi.KnowledgeHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


public class DroolsAction {

    protected static final Logger LOGGER = LoggerFactory.getLogger(DroolsAction.class);
    /**
     * 获取当前匹配事实对象集合
     */
    public static List<Object> listCurrentMatchFacts(KnowledgeHelper droolHelper) {
        InternalFactHandle[] internalFactHandles = droolHelper.getTuple().toFactHandles();
        if(internalFactHandles == null || internalFactHandles.length == 0) {
            LOGGER.error("Drools internalFactHandles is null");
            return null;
        }
        List<Object> matchFacts = new ArrayList<>();
        for(InternalFactHandle internalFactHandle : internalFactHandles) {
            Object fact = internalFactHandle.getObject();
            matchFacts.add(fact);
        }
        return matchFacts;
    }
}
