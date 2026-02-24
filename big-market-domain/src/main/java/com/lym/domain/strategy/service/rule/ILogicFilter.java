package com.lym.domain.strategy.service.rule;

import com.lym.domain.strategy.model.entity.RuleActionEntity;
import com.lym.domain.strategy.model.entity.RuleMatterEntity;

public interface ILogicFilter<T extends RuleActionEntity.RaffleEntity>{
    RuleActionEntity<T> filter(RuleMatterEntity ruleMatterEntity);
}
