package com.scoreboard.service;

import com.scoreboard.service.impl.ScoreboardServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ScoreboardServiceTest {
    private ScoreboardService scoreboardService;
    @BeforeEach
    void setUp() {
        scoreboardService = new ScoreboardServiceImpl();
    }

    @Test
    void testStartMatchSuccessfuly() {
        assertDoesNotThrow(() -> scoreboardService.startMatch("Brazil", "Germany"));
        assertEquals(scoreboardService.getMatchSummary(),
                "1. Brazil 0 - Germany 0\n"
        );
    }

    @Test
    void testStartMatchThrowsExceptionIfTeamsAreTheSame() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> scoreboardService.startMatch("Brazil", "Brazil"));
        assertEquals(exception.getMessage(), "A team cannot play against itself.");
    }

    @Test
    void testStartMatchThrowsExceptionIfOneTeamIsAlreadyPlaying() {
        scoreboardService.startMatch("France", "Austria");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> scoreboardService.startMatch("Brazil", "Austria"));
        assertEquals(exception.getMessage(), "One of the specified teams is already in a match.");
    }

    @Test
    void testStartMatchThrowsExceptionIfTeamNameIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> scoreboardService.startMatch(null, ""));
        assertEquals(exception.getMessage(), "Team name cannot be null.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "\t", "\n", " "})
    void testStartMatchThrowsExceptionIfEmptyTeamName(String teamName) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> scoreboardService.startMatch(teamName, teamName));
        assertEquals(exception.getMessage(), "Team name must be a valid string.");
    }

    @Test
    void testUpdateMatchThatIsNotInProgress() {
        scoreboardService.startMatch("Brazil", "Germany");
        Exception exception = assertThrows(IllegalArgumentException.class, ()-> scoreboardService.updateScore("Spain", "France", 0,3));
        assertEquals(exception.getMessage(), "The match is currently not in progress so it cannot be updated.");
    }

    @Test
    void testUpdateMatchWithNegativeScore () {
        scoreboardService.startMatch("Brazil", "Germany");
        Exception exception = assertThrows(IllegalArgumentException.class, ()-> scoreboardService.updateScore("Brazil", "Germany", -1,3));
        assertEquals(exception.getMessage(), "Scores cannot be negative.");
    }

    @Test
    void testFinishMatchSuccessfully() {
        scoreboardService.startMatch("Brazil", "Germany");
        assertDoesNotThrow(() -> scoreboardService.finishMatch("Brazil", "Germany"));
        assertTrue(scoreboardService.getSummary().isEmpty(), "Match should be removed from the list.");
    }

    @Test
    void testFinishNonExistentMatch() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            scoreboardService.finishMatch("Brazil", "Germany");
        });
        assertEquals("Match not found.", exception.getMessage());
    }

    @Test
    void testFinishMatchWithNullArguments() {
        assertThrows(IllegalArgumentException.class, () -> scoreboardService.finishMatch(null, "Germany"),
                "Should throw an exception due to null home team");
        assertThrows(IllegalArgumentException.class, () -> scoreboardService.finishMatch("Brazil", null),
                "Should throw an exception due to null away team");
    }

    @Test
    void testFinishMatchWithEmptyStringArguments() {
        assertThrows(IllegalArgumentException.class, () -> scoreboardService.finishMatch("", "Germany"),
                "Should throw an exception due to empty home team string");
        assertThrows(IllegalArgumentException.class, () -> scoreboardService.finishMatch("Brazil", ""),
                "Should throw an exception due to empty away team string");
    }

    @Test
    void testGetMatchSummary() {
        scoreboardService.startMatch("Mexico", "Canada");
        scoreboardService.updateScore("Mexico", "Canada", 0, 5);
        scoreboardService.startMatch("Spain", "Brazil");
        scoreboardService.updateScore("Spain", "Brazil", 10,2);
        scoreboardService.startMatch("Germany", "France");
        scoreboardService.updateScore("Germany", "France",2,2);
        scoreboardService.startMatch("Uruguay", "Italy");
        scoreboardService.updateScore("Uruguay", "Italy",6,6);
        scoreboardService.startMatch("Argentina", "Australia");
        scoreboardService.updateScore("Argentina", "Australia",3,1);

        assertEquals(scoreboardService.getMatchSummary(),
                "1. Uruguay 6 - Italy 6\n" +
                        "2. Spain 10 - Brazil 2\n" +
                        "3. Mexico 0 - Canada 5\n" +
                        "4. Argentina 3 - Australia 1\n" +
                        "5. Germany 2 - France 2\n"
        );
    }
}