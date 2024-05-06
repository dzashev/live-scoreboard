package com.scoreboard.match;

import java.util.Collection;

public class MatchCollection {

    public MatchCollection() {
    }

    public void addMatch(Match match) {
    }

    public Match getMatch(String homeTeam, String awayTeam) {
        return null;
    }

    public boolean containsMatch(String homeTeam, String awayTeam) {
        return false;
    }

    public boolean isAnyTeamInAMatch(String homeTeam, String awayTeam) {
        return false;
    }

    public void updateMatchScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
    }

    public Match removeMatch(String homeTeam, String awayTeam) {
        return null;
    }

    public Collection<Match> getMatchList() {
        return null;
    }
}
