package com.playsafe.roulette;

import com.playsafe.roulette.model.Player;
import com.playsafe.roulette.service.RouletteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {

    @Autowired
    private RouletteServiceImpl rouletteService;

    @Override
    public void run(String... args) throws Exception {

        List<Player> players = rouletteService.loadPlayers();
        rouletteService.displayReport(rouletteService.calculateBet(players));

        try {
            while(true){
                Thread.sleep(30000);
                for(int i = 0 ;i < 25;i++)
                    System.out.println("\b");
                rouletteService.displayReport(rouletteService.calculateBet(players));
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
