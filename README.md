# Live Football World Cup Scoreboard v0.1

## Background

### Data models
The `Match` interface is a simple data representation class, containing the bare minimum of information.
It is extended by the `FootballMatch` implementation which supports the following methods:
`getHomeTeam()`, `getHomeTeam()`, `getHomeTeam()`, `getHomeScore()`, and `updateScore(int homeScore, int awayScore)`.

Matches are stored in a MatchCollection, which I have chosen to have a HashMap as the internal implementation for easy retrieval of matches.
The key for every Match in this collection is simply the `"homeTeam vs. awayTeam"` string, as the assumption is that there cannot be duplicate teams in matches that are occurring at the same time.

### Scoreboard Service
* `startMatch(String homeTeam, String awayTeam)`
  This method takes in two Strings as arguments which represent the two teams playing.
  The assumption is detailed validation can be done by another class (i.e. validating the strings to ensure they belong to a list of FIFA members or similar).

Invariants include:
* homeTeam and awayTeam have to be different from eachother;
* homeTeam or awayTeam cannot already be in existing matches;
* homeTeam or awayTeam cannot be null or empty strings;

* `updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore)`
  This method updates the score for a match currently in progress using a pair of absolute scores.
Invariants include:
* homeScore and awayScore must be non-negative integers.

* `finishMatch(String homeTeam, String awayTeam)`
  This method takes in two Strings as arguments which represent the two teams playing. The method throws an exception if the team is not currently playing.

* `String getMatchSummary()`
  Returns a summary of matches in progress ordered by their total score. Should two matches have the same sum of scores, the start timestamps of the matches are used.
  
