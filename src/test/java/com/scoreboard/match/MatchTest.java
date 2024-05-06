package com.scoreboard.match;


import com.scoreboard.match.impl.FootballMatch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MatchTest {

    @Test
    void testMatchIsCreatedAsSpecified(){
        FootballMatch footballMatch = new FootballMatch("France","Italy");
        assertNotNull(footballMatch);
        assertEquals(footballMatch.getHomeTeam(),"France");
        assertEquals(footballMatch.getAwayTeam(),"Italy");
        assertEquals(footballMatch.getHomeScore(),0);
        assertEquals(footballMatch.getAwayScore(),0);
    }


    void testUpdateScore() {
        FootballMatch footballMatch = new FootballMatch("France","Italy");
        footballMatch.updateScore(2,3);
        assertEquals(footballMatch.getHomeScore(),2);
        assertEquals(footballMatch.getAwayScore(),3);

    }
}