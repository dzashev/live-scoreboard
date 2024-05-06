package com.scoreboard.match.utils;

import com.scoreboard.match.Match;
import com.scoreboard.match.MatchCollection;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class MatchUtils {
    public static String getMatchKey(String homeTeam, String awayTeam) {
        return homeTeam + "vs. " +awayTeam;
    }

    public static List<Match> getOrderedMatchList(MatchCollection matchCollection)
    {
        return matchCollection.getMatchList().stream().sorted(Comparator.comparingInt((Match m) -> m.getHomeScore() + m.getAwayScore())
                        .reversed()
                        .thenComparing(Match::getStartTime, Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }
}
