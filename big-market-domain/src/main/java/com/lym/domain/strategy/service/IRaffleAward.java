package com.lym.domain.strategy.service;

import com.lym.domain.strategy.model.entity.StrategyAwardEntity;

import java.util.List;

public interface IRaffleAward {
    List<StrategyAwardEntity> queryRaffleStrategyAwardList(Long strategyId);
}
