package com.lym.domain.strategy.service;

import com.lym.domain.strategy.model.entity.StrategyAwardEntity;
import com.lym.domain.strategy.model.valobj.StrategyAwardStockKeyVO;

import java.util.List;

public interface IRaffleAward {
    List<StrategyAwardEntity> queryRaffleStrategyAwardList(Long strategyId);

    List<StrategyAwardEntity> queryRaffleStrategyAwardListByActivityId(Long activityId);

    List<StrategyAwardStockKeyVO> queryOpenActivityStrategyAwardList();
}
