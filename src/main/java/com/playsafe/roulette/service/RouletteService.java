package com.playsafe.roulette.service;

import com.playsafe.roulette.model.Player;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RouletteService {

    List<Player> loadPlayers();
}
