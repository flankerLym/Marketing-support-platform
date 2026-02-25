package com.lym.domain.strategy.service.rule.chain;

/**
 * @author lym
 * @description 责任链接口
 * @create 2026-02-25 17:21
 */
public interface ILogicChain extends ILogicChainArmory{

    /**
     * 责任链接口
     *
     * @param userId     用户ID
     * @param strategyId 策略ID
     * @return 奖品ID
     */
    Integer logic(String userId, Long strategyId);

}

