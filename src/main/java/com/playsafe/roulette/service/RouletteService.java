package com.playsafe.roulette.service;

import com.playsafe.roulette.dto.PlayerReport;
import com.playsafe.roulette.model.Player;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RouletteService {

    String WIN = "WIN";
    String LOSE = "LOSE";
    String EVEN_NUMBER = "EVEN";
    String ODD_NUMBER = "ODD";

    List<Player> loadPlayers();
    List<PlayerReport> calculateBet(List<Player> players);
}
