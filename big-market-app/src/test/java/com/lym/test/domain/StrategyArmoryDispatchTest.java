package com.lym.test.domain;

import com.lym.domain.strategy.service.armory.StrategyArmoryDispatch;
import lombok.extern.slf4j.Slf4j;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Test;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyArmoryDispatchTest {

    @Resource
    private StrategyArmoryDispatch strategyArmoryDispatch;

    @Test
    public void test() {
        strategyArmoryDispatch.assembleLotteryStrategy(100001L);
    }

    @Test
    public void test2() {
        log.info("奖品值id:{}", strategyArmoryDispatch.getRandomAwardId(100001L, "5000:102,103,104,105,106,107"));
    }
}
