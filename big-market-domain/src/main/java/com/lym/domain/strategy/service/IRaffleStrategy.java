package com.lym.domain.strategy.service;

import com.lym.domain.strategy.model.entity.RaffleAwardEntity;
import com.lym.domain.strategy.model.entity.RaffleFactorEntity;

public interface IRaffleStrategy {

    RaffleAwardEntity performRaffle(RaffleFactorEntity raffleFactorEntity);
}
