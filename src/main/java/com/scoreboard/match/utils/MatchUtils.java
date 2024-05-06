package com.scoreboard.match.utils;

public final class MatchUtils {
    public static String getMatchKey(String homeTeam, String awayTeam) {
        return homeTeam + "vs. " +awayTeam;
    }
}
