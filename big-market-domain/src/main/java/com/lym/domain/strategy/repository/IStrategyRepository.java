package com.lym.domain.strategy.repository;

import com.lym.domain.strategy.model.entity.StrategyAwardEntity;
import com.lym.domain.strategy.model.entity.StrategyEntity;
import com.lym.domain.strategy.model.entity.StrategyRuleEntity;
import com.lym.domain.strategy.model.valobj.StrategyAwardRuleModelVO;

import java.util.List;
import java.util.Map;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 策略服务仓储接口
 * @create 2023-12-23 09:33
 */
public interface IStrategyRepository {

    List<StrategyAwardEntity> queryStrategyAwardList(Long strategyId);

    void storeStrategyAwardSearchRateTable(String key, Integer rateRange, Map<Integer, Integer> strategyAwardSearchRateTable);

    Integer getStrategyAwardAssemble(String key, Integer rateKey);

    int getRateRange(Long strategyId);

    int getRateRange(String key);

    StrategyEntity queryStrategyEntityByStrategyId(Long strategyId);

    StrategyRuleEntity queryStrategyRule(Long strategyId, String ruleModel);

    String queryStrategyRuleValue(Long strategyId, Integer awardId, String ruleModel);


    StrategyAwardRuleModelVO queryStrategyAwardRuleValue(Long strategyId,Integer awardId);
}

