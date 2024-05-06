package com.scoreboard.match;

import java.util.Collection;
import java.util.HashMap;
import static com.scoreboard.match.utils.MatchUtils.getMatchKey;

public class MatchCollection {
    private final HashMap<String, Match> matches;

    public MatchCollection() {
        matches = new HashMap<>();
    }

    public void addMatch(Match match) {
        matches.put(getMatchKey(match.getHomeTeam(), match.getAwayTeam()), match);
    }

    public Match getMatch(String homeTeam, String awayTeam) {
        return matches.get(getMatchKey(homeTeam, awayTeam));
    }

    public boolean containsMatch(String homeTeam, String awayTeam) {
        return matches.containsKey(getMatchKey(homeTeam, awayTeam));
    }

    public boolean isAnyTeamInAMatch(String homeTeam, String awayTeam) {
        return matches.keySet().stream().anyMatch(key -> key.contains(homeTeam) || key.contains(awayTeam));
    }

    public void updateMatchScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        String matchKey = getMatchKey(homeTeam, awayTeam);
        Match match = matches.get(matchKey);
        match.updateScore(homeScore, awayScore);
        matches.replace(getMatchKey(homeTeam,awayTeam), match);
    }

    public Match removeMatch(String homeTeam, String awayTeam) {
        return matches.remove(getMatchKey(homeTeam, awayTeam));
    }

    public Collection<Match> getMatchList() {
        return matches.values();
    }
}
