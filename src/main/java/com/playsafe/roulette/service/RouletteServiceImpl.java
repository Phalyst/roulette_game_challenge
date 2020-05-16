package com.playsafe.roulette.service;

import com.playsafe.roulette.dto.PlayerReport;
import com.playsafe.roulette.model.Player;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


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

    @Override
    public List<PlayerReport> calculateBet(List<Player> players){
        int rouletteNum;
        Random generator = new Random();
        rouletteNum = generator.nextInt(37);

        List<PlayerReport> reports = new ArrayList<>();
        for (Player player : players){
            PlayerReport report = new PlayerReport();
            report.setBet(player.getBet());
            report.setOutcome(LOSE);
            report.setPlayerName(player.getName());
            report.setRouletteNum(rouletteNum);
            if(String.valueOf(rouletteNum).equals(player.getBet())){
                report.setWinnings(player.getAmount()*36);
                report.setOutcome(WIN);
            }

            if(isEvenNumber(rouletteNum)){
                boolean isEven =  isNumber(player.getBet())? isEvenNumber(Integer.parseInt(player.getBet())):false;
                if(EVEN_NUMBER.equals(player.getBet()) || isEven){
                    report.setWinnings(player.getAmount()*2);
                    report.setOutcome(WIN);
                }
            }else{
                boolean isOdd  =  isNumber(player.getBet())? !isEvenNumber(Integer.parseInt(player.getBet())):false;
                if(ODD_NUMBER.equals(player.getBet()) || isOdd ){
                    report.setWinnings(player.getAmount()*2);
                    report.setOutcome(WIN);
                }
            }

            reports.add(report);
        }
        return reports;

    }

    public boolean isEvenNumber(int num){
        return (num % 2 == 0)? true: false;
    }

    public boolean isNumber(String value){
        return value.matches("-?(0|[1-9]\\d*)")? true : false;
    }

}
