package com.scoreboard.service.util;

import com.scoreboard.match.MatchCollection;

public final class MatchValidator {
    public static final String TEAM_NAME_CANNOT_BE_NULL = "Team name cannot be null.";
    public static final String TEAM_NAME_MUST_BE_A_VALID_STRING = "Team name must be a valid string.";
    public static final String A_TEAM_CANNOT_PLAY_AGAINST_ITSELF = "A team cannot play against itself.";
    public static final String ONE_OF_THE_SPECIFIED_TEAMS_IS_ALREADY_IN_A_MATCH = "One of the specified teams is already in a match.";
    public static final String THE_MATCH_IS_CURRENTLY_NOT_IN_PROGRESS_SO_IT_CANNOT_BE_UPDATED = "The match is currently not in progress so it cannot be updated.";

    public static void validateMatch(String homeTeam, String awayTeam, MatchCollection matches) throws IllegalArgumentException {
        if (isTeamNameNull(homeTeam) || isTeamNameNull(awayTeam)) {
            throw new IllegalArgumentException(TEAM_NAME_CANNOT_BE_NULL);
        }
        if(!isTeamNameValid(homeTeam) || !isTeamNameValid(awayTeam)) {
            throw new IllegalArgumentException(TEAM_NAME_MUST_BE_A_VALID_STRING);
        }
        if(!isTeamCombinationValid(homeTeam, awayTeam)) {
            throw new IllegalArgumentException(A_TEAM_CANNOT_PLAY_AGAINST_ITSELF);
        }
        if(isAnyTeamAlreadyInAMatch(homeTeam, awayTeam, matches)) {
            throw new IllegalArgumentException(ONE_OF_THE_SPECIFIED_TEAMS_IS_ALREADY_IN_A_MATCH);
        }
    }

    public static void validateMatchCanBeUpdated(String homeTeam, String awayTeam, MatchCollection matches) throws IllegalArgumentException {
        if(!isMatchInProgress(homeTeam,awayTeam, matches)){
            throw new IllegalArgumentException(THE_MATCH_IS_CURRENTLY_NOT_IN_PROGRESS_SO_IT_CANNOT_BE_UPDATED);
        }
    }

    public static void validateScore(int homeTeamScore, int awayTeamScore) throws IllegalArgumentException {
        if(homeTeamScore < 0 || awayTeamScore < 0) {
            throw new IllegalArgumentException("Scores cannot be negative.");
        }
    }

    private static boolean isTeamNameNull(String teamName)  {
        return teamName == null;
    }
    private static boolean isTeamNameValid(String teamName)  {
        return teamName.matches("^[a-zA-Z0-9_-]+$");
    }

    private static boolean isTeamCombinationValid(String homeTeam, String awayTeam)  {
        return !(homeTeam.equals(awayTeam));
    }

    private static boolean isAnyTeamAlreadyInAMatch(String homeTeam, String awayTeam, MatchCollection matchCollection)  {
        return matchCollection.isAnyTeamInAMatch(homeTeam, awayTeam);
    }

    private static boolean isMatchInProgress(String homeTeam, String awayTeam, MatchCollection matchCollection)  {
        return matchCollection.containsMatch(homeTeam, awayTeam);
    }
}
