package com.playsafe.roulette.dto;

public class PlayerReport {

    private String playerName;
    private String bet;
    private String outcome;
    private double winnings;
    private int rouletteNum;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getBet() {
        return bet;
    }

    public void setBet(String bet) {
        this.bet = bet;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public double getWinnings() {
        return winnings;
    }

    public void setWinnings(double winnings) {
        this.winnings = winnings;
    }

    public int getRouletteNum() {
        return rouletteNum;
    }

    public void setRouletteNum(int rouletteNum) {
        this.rouletteNum = rouletteNum;
    }

    @Override
    public String toString() {
        return String.format("%-15s  %-10s %-10s %-10.1f \n", playerName, bet, outcome, winnings);

    }
}
