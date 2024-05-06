package com.scoreboard.match;

import java.time.LocalTime;

public interface Match {
    String getHomeTeam();
    String getAwayTeam();
    int getHomeScore();
    int getAwayScore();
    void updateScore(int homeScore, int awayScore);
    LocalTime getStartTime();
    String toString();
}
