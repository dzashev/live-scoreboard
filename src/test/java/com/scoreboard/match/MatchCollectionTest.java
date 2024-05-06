package com.scoreboard.match;

import com.scoreboard.match.impl.FootballMatch;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchCollectionTest {
    private MatchCollection matchCollection;

    @BeforeEach
    void setUp() {
        matchCollection = new MatchCollection();
    }

    @Test
    void testAddMatch() {
        matchCollection.addMatch(new FootballMatch("France", "Germany"));
        Assertions.assertEquals(1, matchCollection.getMatchList().size());
    }

    @Test
    void testContainsMatch() {
        matchCollection.addMatch(new FootballMatch("France", "Germany"));
        Assertions.assertTrue(matchCollection.containsMatch("France", "Germany"));
        Assertions.assertFalse(matchCollection.containsMatch("Brazil", "Argentina"));
    }

    @Test
    void testIsAnyTeamInAMatch() {
        matchCollection.addMatch(new FootballMatch("France", "Germany"));
        Assertions.assertTrue(matchCollection.containsMatch("France", "Germany"));
        Assertions.assertFalse(matchCollection.containsMatch("Brazil", "Argentina"));
        ;
    }

    @Test
    void testGetMatch() {
        matchCollection.addMatch(new FootballMatch("France", "Germany"));
        Assertions.assertEquals(1, matchCollection.getMatchList().size());
    }

    @Test
    void testUpdateMatch() {
        matchCollection.addMatch(new FootballMatch("France", "Germany"));
        matchCollection.updateMatchScore("France", "Germany", 2, 3);
        Match match = matchCollection.getMatch("France", "Germany");
        assertEquals(2, match.getHomeScore());
        assertEquals(3, match.getAwayScore());
    }

    @Test
    void testRemoveMatch() {
        matchCollection.addMatch(new FootballMatch("France", "Germany"));
        Match match = matchCollection.removeMatch("France", "Germany");
        assertEquals("France", match.getHomeTeam());
        assertEquals("Germany", match.getAwayTeam());
    }

    @Test
    void testGetMatchList() {
        matchCollection.addMatch(new FootballMatch("France", "Germany"));
        matchCollection.addMatch(new FootballMatch("Brazil", "Argentina"));
        matchCollection.addMatch(new FootballMatch("Italy", "Montenegro"));
        assertEquals(3, matchCollection.getMatchList().size());
    }
}