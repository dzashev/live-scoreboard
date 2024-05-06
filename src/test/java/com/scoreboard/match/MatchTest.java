package com.scoreboard.match;


import com.scoreboard.match.impl.FootballMatch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MatchTest {

    @Test
    void testMatchIsCreatedAsSpecified() {
        FootballMatch footballMatch = new FootballMatch("France", "Italy");
        assertNotNull(footballMatch);
        assertEquals("France", footballMatch.getHomeTeam());
        assertEquals("Italy", footballMatch.getAwayTeam());
        assertEquals(0, footballMatch.getHomeScore());
        assertEquals(0, footballMatch.getAwayScore());
    }

    @Test
    void testUpdateScore() {
        FootballMatch footballMatch = new FootballMatch("France", "Italy");
        assertEquals(0, footballMatch.getHomeScore());
        assertEquals(0, footballMatch.getAwayScore());
        footballMatch.updateScore(2, 3);
        assertEquals(2, footballMatch.getHomeScore());
        assertEquals(3, footballMatch.getAwayScore());

    }

    @Test
    void testGetStartTime() {
        FootballMatch footballMatch = new FootballMatch("France", "Italy");
        assertNotNull(footballMatch.getStartTime());
    }

    @Test
    void testToString() {
        FootballMatch footballMatch = new FootballMatch("France", "Italy");
        assertEquals("France 0 - Italy 0", footballMatch.toString());
    }
}