package com.scoreboard.match.impl;

import com.scoreboard.match.Match;

public class FootballMatch implements Match {

    private final String homeTeam;
    private final String awayTeam;
    private int homeScore;
    private int awayScore;

    public FootballMatch(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = 0;
        this.awayScore = 0;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int getHomeScore() {
        return this.homeScore;
    }

    public int getAwayScore() {
        return this.awayScore;
    }

    public void updateScore(int homeScore, int awayScore) {
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }
}
