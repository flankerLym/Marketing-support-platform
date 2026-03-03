package com.lym.domain.strategy.service.rule.chain;

import com.lym.domain.strategy.service.rule.chain.factory.DefaultChainFactory;

/**
 * @author lym
 * @description 责任链接口
 * @create 2026-02-25 17:21
 */
public interface ILogicChain extends ILogicChainArmory, Cloneable{

    /**
     * 责任链接口
     *
     * @param userId     用户ID
     * @param strategyId 策略ID
     * @return 奖品ID
     */
    DefaultChainFactory.StrategyAwardVO logic(String userId, Long strategyId);

}

