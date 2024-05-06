# Live Football World Cup Scoreboard v0.1

## Background

### Data models
The `Match` interface is a simple data representation class, containing the bare minimum of information.
It is extended by the `FootballMatch` implementation which supports the following methods:
`getHomeTeam()`, `getHomeTeam()`, `getHomeTeam()`, `getHomeScore()`, and `updateScore(int homeScore, int awayScore)`.

Matches are stored in a MatchCollection, which I have chosen to have a HashMap as the internal implementation for easy retrieval of matches.
The key for every Match in this collection is simply the `"homeTeam vs. awayTeam"` string, as the assumption is that there cannot be duplicate teams in matches that are occurring at the same time.
