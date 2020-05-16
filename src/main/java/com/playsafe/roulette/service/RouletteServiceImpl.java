package com.playsafe.roulette.service;

import com.playsafe.roulette.model.Player;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


@Service
public class RouletteServiceImpl implements RouletteService{
    @Override
    public List<Player> loadPlayers() {

        List<Player> players = new ArrayList<>();
        String line;
        try {
            InputStream resource = new ClassPathResource("/players.txt").getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource));
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(" ");
                Player player = new Player();
                player.setName(values[0]);
                player.setBet(values[1]);
                player.setAmount(Double.parseDouble(values[2]));
                players.add(player);
                System.out.println(player.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return players;
    }
}
