package com.lym.domain.strategy.service.rule.factory;

import com.lym.domain.strategy.model.entity.RuleActionEntity;
import com.lym.domain.strategy.service.annotation.LogicStrategy;
import com.lym.domain.strategy.service.rule.ILogicFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 规则工厂
 * @create 2023-12-31 11:23
 */
@Service
public class DefaultLogicFactory {

    public Map<String, ILogicFilter<?>> logicFilterMap = new ConcurrentHashMap<>();

    public DefaultLogicFactory(List<ILogicFilter<?>> logicFilters) {
        logicFilters.forEach(logic -> {
            LogicStrategy strategy = AnnotationUtils.findAnnotation(logic.getClass(), LogicStrategy.class);
            if (null != strategy) {
                logicFilterMap.put(strategy.logicMode().getCode(), logic);
            }
        });
    }

    public <T extends RuleActionEntity.RaffleEntity> Map<String, ILogicFilter<T>> openLogicFilter() {
        return (Map<String, ILogicFilter<T>>) (Map<?, ?>) logicFilterMap;
    }


    @Getter
    @AllArgsConstructor
    public enum LogicModel {

        RULE_WIGHT("rule_weight","【抽奖前规则】根据抽奖权重返回可抽奖范围KEY","before"),
        RULE_BLACKLIST("rule_blacklist","【抽奖前规则】黑名单规则过滤，命中黑名单则直接返回","before"),
        RULE_LOCK("rule_lock", "【抽奖中规则】抽奖n次后解锁奖品","center"),
        RULE_LOCK_AWARD("rule_lock_award", "【抽奖后规则】兜底奖品","after")
                ;

        private final String code;
        private final String info;
        private final String type;

        public static boolean isBefore(String code) {
            return "before".equals(LogicModel.valueOf(code.toUpperCase()).getType());
        }
        public static boolean isCenter(String code) {
            return "center".equals(LogicModel.valueOf(code.toUpperCase()).getType());
        }
        public static boolean isAfter(String code) {
            return "after".equals(LogicModel.valueOf(code.toUpperCase()).getType());
        }
    }

}
