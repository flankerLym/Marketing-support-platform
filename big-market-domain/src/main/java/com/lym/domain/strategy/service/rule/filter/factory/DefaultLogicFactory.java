package com.lym.domain.strategy.service.rule.filter.factory;

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
        RULE_LOCK_AWARD("rule_lock_award", "【抽奖后规则】兜底奖品","after"),
        TREE_LUCK_AWARD("tree_luck_award", "【抽奖后规则】幸运","after")
                ;

        private final String code;
        private final String info;
        private final String type;

        /**
         * 新增：根据code属性查找对应的枚举实例（核心修复）
         * @param code 规则编码（如 "tree_luck_award"）
         * @return 匹配的枚举实例，无匹配则返回null
         */
        private static LogicModel getEnumByCode(String code) {
            if (code == null) {
                return null;
            }
            // 遍历所有枚举常量，匹配code属性值
            for (LogicModel model : LogicModel.values()) {
                if (code.equals(model.getCode())) {
                    return model;
                }
            }
            return null;
        }

        // 修复isBefore方法：改用getEnumByCode匹配code属性，而非枚举名称
        public static boolean isBefore(String code) {
            LogicModel model = getEnumByCode(code);
            return model != null && "before".equals(model.getType());
        }

        // 修复isCenter方法
        public static boolean isCenter(String code) {
            LogicModel model = getEnumByCode(code);
            return model != null && "center".equals(model.getType());
        }

        // 修复isAfter方法
        public static boolean isAfter(String code) {
            LogicModel model = getEnumByCode(code);
            return model != null && "after".equals(model.getType());
        }
    }

}
