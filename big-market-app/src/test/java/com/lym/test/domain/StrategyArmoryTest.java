package com.lym.test.domain;

import com.lym.domain.strategy.service.armory.StrategyArmory;
import lombok.extern.slf4j.Slf4j;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Test;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyArmoryTest {

    @Resource
    private StrategyArmory strategyArmory;

    @Test
    public void test() {
        strategyArmory.assembleLotteryStrategy(100002L);
    }

    @Test
    public void test2() {
        log.info("奖品值id:{}", strategyArmory.getRandomAwardId(100002L));
        log.info("奖品值id:{}", strategyArmory.getRandomAwardId(100002L));
        log.info("奖品值id:{}", strategyArmory.getRandomAwardId(100002L));
    }
}
