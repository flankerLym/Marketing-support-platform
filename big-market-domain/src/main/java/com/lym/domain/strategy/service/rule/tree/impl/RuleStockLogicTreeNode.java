package com.lym.domain.strategy.service.rule.tree.impl;

import com.lym.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import com.lym.domain.strategy.service.rule.tree.ILogicTreeNode;
import com.lym.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author lym
 * @description 库存节点
 * @create 2026-02-27 17:23
 */
@Slf4j
@Component("rule_stock")
public class RuleStockLogicTreeNode implements ILogicTreeNode {
    @Override
    public DefaultTreeFactory.TreeActionEntity logic(String userId, Long strategyId, Integer awardId) {
        return DefaultTreeFactory.TreeActionEntity.builder()
                .ruleLogicCheckType(RuleLogicCheckTypeVO.TAKE_OVER)
                .build();
    }


}
