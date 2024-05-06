package com.scoreboard.service.impl;

import com.scoreboard.match.Match;
import com.scoreboard.match.MatchCollection;
import com.scoreboard.match.impl.FootballMatch;
import com.scoreboard.service.ScoreboardService;

import static com.scoreboard.match.utils.MatchUtils.getOrderedMatchList;
import static com.scoreboard.service.util.MatchValidator.validateMatchCanBeUpdated;
import static com.scoreboard.service.util.MatchValidator.validateMatch;
import static com.scoreboard.service.util.MatchValidator.validateScore;

import java.util.List;

public class ScoreboardServiceImpl implements ScoreboardService {
    private final MatchCollection matches;

    public ScoreboardServiceImpl() {
        this.matches = new MatchCollection();
    }

    @Override
    public void startMatch(String homeTeam, String awayTeam) {
        validateMatch(homeTeam,awayTeam,this.matches);
        matches.addMatch(new FootballMatch(homeTeam, awayTeam));
    }

    @Override
    public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        validateScore(homeScore,awayScore);
        validateMatchCanBeUpdated(homeTeam,awayTeam, this.matches);
        matches.updateMatchScore(homeTeam,awayTeam,homeScore,awayScore);
    }

    @Override
    public void finishMatch(String homeTeam, String awayTeam) {
        if(!this.matches.containsMatch(homeTeam,awayTeam)){
            throw new IllegalArgumentException("Match not found.");
        }
        matches.removeMatch(homeTeam,awayTeam);
    }

    @Override
    public String getMatchSummary() {
        List<Match> matchList = getOrderedMatchList(this.matches);
        String matchSummary = "";
        int i = 1;
        for (Match match : matchList) {
            matchSummary += (i + ". " + match.toString() + "\n");
            i++;
        }
        return matchSummary;
    }
}
